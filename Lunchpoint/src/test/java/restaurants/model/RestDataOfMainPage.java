package restaurants.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@XStreamAlias("RestDataOfMainPage")
public class RestDataOfMainPage {
  @XStreamOmitField
  private double lng;
  @XStreamOmitField
  private int id;
  private String nameOfMainImg;
  @Expose
  private String nameOfRest;
  @Expose
  private String addressOfRest;
  @Expose
  private String seoOfRest;
  private String descriptionOfRest;
  private String addressOnTheMapOfRest;
  private String gpsOfRest;
  @Expose
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

  List<RestDataOfMainPage> restData;

  public List<RestDataOfMainPage> getRestData() {
    return restData;
  }
  /*public RestDataOfMainPage(String nameOfRest, String addressOfRest ) {
    this.nameOfRest = nameOfRest;
    this.addressOfRest = addressOfRest;
  }*/

/*
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
*/
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

/*
  public void setLng(double lng) {
    this.lng = lng;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setNameOfMainImg(String nameOfMainImg) {
    this.nameOfMainImg = nameOfMainImg;
  }

  public void setNameOfRest(String nameOfRest) {
    this.nameOfRest = nameOfRest;
  }

  public void setAddressOfRest(String addressOfRest) {
    this.addressOfRest = addressOfRest;
  }

  public void setSeoOfRest(String seoOfRest) {
    this.seoOfRest = seoOfRest;
  }

  public void setDescriptionOfRest(String descriptionOfRest) {
    this.descriptionOfRest = descriptionOfRest;
  }

  public void setAddressOnTheMapOfRest(String addressOnTheMapOfRest) {
    this.addressOnTheMapOfRest = addressOnTheMapOfRest;
  }

  public void setGpsOfRest(String gpsOfRest) {
    this.gpsOfRest = gpsOfRest;
  }

  public void setIndexOfRest(String indexOfRest) {
    this.indexOfRest = indexOfRest;
  }

  public void setTelOfRest(String telOfRest) {
    this.telOfRest = telOfRest;
  }

  public void setEmailOfRest(String emailOfRest) {
    this.emailOfRest = emailOfRest;
  }

  public void setBookingEmailOfRest(String bookingEmailOfRest) {
    this.bookingEmailOfRest = bookingEmailOfRest;
  }

  public void setSiteOfRest(String siteOfRest) {
    this.siteOfRest = siteOfRest;
  }

  public void setFbOfRest(String fbOfRest) {
    this.fbOfRest = fbOfRest;
  }

  public void setInstagramOfRest(String instagramOfRest) {
    this.instagramOfRest = instagramOfRest;
  }

  public void setTwitterOfRest(String twitterOfRest) {
    this.twitterOfRest = twitterOfRest;
  }

  public void setNetworkOfRest(String networkOfRest) {
    this.networkOfRest = networkOfRest;
  }

  public void setTypeOfRest(String typeOfRest) {
    this.typeOfRest = typeOfRest;
  }

  public void setTypeOfCuisine(String typeOfCuisine) {
    this.typeOfCuisine = typeOfCuisine;
  }

  public void setAdditionalServiceOfRest(String additionalServiceOfRest) {
    this.additionalServiceOfRest = additionalServiceOfRest;
  }

  public void setOtherFeaturesOfRest(String otherFeaturesOfRest) {
    this.otherFeaturesOfRest = otherFeaturesOfRest;
  }
*/
  public RestDataOfMainPage withLng(double lng) {
    this.lng = lng;
    return this;
  }

  public RestDataOfMainPage withId(int id) {
    this.id = id;
    return this;
  }

  public RestDataOfMainPage withNameOfMainImg(String nameOfMainImg) {
    this.nameOfMainImg = nameOfMainImg;
    return this;
  }

  public RestDataOfMainPage withNameOfRest(String nameOfRest) {
    this.nameOfRest = nameOfRest;
    return this;
  }

  public RestDataOfMainPage withAddressOfRest(String addressOfRest) {
    this.addressOfRest = addressOfRest;
    return this;
  }

  public RestDataOfMainPage withSeoOfRest(String seoOfRest) {
    this.seoOfRest = seoOfRest;
    return this;
  }

  public RestDataOfMainPage withDescriptionOfRest(String descriptionOfRest) {
    this.descriptionOfRest = descriptionOfRest;
    return this;
  }

  public RestDataOfMainPage withAddressOnTheMapOfRest(String addressOnTheMapOfRest) {
    this.addressOnTheMapOfRest = addressOnTheMapOfRest;
    return this;
  }

  public RestDataOfMainPage withGpsOfRest(String gpsOfRest) {
    this.gpsOfRest = gpsOfRest;
    return this;
  }

  public RestDataOfMainPage withIndexOfRest(String indexOfRest) {
    this.indexOfRest = indexOfRest;
    return this;
  }

  public RestDataOfMainPage withTelOfRest(String telOfRest) {
    this.telOfRest = telOfRest;
    return this;
  }

  public RestDataOfMainPage withEmailOfRest(String emailOfRest) {
    this.emailOfRest = emailOfRest;
    return this;
  }

  public RestDataOfMainPage withBookingEmailOfRest(String bookingEmailOfRest) {
    this.bookingEmailOfRest = bookingEmailOfRest;
    return this;
  }

  public RestDataOfMainPage withSiteOfRest(String siteOfRest) {
    this.siteOfRest = siteOfRest;
    return this;
  }

  public RestDataOfMainPage withFbOfRest(String fbOfRest) {
    this.fbOfRest = fbOfRest;
    return this;
  }

  public RestDataOfMainPage withInstagramOfRest(String instagramOfRest) {
    this.instagramOfRest = instagramOfRest;
    return this;
  }

  public RestDataOfMainPage withTwitterOfRest(String twitterOfRest) {
    this.twitterOfRest = twitterOfRest;
    return this;
  }

  public RestDataOfMainPage withNetworkOfRest(String networkOfRest) {
    this.networkOfRest = networkOfRest;
    return this;
  }

  public RestDataOfMainPage withTypeOfRest(String typeOfRest) {
    this.typeOfRest = typeOfRest;
    return this;
  }

  public RestDataOfMainPage withTypeOfCuisine(String typeOfCuisine) {
    this.typeOfCuisine = typeOfCuisine;
    return this;
  }

  public RestDataOfMainPage withAdditionalServiceOfRest(String additionalServiceOfRest) {
    this.additionalServiceOfRest = additionalServiceOfRest;
    return this;
  }

  public RestDataOfMainPage withOtherFeaturesOfRest(String otherFeaturesOfRest) {
    this.otherFeaturesOfRest = otherFeaturesOfRest;
    return this;
  }
}
