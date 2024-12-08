<template>
    <div>
        <h1>Blood Record Management</h1>

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
            <el-table-column label="operation" align="center">
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

        <!-- 添加数据弹窗 -->
    <el-dialog v-model="showAddDialog" title="添加血液记录">
        <el-form :model="newRecord" label-width="100px">
            <el-form-item label="Blood Type" :rules="[{ required: true, message: 'Blood Type is required', trigger: 'blur' }]">
                <el-input v-model="newRecord.bloodType" />
            </el-form-item>
            <el-form-item label="Category" :rules="[{ required: true, message: 'Blood Category is required', trigger: 'blur' }]">
                <el-input v-model="newRecord.bloodCategory" />
            </el-form-item>
            <el-form-item label="Amount" :rules="[{ required: true, message: 'Blood Volume is required', trigger: 'blur' }]">
                <el-input v-model="newRecord.bloodVolume" type="number" />
            </el-form-item>
            <el-form-item label="Date" :rules="[{ required: true, message: 'Transaction Date is required', trigger: 'change' }]">
                <el-date-picker v-model="newRecord.transactionDate" type="date" placeholder="Choose Date" />
            </el-form-item>
            <el-form-item label="Expiration Date" :rules="[{ required: true, message: 'Expiration Date is required', trigger: 'change' }]">
                <el-date-picker v-model="newRecord.expirationDate" type="date" placeholder="Choose Expiration Date" />
            </el-form-item>
            <el-form-item label="Blood Source" :rules="[{ required: true, message: 'Blood Source is required', trigger: 'blur' }]">
                <el-input v-model="newRecord.bloodSource" />
            </el-form-item>
            <el-form-item label="Remarks">
                <el-input v-model="newRecord.remarks" />
            </el-form-item>
        </el-form>
        <template v-slot:footer>
            <div class="dialog-footer">
                <el-button @click="showAddDialog = false">Cancel</el-button>
                <el-button type="primary" @click="handleAddRecord">Confirm</el-button>
            </div>
        </template>
    </el-dialog>


        <!-- 编辑数据弹窗 -->
    <el-dialog v-model="showEditDialog" title="编辑血液记录">
        <el-form :model="editRecord" label-width="100px">
            <el-form-item label="Blood Type" :rules="[{ required: true, message: 'Blood Type is required', trigger: 'blur' }]">
                <el-input v-model="editRecord.bloodType" />
            </el-form-item>
            <el-form-item label="Category" :rules="[{ required: true, message: 'Blood Category is required', trigger: 'blur' }]">
                <el-input v-model="editRecord.bloodCategory" />
            </el-form-item>
            <el-form-item label="Amount" :rules="[{ required: true, message: 'Blood Volume is required', trigger: 'blur' }]">
                <el-input v-model="editRecord.bloodVolume" type="number" />
            </el-form-item>
            <el-form-item label="Date" :rules="[{ required: true, message: 'Transaction Date is required', trigger: 'change' }]">
                <el-date-picker v-model="editRecord.transactionDate" type="date" placeholder="Choose Date" />
            </el-form-item>
            <el-form-item label="Expiration Date" :rules="[{ required: true, message: 'Expiration Date is required', trigger: 'change' }]">
                <el-date-picker v-model="editRecord.expirationDate" type="date" placeholder="Choose Expiration Date" />
            </el-form-item>
            <el-form-item label="Blood Source" :rules="[{ required: true, message: 'Blood Source is required', trigger: 'blur' }]">
                <el-input v-model="editRecord.bloodSource" />
            </el-form-item>
            <el-form-item label="Remarks">
                <el-input v-model="editRecord.remarks" />
            </el-form-item>
        </el-form>
        <template v-slot:footer>
            <div class="dialog-footer">
                <el-button @click="showEditDialog = false">Cancel</el-button>
                <el-button type="primary" @click="handleUpdateRecord">Confirm</el-button>
            </div>
        </template>
    </el-dialog>


        <!-- 插入数据按钮 -->
        <el-button type="primary" @click="showAddDialog = true">Add New Record</el-button>
    </div>
</template>

<script>
// 引入新的 API
import bloodBankApi from '@/api/BloodBankapi.js';

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

            showAddDialog: false,  // 控制添加数据弹窗的显示
            showEditDialog: false,  // 控制编辑数据弹窗的显示
            // 新增记录数据
            newRecord: {
                bloodType: "A+",
                bloodCategory: "whole blood",
                bloodVolume: 250.0,
                transactionDate: "2024-12-08 10:00:00",
                expirationDate: "2124-12-15 10:00:00",
                bloodSource: "hospital",
                remarks: "This is a test record.",
                addtime: "2024-12-08 10:00:00"
            },
            // 编辑记录数据
            editRecord: {
                id: null,
                bloodType: "",
                bloodCategory: "",
                bloodVolume: null,
                transactionDate: null,
                expirationDate: null,
                bloodSource: "",
                remarks: "",
            },
        };
    },
    methods: {
        // 加载数据
        async loadData() {
            this.loading = true;
            try {
                const response = await bloodBankApi.getPage({
                    page: this.pagination.currentPage,
                    pageSize: this.pagination.pageSize,
                });
                console.log('Blood records:', response.data.data);
                this.tableData = response.data.data.list;
                this.pagination.total = response.data.data.total;
                this.isTableReady = true;
            } catch (error) {
                console.error('加载数据失败', error);
            } finally {
                this.loading = false;
            }
        },

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
                await bloodBankApi.delete(ids);
                this.loadData(); // 刷新数据
            } catch (error) {
                console.error('删除记录失败', error);
            }
        },

        // 编辑记录
        async handleEdit(row) {
            this.editRecord = { ...row }; // 复制当前行数据到编辑数据模型
            this.showEditDialog = true;
        },

        // 更新记录
        async handleUpdateRecord() {
            console.log("更新记录成功:", this.editRecord);
            try {
                await bloodBankApi.update(this.editRecord);
                
                this.showEditDialog = false;
                this.loadData(); // 刷新数据
            } catch (error) {
                console.error("更新记录失败", error);
            }
        },

        // 添加记录
        async handleAddRecord() {
            try {
                console.log("插入记录:", this.newRecord);
                await bloodBankApi.add(this.newRecord);
                this.showAddDialog = false;
                this.loadData();
            } catch (error) {
                console.error("插入记录失败，错误信息：", error);
            }
        },

        // 查询
        // async handleSearch() {
        //     this.pagination.currentPage = 1; // 重置分页到第一页
        //     this.loading = true;
        //     try {
        //         const response = await bloodBankApi.query({
        //             search: this.searchQuery,
        //             page: this.pagination.currentPage,
        //             pageSize: this.pagination.pageSize
        //         });
        //         console.log('查询结果:', response.data);
        //         this.tableData = response.data.list;
        //         this.pagination.total = response.data.total;
        //         this.isTableReady = true;
        //     } catch (error) {
        //         console.error('查询失败', error);
        //     } finally {
        //         this.loading = false;
        //     }
        // },
    },
    created() {
        this.loadData();
    },
};
</script>

<style scoped>
.dynamic-table {
    table-layout: fixed;
    flex-grow: 1;
    overflow: auto;
}

.batch-actions {
    margin-bottom: 20px;
}

.search-bar {
    margin-bottom: 20px;
}
</style>
