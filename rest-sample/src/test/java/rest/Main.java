package rest;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by slva on 12.08.2018.
 */
public class Main {
    public static void main(String[] args) {
        double a = 2223.3450000000;
        double b = 0.0000000000;
        NumberFormat nf = new DecimalFormat("#.######");
        System.out.println(nf.format(a));
        System.out.println(nf.format(b));
    }
}
