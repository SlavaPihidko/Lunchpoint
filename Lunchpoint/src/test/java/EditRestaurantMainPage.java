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

public class EditRestaurantMainPage {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void EditRestaurantMainPage() {
        wd.get("https://lunchpoint.com/");
        wd.findElement(By.linkText("ВХОД")).click();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("manager@lunch.ua");
        wd.findElement(By.id("pass")).click();
        wd.findElement(By.id("pass")).clear();
        wd.findElement(By.id("pass")).sendKeys("2CDTx8Wz");
        wd.findElement(By.linkText("ЛОГІН")).click();
        wd.findElement(By.linkText("MANAGER")).click();
        wd.findElement(By.name("RestaurantsLangSearch[name]")).click();
        wd.findElement(By.name("RestaurantsLangSearch[name]")).clear();
        wd.findElement(By.name("RestaurantsLangSearch[name]")).sendKeys("test");
        wd.findElement(By.name("RestaurantsLangSearch[name]")).click();
        wd.findElement(By.name("RestaurantsLangSearch[name]")).sendKeys("\n");
        wd.findElement(By.cssSelector("span.glyphicon.glyphicon-pencil")).click();
        wd.findElement(By.id("edit_restName")).click();
        wd.findElement(By.id("edit_restName")).clear();
        wd.findElement(By.id("edit_restName")).sendKeys("Slava test123");
        wd.findElement(By.id("btn_form_general")).click();
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
