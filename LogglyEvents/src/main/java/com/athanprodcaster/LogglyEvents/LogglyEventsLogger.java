package com.athanprodcaster.LogglyEvents;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class LogglyEventsLogger {
	
	@Autowired
	public Tracer tracer;

	public void Log(String event) 
	{
		HashMap<String,Object> map = new HashMap<String,Object>();
		if(tracer.currentSpan() != null && tracer.currentSpan().context()!=null) 
		{
			map.put("traceId", tracer.currentSpan().context().traceId());
			map.put("spanId", tracer.currentSpan().context().spanId());
		}else 
		{
			
			map.put("traceId", "NotAvaliable");
			map.put("spanId", "NotAvaliable");
		}
		
	  
        map.put("event",event);

	    var response = WebClient.create()
	      .post()
	      .uri("http://logs-01.loggly.com/inputs/e398be66-72c1-4390-9ca4-53299e14af76/tag/http/")
.contentType(MediaType.APPLICATION_JSON).bodyValue(map).retrieve().bodyToFlux(String.class).blockLast();

	}

}
