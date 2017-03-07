package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import restaurants.model.RestDataOfNetworkList;
import restaurants.model.RestDataOfSiteList;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 03.03.2017.
 */
public class NetworkOfRestTests extends TestBase {
  String userName = "bigdig_lptest";;
  String password= "1tm5b79b";;
  String dbURL= "jdbc:mysql://bigdig.mysql.ukraine.com.ua/bigdig_lptest";;
  Connection conn;


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

    List<RestDataOfNetworkList> allNetworkListFromDb = null;
    try {
      conn = DriverManager.getConnection(dbURL, userName, password);

      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select name from restaurant_chain");
      allNetworkListFromDb = new ArrayList<RestDataOfNetworkList>();
      while (rs.next()) {
        RestDataOfNetworkList network = new RestDataOfNetworkList(rs.getString("name"));
        allNetworkListFromDb.add(network);
      }
      // создали обьект с "Без мережі" так как в БД он не хранится
      RestDataOfNetworkList bezMereji = new RestDataOfNetworkList("Без мережі");
      allNetworkListFromDb.add(bezMereji);
      System.out.println("из БД:  "+ allNetworkListFromDb);
      rs.close();
      st.close();
      conn.close();
      // Do something with the Connection


    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }


    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(1000);
    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");

    List<RestDataOfNetworkList> objectFromWebNetwork = app.getMainPageHelper().getNetworkList();
    System.out.println("Из Веба:  "+objectFromWebNetwork);
    //Сравнение размеров
    assertEquals(objectFromWebNetwork.size(), allNetworkListFromDb.size());
    // сравнение множест.
    assertEquals(new HashSet<Object>(objectFromWebNetwork), new HashSet<Object>(allNetworkListFromDb));
  }
}
