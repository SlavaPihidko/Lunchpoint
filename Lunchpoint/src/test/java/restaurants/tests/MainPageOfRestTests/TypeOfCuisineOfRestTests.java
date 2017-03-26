package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 07.03.2017.
 */
public class TypeOfCuisineOfRestTests extends TestBase {

  @Test
  public void typeOfCuisineOfRestTest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);

    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверка по типу кухни ресторана на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.wrap div.cafe-kitchen > p")), "BBQ, Smoked food");

    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    Thread.sleep(2000);
    // проверяем в админке на главной страничке ресторана проверяем что типы кухонь такие как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.input-outer.hint-cuisine span.selection li.select2-selection__choice:first-of-type"),"title"), MainPgUtils.restEditDataOfMainPg.getTypeOfCuisine());
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.input-outer.hint-cuisine span.selection li.select2-selection__choice:nth-of-type(2)"),"title"), "Smoked food");
  }
}
