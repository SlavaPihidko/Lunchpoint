package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.AvgBillUtils;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 14.03.2017.
 */
public class AverageBillTests extends TestBase {
  private String town = "Київ";
  private String nameOrRest = "Slava";

  @Test
  public void editAverageBill() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().
            getAddressMainUrl(String.format("manager/restaurants/update?id=%s", MainPgUtils.restEditDataOfMainPg.getId()));
    app.getMainPgHelper().choiceRadiobutAvgPriceOfRestMainPg();
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
    app.getAdminHelper().refreshPg();
    Thread.sleep(3000);
    String avgBillFromMainPg = app.getMainPgHelper()
            .attribute(By.cssSelector("div.Slider.ranger label[for='pos0']"),"data-text");
    assertEquals(avgBillFromMainPg, AvgBillUtils.avgBillData.getAvgSum1());
  }

  @Test
  public void averageBillInSiteLsTest() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite(town,nameOrRest);
    String avgBillFromListPg = app.getMainPgHelper()
            .text(By.cssSelector(String.format("div[lng='%s'] > div.content div.min-bill.clear > span",
                    MainPgUtils.restEditDataOfMainPg.getLng())));
    assertEquals(avgBillFromListPg, AvgBillUtils.avgBillData.getAvgSum1());
  }

  @Test
  public void averageBillOnSitePgTest() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite(town,nameOrRest);
    app.getSiteHelper()
            .click(By.cssSelector(String.format("div[lng='%s'] div.title", MainPgUtils.restEditDataOfMainPg.getLng())));
    // проверка по среднему чеку
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.wrap div.min-bill.clear > span")), AvgBillUtils.avgBillData.getAvgSum1());
  }
}
