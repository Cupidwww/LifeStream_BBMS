<template>
    <el-container class="page-layout">
        <!-- 导航栏 -->
        <el-header height="60px" class="navbar">
            <Navbar />
        </el-header>

        <!-- 主体布局 -->
        <el-container>
            <!-- 侧边栏 -->
            <el-aside :width="sidebarWidth" class="sidebar">
                <Sidebar :is-collapsed="isCollapsed"/>
            </el-aside>

            <!-- 切换按钮 -->
            <div class="sidebar-toggle-button">
            <el-button type="text" @click="toggleSidebar" style="height: 100%;">
              <el-icon :size="20">
                <component :is="isCollapsed ? 'Expand' : 'Fold'" />
              </el-icon>
            </el-button>
            </div>

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
    data() {
        return {
            isCollapsed: false, // 侧边栏是否收缩
        };
    },
    computed: {
        sidebarWidth() {
            return this.isCollapsed ? '80px' : '280px'; // 根据状态动态设置宽度
        },
    },
    methods: {
        toggleSidebar() {
            this.isCollapsed = !this.isCollapsed; // 切换状态
            console.log(this.isCollapsed);
        },
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
    transition: width 0.3s; /* 添加过渡效果 */
}

.sidebar-toggle-button {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 20px; /* 按钮宽度 */
  background-color: #f4f4f4; /* 背景色 */
  border-left: 1px solid #e6e6e6; /* 左侧分割线 */
  border-right: 1px solid #e6e6e6; /* 右侧分割线 */
  cursor: pointer; /* 鼠标悬停时显示手型 */
  transition: background-color 0.3s; /* 过渡效果 */
}

.sidebar-toggle-button:hover {
  background-color: #e6e6e6; /* 鼠标悬停时的背景色 */
}
</style>
