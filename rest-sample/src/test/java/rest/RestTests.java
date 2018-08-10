package rest;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Request;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;


/**
 * Created by slva on 10.08.2018.
 */
public class RestTests {

    @Test
    public void testWalletList() throws IOException {
        //List<Wallets> listWallets =  getWallets();
        Set<Wallets> listWallets =  getWallets();
        System.out.println("spisok " +listWallets);
    }


    private Set<Wallets> getWallets() throws IOException {
        // String json= getExecutor()
        String json = Request.Get("http://146.71.78.211/api/settings/wallets")
                .addHeader("Content-Type", "application/json")
                .addHeader("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHA6Ly8xNDYuNzEuNzguMjExL2FwaS9sb2dpbiIsImlhdCI6MTUzMzkzOTU4OSwiZXhwIjoxNTMzOTQzMTg5LCJuYmYiOjE1MzM5Mzk1ODksImp0aSI6Ikt1RFVpQlYxSDhhdVY2djgifQ.Msf0YpigLruANEQ7WYB2mkSsGNgsrRPlHZdf-Uepd70")
                .execute().returnContent().asString();


        List<Wallets> wallets = new ArrayList<Wallets>();

        JsonParser jsonParser = new JsonParser();
        JsonArray parsed  = jsonParser.parse(json).getAsJsonObject().get("data").getAsJsonObject().getAsJsonArray("wallets");
       /* System.out.println("Массив обьектов wallets представлен строкой "+String.valueOf(parsed));
        System.out.println(" !!! ");

        for(JsonElement result: parsed) {
            Wallets wallet = new Wallets(result);
            wallets.add(wallet);
        }


      Iterator itr = wallets.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());


        return wallets;*/
       return new Gson().fromJson(parsed, new TypeToken<Set<Wallets>>(){}.getType());
    }
}


