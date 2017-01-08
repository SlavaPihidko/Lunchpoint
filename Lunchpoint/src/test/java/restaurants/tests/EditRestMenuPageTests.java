package restaurants.tests;

import org.testng.annotations.Test;

/**
 * Created by Slava on 08.01.2017.
 */
public class EditRestMenuPageTests extends TestBase {

  @Test
  public void testEditRestMenuPage() throws InterruptedException {
    app.getAdminHelper().gotoAdminPanel();
    Thread.sleep(3000);
    app.getAdminHelper().searchRestInAdminPanel();
    app.getAdminHelper().gotoEditRestInAdminPanel();
    app.gotoMenuPage();
    app.createNewMenu();
    app.saveRestMenuPage();
    app.confirmChangesOfRestMenuPage();
  }

}
