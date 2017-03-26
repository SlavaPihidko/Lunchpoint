package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 02.03.2017.
 */
public class IconsSocNetworkTests extends TestBase {

  @Test(enabled = true)
    public void iconSocNetworkSiteTestPresent()  throws InterruptedException {
      app.getSiteHelper().searchRestOnTheSite();
      app.getSiteRestPageHelper().goToRestPage();

      // проверка на присутствие иконки сайта ресторана
      assertEquals(java.util.Optional.of(app.getMainPgHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.links > a.url"))), java.util.Optional.of(true));
    }

  @Test(enabled = true)
  public void iconSocNetworkFaceBookTestPresent()  throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

    // проверка на присутствие иконки FB ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.fb"))), java.util.Optional.of(true));
  }

  @Test(enabled = true)
  public void iconSocNetworkTwitterTestPresent()  throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

    // проверка на присутствие иконки твиттера ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.tw"))), java.util.Optional.of(true));
  }

  @Test(enabled = true)
  public void iconSocNetworkInstagramTestPresent()  throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

    // проверка на присутствие иконки инстаграма ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.inst"))), java.util.Optional.of(true));
  }

  @Test(enabled = true)
  public void iconSocNetworkSiteTestAbsence()  throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPgHelper().enterSiteOfRestMainPage(MainPgUtils.restDefaultDataOfMainPageAllField);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl("slavkotest1234");

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.url"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    app.getMainPgHelper().enterSiteOfRestMainPage(MainPgUtils.restEditDataOfMainPg);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
  }

  @Test(enabled = true)
  public void iconSocNetworkFaceBookTestAbsence()  throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPgHelper().enterFbOfRestMainPage(MainPgUtils.restDefaultDataOfMainPageAllField);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl("slavkotest1234");

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.fb"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    app.getMainPgHelper().enterFbOfRestMainPage(MainPgUtils.restEditDataOfMainPg);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
  }

  @Test(enabled = true)
  public void iconSocNetworkInstagramAbsence()  throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPgHelper().enterInstagramOfRestMainPage(MainPgUtils.restDefaultDataOfMainPageAllField);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl("slavkotest1234");

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.inst"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    app.getMainPgHelper().enterInstagramOfRestMainPage(MainPgUtils.restEditDataOfMainPg);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
  }

  @Test(enabled = true)
  public void iconSocNetworkTwitterTestAbsence()  throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPgHelper().enterTwitterOfRestMainPage(MainPgUtils.restDefaultDataOfMainPageAllField);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl("slavkotest1234");

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.tw"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    app.getMainPgHelper().enterTwitterOfRestMainPage(MainPgUtils.restEditDataOfMainPg);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
  }
}
