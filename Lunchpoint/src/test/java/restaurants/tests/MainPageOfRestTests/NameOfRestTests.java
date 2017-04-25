package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.PackageUtils;
import restaurants.model.RestDataOfMainPage;
import restaurants.tests.TestBase;

import static org.testng.Assert.assertEquals;
//import static restaurants.utils.MainPgUtils.restDataOfMainPageAllField;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 16.02.2017.
 */
public class NameOfRestTests extends TestBase {

  private String[] nameDataOfRest = {
            "s",
            "фотограф",
            "?/\\|,.!@#$%^&*()-=+)_",
            "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa"
  };

  private String[] nameDataOfRestNegative = {
          "",
          "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa1"
  };


  @Test(priority = 1)
  public void testViewNameOfRest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(1000);
    app.getSiteHelper().searchRestOnTheSite("Київ","Slava");
    // проверяем на сайте в списке что имя ресторана такое как ему изменили
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector(String.format("div[lng='%s'] div.title",restEditDataOfMainPg.getLng()))),restEditDataOfMainPg.getNameOfRest()) ;
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

  @Test(priority = 2)
  public void testPosMinSymbols() throws InterruptedException {
//    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
//    Thread.sleep(1000);
    app.getMainPgHelper().changeTheNameOfRest(nameDataOfRest[0]);
    app.getAdminHelper().refreshPg();
    Thread.sleep(1000);

    // проверяем в админке на главной страничке ресторана в поле ввода названия ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.id("edit_restName"),"value"), nameDataOfRest[0]);
    // проверяем в админке на главной страничке ресторана в шапке ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")),nameDataOfRest[0]);

    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoOfRest());
    // проверяем на сайте на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")), nameDataOfRest[0]);
  }

  @Test(priority = 3)
  public void testPosKirillSymbols() throws InterruptedException {
//    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
//    Thread.sleep(1000);
    app.getMainPgHelper().changeTheNameOfRest(nameDataOfRest[1]);
    app.getAdminHelper().refreshPg();
    Thread.sleep(1000);

    // проверяем в админке на главной страничке ресторана в поле ввода названия ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.id("edit_restName"),"value"), nameDataOfRest[1]);
    // проверяем в админке на главной страничке ресторана в шапке ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")),nameDataOfRest[1]);

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite("Київ",nameDataOfRest[1]);
    // проверяем на сайте в списке что имя ресторана такое как ему изменили
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector(String.format("div[lng='%s'] div.title",restEditDataOfMainPg.getLng()))),nameDataOfRest[1]) ;

    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoOfRest());
    // проверяем на сайте на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")), nameDataOfRest[1]);
  }

  @Test(priority = 4)
  public void testPosSpecSymbols() throws InterruptedException {
//    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
//    Thread.sleep(1000);
    app.getMainPgHelper().changeTheNameOfRest(nameDataOfRest[2]);
    app.getAdminHelper().refreshPg();
    Thread.sleep(1000);

    // проверяем в админке на главной страничке ресторана в поле ввода названия ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.id("edit_restName"),"value"), nameDataOfRest[2]);
    // проверяем в админке на главной страничке ресторана в шапке ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")),nameDataOfRest[2]);

    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoOfRest());
    // проверяем на сайте на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")), nameDataOfRest[2]);
  }

  @Test(priority = 5)
  public void testPosMaxSymbols() throws InterruptedException {
//    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
//    Thread.sleep(1000);
    app.getMainPgHelper().changeTheNameOfRest(nameDataOfRest[3]);
    app.getAdminHelper().refreshPg();
    Thread.sleep(1000);

    // проверяем в админке на главной страничке ресторана в поле ввода названия ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.id("edit_restName"),"value"), nameDataOfRest[3]);
    // проверяем в админке на главной страничке ресторана в шапке ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")),nameDataOfRest[3]);

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite("Київ",nameDataOfRest[3]);
    // проверяем на сайте в списке что имя ресторана такое как ему изменили
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector(String.format("div[lng='%s'] div.title",restEditDataOfMainPg.getLng()))),nameDataOfRest[3]) ;

    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoOfRest());
    // проверяем на сайте на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")), nameDataOfRest[3]);
  }


  @Test(priority = 7)
  public void testNegWithoutSymbols() throws InterruptedException {
//    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
//    Thread.sleep(1000);
    app.getAdminHelper().getAddressMainUrl(String.format("manager/restaurants/update?id=%s",restEditDataOfMainPg.getId()));
    app.getMainPgHelper().enterNameOfRestMainPage(nameDataOfRestNegative[0]);
    app.getMainPgHelper().saveRestMainPg();
    Thread.sleep(500);

    // проверяем в админке на главной страничке ресторана что вывелось error-msg
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.input-outer.has-error div.error-msg")), "Укажите название ресторана");
  }

  @Test(priority = 8)
  public void testNegMoreSymbols() throws InterruptedException {
//    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
//    Thread.sleep(1000);
    app.getAdminHelper().getAddressMainUrl(String.format("manager/restaurants/update?id=%s",restEditDataOfMainPg.getId()));
    app.getMainPgHelper().enterNameOfRestMainPage(nameDataOfRestNegative[1]);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
    Thread.sleep(500);
    String positivePart = nameDataOfRestNegative[1].substring(0,46);
    System.out.println(positivePart.length());

    // проверяем в админке на главной страничке ресторана что сохранилось лишь первые 46 символов
    assertEquals(app.getMainPgHelper()
           .attribute(By.id("edit_restName"),"value"), positivePart);
  }

  @Test(priority = 9)
  public void returnToEditNameState() throws InterruptedException {
//    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
//    Thread.sleep(1000);
    app.getAdminHelper().getAddressMainUrl(String.format("manager/restaurants/update?id=%s",restEditDataOfMainPg.getId()));
    app.getMainPgHelper().enterNameOfRestMainPage(restEditDataOfMainPg.getNameOfRest());
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
  }

  @Test(enabled = false)
  public void testViewAllNamesOfRest() throws InterruptedException {
   /* String[] nameDataOfRest = {
            "s",
            "фотограф",
            "?/\\|,.!@#$%^&*()-=+)_",
            "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa",
    };*/
    // вконце создаем с именем slava test selenium что бы вернуть в состояние по умолчанию
//    String[] nameDataOfRestNegative = {
//            "",
//            "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa1",
//            "slava test selenium"
//    };
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(1000);
    //app.getAdminHelper().gotoAdminPanel();
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
