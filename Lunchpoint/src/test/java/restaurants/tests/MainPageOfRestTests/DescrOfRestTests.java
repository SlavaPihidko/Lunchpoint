package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.*;

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
            .click(By.cssSelector(String.format("div[lng='%s'] div.title", restEditDataOfMainPg.getLng())));
    // проверяем на сайте на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.description div.text > p")), restEditDataOfMainPg.getDescriptionOfRest());

    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    // проверяем в админке на главной страничке ресторана в поле ввода описания ресторана что описание такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.name("RestaurantsLang[description]"),"value"), restEditDataOfMainPg.getDescriptionOfRest());
  }
}
