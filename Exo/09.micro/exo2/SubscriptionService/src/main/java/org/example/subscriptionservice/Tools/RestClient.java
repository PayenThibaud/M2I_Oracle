package org.example.subscriptionservice.Tools;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient<T> {
    private String urlApi ;
    private RestTemplate template;
    private HttpHeaders httpHeaders;

    public RestClient(String urlApi) {
        this.urlApi = urlApi;
        template = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.add("content-type", "application/json");

    }

    public T postRequest(String json, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>(json,httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApi, HttpMethod.POST, requestEntity, type);
        if(response.hasBody()) {
            return response.getBody();
        }
        return null;
    }
    public T getRequest( Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("",httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApi, HttpMethod.GET, requestEntity, type);
        if(response.hasBody()) {
            return response.getBody();
        }
        return null;
    }

    public T putRequest(String json, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>(json, httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApi, HttpMethod.PUT, requestEntity, type);
        return response.hasBody() ? response.getBody() : null;
    }

    public void deleteRequest() {
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        template.exchange(urlApi, HttpMethod.DELETE, requestEntity, Void.class);
    }
}
