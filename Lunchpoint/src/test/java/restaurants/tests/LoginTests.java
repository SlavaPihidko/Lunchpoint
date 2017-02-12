package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 09.02.2017.
 */
public class LoginTests extends TestBase {

  @Test (enabled = false)
  public void buttonLoginPresentTest(){
    // наличия елемента кнопки Входа
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in")), true);
  }

  @Test(enabled = true)
  public void formLoginPresentTest(){
    app.getMainPageHelper().click(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"));
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.popup-modal-inner.popup-modal-login")),true);

    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.log-block a.login-link.soc.fb")),true);

    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.log-block a.login-link.soc.fb > span")),"ВОЙТИ ЧЕРЕЗ FACEBOOK");
  }

  @Test(enabled = false)
  public void loginManagerTestPosTroughEmailTest (){
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    // наличия елемента профайла после входа
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link")), true);
    // проверка правильности ссылки для профайла Менеджера
    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link"),"href"),"http://lptest.bigdig.com.ua/manager/restaurants");
    // текст на ссылке профайла
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link")), "MANAGER");
    // наличие иконки человечка возле профайла
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link > i.fa.fa-user")),true);

  }

  @Test(enabled = false)
  public  void loginClientTestPosThroughEmailTest(){
    app.getSessionHelper().login(usernameGuest, passwordGuest);
    // проверка правильности ссылки для профайла Юзера
    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link"),"href"),"http://lptest.bigdig.com.ua/user/profile");

  }
}
