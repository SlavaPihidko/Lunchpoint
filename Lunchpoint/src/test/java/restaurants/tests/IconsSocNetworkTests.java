package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

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
      assertEquals(java.util.Optional.of(app.getMainPageHelper()
              .elementPresent(By.cssSelector("div.cafe-info > div.links > a.url"))), java.util.Optional.of(true));
    }

  @Test(enabled = true)
  public void iconSocNetworkFaceBookTestPresent()  throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

    // проверка на присутствие иконки FB ресторана
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.fb"))), java.util.Optional.of(true));
  }

  @Test(enabled = true)
  public void iconSocNetworkTwitterTestPresent()  throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

    // проверка на присутствие иконки твиттера ресторана
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.tw"))), java.util.Optional.of(true));
  }

  @Test(enabled = true)
  public void iconSocNetworkInstagramTestPresent()  throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

    // проверка на присутствие иконки инстаграма ресторана
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.inst"))), java.util.Optional.of(true));
  }

  @Test(enabled = true)
  public void iconSocNetworkSiteTestAbsence()  throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPageHelper().enterSiteOfRestMainPage(restNullDataOfMainPageAllField);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();

    app.getAdminHelper().getAddressMainUrl("slavkotest1234");

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.url"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    app.getMainPageHelper().enterSiteOfRestMainPage(restEditDataOfMainPg);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
  }

  @Test(enabled = true)
  public void iconSocNetworkFaceBookTestAbsence()  throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPageHelper().enterFbOfRestMainPage(restNullDataOfMainPageAllField);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();

    app.getAdminHelper().getAddressMainUrl("slavkotest1234");

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.fb"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    app.getMainPageHelper().enterFbOfRestMainPage(restEditDataOfMainPg);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
  }

  @Test(enabled = true)
  public void iconSocNetworkInstagramAbsence()  throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPageHelper().enterInstagramOfRestMainPage(restNullDataOfMainPageAllField);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();

    app.getAdminHelper().getAddressMainUrl("slavkotest1234");

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.inst"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    app.getMainPageHelper().enterInstagramOfRestMainPage(restEditDataOfMainPg);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
  }

  @Test(enabled = true)
  public void iconSocNetworkTwitterTestAbsence()  throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPageHelper().enterTwitterOfRestMainPage(restNullDataOfMainPageAllField);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();

    app.getAdminHelper().getAddressMainUrl("slavkotest1234");

    // проверка на отсутствие иконки сайта ресторана
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.tw"))), java.util.Optional.of(false));
    // устновка прежднего состояния
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    app.getMainPageHelper().enterTwitterOfRestMainPage(restEditDataOfMainPg);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
  }
}
