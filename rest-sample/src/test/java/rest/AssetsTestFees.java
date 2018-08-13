package rest;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;


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

                String jsonPut = Request.Put("http://146.71.78.211/api/admin/fees")
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
                                        .returnContent().asString();

        System.out.println("!!!!!"+jsonPut);
        return 0;

    }

//    private Executor getExecutor(){
//        return Executor.newInstance().auth("","");
//    }

}

