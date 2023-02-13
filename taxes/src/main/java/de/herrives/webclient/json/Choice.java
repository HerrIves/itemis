package de.herrives.webclient.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {
    private String text;
    private int index;
    private String logprobs;
    private String finish_reason;

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("index")
    public int getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(int index) {
        this.index = index;
    }

    @JsonProperty("logprobs")
    public String getLogprobs() {
        return logprobs;
    }

    @JsonProperty("logprobs")
    public void setLogprobs(String logprobs) {
        this.logprobs = logprobs;
    }

    @JsonProperty("finish_reason")
    public String getFinishReason() {
        return finish_reason;
    }

    @JsonProperty("finish_reason")
    public void setFinishReason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "text='" + text + '\'' +
                ", index=" + index +
                ", logprobs='" + logprobs + '\'' +
                ", finish_reason='" + finish_reason + '\'' +
                '}';
    }
}
