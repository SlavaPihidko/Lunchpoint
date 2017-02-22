package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.model.NameDataOfRest;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 16.02.2017.
 */
public class NameOfRestTests extends TestBase {

  @Test
  public void nameOfRestTests() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    String [] nameDataOfRest = {"slava",
            "slava ltd",
            "фотограф",
            "q",
            "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa",
            "slava123"};
    String [] nameDataOfRestNegative = {"aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa1"};
    for(int i=0;i<nameDataOfRest.length;i++) {
      //app.getAdminHelper().initOfEditRest();
      app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", nameDataOfRest[i]);
      app.getAdminHelper().gotoAddressFieldInAdminPanel();
      app.getAdminHelper().gotoEditRestInAdminPanel();
      // for(int i=0;i<nameDataOfRest.length;i++) {
      if (i == nameDataOfRest.length-1) {
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
    app.getAdminHelper().gotoEditRestInAdminPanel();
    app.getMainPageHelper().fillNameOfRest(nameDataOfRestNegative, 0);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
    app.getMainPageHelper().gotoTabRestInAdminPanel();
    app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa1");
    app.getAdminHelper().gotoAddressFieldInAdminPanel();
    assertEquals(app.getAdminHelper()
            .text(By.cssSelector("table.table.table-striped.table-bordered div.empty")),"Ничего не найдено.");
  }
}
