package restaurants;

import org.testng.annotations.Test;

/**
 * Created by Slava on 08.01.2017.
 */
public class EditRestMenuPageTests extends TestBase {

  @Test
  public void testEditRestMenuPage() throws InterruptedException {
    gotoAdminPanel();
    Thread.sleep(3000);
    searchRestInAdminPanel();
    gotoEditRestInAdminPanel();
    gotoMenuPage();
    createNewMenu();
    saveRestMenuPage();
    confirmChangesOfRestMenuPage();
  }

}
