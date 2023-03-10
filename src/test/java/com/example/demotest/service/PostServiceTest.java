package com.example.demotest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
  
  @InjectMocks
  private PostService postService;

  @Mock
  private WebClient webClient;

  @Mock
  private WebClient.RequestHeadersSpec requestHeadersMock;
  @Mock
  private WebClient.RequestHeadersUriSpec requestHeadersUriMock;
  @Mock
  private WebClient.RequestBodySpec requestBodyMock;
  @Mock
  private WebClient.RequestBodyUriSpec requestBodyUriMock;
  @Mock
  private WebClient.ResponseSpec responseMock;

  @Mock
  private WebClient.RequestBodyUriSpec requestBodyUriSpecMock;
  @Mock
  private WebClient.RequestBodySpec requestBodySpecMock;

  @Mock
  private WebClient.RequestHeadersSpec requestHeadersSpecMock;

  @BeforeEach
  void setUp() {
    this.postService = new PostService(webClient); 
  }

  @Test
  public void test(){
    when(webClient.get()).thenReturn(requestHeadersUriMock);
    when(requestHeadersUriMock.uri(anyString())).thenReturn(requestHeadersMock);
    when(requestHeadersMock.retrieve()).thenReturn(responseMock);
    when(responseMock.bodyToMono(String.class)).thenReturn(Mono.justOrEmpty("response"));

    String res = this.postService.getPost();
    assertEquals(res, "response");
  }

  @Test
  public void testIsFuntionWasCall(){
    when(webClient.get()).thenReturn(requestHeadersUriMock);
    when(requestHeadersUriMock.uri(anyString())).thenReturn(requestHeadersMock);
    when(requestHeadersMock.retrieve()).thenReturn(responseMock);
    when(responseMock.bodyToMono(String.class)).thenReturn(Mono.justOrEmpty("response"));
    this.postService.getNoReturn();
    verify(webClient, times(1)).get();
  }

  @Test
  public void testPostIsFuntionWasCall(){
    when(webClient.post()).thenReturn(requestBodyUriSpecMock);
    when(requestBodyUriSpecMock.uri(anyString())).thenReturn(requestBodySpecMock);
    when(requestBodySpecMock.bodyValue(any())).thenReturn(requestHeadersSpecMock);
    when(requestHeadersSpecMock.retrieve()).thenReturn(responseMock);
    when(responseMock.bodyToMono(String.class)).thenReturn(Mono.justOrEmpty("response"));
    this.postService.posts();
    verify(webClient, times(1)).post();
  }

}
