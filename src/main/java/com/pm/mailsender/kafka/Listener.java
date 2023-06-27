package com.pm.mailsender.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Listener {

    @KafkaListener()
    public void onReceive(ConsumerRecord<String,Object> record){

    }
}
