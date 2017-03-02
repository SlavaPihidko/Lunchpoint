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
    app.getMainPageHelper().enterSiteOfRestMainPage(restEditDataOfMainPageAllField);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
  }

  }
