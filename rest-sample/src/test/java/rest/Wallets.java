package rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonElement;

/**
 * Created by slva on 10.08.2018.
 */

public class Wallets {
    //public Wallets(JsonElement result) {

    private int id;
    private double balance;
    private  String top_up_address;

    @JsonCreator
    public Wallets(@JsonProperty(value = "id", required = true) int id,
                   @JsonProperty(value = "balance", required = true) double balance,
                   @JsonProperty(value = "top_up_address", required = true) String top_up_address){
        this.id=id;
        this.balance=balance;
        this.top_up_address=top_up_address;
    }


    // }
   public int getId() {
       return id;
   }

    public Wallets withId(int id) {
        this.id = id;
        return this;
    }

    public double getBalance() {
        return balance;
    }

    public Wallets withBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public String getTop_up_address() {
        return top_up_address;
    }

    public Wallets withTop_up_address(String top_up_address) {
        this.top_up_address = top_up_address;
        return this;
    }

    @Override
    public String toString() {
        return "Wallets{" +
                "id=" + id +
                ", balance='" + balance + '\'' +
                ", top_up_address='" + top_up_address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wallets)) return false;

        Wallets wallets = (Wallets) o;

        if (getId() != wallets.getId()) return false;
        if (Double.compare(wallets.getBalance(), getBalance()) != 0) return false;
        return getTop_up_address() != null ? getTop_up_address().equals(wallets.getTop_up_address()) : wallets.getTop_up_address() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        temp = Double.doubleToLongBits(getBalance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getTop_up_address() != null ? getTop_up_address().hashCode() : 0);
        return result;
    }
}
