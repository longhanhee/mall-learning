package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;

public interface UmsMemberService {

    /**
     *  Tạo mã xác minh
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * Xác định xem mã xác minh và số điện thoại di động có khớp không
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}
