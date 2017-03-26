package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.model.RestDataOfMainPage;
import restaurants.tests.TestBase;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.restDataOfMainPageAllField;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 16.02.2017.
 */
public class NameOfRestTests extends TestBase {

  @Test(enabled = true)
  public void testViewNameOfRest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest("Slava");
    app.getMainPgHelper().enterNameOfRestMainPage(restEditDataOfMainPg);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite();
    // проверяем на сайте в списке что имя ресторана такое как ему изменили
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] div.title")),restEditDataOfMainPg.getNameOfRest()) ;
    app.getSiteHelper()
            .click(By.cssSelector(String.format("div[lng='%s'] div.title", restEditDataOfMainPg.getLng())));
    // проверяем на сайте на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")), restEditDataOfMainPg.getNameOfRest());

    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    // проверяем в админке на главной страничке ресторана в поле ввода названия ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.id("edit_restName"),"value"), restEditDataOfMainPg.getNameOfRest());
    // проверяем в админке на главной страничке ресторана в шапке ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")),restEditDataOfMainPg.getNameOfRest());
  }



  @Test(enabled = false)
  public void testViewAllNamesOfRest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    String[] nameDataOfRest = {"slava",
            "slava ltd",
            "фотограф",
            "abc",
            "слава ?/\\|,.!@#$%^&*()-=+)_",
            "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa",
            "slava123"};
    // вконце создаем с именем slava что бы вернуть в состояние по умолчанию
    String[] nameDataOfRestNegative = {"aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa1", "slava"};
    for (int i = 0; i < nameDataOfRest.length; i++) {
      app.getAdminHelper().getAddressMainUrl();
      app.getSiteHelper().enterRestName(nameDataOfRest[i]);
      app.getSiteHelper().searchRestButton();
      // проверяем на сайте в списке что имя ресторана такое как ему изменили
      assertEquals(app.getMainPgHelper()
              .text(By.cssSelector("div[lng='30.39818839999998'] div.title")),nameDataOfRest[i]) ;
      app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
      // проверяем на сайте на страничке ресторана
      assertEquals(app.getMainPgHelper()
              .text(By.cssSelector("div.cafe-name")), nameDataOfRest[i]);
      // переход в админку
      app.getMainPgHelper().click(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.user-profile-link"));
      app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", nameDataOfRest[i]);
      app.getAdminHelper().gotoAddressFieldInAdminPanel();
      // Проверяем на налие ресторана с указаным id
      assertEquals(app.getAdminHelper()
              .elementPresent(By.cssSelector("a[href='/manager/restaurants/update?id=2219']")), true);
      app.getAdminHelper().gotoEditRestInAdminPanel();
      // проверяем в админке на главной страничке ресторана в поле ввода названия ресторана что имя такое как перед этим записали
      assertEquals(app.getMainPgHelper()
              .attribute(By.id("edit_restName"),"value"), nameDataOfRest[i]);
      // проверяем в админке на главной страничке ресторана в шапке ресторана что имя такое как перед этим записали
      assertEquals(app.getMainPgHelper()
              .text(By.cssSelector("div.cafe-name")),nameDataOfRest[i]);
      // делаем цикл по массиву
      if (i != nameDataOfRest.length - 1) {
        app.getMainPgHelper().fillNameOfRest(nameDataOfRest, i + 1);
        app.getMainPgHelper().saveRestMainPg();
        app.getMainPgHelper().confirmChangesOfRestMainPg();
        app.getMainPgHelper().gotoTabRestInAdminPanel();
      } else {
        app.getMainPgHelper().fillNameOfRest(nameDataOfRest, i);
        app.getMainPgHelper().saveRestMainPg();
        app.getMainPgHelper().confirmChangesOfRestMainPg();
        app.getMainPgHelper().gotoTabRestInAdminPanel();
      }
    }
    app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", "slava123");
    app.getAdminHelper().gotoAddressFieldInAdminPanel();
    // делаем цикл для ввода негативных значений
    for (int y = 0; y < nameDataOfRestNegative.length; y++) {
      if(y!=0) {
        app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa");
        app.getAdminHelper().gotoAddressFieldInAdminPanel();
      }
        app.getAdminHelper().gotoEditRestInAdminPanel();
        app.getMainPgHelper().fillNameOfRest(nameDataOfRestNegative, y);
        app.getMainPgHelper().saveRestMainPg();
        app.getMainPgHelper().confirmChangesOfRestMainPg();
        app.getMainPgHelper().gotoTabRestInAdminPanel();
       if(y != nameDataOfRestNegative.length - 1) {
        app.getAdminHelper().searchRestInAdminPanel("RestaurantsLangSearch[name]", "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa1");
        app.getAdminHelper().gotoAddressFieldInAdminPanel();
         // проверяем что после ввода негативного значения ничего не найдено
        assertEquals(app.getAdminHelper()
                .text(By.cssSelector("table.table.table-striped.table-bordered div.empty")), "Ничего не найдено.");
      }
    }
  }


}
