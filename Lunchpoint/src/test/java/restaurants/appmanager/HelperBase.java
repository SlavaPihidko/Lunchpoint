package restaurants.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Slava on 08.01.2017.
 */
public class HelperBase {
  protected FirefoxDriver wd;

  JavascriptExecutor js;// = (JavascriptExecutor)wd;

  Actions clicker;// = new Actions(wd);

  public HelperBase(FirefoxDriver wd) {
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

  protected void click(By locator) {
    wd.findElement(locator).click();
  }



  protected void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  protected void dream3Sec() throws InterruptedException {
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
    return wd.findElement(locator).getAttribute(st);
  }

  public Boolean elementPresent(By locator) {
    if(wd.findElement(locator)!=null){
      System.out.println("Element is Present  " + locator);
      return wd.findElement(locator)!=null; }
    else {
      System.out.println("Element is Absent  " + locator);
      return false;
    }
  }
}
