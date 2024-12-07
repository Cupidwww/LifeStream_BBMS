<template>
    <el-container class="page-layout">
        <!-- 导航栏 -->
        <el-header height="60px" class="navbar">
            <Navbar />
        </el-header>

        <!-- 主体布局 -->
        <el-container>
            <!-- 侧边栏 -->
            <el-aside width="280px" class="sidebar">
                <Sidebar />
            </el-aside>

            <!-- 内容区域 -->
            <el-main>
                <router-view /> <!-- 动态加载路由页面 -->
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
import Navbar from '../components/appNavbar.vue';
import Sidebar from '../components/appSidebar.vue';

export default {
    name: 'AuthLayout',
    components: {
        Navbar,
        Sidebar,
    },
};
</script>

<style scoped>
.page-layout {
    height: 100vh;
}

.navbar {
    background-color: #333;
    color: white;
}

.sidebar {
    background-color: #f4f4f4;
}
</style>
