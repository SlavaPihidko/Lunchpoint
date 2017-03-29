package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 03.03.2017.
 */
public class IndexOfRestTests extends TestBase {
  @Test
  public void emailsOfRestTests() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    // проверяем записалось ли то значение индекса которое вводили
    assertEquals(app.getMainPgHelper()
            .attribute(By.id("restIndex"),"value"), restEditDataOfMainPg.getIndexOfRest());
  }
}
