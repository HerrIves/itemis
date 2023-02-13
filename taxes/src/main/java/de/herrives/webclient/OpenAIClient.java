package de.herrives.webclient;


import de.herrives.webclient.http.AIHttpRequest;
import de.herrives.webclient.http.HttpConfig;
import de.herrives.webclient.json.JsonAnswer;

public class OpenAIClient {
    HttpConfig config;

    public OpenAIClient(String endpoint, String apiKey) {
        config = new HttpConfig(endpoint, apiKey);

    }

    public boolean getAnswerFromAPI(String promptpattern, String itemname) {

        JsonAnswer answerJSON = new AIHttpRequest(config).getAnswer(promptpattern, itemname);
        String answerString = answerJSON.getChoices()[0].getText();

        return answerString.toLowerCase().contains("yes");
    }
}
