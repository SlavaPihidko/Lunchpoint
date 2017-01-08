package restaurants;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Slava on 08.01.2017.
 */
public class EditRestMenuPageTests extends TestBase {

  @Test
  public void testEditRestMenuPage() throws InterruptedException {
      searchRestInAdminPanel();
      gotoEditRestInAdminPanel();
      gotoMenuPage();
      createNewMenu();
      saveRestMenuPage();
      confirmChangesOfRestMenuPage();
  }

}
