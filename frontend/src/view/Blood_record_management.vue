<template>
    <div>
        <h1 class="page-title">Blood Donation Record Management</h1>

        <!-- 查询工具栏 -->
        <div v-if="isTableReady" class="search-bar">
            <!-- 查询表单 -->
            <el-form :model="searchQuery" label-width="auto" class="search-form">
                <!-- ID -->
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

                <!-- 血袋编号 -->
                <el-form-item label="Blood Bag Number">
                    <el-input v-model="searchQuery.bloodBagNumber" placeholder="Enter Blood Bag Number" />
                </el-form-item>

                <!-- 是否合格 -->
                <el-form-item label="Is Qualified">
                    <el-select v-model="searchQuery.isQualified" placeholder="Select Qualification Status">
                        <el-option label="Yes" value="Yes" />
                        <el-option label="No" value="No" />
                    </el-select>
                </el-form-item>

                <!-- 容积 -->
                <el-form-item label="Amount">
                    <el-input v-model="searchQuery.bloodVolume" type="number" placeholder="Enter volume (in increments of 50)" />
                </el-form-item>

                <!-- 登记日期 -->
                <el-form-item label="Registration Date">
                    <el-date-picker v-model="searchQuery.registrationDate" type="date" placeholder="Choose Date" />
                </el-form-item>

                <!-- 献血者ID -->
                <el-form-item label="Donor ID">
                    <el-input v-model="searchQuery.donorID" placeholder="Enter Donor ID" />
                </el-form-item>

                <!-- 工作人员ID -->
                <el-form-item label="Staff ID">
                    <el-input v-model="searchQuery.staffID" placeholder="Enter Staff ID" />
                </el-form-item>

                <!-- 查询按钮 -->
                <el-form-item>
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
            <el-table-column label="operation" align="center" min-width="120">
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

                <!-- 血液类别 -->
                <el-form-item label="Blood Category" class="dialog-label" :rules="[{ required: true, message: 'Blood Category is required', trigger: 'blur' }]">
                    <el-select v-model="newRecord.bloodCategory" placeholder="Select Blood Category">
                        <el-option label="Whole Blood" value="Whole Blood" />
                        <el-option label="Plasma" value="Plasma" />
                        <el-option label="White Blood Cells" value="White Blood Cells" />
                        <el-option label="Red Blood Cells" value="Red Blood Cells" />
                        <el-option label="Platelets" value="Platelets" />
                    </el-select>
                </el-form-item>

                <!-- 血袋编号 -->
                <el-form-item label="Blood Bag Number" class="dialog-label" :rules="[{ required: true, message: 'Blood Bag Number is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.bloodBagNumber" placeholder="Enter Blood Bag Number" />
                </el-form-item>

                <!-- 是否合格 -->
                <el-form-item label="Is Qualified" class="dialog-label" :rules="[{ required: true, message: 'Is Qualified is required', trigger: 'blur' }]">
                    <el-select v-model="newRecord.isQualified" placeholder="Select Qualification Status">
                        <el-option label="Yes" value="Yes" />
                        <el-option label="No" value="No" />
                    </el-select>
                </el-form-item>

                <!-- 容积 -->
                <el-form-item label="Amount" class="dialog-label" :rules="[{ required: true, message: 'Blood Volume is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.bloodVolume" type="number" placeholder="Enter volume (in increments of 50)" />
                </el-form-item>

                <!-- 登记日期 -->
                <el-form-item label="Registration Date" class="dialog-label" :rules="[{ required: true, message: 'Registration Date is required', trigger: 'change' }]">
                    <el-date-picker v-model="newRecord.registrationDate" type="date" placeholder="Choose Date" />
                </el-form-item>

                <!-- 献血者ID -->
                <el-form-item label="Donor ID" class="dialog-label" :rules="[{ required: true, message: 'Donor ID is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.donorID" placeholder="Enter Donor ID" />
                </el-form-item>

                <!-- 工作人员ID -->
                <el-form-item label="Staff ID" class="dialog-label" :rules="[{ required: true, message: 'Staff ID is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.staffID" placeholder="Enter Staff ID" />
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
                <!-- 血型 -->
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

                <!-- 血液类别 -->
                <el-form-item label="Blood Category" class="dialog-label" :rules="[{ required: true, message: 'Blood Category is required', trigger: 'blur' }]">
                    <el-select v-model="editRecord.bloodCategory" placeholder="Select Blood Category">
                        <el-option label="Whole Blood" value="Whole Blood" />
                        <el-option label="Plasma" value="Plasma" />
                        <el-option label="White Blood Cells" value="White Blood Cells" />
                        <el-option label="Red Blood Cells" value="Red Blood Cells" />
                        <el-option label="Platelets" value="Platelets" />
                    </el-select>
                </el-form-item>

                <!-- 血袋编号 -->
                <el-form-item label="Blood Bag Number" class="dialog-label" :rules="[{ required: true, message: 'Blood Bag Number is required', trigger: 'blur' }]">
                    <el-input v-model="editRecord.bloodBagNumber" placeholder="Enter Blood Bag Number" />
                </el-form-item>

                <!-- 是否合格 -->
                <el-form-item label="Is Qualified" class="dialog-label" :rules="[{ required: true, message: 'Is Qualified is required', trigger: 'blur' }]">
                    <el-select v-model="editRecord.isQualified" placeholder="Select Qualification Status">
                        <el-option label="Yes" value="Yes" />
                        <el-option label="No" value="No" />
                    </el-select>
                </el-form-item>

                <!-- 容积 -->
                <el-form-item label="Amount" class="dialog-label" :rules="[{ required: true, message: 'Blood Volume is required', trigger: 'blur' }]">
                    <el-input v-model="editRecord.bloodVolume" type="number" placeholder="Enter volume (in increments of 50)" />
                </el-form-item>

                <!-- 登记日期 -->
                <el-form-item label="Registration Date" class="dialog-label" :rules="[{ required: true, message: 'Registration Date is required', trigger: 'change' }]">
                    <el-date-picker v-model="editRecord.registrationDate" type="date" placeholder="Choose Date" />
                </el-form-item>

                <!-- 献血者ID -->
                <el-form-item label="Donor ID" class="dialog-label" :rules="[{ required: true, message: 'Donor ID is required', trigger: 'blur' }]">
                    <el-input v-model="editRecord.donorID" placeholder="Enter Donor ID" />
                </el-form-item>

                <!-- 工作人员ID -->
                <el-form-item label="Staff ID" class="dialog-label" :rules="[{ required: true, message: 'Staff ID is required', trigger: 'blur' }]">
                    <el-input v-model="editRecord.staffID" placeholder="Enter Staff ID" />
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
import dayjs from 'dayjs';
import '@/assets/css/global.css';

export default {
    data() {
        return {
            isTableReady: false,  // 控制表格的显示
            loading: false,
            tableData: [],
            selectedRows: [],  // 存储选中的数据
            searchQuery: {
                id: null,
                bloodType: "",
                bloodCategory: "",
                bloodBagNumber: null,
                isQualified:"",
                bloodVolume: "",
                registrationDate: "",
                donorID: null,
                staffID: null,
            },  // 用于存储查询条件

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
                id: null,
                bloodType: "",
                bloodCategory: "",
                bloodBagNumber: null,
                isQualified:"",
                bloodVolume: "",
                registrationDate: "",
                donorID: null,
                staffID: null,
            },
            // 编辑记录数据
            editRecord: {
                id: null,
                bloodType: "",
                bloodCategory: "",
                bloodBagNumber: null,
                isQualified:"",
                bloodVolume: "",
                registrationDate: "",
                donorID: null,
                staffID: null,
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

        // 时间格式化
        formatDate(date) {
            return dayjs(date).format('YYYY-MM-DD HH:mm:ss');
        },

        // 更新记录
        async handleUpdateRecord() {
            try {
                this.editRecord.registrationDate = this.formatDate(this.editRecord.registrationDate);
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
                this.newRecord.registrationDate = this.formatDate(this.newRecord.registrationDate);
                await bloodDonationApi.add(this.newRecord);
                this.loadData(); // 添加成功后重新加载数据
                this.showAddDialog = false;
            } catch (error) {
                console.error('添加记录失败', error);
            }
        },

                // 查询
        async handleSearch() {
            this.pagination.currentPage = 1; // 重置分页到第一页
            this.loading = true;
            try {
                if (this.searchQuery.registrationDate) {
                    this.searchQuery.registrationDate = this.formatDate(this.searchQuery.transactionDate);
                }
                const response = await bloodDonationApi.getFullList(this.searchQuery);
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
                bloodBagNumber: null,
                isQualified:"",
                bloodVolume: "",
                registrationDate: "",
                donorID: null,
                staffID: null,
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


