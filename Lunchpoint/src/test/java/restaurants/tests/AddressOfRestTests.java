package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 01.03.2017.
 */
public class AddressOfRestTests extends TestBase {

  @Test
  public void addressOfRestTest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);

    app.getSiteHelper().searchRestOnTheSite();
    // проверяем на сайте в списке что имя ресторана такое как ему изменили
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] div.address")), MainPgUtils.restEditDataOfMainPg.getAddressOfRest()) ;
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверяем на сайте на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-info > div.addr > p")), MainPgUtils.restEditDataOfMainPg.getAddressOfRest());

    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    // проверяем в админке на главной страничке ресторана в поле ввода названия ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.id("restAddress"),"value"), MainPgUtils.restEditDataOfMainPg.getAddressOfRest());
  }
}
