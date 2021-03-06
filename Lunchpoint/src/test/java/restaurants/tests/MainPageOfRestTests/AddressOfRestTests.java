package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.*;

/**
 * Created by Slava on 01.03.2017.
 */
public class AddressOfRestTests extends TestBase {
  private String city = "Київ";
  private String nameOfRest = "Slava";

  @Test(priority = 1)
  public void addressOfRestMainPgTest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().
            getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    // проверяем в админке на главной страничке ресторана в поле адреса ресторана
    // что адрес такой как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.id("restAddress"), "value"), restEditDataOfMainPg.getAddressOfRest());
  }

  @Test(priority = 2)
  public void addressOfRestSiteLsTest() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite(city, nameOfRest);
    // проверяем на сайте в списке что адрес ресторана такой как ему изменили
    String addressFromList = app.getMainPgHelper().text(By.cssSelector(String.format("div[lng='%s'] div.address",
            restEditDataOfMainPg.getLng())));
    assertEquals(addressFromList, restEditDataOfMainPg.getAddressOfRest());
  }

@Test(priority = 3)
    public void addressOfRestPageLsTest() throws InterruptedException {
  app.getSiteHelper().searchRestOnTheSite(city, nameOfRest);
    app.getSiteHelper().click(By.cssSelector(String.format("div[lng='%s'] div.title",
            restEditDataOfMainPg.getLng())));
    // проверяем на сайте на страничке ресторана что адрес ресторана такой как ему изменили
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-info > div.addr > p")), restEditDataOfMainPg.getAddressOfRest());

  }
}
