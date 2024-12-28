<template>
    <el-header height="60px" class="navbar">
        <div class="navbar-left">
                <img src="..\assets\爱如火icon-removebg-preview.png" alt="Logo" class="logo">
                <img src="..\assets\爱如火-removebg-preview.png" alt="Logo" class="logo">
        </div>
        <div class="navbar-right">
            <el-dropdown @command="handleCommand" append-to-body>
                <span class="el-dropdown-link">
                    <el-avatar :src="image" size="40" class="avatar" />
                </span>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item command="profile">
                            <el-icon>
                                <User />
                            </el-icon>Profile
                        </el-dropdown-item>
                        <el-dropdown-item command="logout" divided>
                            <el-icon>
                                <SwitchButton />
                            </el-icon>Logout
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </el-header>
</template>

<script>
import userApi from '@/api/userapi'; // 导入 API 方法
import { useRouter } from 'vue-router'; // 导入 useRouter

export default {
    data() {
        return {
            image: require('@/assets/avatar.png'), // 头像图片路径
        };
    },
    setup() {
        const router = useRouter();

        const handleCommand = async (command) => {
            if (command === 'profile') {
                console.log('跳转到用户详情页面');
            } else if (command === 'logout') {
                try {
                    const response = await userApi.logoutUser(); // 调用 API 登出
                    console.log(response.status);
                    if (response.status === 200) {
                        router.push('/index'); // 跳转到登录页面
                        console.log('登出成功');
                    } else {
                        console.log('登出失败');
                    }
                } catch (error) {
                    console.error('登出请求出错:', error); // 处理请求过程中出现的错误
                    console.log('登出失败');
                }
            }

        };
        return { handleCommand };
    }
};
</script>

<style scoped>
.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 20px;
    background-color: #333;
    color: white;
}

.logo {
    height: 40px;
}

.navbar-right {
    display: flex;
    align-items: center;
}

.avatar {
    cursor: pointer;
}</style>
