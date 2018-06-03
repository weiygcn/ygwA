package rvo;

import core.ActionCode;
import lombok.Data;

@Data
public class RVO<T> {
    private int code;
    private String message;
    private T data;

    public RVO(String message) {
        this(ActionCode.ERROR, message, null);
    }

    public RVO(ActionCode action) {
        this(action, null);
    }

    public RVO(ActionCode action, T data) {
        this(action.code, action.message, data);
    }

    public RVO(ActionCode action, String message, T data) {
        this(action.code, message, data);
    }

    public RVO(int code, String message) {
        this(code, message, null);
    }

    public RVO(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
