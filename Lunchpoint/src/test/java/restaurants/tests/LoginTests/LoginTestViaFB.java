package restaurants.tests.LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 12.02.2017.
 */
public class LoginTestViaFB extends TestBase {
  public WebDriver wd;

  @Test
  public void testLoginClientThroughFB() throws InterruptedException {
    app.getMainPgHelper().click(By.cssSelector("a.log-in"));
    // работа с окнами
    app.getSiteHelper().workWithNewWindowForFB();
    Thread.sleep(2000);
    // проверка имени пользователя после логина
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link")), "JOHN");
  }

}

