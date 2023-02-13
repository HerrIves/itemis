package de.herrives.webclient.http;

import de.herrives.webclient.json.JsonAnswer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class AIHttpRequest {
    String prompt;
    final HttpConfig config;
    RestTemplate template;

    public AIHttpRequest(HttpConfig config) {
        this.config = config;
        template = new RestTemplate();
    }

    public JsonAnswer getAnswer(String promptpattern, String itemname) {
        prompt = String.format(promptpattern, itemname);

        return template.postForObject(config.ENDPOINT, request(), JsonAnswer.class);
    }

    private HttpEntity<Map<String, Object>> request() {
        return new HttpEntity<>(jsonBody(), jsonHeader());
    }


    private Map<String, Object> jsonBody(){
        Map<String, Object> jsonToSend = new HashMap<>();
        jsonToSend.put("model", "text-davinci-001");
        jsonToSend.put("prompt", prompt);
        jsonToSend.put("max_tokens", 1024);
        jsonToSend.put("temperature", 0.5);

        return jsonToSend;
    }

    private HttpHeaders jsonHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + config.APIKEY);

        return headers;
    }

}
