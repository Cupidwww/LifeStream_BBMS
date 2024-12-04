import axios from 'axios';
// import storage from '@/utils/storage';

// 创建 axios 实例
const http = axios.create({
    timeout: 1000 * 86400,
    withCredentials: true,
    baseURL: process.env.NODE_ENV === 'development' ? '/mock' : '/springbootypiqw',  // 开发环境指向 mock
    headers: {
        'Content-Type': 'application/json; charset=utf-8'
    }
});

// 请求拦截器：在请求发送之前添加认证信息（如 Token）
http.interceptors.request.use(config => {
    const token = localStorage.getItem('authToken'); // 假设 token 存储在 localStorage 中
    if (token) {
        config.headers['Authorization'] = `Bearer ${token}`;  // 将 token 添加到请求头
    }
    return config; // 返回修改后的 config
}, error => {
    return Promise.reject(error); // 请求失败时处理
});

// 响应拦截器：统一处理错误，展示错误信息
http.interceptors.response.use(response => {
    return response; // 请求成功，直接返回响应
}, error => {
    // 统一的错误处理逻辑
    if (error.response) {
        const status = error.response.status;
        if (status === 401) {
            // 401 错误：未授权，可能是 token 过期或无效
            console.error('认证失败，请重新登录');
        } else if (status === 500) {
            // 500 错误：服务器错误
            console.error('服务器错误，请稍后再试');
        } else {
            // 其他错误
            console.error(`请求失败: ${error.response.data.message || '未知错误'}`);
        }
    } else {
        console.error('请求失败：网络错误或超时');
    }
    return Promise.reject(error); // 继续抛出错误
});

export default http;

