package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 07.03.2017.
 */
public class TypeOfRestTests extends TestBase {

  @Test
  public void typeOfRestTest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);

    app.getSiteHelper().searchRestOnTheSite();
    // проверяем на сайте в списке что тип ресторана такой как ему изменили
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] > div.content > div.type")),"Бистро");
    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверка по типу ресторана на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.wrap div.cafe-type > p")), "Бистро");

    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    // проверяем в админке на главной страничке ресторана в поле ввода названия ресторана что имя такое как перед этим записали
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("span#select2-restType-container")), MainPgUtils.restEditDataOfMainPg.getTypeOfRest());
  }
}
