import http from '@/utils/http'; // 引入axios实例

const bloodBankApi = {
    // 获取后端分页列表
    getPage(params) {
        return http.get('/bloodbank/page', { params });
    },

    // 获取前端分页列表
    getList(params) {
        return http.get('/bloodbank/list', { params });
    },

    // 获取完整列表
    getFullList(data) {
        return http.post('/bloodbank/lists', data);
    },

    // 查询指定条件的血库信息
    query(data) {
        return http.post('/bloodbank/query', data);
    },

    // 获取后端详情
    getInfo(id) {
        return http.get(`/bloodbank/info/${id}`);
    },

    // 获取前端详情
    getDetail(id) {
        return http.get(`/bloodbank/detail/${id}`);
    },

    // 保存数据（后端保存）
    save(data) {
        return http.post('/bloodbank/save', data);
    },

    // 新增数据（前端保存）
    add(data) {
        return http.post('/bloodbank/add', data);
    },

    // 更新数据
    update(data) {
        return http.post('/bloodbank/update', data);
    },

    // 删除数据
    delete(ids) {
        return http.post('/bloodbank/delete', ids);
    },
};

export default bloodBankApi;
