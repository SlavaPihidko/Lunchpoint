package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import restaurants.model.CommentsDataOfRest;
import restaurants.model.RestDataOfMainPage;
import restaurants.model.RestDataOfNetworkList;
import restaurants.model.VariantsOfNameOfMainPage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slava on 08.01.2017.
 */
public class MainPageHelper extends HelperBase {

  public MainPageHelper(WebDriver wd) {
    super(wd);
  }


  public void fillRestFieldOnMainPageNameAddress(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
    enterNameOfRestMainPage(restDataOfMainPage);
    dream3Sec();
    enterAddressOfRestMainPage(restDataOfMainPage);
    js.executeScript("scrollBy(0,2000)");
  }

  public void saveRestMainPg() throws InterruptedException {
    click(By.cssSelector("div.input-outer.to-right > #btn_form_general"));
    dream3Sec();
  }

  public void confirmChangesOfRestMainPg() throws InterruptedException {
    click(By.id("save_ok"));
    dream2Sec();
    js.executeScript("scrollBy(0,-3300)");
  }

  public void gotoTabRestInAdminPanel() throws InterruptedException {
    click(By.linkText("РЕСТОРАНЫ"));
    dream1Sec();
     }

  public void fillAllOfRestFieldOnMainPage(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
    enterNameOfRestMainPage(restDataOfMainPage);
    enterSeoUrlOfRestMainPage(restDataOfMainPage);
    VariantsOfNameOfMainPage variantsOfNameOfMainPage = new VariantsOfNameOfMainPage("Masha\n", "Dima\n", "Kolya\n");
    enterVariantsOfNameOfRestMainPage(variantsOfNameOfMainPage);
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
    choiceNetworkOfRestMainPage(restDataOfMainPage);
    choiceTypeOfRestMainPage(restDataOfMainPage);
    choiceTypeOfCuisineOfRestMainPage(restDataOfMainPage);
    clickCheckBoxServicesOfRestMainPage();
    js.executeScript("scrollBy(0,300)");
    choiceAdditionalServicesOfRestMainPage(restDataOfMainPage);
    choiceOtherFeaturesOfRestMainPage(restDataOfMainPage);
    clickCheckboxPaymentOfRestMainPage();
    js.executeScript("scrollBy(0,300)");
    choiceRadiobuttonStatusOfRestMainPage();
    choiceTypeOfScheduleForEachDayOfRestMainPg();
    js.executeScript("scrollBy(0,600)");
    choiceRadiobutAvgPriceOfRestMainPg();
  }

  public void choiceRadiobutAvgPriceOfRestMainPg() throws InterruptedException {
    click(By.cssSelector("div.ranger-outer > div.Slider.ranger label[for='pos0']")); // Клик выбора средней цены
    dream1Sec();
  }

  public void choiceTypeOfScheduleForEachDayOfRestMainPg() throws InterruptedException {
    // Клик по выпадашке для Робочих дней
    click(By.cssSelector("div.day-type div#time_schedule1 > span"));
    dream1Sec();
    // Клик выбора работы Рабочих Дней Ресторана для каждого дня
    click(By.cssSelector("div#time_schedule1 ul.select li[value='each'] > span"));
    dream1Sec();
  }

  private void choiceRadiobuttonStatusOfRestMainPage() {
    click(By.cssSelector("div.input-outer.radio-tog.rest-state > label[for='state-1']")); // Клик по радиобатону Статус Ресторана
  }

  private void clickCheckboxPaymentOfRestMainPage() throws InterruptedException {
    click(By.cssSelector("div.opt div.input-outer li > label[for='payment0']")); // Клик по чекбоксу Наличные
    dream1Sec();
  }

  private void choiceOtherFeaturesOfRestMainPage(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
    new Select(wd.findElement(By.cssSelector("div.input-outer.hint-other-features select#restOtherFeatures2")))
            .selectByVisibleText(restDataOfMainPage.getOtherFeaturesOfRest());
  }

  private void choiceAdditionalServicesOfRestMainPage(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
    new Select(wd.findElement(By.cssSelector("div.opt.hint-options select#restOtherFeatures")))
            .selectByVisibleText(restDataOfMainPage.getAdditionalServiceOfRest());
  }

  private void clickCheckBoxServicesOfRestMainPage() throws InterruptedException {
    click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services1']")); // Клик по чекбоксу Завтраки
    dream1Sec();
  }

  private void choiceTypeOfCuisineOfRestMainPage(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
    new Select(wd.findElement(By.cssSelector("div.input-outer.hint-cuisine select#restCuisine")))
            .selectByVisibleText(restDataOfMainPage.getTypeOfCuisine());
    dream1Sec();
    new Select(wd.findElement(By.cssSelector("div.input-outer.hint-cuisine select#restCuisine")))
            .selectByVisibleText("Smoked food");
    dream1Sec();
  }

  private void choiceTypeOfRestMainPage(RestDataOfMainPage restDataOfMainPage) throws InterruptedException {
       new Select(wd.findElement(By.cssSelector("div.input-outer.rest-type select#restType")))
            .selectByVisibleText(restDataOfMainPage.getTypeOfRest());
    dream1Sec();
  }

  private void choiceNetworkOfRestMainPage(RestDataOfMainPage restDataOfMainPageAllField) throws InterruptedException {
       new Select(wd.findElement(By.cssSelector("div.input-outer.rest-net select#restNet")))
            .selectByVisibleText(restDataOfMainPageAllField.getNetworkOfRest());
    dream1Sec();
  }

  public void enterTwitterOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("restTw"),restDataOfMainPage.getTwitterOfRest()); // Вводим Твиттер Ресторана
  }

  public void enterInstagramOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("restInst"),restDataOfMainPage.getInstagramOfRest()); // Вводим Инстаграм Ресторана
  }

  public void enterFbOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.name("Restaurants[fb]"),restDataOfMainPage.getFbOfRest()); // Вводим Фейсбук ресторана
  }

  public void enterSiteOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("restSite"),restDataOfMainPage.getSiteOfRest()); // Вводим Сайт ресторана
  }

  public void enterBookingEmailOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.name("Restaurants[booking_email]"),restDataOfMainPage.getBookingEmailOfRest()); // Вводим Емейл для бронирования
  }

  public void enterEmailOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.name("Restaurants[email]"),restDataOfMainPage.getEmailOfRest()); // Вводим Емейл Ресторана
  }

  public void enterTelOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.xpath("//input[@name='phone[]']"),restDataOfMainPage.getTelOfRest()); // Вводим телефон ресторана
  }

  public void enterIndexOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("restIndex"),restDataOfMainPage.getIndexOfRest()); // Вводим Индекс ресторана
  }

  public void enterGpsOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
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

  public void enterDescriptionOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.name("RestaurantsLang[description]"),restDataOfMainPage.getDescriptionOfRest()); // Вводим текст в поле Описание Ресторана
  }

  public void enterVariantsOfNameOfRestMainPage(VariantsOfNameOfMainPage variantsOfNameOfMainPage) throws InterruptedException {
    click(By.cssSelector("div.input-outer span.selection ul.select2-selection__rendered")); // Кликаем в поле Варианты Названий
    dream1Sec();
    wd.findElement(By.cssSelector("div.input-outer span.selection ul.select2-selection__rendered input.select2-search__field")).sendKeys(variantsOfNameOfMainPage.getVarName1()); // Вводим в поле Варианты Названий текст и Ентер
    click(By.cssSelector("div.input-outer span.selection ul.select2-selection__rendered")); // Кликаем в поле Варианты Названий
    dream1Sec();
    wd.findElement(By.cssSelector("div.input-outer span.selection ul.select2-selection__rendered input.select2-search__field")).sendKeys(variantsOfNameOfMainPage.getVarName2());
    click(By.cssSelector("div.input-outer span.selection ul.select2-selection__rendered")); // Кликаем в поле Варианты Названий
    dream1Sec();
    wd.findElement(By.cssSelector("div.input-outer span.selection ul.select2-selection__rendered input.select2-search__field")).sendKeys(variantsOfNameOfMainPage.getVarName3());
    dream3Sec();
  }

  public void enterSeoUrlOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("edit_seo_url"),restDataOfMainPage.getSeoUrlOfRest()); // Вводим seo-url ресторана
  }

  public void enterNameOfRestMainPage(RestDataOfMainPage restDataOfMainPage) {
    type(By.id("edit_restName"), restDataOfMainPage.getNameOfRest()); // Вводим имя ресторана
  }

  public void fillNameOfRest(String[] nameDataOfRest, int i) {
    type(By.id("edit_restName"), nameDataOfRest[i]); // Вводим имя ресторана
  }

  public List<RestDataOfNetworkList> getNetworkList() {
    List<RestDataOfNetworkList> nameOfNetworks = new ArrayList<RestDataOfNetworkList>();
    List<WebElement> elements = wd.findElements(By.cssSelector("div.input-outer.rest-net select#restNet option"));
    for (WebElement element: elements){
      String nameOfNetwork = element.getText();
     // if(!nameOfNetwork.equals( "Без мережі")){
      //System.out.println("Из Веба:  "+nameOfNetwork);
      RestDataOfNetworkList network = new RestDataOfNetworkList(nameOfNetwork);
      nameOfNetworks.add(network);}
    //}
    return nameOfNetworks;
  }

  public void choiceHoursOfWorkingMon() {
    //установка часов напонедельник от
    click(By.cssSelector("div.each-day div.single-day:first-of-type div.outer input.time.ui-timepicker-input:first-of-type"));
    click(By.cssSelector("div.ui-timepicker-wrapper ul.ui-timepicker-list li:nth-of-type(1)"));
    //установка часов напонедельник до
    click(By.cssSelector("div.each-day div.single-day:first-of-type div.outer input.time.ui-timepicker-input:nth-of-type(2)"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(49)"));
  }

  public void choiceHoursOfWorkingTue() {
    //установка часов на вторник от
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(2) div.outer input.time.ui-timepicker-input:first-of-type"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(2)"));
    //установка часов на вторник до
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(2) div.outer input.time.ui-timepicker-input:nth-of-type(2)"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(10)"));
  }

  public void choiceHoursOfWorkingWen() {
    //установка часов на среду от
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(3) div.outer input.time.ui-timepicker-input:first-of-type"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(12)"));
    //установка часов на среду до
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(3) div.outer input.time.ui-timepicker-input:nth-of-type(2)"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(12)"));
  }

  public void choiceHoursOfWorkingThu() {
    //установка часов на четверг от
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(4) div.outer input.time.ui-timepicker-input:first-of-type"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(18)"));
    //установка часов на четверг до
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(4) div.outer input.time.ui-timepicker-input:nth-of-type(2)"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(30)"));
  }

  public void choiceHoursOfWorkingFri() {
    //установка часов на пятницу от
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(5) div.outer input.time.ui-timepicker-input:first-of-type"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(14)"));
    //установка часов на пятницу до
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(5) div.outer input.time.ui-timepicker-input:nth-of-type(2)"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(31)"));
  }

  public void choiceHoursOfWorkingSat() {
    //установка часов на субботу от
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(6) div.outer input.time.ui-timepicker-input:first-of-type"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(15)"));
    //установка часов на субботу до
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(6) div.outer input.time.ui-timepicker-input:nth-of-type(2)"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(32)"));
  }

  public void choiceHoursOfWorkingSun() {
    //установка часов на восресенье от
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(7) div.outer input.time.ui-timepicker-input:first-of-type"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(16)"));
    //установка часов на воскресенье до
    click(By.cssSelector("div.each-day div.single-day:nth-of-type(7) div.outer input.time.ui-timepicker-input:nth-of-type(2)"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(40)"));
  }

  public void choiceTypeOfScheduleForAllDaysOfRestMainPage() throws InterruptedException {
    // Клик по выпадашке для Робочих дней
    click(By.cssSelector("div.day-type div#time_schedule1 > span"));
    dream1Sec();
    // Клик выбора работы Рабочих Дней Ресторана для всех дней
    click(By.cssSelector("div#time_schedule1 ul.select li[value='all'] > span"));
    dream1Sec();
  }

  public void choiceHoursForAllDays() {
    //установка часов на все дни от
    click(By.cssSelector("div.all-days input:first-of-type"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(2)"));
    //установка часов на все дни до
    click(By.cssSelector("div.all-days input:nth-of-type(2)"));
    click(By.cssSelector("div.ui-timepicker-wrapper:last-of-type ul.ui-timepicker-list li:nth-of-type(40)"));
  }

  public void changeImage(File photo) {
    attach(By.name("rest_cover"),photo);
  }

  public List<CommentsDataOfRest> getCommentsList() throws InterruptedException {
    click(By.cssSelector("div.inner-toggle-full"));
    Thread.sleep(1000);

   /* List<CommentsDataOfRest> commentsFromWebStr = new ArrayList<CommentsDataOfRest>();
    List<WebElement> elements = wd.findElements(By.cssSelector("div.reviews-feed div.review-item.clear div.review-main div.text > p"));
    for(WebElement element:elements ) {
      String comment = element.getText();
      CommentsDataOfRest comments = new CommentsDataOfRest(comment);
      commentsFromWebStr.add(comments);
      System.out.println("commentsFromWebStr: " + commentsFromWebStr);
    }

    List<CommentsDataOfRest> commentsFromWebIds = new ArrayList<CommentsDataOfRest>();
      List<WebElement> elements2 = wd.findElements(By.cssSelector("div.reviews-feed div.review-item.clear"));
      for(WebElement element1:elements2){
        String id = element1.getAttribute("data");
        CommentsDataOfRest ids = new CommentsDataOfRest(id);
        commentsFromWebIds.add(ids);
        System.out.println("commentsFromWebIds : " + commentsFromWebIds);

      }
      //return commentsFromWebIds;
    return commentsFromWebStr;
    */
    List<CommentsDataOfRest> commentsFromWeb = new ArrayList<CommentsDataOfRest>();
    List<WebElement> elements = wd.findElements(By.cssSelector("div.reviews-feed div.review-item.clear"));
    for(WebElement element:elements ) {
      /*if(elementPresent(By.cssSelector("div.reply-toggle-full"))){
        click(By.cssSelector("div.reply-toggle-full"));
        Thread.sleep(1000);
      } else {
        System.out.println("NET ELEMENTA");
      }*/
      String id = element.getAttribute("data");
      String commentDirty = element.getText();
      String [] comment = commentDirty.split("\n");
     commentsFromWeb.add(new CommentsDataOfRest(id ,comment[5]));
      //System.out.println("commentsFromWebStr: " + commentsFromWeb);
    }
    return commentsFromWeb;
    }
  }


