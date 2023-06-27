package com.pm.mailsender.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Sender {

    private final JavaMailSender javaMailSender;

    public Sender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void onSend(MailPayload mailPayload) {
        //save log if you want
        try {
            // Creating a simple mail message object
            SimpleMailMessage emailMessage = new SimpleMailMessage();

            // Setting up necessary details of mail
            emailMessage.setCc(mailPayload.getCc());
            emailMessage.setTo(mailPayload.getTo());
            emailMessage.setSubject("Test Subject");
            emailMessage.setText(mailPayload.getContent());

            // Sending the email
            javaMailSender.send(emailMessage);
            log.info("Email Sent");
        }
        // Catch block to handle the exceptions
        catch (Exception e) {
            log.info("error tat {}", e.getMessage());
        }
    }
}
