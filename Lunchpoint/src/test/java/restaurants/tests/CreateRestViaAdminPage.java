package restaurants.tests;

/**
 * Created by Slava on 27.02.2017.
 */
public class CreateRestViaAdminPage extends TestBase {

  public void createRestViaAdminPageTests() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
  }
}
