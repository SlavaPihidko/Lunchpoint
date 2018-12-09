package structure.tests;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;


public class AssetsTestFees {

    @Test
    public void testAssetsTestFees() throws IOException {
        AssetsFees assetsFees = new AssetsFees()
                .withId("18")
                .withOrder_max("100")
                .withOrder_min("100")
                .withDeposit_max("100")
                .withOrder_min("0")
                .withWithdraw_max("100")
                .withWithdraw_min("100")
                .withWithdraw_fee("0.001");
        int assetsFeesId = updateAssetsFees(assetsFees); // эта строчка написана для того что бы вызвать метод updateAssetsFees
    }


    private int updateAssetsFees(AssetsFees assetsFees) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut("http://146.71.78.211/api/admin/fees");
        String json = "{\"assets\": [{\"id\":18,\"trade_fee\": 1,\"deposit_fee\": 1,\"withdraw_fee\": 0.000001,\"order_max\": 1000,\"order_min\": 0.0001,\"deposit_max\": 1000,\"deposit_min\": 0.00001,\"withdraw_max\": 100,\"withdraw_min\": 0.00001}]}";
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        httpPut.setHeader("Content-Type", "application/json");
        httpPut.setHeader("authorization",
                "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjY0LCJpc3MiOiJodHRwOi8vMTQ2LjcxLjc4LjIxMS9hcGkvbG9naW4iLCJpYXQiOjE1MzQyODE1MDEsImV4cCI6MTUzNDI4NTEwMSwibmJmIjoxNTM0MjgxNTAxLCJqdGkiOiJqcjBIdmw0ZWJ1cDBHa3ZjIn0.hoDq8-QkRZa8kE70vwfDLMFVkIdEn2dohVbOLcvDAM8");
        CloseableHttpResponse responseHeader = client.execute(httpPut);
        HttpEntity entity2 = responseHeader.getEntity();
        String responseBody=  EntityUtils.toString(entity2);


       /* String jsonPut = Request.Put("http://146.71.78.211/api/admin/fees")
          .addHeader("Content-Type", "application/json")
                .addHeader("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjY0LCJpc3MiOiJodHRwOi8vMTQ2LjcxLjc4LjIxMS9hcGkvbG9naW4iLCJpYXQiOjE1MzQxNzIzODMsImV4cCI6MTUzNDE3NTk4MywibmJmIjoxNTM0MTcyMzgzLCJqdGkiOiJXQmZweEJoSDNkYWpUUUs1In0.bsD6PYbKSD4aqTnvioXPCXYoKNjKvieiwxERic0tWNI")
                   .bodyForm(Form.form()
                           .add("id", assetsFees.getId())
                           .add("order_max",assetsFees.getOrder_max())
                           .add("order_min",assetsFees.getOrder_min())
                           .add("deposit_max",assetsFees.getDeposit_max())
                           .add("deposit_min",assetsFees.getDeposit_min())
                           .add("withdraw_max",assetsFees.getWithdraw_max())
                           .add("withdraw_min",assetsFees.getWithdraw_min())
                           .add("withdraw_fee",assetsFees.getWithdraw_fee())
//                .bodyForm(new BasicNameValuePair("id", assetsFees.getId()))
//                .bodyForm(new BasicNameValuePair("order_max", assetsFees.getOrder_max()))
//                .bodyForm(new BasicNameValuePair("order_min", assetsFees.getOrder_min()))
                           .build()).execute()
                                        .returnContent().asString();*/

        System.out.println("!!!!!"+responseHeader);
        System.out.println("!!!!!"+responseBody);
        client.close();
        return 0;

    }

//    private Executor getExecutor(){
//        return Executor.newInstance().auth("","");
//    }

}

