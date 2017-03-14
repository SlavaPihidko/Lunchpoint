package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 09.02.2017.
 */
public class LoginTests extends TestBase {

  @Test (enabled = false)
  public void buttonLoginPresentTest(){
    // наличия елемента кнопки Входа
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in")), true);
  }

  @Test(enabled = false)
  public void formLoginPresentTest(){
    app.getMainPgHelper().click(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"));
    // наличие формы входа
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.popup-modal-inner.popup-modal-login")),true);
    // наличие кнопки входа через фейсбук
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.log-block a.login-link.soc.fb")),true);
    // текст на кнопки входа через фейсбука
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.log-block a.login-link.soc.fb > span")),"ВОЙТИ ЧЕРЕЗ FACEBOOK");
    // наличие кнопки входа через гугл +
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.log-block a.login-link.soc.google")),true);
    // текст на кнопки входа через гугл +
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.log-block a.login-link.soc.google > span")),"ВОЙТИ ЧЕРЕЗ GOOGLE+");
    // наличие кнопки входа через twitter
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.log-block a.login-link.soc.tw")),true);
    // текст на кнопки входа через twitter
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.log-block a.login-link.soc.tw > span")),"ВОЙТИ ЧЕРЕЗ TWITTER");
    // текст разделителя
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.log-block div.divider")),"ИЛИ");
    // наличие поля емейла
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.log-block div.input-wrap label[for='email']")),true);
    // наличие текста емейла
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.log-block div.input-wrap label[for='email'] > span")),"Email");
    // наличие поля пасворда
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.log-block div.input-wrap label[for='pass']")),true);
    // наличие текста пасворда
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.log-block div.input-wrap label[for='pass'] > span")),"Пароль");
    // наличие кнопки Логина
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.popup-modal-inner.popup-modal-login a.login-link.email.login-form")),true);
    // текст кнопки Логина
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.popup-modal-inner.popup-modal-login a.login-link.email.login-form > span")),"ЛОГИН");
    // наличие блока футера
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.popup-modal-inner.popup-modal-login div.popup-footer div.line.log")),true);
    // текст футера блока входа
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.popup-modal-inner.popup-modal-login div.popup-footer div.line.log > p")),"Вы еще не с нами? Присоединяйтесь!");
  }

  @Test(enabled = false)
  public void loginManagerTestPosTroughEmailTest (){
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    // наличия елемента профайла после входа
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link")), true);
    // проверка правильности ссылки для профайла Менеджера
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link"),"href"),"http://lptest.bigdig.com.ua/manager/restaurants");
    // текст на ссылке профайла
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link")), "MANAGER");
    // наличие иконки человечка возле профайла
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link > i.fa.fa-user")),true);

  }

  @Test(enabled = false)
  public  void loginClientTestPosThroughEmailTest(){
    app.getSessionHelper().login(usernameGuest, passwordGuest);
    // проверка правильности ссылки для профайла Юзера
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link"),"href"),"http://lptest.bigdig.com.ua/user/profile");
  }

}
