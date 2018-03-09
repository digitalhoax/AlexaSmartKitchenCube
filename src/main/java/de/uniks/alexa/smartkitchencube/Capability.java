
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
    "type",
    "interface",
    "version",
    "properties",
    "supportsDeactivation",
    "proactivelyReported",
    "cameraStreamConfigurations",
    "configuration"
})
public class Capability {

    @JsonProperty("type")
    private String type;
    @JsonProperty("interface")
    private String _interface;
    @JsonProperty("version")
    private String version;
    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("supportsDeactivation")
    private Boolean supportsDeactivation;
    @JsonProperty("proactivelyReported")
    private Boolean proactivelyReported;
    @JsonProperty("cameraStreamConfigurations")
    private List<CameraStreamConfiguration> cameraStreamConfigurations = null;
    @JsonProperty("configuration")
    private Configuration configuration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Capability withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("interface")
    public String getInterface() {
        return _interface;
    }

    @JsonProperty("interface")
    public void setInterface(String _interface) {
        this._interface = _interface;
    }

    public Capability withInterface(String _interface) {
        this._interface = _interface;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Capability withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Capability withProperties(Properties properties) {
        this.properties = properties;
        return this;
    }

    @JsonProperty("supportsDeactivation")
    public Boolean getSupportsDeactivation() {
        return supportsDeactivation;
    }

    @JsonProperty("supportsDeactivation")
    public void setSupportsDeactivation(Boolean supportsDeactivation) {
        this.supportsDeactivation = supportsDeactivation;
    }

    public Capability withSupportsDeactivation(Boolean supportsDeactivation) {
        this.supportsDeactivation = supportsDeactivation;
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

    public Capability withProactivelyReported(Boolean proactivelyReported) {
        this.proactivelyReported = proactivelyReported;
        return this;
    }

    @JsonProperty("cameraStreamConfigurations")
    public List<CameraStreamConfiguration> getCameraStreamConfigurations() {
        return cameraStreamConfigurations;
    }

    @JsonProperty("cameraStreamConfigurations")
    public void setCameraStreamConfigurations(List<CameraStreamConfiguration> cameraStreamConfigurations) {
        this.cameraStreamConfigurations = cameraStreamConfigurations;
    }

    public Capability withCameraStreamConfigurations(List<CameraStreamConfiguration> cameraStreamConfigurations) {
        this.cameraStreamConfigurations = cameraStreamConfigurations;
        return this;
    }

    @JsonProperty("configuration")
    public Configuration getConfiguration() {
        return configuration;
    }

    @JsonProperty("configuration")
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Capability withConfiguration(Configuration configuration) {
        this.configuration = configuration;
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

    public Capability withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
