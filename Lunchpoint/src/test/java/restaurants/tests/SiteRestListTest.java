package restaurants.tests;

import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 30.01.2017.
 */
public class SiteRestListTest extends TestBase {

  @Test(enabled = true)
  public void testSiteRestList() throws InterruptedException {
    app.getSiteHelper().searchRestOnTheSite();
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("section.container > div.title-h1 > h1")), "Рестораны в Киеве");
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] > div.content > div.type")),"Бистро");
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] a[href='/slavkotest123'] > div.title")), "Slava test selenium");
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] > div.content > div.address")), "вул.Жолудєва 8");
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] > div.content div.min-bill.clear > span")), "<100 грн");
    // проверка на наличие названия Средний чек и его значение
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] div.min-bill.clear")), "Средний чек <100 грн");
    /* Пока что возвращает пустоту
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] div.row > div.to-right")), "отзывы");
            */

    // количество 29 символов потому что /manager/img/restaurants/.jpg = 29 символов
    // когда заглушка, то атрибут img будет короткий, к примеру /img/3.png
    // проверка на наличие главной картинки
    String attributeOfImg = app.getMainPageHelper()
            .attribute(By.cssSelector("div[lng='30.39818839999998'] > a.img-outer"), "img");
    System.out.println(attributeOfImg);
    int n = 29;
    System.out.println(attributeOfImg.length());
     if(attributeOfImg.length() < n){
       assertEquals(app.getMainPageHelper()
               .attribute(By.cssSelector("div[lng='30.39818839999998'] > a.img-outer"), "img"), "testMustFail");
     }
    // если заглушка вместо картинки
    /*assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div[lng='30.39818839999998'] > a.img-outer"), "img"), "/img/3.png"); */
    //System.out.print(app.getMainPageHelper().attribute(By.cssSelector("div[lng='30.39818839999998'] > a.img-outer"), "img")); // выводим то что возвращает метод attribute
    // Проверка на наличие звезд в блоке с рейтингом
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div[lng='30.39818839999998'] div.rating.to-left > ul.stars")), true);
    // Проверка на наличие блока с временем работы и наличие иконки часов
    assertEquals(app.getMainPageHelper()
            .elementPresent(By.cssSelector("div[lng='30.39818839999998'] div.work-shcedule > div.img-time")), true);
    // Проверка на то что кнопка Меню существует и  имеет название Меню
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] div.row.mt > a ")), "Меню");
    // Проверка на то что кнопка Меню ведет на страницу ресторана
    assertEquals(app.getMainPageHelper()
            .attribute(By.cssSelector("div[lng='30.39818839999998'] div.row.mt > a"), "href"), "http://lptest.bigdig.com.ua/slavkotest123#menu_tab");
    // Проверка на наличие кнопки Доставка и что имеет название Доставка
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div[lng='30.39818839999998'] div.to-right > a")), "ДОСТАВКА");
  }
}
