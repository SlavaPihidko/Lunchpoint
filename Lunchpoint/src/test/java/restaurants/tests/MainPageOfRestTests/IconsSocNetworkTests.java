package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.restDefaultDataOfMainPageAllField;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 02.03.2017.
 */
public class IconsSocNetworkTests extends TestBase {

  @Test(enabled = true)
  public void iconSocNetworkSiteTestPresent() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

    // проверка на присутствие иконки сайта ресторана
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.url")), true);
  }

  @Test(enabled = true)
  public void iconSocNetworkFaceBookTestPresent() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

    // проверка на присутствие иконки FB ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.fb"))), java.util.Optional.of(true));
  }

  @Test(enabled = true)
  public void iconSocNetworkTwitterTestPresent() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

    // проверка на присутствие иконки твиттера ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.tw"))), java.util.Optional.of(true));
  }

  @Test(enabled = true)
  public void iconSocNetworkInstagramTestPresent() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

    // проверка на присутствие иконки инстаграма ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.inst"))), java.util.Optional.of(true));
  }

  @Test(enabled = true)
  public void iconSocNetworkSiteTestAbsence() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPgHelper().enterSiteOfRestMainPage(restDefaultDataOfMainPageAllField);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoOfRest());

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.url"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    app.getMainPgHelper().enterSiteOfRestMainPage(restEditDataOfMainPg);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
  }

  @Test(enabled = true)
  public void iconSocNetworkFaceBookTestAbsence() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPgHelper().enterFbOfRestMainPage(restDefaultDataOfMainPageAllField);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoOfRest());

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.fb"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    app.getMainPgHelper().enterFbOfRestMainPage(restEditDataOfMainPg);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
  }

  @Test(enabled = true)
  public void iconSocNetworkInstagramAbsence() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPgHelper().enterInstagramOfRestMainPage(restDefaultDataOfMainPageAllField);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoOfRest());

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.inst"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    app.getMainPgHelper().enterInstagramOfRestMainPage(restEditDataOfMainPg);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
  }

  @Test(enabled = true)
  public void iconSocNetworkTwitterTestAbsence() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPgHelper().enterTwitterOfRestMainPage(restDefaultDataOfMainPageAllField);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoOfRest());

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.tw"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    app.getMainPgHelper().enterTwitterOfRestMainPage(restEditDataOfMainPg);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
  }
}
