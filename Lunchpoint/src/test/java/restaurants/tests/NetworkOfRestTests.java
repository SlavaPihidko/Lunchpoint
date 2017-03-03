package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 03.03.2017.
 */
public class NetworkOfRestTests extends TestBase {
  @Test
  public void emailsOfRestTests() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    // проверяем записалось ли то значение сети ресторана которое выбрали
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.input-outer.rest-net span#select2-restNet-container")),restEditDataOfMainPageAllField.getNetworkOfRest());
  }
}
