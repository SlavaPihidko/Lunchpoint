package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import restaurants.model.RestDataOfSiteList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

  public void workWithNewWindowForFB() throws InterruptedException {

    String originalWindow = wd.getWindowHandle();
    final Set<String> oldWindowsSet = wd.getWindowHandles();

    wd.findElement(By.cssSelector("div.log-block a.login-link.soc.fb")).click();
    String newWindow = (new WebDriverWait(wd, 10))
            .until(new ExpectedCondition<String>() {
                     public String apply(WebDriver driver) {
                       Set<String> newWindowsSet = driver.getWindowHandles();
                       newWindowsSet.removeAll(oldWindowsSet);
                       return newWindowsSet.size() > 0 ?
                               newWindowsSet.iterator().next() : null;
                     }
                   }
            );

    wd.switchTo().window(newWindow);
    System.out.println("New window title: " + wd.getTitle());
    wd.findElement(By.id("email")).click();
    wd.findElement(By.id("email")).clear();
    wd.findElement(By.id("email")).sendKeys("mltest@ukr.net");
    wd.findElement(By.id("pass")).click();
    wd.findElement(By.id("pass")).clear();
    wd.findElement(By.id("pass")).sendKeys("bigdig");
    wd.findElement(By.id("u_0_2")).click();

    wd.switchTo().window(originalWindow);
    System.out.println("Old window title: " + wd.getTitle());

  }

  public void workWithNewWindowForGoogle() throws InterruptedException {
    String originalWindow = wd.getWindowHandle();
    final Set<String> oldWindowsSet = wd.getWindowHandles();

    wd.findElement(By.cssSelector("div.log-block a.login-link.soc.google")).click();
    String newWindow = (new WebDriverWait(wd, 10))
            .until(new ExpectedCondition<String>() {
                     public String apply(WebDriver driver) {
                       Set<String> newWindowsSet = driver.getWindowHandles();
                       newWindowsSet.removeAll(oldWindowsSet);
                       return newWindowsSet.size() > 0 ?
                               newWindowsSet.iterator().next() : null;
                     }
                   }
            );

    wd.switchTo().window(newWindow);
    System.out.println("New window title: " + wd.getTitle());
    wd.findElement(By.id("identifierId")).click();
    wd.findElement(By.id("identifierId")).clear();
    wd.findElement(By.id("identifierId")).sendKeys("slavko9090test@gmail.com");
    wd.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(1500);
    wd.findElement(By.cssSelector("input[type='password']")).click();
    wd.findElement(By.cssSelector("input[type='password']")).clear();
    wd.findElement(By.cssSelector("input[type='password']")).sendKeys("testforselenium");
    wd.findElement(By.cssSelector("span.RveJvd.snByac")).click();

//    if(elementPresent(By.id("grant_heading"))){
//      click(By.id("submit_approve_access"));
//    }

    wd.switchTo().window(originalWindow);
    System.out.println("Old window title: " + wd.getTitle());
  }
}
