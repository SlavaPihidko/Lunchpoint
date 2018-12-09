package structure.tests;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by slva on 10.08.2018.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "balance",
        "top_up_address"
})
public class Wallets {
    @JsonProperty("id")
    private int id;
    @JsonProperty("balance")
    private double balance;
    @JsonProperty("top_up_address")
    private  String top_up_address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();



    public Wallets( int id,
                    double balance,
                    String top_up_address){
        this.id=id;
        this.balance=balance;
        this.top_up_address=top_up_address;
    }

    public Wallets(){}

    @JsonProperty("id")
   public int getId() {
       return id;
   }

    @JsonProperty("id")
    public Wallets withId(int id) {
        this.id = id;
        return this;
    }

    @JsonProperty("balance")
    public double getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public Wallets withBalance(double balance) {
        this.balance = balance;
        return this;
    }

    @JsonProperty("top_up_address")
    public String getTop_up_address() {
        return top_up_address;
    }

    @JsonProperty("top_up_address")
    public Wallets withTop_up_address(String top_up_address) {
        this.top_up_address = top_up_address;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
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
