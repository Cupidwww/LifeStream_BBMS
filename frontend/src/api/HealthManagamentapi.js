import http from '@/utils/http'; // 引入http实例

const healthManagementApi = {
    // 后端分页列表
    getPage(params) {
        return http.get('/health_management/page', { params });
    },

    // 前端分页列表
    getList(params) {
        return http.get('/health_management/list', { params });
    },

    // 获取完整列表
    getFullList(data) {
        return http.post('/health_management/lists', data);
    },

    // 查询指定条件的健康管理信息
    query(data) {
        return http.post('/health_management/query', data);
    },

    // 获取后端详情
    getInfo(id) {
        return http.get(`/health_management/info/${id}`);
    },

    // 获取前端详情
    getDetail(id) {
        return http.get(`/health_management/detail/${id}`);
    },

    // 保存数据（后端保存）
    save(data) {
        return http.post('/health_management/save', data);
    },

    // 新增数据（前端保存）
    add(data) {
        return http.post('/health_management/add', data);
    },

    // 更新数据
    update(data) {
        return http.post('/health_management/update', data);
    },

    // 删除数据
    delete(ids) {
        return http.post('/health_management/delete', ids);
    },

    // 提醒接口
    remind(columnName, type, params) {
        return http.post(`/health_management/remind/${columnName}/${type}`, params);
    },
};

export default healthManagementApi;


