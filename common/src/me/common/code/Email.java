package me.common.code;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class Email implements Serializable {

    private String sender;
    private String receiver;
    private String subject;
    private String body;
    private OffsetDateTime date;
    private boolean isNew;

    public Email(String sender,String receiver,String subject,String body){
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
        isNew = true;

        date = OffsetDateTime.now();
    }



    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }


}
