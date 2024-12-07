<template>
    <div class="register">
      <div class="box">
        <div class="max-w-md w-full bg-white shadow-lg rounded-lg p-8">
          <div class="text-center mb-8">
            <img
             src="..\assets\爱如火icon-removebg-preview.png"
              alt="血库管理系统"
              class="w-16 h-16"
               style="max-width: 100px; max-height: 100px; margin-bottom: 8px;"
            />
            <h1 class="text-3xl font-bold text-gray-900" style="margin-top: 0;">Blood bank management system</h1>
            <p class="text-xl text-gray-600">User Registration
            </p>
          </div>
  
          <div class="mb-6">
            <div class="flex justify-between items-center">
              <div class="w-1/3 h-1 bg-custom rounded-full"></div>
              <div class="w-1/3 h-1 bg-gray-300 rounded-full mx-2"></div>
              <div class="w-1/3 h-1 bg-gray-300 rounded-full"></div>
            </div>
          </div>
  
            <div>
              <input
                type="text"
                id="username"
                placeholder="Please enter username"
                name="username"
                v-model="user.username"
                required
                class="info-1"
              />
            </div>
  
            <div>
              <input
                type="password"
                id="password"
                placeholder="Please enter password"
                name="password"
                v-model="user.password"
                required
                class="info-1"
              />
              <div class="mt-2 h-2 bg-gray-200 rounded-full">
                <div
                  class="h-full bg-yellow-500 rounded-full"
                  :style="{ width: passwordStrengthWidth }"
                ></div>
              </div>
              <p class="mt-1 text-sm text-gray-500">{{ passwordStrengthText }}</p>
            </div>
      
            <div>
          <input
            type="text"
            id="idNumber"
            placeholder="Please enter ID number"
            name="idNumber"
            v-model="user.idNumber"
            required
            class="info-1"
          />
        </div>
  
            <div>

              <input
                type="password"
                id="confirm-password"
                name="confirm-password"
                placeholder="Reconfirm password"
                v-model="user.confirmPassword"
                required
                class="info-1"
              />
            </div>
  
            <div>
              <input
                type="tel"
                id="phone"
                name="phone"
                placeholder="Please enter phone number" 
                v-model="user.phone"
                required
                class="info-1"  
              />
            </div>
  
            <div>
              <div class="mt-1 flex rounded-md shadow-sm">
                <input
                  type="email"
                  id="email"
                  name="email"
                  placeholder="Please enter email"
                  v-model="user.email"
                  required
                  class="info-1"    
                />
              
              </div>
            </div>
  
  
            <div class="flex items-center">
              <input
                id="agree-terms"
                name="agree-terms"
                type="checkbox"
                v-model="user.agreeTerms"
                class="h-4 w-4 text-custom focus:ring-custom border-gray-300 rounded"
              />
              <label for="agree-terms" class="ml-2 block text-sm text-gray-900">
                agree 
                <a
                  href="#"
                  class="text-custom hover:text-custom-dark"
                >
                user agreement
                </a>
                and
                <a
                  href="#"
                  class="text-custom hover:text-custom-dark"
                >
                  
privacy policy

                </a>
              </label>
            </div>
  
            <div>
              <button
                type="submit"
                class="register-button"
                 @click="register"
              >
                register
              </button>
            </div>
  
          <div class="mt-6 text-center">
            <p class="text-sm text-gray-600">
              Already have an account
              <router-link to="/login" class="font-medium text-custom hover:text-custom-dark">
                Sign in now
              </router-link>
            </p>
          </div>
        </div>
      </div>
    </div>
  </template>
 
  
  <style scoped>
  
.info-1{
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

.info-1:focus {
  outline: none; /* 移除默认的focus轮廓 */
  border-color: #3182ce; /* 聚焦时边框颜色变为蓝色 */
  box-shadow: 0 0 0 2px rgba(66, 153, 225, 0.5); /* 聚焦时增加阴影效果 */
}

::placeholder {
  color: #a0aec0; /* placeholder字体颜色 */
  font-size: 0.875rem; /* placeholder字体小一点 */
}
    .register {
    display: flex;
    flex-direction: column; /* 垂直排列内容 */
    align-items: center; /* 内容在水平方向居中 */
    min-height: 100vh; /* 页面最小高度为视口高度 */
    padding: 0 16px;
    background: linear-gradient(to bottom, #FEF2F2, #FFFFFF);
  }
  .register-button {
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

.register-button:hover {
  background-color: #3182ce; /* 悬停时背景色稍微深一点 */
  transform: translateY(-2px); /* 悬停时按钮上移 */
}

.register-button:focus {
  outline: none; /* 去掉焦点轮廓 */
  box-shadow: 0 0 0 2px rgba(66, 153, 225, 0.5); /* 聚焦时增加阴影效果 */
}
.box {
  width: 25vw; /* 宽度为视口宽度的一半 */
  height: 80vh; /* 高度为视口高度的一半 */
  padding: 1.5rem; /* 添加内边距 */
  margin-top: 3rem;
  background-color: white; /* 背景白色 */
  border-radius: 0.75rem; /* 添加圆角 */
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 添加阴影 */
  display: flex;
  flex-direction: column; /* 内容垂直排列 */
  justify-content: space-between; /* 内容均匀分布 */
}
  </style>
  
  
  <script>
      import userapi from '@/api/userapi';


export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        phone: '',
        idNumber: '', 
        agreeTerms: false,
      },
      passwordStrength: 0,
      passwordStrengthText: '',
      passwordStrengthWidth: '0%',
    };
  },
  methods: {
checkPasswordStrength() {
  const password = this.user.password;
  let strength = 0;

  if (password.length >= 8) {
    if (password.match(/[a-z]+/)) strength += 1;
    if (password.match(/[A-Z]+/)) strength += 1;
    if (password.match(/[0-9]+/)) strength += 1;
    if (password.match(/[$@#&!]+/)) strength += 1;
  }

  this.passwordStrength = strength;
  this.passwordStrengthText = this.getPasswordStrengthText(strength);
  this.passwordStrengthWidth = this.getPasswordStrengthWidth(strength);
},




register() {
const formData = {
  username: this.user.username,
  password: this.user.password,
  confirmPassword: this.user.confirmPassword,
  phone: this.user.phone,
  idNumber: this.user.idNumber,
  email: this.user.email,
};

if (!formData.username || !formData.password || !formData.confirmPassword || !formData.phone || !formData.idNumber || !formData.email) {
  this.$message.error('Please fill in all required fields');
  return;
}

if (formData.password !== formData.confirmPassword) {
  this.$message.error('The two passwords are different');
  return;
}

// 使用 userapi 中封装的接口
userapi.registerUser(formData)
.then(response => {


  // 假设后端返回的数据里有一个 message 字段
  const successMessage = response.data.message || 'Registration successful, please login';
  this.$message.success(successMessage); // 使用响应中的消息

  // 跳转到登录页面
  this.$router.push('/login');
})
.catch(error => {
  // 获取错误消息并显示给用户
  const errorMessage = error.response?.data?.msg || 'Registration failed, please try again later';
  this.$message.error(errorMessage);
});



}
}
}



  </script>