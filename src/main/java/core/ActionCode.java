package core;

public enum ActionCode {
    ERROR(0, "请求失败"),
    SUCCESS(1, "请求成功"),
    EXCEPTION(10, "服务器异常"),
    VALID(100, "参数校验异常");

    public int code;
    public String message;

    ActionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
