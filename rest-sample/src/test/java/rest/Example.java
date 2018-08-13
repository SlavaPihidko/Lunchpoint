package rest;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "primer"
})

public class Example {

    @JsonProperty("primer")
    private Set<Wallets> primer =null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("primer")
    public Set<Wallets> getPrimer() {
        return primer;
    }
    @JsonProperty("primer")
    public void setPrimer(Set<Wallets> primer) {
        this.primer = primer;
    }
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}


