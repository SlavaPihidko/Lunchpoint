package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.MainPgUtils;
import restaurants.utils.VariantsOfNameUtils;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.*;
import static restaurants.utils.VariantsOfNameUtils.*;

/**
 * Created by Slava on 29.03.2017.
 */
public class VariantsOfNameTests extends TestBase {

  @Test(priority = 1)
  public void testViewVariantsOfName() throws InterruptedException {

    if(app.getMainPgHelper().elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"))) {
      app.getSessionHelper().login(usernameAdmin, passwordAdmin);
      Thread.sleep(1000);
    }

    app.getAdminHelper().getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    Thread.sleep(2000);
    // проверяем в админке на главной страничке ресторана что варианты названий сохранились
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.input-outer span.select2-selection.select2-selection--multiple li.select2-selection__choice:first-of-type"),"title"), variantsOfName.getVarName1());
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.input-outer span.select2-selection.select2-selection--multiple li.select2-selection__choice:nth-of-type(2)"),"title"), variantsOfName.getVarName2());
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.input-outer span.select2-selection.select2-selection--multiple li.select2-selection__choice:nth-of-type(3)"),"title"), variantsOfName.getVarName3());
  }

  @Test(priority = 2)
  public void testDeleteNameOfVariant() throws InterruptedException {

    if(app.getMainPgHelper().elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"))) {
      app.getSessionHelper().login(usernameAdmin, passwordAdmin);
      Thread.sleep(1000);
    }

    app.getAdminHelper().getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    Thread.sleep(2000);

    String nextName = app.getMainPgHelper()
            .attribute(By.cssSelector("div.input-outer span.select2-selection.select2-selection--multiple li.select2-selection__choice:nth-of-type(3)"),"title");

    app.getMainPgHelper().deleteOfNameVariant(2);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
    app.getAdminHelper().refreshPg();
// Проверяем что название которое ишло после елемента которое удалили, стало его порядковым номером
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.input-outer span.select2-selection.select2-selection--multiple li.select2-selection__choice:nth-of-type(2)"),"title"), nextName);
  }

  @Test(priority = 3)
  public void returnToEditVariantsOfNameState() throws InterruptedException {

      if(app.getMainPgHelper().elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"))) {
        app.getSessionHelper().login(usernameAdmin, passwordAdmin);
        Thread.sleep(1000);
      }
      app.getAdminHelper().getAddressMainUrl(String.format("manager/restaurants/update?id=%s",restEditDataOfMainPg.getId()));
      app.getMainPgHelper().enterVariantsOfNameOfRestMainPage(variantsOfName);
      app.getMainPgHelper().saveRestMainPg();
      app.getMainPgHelper().confirmChangesOfRestMainPg();
  }
}
