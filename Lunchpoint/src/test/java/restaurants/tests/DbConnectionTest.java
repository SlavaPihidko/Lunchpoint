package restaurants.tests;

import org.testng.annotations.Test;
import restaurants.model.RestDataOfNetworkList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slava on 04.03.2017.
 */
public class DbConnectionTest {

  @Test
  public  void testDbConnection(){
      String userName;
      String password;
      String dbURL;
    Connection conn;

    userName = "bigdig_lptest";
    password = "1tm5b79b";
    dbURL = "jdbc:mysql://bigdig.mysql.ukraine.com.ua/bigdig_lptest";

    try {
      conn = DriverManager.getConnection(dbURL,userName,password);

      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select chain_id, name from restaurant_chain");
      List<RestDataOfNetworkList> nt = new ArrayList<RestDataOfNetworkList>();
     while (rs.next()){
       RestDataOfNetworkList network123 = new RestDataOfNetworkList(rs.getInt("chain_id"), rs.getString("name"));
       nt.add(network123);
      }
      System.out.println(nt);
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
  }
}
