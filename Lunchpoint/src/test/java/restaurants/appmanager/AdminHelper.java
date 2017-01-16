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
    dream3Sec();
  }

  public void searchRestInAdminPanel(String locator, String nameOfRest) {
    type(By.name(locator), nameOfRest);
    //click(By.name(locator));

  }

  public void gotoAddressFieldInAdminPanel() throws InterruptedException {
    click(By.name("RestaurantsLangSearch[address]"));
    dream3Sec();
  }

  public void gotoEditRestInAdminPanel() throws InterruptedException {
    click(By.cssSelector("a[href='/manager/restaurants/update?id=2219']>span.glyphicon.glyphicon-pencil"));
    dream3Sec();
  }

  public void initOfEditRest() throws InterruptedException {
    searchRestInAdminPanel("RestaurantsLangSearch[name]", "slava");
    gotoAddressFieldInAdminPanel();
    gotoEditRestInAdminPanel();
  }


}
