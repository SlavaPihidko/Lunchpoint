package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Slava on 08.01.2017.
 */
public class AdminHelper extends HelperBase {

  public AdminHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoAdminPanel() throws InterruptedException {
    click(By.xpath("//a[contains(text(),'manager')]"));
    dream();
  }

  public void searchRestInAdminPanel() throws InterruptedException {
    type(By.name("RestaurantsLangSearch[name]"),"slava");
    click(By.name("RestaurantsLangSearch[address]"));
    dream();
  }

  public void gotoEditRestInAdminPanel() throws InterruptedException {
    click(By.cssSelector("a[href='/manager/restaurants/update?id=2219']>span.glyphicon.glyphicon-pencil"));
    dream();
  }

  public void initOfEditRest() throws InterruptedException {
    gotoAdminPanel();
    searchRestInAdminPanel();
    gotoEditRestInAdminPanel();
  }


}
