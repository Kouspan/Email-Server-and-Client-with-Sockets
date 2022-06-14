package me.common.requests;

import me.common.IRequest;
import me.common.Type;

import java.io.Serializable;

public class FetchRequest implements IRequest, Serializable {


    @Override
    public Type getType() {
        return Type.FETCH;
    }
}
