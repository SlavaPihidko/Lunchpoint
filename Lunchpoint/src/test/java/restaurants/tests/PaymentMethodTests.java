package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 11.03.2017.
 */
public class PaymentMethodTests extends TestBase {

    @Test(enabled = true)
    public void paymentMethodAllPresenceTests() throws InterruptedException {
      // Наличие всех 6 методов оплаты
      app.getSessionHelper().login(usernameAdmin, passwordAdmin);
      Thread.sleep(2000);
      app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");

      // наличка/ Если выбран то елемент остается выбраным
      if (app.getMainPageHelper().elementPresent(By.cssSelector("div.opt input#payment0[checked='true']"))) {

      } else {
        app.getMainPageHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment0']"));
      }
      // виза/ Если выбран то елемент остается выбраным
      if (app.getMainPageHelper().elementPresent(By.cssSelector("div.opt input#payment1[checked='true']"))) {

      } else {
        app.getMainPageHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment1']"));
      }

      // мастер кард/ Если выбран то елемент остается выбраным
      if (app.getMainPageHelper().elementPresent(By.cssSelector("div.opt input#payment2[checked='true']"))) {

      } else {
        app.getMainPageHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment2']"));
      }

      // маестро/ Если выбран то елемент остается выбраным
      if (app.getMainPageHelper().elementPresent(By.cssSelector("div.opt input#payment3[checked='true']"))) {

      } else {
        app.getMainPageHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment3']"));
      }
      // Diners Club/ Если выбран то елемент остается выбраным
      if (app.getMainPageHelper().elementPresent(By.cssSelector("div.opt input#payment4[checked='true']"))) {

      } else {
        app.getMainPageHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment4']"));
      }

      // American Express/ Если выбран то елемент остается выбраным
      if (app.getMainPageHelper().elementPresent(By.cssSelector("div.opt input#payment5[checked='true']"))) {

      } else {
        app.getMainPageHelper().click(By.cssSelector("div.opt div.input-outer li > label[for='payment5']"));
      }

      app.getMainPageHelper().saveRestMainPage();
      app.getMainPageHelper().confirmChangesOfRestMainPage();

      app.getAdminHelper().getAddressMainUrl();
      app.getSiteHelper().searchRestOnTheSite();
      app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
      // проверка на присутствие иконки способ оплаты наличными
      assertEquals(app.getMainPageHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: bill']")), true);
      // проверка на присутствие иконки способ оплаты visa
      assertEquals(app.getMainPageHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: visa']")), true);
      // проверка на присутствие иконки способ оплаты mastercard
      assertEquals(app.getMainPageHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: mastercard']")), true);
      // проверка на присутствие иконки способ оплаты american card
      assertEquals(app.getMainPageHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: amex']")), true);
      // проверка на присутствие иконки способ оплаты diners-club
      assertEquals(app.getMainPageHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: diners-club']")), true);
      // проверка на присутствие иконки способ оплаты maestro
      assertEquals(app.getMainPageHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: maestro']")), true);
    }
}
