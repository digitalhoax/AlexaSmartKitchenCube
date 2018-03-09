
package de.uniks.alexa.smartkitchencube;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "namespace",
    "name",
    "value",
    "timeOfSample",
    "uncertaintyInMilliseconds"
})
public class Property {

    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;
    @JsonProperty("timeOfSample")
    private String timeOfSample;
    @JsonProperty("uncertaintyInMilliseconds")
    private Integer uncertaintyInMilliseconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Property withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Property withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public Property withValue(String value) {
        this.value = value;
        return this;
    }

    @JsonProperty("timeOfSample")
    public String getTimeOfSample() {
        return timeOfSample;
    }

    @JsonProperty("timeOfSample")
    public void setTimeOfSample(String timeOfSample) {
        this.timeOfSample = timeOfSample;
    }

    public Property withTimeOfSample(String timeOfSample) {
        this.timeOfSample = timeOfSample;
        return this;
    }

    @JsonProperty("uncertaintyInMilliseconds")
    public Integer getUncertaintyInMilliseconds() {
        return uncertaintyInMilliseconds;
    }

    @JsonProperty("uncertaintyInMilliseconds")
    public void setUncertaintyInMilliseconds(Integer uncertaintyInMilliseconds) {
        this.uncertaintyInMilliseconds = uncertaintyInMilliseconds;
    }

    public Property withUncertaintyInMilliseconds(Integer uncertaintyInMilliseconds) {
        this.uncertaintyInMilliseconds = uncertaintyInMilliseconds;
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

    public Property withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
