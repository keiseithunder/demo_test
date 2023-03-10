package com.example.demotest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.reactive.function.client.WebClient;

public class PostService {

  private final WebClient postWebClient;

  @Autowired
  public PostService(@Qualifier("postWebClient") WebClient postWebClient) {
    this.postWebClient = postWebClient;
  }

  public String getPost() {
    return postWebClient.get().uri("/posts/1").retrieve().bodyToMono(String.class).block();
  }

  public void getNoReturn() {
    postWebClient.get().uri("/posts/1").retrieve().bodyToMono(String.class).block();
  }

  public void posts(){
    postWebClient.post()
    .uri("/posts")
    .bodyValue(null)
    .retrieve()
    .bodyToMono(String.class)
    .block();
  }
}
