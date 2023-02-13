package de.herrives.webclient.http;

public class HttpConfig {
    final String ENDPOINT;
    final String APIKEY;

    public HttpConfig(String endpoint, String apiKey) {
        this.ENDPOINT = endpoint;
        this.APIKEY = apiKey;
    }
}
