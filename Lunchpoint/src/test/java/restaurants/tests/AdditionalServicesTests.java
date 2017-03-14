package restaurants.tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 08.03.2017.
 */
public class AdditionalServicesTests extends TestBase {

  @Test
  public void additionalServicesTest() throws InterruptedException {

    app.getAdminHelper().getAddressMainUrl("slavkotest123");
    Thread.sleep(2000);
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.features-outer div.features div[dir='ltr'] > li.wi-fi:first-of-type")),
            MainPgUtils.restEditDataOfMainPg.getAdditionalServiceOfRest());
  }
}
