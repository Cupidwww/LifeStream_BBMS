<template>
    <div>
        <h1>Blood Donation Record Management</h1>

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
                        <el-icon>
                            <edit />
                        </el-icon>
                    </el-button>
                    <el-button type="danger" size="small" @click="handleDeleteRecords([scope.row.id])">
                        <el-icon>
                            <delete />
                        </el-icon>
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
        <el-dialog v-model="showAddDialog" title="Add Blood Donation Record">
            <el-form :model="newRecord" label-width="100px">
                <el-form-item label="Blood Type"
                    :rules="[{ required: true, message: 'Blood Type is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.bloodType" />
                </el-form-item>
                <el-form-item label="Donation Type"
                    :rules="[{ required: true, message: 'Donation Type is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.donationType" />
                </el-form-item>
                <el-form-item label="Volume" :rules="[{ required: true, message: 'Volume is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.volume" type="number" />
                </el-form-item>
                <el-form-item label="Donation Date"
                    :rules="[{ required: true, message: 'Donation Date is required', trigger: 'change' }]">
                    <el-date-picker v-model="newRecord.donationDate" type="date" placeholder="Choose Date" />
                </el-form-item>
                <el-form-item label="Expiry Date"
                    :rules="[{ required: true, message: 'Expiry Date is required', trigger: 'change' }]">
                    <el-date-picker v-model="newRecord.expiryDate" type="date" placeholder="Choose Expiry Date" />
                </el-form-item>
                <el-form-item label="Donor" :rules="[{ required: true, message: 'Donor is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.donor" />
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
        <el-dialog v-model="showEditDialog" title="Edit Blood Donation Record">
            <el-form :model="editRecord" label-width="100px">
                <el-form-item label="Blood Type"
                    :rules="[{ required: true, message: 'Blood Type is required', trigger: 'blur' }]">
                    <el-input v-model="editRecord.bloodType" />
                </el-form-item>
                <el-form-item label="Donation Type"
                    :rules="[{ required: true, message: 'Donation Type is required', trigger: 'blur' }]">
                    <el-input v-model="editRecord.donationType" />
                </el-form-item>
                <el-form-item label="Volume" :rules="[{ required: true, message: 'Volume is required', trigger: 'blur' }]">
                    <el-input v-model="editRecord.volume" type="number" />
                </el-form-item>
                <el-form-item label="Donation Date"
                    :rules="[{ required: true, message: 'Donation Date is required', trigger: 'change' }]">
                    <el-date-picker v-model="editRecord.donationDate" type="date" placeholder="Choose Date" />
                </el-form-item>
                <el-form-item label="Expiry Date"
                    :rules="[{ required: true, message: 'Expiry Date is required', trigger: 'change' }]">
                    <el-date-picker v-model="editRecord.expiryDate" type="date" placeholder="Choose Expiry Date" />
                </el-form-item>
                <el-form-item label="Donor" :rules="[{ required: true, message: 'Donor is required', trigger: 'blur' }]">
                    <el-input v-model="editRecord.donor" />
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
        <el-button type="primary" @click="showAddDialog = true">Add New Donation Record</el-button>
    </div>
</template>

<script>
// 引入新的 API
import bloodDonationApi from '@/api/BloodDonationapi.js';

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
                donationType: "Whole Blood",
                volume: 450,
                donationDate: "2024-12-08",
                expiryDate: "2024-12-15",
                donor: "John Doe",
                remarks: "Donor is healthy",
            },
            // 编辑记录数据
            editRecord: {
                id: null,
                bloodType: "",
                donationType: "",
                volume: null,
                donationDate: null,
                expiryDate: null,
                donor: "",
                remarks: "",
            },
        };
    },
    methods: {
        // 加载数据
        async loadData() {
            this.loading = true;
            try {
                const response = await bloodDonationApi.getPage({
                    page: this.pagination.currentPage,
                    pageSize: this.pagination.pageSize,
                });
                console.log('Blood donation records:', response.data.data.list);
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

        // 删除记录
        async handleDeleteRecords(ids) {
            try {
                await bloodDonationApi.delete(ids);
                this.loadData(); // 删除成功后重新加载数据
            } catch (error) {
                console.error('删除记录失败', error);
            }
        },

        // 显示编辑弹窗
        handleEdit(row) {
            this.editRecord = { ...row };
            this.showEditDialog = true;
        },

        // 更新记录
        async handleUpdateRecord() {
            try {
                await bloodDonationApi.update(this.editRecord);
                this.loadData(); // 更新成功后重新加载数据
                this.showEditDialog = false;
            } catch (error) {
                console.error('更新记录失败', error);
            }
        },

        // 添加记录
        async handleAddRecord() {
            try {
                await bloodDonationApi.add(this.newRecord);
                this.loadData(); // 添加成功后重新加载数据
                this.showAddDialog = false;
            } catch (error) {
                console.error('添加记录失败', error);
            }
        },
    },

    mounted() {
        this.loadData();
    },
};
</script>

<style scoped>
/* 样式 */
.dynamic-table {
    width: 100%;
}

.batch-actions {
    margin-bottom: 20px;
}

.dialog-footer {
    text-align: right;
}</style>


