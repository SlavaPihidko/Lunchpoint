package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
    assertEquals(app.getMainPageHelper()
            .attribute(By.id("restIndex"),"value"),restEditDataOfMainPageAllField.getIndexOfRest());
  }
}
