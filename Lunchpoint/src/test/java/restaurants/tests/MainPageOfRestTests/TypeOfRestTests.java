package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

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
            .text(By.cssSelector(String
                    .format("div[lng='%s'] > div.content > div.type", restEditDataOfMainPg.getLng()))),"Бистро");

    app.getSiteHelper()
            .click(By.cssSelector(String.format("div[lng='%s'] div.title", restEditDataOfMainPg.getLng())));
    // проверка по типу ресторана на страничке ресторана
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.wrap div.cafe-type > p")), "Бистро");

    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    // проверяем в админке на главной страничке ресторана в поле ввода названия ресторана
    // что тип такой как перед этим записали
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("span#select2-restType-container")), restEditDataOfMainPg.getTypeOfRest());
    // проверяем в админке на главной страничке ресторана в шапке
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.row-footer.clear div.cafe-type >p")), restEditDataOfMainPg.getTypeOfRest());
  }
}
