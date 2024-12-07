import { createApp } from 'vue';
import router from './router';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import * as Icons from '@element-plus/icons-vue'; // 引入图标库
import App from './App.vue';

const app = createApp(App);

// 注册所有图标组件
for (const [key, component] of Object.entries(Icons)) {
    app.component(key, component);
}

app.use(router);
app.use(ElementPlus);
app.mount('#app');

