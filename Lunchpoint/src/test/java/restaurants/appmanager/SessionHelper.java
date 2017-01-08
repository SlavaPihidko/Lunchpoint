package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Slava on 08.01.2017.
 */
public class SessionHelper extends HelperBase {
  protected FirefoxDriver wd;

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  protected void login(String username, String password) {
    click(By.cssSelector("a.log-in"));
    //wd.findElement(By.cssSelector("a.log-in")).click();
    type(By.id("email"),username);
    /*wd.findElement(By.id("email")).click();
    wd.findElement(By.id("email")).clear();
    wd.findElement(By.id("email")).sendKeys(username);*/
    type(By.id("pass"),password);
    /*wd.findElement(By.id("pass")).click();
    wd.findElement(By.id("pass")).clear();
    wd.findElement(By.id("pass")).sendKeys(password);*/
    click(By.xpath("//div[@id='logIn']/div/a/span"));
    //wd.findElement(By.xpath("//div[@id='logIn']/div/a/span")).click();
  }
}
