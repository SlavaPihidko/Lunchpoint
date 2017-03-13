package restaurants.model;

public class RestDataOfMainPage {
  private double lng;
  private int id;
  private String nameOfMainImg;
  private String nameOfRest;
  private String addressOfRest;
  private String seoOfRest;
  private String descriptionOfRest;
  private String addressOnTheMapOfRest;
  private String gpsOfRest;
  private String indexOfRest;
  private String telOfRest;
  private String emailOfRest;
  private String bookingEmailOfRest;
  private String siteOfRest;
  private String fbOfRest;
  private String instagramOfRest;
  private String twitterOfRest;
  private String networkOfRest;
  private String typeOfRest;
  private String typeOfCuisine;
  private String additionalServiceOfRest;
  private String otherFeaturesOfRest;

  public RestDataOfMainPage(String nameOfRest, String addressOfRest ) {
    this.nameOfRest = nameOfRest;
    this.addressOfRest = addressOfRest;
  }


   public RestDataOfMainPage(double lng,
                            int id,
                            String nameOfMainImg,
                            String nameOfRest,
                            String addressOfRest,
                            String seoOfRest,
                            String descriptionOfRest,
                            String addressOnTheMapOfRest,
                            String gpsOfRest,
                            String indexOfRest,
                            String telOfRest,
                            String emailOfRest,
                            String bookingEmailOfRest,
                            String siteOfRest,
                            String fbOfRest,
                            String instagramOfRest,
                            String twitterOfRest,
                            String networkOfRest,
                            String typeOfRest,
                            String typeOfCuisine,
                            String additionalServiceOfRest,
                            String otherFeaturesOfRest) {
    this.lng = lng;
    this.id = id;
    this.nameOfMainImg = nameOfMainImg;
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
    this.fbOfRest = fbOfRest;
    this.instagramOfRest = instagramOfRest;
    this.twitterOfRest = twitterOfRest;
    this.networkOfRest = networkOfRest;
    this.typeOfRest = typeOfRest;
    this.typeOfCuisine = typeOfCuisine;
    this.additionalServiceOfRest = additionalServiceOfRest;
    this.otherFeaturesOfRest = otherFeaturesOfRest;
  }

  public double getLng() {
    return lng;
  }

  public int getId() {
    return id;
  }

  public String getNameOfMainImg() {
    return nameOfMainImg;
  }

  public String getNameOfRest() {
    return nameOfRest;
  }

  public String getAddressOfRest() {
    return addressOfRest;
  }

  public String getSeoUrlOfRest() {
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

  public String getFbOfRest() {
    return fbOfRest;
  }

  public String getInstagramOfRest() {
    return instagramOfRest;
  }

  public String getTwitterOfRest() {
    return twitterOfRest;
  }

  public String getNetworkOfRest() {
    return networkOfRest;
  }

  public String getTypeOfRest() {
    return typeOfRest;
  }

  public String getTypeOfCuisine() {
    return typeOfCuisine;
  }

  public String getAdditionalServiceOfRest() {
    return additionalServiceOfRest;
  }

  public String getOtherFeaturesOfRest() {
    return otherFeaturesOfRest;
  }
}
