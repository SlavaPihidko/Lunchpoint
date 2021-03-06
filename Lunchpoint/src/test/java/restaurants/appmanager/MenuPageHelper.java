package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Slava on 08.01.2017.
 */
public class MenuPageHelper extends HelperBase {

  public MenuPageHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoMenuPage() throws InterruptedException {
    click(By.linkText("Меню"));
    dream3Sec();
  }

  public void createNewMenu() throws InterruptedException {
    click(By.cssSelector("div.add-menu-block"));
    dream3Sec();
  }

  public void saveRestMenuPage() throws InterruptedException {
    click(By.id("menu-img_update"));
    dream3Sec();
  }

  public void confirmChangesOfRestMenuPage() {
    click(By.id("save_ok"));
  }

}
