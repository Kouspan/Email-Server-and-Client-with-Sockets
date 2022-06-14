package me.common.requests;

import me.common.IRequest;
import me.common.Type;

import java.io.Serializable;

public class ReadRequest implements IRequest, Serializable {
    int index;

    public ReadRequest(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public Type getType() {
        return Type.READ;
    }
}
