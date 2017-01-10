package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import restaurants.model.RestDataOfMainPage;

/**
 * Created by Slava on 08.01.2017.
 */
public class MainPageHelper extends HelperBase {

  public MainPageHelper(FirefoxDriver wd) {
    super(wd);
  }

  JavascriptExecutor js = (JavascriptExecutor)wd;


  public void fillRestFieldOnMainPage(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
    type(By.id("edit_restName"), restDataOfMainPage.getNameOfRest());
    dream();
    type(By.id("restAddress"),restDataOfMainPage.getAddressOfRest());
    js.executeScript("scrollBy(0,2000)");
    //click(By.cssSelector("div.rest-options"));
    //dream();

  }

  public void saveRestMainPage() throws InterruptedException {
    click(By.cssSelector("div.input-outer.to-right > #btn_form_general"));
    dream();
  }

  public void confirmChangesOfRestMainPage() throws InterruptedException {
    click(By.id("save_ok"));
    dream();
  }

  public void gotoTabRestInAdminPanel() throws InterruptedException {
    wd.get("http://lptest.bigdig.com.ua/manager/restaurants");
    dream();
     }

  public void setText(By locator){
    wd.findElement(locator);
  }

  public String text(By locator){
    return wd.findElement(locator).getText();
  }

}
