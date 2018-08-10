package rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;




/**
 * Created by slva on 10.08.2018.
 */
public class RestTests {

    @Test
    public void testWalletList() throws IOException {
        Set<Wallets> listWallets = getWallets();
System.out.println(listWallets);
    }


    private Set<Wallets> getWallets() throws IOException {
       // String json= getExecutor()
        String json =  Request.Get("http://146.71.78.211/api/settings/wallets")
                .addHeader("Content-Type", "application/json")
                .addHeader("authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHA6Ly8xNDYuNzEuNzguMjExL2FwaS9sb2dpbiIsImlhdCI6MTUzMzkxNzUzOSwiZXhwIjoxNTMzOTIxMTM5LCJuYmYiOjE1MzM5MTc1MzksImp0aSI6IkV2RjdaTWNWM3VqWFByVG0ifQ.Dze6qHwMkdGQaETITanNcK4DqA1zeSCtVMyEr3YwVNo")
        .execute().returnContent().asString();

        JsonElement parsed  =  new JsonParser().parse(json);
        JsonElement wallets =  parsed.getAsJsonObject().get("data");

        System.out.println(wallets);
       return new Gson().fromJson(wallets, new TypeToken<Set<Wallets>>(){}.getType());
    }



    /*private Executor getExecutor(){
        return Executor.newInstance()
                .auth("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHA6Ly8xNDYuNzEuNzguMjExL2FwaS9sb2dpbiIsImlhdCI6MTUzMzkwODg3MSwiZXhwIjoxNTMzOTEyNDcxLCJuYmYiOjE1MzM5MDg4NzEsImp0aSI6IjJWNVlQcVZrWUdWcWRkVkEifQ.yBeOQj3lV-nyzy9U4121QAh6rWQHCAXgaI-CUk4umLg", "");

    } */
}
