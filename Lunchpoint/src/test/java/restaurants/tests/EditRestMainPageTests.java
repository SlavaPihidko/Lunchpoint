package restaurants.tests;

import org.testng.annotations.Test;
import restaurants.model.RestDataOfMainPage;

public class EditRestMainPageTests extends TestBase {

  @Test
  public void testEditRestaurantMainPage() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPageHelper().fillRestName(new RestDataOfMainPage("Slava test selenium"));
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
  }
}
