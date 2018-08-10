package rest;

import com.google.gson.*;
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
        List<Wallets> listWallets =  getWallets();
        System.out.println(listWallets);
    }


    private List<Wallets> getWallets() throws IOException {
        // String json= getExecutor()
        String json = Request.Get("http://146.71.78.211/api/settings/wallets")
                .addHeader("Content-Type", "application/json")
                .addHeader("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHA6Ly8xNDYuNzEuNzguMjExL2FwaS9sb2dpbiIsImlhdCI6MTUzMzkzMzQ4OCwiZXhwIjoxNTMzOTM3MDg4LCJuYmYiOjE1MzM5MzM0ODgsImp0aSI6Ik5lM0Qzdm5lbXRUN3JHazAifQ.Q66rmMikiUqBw3D_ruw2QGMczGTonQVSrU5wWhA58GU")
                .execute().returnContent().asString();


        List<Wallets> wallets = new ArrayList<Wallets>();

        JsonParser jsonParser = new JsonParser();
        JsonArray parsed  = jsonParser.parse(json).getAsJsonObject().get("data").getAsJsonObject().getAsJsonArray("wallets");
        System.out.printf(String.valueOf(parsed));
        for(JsonElement result: parsed) {
            Wallets wallet = new Wallets(result);
            wallets.add(wallet);
        }


      Iterator itr = wallets.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());


        return wallets;
    }
}


