package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Slava on 08.01.2017.
 */
public class ApplicationManager {
  private FirefoxDriver wd;

  private MainPageHelper mainPageHelper;
  private AdminHelper adminHelper;

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
    login("manager@lunch.ua", "2CDTx8Wz");
  }

  private void login(String username, String password) {
    wd.findElement(By.cssSelector("a.log-in")).click();
    wd.findElement(By.id("email")).click();
    wd.findElement(By.id("email")).clear();
    wd.findElement(By.id("email")).sendKeys(username);
    wd.findElement(By.id("pass")).click();
    wd.findElement(By.id("pass")).clear();
    wd.findElement(By.id("pass")).sendKeys(password);
    wd.findElement(By.xpath("//div[@id='logIn']/div/a/span")).click();
  }

  public void stop() {
    wd.quit();
  }

  public void confirmChangesOfRestMenuPage() {
    wd.findElement(By.id("save_ok")).click();
  }

  public void saveRestMenuPage() throws InterruptedException {
    wd.findElement(By.id("menu-img_update")).click();
    Thread.sleep(3000);
  }

  public void createNewMenu() throws InterruptedException {
    wd.findElement(By.cssSelector("div.add-menu-block")).click();
    Thread.sleep(3000);
  }

  public void gotoMenuPage() throws InterruptedException {
    wd.findElement(By.linkText("Меню")).click();
    Thread.sleep(3000);
  }

  public AdminHelper getAdminHelper() {
    return adminHelper;
  }

  public MainPageHelper getMainPageHelper() {
    return mainPageHelper;
  }
}
