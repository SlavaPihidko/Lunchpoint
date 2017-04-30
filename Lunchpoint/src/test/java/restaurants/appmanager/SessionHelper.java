package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Slava on 08.01.2017.
 */
public class SessionHelper extends HelperBase {
  //protected FirefoxDriver wd;

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    click(By.cssSelector("a.log-in"));
    type(By.id("email"), username);
    type(By.id("pass"), password);
    click(By.xpath("//div[@id='logIn']/div/a/span"));
  }

  public void loginWithoutConfirm(String username, String password) {
    click(By.cssSelector("a.log-in"));
    type(By.id("email"), username);
    type(By.id("pass"), password);
  }

  public void loginWithoutConfirmFirstPassword(String username, String password) {
    click(By.cssSelector("a.log-in"));
    type(By.id("pass"), password);
    type(By.id("email"), username);
  }

}
