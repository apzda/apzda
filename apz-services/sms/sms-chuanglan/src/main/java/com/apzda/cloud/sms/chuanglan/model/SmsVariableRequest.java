/*
 * Copyright (C) 2023-2023 Fengz Ning (windywany@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.apzda.cloud.sms.chuanglan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author fengz (windywany@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmsVariableRequest {

    private String sign;

    /**
     * 用户账号，必填
     */
    private String account;

    /**
     * 用户密码，必填
     */
    private String password;

    /**
     * 短信内容。长度不能超过536个字符，必填
     */
    private String msg;

    /**
     * 手机号码和变量参数，多组参数使用英文分号;区分，必填
     */
    private String params;

    private String timestamp;

    /**
     * 定时发送短信时间。格式为yyyyMMddHHmm，值小于或等于当前时间则立即发送，默认立即发送，选填
     */
    @JsonProperty("sendtime")
    private String sendTime;

    /**
     * 是否需要状态报告（默认false），选填
     */
    private String report;

    /**
     * 下发短信号码扩展码，纯数字，建议1-3位，选填
     */
    private String extend;

    /**
     * 该条短信在您业务系统内的ID，如订单号或者短信发送记录流水号，选填
     */
    private String uid;

    public SmsVariableRequest() {

    }

    public SmsVariableRequest(String account, String password, String msg, String params) {
        this.account = account;
        this.password = password;
        this.msg = msg;
        this.params = params;
    }

    public SmsVariableRequest(String account, String password, String msg, String params, String report) {
        this.account = account;
        this.password = password;
        this.msg = msg;
        this.params = params;
        this.report = report;
    }

}
