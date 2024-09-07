package com.deliveryboy.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliveryboy.deliveryboy.config.AppConstant;

@Service
public class KafkaService {

	@Autowired
	private org.springframework.kafka.core.KafkaTemplate<String,String> KafkaTemplate;
	
	private Logger logger= LoggerFactory.getLogger(KafkaService.class);
	
	public boolean updatelocation(String location) {
		
		
		this.KafkaTemplate.send(AppConstant.LOCATION_TOPIC_NAME, location);
		this.logger.info("Message Produced");
		
		return true;
		
	}
	
}
