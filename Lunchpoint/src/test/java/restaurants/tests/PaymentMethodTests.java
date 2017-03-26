package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 11.03.2017.
 */
public class PaymentMethodTests extends TestBase {

    @Test(enabled = true)
    public void paymentMethodAllPresenceTests() throws InterruptedException {
      // Наличие всех 6 методов оплаты
      app.getSessionHelper().login(usernameAdmin, passwordAdmin);
      Thread.sleep(2000);
      app.getAdminHelper()
              .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));

      // наличка/ Если выбран то елемент остается выбраным
      if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment0[checked='true']"))) {

      } else {
        app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment0']"));
      }
      // виза/ Если выбран то елемент остается выбраным
      if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment1[checked='true']"))) {

      } else {
        app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment1']"));
      }

      // мастер кард/ Если выбран то елемент остается выбраным
      if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment2[checked='true']"))) {

      } else {
        app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment2']"));
      }

      // маестро/ Если выбран то елемент остается выбраным
      if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment3[checked='true']"))) {

      } else {
        app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment3']"));
      }
      // Diners Club/ Если выбран то елемент остается выбраным
      if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment4[checked='true']"))) {

      } else {
        app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment4']"));
      }

      // American Express/ Если выбран то елемент остается выбраным
      if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment5[checked='true']"))) {

      } else {
        app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment5']"));
      }

      app.getMainPgHelper().saveRestMainPg();
      app.getMainPgHelper().confirmChangesOfRestMainPg();

      app.getAdminHelper().getAddressMainUrl();
      app.getSiteHelper().searchRestOnTheSite();
      app.getSiteHelper()
              .click(By.cssSelector(String.format("div[lng='%s'] div.title", restEditDataOfMainPg.getLng())));
      // проверка на присутствие иконки способ оплаты наличными
      assertEquals(app.getMainPgHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: bill']")), true);
      // проверка на присутствие иконки способ оплаты visa
      assertEquals(app.getMainPgHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: visa']")), true);
      // проверка на присутствие иконки способ оплаты mastercard
      assertEquals(app.getMainPgHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: mastercard']")), true);
      // проверка на присутствие иконки способ оплаты american card
      assertEquals(app.getMainPgHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: amex']")), true);
      // проверка на присутствие иконки способ оплаты diners-club
      assertEquals(app.getMainPgHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: diners-club']")), true);
      // проверка на присутствие иконки способ оплаты maestro
      assertEquals(app.getMainPgHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: maestro']")), true);
    }


  @Test(enabled = true)
  public void paymentMethodAllAbsenceTests() throws InterruptedException {
    // Отсутствие всех 6 методов оплаты
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));

    // наличка/ Если выбран то елемент становится не  выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment0[checked='true']"))) {
      app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment0']"));
    }
    // виза/ Если выбран то елемент становится не  выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment1[checked='true']"))) {
      app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment1']"));
    }
    // мастер кард/ Если выбран то елемент становится не  выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment2[checked='true']"))) {
      app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment2']"));
    }
    // маестро/ Если выбран то елемент становится не  выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment3[checked='true']"))) {
      app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment3']"));
    }
    // Diners Club/ Если выбран то елемент становится не  выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment4[checked='true']"))) {
      app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment4']"));
    }
    // American Express/ Если выбран то елемент становится не  выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt input#payment5[checked='true']"))) {
      app.getMainPgHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment5']"));
    }

    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper()
            .click(By.cssSelector(String.format("div[lng='%s'] div.title", restEditDataOfMainPg.getLng())));
    // проверка на отсутствие блока оплаты на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.pay-methods")), false);

  }
}
