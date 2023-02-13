package de.herrives.webclient.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonAnswer {
    private String id;
    private String object;
    private int created;
    private String model;
    private Choice[] choices;
    private Usage usage;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("object")
    public String getObject() {
        return object;
    }

    @JsonProperty("object")
    public void setObject(String object) {
        this.object = object;
    }

    @JsonProperty("created")
    public int getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(int created) {
        this.created = created;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("choices")
    public Choice[] getChoices() {
        return choices;
    }

    @JsonProperty("choices")
    public void setChoices(Choice[] choices) {
        this.choices = choices;
    }

    @JsonProperty("usage")
    public Usage getUsage() {
        return usage;
    }

    @JsonProperty("usage")
    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
