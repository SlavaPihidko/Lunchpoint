package restaurants.appmanager;

import org.openqa.selenium.*;
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

  public byte[] takeScreenshot(){
    return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
  }


}
