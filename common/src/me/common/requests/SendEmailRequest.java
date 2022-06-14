package me.common.requests;

import me.common.IRequest;

import me.common.Type;
import me.common.code.Email;

import java.io.Serializable;

public class SendEmailRequest implements IRequest, Serializable {
    Email email;

    public SendEmailRequest(Email email){
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public Type getType() {
        return Type.SEND;
    }

}
