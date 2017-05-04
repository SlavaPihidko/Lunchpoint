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
  private int sizeOfList;
  private String st1 = "Task1";;
  private String st2 = "Task2";;
  private String st3 = "Task3";;
  private String st4 = "Task4";

  @BeforeSuite
  public void init() {
    wd = new FirefoxDriver();
  }

  @BeforeTest
  public void toDoMVCTest() throws InterruptedException {
    wd.get("http://todomvc.com/examples/troopjs_require/");
    wd.findElement(By.cssSelector("input.new-todo")).click();
    wd.findElement(By.cssSelector("input.new-todo")).sendKeys(st1 + Keys.ENTER);
    wd.findElement(By.cssSelector("header.header input.new-todo")).click();
    wd.findElement(By.cssSelector("header.header input.new-todo")).sendKeys(st2 + Keys.ENTER);
    wd.findElement(By.cssSelector("header.header input.new-todo")).click();
    wd.findElement(By.cssSelector("input.new-todo")).sendKeys(st3 + Keys.ENTER);
    wd.findElement(By.cssSelector("header.header input.new-todo")).click();
    wd.findElement(By.cssSelector("input.new-todo")).sendKeys(st4 + Keys.ENTER);
  }
  @Test
  public void toDoMVCTest1() {
    List<WebElement> elements = wd.findElements(By.cssSelector("ul.todo-list li"));
    sizeOfList = new Integer(wd.findElement(By.cssSelector("span.todo-count > strong")).getText());
    System.out.println("elements.size=" + elements.size());
    System.out.println("sizeOfList =" + sizeOfList);
    assertEquals(elements.size(), sizeOfList);
  }

  @Test(dependsOnMethods ="toDoMVCTest1", alwaysRun = true)
  public void toDoMVCTest2(){
    String textOf4Element = wd.findElement(By.cssSelector("ul.todo-list li.active:nth-of-type(4)")).getText();
    System.out.println(textOf4Element);
    assertEquals(textOf4Element, st4);
  }

  @Test(dependsOnMethods = "toDoMVCTest2", alwaysRun = true)
  public void toDoMVCTest3() throws InterruptedException {
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

  @Test(dependsOnMethods ="toDoMVCTest3", alwaysRun = true)
  public void toDoMVCTest4() throws InterruptedException {
    wd.findElement(By.cssSelector("ul.todo-list li.active:last-of-type input.toggle")).click();
    Thread.sleep(3000);
    wd.findElement(By.cssSelector("a[href='#/completed']")).click();
    String firstCompletedItem = wd.findElement(By.cssSelector("ul.todo-list.filter-completed li.completed label")).getText();
    assertEquals(firstCompletedItem, st4);
  }

  @Test(dependsOnMethods = "toDoMVCTest4", alwaysRun = true)
  public void toDoMVCTest5() throws InterruptedException {
    wd.findElement(By.cssSelector("ul.todo-list li.active:last-of-type input.toggle")).click();
    Thread.sleep(3000);
    wd.findElement(By.cssSelector("a[href='#/active']")).click();
    List<WebElement> elements = wd.findElements(By.cssSelector("ul.todo-list li"));
    sizeOfList = new Integer(wd.findElement(By.cssSelector("span.todo-count > strong")).getText());
    System.out.println("elements.size=" + elements.size());
    System.out.println("sizeOfList =" + sizeOfList);
    assertEquals(elements.size(), sizeOfList);
  }

  @AfterSuite
  public void stop(){
    wd.quit();
  }

}
