package com.hashedin.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "shares",groupId = "myGroup")
    public void consumer(ConsumerRecord<String,String> record)
    {
        //String payload = message.getPayload();
        System.out.println("Consumed Value ="+ record.value());
        System.out.println("Consumed Key="+ record.key());
    }


}
