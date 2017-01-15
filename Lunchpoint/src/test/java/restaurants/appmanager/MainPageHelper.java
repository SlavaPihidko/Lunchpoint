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


  public void fillRestFieldOnMainPageNameAddress(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
    type(By.id("edit_restName"), restDataOfMainPage.getNameOfRest());
    dream();
    type(By.id("restAddress"),restDataOfMainPage.getAddressOfRest());
    js.executeScript("scrollBy(0,2000)");
  }

  public void saveRestMainPage() throws InterruptedException {
    click(By.cssSelector("div.input-outer.to-right > #btn_form_general"));
    dream();
  }

  public void confirmChangesOfRestMainPage() throws InterruptedException {
    click(By.id("save_ok"));
    dream();
    js.executeScript("scrollBy(0,-3300)");
  }

  public void gotoTabRestInAdminPanel() throws InterruptedException {
    click(By.linkText("Ресторани"));
    dream();
     }

  public void setText(By locator){
    wd.findElement(locator);
  }

  public String text(By locator){
    return wd.findElement(locator).getText();
  }

  public void fillAllOfRestFieldOnMainPage(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
    type(By.id("edit_restName"), restDataOfMainPage.getNameOfRest());
    type(By.id("edit_seo_url"),restDataOfMainPage.getSeoOfRest());
    type(By.name("RestaurantsLang[description]"),restDataOfMainPage.getDescriptionOfRest());
    type(By.id("restAddress"),restDataOfMainPage.getAddressOfRest());
   // type(By.id("geocomplete"),restDataOfMainPage.getAddressOnTheMapOfRest()); В поле "Адреса на карті" записываетсся значение, но так как выпадашка Гугловская, то я не могу выбрать значение с выпадашки
    //Нужно с значений с выпадашки формировать лишки, потом я смогу по ним клацать
    // Сейчас это обойду и буду жестко вставлять значение в поле GPS
    type(By.id("restaurants-latlng"),restDataOfMainPage.getGpsOfRest());
    type(By.id("restIndex"),restDataOfMainPage.getIndexOfRest());
    type(By.xpath("//input[@name='phone[]']"),restDataOfMainPage.getTelOfRest());
    type(By.name("Restaurants[email]"),restDataOfMainPage.getEmailOfRest());
    type(By.name("Restaurants[booking_email]"),restDataOfMainPage.getBookingEmailOfRest());
    type(By.id("restSite"),restDataOfMainPage.getSiteOfRest());
    type(By.name("Restaurants[fb]"),restDataOfMainPage.getFbOfRest());
    dream();
    js.executeScript("scrollBy(0,1600)");
    dream();
  }
}
