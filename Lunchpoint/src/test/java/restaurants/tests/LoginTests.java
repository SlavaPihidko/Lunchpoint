package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 09.02.2017.
 */
public class LoginTests extends TestBase {

  @Test
  public void buttonLoginPresentTest(){
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in")), true);
  }

  @Test(enabled = false)
  public void loginManagerTestPosTroughEmail (){
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link")), true);
    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link"),"href"),"http://lptest.bigdig.com.ua/manager/restaurants");
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link")), "MANAGER");
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link > i.fa.fa-user")),true);

  }

  @Test(enabled = false)
  public  void loginClientTestPosThroughEmail(){
    app.getSessionHelper().login(usernameGuest, passwordGuest);
    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link"),"href"),"http://lptest.bigdig.com.ua/user/profile");

  }
}
