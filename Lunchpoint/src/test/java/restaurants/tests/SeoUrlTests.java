package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.model.RestDataOfMainPage;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 23.02.2017.
 */
public class SeoUrlTests extends TestBase {

  @Test
  public void seoUrlTest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest("Slava");
    RestDataOfMainPage restDataOfMainPageAllField = new RestDataOfMainPage(
            30.39818839999998,
            2219,
            "MainImgFirst.jpg",
            "Slava",
            "вул.Жолудєва 8",
            "slavkotest1234",
            "Здесь описание ресторана",
            "вулиця Жолудєва, 8, Київ, Украина, 03134",
            "50.4167724,30.39818839999998",
            "03134",
            "0632223344",
            "optibayukraine@gmail.com",
            "slava17puh123@gmail.com",
            "my_site123.com",
            "my_fb.com",
            "my_instagram.com",
            "my_twitter.com",
            "Aroma espresso bars",
            "Бистро",
            "BBQ",
            "Happy hours",
            "Cork-fee");
    app.getMainPgHelper().enterNameOfRestMainPage(restDataOfMainPageAllField);
    app.getMainPgHelper().enterSeoUrlOfRestMainPage(restDataOfMainPageAllField);
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
    app.getAdminHelper().getAddressMainUrl("slavkotest1234");
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.cafe-name")), restDataOfMainPageAllField.getNameOfRest());

  }
}
