package me.common;

public interface IResponse {
    Type getType();

    ResponseCode getCode();

    void setCode(ResponseCode code);

}
