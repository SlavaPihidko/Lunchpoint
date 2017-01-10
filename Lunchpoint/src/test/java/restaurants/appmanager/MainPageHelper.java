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

  public void fillRestFieldOnMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("edit_restName"), restDataOfMainPage.getNameOfRest());

  }

  public void saveRestMainPage() throws InterruptedException {
    click(By.id("btn_form_general"));
    dream();
  }

  public void confirmChangesOfRestMainPage() throws InterruptedException {
    click(By.id("save_ok"));
    dream();
  }

  public void gotoTabRestInAdminPanel() throws InterruptedException {
    wd.get("http://lptest.bigdig.com.ua/manager/restaurants");
    dream();
    //click(By.cssSelector("div.row-footer.clear"));
    //click(By.linkText("Ресторани"));
    //dream();
  }

  public void setText(By locator){
    wd.findElement(locator);
  }

  public String text(By locator){
    return wd.findElement(locator).getText();
  }

}
