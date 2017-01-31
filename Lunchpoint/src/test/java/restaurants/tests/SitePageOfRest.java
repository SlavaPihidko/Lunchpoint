package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 30.01.2017.
 */
public class SitePageOfRest extends TestBase {

  @Test(enabled = true)
  public void testSitePageOfRest() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();
    // проверка по типу ресторана
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.wrap div.cafe-type > p")), "Бистро");
    // проверка по названию ресторана
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.wrap div.cafe-name > h1")), "Slava test selenium");
    // проверка по типу кухни
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.wrap div.cafe-kitchen > p")), "BBQ");
    // проверка по типу улице
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.cafe-info > div.addr > p")), "вул.Жолудєва 8");
    // проверка по ном. тел
   // assertEquals(app.getMainPageHelper().text(By.cssSelector("div.cafe-info > div.tel > p")), "");
    // проверка по среднему чеку
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.wrap div.min-bill.clear > span")), "<100 грн");
    // проверка на присутствие иконки сайта ресторана и текста в ней www
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.cafe-info > div.links > a.url")), "www");
    // проверка на присутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.url"))), java.util.Optional.of(true));
    // проверка на присутствие иконки фейсбука
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.fb"))), java.util.Optional.of(true));
    // проверка на присутствие иконки твитера
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.tw"))), java.util.Optional.of(true));
    // проверка на присутствие иконки инстаграм
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.inst"))), java.util.Optional.of(true));
    // проверка на присутствие иконки способ оплаты наличными
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: bill']"))), java.util.Optional.of(true));
    // проверка на присутствие иконки способ оплаты visa
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: visa']"))), java.util.Optional.of(true));
    // проверка на присутствие иконки способ оплаты mastercard
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: mastercard']"))), java.util.Optional.of(true));
    // проверка на присутствие иконки способ оплаты american card
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: amex']"))), java.util.Optional.of(true));
    // проверка на присутствие иконки способ оплаты diners-club
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: diners-club']"))), java.util.Optional.of(true));
    // проверка на присутствие иконки способ оплаты maestro
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.pay-methods > img[alt='payment method: maestro']"))), java.util.Optional.of(true));
    // проверка на наличие и название особенности(доп. услуг)
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.features-outer div.features div[dir='ltr'] > li.wi-fi:first-of-type")), "Happy hours");
    // проверка на наличие и название особенности
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.features-outer div.features div[dir='ltr'] > li.wi-fi:nth-of-type(2)")), "Cork-fee");


  }

}
