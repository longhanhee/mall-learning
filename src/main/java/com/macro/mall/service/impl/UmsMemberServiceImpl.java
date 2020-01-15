package com.macro.mall.service.impl;


import com.macro.mall.common.api.CommonResult;
import com.macro.mall.service.RedisService;
import com.macro.mall.service.UmsMemberService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 会员管理Service实现类
 * Created by macro on 2018/8/3.
 */
@Service
//cần setting @Data để active prefix
@Data
@ConfigurationProperties(prefix = "redis.key.string")
public class UmsMemberServiceImpl implements UmsMemberService {

    private String prefix;
    private Long expire;
    private String emptyValidate;
    private String getValidate;
    private String successValidate;
    private String failValidate;

    @Autowired
    private RedisService redisService;


    @Override
    public CommonResult generateAuthCode(String telephone) {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //Mã xác minh liên kết số điện thoại và lưu nó vào redis
        redisService.set(prefix + telephone, sb.toString());
        redisService.expire(prefix + telephone, expire);
        return CommonResult.success(sb.toString(), getValidate);
    }


    //Xác minh mã xác minh đã nhập
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed(emptyValidate);
        }
        String realAuthCode = redisService.get(prefix + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, successValidate);
        } else {
            return CommonResult.failed(failValidate);
        }
    }

}
