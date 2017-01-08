package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import restaurants.model.RestDataOfMainPage;

/**
 * Created by Slava on 08.01.2017.
 */
public class MainPageHelper {
  private FirefoxDriver wd;

  public MainPageHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void confirmChangesOfRestMainPage() {
    wd.findElement(By.id("save_ok")).click();
  }

  public void saveRestMainPage() throws InterruptedException {
    wd.findElement(By.id("btn_form_general")).click();
    Thread.sleep(3000);
  }

  public void fillRestName(RestDataOfMainPage restDataOfMainPage) {
    wd.findElement(By.id("edit_restName")).click();
    wd.findElement(By.id("edit_restName")).clear();
    wd.findElement(By.id("edit_restName")).sendKeys(restDataOfMainPage.getNameOfRest());
  }
}
