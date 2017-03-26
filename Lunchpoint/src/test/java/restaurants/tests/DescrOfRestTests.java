package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 26.02.2017.
 */
public class DescrOfRestTests extends TestBase {

  @Test
  public void descrOfRestTests() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);

    app.getSiteHelper().searchRestOnTheSite("Київ","Slava");
    app.getSiteHelper()
            .click(By.cssSelector(String.format("div[lng='%s'] div.title", MainPgUtils.restEditDataOfMainPg.getLng())));
    // проверяем на сайте на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.description div.text > p")), MainPgUtils.restEditDataOfMainPg.getDescriptionOfRest());

    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", MainPgUtils.restEditDataOfMainPg.getId()));
    // проверяем в админке на главной страничке ресторана в поле ввода описания ресторана что описание такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.name("RestaurantsLang[description]"),"value"), MainPgUtils.restEditDataOfMainPg.getDescriptionOfRest());
  }
}
