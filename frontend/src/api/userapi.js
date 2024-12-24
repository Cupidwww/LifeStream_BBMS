import http from '@/utils/http'; // 确保路径正确

// 注册用户接口
export const registerUser = (userData) => {
  return http.post('/register', userData);
};

// 示例：其他用户相关接口
// 登录接口
export const loginUser = (loginData) => {
  return http.post('/login', loginData);
};

// 获取用户信息
export const getUserInfo = () => {
  return http.get('/resetPass');
};

// 导出所有接口
export default {
  registerUser,
  loginUser,
  getUserInfo,
};
