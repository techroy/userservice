package com.consumer.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestTemlateConsumer {

	public static void main(String[] args) {
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		MultiValueMap<String, String> headersMap =  new LinkedMultiValueMap<String, String>();
		headersMap.add("content-type", "application/json");
		headersMap.add("Accept", "application/json");

		HttpEntity<String> requestHeaders = new HttpEntity<String>(headersMap);
		
		
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8085/rest/users/findPath/1" , String.class);

		
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
	}

}
