package com.wlyang.record.mq.config;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AetemisConfig {

	@Bean
	public ActiveMQQueue getActiveMQQueue() {
		ActiveMQQueue activeMQQueue = new ActiveMQQueue("myQueue");
		return activeMQQueue;
	}
}