package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Slava on 08.01.2017.
 */
public class SessionHelper {
  protected FirefoxDriver wd;

  public SessionHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  protected void login(String username, String password) {
    wd.findElement(By.cssSelector("a.log-in")).click();
    wd.findElement(By.id("email")).click();
    wd.findElement(By.id("email")).clear();
    wd.findElement(By.id("email")).sendKeys(username);
    wd.findElement(By.id("pass")).click();
    wd.findElement(By.id("pass")).clear();
    wd.findElement(By.id("pass")).sendKeys(password);
    wd.findElement(By.xpath("//div[@id='logIn']/div/a/span")).click();
  }
}
