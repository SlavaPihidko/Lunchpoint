package restaurants.model;

public class RestDataOfMainPage {
  private final String nameOfRest;
  private final String addressOfRest;
  private final String seoOfRest;

  public RestDataOfMainPage(String nameOfRest, String addressOfRest, String seoOfRest) {
    this.nameOfRest = nameOfRest;
    this.addressOfRest = addressOfRest;
    this.seoOfRest = seoOfRest;
  }

  public String getNameOfRest() {
    return nameOfRest;
  }

  public String  getAddressOfRest(){
    return addressOfRest;
  }

  public String getSeoOfRest(){
    return seoOfRest;
  }
}
