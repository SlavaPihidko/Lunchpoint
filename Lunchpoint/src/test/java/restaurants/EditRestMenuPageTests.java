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

  private void confirmChangesOfRestMenuPage() {
    wd.findElement(By.id("save_ok")).click();
  }

  private void saveRestMenuPage() throws InterruptedException {
    wd.findElement(By.id("menu-img_update")).click();
    Thread.sleep(3000);
  }

  private void createNewMenu() throws InterruptedException {
    wd.findElement(By.cssSelector("div.add-menu-block")).click();
    Thread.sleep(3000);
  }

  private void gotoMenuPage() throws InterruptedException {
    wd.findElement(By.linkText("Меню")).click();
    Thread.sleep(3000);
  }
}
