package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 11.03.2017.
 */
public class EditWorkingHours extends  TestBase {

  @Test(enabled = false)
  public void editWorkingHours() throws InterruptedException {
    // Отсутствие всех 6 методов оплаты
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    app.getMainPageHelper().choiceTypeOfScheduleForEachDayOfRestMainPage();
    app.getMainPageHelper().scroll(0,200);
    app.getMainPageHelper().choiceHoursOfWorkingMon();
    app.getMainPageHelper().choiceHoursOfWorkingTue();
    app.getMainPageHelper().choiceHoursOfWorkingWen();
    app.getMainPageHelper().choiceHoursOfWorkingThu();
    app.getMainPageHelper().choiceHoursOfWorkingFri();
    app.getMainPageHelper().choiceHoursOfWorkingSat();
    app.getMainPageHelper().choiceHoursOfWorkingSun();

    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
  }

 @Test(enabled = true)
  public void allHoursOfWorkingTests() throws InterruptedException {
   app.getAdminHelper().getAddressMainUrl();
   app.getSiteHelper().searchRestOnTheSite();
   app.getSiteHelper().click(By.cssSelector("div[lng='30.39818839999998'] div.title"));
   app.getSiteHelper().click(By.cssSelector("div.work-time.clear > div.to-right"));
    //понедельник
   assertEquals(app.getMainPageHelper()
           .text(By.cssSelector("div.drop li:first-of-type div.to-right span")),"00:00-24:00");
   // вторник
   assertEquals(app.getMainPageHelper()
           .text(By.cssSelector("div.drop li:nth-of-type(2) div.to-right span")),"00:30-04:30");
   //среда
   assertEquals(app.getMainPageHelper()
           .text(By.cssSelector("div.drop li:nth-of-type(3) div.to-right span")),"05:30-05:30");
   //четверг
   assertEquals(app.getMainPageHelper()
           .text(By.cssSelector("div.drop li:nth-of-type(4) div.to-right span")),"08:30-14:30");
   //пятница
   assertEquals(app.getMainPageHelper()
           .text(By.cssSelector("div.drop li:nth-of-type(5) div.to-right span")),"06:30-15:00");
   //суббота
   assertEquals(app.getMainPageHelper()
           .text(By.cssSelector("div.drop li:nth-of-type(6) div.to-right span")),"07:00-15:30");
   //воскресенье
   assertEquals(app.getMainPageHelper()
           .text(By.cssSelector("div.drop li:nth-of-type(7) div.to-right span")),"07:30-19:30");
 }
}
