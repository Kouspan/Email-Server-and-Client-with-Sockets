package me.common.responses;

import me.common.IResponse;
import me.common.ResponseCode;
import me.common.Type;
import me.common.code.Account;


import java.io.Serializable;

public class LoginResponse implements IResponse, Serializable {
    Account account;
    ResponseCode code;
    public LoginResponse(Account account){
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public Type getType() {
        return Type.LOGIN;
    }

    public void setCode(ResponseCode code){
        this.code = code;
    }

    public ResponseCode getCode() {
        return code;
    }
}
