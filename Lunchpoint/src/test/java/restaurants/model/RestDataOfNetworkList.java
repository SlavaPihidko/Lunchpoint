package restaurants.model;

import java.sql.ResultSet;

/**
 * Created by Slava on 03.03.2017.
 */
public class RestDataOfNetworkList {
  private int id;
  private String nameNetwork;

  public RestDataOfNetworkList(int id, String nameNetwork) {
    this.id=id;
    this.nameNetwork=nameNetwork;
  }

  public RestDataOfNetworkList(String nameNetwork){
    this.nameNetwork=nameNetwork;

  }

  @Override
  public String toString() {
    return "RestDataOfNetworkList{" +
            "nameNetwork='" + nameNetwork + '\'' +
            '}';
  }

  public String getNameNetwork() {
    return nameNetwork;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    RestDataOfNetworkList that = (RestDataOfNetworkList) o;

    return nameNetwork != null ? nameNetwork.equals(that.nameNetwork) : that.nameNetwork == null;

  }

  @Override
  public int hashCode() {
    return nameNetwork != null ? nameNetwork.hashCode() : 0;
  }
}
