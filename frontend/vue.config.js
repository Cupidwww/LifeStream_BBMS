const { defineConfig } = require('@vue/cli-service');

module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8081,  // 设置前端开发服务器的端口
    proxy: {
      '/mock': {
        target: 'http://localhost:8080',  // 本地开发服务器
        changeOrigin: true,
        pathRewrite: {
          '^/mock': '',  // 去掉 /mock 前缀
        },
      },
    },
  },
});
