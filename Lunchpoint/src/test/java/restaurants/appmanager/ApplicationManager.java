package restaurants.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

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
    if(browser == BrowserType.FIREFOX) {
      wd = new FirefoxDriver();
    } else if(browser == BrowserType.CHROME) {
      wd = new ChromeDriver();
    } else if(browser == BrowserType.IE) {
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://lptest.bigdig.com.ua/");
    wd.manage().window().setSize(new Dimension(1366,730)); // устанавливает ширину открывающегося окна
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

  public AdminHelper getAdminHelper() {
    return adminHelper;
  }

  public MainPageHelper getMainPageHelper() {
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
}
