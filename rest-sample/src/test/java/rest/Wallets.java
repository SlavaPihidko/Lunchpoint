package rest;

/**
 * Created by slva on 10.08.2018.
 */
public class Wallets {
    public int getId() {
        return id;
    }

    public Wallets withId(int id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Wallets withCode(String code) {
        this.code = code;
        return this;
    }

    public String getChain() {
        return chain;
    }

    public Wallets withChain(String chain) {
        this.chain = chain;
        return this;
    }

    private int id;
    private String code;
    private String chain;
}
