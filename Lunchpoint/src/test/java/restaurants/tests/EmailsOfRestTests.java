package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
    assertEquals(app.getMainPageHelper()
            .attribute(By.name("Restaurants[email]"),"value"),restEditDataOfMainPageAllField.getEmailOfRest());
    // проверяем записалось ли то значение емейла для букинга которое вводили
    assertEquals(app.getMainPageHelper()
            .attribute(By.name("Restaurants[booking_email]"),"value"),restEditDataOfMainPageAllField.getBookingEmailOfRest());

  }
}