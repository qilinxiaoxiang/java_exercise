package reflect;

public class Result<T> {
    private boolean success;
    private String code;
    private T data;

    private Result() {
    }

    private Result(boolean success, String code, T data) {
        this.success = success;
        this.code = code;
        this.data = data;
    }

    public static <T> Result success(T data) {
        return new Result(true, "success", data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
