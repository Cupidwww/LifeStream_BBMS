<template>
    <div id="app">
        <!-- 导航栏 -->
        <el-header height="60px" class="navbar">
            <div class="navbar-left">
                <img src="logo.png" alt="Logo" class="logo">
            </div>
            <div class="navbar-right">
        <el-dropdown @command="handleCommand" append-to-body>
          <span class="el-dropdown-link">
            <el-avatar src="avatar.jpg" size="40" class="avatar" />
          </span>
          <!-- 确保菜单位于 slot="dropdown" -->
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item command="profile">
                <el-icon><User /></el-icon>Profile
            </el-dropdown-item>
              <el-dropdown-item command="logout" divided>
                <el-icon><SwitchButton /></el-icon>Logout
            </el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
        </el-header>

        <el-container>
        <!-- 侧边栏 -->
        <el-aside width="220px" class="sidebar">
          <el-menu default-active="1" router>
            <!-- 个人主页 -->
            <el-menu-item index="1">
              <el-icon><HomeFilled /></el-icon>
              <span>Personal homepage</span>
            </el-menu-item>

            <!-- 献血预约 -->
            <el-menu-item index="2">
                <el-icon><Calendar /></el-icon>
                <span>Blood donation</span>
            </el-menu-item>
            
            <!-- 人员管理 -->
            <el-sub-menu index="3">
            <template #title>
              <el-icon><Avatar /></el-icon>
              <span>User management</span>
            </template>
            <el-menu-item index="3-1">Donor</el-menu-item>
            <el-menu-item index="3-2">Staff</el-menu-item>
          </el-sub-menu>

            <!-- 血库管理 -->
            <el-sub-menu index="4">
            <template #title>
                <el-icon><Grid /></el-icon>
                <span>Blood bank</span>
            </template>
                <el-menu-item index="4-1">Qurey</el-menu-item>
                <el-menu-item index="4-2">Inbound</el-menu-item>
                <el-menu-item index="4-3">Outbound</el-menu-item>
            </el-sub-menu>
            
            <!-- 消息通知 -->
            <el-menu-item index="5">
                <el-icon><Bell /></el-icon>
                <span>Message</span>
            </el-menu-item>

            <!-- 设置 -->
            <el-menu-item index="6">
              <el-icon><Tools /></el-icon>
              <span>Setting</span>
            </el-menu-item>
          </el-menu>
        </el-aside>

        <!-- 主体内容 -->
        <el-main>
          <h1>欢迎来到页面！</h1>
          <p>这里是主要内容区域。</p>
        </el-main>
      </el-container>
    </div>
</template>


<script>

export default {
    setup() {
        // 定义方法
        const handleCommand = (command) => {
            if (command === 'profile') {
                console.log('跳转到用户详情页面');
            } else if (command === 'logout') {
                console.log('退出成功！');
            }
        };

        // 返回给模板使用
        return {
            handleCommand,
        };
    },
};
</script>

<style scoped>
/* 全局布局 */
#app {
    height: 100vh;
    display: flex;
    flex-direction: column;
}

/* 导航栏样式 */
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
}

/* 侧边栏样式 */
.sidebar {
    background-color: #f4f4f4;
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
    padding: 10px;
}

.sidebar .el-menu-item {
    margin-bottom: 10px;
}

.el-menu-item .el-icon {
    margin-right: 10px;
}

/* 主体内容 */
.el-main {
    padding: 20px;
}
</style>
