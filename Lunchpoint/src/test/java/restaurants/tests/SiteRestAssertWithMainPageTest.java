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
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] a[href='/kharkiv/slavkotest123'] > div.title")), "Slava test selenium");
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] > div.content > div.address")), "вул.Жолудєва 8");
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] > div.content div.min-bill.clear > span")), "<100 грн");
  }

}
