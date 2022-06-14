package me.common.responses;

import me.common.IResponse;
import me.common.ResponseCode;
import me.common.Type;
import me.common.code.Email;

import java.io.Serializable;

public class EmailResponse implements IResponse, Serializable {
    private Email email;
    private ResponseCode code=null;
    public EmailResponse(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public Type getType() {
        return Type.EMAIL;
    }

    @Override
    public ResponseCode getCode() {
        return code;
    }

    @Override
    public void setCode(ResponseCode code) {
        this.code=code;
    }
}
