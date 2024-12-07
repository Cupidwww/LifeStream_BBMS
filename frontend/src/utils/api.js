import http from '@/utils/http'; // 导入配置好的 axios 实例

// 获取血液记录
export const fetchBloodRecords = (page, size) => {
    return http.get('/mock/api/blood-records', {
        params: { page, size }
    });
};

// 添加血液记录
export const addBloodRecord = (data) => {
    return http.post('/mock/api/blood-records', data);
};

// 批量删除血液记录
export const deleteBloodRecords = (ids) => {
    return http.delete('/mock/api/blood-records', {
        data: { ids }  // 用 data 包装参数
    });
};

// 更新血液记录
export const updateBloodRecord = (id, data) => {
    return http.put(`/mock/api/blood-records/${id}`, data);
};

// 获取单条血液记录
export const fetchBloodRecordById = (id) => {
    return http.get(`/mock/api/blood-records/${id}`);
};

export default {
    fetchBloodRecords,
    addBloodRecord,
    deleteBloodRecords,
    updateBloodRecord,
    fetchBloodRecordById
};
