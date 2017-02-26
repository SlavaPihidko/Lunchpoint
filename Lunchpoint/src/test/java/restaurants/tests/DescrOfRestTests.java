package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 26.02.2017.
 */
public class DescrOfRestTests extends TestBase {

  @Test
  public void descrOfRestTests() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);

    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверяем на сайте на страничке ресторана
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.description div.text > p")), restDataOfMainPageAllField.getDescriptionOfRest());

    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    // проверяем в админке на главной страничке ресторана в поле ввода названия ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPageHelper()
            .attribute(By.name("RestaurantsLang[description]"),"value"), restDataOfMainPageAllField.getDescriptionOfRest());
  }
}
