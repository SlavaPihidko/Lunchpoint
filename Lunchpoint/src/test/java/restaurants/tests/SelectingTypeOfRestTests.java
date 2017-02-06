package restaurants.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import restaurants.model.RestDataOfSiteList;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 06.02.2017.
 */
public class SelectingTypeOfRestTests extends TestBase {

  @Test
  public void testSelectingTypeOfRest() throws InterruptedException {
    app.getSiteHelper().choiceTheTown("Харків");
    // Выбор Типа Бар
    app.getSiteHelper().choiceTypeOfRest("type1");
    List<RestDataOfSiteList> objectWithOnlyTypeFromWeb = app.getSiteHelper().getRestList();

    List<RestDataOfSiteList> objectWithHardType = new ArrayList<RestDataOfSiteList>();
    for(int i=0; i<objectWithOnlyTypeFromWeb.size();i++) {
      String typeOfRest = "Бар";
      RestDataOfSiteList rest = new RestDataOfSiteList(typeOfRest);
      objectWithHardType.add(rest);
    }

    for(int i=0; i<objectWithOnlyTypeFromWeb.size();i++) {
      assertEquals(objectWithOnlyTypeFromWeb.get(i), objectWithHardType.get(i));}
  }
}
