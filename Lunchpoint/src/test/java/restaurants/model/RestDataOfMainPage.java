package restaurants.model;

public class RestDataOfMainPage {
  private final String nameOfRest;
  private final String addressOfRest;

  public RestDataOfMainPage(String nameOfRest, String addressOfRest) {
    this.nameOfRest = nameOfRest;
    this.addressOfRest = addressOfRest;
  }

  public String getNameOfRest() {
    return nameOfRest;
  }

  public String  getAddressOfRest(){
    return addressOfRest;
  }
}
