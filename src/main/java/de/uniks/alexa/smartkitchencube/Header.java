
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
    "payloadVersion",
    "messageId",
    "correlationToken"
})
public class Header {

    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("name")
    private String name;
    @JsonProperty("payloadVersion")
    private String payloadVersion;
    @JsonProperty("messageId")
    private String messageId;
    @JsonProperty("correlationToken")
    private String correlationToken;
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

    public Header withNamespace(String namespace) {
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

    public Header withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("payloadVersion")
    public String getPayloadVersion() {
        return payloadVersion;
    }

    @JsonProperty("payloadVersion")
    public void setPayloadVersion(String payloadVersion) {
        this.payloadVersion = payloadVersion;
    }

    public Header withPayloadVersion(String payloadVersion) {
        this.payloadVersion = payloadVersion;
        return this;
    }

    @JsonProperty("messageId")
    public String getMessageId() {
        return messageId;
    }

    @JsonProperty("messageId")
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Header withMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    @JsonProperty("correlationToken")
    public String getCorrelationToken() {
        return correlationToken;
    }

    @JsonProperty("correlationToken")
    public void setCorrelationToken(String correlationToken) {
        this.correlationToken = correlationToken;
    }

    public Header withCorrelationToken(String correlationToken) {
        this.correlationToken = correlationToken;
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

    public Header withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
