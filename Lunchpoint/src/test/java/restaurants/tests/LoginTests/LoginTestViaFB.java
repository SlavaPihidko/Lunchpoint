package restaurants.tests.LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 12.02.2017.
 */
@Test(priority = 2, alwaysRun = true)
public class LoginTestViaFB extends TestBase {
  public WebDriver wd;

  @Test
  public void testLoginClientThroughFB() throws InterruptedException {
    System.out.println("=========LoginTestViaFB Test 1======= ");
    app.getMainPgHelper().click(By.cssSelector("a.log-in"));
    // работа с окнами
    app.getSiteHelper().workWithNewWindowForFB();
    Thread.sleep(2000);
    // проверка имени пользователя после логина
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link")), "JOHN");
  }

@Test(dependsOnMethods = "testLoginClientThroughFB")
  public void testLogOutClientFB() throws InterruptedException {
    System.out.println("======LoginTestViaFB Test 2========== ");
    if(app.getMainPgHelper().elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"))) {
      app.getSessionHelper().login(usernameGuest, passwordGuest);
      Thread.sleep(1000);
    }
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

