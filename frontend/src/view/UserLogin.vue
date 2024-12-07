<template>
    <div class="main">
      <div class="text-center mb-6">
        <img 
          src="PNG" 
          alt="LOGO" 
          class="mx-auto w-16 h-16"
        />
        <h1 class="text-2xl font-semibold text-gray-700 mt-2">Blood bank management system</h1>
      </div>
  
  <!-- 白色背景框 -->
  <div class=box>
    <!-- 用户名 -->
    <div class="mb-4">

      <input
        id="username"
        type="text"
        placeholder="Please enter username"
        class="input1"
      />
    </div>

    <!-- 密码 -->
    <div class="mb-4">

      <input
        id="password"
        type="password"
        placeholder="Please enter password"
        class="input1"
      />
    </div>

    <!-- 记住我 和 忘记密码 -->
    <div class=tips>
      <label class="inline-flex items-center">
        <input
          type="checkbox"
          class="form-checkbox text-blue-500 border-gray-300 rounded"
        />
        <span class="ml-2 text-sm text-gray-600">remember me</span>
      </label>
      <a href="#" class="text-sm text-blue-500 hover:underline">forget password</a>
    </div>

    <!-- 登录按钮 -->
    <button
      type="submit"
      class="login-btn"
    >
      login
    </button>

    <!-- 注册链接 -->
    <div class="text-center mt-4 text-sm">
      no account yet ?
      <a href="/register" class="text-blue-500 hover:underline" style="margin-left: 10px;">sign up</a>
    </div>

    <!-- 底部信息 -->
    <div class="text-center mt-6 text-xs text-gray-500" style="font-size: 10px;">
      This system adopts encrypted transmission to ensure the security of your information
      <br />
      © 2024 Blood Bank Management System version v1.0.0
      <br />
      Technical support: Medical Information Department
    </div>
  </div>
</div>
</template>

<style scoped>
  .main {
    display: flex;
    flex-direction: column; /* 垂直排列内容 */
    justify-content: center; /* 内容在垂直方向居中 */
    align-items: center; /* 内容在水平方向居中 */
    min-height: 100vh; /* 页面最小高度为视口高度 */
    padding: 0 16px;
    background: linear-gradient(to bottom, #FEF2F2, #FFFFFF);
  }
  .login-btn {
  width: 100%; /* 让按钮占满父容器的宽度 */
  padding: 0.75rem 1.5rem; /* 增加内边距，按钮更大 */
  background-color: #000000; /* 背景色为蓝色 */
  color: white; /* 文字为白色 */
  font-size: 1rem; /* 字体大小适中 */
  font-weight: bold; /* 字体加粗 */
  text-align: center; /* 文字居中 */
  border-radius: 0.75rem; /* 圆角按钮 */
  border: none; /* 去掉默认边框 */
  transition: background-color 0.3s, transform 0.3s; /* 添加过渡效果 */
}

.login-btn:hover {
  background-color: #3182ce; /* 悬停时背景色稍微深一点 */
  transform: translateY(-2px); /* 悬停时按钮上移 */
}

.login-btn:focus {
  outline: none; /* 去掉焦点轮廓 */
  box-shadow: 0 0 0 2px rgba(66, 153, 225, 0.5); /* 聚焦时增加阴影效果 */
}
.box {
  width: 25vw; /* 宽度为视口宽度的一半 */
  height: 40vh; /* 高度为视口高度的一半 */
  padding: 1.5rem; /* 添加内边距 */
  background-color: white; /* 背景白色 */
  border-radius: 0.75rem; /* 添加圆角 */
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 添加阴影 */
  display: flex;
  flex-direction: column; /* 内容垂直排列 */
  justify-content: space-between; /* 内容均匀分布 */
}
.mb-4 {
  margin-bottom: 1rem; /* 增加输入框之间的间距 */
}

.input1 {
  width: 70%; /* 使输入框宽度填满父容器 */
  padding: 0.75rem 1.25rem; /* 增加输入框内边距，变大输入框 */
  background-color: #f7fafc; /* 输入框背景颜色 */
  border-radius: 0.5rem; /* 圆角 */
  font-size: 0.875rem; /* 字体变小 */
  line-height: 1.25rem; /* 行高 */
  border: 1px solid #e2e8f0; /* 边框颜色 */
  margin-top: 0.5rem; /* 给输入框添加一些顶部间距 */
  transition: border-color 0.3s ease; /* 动画效果 */
}

.input1:focus {
  outline: none; /* 移除默认的focus轮廓 */
  border-color: #3182ce; /* 聚焦时边框颜色变为蓝色 */
  box-shadow: 0 0 0 2px rgba(66, 153, 225, 0.5); /* 聚焦时增加阴影效果 */
}

::placeholder {
  color: #a0aec0; /* placeholder字体颜色 */
  font-size: 0.875rem; /* placeholder字体小一点 */
}
.tips {
  display: flex;              /* 使用flex布局 */
  justify-content: space-between; /* 将内容分布在两端 */
  align-items: center;         /* 垂直居中对齐 */
  width: 100%;                /* 父容器宽度为100% */
}

.tips a {
  margin-left: 16px;           /* 给忘记密码添加间距 */
}

.tips label {
  display: flex;               /* 确保label内部的内容是水平排列 */
  align-items: center;         /* 垂直居中 */
}
</style>
  
