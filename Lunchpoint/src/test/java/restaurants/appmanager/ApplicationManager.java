package restaurants.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Slava on 08.01.2017.
 */
public class ApplicationManager {
  protected FirefoxDriver wd;

  private SessionHelper sessionHelper;
  private AdminHelper adminHelper;
  private MainPageHelper mainPageHelper;
  private MenuPageHelper menuPageHelper;
  private SiteHelper siteHelper;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://lptest.bigdig.com.ua/");
    wd.manage().window().setSize(new Dimension(1366,730)); // устанавливает ширину открывающегося окна
    adminHelper = new AdminHelper(wd);
    mainPageHelper = new MainPageHelper(wd);
    menuPageHelper = new MenuPageHelper(wd);
    sessionHelper = new SessionHelper(wd);
    siteHelper = new SiteHelper(wd);
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
}
