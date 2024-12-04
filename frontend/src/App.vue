<template>
  <component :is="layoutComponent">
      <router-view />
    </component>
</template>

<script>
import { defineComponent, computed } from 'vue';
import { useRoute } from 'vue-router';
// import AuthLayout from '@/layouts/AuthLayout.vue';
// import PageLayout from '@/layouts/PageLayout.vue';

export default defineComponent({
  name: 'App',
  setup() {
    const route = useRoute();

    // 计算布局组件
    const layoutComponent = computed(() => {
      // 如果路由的 meta 中有 layout，使用它；否则默认使用 PageLayout
      return route.meta.layout;
    });

    return { layoutComponent };
  },
});
</script>

<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
