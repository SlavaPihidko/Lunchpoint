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
    click(By.id("save_ok"));
  }

  public void saveRestMainPage() throws InterruptedException {
    click(By.id("btn_form_general"));
    Thread.sleep(3000);
  }

  private void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillRestName(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("edit_restName"), restDataOfMainPage.getNameOfRest());
  }

  private void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }
}
