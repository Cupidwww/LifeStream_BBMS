<template>
    <div>
        <h1>Blood Record Management</h1>
        <p>This is the blood record management page.</p>

        <!-- 批量操作工具栏 -->
        <div v-if="selectedRows.length > 0" class="batch-actions">
            <el-button type="danger" @click="handleBatchDelete">Delete All</el-button>
        </div>

        <!-- 表格 -->
        <el-table v-if="isTableReady" class="dynamic-table"
        :data="tableData" border v-loading="loading"
            @selection-change="handleSelectionChange">
            <!-- 多选框 -->
            <el-table-column type="selection" width="55" />

            <!-- 动态渲染表头 -->
            <el-table-column v-for="(value, key) in tableData[0]" :key="key" :prop="key" :label="key" />

            <!-- 操作列 -->
            <el-table-column label="operation" align="center">
                <template #default="scope">
                    <el-button type="primary" size="small" @click="handleEdit(scope.row)">Modify</el-button>
                    <el-button type="danger" size="small" @click="handleDelete(scope.row)">Delete</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 分页 -->
        <el-pagination v-if="pagination" style="margin-top: 20px; text-align: right" background
            layout="prev, pager, next, jumper" 
            :total="pagination.total || 0" 
            :page-size="pagination.pageSize || 10"
            :current-page="pagination.currentPage || 1" 
            @current-change="handlePageChange"
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
import axios from '@/utils/http.js';  // 根据实际路径修改

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
        async fetchBloodRecords(page, size) {
            this.loading = true;
            try {
                const response = await axios.get("/mock/api/blood-records", {
                    params: { page, size },
                });
                this.tableData = response.data.data;
                this.pagination.total = response.data.total;
                this.pagination.currentPage = page;
                this.pagination.pageSize = size;
                this.isTableReady = true;
            } catch (error) {
                console.error("请求失败，错误信息：", error);
            } finally {
                this.loading = false;
            }
        },

        handlePageChange(page) {
            this.fetchBloodRecords(page, this.pagination.pageSize);
        },

        handleSizeChange(size) {
            this.fetchBloodRecords(this.pagination.currentPage, size);
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

        handleDelete(row) {
            console.log("删除行:", row);
            // 在这里调用删除接口，删除指定的数据
        },

        async handleAddRecord() {
            // 调用接口插入新记录
            try {
                await axios.post("/mock/api/blood-records", this.newRecord);
                this.showAddDialog = false;
                this.fetchBloodRecords(this.pagination.currentPage, this.pagination.pageSize); // 重新加载数据
            } catch (error) {
                console.error("插入记录失败，错误信息：", error);
            }
        },
    },
    mounted() {
        this.fetchBloodRecords(this.pagination.currentPage, this.pagination.pageSize);
    },
};
</script>

<style scoped>

</style>


<style scoped>

.dynamic-table {
    table-layout: fixed;
    flex-grow: 1; /* 让表格区域占据父容器的剩余空间 */
    overflow: auto; /* 当表格内容超出时，可以滚动 */
}
.batch-actions {
    margin-bottom: 20px;
}

</style>
