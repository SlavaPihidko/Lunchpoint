package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import restaurants.model.RestDataOfMainPage;

/**
 * Created by Slava on 08.01.2017.
 */
public class MainPageHelper extends HelperBase {

  public MainPageHelper(FirefoxDriver wd) {
    super(wd);
  }

  JavascriptExecutor js = (JavascriptExecutor)wd;

  Actions clicker = new Actions(wd);



  public void fillRestFieldOnMainPageNameAddress(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
    type(By.id("edit_restName"), restDataOfMainPage.getNameOfRest());
    dream3Sec();
    type(By.id("restAddress"),restDataOfMainPage.getAddressOfRest());
    js.executeScript("scrollBy(0,2000)");
  }

  public void saveRestMainPage() throws InterruptedException {
    click(By.cssSelector("div.input-outer.to-right > #btn_form_general"));
    dream3Sec();
  }

  public void confirmChangesOfRestMainPage() throws InterruptedException {
    click(By.id("save_ok"));
    dream3Sec();
    js.executeScript("scrollBy(0,-3300)");
  }

  public void gotoTabRestInAdminPanel() throws InterruptedException {
    click(By.linkText("Ресторани"));
    dream3Sec();
     }

  public void setText(By locator){
    wd.findElement(locator);
  }

  public String text(By locator){
    return wd.findElement(locator).getText();
  }

  public void fillAllOfRestFieldOnMainPage(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
    type(By.id("edit_restName"), restDataOfMainPage.getNameOfRest()); // Вводим имя ресторана
    type(By.id("edit_seo_url"),restDataOfMainPage.getSeoOfRest()); // Вводим seo-url ресторана
    click(By.cssSelector("div.input-outer span.selection ul.select2-selection__rendered")); // Кликаем в поле Варианты Названий
    wd.findElement(By.cssSelector("div.input-outer span.selection ul.select2-selection__rendered input.select2-search__field")).sendKeys("Dima\n"); // Вводим в поле Варианты Названий текст и Ентер
    type(By.name("RestaurantsLang[description]"),restDataOfMainPage.getDescriptionOfRest()); // Вводим текст в поле Описание Ресторана
    type(By.id("restAddress"),restDataOfMainPage.getAddressOfRest());
   // type(By.id("geocomplete"),restDataOfMainPage.getAddressOnTheMapOfRest()); В поле "Адреса на карті" записываетсся значение, но так как выпадашка Гугловская, то я не могу выбрать значение с выпадашки
    //Нужно с значений с выпадашки формировать лишки, потом я смогу по ним клацать
    // Сейчас это обойду и буду жестко вставлять значение в поле GPS
    js.executeScript("scrollBy(0,150)");
    type(By.id("restaurants-latlng"),restDataOfMainPage.getGpsOfRest()); // Вводим координаты Ресторана
    type(By.id("restIndex"),restDataOfMainPage.getIndexOfRest()); // Вводим Индекс ресторана
    type(By.xpath("//input[@name='phone[]']"),restDataOfMainPage.getTelOfRest()); // Вводим телефон ресторана
    js.executeScript("scrollBy(0,600)");
    type(By.name("Restaurants[email]"),restDataOfMainPage.getEmailOfRest()); // Вводим Емейл Ресторана
    type(By.name("Restaurants[booking_email]"),restDataOfMainPage.getBookingEmailOfRest()); // Вводим Емейл для бронирования
    type(By.id("restSite"),restDataOfMainPage.getSiteOfRest()); // Вводим Сайт ресторана
    type(By.name("Restaurants[fb]"),restDataOfMainPage.getFbOfRest()); // Вводим Фейсбук ресторана
    type(By.id("restInst"),restDataOfMainPage.getInstagramOfRest()); // Вводим Инстаграм Ресторана
    type(By.id("restTw"),restDataOfMainPage.getTwitterOfRest()); // Вводим Твиттер Ресторана
    js.executeScript("scrollBy(0,400)");
    click(By.cssSelector("div.input-outer.hint-cuisine  span[dir='ltr'] span.selection ul.select2-selection__rendered")); // Клик в поле Типы Кухни
    dream1Sec();
    clicker.moveToElement(wd.findElement(By.cssSelector("ul#select2-restCuisine-results > li:nth-of-type(1)"))).moveByOffset(15,15).click().perform(); // Выбор первого элемента с Типов Кухни
    click(By.cssSelector("div.input-outer.hint-cuisine  span[dir='ltr'] span.selection ul.select2-selection__rendered")); // Клик в Типах Кухни чточто бы закрыть выпадашку
    dream1Sec();
    click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services1']")); // Клик по чекбоксу Завтраки
    dream1Sec();
    js.executeScript("scrollBy(0,300)");
    dream1Sec();
    click(By.cssSelector("div.opt.hint-options span[dir='ltr'] span.selection ul.select2-selection__rendered ")); // Клик в поле Дополнительные услуги
    dream1Sec();
    clicker.moveToElement(wd.findElement(By.cssSelector("ul#select2-restOtherFeatures-results > li:nth-of-type(1)"))).moveByOffset(5,5).click().perform(); // Выбор первого элемента для Дополнительных услуг
    click(By.cssSelector("div.opt.hint-options span[dir='ltr'] span.selection ul.select2-selection__rendered ")); // что бы закрыть выпадашку снова клик в Дополнительных Услугах
    dream1Sec();
    click(By.cssSelector("div.input-outer.hint-other-features  span[dir='ltr'] span.selection ul.select2-selection__rendered")); // Клик в поле Особенности заведения
    dream1Sec();
    clicker.moveToElement(wd.findElement(By.cssSelector("ul#select2-restOtherFeatures2-results > li:nth-of-type(1)"))).moveByOffset(5,5).click().perform(); // Выбор первого элемента в поле Особенности заведения
    click(By.cssSelector("div.input-outer.hint-other-features  span[dir='ltr'] span.selection ul.select2-selection__rendered")); //что бы закрыть выпадашку
    dream1Sec();
    click(By.cssSelector("div.opt div.input-outer li > label[for='payment0']")); // Клик по чекбоксу Наличные
    dream1Sec();
    js.executeScript("scrollBy(0,200)");
    click(By.cssSelector("div.input-outer.radio-tog.rest-state > label[for='state-1']")); // Клик по радиобатону Статус Ресторана
    click(By.cssSelector("div.day-type div#time_schedule1 > span")); // Клик по выпадашке для Робочих дней
    dream3Sec();
    js.executeScript("scrollBy(0,800)");
    dream3Sec();
  }
}
