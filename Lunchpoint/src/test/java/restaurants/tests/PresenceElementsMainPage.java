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

  @Test(enabled = false)
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
    //  текст кнопки Поиска
    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div.header-search div.wrap form#w0 div.input-outer.to-right > input"), "value"),"Поиск");
  }

  @Test
  public void presenceElementsHeaderDown(){
    app.getMainPageHelper().click(By.cssSelector("div#customSelectSearch"));
    // наличие вкладки завтраки
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(1) > a[href='/breakfasts']")),true);
    // текст вкладки Завтраков
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(1) > a[href='/breakfasts']")),"ЗАВТРАКИ");
    // наличие вкладки Бизнес-Ланчи
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(2) > a[href='/lunches']")),true);
    // текст вкладки Бизнес-Ланчи
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(2) > a[href='/lunches']")),"БИЗНЕС-ЛАНЧИ");
    // наличие вкладки Рестораны
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(3) > a[href='/restaurants']")),true);
    // текст вкладки Рестораны
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(3) > a[href='/restaurants']")),"РЕСТОРАНЫ");
    // наличие вкладки Резерв Стола
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(4) > a[href='/reserve']")),true);
    // текст вкладки Резерв стола
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(4) > a[href='/reserve']")),"РЕЗЕРВ СТОЛА");
    // наличие вкладки Доставка (disable)
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("nav.main-nav div.wrap li.disabled > a")),true);
    // текст вкладки Доставка
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("nav.main-nav div.wrap li.disabled > a")),"ДОСТАВКА");
    // наличие вкладки Акции
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(6) > a[href='/offers']")),true);
    // текст вкладки Акции
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(6) > a[href='/offers']")),"АКЦИИ");
    // наличие вкладки Афиши
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(7) > a[href='/posters']")),true);
    // текст вкладки Афиши
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("nav.main-nav div.wrap li.top-form-submit:nth-of-type(7) > a[href='/posters']")),"АФИШИ");

  }
}
