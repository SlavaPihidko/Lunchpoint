package rest;

import com.google.gson.JsonElement;

/**
 * Created by slva on 10.08.2018.
 */
public class Wallets {
    //public Wallets(JsonElement result) {

    private int id;
    private String balance;
    private  String top_up_address;

   // }
   public int getId() {
       return id;
   }

    public Wallets withId(int id) {
        this.id = id;
        return this;
    }

    public String getBalance() {
        return balance;
    }

    public Wallets withBalance(String balance) {
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
}
