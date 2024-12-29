<template>
    <el-aside :width="isCollapsed ? '84px' : '280px'" class="sidebar" :class="{ collapsed: isCollapsed }">
        <el-menu :default-active="$route.path" router :collapse="isCollapsed" >
            <template v-for="route in menuRoutes">
                <!-- 如果有子菜单 -->
                <el-sub-menu v-if="route.children" :key="`submenu-${route.path}`" :index="route.path">
                    <template #title>
                        <el-icon>
                            <component :is="route.meta.icon" />
                        </el-icon>
                        <span v-show="!isCollapsed">{{ route.meta.title }}</span>
                    </template>
                    <el-menu-item v-for="child in route.children" :key="`${route.path}-${child.path}`"
                        :index="`${route.path.replace(/\/$/, '')}/${child.path.replace(/^\//, '')}`"
                        :to="`${route.path.replace(/\/$/, '')}/${child.path.replace(/^\//, '')}`">
                        {{ child.meta.title }}
                    </el-menu-item>
                </el-sub-menu>

                <!-- 没有子菜单 -->
                <el-menu-item v-else :key="`menuitem-${route.path}`" :index="route.path" :to="route.path">
                    <el-icon>
                        <component :is="route.meta.icon" />
                    </el-icon>
                    <span v-show="!isCollapsed">{{ route.meta.title }}</span>
                </el-menu-item>
            </template>
        </el-menu>
    </el-aside>
</template>

<script>
import { computed } from 'vue';
import { useRouter } from 'vue-router';

export default {
    props: {
        isCollapsed: {
            type: Boolean,
            required: true,
        },
    },
    setup() {
        const router = useRouter();

        // 筛选出需要在菜单中显示的路由
        const menuRoutes = computed(() =>
            router.options.routes
                .filter((route) => route.meta && route.meta.title)
                .map((route) => ({
                    ...route,
                    children: route.children?.filter((child) => child.meta && child.meta.title),
                }))
        );

        return {
            menuRoutes,
        };
    },
};
</script>


<style scoped>
.sidebar {
    background-color: #f4f4f4;
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
    padding: 10px;
    transition: width 0.3s;
    /* 添加过渡效果 */
}

.sidebar .el-menu-item {
    position: relative; /* 确保子元素 span 可以绝对定位 */
    margin-bottom: 10px;
    white-space: nowrap;
    /* 防止文字换行 */
}

.el-menu-item .el-icon {
    margin-right: 10px;
}

/* 侧边栏收缩时隐藏标题中的 span */
.sidebar.collapsed .el-sub-menu__title span {
  display: none;
}

/* 鼠标悬停时显示标题中的 span */
.sidebar.collapsed .el-sub-menu__title:hover span {
  display: inline;
  position: absolute;
  left: 84px; /* 根据侧边栏宽度调整 */
  background-color: #fff;
  padding: 5px 10px;
  border-radius: 4px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}
</style>
