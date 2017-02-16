package restaurants.tests;

import org.testng.annotations.Test;
import restaurants.model.NameDataOfRest;

/**
 * Created by Slava on 16.02.2017.
 */
public class NameOfRestTests extends TestBase {

  @Test
  public void nameOfRestTests() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest();
   // NameDataOfRest nameDataOfRest = new NameDataOfRest()
    String [] nameDataOfRest = {"f",
                                "фотограф",
                                "slava",
                                "slava ltd",
                                "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa",
                                "aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaaa aaaa1"};
    app.getMainPageHelper().fillNameOfRest(nameDataOfRest);
  }
}
