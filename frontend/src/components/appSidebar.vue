<template>
    <el-aside width="280px" class="sidebar">
        <el-menu :default-active="$route.path" router>
            <template v-for="route in menuRoutes">
                <!-- 如果有子菜单 -->
                <el-sub-menu v-if="route.children" :key="`submenu-${route.path}`" :index="route.path">
                    <template #title>
                        <el-icon>
                            <component :is="route.meta.icon" />
                        </el-icon>
                        <span>{{ route.meta.title }}</span>
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
                    <span>{{ route.meta.title }}</span>
                </el-menu-item>
            </template>
        </el-menu>
    </el-aside>
</template>

<script>
import { computed } from 'vue';
import { useRouter } from 'vue-router';

export default {
    setup() {
        const router = useRouter();

        // 筛选出需要在菜单中显示的路由
        const menuRoutes = computed(() =>
            router.options.routes
                .filter((route) => route.meta && route.meta.title) // 只保留有标题的路由
                .map((route) => ({
                    ...route,
                    children: route.children?.filter((child) => child.meta && child.meta.title),
                })) // 处理子路由
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
}

.sidebar .el-menu-item {
    margin-bottom: 10px;
}

.el-menu-item .el-icon {
    margin-right: 10px;
}
</style>
