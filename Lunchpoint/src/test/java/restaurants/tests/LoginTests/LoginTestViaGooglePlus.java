package restaurants.tests.LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 26.04.2017.
 */
@Test(priority = 3)
public class LoginTestViaGooglePlus extends TestBase {

  public WebDriver wd;

@Test
  public void testLoginClientThroughGoogle() throws InterruptedException {
    app.getMainPgHelper().click(By.cssSelector("a.log-in"));
    // работа с окнами
    app.getSiteHelper().workWithNewWindowForGoogle();
    Thread.sleep(2000);
    System.out.println("=======LoginTestViaGooglePlus Test 1=========");
    // проверка имени пользователя после логина
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link")), "CD");
  }

@Test(dependsOnMethods = "testLoginClientThroughGoogle")
  public void testLogOutClientGoogle() throws InterruptedException {
    if(app.getMainPgHelper().elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"))) {
      app.getSessionHelper().login(usernameGuest, passwordGuest);
      Thread.sleep(1000);
    }
    System.out.println("=======LoginTestViaGooglePlus Test 2=========");
    app.getSiteHelper().click(By.cssSelector("a.user-profile-link"));
    Thread.sleep(500);
    app.getAdminHelper().click(By.cssSelector("li.logout-user > a"));
    app.getAdminHelper().getAddressMainUrl();
    Thread.sleep(1000);
    // наличия елемента кнопки Входа
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in")), true);
  }

}
