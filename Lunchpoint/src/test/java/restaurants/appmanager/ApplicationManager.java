package restaurants.appmanager;

import org.openqa.selenium.NoAlertPresentException;
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

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://lptest.bigdig.com.ua/");
    adminHelper = new AdminHelper(wd);
    mainPageHelper = new MainPageHelper(wd);
    menuPageHelper = new MenuPageHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("manager@lunch.ua", "2CDTx8Wz");
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
}
