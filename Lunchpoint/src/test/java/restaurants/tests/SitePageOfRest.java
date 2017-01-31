package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 30.01.2017.
 */
public class SitePageOfRest extends TestBase {

  @Test(enabled = true)
  public void testSitePageOfRest() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.wrap div.cafe-type > p")), "Бистро"); // проверка по типу ресторана
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.wrap div.cafe-name > h1")), "Slava test selenium"); // проверка по названию ресторана
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.wrap div.cafe-kitchen > p")), "BBQ"); // проверка по типу кухни
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.cafe-info > div.addr > p")), "вул.Жолудєва 8"); // проверка по типу улице
   // assertEquals(app.getMainPageHelper().text(By.cssSelector("div.cafe-info > div.tel > p")), ""); // проверка по ном. тел
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.wrap div.min-bill.clear > span")), "<100 грн"); // проверка по среднему чеку
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.cafe-info > div.links > a.url")), "www"); // проверка на присутствие иконки сайта ресторана и текста в ней www
    assertEquals(java.util.Optional.of(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.cafe-info > div.links > a.url"))), java.util.Optional.of(true)); // проверка на присутствие иконки сайта ресторана



  }

}
