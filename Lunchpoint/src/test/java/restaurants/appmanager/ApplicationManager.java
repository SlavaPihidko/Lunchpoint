package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Slava on 08.01.2017.
 */
public class ApplicationManager {
  protected WebDriver wd;

  private SessionHelper sessionHelper;
  private AdminHelper adminHelper;
  private MainPageHelper mainPageHelper;
  private MenuPageHelper menuPageHelper;
  private SiteHelper siteHelper;
  private SiteRestPageHelper siteRestPageHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if(browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if(browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if(browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    wd.get("http://lptest.bigdig.com.ua/");
    wd.manage().window().setSize(new Dimension(1360,720)); // устанавливает ширину открывающегося окна
    adminHelper = new AdminHelper(wd);
    mainPageHelper = new MainPageHelper(wd);
    menuPageHelper = new MenuPageHelper(wd);
    sessionHelper = new SessionHelper(wd);
    siteHelper = new SiteHelper(wd);
    siteRestPageHelper = new SiteRestPageHelper(wd);
    //sessionHelper.login("manager@lunch.ua", "2CDTx8Wz");
  }

  public void stop() {
    wd.quit();
  }

  public String getWindowHandle(){
    return wd.getWindowHandle();
  }

  public Set<String> getWindowHandles(){
    return wd.getWindowHandles();
  }

  public AdminHelper getAdminHelper() {
    return adminHelper;
  }

  public MainPageHelper getMainPgHelper() {
    return mainPageHelper;
  }

  public MenuPageHelper getMenuPageHelper() {
    return menuPageHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public SiteHelper getSiteHelper() {
    return siteHelper;
  }

  public SiteRestPageHelper getSiteRestPageHelper() {
    return siteRestPageHelper;
  }

  public void workWithNewWindow() throws InterruptedException {

    String originalWindow = wd.getWindowHandle();
    final Set<String> oldWindowsSet = wd.getWindowHandles();

    wd.findElement(By.cssSelector("div.log-block a.login-link.soc.fb")).click();
    String newWindow = (new WebDriverWait(wd, 10))
            .until(new ExpectedCondition<String>() {
                     public String apply(WebDriver driver) {
                       Set<String> newWindowsSet = driver.getWindowHandles();
                       newWindowsSet.removeAll(oldWindowsSet);
                       return newWindowsSet.size() > 0 ?
                               newWindowsSet.iterator().next() : null;
                     }
                   }
            );

    wd.switchTo().window(newWindow);
    System.out.println("New window title: " + wd.getTitle());
    wd.findElement(By.id("email")).click();
    wd.findElement(By.id("email")).clear();
    wd.findElement(By.id("email")).sendKeys("mltest@ukr.net");
    wd.findElement(By.id("pass")).click();
    wd.findElement(By.id("pass")).clear();
    wd.findElement(By.id("pass")).sendKeys("bigdig");
    wd.findElement(By.id("u_0_2")).click();

    wd.switchTo().window(originalWindow);
    System.out.println("Old window title: " + wd.getTitle());

  }
}
