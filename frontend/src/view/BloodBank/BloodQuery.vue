<template>
    <div>
        <h1 class="page-title">Blood Record Management</h1>

        <!-- 查询工具栏 -->
        <div v-if="isTableReady" class="search-bar">
            <!-- 查询表单 -->
            <el-form :model="searchQuery" label-width="auto" class="search-form">
                <!-- id -->
                <el-form-item label="ID">
                    <el-input v-model="searchQuery.id" placeholder="Enter ID" />
                </el-form-item>

                <!-- 血型 -->
                <el-form-item label="Blood Type">
                    <el-select v-model="searchQuery.bloodType" placeholder="Select Blood Type">
                        <el-option label="A+" value="A+" />
                        <el-option label="A-" value="A-" />
                        <el-option label="B+" value="B+" />
                        <el-option label="B-" value="B-" />
                        <el-option label="O+" value="O+" />
                        <el-option label="O-" value="O-" />
                        <el-option label="AB+" value="AB+" />
                        <el-option label="AB-" value="AB-" />
                    </el-select>
                </el-form-item>

                <!-- 血液类别 -->
                <el-form-item label="Blood Category">
                    <el-select v-model="searchQuery.bloodCategory" placeholder="Select Blood Category">
                        <el-option label="Whole Blood" value="Whole Blood" />
                        <el-option label="Plasma" value="Plasma" />
                        <el-option label="White Blood Cells" value="White Blood Cells" />
                        <el-option label="Red Blood Cells" value="Red Blood Cells" />
                        <el-option label="Platelets" value="Platelets" />
                    </el-select>
                </el-form-item>

                <!-- 容积 -->
                <el-form-item label="Amount">
                    <el-input v-model="searchQuery.bloodVolume" type="number" placeholder="Enter volume (in increments of 50)" />
                </el-form-item>

                <!-- 日期 -->
                <el-form-item label="Date">
                    <el-date-picker v-model="searchQuery.transactionDate" type="date" placeholder="Choose Date" />
                </el-form-item>

                <!-- 血源ID -->
                <el-form-item label="BloodDonationID">
                    <el-input v-model="searchQuery.bloodDonationID" placeholder="Enter Blood Donation ID" />
                </el-form-item>

                <!-- 备注 -->
                <el-form-item label="Remarks">
                    <el-input v-model="searchQuery.remarks" placeholder="Enter Remarks" />
                </el-form-item>

                <!-- 查询按钮 -->
                <el-form-item class="search-buttons"> 
                    <!-- 想让这两个按钮居中，无果 -->
                    <el-button type="primary" @click="handleSearch">Search</el-button>
                    <el-button @click="resetSearchForm">Reset</el-button>
                </el-form-item>
            </el-form>
        </div>

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
            <el-table-column label="operation" align="center" min-width="100">
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
        <el-dialog v-model="showAddDialog" title="添加血液记录" 
        class="dialog-box"
        :draggable="true" 
        :modal="true" 
        :close-on-click-modal="false">
            <el-form :model="newRecord" label-width="auto">
                <!-- 血型 -->
                <el-form-item label="Blood Type" class="dialog-label" :rules="[{ required: true, message: 'Blood Type is required', trigger: 'blur' }]">
                    <el-select v-model="newRecord.bloodType" placeholder="Select Blood Type">
                        <el-option label="A+" value="A+" />
                        <el-option label="A-" value="A-" />
                        <el-option label="B+" value="B+" />
                        <el-option label="B-" value="B-" />
                        <el-option label="O+" value="O+" />
                        <el-option label="O-" value="O-" />
                        <el-option label="AB+" value="AB+" />
                        <el-option label="AB-" value="AB-" />
                    </el-select>
                </el-form-item>
                <!-- 类别 -->
                <el-form-item label="Category" class="dialog-label" :rules="[{ required: true, message: 'Blood Category is required', trigger: 'blur' }]">
                    <el-select v-model="newRecord.bloodCategory" placeholder="Select Blood Type">
                        <el-option label="Whole Blood" value="Whole Blood" />
                        <el-option label="Plasma" value="Plasma" />
                        <el-option label="White Blood Cells" value="White Blood Cells" />
                        <el-option label="Red Blood Cells" value="Red Blood Cells" />
                        <el-option label="Platelets" value="Platelets" />
                    </el-select>
                </el-form-item>
                <!-- 容积 -->
                <el-form-item label="Amount" class="dialog-label" :rules="[{ required: true, message: 'Blood Volume is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.bloodVolume" type="number" />
                </el-form-item>
                <!-- 日期 -->
                <el-form-item label="Date" class="dialog-label" :rules="[{ required: true, message: 'Transaction Date is required', trigger: 'change' }]">
                    <el-date-picker v-model="newRecord.transactionDate" type="date" placeholder="Choose Date" />
                </el-form-item>
                <!-- 血源 -->
                <el-form-item label="BloodDonationID" class="dialog-label" :rules="[{ required: true, message: 'Blood Donor ID is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.bloodDonationID" />
                </el-form-item>
                <!-- 备注 -->
                <el-form-item class="dialog-label" label="Remarks">
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
        <el-dialog v-model="showEditDialog" title="编辑血液记录" 
        class="dialog-box"
        :draggable="true" 
        :modal="true" 
        :close-on-click-modal="false">
            <el-form :model="editRecord" label-width="auto">
                <el-form-item label="Blood Type" class="dialog-label" :rules="[{ required: true, message: 'Blood Type is required', trigger: 'blur' }]">
                    <el-select v-model="editRecord.bloodType" placeholder="Select Blood Type">
                        <el-option label="A+" value="A+" />
                        <el-option label="A-" value="A-" />
                        <el-option label="B+" value="B+" />
                        <el-option label="B-" value="B-" />
                        <el-option label="O+" value="O+" />
                        <el-option label="O-" value="O-" />
                        <el-option label="AB+" value="AB+" />
                        <el-option label="AB-" value="AB-" />
                    </el-select>
                </el-form-item>
                <el-form-item label="Category" class="dialog-label" :rules="[{ required: true, message: 'Blood Category is required', trigger: 'blur' }]">
                    <el-select v-model="editRecord.bloodCategory" placeholder="Select Blood Type">
                        <el-option label="Whole Blood" value="Whole Blood" />
                        <el-option label="Plasma" value="Plasma" />
                        <el-option label="White Blood Cells" value="White Blood Cells" />
                        <el-option label="Red Blood Cells" value="Red Blood Cells" />
                        <el-option label="Platelets" value="Platelets" />
                    </el-select>
                </el-form-item>
                <el-form-item label="Amount" class="dialog-label" :rules="[{ required: true, message: 'Blood Volume is required', trigger: 'blur' }]">
                    <el-input v-model="editRecord.bloodVolume" type="number" />
                </el-form-item>
                <el-form-item label="Date" class="dialog-label" :rules="[{ required: true, message: 'Transaction Date is required', trigger: 'change' }]">
                    <el-date-picker v-model="editRecord.transactionDate" type="date" placeholder="Choose Date" />
                </el-form-item>
                <el-form-item label="BloodDonationID" class="dialog-label" :rules="[{ required: true, message: 'Blood Donor ID is required', trigger: 'blur' }]">
                    <el-input v-model="editRecord.bloodDonationID" />
                </el-form-item>
                <el-form-item class="dialog-label" label="Remarks">
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
import dayjs from 'dayjs';
import '@/assets/css/global.css';

export default {
    data() {
        return {
            isTableReady: false,  // 控制表格的显示
            loading: false,
            tableData: [],
            selectedRows: [],  // 存储选中的数据
            // 分页
            pagination: {
                total: 0,
                currentPage: 1,
                pageSize: 10,
            },
            // 查询条件
            searchQuery: {
                id: null,
                bloodType: "",
                bloodCategory: "",
                bloodVolume: null,
                // transactionDate: "", // 日期格式为 YYYY-MM-DD-HH-mm-ss, 做不到所以算了
                bloodDonationID: null,
                remarks: "",
            },
            showAddDialog: false,  // 控制添加数据弹窗的显示
            showEditDialog: false,  // 控制编辑数据弹窗的显示
            // 新增记录数据
            newRecord: {
                bloodType: "",
                bloodCategory: "",
                bloodVolume: null,
                transactionDate: "",
                bloodDonationID: null,
                remarks: "",
                addtime: ""
            },
            // 编辑记录数据
            editRecord: {
                id: null,
                bloodType: "",
                bloodCategory: "",
                bloodVolume: null,
                transactionDate: null,
                bloodDonationID: null,
                remarks: "",
            },
        };
    },
    methods: {
        // 加载数据
        async loadData() {
            this.loading = true;
            try {
                // const bloodBank = this.searchQuery;
                // 合并分页参数和 bloodBank 对象
                const requestParams = {
                    page: this.pagination.currentPage,
                    pageSize: this.pagination.pageSize,
                    // ...bloodBank
                };
                console.log('请求参数:', requestParams);
                const response = await bloodBankApi.getPage(requestParams);
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

        // 批量删除选框
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

        // 编辑记录行数据复制
        async handleEdit(row) {
            this.editRecord = { ...row }; // 复制当前行数据到编辑数据模型
            this.showEditDialog = true;
        },

        // 更新记录
        async handleUpdateRecord() {
            console.log("更新记录成功:", this.editRecord);
            try {
                this.editRecord.transactionDate = this.formatDate(this.editRecord.transactionDate);
                await bloodBankApi.update(this.editRecord);
                this.showEditDialog = false;
                this.loadData(); // 刷新数据
            } catch (error) {
                console.error("更新记录失败", error);
            }
        },

        // 时间格式化
        formatDate(date) {
            return dayjs(date).format('YYYY-MM-DD HH:mm:ss');
        },

        // 添加记录
        async handleAddRecord() {
            try {
                console.log("插入记录:", this.newRecord);
                this.newRecord.transactionDate = this.formatDate(this.newRecord.transactionDate);
                await bloodBankApi.add(this.newRecord);
                this.showAddDialog = false;
                this.loadData();
            } catch (error) {
                console.error("插入记录失败，错误信息：", error);
            }
        },

        // 查询
        async handleSearch() {
            this.pagination.currentPage = 1; // 重置分页到第一页
            this.loading = true;
            try {
                if (this.searchQuery.transactionDate) {
                    this.searchQuery.transactionDate = this.formatDate(this.searchQuery.transactionDate);
                }
                const response = await bloodBankApi.getUserList(this.searchQuery);
                console.log('查询结果:', response.data.data);
                this.tableData = response.data.data;
                // this.pagination.total = response.data;
                this.isTableReady = true;
                console.log('查询结果:', response);
            } catch (error) {
                console.error('查询失败', error);
            } finally {
                this.loading = false;
            }
        },

        // 重置查询条件
        resetSearchForm() {
            this.searchQuery = {
                id: null,
                bloodType: "",
                bloodCategory: "",
                bloodVolume: null,
                transactionDate: "",
                bloodDonationID: null,
                remarks: "",
            };
            this.loadings = true;
            try {
                this.loadData();
                this.$message.success('reset search form success');
            } catch (error) {
                console.error('重置查询条件失败', error);
            } finally {
                this.loading = false;
            } 
        }
    },
    created() {
        this.loadData();
    },
};
</script>

<style scoped>

</style>
