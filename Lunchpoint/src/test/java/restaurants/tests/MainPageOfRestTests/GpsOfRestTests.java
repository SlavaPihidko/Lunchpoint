package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 29.03.2017.
 */
public class GpsOfRestTests extends TestBase {

    @Test
    public void gpsTest() throws InterruptedException {
      app.getSessionHelper().login(usernameAdmin, passwordAdmin);
      Thread.sleep(2000);

      app.getAdminHelper().getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
      Thread.sleep(2000);
      // Проверяем что координаты изменились
      assertEquals(app.getMainPgHelper()
              .attribute(By.id("restaurants-latlng"),"value"),restEditDataOfMainPg.getGpsOfRest());
  }

}
