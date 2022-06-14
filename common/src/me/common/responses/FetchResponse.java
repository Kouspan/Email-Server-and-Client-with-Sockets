package me.common.responses;

import me.common.IResponse;
import me.common.ResponseCode;
import me.common.Type;

import me.common.code.Account;
import me.common.code.Email;


import java.io.Serializable;



public class FetchResponse implements IResponse, Serializable {

    ResponseCode code;




    @Override
    public Type getType() {
        return Type.FETCH;
    }

    @Override
    public ResponseCode getCode() {
        return code;
    }

    @Override
    public void setCode(ResponseCode code) {
        this.code = code;
    }
}
