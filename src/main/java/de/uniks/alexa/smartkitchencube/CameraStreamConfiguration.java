
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
    "protocols",
    "resolutions",
    "authorizationTypes",
    "videoCodecs",
    "audioCodecs"
})
public class CameraStreamConfiguration {

    @JsonProperty("protocols")
    private List<String> protocols = null;
    @JsonProperty("resolutions")
    private List<Resolution> resolutions = null;
    @JsonProperty("authorizationTypes")
    private List<String> authorizationTypes = null;
    @JsonProperty("videoCodecs")
    private List<String> videoCodecs = null;
    @JsonProperty("audioCodecs")
    private List<String> audioCodecs = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("protocols")
    public List<String> getProtocols() {
        return protocols;
    }

    @JsonProperty("protocols")
    public void setProtocols(List<String> protocols) {
        this.protocols = protocols;
    }

    public CameraStreamConfiguration withProtocols(List<String> protocols) {
        this.protocols = protocols;
        return this;
    }

    @JsonProperty("resolutions")
    public List<Resolution> getResolutions() {
        return resolutions;
    }

    @JsonProperty("resolutions")
    public void setResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    public CameraStreamConfiguration withResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
        return this;
    }

    @JsonProperty("authorizationTypes")
    public List<String> getAuthorizationTypes() {
        return authorizationTypes;
    }

    @JsonProperty("authorizationTypes")
    public void setAuthorizationTypes(List<String> authorizationTypes) {
        this.authorizationTypes = authorizationTypes;
    }

    public CameraStreamConfiguration withAuthorizationTypes(List<String> authorizationTypes) {
        this.authorizationTypes = authorizationTypes;
        return this;
    }

    @JsonProperty("videoCodecs")
    public List<String> getVideoCodecs() {
        return videoCodecs;
    }

    @JsonProperty("videoCodecs")
    public void setVideoCodecs(List<String> videoCodecs) {
        this.videoCodecs = videoCodecs;
    }

    public CameraStreamConfiguration withVideoCodecs(List<String> videoCodecs) {
        this.videoCodecs = videoCodecs;
        return this;
    }

    @JsonProperty("audioCodecs")
    public List<String> getAudioCodecs() {
        return audioCodecs;
    }

    @JsonProperty("audioCodecs")
    public void setAudioCodecs(List<String> audioCodecs) {
        this.audioCodecs = audioCodecs;
    }

    public CameraStreamConfiguration withAudioCodecs(List<String> audioCodecs) {
        this.audioCodecs = audioCodecs;
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

    public CameraStreamConfiguration withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
