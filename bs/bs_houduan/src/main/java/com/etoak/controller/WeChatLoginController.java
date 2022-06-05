package com.etoak.controller;

import com.etoak.utils.JsonResponse;
import com.etoak.utils.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
@Slf4j
public class WeChatLoginController {

    /**
     * (测试功能)微信扫码登录
     * @return
     */
    @RequestMapping("/wechat")
    public JsonResponse wechatLogin() {
        // https://open.weixin.qq.com/connect/qrconnect?appid=wx00f80ce429d5e494&redirect_uri=&response_type=code&scope=snsapi_login#wechat_redirect

        return ResultStatus.suc("成功");
    }

}
