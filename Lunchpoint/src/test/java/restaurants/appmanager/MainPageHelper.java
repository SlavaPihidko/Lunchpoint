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
    enterNameOfRestMainPage(restDataOfMainPage);
    dream3Sec();
    enterAddressOfRestMainPage(restDataOfMainPage);
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
    enterNameOfRestMainPage(restDataOfMainPage);
    enterSeoUrlOfRestMainPage(restDataOfMainPage);
    enterVariantsOfNameOfRestMainPage();
    enterDescriptionOfRestMainPage(restDataOfMainPage);
    enterAddressOfRestMainPage(restDataOfMainPage);
    //enterAddressOnTheMapOfRestMainPage(restDataOfMainPage);
    js.executeScript("scrollBy(0,150)");
    enterGpsOfRestMainPage(restDataOfMainPage);
    enterIndexOfRestMainPage(restDataOfMainPage);
    enterTelOfRestMainPage(restDataOfMainPage);
    js.executeScript("scrollBy(0,600)");
    enterEmailOfRestMainPage(restDataOfMainPage);
    enterBookingEmailOfRestMainPage(restDataOfMainPage);
    enterSiteOfRestMainPage(restDataOfMainPage);
    enterFbOfRestMainPage(restDataOfMainPage);
    enterInstagramOfRestMainPage(restDataOfMainPage);
    enterTwitterOfRestMainPage(restDataOfMainPage);
    js.executeScript("scrollBy(0,300)");
    click(By.cssSelector("div.input-outer.rest-net span.select2-selection__arrow")); // Клик по Сети Заведения
    dream3Sec();
    clicker.moveToElement(wd.findElement(By.cssSelector("span.select2-dropdown.select2-dropdown--below span.select2-results > ul#select2-restNet-results > li:nth-of-type(2)"))).moveByOffset(5,5).click().perform(); // Клип по второму елементу с Сетей заведения, если  выбран изначально первый елемент
    dream1Sec();
    click(By.cssSelector("div.input-outer.rest-net span.select2-selection__arrow")); // Клик по Сети Заведения что бы закрыть
    dream1Sec();
    click(By.cssSelector("div.input-outer.rest-type span.select2-selection__arrow")); // Клик по Типу Заведения
    dream1Sec();
    clicker.moveToElement(wd.findElement(By.cssSelector("span.select2-dropdown.select2-dropdown--below span.select2-results ul#select2-restType-results > li:nth-of-type(2)"))).moveByOffset(5,5).click().perform(); // Клик по первому елементу с Типов Заведения
    click(By.cssSelector("div.input-outer.rest-type span.select2-selection__arrow")); // Клик что бы закрыть выпадашку по Типам Заведения
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
    js.executeScript("scrollBy(0,300)");
    click(By.cssSelector("div.input-outer.radio-tog.rest-state > label[for='state-1']")); // Клик по радиобатону Статус Ресторана
    click(By.cssSelector("div.day-type div#time_schedule1 > span")); // Клик по выпадашке для Робочих дней
    //div.time_schedule1 ul.select li.option.curr-opt > span
    dream1Sec();
    click(By.cssSelector("div#time_schedule1 ul.select li[value='each'] > span")); // Клик выбора работы Рабочих Дней Ресторана
    dream1Sec();
    //div.ranger-outer > div.Slider.ranger label[for='pos0']
    js.executeScript("scrollBy(0,600)");
    click(By.cssSelector("div.ranger-outer > div.Slider.ranger label[for='pos0']")); // Клик выбора средней цены
    dream3Sec();
  }

  private void enterTwitterOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("restTw"),restDataOfMainPage.getTwitterOfRest()); // Вводим Твиттер Ресторана
  }

  private void enterInstagramOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("restInst"),restDataOfMainPage.getInstagramOfRest()); // Вводим Инстаграм Ресторана
  }

  private void enterFbOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.name("Restaurants[fb]"),restDataOfMainPage.getFbOfRest()); // Вводим Фейсбук ресторана
  }

  private void enterSiteOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("restSite"),restDataOfMainPage.getSiteOfRest()); // Вводим Сайт ресторана
  }

  private void enterBookingEmailOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.name("Restaurants[booking_email]"),restDataOfMainPage.getBookingEmailOfRest()); // Вводим Емейл для бронирования
  }

  private void enterEmailOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.name("Restaurants[email]"),restDataOfMainPage.getEmailOfRest()); // Вводим Емейл Ресторана
  }

  private void enterTelOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.xpath("//input[@name='phone[]']"),restDataOfMainPage.getTelOfRest()); // Вводим телефон ресторана
  }

  private void enterIndexOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("restIndex"),restDataOfMainPage.getIndexOfRest()); // Вводим Индекс ресторана
  }

  private void enterGpsOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("restaurants-latlng"),restDataOfMainPage.getGpsOfRest()); // Вводим координаты Ресторана
  }

  private void enterAddressOnTheMapOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("geocomplete"),restDataOfMainPage.getAddressOnTheMapOfRest());
    //В поле "Адреса на карті" записываетсся значение, но так как выпадашка Гугловская, то я не могу выбрать значение с выпадашки
    //Нужно с значений с выпадашки формировать лишки, потом я смогу по ним клацать
    // Сейчас это обойду и буду жестко вставлять значение в поле GPS
  }

  private void enterAddressOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("restAddress"),restDataOfMainPage.getAddressOfRest());
  }

  private void enterDescriptionOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.name("RestaurantsLang[description]"),restDataOfMainPage.getDescriptionOfRest()); // Вводим текст в поле Описание Ресторана
  }

  private void enterVariantsOfNameOfRestMainPage() {
    click(By.cssSelector("div.input-outer span.selection ul.select2-selection__rendered")); // Кликаем в поле Варианты Названий
    wd.findElement(By.cssSelector("div.input-outer span.selection ul.select2-selection__rendered input.select2-search__field")).sendKeys("Dima\n"); // Вводим в поле Варианты Названий текст и Ентер
  }

  private void enterSeoUrlOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("edit_seo_url"),restDataOfMainPage.getSeoUrlOfRest()); // Вводим seo-url ресторана
  }

  private void enterNameOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("edit_restName"), restDataOfMainPage.getNameOfRest()); // Вводим имя ресторана
  }
}
