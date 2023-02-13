package de.herrives.webclient.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usage {
    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;

    @JsonProperty("prompt_tokens")
    public int getPromptTokens() {
        return prompt_tokens;
    }

    @JsonProperty("prompt_tokens")
    public void setPromptTokens(int prompt_tokens) {
        this.prompt_tokens = prompt_tokens;
    }

    @JsonProperty("completion_tokens")
    public int getCompletionTokens() {
        return completion_tokens;
    }

    @JsonProperty("completion_tokens")
    public void setCompletionTokens(int completion_tokens) {
        this.completion_tokens = completion_tokens;
    }

    @JsonProperty("total_tokens")
    public int getTotalTokens() {
        return total_tokens;
    }

    @JsonProperty("total_tokens")
    public void setTotalTokens(int total_tokens) {
        this.total_tokens = total_tokens;
    }
}
