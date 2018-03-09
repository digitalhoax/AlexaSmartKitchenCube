
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
    "supportsRemoteStart",
    "enumeratedPowerLevels",
    "integralPowerLevels",
    "cookingModes"
})
public class Configuration {

    @JsonProperty("supportsRemoteStart")
    private Boolean supportsRemoteStart;
    @JsonProperty("enumeratedPowerLevels")
    private List<String> enumeratedPowerLevels = null;
    @JsonProperty("integralPowerLevels")
    private List<Object> integralPowerLevels = null;
    @JsonProperty("cookingModes")
    private List<String> cookingModes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("supportsRemoteStart")
    public Boolean getSupportsRemoteStart() {
        return supportsRemoteStart;
    }

    @JsonProperty("supportsRemoteStart")
    public void setSupportsRemoteStart(Boolean supportsRemoteStart) {
        this.supportsRemoteStart = supportsRemoteStart;
    }

    public Configuration withSupportsRemoteStart(Boolean supportsRemoteStart) {
        this.supportsRemoteStart = supportsRemoteStart;
        return this;
    }

    @JsonProperty("enumeratedPowerLevels")
    public List<String> getEnumeratedPowerLevels() {
        return enumeratedPowerLevels;
    }

    @JsonProperty("enumeratedPowerLevels")
    public void setEnumeratedPowerLevels(List<String> enumeratedPowerLevels) {
        this.enumeratedPowerLevels = enumeratedPowerLevels;
    }

    public Configuration withEnumeratedPowerLevels(List<String> enumeratedPowerLevels) {
        this.enumeratedPowerLevels = enumeratedPowerLevels;
        return this;
    }

    @JsonProperty("integralPowerLevels")
    public List<Object> getIntegralPowerLevels() {
        return integralPowerLevels;
    }

    @JsonProperty("integralPowerLevels")
    public void setIntegralPowerLevels(List<Object> integralPowerLevels) {
        this.integralPowerLevels = integralPowerLevels;
    }

    public Configuration withIntegralPowerLevels(List<Object> integralPowerLevels) {
        this.integralPowerLevels = integralPowerLevels;
        return this;
    }

    @JsonProperty("cookingModes")
    public List<String> getCookingModes() {
        return cookingModes;
    }

    @JsonProperty("cookingModes")
    public void setCookingModes(List<String> supportedCookingModes) {
        this.cookingModes = supportedCookingModes;
    }

    public Configuration withCookingModes(List<String> supportedCookingModes) {
        this.cookingModes = supportedCookingModes;
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

    public Configuration withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
