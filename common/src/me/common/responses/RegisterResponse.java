package me.common.responses;

import me.common.IResponse;
import me.common.ResponseCode;
import me.common.Type;
import me.common.code.Account;

import java.io.Serializable;

public class RegisterResponse implements IResponse, Serializable {

    Account account;
    ResponseCode code;
    public RegisterResponse(Account account){
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public Type getType() {
        return Type.REGISTER;
    }
    public void setCode(ResponseCode code){
        this.code = code;
    }

    public ResponseCode getCode() {
        return code;
    }
}
