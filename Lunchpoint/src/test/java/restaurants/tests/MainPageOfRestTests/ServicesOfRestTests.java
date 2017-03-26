package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 08.03.2017.
 */
public class ServicesOfRestTests extends TestBase {

  @Test(enabled = false)
  public void servicesOfRestPresenceBreakfastAndLunchTest() throws InterruptedException {
    // Наличие завтраков и ланчей
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");

    // завтраки/ Если выбран то елемент остается выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services1[checked]"))) {

    } else {
      app.getMainPgHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services1']"));
    }
    // ланчи/ Если выбран то елемент остается выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services2[checked]"))) {

    } else {
      app.getMainPgHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services2']"));
    }

    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверка наличия вкладки с завтраком на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.nav.module-header li[data-id='breakfasts']")), true);
    // проверка наличия вкладки с ланчем на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.nav.module-header li[data-id='lunches']")), true);

  }


  @Test(enabled = false)
  public void servicesOfRestAbsenceBreakfastAndLunchTest() throws InterruptedException {
    // Отсутствие завтраков и ланчей
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");

    // завтраки/ Если выбран то елемент становится не выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services1[checked]"))) {
      app.getMainPgHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services1']"));
    }
    // ланчи/ Если выбран то елемент становится не выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services2[checked]"))) {
      app.getMainPgHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services2']"));
    }

    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверка наличия вкладки с завтраком на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.nav.module-header li[data-id='breakfasts']")), false);
    // проверка наличия вкладки с ланчем на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.nav.module-header li[data-id='lunches']")), false);

  }

  @Test(enabled = true)
  public void servicesOfRestPresenceBookTableTest() throws InterruptedException {
    // На наличие блока Бронирования столика
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");

    // Если выбран то ничего не делать, если не выбран то становится выбраным
   if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services3[checked]"))) {

    } else {
      app.getMainPgHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services3']"));
    }

    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверка наличия блока Бронирования
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.book-table.booking-view")), true);
  }


  @Test(enabled = true)
  public void servicesOfRestAbsenceBookTableTest() throws InterruptedException {
    // На отсутствие блока Бронирования столика
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");

    // Сделать не выбраным
    if (app.getMainPgHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services3[checked]"))) {
      app.getMainPgHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services3']"));
    }

    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверка отсутствия блока Бронирования
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.book-table.booking-view")), false);
  }
}


