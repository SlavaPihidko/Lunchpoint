package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import restaurants.model.RestDataOfMainPage;

/**
 * Created by Slava on 08.01.2017.
 */
public class MainPageHelper extends HelperBase {

  public MainPageHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillRestName(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("edit_restName"), restDataOfMainPage.getNameOfRest());
  }

  public void saveRestMainPage() throws InterruptedException {
    click(By.id("btn_form_general"));
    dream();
  }

  public void confirmChangesOfRestMainPage() {
    click(By.id("save_ok"));
  }

  public void gotoTabRestInAdminPanel() {
    click(By.linkText("Ресторани"));
  }
}
