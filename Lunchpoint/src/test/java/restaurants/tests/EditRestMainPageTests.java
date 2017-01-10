package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.model.RestDataOfMainPage;

import static org.testng.Assert.assertEquals;

public class EditRestMainPageTests extends TestBase {

  @Test
  public void testEditRestaurantMainPage() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    app.getMainPageHelper().fillRestFieldOnMainPage(new RestDataOfMainPage("Slava test selenium", "вул.Жолудєва 8"));
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
    app.getMainPageHelper().gotoTabRestInAdminPanel();
    app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", "slava");
    // нужно заполнить все поля на главной странице, позже открыть код тот что ниже
    //app.getAdminHelper().gotoAddressFieldInAdminPanel();//
    assertEquals(app.getMainPageHelper().text(By.xpath("//tr[@data-key='40357']/td[2]/a")), "Slava test selenium");// проверка имени
    assertEquals(app.getMainPageHelper().text(By.xpath("//tr[@data-key='40357']/td[3]/a")),"вул.Жолудєва 8");// проверка адреса

  }
}
