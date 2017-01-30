package restaurants.tests;

import org.testng.annotations.Test;

/**
 * Created by Slava on 30.01.2017.
 */
public class SitePageOfRest extends TestBase {

  @Test(enabled = true)
  public void testSitePageOfRest() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    app.getSiteRestPageHelper().goToRestPage();

  }

}
