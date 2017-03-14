package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.utils.MainPgUtils;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 01.03.2017.
 */
public class TelOfRestTests extends TestBase {

  @Test
  public void addressOfRestTest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);

    app.getSiteHelper().searchRestOnTheSite();

    app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
    app.getSiteHelper().click(By.cssSelector("div.tel span.spoiler > span"));
    Thread.sleep(500);
    // проверяем на сайте на страничке ресторана
    String tel = app.getMainPageHelper()
            .text(By.cssSelector("div.tel > p"));
    System.out.println("tel="+tel);

    String telExpected = MainPgUtils.restEditDataOfMainPg.getTelOfRest();
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


   assertEquals(app.getMainPageHelper()
           .text(By.cssSelector("div.tel > p")), telKleim );

    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    // проверяем в админке на главной страничке ресторана в поле ввода тел ресторана что тел такой как перед этим записали
    assertEquals(app.getMainPageHelper()
            .attribute(By.xpath("//input[@name='phone[]']"),"value"), telKleim);
  }
}
