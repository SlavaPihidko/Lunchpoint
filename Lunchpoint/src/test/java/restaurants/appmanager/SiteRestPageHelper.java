package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Slava on 30.01.2017.
 */
public class SiteRestPageHelper extends HelperBase {

  public SiteRestPageHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToRestPage() throws InterruptedException {
    click(By.cssSelector("div[lng='30.39818839999998'] > a"));
    dream3Sec();
  }
}
