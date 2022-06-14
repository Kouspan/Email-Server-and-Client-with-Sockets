package me.common.requests;

import me.common.IRequest;
import me.common.Type;

import java.io.Serializable;

public class DeleteRequest implements IRequest, Serializable {

    private final int row;
    public DeleteRequest(int row) {
        this.row=row;
    }

    public int getRow() {
        return row;
    }

    public Type getType() {
        return Type.DELETE;
    }
}
