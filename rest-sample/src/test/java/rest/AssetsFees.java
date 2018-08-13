package rest;

public class AssetsFees {
    private String id;
    private String order_max;
    private String order_min;
    private String deposit_max;
    private String deposit_min;
    private String withdraw_max;
    private String withdraw_min;
    private String withdraw_fee;
    private String st;


    public String getSt() {
        return st;
    }

    public AssetsFees withSt(String st) {
        this.st = st;
        return this;
    }

    public String getId() {
        return id;
    }

    public AssetsFees withId(String id) {
        this.id = id;
        return this;
    }

    public String getOrder_max() {
        return order_max;
    }

    public AssetsFees withOrder_max(String order_max) {
        this.order_max = order_max;
        return this;
    }

    public String getOrder_min() {
        return order_min;
    }

    public AssetsFees withOrder_min(String order_min) {
        this.order_min = order_min;
        return this;
    }

    public String getDeposit_max() {
        return deposit_max;
    }

    public AssetsFees withDeposit_max(String deposit_max) {
        this.deposit_max = deposit_max;
        return this;
    }

    public String getDeposit_min() {
        return deposit_min;
    }

    public AssetsFees withDeposit_min(String deposit_min) {
        this.deposit_min = deposit_min;
        return this;
    }

    public String getWithdraw_max() {
        return withdraw_max;
    }

    public AssetsFees withWithdraw_max(String withdraw_max) {
        this.withdraw_max = withdraw_max;
        return this;
    }

    public String getWithdraw_min() {
        return withdraw_min;
    }

    public AssetsFees withWithdraw_min(String withdraw_min) {
        this.withdraw_min = withdraw_min;
        return this;
    }

    public String getWithdraw_fee() {
        return withdraw_fee;
    }

    public AssetsFees withWithdraw_fee(String withdraw_fee) {
        this.withdraw_fee = withdraw_fee;
        return this;
    }
}
