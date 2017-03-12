package restaurants.tests;

import org.openqa.selenium.By;
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
    String namePhotoFromMainPage = app.getMainPageHelper()
            .attribute(By.cssSelector("div.bg-inner > img"),"src");


    System.out.println(namePhotoFromMainPage.length());
    System.out.println(namePhotoFromMainPage.substring(62,73));
    assertEquals(namePhotoFromMainPage.substring(62,73),"MainImg.jpg");

    app.getAdminHelper().getAddressMainUrl();
    app.getSiteHelper().searchRestOnTheSite();
    // проверяем на сайте в списке что картинка ресторана изменилася
    String nameImageFromList = app.getMainPageHelper()
            .attribute(By.cssSelector("div[lng='30.39818839999998'] > a"),"img");
    System.out.println("nameImageFromList"+nameImageFromList.length());
    System.out.println(nameImageFromList.substring(35,46));
    assertEquals(nameImageFromList.substring(35,46),"MainImg.jpg") ;

    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    // проверяем на сайте на страничке ресторана
    String nameImageFromPageOfRest = app.getMainPageHelper()
            .attribute(By.cssSelector("div.bg-inner > img"),"src");
    System.out.println(nameImageFromPageOfRest.substring(62,73));
    assertEquals(nameImageFromPageOfRest.substring(62,73), "MainImg.jpg");

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
