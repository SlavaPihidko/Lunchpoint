package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Slava on 08.01.2017.
 */
public class AdminHelper {
  private FirefoxDriver wd;

  public AdminHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void gotoAdminPanel() {
    wd.findElement(By.xpath("//a[contains(text(),'manager')]")).click();
  }

  public void searchRestInAdminPanel() throws InterruptedException {
    wd.findElement(By.name("RestaurantsLangSearch[name]")).click();
    wd.findElement(By.name("RestaurantsLangSearch[name]")).clear();
    wd.findElement(By.name("RestaurantsLangSearch[name]")).sendKeys("slava");
    // wd.get("http://lptest.bigdig.com.ua/manager/restaurants?RestaurantsLangSearch%5Bname%5D=test&RestaurantsLangSearch%5Baddress%5D=");
    wd.findElement(By.name("RestaurantsLangSearch[name]")).click();
    wd.findElement(By.name("RestaurantsLangSearch[address]")).click();
    //wd.findElement(By.name("RestaurantsLangSearch[address]")).clear();
    Thread.sleep(3000);
  }

  public void gotoEditRestInAdminPanel() throws InterruptedException {
    wd.findElement(By.cssSelector("a[href='/manager/restaurants/update?id=2219']>span.glyphicon.glyphicon-pencil")).click();
    Thread.sleep(3000);
  }


}
