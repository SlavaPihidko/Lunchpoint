package restaurants;

import org.testng.annotations.Test;

public class EditRestMainPageTests extends TestBase {

  @Test
  public void testEditRestaurantMainPage() throws InterruptedException {
    gotoAdminPanel();
    Thread.sleep(3000);
    searchRestInAdminPanel();
    gotoEditRestInAdminPanel();
    fillRestName(new RestDataOfMainPage("Slava test selenium"));
    saveRestMainPage();
    confirmChangesOfRestMainPage();
  }

}
