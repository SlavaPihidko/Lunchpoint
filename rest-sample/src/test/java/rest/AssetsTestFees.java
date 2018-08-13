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
        AssetsFees assetsFees = new AssetsFees();
        int assetsFeesId = updateAssetsFees(assetsFees);
    }


    private int updateAssetsFees(AssetsFees assetsFees) throws IOException {

                String jsonPut = Request.Put("http://146.71.78.211/api/admin/fees")
          .addHeader("Content-Type", "application/json")
                .addHeader("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjY0LCJpc3MiOiJodHRwOi8vMTQ2LjcxLjc4LjIxMS9hcGkvbG9naW4iLCJpYXQiOjE1MzQxNzIzODMsImV4cCI6MTUzNDE3NTk4MywibmJmIjoxNTM0MTcyMzgzLCJqdGkiOiJXQmZweEJoSDNkYWpUUUs1In0.bsD6PYbKSD4aqTnvioXPCXYoKNjKvieiwxERic0tWNI")
                   .bodyForm(Form.form().add("user", "vfvf").build()).execute()
//                .bodyForm(new BasicNameValuePair("id", assetsFees.getId()))
//                .bodyForm(new BasicNameValuePair("order_max", assetsFees.getOrder_max()))
//                .bodyForm(new BasicNameValuePair("order_min", assetsFees.getOrder_min()))

                                        .returnContent().asString();

        System.out.println("!!!!!"+jsonPut);
        return 0;

    }

//    private Executor getExecutor(){
//        return Executor.newInstance().auth("","");
//    }

}

