package rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Request;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.rmi.CORBA.ValueHandler;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class WalletsTestsWithRestAndDB {

    private Set<Wallets> getWallets() throws IOException {
        String json = Request.Get("http://146.71.78.211/api/settings/wallets")
                .addHeader("Content-Type", "application/json")
                .addHeader("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHA6Ly8xNDYuNzEuNzguMjExL2FwaS9sb2dpbiIsImlhdCI6MTUzNDA5NDk0NSwiZXhwIjoxNTM0MDk4NTQ1LCJuYmYiOjE1MzQwOTQ5NDUsImp0aSI6IndBbmhLdGJnMDN1ZnYyMVgifQ.j93Snw5vHZRN_dQe05ptd7PwUnE8lTPoc0H7QZd5Rwo")
                .execute().returnContent().asString();

        String json2 =
                "[{ \"id\" : \"1\", \"balance\" : \"0.0001\", \"top_up_address\" : \"BMW\" }," +
                        " { \"id\" : \"2\", \"balance\" : \"0.002\", \"top_up_address\" : \"FIAT\"}]";

        ObjectMapper objectMapper = new ObjectMapper();
        Set<Wallets> walletsMap = objectMapper.readValue(json2, new TypeReference<Set<Wallets>>(){});
        System.out.println("Set<Wallets> " +walletsMap);

//        System.out.println(walletsMap.getId());
//        System.out.println(walletsMap.getBalance());
//        System.out.println(walletsMap.getTop_up_address());

        JsonParser jsonParser = new JsonParser();
        JsonArray parsed = jsonParser.parse(json).getAsJsonObject().get("data").getAsJsonObject().getAsJsonArray("wallets");

        return new Gson().fromJson(parsed, new TypeToken<Set<Wallets>>() {
        }.getType());
    }

    @Test
    public void walletsTestsWithRestAndDB() throws IOException {

        String userName;
        String password;
        String dbURL;
        Connection conn;

        userName = "root";
        password = "qwerty";
        dbURL = "jdbc:mysql://146.71.78.211:3306?autoReconnect=true&useSSL=false";

        Set<Wallets> walletsFromRequest = getWallets();
        //System.out.println("spisok " +setWalletsFromRequest);
        for(Wallets n: walletsFromRequest) {
            System.out.println("wallet from response :" +n);
        }

        Set<Wallets> walletsFromDb = null;

        try {
            conn = DriverManager.getConnection(dbURL, userName, password);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, balance, top_up_address FROM puredex.balances where user_id=2 and top_up_address is not NULL;");

            walletsFromDb = new HashSet<>();
            while (rs.next()) {
                Wallets wallet = new Wallets(rs.getInt("id"), rs.getDouble("balance"), rs.getString("top_up_address"));
                walletsFromDb.add(wallet);
                double balance = wallet.getBalance();
                System.out.println(balance);
            }
            for (Wallets n : walletsFromDb) {
                System.out.println("wallet from DB equal : " + n);
            }
//            Iterator iterator = walletsFromDb.iterator();
//            while (iterator.hasNext()){
//                System.out.println(iterator.next());
//            }

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


        assertEquals(new HashSet<Object>(walletsFromDb), new HashSet<Object>(walletsFromRequest));
    }

}

