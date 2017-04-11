package restaurants.tests.MainPageOfRestTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.*;

/**
 * Created by Slava on 08.03.2017.
 */
public class AdditionalServicesTests extends TestBase {

  @Test
  public void additionalServicesTest() throws InterruptedException {

    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoOfRest());
    Thread.sleep(2000);
    // проверка на страничке ресторана дополнительные услуги
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.features-outer div.features div[dir='ltr'] > li.wi-fi:first-of-type")),
            restEditDataOfMainPg.getAdditionalServiceOfRest());
  }
}
