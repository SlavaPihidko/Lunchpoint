package restaurants.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 12.02.2017.
 */
public class LoginTestFB extends TestBase {
  public WebDriver wd;

  @Test
  public void loginClientThroughFBTest() throws InterruptedException {
    app.getMainPgHelper().click(By.cssSelector("a.log-in"));
    // работа с окнами
    app.workWithNewWindow();
    Thread.sleep(2000);
    // проверка имени пользователя после логина
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link")), "JOHN");
  }
}

