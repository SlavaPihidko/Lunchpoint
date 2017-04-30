package restaurants.tests.LoginTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;

import java.awt.*;

import static java.awt.SystemColor.text;
import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 09.02.2017.
 */
@Test(priority = 1)
public class LoginTestsViaForm extends TestBase {

  @Test
  public void buttonLoginPresentTest(){
    System.out.println("======LoginTestsViaForm Test1=======");
    // наличия елемента кнопки Входа
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in")), true);
  }

  @Test(dependsOnMethods ="buttonLoginPresentTest" )
  public void formLoginPresentTest() throws InterruptedException {
    System.out.println("======LoginTestsViaForm Test2=========");
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
  app.getAdminHelper().getAddressMainUrl();
    Thread.sleep(500);
  }

  @Test(dependsOnMethods = "formLoginPresentTest")
  public void loginManagerTestPosTroughEmailTest (){
    System.out.println("==========LoginTestsViaForm Test3==========");
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

  @Test(dependsOnMethods = "loginManagerTestPosTroughEmailTest")
  public void testLogOutManager() throws InterruptedException {
    System.out.println("========LoginTestsViaForm Test4==========");
    if(app.getMainPgHelper().elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"))) {
      app.getSessionHelper().login(usernameAdmin, passwordAdmin);
      Thread.sleep(1000);
    }
    app.getSiteHelper().click(By.cssSelector("a.user-profile-link"));
    app.getAdminHelper().click(By.cssSelector("button.btn.btn-link"));
    app.getAdminHelper().getAddressMainUrl();
    // наличия елемента кнопки Входа
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in")), true);
  }

@Test(dependsOnMethods = "testLogOutManager")
  public  void loginClientTestPosThroughEmailTest() throws InterruptedException {
    System.out.println("=======LoginTestsViaForm Test5=======");
    if(app.getMainPgHelper().elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"))) {
      app.getSessionHelper().login(usernameGuest, passwordGuest);
      Thread.sleep(1000);
    }
    // проверка правильности ссылки для профайла Юзера
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link"),"href"),"http://lptest.bigdig.com.ua/user/profile");
  }

@Test(dependsOnMethods = "loginClientTestPosThroughEmailTest")
  public void testLogOutClient() throws InterruptedException {
    System.out.println("======LoginTestsViaForm Test6=======");
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


  public void loginNegativeEmailTroughEmailTest () throws InterruptedException {
    String expectedTextFromAlert = "Введенные логин/пароль не верны";
    String IncorrectLogin = "manager@lunch.ua1";
    System.out.println("==========LoginTestsViaForm Test7==========");
    app.getSessionHelper().login(IncorrectLogin, passwordAdmin);
    Thread.sleep(1000);
    app.getSiteHelper().workWithAlert();
    String textFromAlert = app.getSiteHelper().alert.getText();
    System.out.println(textFromAlert);
    assertEquals(textFromAlert,expectedTextFromAlert);
  }

}
