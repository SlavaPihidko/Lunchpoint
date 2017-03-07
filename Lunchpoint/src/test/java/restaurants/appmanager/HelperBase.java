package restaurants.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Slava on 08.01.2017.
 */
public class HelperBase {
  protected WebDriver wd;

  JavascriptExecutor js;// = (JavascriptExecutor)wd;

  Actions clicker;// = new Actions(wd);

  public HelperBase(WebDriver wd) {
    this.wd = wd;
    js = (JavascriptExecutor)wd;
    clicker = new Actions(wd);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }



  public void type(By locator, String text) {
    click(locator);
    if(text != null) { // оставляем дефолтные значения в полях
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!existingText.equals(text)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void dream3Sec() throws InterruptedException {
    Thread.sleep(3000);
  }

  protected void dream2Sec() throws InterruptedException {
    Thread.sleep(3000);
  }

  protected void dream1Sec() throws InterruptedException {
    Thread.sleep(1000);
  }

  public void setText(By locator){
    wd.findElement(locator);
  }

  public String text(By locator){
    System.out.println( locator +" locator shows " + wd.findElement(locator).getText() );
    return wd.findElement(locator).getText();
  }

  public String attribute(By locator, String st){
    System.out.println( locator +" locator of value shows " + wd.findElement(locator).getAttribute("value"));
    System.out.println( locator +" locator of title  shows " + wd.findElement(locator).getAttribute("title"));
    return wd.findElement(locator).getAttribute(st);
  }

  /*public Boolean elementPresent(By locator) {
    if(wd.findElement(locator)!=null){
      System.out.println("Element is Present  " + locator);
      return true }
    else {
      System.out.println("Element is Absent  " + locator);
      return false;
    }
  } */
  // Более правильный подход для проверки присутствия елемента
  public boolean elementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
