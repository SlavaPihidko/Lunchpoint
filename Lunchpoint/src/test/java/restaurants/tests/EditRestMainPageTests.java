package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.model.RestDataOfMainPage;

import static org.testng.Assert.assertEquals;

public class EditRestMainPageTests extends TestBase {

  @Test(enabled = false)
  public void testEditRestMainPageNameAddress() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
    RestDataOfMainPage restDataOfMainPageNameAddress = new RestDataOfMainPage("Slava test selenium", "вул.Жолудєва 8");
    app.getMainPageHelper().fillRestFieldOnMainPageNameAddress(restDataOfMainPageNameAddress);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
    app.getMainPageHelper().gotoTabRestInAdminPanel();
    app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", "Slava test selenium");
    // нужно заполнить все поля на главной странице, позже открыть код тот что ниже
    app.getAdminHelper().gotoAddressFieldInAdminPanel();//
    assertEquals(app.getMainPageHelper().text(By.xpath("//tr[@data-key]/td[2]/a")), "Slava test selenium");// проверка имени
    assertEquals(app.getMainPageHelper().text(By.xpath("//tr[@data-key]/td[3]/a")),"вул.Жолудєва 8");// проверка адреса
  }

  @Test(enabled = true)
public void testEditRestMainPageAllField() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();

    app.getMainPageHelper().fillAllOfRestFieldOnMainPage(restEditDataOfMainPageAllField);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
     }
}

