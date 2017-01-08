package restaurants.tests;

import org.testng.annotations.Test;
import restaurants.model.RestDataOfMainPage;

public class EditRestMainPageTests extends TestBase {

  @Test
  public void testEditRestaurantMainPage() throws InterruptedException {
    app.gotoAdminPanel();
    Thread.sleep(3000);
    app.searchRestInAdminPanel();
    app.gotoEditRestInAdminPanel();
    app.fillRestName(new RestDataOfMainPage("Slava test selenium"));
    app.saveRestMainPage();
    app.confirmChangesOfRestMainPage();
  }

}
