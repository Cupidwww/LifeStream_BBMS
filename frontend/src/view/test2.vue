<template>
    <div>
        <h1>Blood Record Management</h1>
        <p>This is the blood record management page.</p>

        <!-- 批量操作工具栏 -->
        <div v-if="selectedRows.length > 0" class="batch-actions">
            <el-button type="danger" @click="handleBatchDelete">Delete All</el-button>
        </div>

        <!-- 表格 -->
        <el-table v-if="isTableReady" class="dynamic-table" :data="tableData" border v-loading="loading"
            @selection-change="handleSelectionChange">
            <!-- 多选框 -->
            <el-table-column type="selection" width="55" />

            <!-- 动态渲染表头 -->
            <el-table-column v-for="(value, key) in tableData[0]" :key="key" :prop="key" :label="key" />

            <!-- 操作列 -->
            <el-table-column label="operation" align="center">
                <template #default="scope">
                    <el-button type="primary" size="small" @click="handleEdit(scope.row)">Modify</el-button>
                    <el-button type="danger" size="small" @click="handleDeleteRecords(scope.row)">Delete</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 分页 -->
        <el-pagination v-if="pagination" style="margin-top: 20px; text-align: right" background
            layout="prev, pager, next, jumper" :total="pagination.total || 0" :page-size="pagination.pageSize || 10"
            :current-page="pagination.currentPage || 1" @current-change="handlePageChange"
            @size-change="handleSizeChange" />

        <!-- 添加数据弹窗 -->
        <el-dialog v-model="showAddDialog" title="添加血液记录">
            <el-form :model="newRecord" label-width="100px">
                <el-form-item label="血液类型">
                    <el-input v-model="newRecord.type" />
                </el-form-item>
                <el-form-item label="数量">
                    <el-input v-model="newRecord.amount" type="number" />
                </el-form-item>
                <el-form-item label="日期">
                    <el-date-picker v-model="newRecord.date" type="date" placeholder="选择日期" />
                </el-form-item>
            </el-form>
            <template v-slot:footer>
                <div class="dialog-footer">
                    <el-button @click="showAddDialog = false">Cancel</el-button>
                    <el-button type="primary" @click="handleAddRecord">Confirm</el-button>
                </div>
            </template>

        </el-dialog>

        <!-- 插入数据按钮 -->
        <el-button type="primary" @click="showAddDialog = true">Add</el-button>
    </div>
</template>

<script>
// import axios from '@/utils/http.js';  // 根据实际路径修改
import api from '@/utils/api.js';

export default {
    data() {
        return {
            isTableReady: false,  // 控制表格的显示
            loading: false,
            tableData: [],
            selectedRows: [],  // 存储选中的数据
            pagination: {
                total: 0,
                currentPage: 1,
                pageSize: 10,
            },
            showAddDialog: false,  // 控制添加数据弹窗的显示
            newRecord: {  // 新记录的表单数据
                type: '',
                amount: '',
                date: '',
            },
        };
    },
    methods: {
        async loadData() {
            this.loading = true;
            try {
                const response = await api.fetchBloodRecords(this.pagination.currentPage, this.pagination.pageSize);
                // console.log('Blood records:', response.data);
                this.tableData = response.data.data;
                this.pagination.total = response.data.total;
                this.isTableReady = true;
            } catch (error) {
                console.error('加载数据失败', error);
            } finally {
                this.loading = false;
            }
        },

        handlePageChange(page) {
            // 更新当前页
            this.pagination.currentPage = page;
            // 重新加载数据
            this.loadData();
        },

        handleSizeChange(size) {
            // 更新每页大小
            this.pagination.pageSize = size;
            // 重置到第一页
            this.pagination.currentPage = 1;
            // 重新加载数据
            this.loadData();
        },

        handleSelectionChange(val) {
            // 当选择框发生变化时，更新选中的行
            this.selectedRows = val;
        },

        handleBatchDelete() {
            // 批量删除逻辑
            console.log("Selected rows for deletion:", this.selectedRows);
            // 在这里调用删除接口，将选中的数据删除
        },

        handleEdit(row) {
            console.log("编辑行:", row);
            // 在这里你可以实现编辑的逻辑
        },

        async handleDeleteRecords(selectedIds) {
            try {
                await api.deleteBloodRecords(selectedIds);
                this.loadData(); // 刷新数据
            } catch (error) {
                console.error('删除记录失败', error);
            }
        },


        async handleAddRecord() {
            // 调用接口插入新记录
            try {
                await api.addBloodRecord(this.newRecord);
                this.showAddDialog = false;
                this.loadData();
            } catch (error) {
                console.error("插入记录失败，错误信息：", error);
            }
        },
    },
    mounted() {
        this.loadData();
    },
};
</script>

<style scoped></style>


<style scoped>
.dynamic-table {
    table-layout: fixed;
    flex-grow: 1;
    /* 让表格区域占据父容器的剩余空间 */
    overflow: auto;
    /* 当表格内容超出时，可以滚动 */
}

.batch-actions {
    margin-bottom: 20px;
}
</style>
