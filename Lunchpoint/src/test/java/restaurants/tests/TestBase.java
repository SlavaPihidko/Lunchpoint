package restaurants.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import restaurants.appmanager.ApplicationManager;

/**
 * Created by Slava on 08.01.2017.
 */
public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
  String usernameAdmin = "manager@lunch.ua";
  String passwordAdmin = "2CDTx8Wz";
  String usernameGuest = "slava17puh999@gmail.com";
  String passwordGuest = "bigdig2";

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }


}
