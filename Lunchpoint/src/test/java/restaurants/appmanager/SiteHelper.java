package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Slava on 30.01.2017.
 */
public class SiteHelper extends HelperBase {

  public SiteHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void enterCity(String city) {
    //click(By.id("name_address"));
    type(By.id("name_address"), city);
  }

  public void enterRestName(String nameOfRest) {
    type(By.name("f"), nameOfRest);
  }

  public void searchRestButton() throws InterruptedException {
    click(By.cssSelector("div.input-outer.to-right > input[type='submit']"));
    dream3Sec();
  }
}
