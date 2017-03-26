package restaurants.scenarios;

import org.testng.annotations.Test;
import restaurants.tests.TestBase;

/**
 * Created by Slava on 08.01.2017.
 */
public class EditRestMenuPageTests extends TestBase {

  @Test
  public void testEditRestMenuPage() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMenuPageHelper().gotoMenuPage();
    app.getMenuPageHelper().createNewMenu();
    app.getMenuPageHelper().saveRestMenuPage();
    app.getMenuPageHelper().confirmChangesOfRestMenuPage();
  }
}
