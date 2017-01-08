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

  public void gotoAdminPanel() {
    click(By.xpath("//a[contains(text(),'manager')]"));
    //wd.findElement(By.xpath("//a[contains(text(),'manager')]")).click();
  }

  public void searchRestInAdminPanel() throws InterruptedException {
    type(By.name("RestaurantsLangSearch[name]"),"slava");
    /*wd.findElement(By.name("RestaurantsLangSearch[name]")).click();
    wd.findElement(By.name("RestaurantsLangSearch[name]")).clear();
    wd.findElement(By.name("RestaurantsLangSearch[name]")).sendKeys("slava");*/
    // wd.get("http://lptest.bigdig.com.ua/manager/restaurants?RestaurantsLangSearch%5Bname%5D=test&RestaurantsLangSearch%5Baddress%5D=");
    click(By.name("RestaurantsLangSearch[name]"));
    click(By.name("RestaurantsLangSearch[address]"));
    //wd.findElement(By.name("RestaurantsLangSearch[name]")).click();
    //wd.findElement(By.name("RestaurantsLangSearch[address]")).click();
    //wd.findElement(By.name("RestaurantsLangSearch[address]")).clear();
    dream();
  }

  public void gotoEditRestInAdminPanel() throws InterruptedException {
    click(By.cssSelector("a[href='/manager/restaurants/update?id=2219']>span.glyphicon.glyphicon-pencil"));
    //wd.findElement(By.cssSelector("a[href='/manager/restaurants/update?id=2219']>span.glyphicon.glyphicon-pencil")).click();
    dream();
  }


}
