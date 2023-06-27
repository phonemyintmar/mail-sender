package com.pm.mailsender.kafka;

import com.pm.mailsender.mail.MailPayload;
import com.pm.mailsender.mail.Sender;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Listener {

    private final Sender sender;

    public Listener(Sender sender) {
        this.sender = sender;
    }

    @KafkaListener(topics = "${listener.config.topic}", groupId = "${listener.config.groupId}")
    public void onReceive(ConsumerRecord<String, MailPayload> record) {
        // d mhr clarify payload.
        MailPayload mailPayload = record.value();

        //log ml so d mhr sa log, check recordId and status and blah blah
        sender.onSend(mailPayload);
    }
}
