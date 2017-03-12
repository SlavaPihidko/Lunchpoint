package restaurants.tests;

import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 12.03.2017.
 */
public class MainImageOfRestTests extends TestBase {

  @Test(enabled = true)
  public void changeMainImageTests() throws InterruptedException {
    File mainPhoto = new File("src/test/resources/MainImg.jpg");
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    app.getMainPageHelper().changeImage(mainPhoto);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
    app.getAdminHelper().refreshUrl();
    Thread.sleep(3000);
    String namePhoto = app.getMainPageHelper()
            .attribute(By.cssSelector("div.bg-inner > img"),"src");
    System.out.println(namePhoto.length());
    System.out.println(namePhoto.substring(62,73));
    assertEquals(namePhoto.substring(62,73),"MainImg.jpg");

  }

  @Test(enabled = false)
  public void currentWorkingDirectory(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/MainImg.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }
}
