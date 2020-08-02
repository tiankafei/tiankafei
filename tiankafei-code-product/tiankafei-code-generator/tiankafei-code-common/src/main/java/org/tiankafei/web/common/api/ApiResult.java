package org.tiankafei.web.common.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.tiankafei.web.common.enums.ApiStatusEnum;
import org.tiankafei.web.common.enums.BaseEnums;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@ApiModel(value = "api返回结果对象", description = "api返回结果对象")
public class ApiResult<T> implements Serializable {

    /**
     * 状态（0，失败；1成功，2错误）
     */
    @ApiModelProperty(value = "状态（0，失败；1成功，2错误）")
    private Integer status;

    /**
     * 返回的响应消息
     */
    @ApiModelProperty(value = "返回的响应消息")
    private String message;


    /**
     * 返回的响应数据
     */
    @ApiModelProperty(value = "返回的响应数据")
    private T data;

    /**
     * 响应时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private ApiResult() {

    }

    /**
     * 处理成功
     *
     * @return
     */
    public static ApiResult ok() {
        return ok(ApiStatusEnum.OK);
    }

//    public static ApiResult ok(String message) {
//        return ok(message, null);
//    }

    public static ApiResult ok(BaseEnums enums) {
        return result(enums, null);
    }

    public static ApiResult ok(Object data) {
        return ok(ApiStatusEnum.OK, data);
    }

    public static ApiResult ok(BaseEnums enums, Object data) {
        return result(enums, data);
    }

    public static ApiResult ok(BaseEnums enums, String message) {
        return result(enums.getStatus(), message, null);
    }

    public static ApiResult ok(String message, Object data) {
        return result(ApiStatusEnum.OK.getStatus(), message, data);
    }


    /**
     * 处理失败
     *
     * @return
     */
    public static ApiResult fail() {
        return fail(ApiStatusEnum.FAIL);
    }

    public static ApiResult fail(String message) {
        return fail(message, null);
    }

    public static ApiResult fail(BaseEnums enums) {
        return result(enums, null);
    }

    public static ApiResult fail(Object data) {
        return fail(ApiStatusEnum.FAIL, data);
    }

    public static ApiResult fail(BaseEnums enums, Object data) {
        return result(enums, data);
    }

    public static ApiResult fail(BaseEnums enums, String message) {
        return result(enums.getStatus(), message, null);
    }

    public static ApiResult fail(String message, Object data) {
        return result(ApiStatusEnum.FAIL.getStatus(), message, data);
    }

    /**
     * 异常是错误
     *
     * @return
     */
    public static ApiResult error() {
        return error(ApiStatusEnum.ERROR);
    }

    public static ApiResult error(String message) {
        return error(message, null);
    }

    public static ApiResult error(BaseEnums enums) {
        return result(enums, null);
    }

    public static ApiResult error(Object data) {
        return error(ApiStatusEnum.ERROR, data);
    }

    public static ApiResult error(BaseEnums enums, Object data) {
        return result(enums, data);
    }

    public static ApiResult error(BaseEnums enums, String message) {
        return result(enums.getStatus(), message, null);
    }

    public static ApiResult error(String message, Object data) {
        return result(ApiStatusEnum.ERROR.getStatus(), message, data);
    }

    private static ApiResult result(BaseEnums enums, Object data) {
        return result(enums.getStatus(), enums.getMessage(), data);
    }

    private static ApiResult result(Integer status, String message, Object data) {
        return ApiResult.builder()
                .status(status)
                .message(message)
                .data(data)
                .time(new Date())
                .build();
    }

}
