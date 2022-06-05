<template>
<div>
<div onclick="dianji()">
        微信登录
    </div>
    <div id="login_container">
		</div>
</div>
</template>

<script src="http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script>
export default {
    created() {
        this.dianji()
    },
    methods: {
        dianji() {
            new WxLogin({
                self_redirect: true,
                id: "login_container", //要与你在那里生成二维码的div id 一致
                appid: "wx06dadc1cce7d8150", //你申请的appid
                scope: "snsapi_login,snsapi_userinfo", //你的权限
                redirect_uri: encodeURIComponent("http://127.0.0.1:8080/ks/login/wechat"), //url要进行encodeURIComponent编码
                state: "STATE", //微信官方接口为了防止跨域攻击要加的参数 可以自己定义
                style: "black", //样式
                href: "", //可以引入你自己的样式 注意这个只能是网络中的
            });
        },
    },
};
</script>

<style scoped></style>
