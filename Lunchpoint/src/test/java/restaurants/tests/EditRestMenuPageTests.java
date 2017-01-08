package restaurants.tests;

import org.testng.annotations.Test;

/**
 * Created by Slava on 08.01.2017.
 */
public class EditRestMenuPageTests extends TestBase {

  @Test
  public void testEditRestMenuPage() throws InterruptedException {
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().searchRestInAdminPanel();
    app.getAdminHelper().gotoEditRestInAdminPanel();
    app.getMenuPageHelper().gotoMenuPage();
    app.getMenuPageHelper().createNewMenu();
    app.getMenuPageHelper().saveRestMenuPage();
    app.getMenuPageHelper().confirmChangesOfRestMenuPage();
  }

}
