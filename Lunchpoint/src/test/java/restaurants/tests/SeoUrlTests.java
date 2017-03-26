package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.model.RestDataOfMainPage;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.restDataOfMainPageAllField;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 23.02.2017.
 */
public class SeoUrlTests extends TestBase {

  @Test
  public void seoUrlTest() throws InterruptedException {

    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoUrlOfRest());
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")), restEditDataOfMainPg.getNameOfRest());
  }
}
