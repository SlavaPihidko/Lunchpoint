package restaurants.model;

/**
 * Created by Slava on 14.03.2017.
 */
public class AvgBillDataOfRest {

  private String avgSum1;
  private String avgSum2;
  private String avgSum3;
  private String avgSum4;
  private String avgSum5;

  public AvgBillDataOfRest(String avgSum1,String avgSum2, String avgSum3, String avgSum4, String avgSum5){
    this.avgSum1=avgSum1;
    this.avgSum2=avgSum2;
    this.avgSum3=avgSum3;
    this.avgSum4=avgSum4;
    this.avgSum5=avgSum5;
  }

  public  String getAvgSum1() {
    return avgSum1;
  }public String getAvgSum2() {
    return avgSum2;
  }public String getAvgSum3() {
    return avgSum3;
  }public String getAvgSum4() {
    return avgSum4;
  }public String getAvgSum5() {
    return avgSum5;
  }
}
