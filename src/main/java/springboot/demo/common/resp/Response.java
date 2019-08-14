package springboot.demo.common.resp;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Response<T> implements Serializable {
    /**
     * 序列化版本
     */
    private static final long serialVersionUID = 1L;

    /**
     * 操作成功/失败
     */
    @ApiModelProperty("true：请求成功；false：请求失败")
    private boolean success;

    /**
     * 状态码
     */
    @ApiModelProperty("请求状态码")
    private Integer code;

    /**
     * 返回消息
     */
    @ApiModelProperty("返回地提示信息")
    private String message;

    /**
     * 结果数据
     */
    @ApiModelProperty("请求处理成功之后返回的结果")
    private T data;


    public Response() {
        success(null);
    }

    /**
     * 成功处理之后的响应
     * @param t
     */
    public Response(T t) {
        success(t);
    }


    /**
     * 调用是否成功
     */
    public boolean isSuccess() {
        return this.success;
    }

    /**
     * 获取状态码，参考ErrorCodeConstants类
     * @return
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 获取消息
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 获取调用结果
     *
     * @return 调用结果
     */
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 设置调用结果
     *
     * @param data
     */
    public void success(T data) {
        this.success = true;
        this.data = data;
        this.code = ErrorCode.HTTP_STATUS_200;
    }


    /**
     * 设置错误消息，并将调用结果设置为失败
     *
     * @param error 错误消息
     */
    public void setError(String error) {
        this.success = false;
        this.code = ErrorCode.HTTP_STATUS_500;
        this.message = error;
    }

    /**
     * 设置错误消息，并将调用结果设置为失败
     *
     * @param error 错误消息
     */
    public void setError(Integer code, String error) {
        this.success = false;
        this.code = code;
        this.message = error;
    }

    /**
     * 设置返回消息
     *
     * @param message 返回消息
     */
    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}