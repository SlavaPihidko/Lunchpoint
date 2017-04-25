package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 01.03.2017.
 */
public class TelOfRestTests extends TestBase {

  @Test
  public void addressOfRestTest() throws InterruptedException {
    if(app.getMainPgHelper().elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"))) {
      app.getSessionHelper().login(usernameAdmin, passwordAdmin);
      Thread.sleep(1000);
    }

    app.getSiteHelper().searchRestOnTheSite();

    app.getSiteHelper()
            .click(By.cssSelector(String.format("div[lng='%s'] div.title", restEditDataOfMainPg.getLng())));
    app.getSiteHelper().click(By.cssSelector("div.tel span.spoiler > span"));
    Thread.sleep(500);
    // проверяем на сайте на страничке ресторана
    String tel = app.getMainPgHelper()
            .text(By.cssSelector("div.tel > p"));
    System.out.println("tel="+tel);

    String telExpected = restEditDataOfMainPg.getTelOfRest();
    System.out.println("telExpected = "+telExpected);
    String part1 = telExpected.substring(0,3);
    String part2 = telExpected.substring(3,6);
    String part3 = telExpected.substring(6,8);
    String part4 = telExpected.substring(8,10);
    System.out.println("part1="+part1);
    System.out.println("part2="+part2);
    System.out.println("part3="+part3);
    System.out.println("part4="+part4);
    //String telKleim = "+38 ("+part1+") "+part2+"-"+part3+"-"+part4;
    String telKleim = "+38 (".concat(part1).concat(") ").concat(part2).concat("-").concat(part3).concat("-").concat(part4);
    System.out.println("telKleim ="+telKleim);


   assertEquals(app.getMainPgHelper()
           .text(By.cssSelector("div.tel > p")), telKleim );

    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    // проверяем в админке на главной страничке ресторана в поле ввода тел ресторана что тел такой как перед этим записали
    assertEquals(app.getMainPgHelper()
            .attribute(By.xpath("//input[@name='phone[]']"),"value"), telKleim);
  }

  @Test
  public void testAddTelNumber() throws InterruptedException {
    if(app.getMainPgHelper().elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in"))) {
      app.getSessionHelper().login(usernameAdmin, passwordAdmin);
      Thread.sleep(1000);
    }
    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));

    app.getMainPgHelper().addTelNumber();
    Thread.sleep(100);
    app.getMainPgHelper().enterTelOfRestMainPage("0632223355");
    app.getMainPgHelper().saveRestMainPg();
    app.getMainPgHelper().confirmChangesOfRestMainPg();
    app.getAdminHelper().refreshPg();
    Thread.sleep(2000);

    String secondTelNumber = app.getMainPgHelper().attribute(By.xpath("(//input[@name='phone[]'])[2]"), "value");
    System.out.println(secondTelNumber);
    assertEquals(secondTelNumber, "+38 (063) 222-33-55");
  }

}
