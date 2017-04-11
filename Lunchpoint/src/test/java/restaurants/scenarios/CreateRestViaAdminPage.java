package restaurants.scenarios;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restaurants.model.DataOfRestMainPgJson;
import restaurants.model.RestDataOfMainPage;
import restaurants.tests.TestBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Slava on 27.02.2017.
 */
public class CreateRestViaAdminPage extends TestBase {

  @DataProvider
  public Iterator<Object[]> defaultRestData() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//    BufferedReader reader = new BufferedReader( new FileReader(new File("src\\test\\resources\\forRest.json")));'
//    StringBuilder builder = new StringBuilder();
//    String line = reader.readLine();
//    while (line !=null){
//      builder.append(line);
////      String [] split = line.split(",");
////      list.add(new Object[] {new RestDataOfMainPage().withNameOfRest(split[0]).withAddressOfRest(split[1]).withSeoOfRest(split[2])});
//      line = reader.readLine();
//    }
    DataOfRestMainPgJson mappedJson = mapper.readValue(new File("src\\test\\resources\\forRest.json"), DataOfRestMainPgJson.class);
    for (RestDataOfMainPage data : mappedJson.getRestData()) {
      list.add(new Object[] {data});
    }
    return list.iterator();
  }

  @Test(dataProvider = "defaultRestData" )
  public void createRestViaAdminPageTests(RestDataOfMainPage restDefaultDataOfMainPageAllField) throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().createNewRestButton();
    app.getMainPgHelper().enterNameOfRestMainPage(restDefaultDataOfMainPageAllField);
    app.getMainPgHelper().enterAddressOfRestMainPage(restDefaultDataOfMainPageAllField);
    app.getMainPgHelper().enterSeoUrlOfRestMainPage(restDefaultDataOfMainPageAllField);

  }
}
