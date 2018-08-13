package rest;

public class AssetsFees {
    private int id;
    private double order_max;
    private double order_min;
    private double deposit_max;
    private double deposit_min;
    private double withdraw_max;
    private double withdraw_min;
    private double withdraw_fee;
    private String st;


    public String getSt() {
        return st;
    }

    public AssetsFees withSt(String st) {
        this.st = st;
        return this;
    }

    public int getId() {
        return id;
    }

    public AssetsFees withId(int id) {
        this.id = id;
        return this;
    }

    public double getOrder_max() {
        return order_max;
    }

    public AssetsFees withOrder_max(double order_max) {
        this.order_max = order_max;
        return this;
    }

    public double getOrder_min() {
        return order_min;
    }

    public AssetsFees withOrder_min(double order_min) {
        this.order_min = order_min;
        return this;
    }

    public double getDeposit_max() {
        return deposit_max;
    }

    public AssetsFees withDeposit_max(double deposit_max) {
        this.deposit_max = deposit_max;
        return this;
    }

    public double getDeposit_min() {
        return deposit_min;
    }

    public AssetsFees withDeposit_min(double deposit_min) {
        this.deposit_min = deposit_min;
        return this;
    }

    public double getWithdraw_max() {
        return withdraw_max;
    }

    public AssetsFees withWithdraw_max(double withdraw_max) {
        this.withdraw_max = withdraw_max;
        return this;
    }

    public double getWithdraw_min() {
        return withdraw_min;
    }

    public AssetsFees withWithdraw_min(double withdraw_min) {
        this.withdraw_min = withdraw_min;
        return this;
    }

    public double getWithdraw_fee() {
        return withdraw_fee;
    }

    public AssetsFees withWithdraw_fee(double withdraw_fee) {
        this.withdraw_fee = withdraw_fee;
        return this;
    }
}
