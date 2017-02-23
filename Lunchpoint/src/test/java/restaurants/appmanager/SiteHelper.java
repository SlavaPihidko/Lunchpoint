package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import restaurants.model.RestDataOfSiteList;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

/**
 * Created by Slava on 30.01.2017.
 */
public class SiteHelper extends HelperBase {

  public SiteHelper(WebDriver wd) {
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

  public void searchRestOnTheSite() throws InterruptedException {
    String city = "Київ";
    String nameOfRest = "Slava";
    enterCity(city);
    enterRestName(nameOfRest);
    searchRestButton();
  }

  public void searchRestOnTheSite(String city, String nameOfRest) throws InterruptedException {
    enterCity(city);
    enterRestName(nameOfRest);
    searchRestButton();
  }

  public void choiceTheTown(String city) throws InterruptedException {
    enterCity(city);
    searchRestButton();
  }

  public void scroll(String x) throws InterruptedException {
    js.executeScript(x);
    dream3Sec();
  }

  public void goToRestTab()  {
    click(By.cssSelector("div.wrap li.top-form-submit:nth-of-type(3) > a"));
  }

  public void choiceTypeOfRest(String typeOfRest) throws InterruptedException {
    click(By.cssSelector("div.filters div.opt-group:nth-of-type(1) div.opts > label[for='"+typeOfRest+"']"));
    dream3Sec();
  }

  public List<RestDataOfSiteList> getRestList() {
    List<RestDataOfSiteList> restsFromTypeOfRest = new ArrayList<RestDataOfSiteList>();
    List<WebElement> elements = wd.findElements(By.cssSelector("div.results-list div.item div.type"));
    for (WebElement element: elements){
      String typeOfRest = element.getText();
      RestDataOfSiteList rest = new RestDataOfSiteList(typeOfRest);
      restsFromTypeOfRest.add(rest);
    }
    return restsFromTypeOfRest;
  }
}
