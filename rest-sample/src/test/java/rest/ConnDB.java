package rest;


/**
 * Created by slva on 11.08.2018.
 */

import org.testng.annotations.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnDB {

    @Test
    public void testDbConnection() {
        String userName;
        String password;
        String dbURL;
        Connection conn;

        userName = "root";
        password = "qwerty";
        dbURL = "jdbc:mysql://146.71.78.211:3306?autoReconnect=true&useSSL=false";

        try {
            conn = DriverManager.getConnection(dbURL, userName, password);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, balance, top_up_address FROM puredex.balances where user_id=2 and top_up_address is not NULL;");

            List<Wallets> walletsFromDb = new ArrayList<Wallets>();
            while (rs.next()){
                Wallets wallet = new Wallets(rs.getInt("id"), rs.getString("balance"), rs.getString("top_up_address"));
                walletsFromDb.add(wallet);
            }
            System.out.println(walletsFromDb);

            rs.close();
            st.close();
            conn.close();
            // Do something with the Connection
        }

     catch(SQLException ex) {

        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
}
}
