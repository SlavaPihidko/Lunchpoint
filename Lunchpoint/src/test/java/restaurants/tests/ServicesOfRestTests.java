package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

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
    if (app.getMainPageHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services1[checked]"))) {

    } else {
      app.getMainPageHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services1']"));
    }
    // ланчи/ Если выбран то елемент остается выбраным
    if (app.getMainPageHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services2[checked]"))) {

    } else {
      app.getMainPageHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services2']"));
    }

    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверка наличия вкладки с завтраком на страничке ресторана
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.nav.module-header li[data-id='breakfasts']")), true);
    // проверка наличия вкладки с ланчем на страничке ресторана
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.nav.module-header li[data-id='lunches']")), true);

  }


  @Test(enabled = true)
  public void servicesOfRestAbsenceBreakfastAndLunchTest() throws InterruptedException {
    // Отсутствие завтраков и ланчей
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");

    // завтраки/ Если выбран то елемент становится не выбраным
    if (app.getMainPageHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services1[checked]"))) {
      app.getMainPageHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services1']"));
    }
    // ланчи/ Если выбран то елемент становится не выбраным
    if (app.getMainPageHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services2[checked]"))) {
      app.getMainPageHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services2']"));
    }

    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверка наличия вкладки с завтраком на страничке ресторана
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.nav.module-header li[data-id='breakfasts']")), false);
    // проверка наличия вкладки с ланчем на страничке ресторана
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.nav.module-header li[data-id='lunches']")), false);

  }
}


