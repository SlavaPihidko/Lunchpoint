package restaurants;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class EditRestMainPageTests extends TestBase {

  @Test
  public void testEditRestaurantMainPage() throws InterruptedException {
    searchRestInAdminPanel();
    gotoEditRestInAdminPanel();
    fillRestName(new RestDataOfMainPage("Slava test selenium"));
    saveRestMainPage();
    confirmChangesOfRestMainPage();
  }

}
