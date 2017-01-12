package restaurants.model;

public class RestDataOfMainPage {
  private final String nameOfRest;
  private final String addressOfRest;
  private String seoOfRest;
  private String descriptionOfRest;

  public RestDataOfMainPage(String nameOfRest, String addressOfRest ) {
    this.nameOfRest = nameOfRest;
    this.addressOfRest = addressOfRest;
  }

  public RestDataOfMainPage(String nameOfRest, String addressOfRest, String seoOfRest, String descriptionOfRest ) {
    this.nameOfRest = nameOfRest;
    this.addressOfRest = addressOfRest;
    this.seoOfRest = seoOfRest;
    this.descriptionOfRest = descriptionOfRest;
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

  public String getDescriptionOfRest() {
    return descriptionOfRest;
  }
}
