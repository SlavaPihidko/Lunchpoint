package rest;


/**
 * Created by slva on 11.08.2018.
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class ConnDB {

    @Test
    public void testDbConnection() throws IOException {
        String userName;
        String password;
        String dbURL;
        Connection conn;

        userName = "root";
        password = "qwerty";
        dbURL = "jdbc:mysql://146.71.78.211:3306?autoReconnect=true&useSSL=false";

        Set<Wallets> setWalletsFromRequest = getWallets();
        //System.out.println("spisok " +setWalletsFromRequest);
        for(Wallets n: setWalletsFromRequest) {
            System.out.println("wallet from response :" +n);
        }

        Set<Wallets> walletsFromDb = null;

        try {
            conn = DriverManager.getConnection(dbURL, userName, password);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, balance, top_up_address FROM puredex.balances where user_id=2 and top_up_address is not NULL;");

            walletsFromDb = new HashSet<>();
            while (rs.next()) {
                Wallets wallet = new Wallets(rs.getInt("id"), rs.getString("balance"), rs.getString("top_up_address"));
                walletsFromDb.add(wallet);
            }
            for (Wallets n : walletsFromDb) {
                System.out.println("wallet from DB equal : " + n);
            }
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


        assertEquals(new HashSet<Object>(walletsFromDb), new HashSet<Object>(setWalletsFromRequest));
    }



    private Set<Wallets> getWallets() throws IOException {
        String json = Request.Get("http://146.71.78.211/api/settings/wallets")
                .addHeader("Content-Type", "application/json")
                .addHeader("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHA6Ly8xNDYuNzEuNzguMjExL2FwaS9sb2dpbiIsImlhdCI6MTUzMzk5NTM2MywiZXhwIjoxNTMzOTk4OTYzLCJuYmYiOjE1MzM5OTUzNjMsImp0aSI6ImZ0NkxlcmhQOWpDZFB1SzIifQ.f5-1RT4NBAja7IHNychWZhMzUW4AJPYcj4n6rX9Gs_k")
                .execute().returnContent().asString();

        JsonParser jsonParser = new JsonParser();
        JsonArray parsed = jsonParser.parse(json).getAsJsonObject().get("data").getAsJsonObject().getAsJsonArray("wallets");

        return new Gson().fromJson(parsed, new TypeToken<Set<Wallets>>() {
        }.getType());
    }
}

