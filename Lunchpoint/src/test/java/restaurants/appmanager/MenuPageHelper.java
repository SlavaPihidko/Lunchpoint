package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Slava on 08.01.2017.
 */
public class MenuPageHelper {
  protected FirefoxDriver wd;

  public MenuPageHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void confirmChangesOfRestMenuPage() {
    wd.findElement(By.id("save_ok")).click();
  }

  public void saveRestMenuPage() throws InterruptedException {
    wd.findElement(By.id("menu-img_update")).click();
    Thread.sleep(3000);
  }

  public void createNewMenu() throws InterruptedException {
    wd.findElement(By.cssSelector("div.add-menu-block")).click();
    Thread.sleep(3000);
  }

  public void gotoMenuPage() throws InterruptedException {
    wd.findElement(By.linkText("Меню")).click();
    Thread.sleep(3000);
  }
}
