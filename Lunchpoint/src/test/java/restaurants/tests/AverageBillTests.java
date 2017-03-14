package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 14.03.2017.
 */
public class AverageBillTests extends TestBase {

  @Test
  public void editAverageBill() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().
            getAddressMainUrl(String.format("manager/restaurants/update?id=%s", MainPgUtils.restEditDataOfMainPg.getId()));
    app.getMainPageHelper().choiceRadiobuttonAvgPriceOfRestMainPage();
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
    app.getAdminHelper().refreshPage();
    Thread.sleep(3000);
    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div.Slider.ranger label[for='pos0']"),"data-text"), "<100 грн");
  }

  @Test
  public void averageBillInSiteLs() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector(String.format("div[lng='%s'] > div.content div.min-bill.clear > span",
                    MainPgUtils.restEditDataOfMainPg.getLng()))), "<100 грн");

  }

  @Test
  public void averageBillOnSitePg() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper()
            .click(By.cssSelector(String.format("div[lng='%s'] div.title", MainPgUtils.restEditDataOfMainPg.getLng())));
    // проверка по среднему чеку
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.wrap div.min-bill.clear > span")), "<100 грн");
  }
}
