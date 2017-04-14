package restaurants.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import restaurants.model.RestDataOfMainPage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slava on 13.04.2017.
 */
public class RestDataOfMainPgGenerator {

  @Parameter(names = "-c", description = "RestData count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;


  public static void main(String[] args) throws IOException {
    RestDataOfMainPgGenerator generator = new RestDataOfMainPgGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<RestDataOfMainPage> dataOfRestsMainPg = generateRestDataMainPg(count);
    if (format.equals("csv")) {
      saveAsCsv(dataOfRestsMainPg, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(dataOfRestsMainPg, new File(file));
    } else if(format.equals("json")){
      saveAsJson(dataOfRestsMainPg, new File(file));
    }
    else {
      System.out.println("Unrecognized forfat");
    }
  }

  private void saveAsJson(List<RestDataOfMainPage> dataOfRestsMainPg, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(dataOfRestsMainPg);
    try(Writer writer = new FileWriter(file)) {  //поместили в try что бы автоматически закрывался файл на запись
      writer.write(json);
    }
  }

  private void saveAsXml(List<RestDataOfMainPage> dataOfRestsMainPg, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(RestDataOfMainPage.class);
    String xml = xstream.toXML(dataOfRestsMainPg);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private  List<RestDataOfMainPage> generateRestDataMainPg(int count) {
    List<RestDataOfMainPage> dataOfRestsMainPg = new ArrayList<RestDataOfMainPage>();
    for(int i=0;i<count;i++){
      dataOfRestsMainPg.add(new RestDataOfMainPage()
              .withNameOfRest(String.format("Test %s", i))
              .withSeoOfRest(String.format("testing %s", i))
              .withAddressOfRest(String.format("ulitsa %s", i))
              .withIndexOfRest(String.format("333 %s",i)));
    }
    return dataOfRestsMainPg;
  }

  private  void saveAsCsv(List<RestDataOfMainPage> dataOfRestsMainPg , File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for(RestDataOfMainPage rest: dataOfRestsMainPg){
      writer.write(String.format("%s;%s;%s\n", rest.getNameOfRest(), rest.getSeoOfRest(),rest.getAddressOfRest()));
    }
    writer.close();
  }
}
