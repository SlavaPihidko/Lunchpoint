package restaurants.model;

/**
 * Created by Slava on 18.01.2017.
 */
public class VariantsOfNameOfMainPage {

  private String varName1;
  private String varName2;
  private String varName3;
  private String varName4;

  public VariantsOfNameOfMainPage(String varName1, String varName2, String varName3, String varName4){

    this.varName1 = varName1;
    this.varName2 = varName2;
    this.varName3 = varName3;
    this.varName4 = varName4;

  }

  public String getVarName1() {
    return varName1;
  }

  public String getVarName2() {
    return varName2;
  }

  public String getVarName3() {
    return varName3;
  }

  public String getVarName4() {
    return varName4;
  }
}
