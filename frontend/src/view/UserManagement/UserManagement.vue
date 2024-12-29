<template>
    <div>
        <h1>User Management</h1>
        <!-- 查询工具栏 -->
            <!-- <div v-if="isTableReady" class="search-bar">
            <el-input v-model="searchQuery" placeholder="Enter search term" suffix-icon="el-icon-search" @keyup.enter="handleSearch" />
            <el-button type="primary" @click="handleSearch">Search</el-button>
        </div> -->

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
                <el-table-column label="operation" align="center" min-width="120">
                    <template #default="scope">
                        <el-button type="primary" size="small" @click="handleEdit(scope.row)">
                            <el-icon><edit /></el-icon>
                        </el-button>
                        <el-button type="danger" size="small" @click="handleDeleteRecords([scope.row.id])">
                            <el-icon><delete /></el-icon>
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>

            <!-- 分页 -->
            <el-pagination v-if="pagination" style="margin-top: 20px; text-align: right" background
                layout="prev, pager, next, jumper" :total="pagination.total || 0" :page-size="pagination.pageSize || 10"
                :current-page="pagination.currentPage || 1" @current-change="handlePageChange"
                @size-change="handleSizeChange" />

            <!-- 插入数据按钮 -->
            <el-button type="primary" @click="showAddDialog = true">Add New Record</el-button>    
    </div>
</template>
<script>
import userApi from '@/api/userapi';

export default {
    data() {
        return {
            isTableReady: false,  // 控制表格的显示
            loading: false,
            tableData: [],
            selectedRows: [],  // 存储选中的数据
            searchQuery: "",  // 用于存储查询条件

            // 分页
            pagination: {
                total: 0,
                currentPage: 1,
                pageSize: 10,
            },
        }
    },
    methods: {       
        async loadData() {
            this.loading = true;
            try {
                // 查询参数
                const params = {
                    page: this.pagination.currentPage,
                    limit: this.pagination.pageSize,
                };
                // 用户实体（根据实际需求填写）
                // const user = {
                //     username: '张三', 
                //     role: 'user'     
                // };
                // 调用接口
                const response = await userApi.getUserList(params);
                console.log('User records:', response.data.data);

                // 更新表格数据和分页信息
                this.tableData = response.data.data.list;
                this.pagination.total = response.data.data.total;
                this.isTableReady = true;
            } catch (error) {
                console.error('加载数据失败', error);
            } finally {
                this.loading = false;
            }
        },
        //
        // 页面变更
        handlePageChange(page) {
            this.pagination.currentPage = page;
            this.loadData();
        },

        // 每页大小变更
        handleSizeChange(size) {
            this.pagination.pageSize = size;
            this.pagination.currentPage = 1;
            this.loadData();
        },

        // 选中行变化
        handleSelectionChange(val) {
            this.selectedRows = val;
        },

        // 批量删除
        handleBatchDelete() {
            if (this.selectedRows.length > 0) {
                const ids = this.selectedRows.map(row => row.id);
                this.handleDeleteRecords(ids);
            }
        },

        // 删除单个或多个记录
        async handleDeleteRecords(ids) {
            try {
                console.log('删除记录:', ids);
                await userApi.delete(ids);
                this.loadData(); // 刷新数据
            } catch (error) {
                console.error('删除记录失败', error);
            }
        },

        // 处理编辑记录
        async handleEdit(row) {
            // 打开编辑弹窗
            this.$emit('edit-user', row);
        },
        // 打开新增弹窗
        showAddDialog() {
            this.$emit('show-add-dialog');
        },

    },
    created() {
        this.loadData();
    },
}

</script>
