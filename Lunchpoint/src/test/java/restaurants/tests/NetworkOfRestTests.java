package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.model.RestDataOfNetworkList;
import restaurants.model.RestDataOfSiteList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 03.03.2017.
 */
public class NetworkOfRestTests extends TestBase {

  @Test(enabled = false)
  public void networkOfRestTest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(1000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    // проверяем записалось ли то значение сети ресторана которое выбрали
    assertEquals(app.getMainPageHelper()
            .text(By.cssSelector("div.input-outer.rest-net span#select2-restNet-container")),restEditDataOfMainPageAllField.getNetworkOfRest());
  }

  @Test(enabled = true)
  public void networkOfRestTestAllListPresent() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(1000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");

    List<RestDataOfNetworkList> objectFromWebNetwork = app.getMainPageHelper().getNetworkList();

    List<RestDataOfNetworkList> objectHardNameNetwork = new ArrayList<RestDataOfNetworkList>();
    String[] listNameOfNetwork = {
            "!Fest ", "7 Континентов ","Aroma espresso bars","Best Restaurant System",
            "Carte Blanche ", "Coffee Life", "Confetti", "Egoисты ",
            "FIRST LINE GROUP", "Forever Friends ", "Fresh Карта", "FreshLine", "Gastra",
            "Good Food House", "Hesburger", "Il Molino", "Kelembet", "Kumpel 'Group ",
            "L'Kafa Group ", "Maranello", "Mario's Trattoria", "Melrose Sensuyaki",
            "Pees Boy Club", "Rainford ", "Restaron ", "Salateira", "Seat & Eat ", "The Loft",
            "Woka", "Буфет", "ГурманіЯ", "Дом вкуса ", "Здесь весело!", "Итальянский Квартал",
            "Козырная карта ", "Континент Карт ", "Линия ", "Любовь и Голод ", "Мастергуд ",
            "Мировая карта", "Мистер Сендвич", "Наша карта", "Путеводная звезда ", "Реста ",
            "Росинтер", "Сан Сити ", "Сели-Поели ", "Сеть кофеен Шоколадница", "Сеть ресторанов Mafia",
            "Смак", "Суши WOK", "Таврия В", "Территория вкуса", "Фабрика вкуса ", "Фишка ",
            "Франс.Уа", "Без мережі", "Якитория"
    };
    for (int i=0;i<listNameOfNetwork.length;i++){
      RestDataOfNetworkList network = new RestDataOfNetworkList(listNameOfNetwork[i]);
      objectHardNameNetwork.add(network);
    }
    // сравнение множест.
      assertEquals(objectFromWebNetwork.size(), objectHardNameNetwork.size());
      assertEquals(new HashSet<Object>(objectFromWebNetwork), new HashSet<Object>(objectHardNameNetwork));
  }
}
