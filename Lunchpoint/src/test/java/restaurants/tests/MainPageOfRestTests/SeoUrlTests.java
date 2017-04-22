package restaurants.tests.MainPageOfRestTests;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;

import static org.testng.Assert.assertEquals;
//import static restaurants.utils.MainPgUtils.restDataOfMainPageAllField;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 23.02.2017.
 */
public class SeoUrlTests extends TestBase {

  @Test(enabled = true)
  public void seoUrlTest() throws InterruptedException {

    if(app == null ) {
      System.out.println("app equals Null");
    } else {
      System.out.println("app is not Null");
    }
    System.out.println(usernameAdmin);
    System.out.println(passwordAdmin);

    if(app.getSessionHelper() == null) {
      System.out.println("app.getSessionHelper() equals Null");
    } else {
      System.out.println("app.getSessionHelper() is not Null");
    }

    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().getAddressMainUrl(restEditDataOfMainPg.getSeoOfRest());
    // Проверка на страничке ресторана что имя ресторана соответствует переходу по ЮРЛу
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")), restEditDataOfMainPg.getNameOfRest());

    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    // Проверка в админке в поле SEO url
    assertEquals(app.getMainPgHelper()
            .attribute(By.id("edit_seo_url"), "value" ),restEditDataOfMainPg.getSeoOfRest());
  }
}
