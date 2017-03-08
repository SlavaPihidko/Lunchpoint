package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 08.03.2017.
 */
public class ServicesOfRestTests extends TestBase {

  @Test
  public void servicesOfRestTest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");

     // завтраки/ Если выбран то елемент остается выбраным
    if(app.getMainPageHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services1[checked]"))) {

    } else {
      app.getMainPageHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services1']"));
    }
    // ланчи/ Если выбран то елемент остается выбраным
    if(app.getMainPageHelper().elementPresent(By.cssSelector("div.opt.hint-services input#services2[checked]"))){

    } else {
      app.getMainPageHelper().click(By.cssSelector("div.opt.hint-services div.input-outer li > label[for='services2']"));
    }

    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
/*
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверка по типу кухни ресторана на страничке ресторана
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.wrap div.cafe-kitchen > p")), "BBQ, Smoked food");

    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    Thread.sleep(2000);
    // проверяем в админке на главной страничке ресторана проверяем что типы кухонь такие как перед этим записали
    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div.input-outer.hint-cuisine span.selection li.select2-selection__choice:first-of-type"),"title"), restEditDataOfMainPageAllField.getTypeOfCuisine());
    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div.input-outer.hint-cuisine span.selection li.select2-selection__choice:nth-of-type(2)"),"title"), "Smoked food");
  */}
}
