package com.example.demo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	private final static String TOPIC_NAME = "topic5";

	ObjectMapper objectMapper = new ObjectMapper();

	@KafkaListener(topics = TOPIC_NAME)
	public void listenMessage(String jsonMessage) {
		try {
			MyMessage message = objectMapper.readValue(jsonMessage, MyMessage.class);
			System.out.println(">>> " + message.getName() + "," + message.getMessage());
		} catch (JsonProcessingException e) {
//			throw new RuntimeException(e);
			e.printStackTrace();
		}
	}
}
