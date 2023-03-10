package com.example.demotest.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfigImpl implements WebClientConfig {

  @Override
  @Qualifier("postWebClient")
  public WebClient webClient() {
    WebClient client = WebClient.builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
    return client;
  }

}
