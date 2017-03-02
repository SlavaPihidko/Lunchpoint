package restaurants.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import restaurants.appmanager.ApplicationManager;
import restaurants.model.RestDataOfMainPage;

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

  RestDataOfMainPage restDataOfMainPageAllField = new RestDataOfMainPage(
          "Slava test123",
          "вул.Академика Белецкого, 9а",
          "viacheslav",
          "Здесь описание ресторана тест создание ресторана",
          "9A, вулиця Академіка Білецького, 9А, Київ, Украина",
          "50.430206,30.417633000000023",
          "03126",
          "0671112299",
          "create123@gmail.com",
          "test123@gmail.com",
          "my_first_site.com",
          "my_first_fb.com",
          "my_first_instagram.com",
          "my_first_twitter.com",
          "Carte Blanche",
          "Винотека",
          "Авторская",
          "Еда с собой",
          "Бильярд");

  RestDataOfMainPage restEditDataOfMainPageAllField = new RestDataOfMainPage(
          "Slava test selenium",
          "вул.Жолудєва 8",
          "slavkotest123",
          "Здесь описание ресторана",
          "вулиця Жолудєва, 8, Київ, Украина, 03134",
          "50.4167724,30.39818839999998",
          "03134",
          "0632223344",
          "optibayukraine@gmail.com",
          "slava17puh123@gmail.com",
          "my_site123.com",
          "my_fb.com",
          "my_instagram.com",
          "my_twitter.com",
          "Aroma espresso bars",
          "Бистро",
          "BBQ",
          "Happy hours",
          "Cork-fee");

  RestDataOfMainPage restNullDataOfMainPageAllField = new RestDataOfMainPage(
          "Slava test123",
          "вул.Академика Белецкого, 9а",
          "viacheslav",
          "Здесь описание ресторана тест создание ресторана",
          "9A, вулиця Академіка Білецького, 9А, Київ, Украина",
          "50.430206,30.417633000000023",
          "03126",
          "0671112299",
          "create123@gmail.com",
          "test123@gmail.com",
          "",
          "my_first_fb.com",
          "my_first_instagram.com",
          "my_first_twitter.com",
          "Carte Blanche",
          "Винотека",
          "Авторская",
          "Еда с собой",
          "Бильярд");

}
