<template>
    <div class="body">
        <div>
            <img src="..\assets\爱如火icon-removebg-preview.png"
                alt="Logo"
                class="w-16 h-16"
                style="max-width: 100px; max-height: 100px;
                 margin-bottom: 8px; z-index: 200; position: relative;"/>
            <h1 class="text-3xl font-bold">LifeStream Blood Bank Management System</h1>
        </div>
        <div :class="['container', { 'right-panel-active': isSignUp }]" id="login-box">
            
            <!-- 注册面板 -->
            <div class="form-container sign-up-container" v-show="isSignUp">
                <form >
                <h1>sign up</h1>
                <div class="txtb">
                    <input type="text" v-model="registerData.username" @focus="focusInput" @blur="blurInput" />
                    <span :class="{ focus: registerData.username }" data-placeholder="Username"></span>
                </div>
                <div class="txtb">
                    <input type="phone" v-model="registerData.phone" @focus="focusInput" @blur="blurInput" />
                    <span :class="{ focus: registerData.phone }" data-placeholder="Phone"></span>
                </div>
                <div class="txtb">
                    <input type="password" v-model="registerData.password" @focus="focusInput" @blur="blurInput" />
                    <span :class="{ focus: registerData.password }" data-placeholder="Password"></span>
                </div>
                <div class="txtb">
                    <input type="password" v-model="registerData.confirmPassword" @focus="focusInput" @blur="blurInput" />
                    <span :class="{ focus: registerData.confirmPassword }" data-placeholder="Confirm Password"></span>
                </div>
                <button @click.prevent="register">submit</button>
                </form>
            </div>

            <!-- 登录面板 --> 
            <div class="form-container sign-in-container" v-show="!isSignUp">
                <form ref="myForm">
                    <h1>sign in</h1>
                    <div class="txtb">
                        <input type="text" v-model="loginData.username" @focus="focusInput" @blur="blurInput"/>
                        <span :class="{ focus: loginData.username }" data-placeholder="Username"></span>
                    </div>
                    <div class="txtb">
                        <input type="password" v-model="loginData.password" @focus="focusInput" @blur="blurInput"/>
                        <span :class="{ focus: loginData.password }" data-placeholder="Password"></span>
                    </div>
                    <div class="remember-me">
                        <el-checkbox v-model="loginData.rememberMe">Remember me</el-checkbox>
                    </div>
                    <button @click.prevent="handleLogin">submit</button>
                </form>
            </div>


            <!-- 切换面板的按钮 -->
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Already have an account?</h1>
                        <p>sign in now</p>
                        <button class="ghost" @click="toggleSignUp">Login</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Not yet a member?</h1>
                        <p>sign up now</p>
                        <button class="ghost" @click="toggleSignUp">Register</button>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <!-- 底部信息 -->
            <el-row class="footer" justify="center" align="middle">
            <el-col :span="24" class="text-center">
                <el-text type="info" size="small">
                This system adopts encrypted transmission to ensure the security of your information
                <br />
                © 2024 Blood Bank Management System version v1.0.0
                <br />
                Technical support: Medical Information Department
                </el-text>
            </el-col>
            </el-row>
        </div>
        <!-- 气泡容器 -->
        <div class="bubbles-container">
            <div v-for="(bubble, index) in bubbles" :key="index" class="bubble" :style="bubble.style"></div>
        </div>
    </div>
</template>

<script>
import "../assets/css/index.css";
import userApi from "@/api/userapi.js";

export default {
    
    data() {
        return {
            isSignUp: false, // 控制是否显示注册面板
            registerData: {
                username: '',
                phone: '',
                password: '',
                confirmPassword: ''
            },
            loginData: {
                username: localStorage.getItem('username') || '',     // 存储用户名
                password: localStorage.getItem('password') || '',     // 存储密码
                rememberMe: localStorage.getItem('rememberMe') === 'true',
            },
            bubbles: [], // 存储气泡数据
        };
    },
    methods: {
        // 切换注册和登录面板
        toggleSignUp() {
            this.isSignUp = !this.isSignUp;
        },

        // 注册方法
        register() {
            const registerData = {
                username: this.registerData.username,
                phone: this.registerData.phone,
                password: this.registerData.password,
                confirmPassword: this.registerData.confirmPassword,
            };

            if (!registerData.username || !registerData.password || !registerData.confirmPassword || !registerData.phone) {
                this.$message.error('Please fill in all required fields');
                return;
            }
    
            if (registerData.password !== registerData.confirmPassword) {
                this.$message.error('The two passwords are different');
                return;
            }

            // 使用 userapi 中封装的接口
            userApi.registerUser(registerData)
                .then(response => {
                    // 假设后端返回的数据里有一个 message 字段
                    const successMessage = response.data.message || 'Registration successful, please login';
                    this.$message.success(successMessage); // 使用响应中的消息

                    // 跳转到登录页面
                    this.$router.push('/home');
                })
                .catch(error => {
                    // 获取错误消息并显示给用户
                    const errorMessage = error.response?.data?.msg || 'Registration failed, please try again later';
                    this.$message.error(errorMessage);
                });
        },

        // 登录方法
        async handleLogin() {
            const loginData = {
                username: this.loginData.username,
                password: this.loginData.password,
                roleType: (this.loginData.username === 'admin')? 'ADMIN' : 'DONOR', 
            };

            console.log(this.loginData.username, this.loginData.password);

            // 检查用户名和密码是否为空
            if (!this.loginData.username || !this.loginData.password) {
                this.$message.error('请填写用户名和密码');
                return;
            }

            try {
                // 调用登录接口
                const response = await userApi.loginUser(loginData);

                // 登录成功后存储token
                localStorage.setItem('token', response.data.token);
                // 存储用户角色
                localStorage.setItem('role', loginData.roleType);

                console.log(response.data.token);

                // 记住我功能
                if (this.loginData.rememberMe) {
                    localStorage.setItem('username', this.loginData.username);
                    localStorage.setItem('password', this.loginData.password);
                    localStorage.setItem('rememberMe', true);
                } else {
                    localStorage.removeItem('username');
                    localStorage.removeItem('password');
                    localStorage.removeItem('rememberMe');
                }

                //删除输入框中的内容
                this.username = '';
                this.password = '';
                this.$nextTick(() => {
                    this.$forceUpdate(); // 强制刷新组件视图
                });

                // 显示成功消息
                this.$message.success('登录成功');

                // 打印 localStorage 中的值
                console.log('username:', this.username);
                console.log('password:', this.password);

                // 登录成功后跳转到主页面
                this.$router.push('/home');  // 假设登录成功后跳转到 `/home` 页面
            } catch (error) {
                // 错误处理
                const errorMessage = error.response?.data?.msg || '登录失败，请稍后再试';
                this.$message.error(errorMessage);
            }
        },

        // 聚焦输入框
        focusInput(event) {
            event.target.classList.add('focus');
        },

        // 失去焦点时判断是否为空
        blurInput(event) {
            if (event.target.value === '') {
                event.target.classList.remove('focus');
            }
        },

        // 生成气泡
        createBubble() {
            if (this.bubbles.length >= 10) return; // 限制气泡数量
            
            const bubble = {
                style: {
                    left: Math.random() * 100 + 'vw',
                    animationDuration: Math.random() * 3 + 2 + 's'
                }
            };
            this.bubbles.push(bubble);

            // 在动画结束后移除气泡
            setTimeout(() => {
                this.bubbles = this.bubbles.filter(b => b !== bubble); // 准确移除当前气泡
            }, parseFloat(bubble.style.animationDuration) * 1000);
        },
        startBubbleAnimation() {
            this.createBubble();
            requestAnimationFrame(this.startBubbleAnimation);
        },
    },
    mounted() {
        // 使用 Vue 的 ref 获取表单元素
        const form = this.$refs.myForm;
        if (form) {
            form.setAttribute('autocomplete', 'off');
        }
        // 每隔500毫秒生成一个气泡
        setInterval(this.createBubble, 800);
    },
};
</script>

<style scoped>
.footer {
    margin-top: 1.5rem;
    /* 对应 mt-6 */
    font-size: 10px;
    /* 自定义字体大小 */
}
.remember-me .el-checkbox {
    margin: 15px 0;
}

.remember-me .el-checkbox__label {
    font-size: 14px;
    color: #555;
}

.remember-me .el-checkbox__inner {
    width: 18px;
    height: 18px;
    border-radius: 4px;
}

.remember-me .el-checkbox__inner::after {
    border-width: 0 2px 2px 0;
    left: 6px;
    top: 2px;
}

.bubbles-container {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    pointer-events: none;
}

.bubble {
    position: absolute;
    bottom: -50px;
    width: 20px;
    height: 20px;
    background-color: rgba(255, 255, 255, 0.7);
    border-radius: 50%;
    animation: rise 5s infinite linear;
}

@keyframes rise {
    0% {
        transform: translate3d(0, 0, 0);
        opacity: 1;
    }
    50% {
        transform: translate3d(0, -50vh, 0);
        opacity: 0.5;
    }
    100% {
        transform: translate3d(0, -100vh, 0);
        opacity: 0;
    }
}

</style>
