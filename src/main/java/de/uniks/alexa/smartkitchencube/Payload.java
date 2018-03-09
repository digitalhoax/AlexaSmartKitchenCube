
package de.uniks.alexa.smartkitchencube;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scope"
})
public class Payload {

    @JsonProperty("scope")
    private Scope scope;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cookTime")
    private String cookTime;
    
    @JsonProperty("cookTime")
    public String getCookTime() {
        return cookTime;
    }

    @JsonProperty("cookTime")
    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }
    
    public Payload withCookTime(String cookTime) {
    	this.cookTime = cookTime;
    	return this;
    }

    @JsonProperty("cookTimeDelta")
    private String cookTimeDelta;
    
    @JsonProperty("cookTimeDelta")
    public String getCookTimeDelta() {
        return cookTimeDelta;
    }

    @JsonProperty("cookTimeDelta")
    public void setCookTimeDelta(String cookTimeDelta) {
        this.cookTimeDelta = cookTimeDelta;
    }

    public Payload withCookTimeDelta(String cookTimeDelta) {
        this.cookTimeDelta = cookTimeDelta;
        return this;
    }
    
    @JsonProperty("scope")
    public Scope getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public Payload withScope(Scope scope) {
        this.scope = scope;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Payload withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
    
    @JsonProperty("endpoints")
    private List<Endpoint> endpoints = null;
    @JsonIgnore

    @JsonProperty("endpoints")
    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    @JsonProperty("endpoints")
    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }

    public Payload withEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
        return this;
    }


}
