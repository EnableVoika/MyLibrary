module.exports = {
    devServer: {
        port: 8888, // 端口号，如果端口被占用，会自动提升 1
        open: true, // 启动服务自动打开浏览器
        https: false, // 协议
        host: "localhost", // 主机名，也可以 127.0.0.1 或 做真机测试时候 0.0.0.0

        proxy:{
            // 匹配 /dev-api 开头的请求，
            //'/dev-api':{
            [process.env.VUE_APP_BASE_API]:{
                //目标服务器，代理访问到哪里
                //target:'http://localhost:8888',
                target:process.env.VUE_APP_SERVICE_URL,
                //开启代理服务器
                changeOrigin: true,
                pathRewrite: {
                    // /dev-api/db.json 最终会发送 http://localhost:8001/db.json
                    // 将 请求地址前缀 /dev-api 替换为 空的，
                    //'^/dev-api':'',
                    ['^' + process.env.VUE_APP_BASE_API]: ''
                }
            }
        }
    },
    lintOnSave: false, // 是否关闭eslint语法检查，默认 true, 警告仅仅会被输出到命令行，且不会使得编译失败。
    productionSourceMap: false, // 打包时, 不生成 .map 文件, 加快打包构建
}
