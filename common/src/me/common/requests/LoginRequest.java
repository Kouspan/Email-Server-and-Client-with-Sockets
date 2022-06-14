package me.common.requests;

import me.common.IRequest;
import me.common.Type;

import java.io.Serializable;

public class LoginRequest implements IRequest, Serializable {

    private final String name;
    private final String pass;

    public LoginRequest(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public Type getType() {
        return Type.LOGIN;
    }
}
