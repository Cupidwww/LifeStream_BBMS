<template>
    <el-header height="60px" class="navbar">
        <div class="navbar-left">
            <img src="..\assets\爱如火icon-removebg-preview.png" alt="Logo" class="logo">
            <img src="..\assets\爱如火-removebg-preview.png" alt="Logo" class="logo">
        </div>
        <div class="navbar-right">
            <el-dropdown @command="handleCommand" append-to-body>
                <span class="el-dropdown-link">
                    <el-avatar src="avatar.jpg" size="40" class="avatar" />
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
export default {
    setup() {
        const handleCommand = (command) => {
            if (command === 'profile') {
                console.log('跳转到用户详情页面');
            } else if (command === 'logout') {
                console.log('退出成功！');
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
