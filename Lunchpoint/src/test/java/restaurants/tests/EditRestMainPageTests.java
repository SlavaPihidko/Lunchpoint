package restaurants.tests;

import org.testng.annotations.Test;
import restaurants.model.RestDataOfMainPage;

public class EditRestMainPageTests extends TestBase {

  @Test
  public void testEditRestaurantMainPage() throws InterruptedException {
    app.getAdminHelper().gotoAdminPanel();
    Thread.sleep(3000);
    app.getAdminHelper().searchRestInAdminPanel();
    app.getAdminHelper().gotoEditRestInAdminPanel();
    app.getMainPageHelper().fillRestName(new RestDataOfMainPage("Slava test selenium"));
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
  }

}
