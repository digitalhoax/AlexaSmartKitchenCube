
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
    "endpointId",
    "manufacturerName",
    "friendlyName",
    "description",
    "displayCategories",
    "cookie",
    "capabilities"
})
public class Endpoint {

	@JsonProperty("scope")
    private Scope scope;
    @JsonProperty("endpointId")
    private String endpointId;
    @JsonProperty("manufacturerName")
    private String manufacturerName;
    @JsonProperty("friendlyName")
    private String friendlyName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayCategories")
    private List<String> displayCategories = null;
    @JsonProperty("cookie")
    private Cookie cookie;
    @JsonProperty("capabilities")
    private List<Capability> capabilities = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("endpointId")
    public String getEndpointId() {
        return endpointId;
    }

    @JsonProperty("endpointId")
    public void setEndpointId(String endpointId) {
        this.endpointId = endpointId;
    }

    public Endpoint withEndpointId(String endpointId) {
        this.endpointId = endpointId;
        return this;
    }

    @JsonProperty("manufacturerName")
    public String getManufacturerName() {
        return manufacturerName;
    }

    @JsonProperty("manufacturerName")
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Endpoint withManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }

    @JsonProperty("friendlyName")
    public String getFriendlyName() {
        return friendlyName;
    }

    @JsonProperty("friendlyName")
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public Endpoint withFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Endpoint withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("displayCategories")
    public List<String> getDisplayCategories() {
        return displayCategories;
    }

    @JsonProperty("displayCategories")
    public void setDisplayCategories(List<String> displayCategories) {
        this.displayCategories = displayCategories;
    }

    public Endpoint withDisplayCategories(List<String> displayCategories) {
        this.displayCategories = displayCategories;
        return this;
    }

    @JsonProperty("cookie")
    public Cookie getCookie() {
        return cookie;
    }

    @JsonProperty("cookie")
    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public Endpoint withCookie(Cookie cookie) {
        this.cookie = cookie;
        return this;
    }

    @JsonProperty("capabilities")
    public List<Capability> getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }

    public Endpoint withCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
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

    public Endpoint withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
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

    public Endpoint withScope(Scope scope) {
        this.scope = scope;
        return this;
    }


}
