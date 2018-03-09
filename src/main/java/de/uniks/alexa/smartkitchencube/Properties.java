
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
    "supported",
    "proactivelyReported",
    "retrievable"
})
public class Properties {

    @JsonProperty("supported")
    private List<Supported> supported = null;
    @JsonProperty("proactivelyReported")
    private Boolean proactivelyReported;
    @JsonProperty("retrievable")
    private Boolean retrievable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("supported")
    public List<Supported> getSupported() {
        return supported;
    }

    @JsonProperty("supported")
    public void setSupported(List<Supported> supported) {
        this.supported = supported;
    }

    public Properties withSupported(List<Supported> supported) {
        this.supported = supported;
        return this;
    }

    @JsonProperty("proactivelyReported")
    public Boolean getProactivelyReported() {
        return proactivelyReported;
    }

    @JsonProperty("proactivelyReported")
    public void setProactivelyReported(Boolean proactivelyReported) {
        this.proactivelyReported = proactivelyReported;
    }

    public Properties withProactivelyReported(Boolean proactivelyReported) {
        this.proactivelyReported = proactivelyReported;
        return this;
    }

    @JsonProperty("retrievable")
    public Boolean getRetrievable() {
        return retrievable;
    }

    @JsonProperty("retrievable")
    public void setRetrievable(Boolean retrievable) {
        this.retrievable = retrievable;
    }

    public Properties withRetrievable(Boolean retrievable) {
        this.retrievable = retrievable;
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

    public Properties withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
