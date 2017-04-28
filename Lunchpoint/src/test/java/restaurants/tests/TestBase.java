package restaurants.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import restaurants.appmanager.ApplicationManager;
import restaurants.tests.MainPageOfRestTests.NameOfRestTests;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

@Listeners(MyTestListener.class)
public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  public static ApplicationManager app;
  protected String usernameAdmin = "manager@lunch.ua";
  protected String passwordAdmin = "2CDTx8Wz";
  protected String usernameGuest = "slava17puh999@gmail.com";
  protected String passwordGuest = "bigdig2";

  @BeforeSuite
  public void setUp(ITestContext context) throws Exception {
    app  = new ApplicationManager(BrowserType.CHROME);
    app.init();
    context.setAttribute("app", app);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p){
    logger.info("Start test "+ m.getName() + " with parameters "+ Arrays.asList(p));

  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("Stop test "+ m.getName());
  }

}
