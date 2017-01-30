package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 30.01.2017.
 */
public class SiteRestAssertWithMainPageTest extends TestBase {

  @Test(enabled = true)
  public void testSiteRestAssertWithMainPage() throws InterruptedException {
    String city = "Київ";
    String nameOfRest = "Slava";
    app.getSiteHelper().enterCity(city);
    app.getSiteHelper().enterRestName(nameOfRest);
    app.getSiteHelper().searchRestButton();
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] > div.content > div.type")),"Бистро");
  }

}
