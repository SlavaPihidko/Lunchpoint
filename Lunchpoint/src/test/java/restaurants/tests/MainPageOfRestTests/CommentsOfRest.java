package restaurants.tests.MainPageOfRestTests;

import org.testng.annotations.Test;
import restaurants.model.CommentsDataOfRest;
import restaurants.tests.TestBase;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import static restaurants.utils.DataBaseUtils.*;

/**
 * Created by Slava on 31.03.2017.
 */
public class CommentsOfRest extends TestBase {

  @Test
  public void commentsOfRest() throws InterruptedException {
    List<CommentsDataOfRest> commentsFromDb=null;
    try{
      conn = DriverManager.getConnection(dbURL,userName,password);
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT comment_id, text FROM  comments  WHERE restaurant_id=2219");
      commentsFromDb = new ArrayList<CommentsDataOfRest>();
      while (rs.next()){
        CommentsDataOfRest comment = new CommentsDataOfRest(rs.getInt("comment_id"),rs.getString("text"));
        commentsFromDb.add(comment);

        System.out.println("commentsFromDb :" + commentsFromDb );
      }
    }
    catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
