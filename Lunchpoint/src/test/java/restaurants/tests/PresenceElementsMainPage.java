package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static java.sql.Types.NULL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Slava on 10.02.2017.
 */
public class PresenceElementsMainPage extends TestBase {


  @Test(enabled = false)
  public void presenceElementsHeaderTop(){
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

  @Test
  public void presenceElementsHeaderMiddle(){
    // наличие текста
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.header-search div.phrace")),"ПРОГОЛОДАЛСЯ? МЕНЮ В ОДИН КЛИК!");
    // наличие формы
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-search div.wrap form#w0")),true);
    // наличие поля для ввода адреса
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-search div.wrap form#w0 > div.input-outer.location > div#cities")),true);
    // наличие пульсируещого значка
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-search div.wrap form#w0 > div.input-outer.location > div#cities >a.check-location.pulsing")),true);
    // наличие текста по умолчанию в поле для ввода города
    String s = app.getMainPageHelper()
            .attribute(By.cssSelector("div.header-search div.wrap form#w0 > div.input-outer.location > div#cities input#name_address"),"value");
    System.out.println(s);
    if (s == "") {
      // если текста по умолчанию нету в поле то тест упадет
      assertEquals(app.getMainPageHelper()
              .attribute(By.cssSelector("div.header-search div.wrap form#w0 > div.input-outer.location > div#cities input#name_address"),"value"),"mustFail");
    }

    // наличие птички в поле для ввода города
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-search div.wrap form#w0 > div.input-outer.location > div#cities i.fa.fa-angle-down")),true);


    // наличие поля для ввода ресторана
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-search div.wrap form#w0 div#customSelectSearch")),true);
    // текст плейсхолдера в поле ввода ресторана
    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div.header-search div.wrap form#w0 div#customSelectSearch > input"),"placeholder"),"Выберите раздел или укажите название ресторана или кухни...");
    // наличие птички в поле для ввода ресторана
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-search div.wrap form#w0 div#customSelectSearch i.fa.fa-angle-down.rotated.collapsed")),true);
    // наличие кнопки Поиска
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div.header-search div.wrap form#w0 div.input-outer.to-right")),true);

    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div.header-search div.wrap form#w0 div.input-outer.to-right > input"), "value"),"Поиск");



  }

}
