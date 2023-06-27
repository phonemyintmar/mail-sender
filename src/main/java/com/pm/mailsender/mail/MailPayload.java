package com.pm.mailsender.mail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailPayload {
    //modify this accordingly
    private String to;
    private String cc;
    private String content;
}
