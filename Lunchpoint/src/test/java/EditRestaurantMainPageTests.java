import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class EditRestaurantMainPageTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://lptest.bigdig.com.ua/");
        wd.findElement(By.cssSelector("a.log-in")).click();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("manager@lunch.ua");
        wd.findElement(By.id("pass")).click();
        wd.findElement(By.id("pass")).clear();
        wd.findElement(By.id("pass")).sendKeys("2CDTx8Wz");
        wd.findElement(By.xpath("//div[@id='logIn']/div/a/span")).click();
        wd.findElement(By.xpath("//a[contains(text(),'manager')]")).click();
        Thread.sleep(3000);
    }
    
    @Test
    public void testEditRestaurantMainPage() throws InterruptedException {
        wd.findElement(By.name("RestaurantsLangSearch[name]")).click();
        wd.findElement(By.name("RestaurantsLangSearch[name]")).clear();
        wd.findElement(By.name("RestaurantsLangSearch[name]")).sendKeys("slava");
       // wd.get("http://lptest.bigdig.com.ua/manager/restaurants?RestaurantsLangSearch%5Bname%5D=test&RestaurantsLangSearch%5Baddress%5D=");
        wd.findElement(By.name("RestaurantsLangSearch[name]")).click();
        wd.findElement(By.name("RestaurantsLangSearch[address]")).click();
        //wd.findElement(By.name("RestaurantsLangSearch[address]")).clear();
        Thread.sleep(3000);
        wd.findElement(By.cssSelector("a[href='/manager/restaurants/update?id=2219']>span.glyphicon.glyphicon-pencil")).click();
        Thread.sleep(3000);
        wd.findElement(By.id("edit_restName")).click();
        wd.findElement(By.id("edit_restName")).clear();
        wd.findElement(By.id("edit_restName")).sendKeys("Slava test selenium");
        wd.findElement(By.id("btn_form_general")).click();
        Thread.sleep(3000);
        wd.findElement(By.id("save_ok")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
