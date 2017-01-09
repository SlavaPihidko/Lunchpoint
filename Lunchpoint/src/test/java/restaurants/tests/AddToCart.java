package restaurants.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddToCart {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://demo.litecart.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddToCart() throws Exception {
    driver.get(baseUrl + "/en/");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//img[@alt='Blue Duck']")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("3");
    Thread.sleep(3000);
    driver.findElement(By.name("add_cart_product")).click();
    Thread.sleep(3000);
    assertEquals(driver.findElement(By.cssSelector("a.content")).getText(), "Cart:\n3 item(s) - $60");
    driver.findElement(By.cssSelector("a.content")).click();
    Thread.sleep(3000);
    assertEquals(driver.findElement(By.name("quantity")).getAttribute("value"), "3");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
