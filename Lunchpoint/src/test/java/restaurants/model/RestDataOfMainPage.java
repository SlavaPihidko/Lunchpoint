package restaurants.model;

public class RestDataOfMainPage {
  private final String nameOfRest;
  private final String addressOfRest;
  private String seoOfRest;
  private String descriptionOfRest;
  private String addressOnTheMapOfRest;
  private String gpsOfRest;
  private String indexOfRest;
  private String telOfRest;
  private String emailOfRest;
  private String bookingEmailOfRest;
  private String siteOfRest;

  public RestDataOfMainPage(String nameOfRest, String addressOfRest ) {
    this.nameOfRest = nameOfRest;
    this.addressOfRest = addressOfRest;
  }

  public RestDataOfMainPage(String nameOfRest,
                            String addressOfRest,
                            String seoOfRest,
                            String descriptionOfRest,
                            String addressOnTheMapOfRest,
                            String gpsOfRest,
                            String indexOfRest,
                            String telOfRest,
                            String emailOfRest,
                            String bookingEmailOfRest,
                            String siteOfRest) {
    this.nameOfRest = nameOfRest;
    this.addressOfRest = addressOfRest;
    this.seoOfRest = seoOfRest;
    this.descriptionOfRest = descriptionOfRest;
    this.addressOnTheMapOfRest = addressOnTheMapOfRest;
    this.gpsOfRest = gpsOfRest;
    this.indexOfRest = indexOfRest;
    this.telOfRest = telOfRest;
    this.emailOfRest = emailOfRest;
    this.bookingEmailOfRest = bookingEmailOfRest;
    this.siteOfRest = siteOfRest;
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

  public String getIndexOfRest() {
    return indexOfRest;
  }

  public String getTelOfRest() {
    return telOfRest;
  }

  public String getEmailOfRest() {
    return emailOfRest;
  }

  public String getBookingEmailOfRest() {
    return bookingEmailOfRest;
  }

  public String getSiteOfRest() {
    return siteOfRest;
  }
}
