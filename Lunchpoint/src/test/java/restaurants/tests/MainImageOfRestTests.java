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
  public void changeMainImageInAdminPanelTests() throws InterruptedException {
    File mainPhoto = new File("src/test/resources/" + restEditDataOfMainPg.getNameOfMainImg());
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().
            getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    app.getMainPageHelper().changeImage(mainPhoto);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
    app.getAdminHelper().refreshPage();
    Thread.sleep(3000);
    String namePhotoFromMainPage = app.getMainPageHelper()
            .attribute(By.cssSelector("div.bg-inner > img"), "src");

    System.out.println("namePhotoFromMainPage: "+namePhotoFromMainPage.length());
    int startOfName = namePhotoFromMainPage.length() - restEditDataOfMainPg.getNameOfMainImg().length();
    System.out.println(namePhotoFromMainPage.substring(startOfName, namePhotoFromMainPage.length()));
    assertEquals(namePhotoFromMainPage
            .substring(startOfName, namePhotoFromMainPage.length()), restEditDataOfMainPg.getNameOfMainImg());
  }

    @Test(enabled = true)
    public void changeMainImageOnSiteListTests() throws InterruptedException {
      app.getSiteHelper().searchRestOnTheSite();
      // проверяем на сайте в списке что картинка ресторана изменилася
      String nameImageFromList = app.getMainPageHelper()
              .attribute(By.cssSelector(String.format("div[lng='%s'] > a", restEditDataOfMainPg.getLng())), "img");
      System.out.println("nameImageFromList: " + nameImageFromList.length());
      int startOfName = nameImageFromList.length() - restEditDataOfMainPg.getNameOfMainImg().length();
      System.out.println(nameImageFromList.substring(startOfName, nameImageFromList.length()));
      assertEquals(nameImageFromList
              .substring(startOfName, nameImageFromList.length()), restEditDataOfMainPg.getNameOfMainImg());
    }

    @Test
    public void changeMainImageOnSitePageTests() throws InterruptedException {
      app.getSiteHelper().searchRestOnTheSite();
    app.getSiteHelper()
            .click(By.cssSelector(String.format("div[lng='%s'] div.title", restEditDataOfMainPg.getLng())));
    // проверяем на сайте на страничке ресторана
    String nameImageFromPageOfRest = app.getMainPageHelper()
            .attribute(By.cssSelector("div.bg-inner > img"),"src");
      int startOfName = nameImageFromPageOfRest.length() - restEditDataOfMainPg.getNameOfMainImg().length();
    System.out.println(nameImageFromPageOfRest.substring(startOfName,nameImageFromPageOfRest.length()));
    assertEquals(nameImageFromPageOfRest
            .substring(startOfName,nameImageFromPageOfRest.length()), restEditDataOfMainPg.getNameOfMainImg());
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
