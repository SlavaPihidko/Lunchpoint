package restaurants.tests.draft;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

/**
 * Created by Slava on 03.05.2017.
 */
public class ToDoMVCTest1 {
  protected WebDriver wd;
  int sizeOfList;

  @BeforeSuite
  public void init() {
    wd = new FirefoxDriver();
  }

  @BeforeTest
  public void toDoMVCTest() throws InterruptedException {
    wd.get("http://todomvc.com/examples/troopjs_require/");
    wd.findElement(By.cssSelector("input.new-todo")).click();
    wd.findElement(By.cssSelector("input.new-todo")).sendKeys("Task1" + Keys.ENTER);
    wd.findElement(By.cssSelector("header.header input.new-todo")).click();
    wd.findElement(By.cssSelector("header.header input.new-todo")).sendKeys("Task2" + Keys.ENTER);
    wd.findElement(By.cssSelector("header.header input.new-todo")).click();
    wd.findElement(By.cssSelector("input.new-todo")).sendKeys("Task3" + Keys.ENTER);
    wd.findElement(By.cssSelector("header.header input.new-todo")).click();
    wd.findElement(By.cssSelector("input.new-todo")).sendKeys("Task4" + Keys.ENTER);
  }
  @Test
  public void toDoMVCTest1() {
    List<WebElement> elements = wd.findElements(By.cssSelector("ul.todo-list li"));
    sizeOfList = new Integer(wd.findElement(By.cssSelector("span.todo-count > strong")).getText());
    System.out.println("elements.size=" + elements.size());
    System.out.println("sizeOfList =" + sizeOfList);
    assertEquals(elements.size(), sizeOfList);
  }

  @Test(dependsOnMethods = "toDoMVCTest1", alwaysRun = true)
  public void toDoMVCTest2() throws InterruptedException {
    WebElement destroy2 = wd.findElement(By.cssSelector("ul.todo-list li.active:nth-of-type(2)"));
    Actions action = new Actions(wd);
    action.moveToElement(destroy2);
    action.perform();
    Thread.sleep(2000);
    wd.findElement(By.cssSelector("ul.todo-list li.active:nth-of-type(2) button.destroy")).click();
    Thread.sleep(1000);
    List<WebElement> elements = wd.findElements(By.cssSelector("ul.todo-list li"));
    sizeOfList = new Integer(wd.findElement(By.cssSelector("span.todo-count > strong")).getText());
    System.out.println("elements.size=" + elements.size());
    System.out.println("sizeOfList =" + sizeOfList);
    assertEquals(elements.size(), sizeOfList);
  }

  @Test//(dependsOnMethods ="toDoMVCTest2", alwaysRun = true)
  public void toDoMVCTest3() throws InterruptedException {
    wd.findElement(By.cssSelector("ul.todo-list li.active:last-of-type input.toggle")).click();
    Thread.sleep(3000);
    wd.findElement(By.cssSelector("a[href='#/completed']")).click();
    String firstCompletedItem = wd.findElement(By.cssSelector("ul.todo-list.filter-completed li.completed label")).getText();
  assertEquals(firstCompletedItem, "Task4");
  }

  @AfterSuite
  public void stop(){
    wd.quit();
  }

}
