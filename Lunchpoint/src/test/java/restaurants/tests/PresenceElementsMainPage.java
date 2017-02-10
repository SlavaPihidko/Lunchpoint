package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Slava on 10.02.2017.
 */
public class PresenceElementsMainPage extends TestBase {

  @Test
  public void presenceElementsHeader(){
    // наличие логотипа ЛП
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap > a > img[src='/img/logo-home1.svg'] ")),true);
    //наличие елемента логина
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in")),true);
    //текст логина
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.header-top.clear div.wrap div.to-right > a.log-in")), "ВХОД");
    // наличие елемента переключения языка
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > div.lang")), true);
    // текст переключения языка РУС по умолчанию
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.header-top.clear div.wrap div.to-right > div.lang > ul > li:nth-of-type(1) > a")), "РУС");
    // наличие птички возле переключения языка
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right > div.lang i.fa.fa-angle-down")), true);
    // наличие кнопки Присоедини ресторан
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-top.clear div.wrap div.to-right a.btn")),true);
    // текст кнопки Присоедини ресторан
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.header-top.clear div.wrap div.to-right a.btn")),"ПРИСОЕДИНИ РЕСТОРАН");

  }

}
