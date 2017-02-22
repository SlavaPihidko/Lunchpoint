package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 16.02.2017.
 */
public class NameOfRestTests extends TestBase {

  @Test
  public void nameOfRestTests() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    String[] nameDataOfRest = {"slava",
            "slava ltd",
            "фотограф",
            "abc",
            "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa",
            "slava123"};
    String[] nameDataOfRestNegative = {"aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa1", "slava"};
    for (int i = 0; i < nameDataOfRest.length; i++) {
      //app.getAdminHelper().initOfEditRest();
      app.getAdminHelper().getAddressMainUrl();
      app.getSiteHelper().enterRestName(nameDataOfRest[i]);
      app.getSiteHelper().searchRestButton();
      assertEquals(app.getMainPageHelper()
              .text(By.cssSelector("div[lng='30.39818839999998'] div.title")),nameDataOfRest[i]) ;
      app.getMainPageHelper().click(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link"));
      app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", nameDataOfRest[i]);
      app.getAdminHelper().gotoAddressFieldInAdminPanel();

      assertEquals(app.getAdminHelper()
              .elementPresent(By.cssSelector("a[href='/manager/restaurants/update?id=2219']")), true);
      app.getAdminHelper().gotoEditRestInAdminPanel();
      Thread.sleep(2000);
      assertEquals(app.getMainPageHelper()
              .attribute(By.id("edit_restName"),"value"), nameDataOfRest[i]);
      // for(int i=0;i<nameDataOfRest.length;i++) {
      if (i == nameDataOfRest.length - 1) {
        app.getMainPageHelper().fillNameOfRest(nameDataOfRest, i);
        app.getMainPageHelper().saveRestMainPage();
        app.getMainPageHelper().confirmChangesOfRestMainPage();
        app.getMainPageHelper().gotoTabRestInAdminPanel();
        // }
      } else {
        app.getMainPageHelper().fillNameOfRest(nameDataOfRest, i + 1);
        app.getMainPageHelper().saveRestMainPage();
        app.getMainPageHelper().confirmChangesOfRestMainPage();
        app.getMainPageHelper().gotoTabRestInAdminPanel();
      }
    }
    app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", "slava123");
    app.getAdminHelper().gotoAddressFieldInAdminPanel();
    for (int y = 0; y < nameDataOfRestNegative.length; y++) {
      if(y!=0) {
        app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa");
        app.getAdminHelper().gotoAddressFieldInAdminPanel();
      }
      app.getAdminHelper().gotoEditRestInAdminPanel();

        app.getMainPageHelper().fillNameOfRest(nameDataOfRestNegative, y);
        app.getMainPageHelper().saveRestMainPage();
        app.getMainPageHelper().confirmChangesOfRestMainPage();
        app.getMainPageHelper().gotoTabRestInAdminPanel();
       if(y != nameDataOfRestNegative.length - 1) {
        app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa1");
        app.getAdminHelper().gotoAddressFieldInAdminPanel();
        //while (y == nameDataOfRestNegative.length - 1) ;
        assertEquals(app.getAdminHelper()
                .text(By.cssSelector("table.table.table-striped.table-bordered div.empty")), "Ничего не найдено.");
      } //while (y != nameDataOfRestNegative.length - 1);
    }
  }


}
