import http from '@/utils/http'; // 引入http实例

const bloodDonationApi = {
    // 获取后端分页列表
    getPage(params) {
        return http.get('/blood_donation/page', { params });
    },

    // 获取前端分页列表
    getList(params) {
        return http.get('/blood_donation/list', { params });
    },

    // 获取完整列表
    getFullList(data) {
        return http.post('/blood_donation/lists', data);
    },

    // 查询指定条件的血液捐献信息
    query(data) {
        return http.post('/blood_donation/query', data);
    },

    // 获取后端详情
    getInfo(id) {
        return http.get(`/blood_donation/info/${id}`);
    },

    // 获取前端详情
    getDetail(id) {
        return http.get(`/blood_donation/detail/${id}`);
    },

    // 保存数据（后端保存）
    save(data) {
        return http.post('/blood_donation/save', data);
    },

    // 新增数据（前端保存）
    add(data) {
        return http.post('/blood_donation/add', data);
    },

    // 更新数据
    update(data) {
        return http.post('/blood_donation/update', data);
    },

    // 删除数据
    delete(ids) {
        return http.post('/blood_donation/delete', ids);
    },

    // 提醒接口
    remind(columnName, type, params) {
        return http.post(`/blood_donation/remind/${columnName}/${type}`, params);
    },
};

export default bloodDonationApi;
