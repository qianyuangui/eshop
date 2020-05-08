package com.ftown.eshop.zuul.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ZuulFallBackProvider implements FallbackProvider {

	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		 System.out.println("ClientHttpResponse fallbackResponse()");
	        
	        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
	        Map<String, Object> data = new HashMap<String, Object>();
	        data.put("message", "服务正忙，请稍后重试");
	        result.add(data);
	        
	        ObjectMapper mapper = new ObjectMapper();
	        
	        String msg = "";
	        try {
	            msg = mapper.writeValueAsString(result);
	        } catch (JsonProcessingException e) {
	            msg = "";
	        }
	        
	        return this.response(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public String getRoute() {
		return "*";
	}
	private ClientHttpResponse response(final HttpStatus status) {
	    return new ClientHttpResponse() {
	    	
	      public HttpStatus getStatusCode() throws IOException {
	        return status;
	      }
	      
	      public int getRawStatusCode() throws IOException {
	        return status.value();
	      }
	      
	      public String getStatusText() throws IOException {
	        return status.getReasonPhrase();
	      }
	      
	      public void close() {
	      }
	      
	      public InputStream getBody() throws IOException {
	        return new ByteArrayInputStream("服务不可用，请稍后再试。".getBytes());
	      }
	      
	      public HttpHeaders getHeaders() {
	        // headers设定
	        HttpHeaders headers = new HttpHeaders();
	        MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
	        headers.setContentType(mt);
	        return headers;
	      }
	      
	    };
	  }
}
