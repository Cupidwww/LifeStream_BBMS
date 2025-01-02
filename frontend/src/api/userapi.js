import http from '@/utils/http'; // 确保路径正确

const userApi = {
  // 注册用户接口
  registerUser(userData) {
    return http.post('/user/register', userData); // 使用完整的路径
  },

  // 登录接口
  loginUser(userData) {
    return http.post('/user/login', userData); // 使用完整的路径
  },

  // 退出登录接口
  logoutUser() {
    return http.post('/user/logout'); // 使用完整的路径
  },

  // 获取用户信息接口
  getUserInfo() {
    return http.get('/user/session'); // 使用完整的路径
  },

  // 密码重置接口
  resetPassword(username) {
    return http.post('/user/resetPass', { username });
  },

  // 获取用户列表（后端）
  getPage(params) {
    return http.get('/user/page',{ params }); // 使用完整的路径
  },

  // 获取用户列表（前端）
  getUserList(user) {
    return http.post('/user/lists', user); // 之前使用GET请求并传递查询参数，现在用post
  },

  // 获取用户详情
  getUserDetail(id) {
    return http.get(`/user/detail/${id}`); // 使用路径参数
  },

  // 更新用户信息接口
  updateUser(userData) {
    return http.post('/user/update', userData); // 使用POST请求更新用户信息
  },

  // 新增用户接口
  addUser(userData) {
    return http.post('/user/add', userData); // 使用POST请求新增用户
  },

  // 删除用户接口
  deleteUser(ids) {
    return http.post('/user/delete', ids); // 批量删除用户
  }
};

// 导出用户相关接口
export default userApi;
