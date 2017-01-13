package restaurants.model;

public class RestDataOfMainPage {
  private final String nameOfRest;
  private final String addressOfRest;
  private String seoOfRest;
  private String descriptionOfRest;
  private String addressOnTheMapOfRest;
  private String gpsOfRest;

  public RestDataOfMainPage(String nameOfRest, String addressOfRest ) {
    this.nameOfRest = nameOfRest;
    this.addressOfRest = addressOfRest;
  }

  public RestDataOfMainPage(String nameOfRest,
                            String addressOfRest,
                            String seoOfRest,
                            String descriptionOfRest,
                            String addressOnTheMapOfRest,
                            String gpsOfRest) {
    this.nameOfRest = nameOfRest;
    this.addressOfRest = addressOfRest;
    this.seoOfRest = seoOfRest;
    this.descriptionOfRest = descriptionOfRest;
    this.addressOnTheMapOfRest = addressOnTheMapOfRest;
    this.gpsOfRest = gpsOfRest;
  }

  public String getNameOfRest() {
    return nameOfRest;
  }

  public String getAddressOfRest() {
    return addressOfRest;
  }

  public String getSeoOfRest() {
    return seoOfRest;
  }

  public String getDescriptionOfRest() {
    return descriptionOfRest;
  }

  public String getAddressOnTheMapOfRest() {
    return addressOnTheMapOfRest;
  }

  public String getGpsOfRest() {
    return gpsOfRest;
  }
}
