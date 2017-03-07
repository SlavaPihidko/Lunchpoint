package restaurants.tests;

import org.testng.annotations.Test;

/**
 * Created by Slava on 07.03.2017.
 */
public class Yarik
{
  @Test
  public void yarikTest(){
    Integer st1 =0;
    Integer st2 =1;
    Integer st3 =2;
    Integer st4 =4;
    Integer st5 =127;
    Integer st6 =400;

    Integer st10 =0;
    Integer st20 =1;
    Integer st30 =2;
    Integer st40 =4;
    Integer st50 =127;
    Integer st60 =400;

    Object o = 400;


    System.out.println(String.valueOf(st1)+" ravnu "+(st1==st10));
    System.out.println(String.valueOf(st2)+" ravnu "+(st2==st20));
    System.out.println(String.valueOf(st3)+" ravnu "+(st3==st30));
    System.out.println(String.valueOf(st4)+" ravnu "+(st4==st40));
    System.out.println(String.valueOf(st5)+" ravnu "+(st5==st50));
    System.out.println(String.valueOf(st6)+" ravnu "+(st6.equals(o)));



  }
}
