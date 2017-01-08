package restaurants;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Slava on 08.01.2017.
 */
public class TestBase {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://lptest.bigdig.com.ua/");
    login("manager@lunch.ua", "2CDTx8Wz");
    gotoAdminPanel();
    Thread.sleep(3000);
  }

  private void gotoAdminPanel() {
    wd.findElement(By.xpath("//a[contains(text(),'manager')]")).click();
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

  protected void confirmChangesOfRestMainPage() {
    wd.findElement(By.id("save_ok")).click();
  }

  protected void saveRestMainPage() throws InterruptedException {
    wd.findElement(By.id("btn_form_general")).click();
    Thread.sleep(3000);
  }

  protected void fillRestName(RestDataOfMainPage restDataOfMainPage) {
    wd.findElement(By.id("edit_restName")).click();
    wd.findElement(By.id("edit_restName")).clear();
    wd.findElement(By.id("edit_restName")).sendKeys(restDataOfMainPage.getNameOfRest());
  }

  protected void gotoEditRestInAdminPanel() throws InterruptedException {
    wd.findElement(By.cssSelector("a[href='/manager/restaurants/update?id=2219']>span.glyphicon.glyphicon-pencil")).click();
    Thread.sleep(3000);
  }

  protected void searchRestInAdminPanel() throws InterruptedException {
    wd.findElement(By.name("RestaurantsLangSearch[name]")).click();
    wd.findElement(By.name("RestaurantsLangSearch[name]")).clear();
    wd.findElement(By.name("RestaurantsLangSearch[name]")).sendKeys("slava");
    // wd.get("http://lptest.bigdig.com.ua/manager/restaurants?RestaurantsLangSearch%5Bname%5D=test&RestaurantsLangSearch%5Baddress%5D=");
    wd.findElement(By.name("RestaurantsLangSearch[name]")).click();
    wd.findElement(By.name("RestaurantsLangSearch[address]")).click();
    //wd.findElement(By.name("RestaurantsLangSearch[address]")).clear();
    Thread.sleep(3000);
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
}
