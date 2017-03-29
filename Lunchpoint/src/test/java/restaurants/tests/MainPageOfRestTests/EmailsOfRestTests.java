package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 02.03.2017.
 */
public class EmailsOfRestTests extends TestBase {

  @Test
  public void emailsOfRestTests() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
  // проверяем записалось ли то значение емейла которое вводили
    assertEquals(app.getMainPgHelper()
            .attribute(By.name("Restaurants[email]"),"value"), restEditDataOfMainPg.getEmailOfRest());
    // проверяем записалось ли то значение емейла для букинга которое вводили
    assertEquals(app.getMainPgHelper()
            .attribute(By.name("Restaurants[booking_email]"),"value"), restEditDataOfMainPg.getBookingEmailOfRest());

  }
}