package restaurants.tests;

import org.testng.annotations.Test;
import restaurants.model.RestDataOfSiteList;

import java.util.List;

/**
 * Created by Slava on 06.02.2017.
 */
public class SelectingTypeOfRestTests extends TestBase {

  @Test
  public void testSelectingTypeOfRest() throws InterruptedException {
    app.getSiteHelper().choiceTheTown("Харків");
    //app.getSiteHelper().scroll("scrollBy(0,100)");
    //app.getSiteHelper().goToRestTab();
    // Выбор Типа Бар
    app.getSiteHelper().choiceTypeOfRest("type1");
    List<RestDataOfSiteList> before = app.getSiteHelper().getRestList();
  }
}
