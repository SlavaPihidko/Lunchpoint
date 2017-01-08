package restaurants.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import restaurants.appmanager.ApplicationManager;

/**
 * Created by Slava on 08.01.2017.
 */
public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
