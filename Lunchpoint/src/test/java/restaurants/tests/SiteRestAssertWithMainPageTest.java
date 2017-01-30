package restaurants.tests;

import org.testng.annotations.Test;

/**
 * Created by Slava on 30.01.2017.
 */
public class SiteRestAssertWithMainPageTest extends TestBase {

  @Test(enabled = true)
  public void testSiteRestAssertWithMainPage(){
    String city = "Київ";
    String nameOfRest = "Slava";
    app.getSiteHelper().enterCity(city);
    app.getSiteHelper().enterRestName(nameOfRest);
    app.getSiteHelper().searchRestButton();
  }

}
