package restaurants.model;

/**
 * Created by Slava on 06.02.2017.
 */
public class RestDataOfSiteList {

  private String nameOfRestList;

  public RestDataOfSiteList(String nameOfRestList){

    this.nameOfRestList = nameOfRestList;
  }

  public String getNameOfRestList() {
    return nameOfRestList;
  }

  @Override
  public String toString() {
    return "RestDataOfSiteList{" +
            "nameOfRestList='" + nameOfRestList + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    RestDataOfSiteList that = (RestDataOfSiteList) o;

    return nameOfRestList != null ? nameOfRestList.equals(that.nameOfRestList) : that.nameOfRestList == null;

  }

  @Override
  public int hashCode() {
    return nameOfRestList != null ? nameOfRestList.hashCode() : 0;
  }
}
