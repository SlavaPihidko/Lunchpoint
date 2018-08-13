/*package rest;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;


public class AssetsTestFees {

    @Test
    public void testAssetsTestFees() {
        AssetsFees assetsFees = new AssetsFees();
    }


    private int updateAssetsFees(AssetsFees assetsFees) throws IOException {

                String jsonPut = Executor.execute(Request.Put("http://146.71.78.211/api//admin/fees")
          .addHeader("Content-Type", "application/json")
                .addHeader("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHA6Ly8xNDYuNzEuNzguMjExL2FwaS9sb2dpbiIsImlhdCI6MTUzNDEwMjE2MSwiZXhwIjoxNTM0MTA1NzYxLCJuYmYiOjE1MzQxMDIxNjEsImp0aSI6Imcxckszc29Sa3A3RFp0VGMifQ.6q1hUMtbnGEHPyMMk6de_5c_WwLkcC9Ba67v6s3KyZc")
                .bodyForm(new BasicNameValuePair("id", assetsFees.getSt()))
                        .returnContent().asString();
        return 0;

    }

}

*/