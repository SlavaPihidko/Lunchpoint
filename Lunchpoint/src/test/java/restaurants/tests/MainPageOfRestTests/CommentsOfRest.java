package restaurants.tests.MainPageOfRestTests;

import org.testng.annotations.Test;
import restaurants.model.CommentsDataOfRest;
import restaurants.model.RestDataOfMainPage;
import restaurants.tests.TestBase;
import restaurants.utils.DataBaseUtils;
import restaurants.utils.MainPgUtils;

import java.sql.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.DataBaseUtils.*;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 31.03.2017.
 */
public class CommentsOfRest extends TestBase {

  @Test
  public void commentsOfRest() throws InterruptedException {
    List<CommentsDataOfRest> commentsFromDb = null;
    try {
      conn = DriverManager.getConnection(dbURL, userName, password);
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT comment_id, text FROM  comments  WHERE restaurant_id=2219");
      commentsFromDb = new ArrayList<CommentsDataOfRest>();
      while (rs.next()) {
        CommentsDataOfRest comment = new CommentsDataOfRest(rs.getString("comment_id"), rs.getString("text"));
        commentsFromDb.add(comment);

        System.out.println("commentsFromDb :" + commentsFromDb);
      }

      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(1000);
    app.getAdminHelper()
            .getAddressMainUrl(String.format("manager/restaurants/update?id=%s", restEditDataOfMainPg.getId()));
    List<CommentsDataOfRest> commentsFromWebMainPg = app.getMainPgHelper().getCommentsList();
    System.out.println("commentsFromWebMainPg : " + commentsFromWebMainPg);
    //Сравнение размеров
    assertEquals(commentsFromDb.size(), commentsFromWebMainPg.size());
    // сравнение множест.
    //assertEquals(new HashSet<Object>(objectFromWebNetwork), new HashSet<Object>(allNetworkListFromDb));

  }
}
