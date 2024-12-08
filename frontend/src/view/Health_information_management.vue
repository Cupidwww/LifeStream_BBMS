<template>
    <div>
        <h1>Health Information Management</h1>

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
    <!-- 添加数据弹窗 -->
    <el-dialog v-model="showAddDialog" title="Add Health Record">
        <el-form :model="newRecord" label-width="100px">
            <el-form-item label="Donor ID" :rules="[{ required: true, message: 'Donor ID is required', trigger: 'blur' }]">
                <el-input v-model="newRecord.donorID" type="number" />
            </el-form-item>
        
            <el-form-item label="Blood Type" :rules="[{ required: true, message: 'Blood Type is required', trigger: 'blur' }]">
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

            <el-form-item label="Gender" :rules="[{ required: true, message: 'Gender is required', trigger: 'blur' }]">
                <el-select v-model="newRecord.gender" placeholder="Select Gender">
                    <el-option label="Male" value="Male" />
                    <el-option label="Female" value="Female" />
                </el-select>
            </el-form-item>

            <el-form-item label="Height" :rules="[{ required: true, message: 'Height is required', trigger: 'blur' }]">
                <el-input v-model="newRecord.height" type="number" />
            </el-form-item>

            <el-form-item label="Weight" :rules="[{ required: true, message: 'Weight is required', trigger: 'blur' }]">
                <el-input v-model="newRecord.weight" type="number" />
            </el-form-item>

            <el-form-item label="Hepatitis B" :rules="[{ required: true, message: 'Hepatitis B status is required', trigger: 'blur' }]">
                <el-select v-model="newRecord.hepatitisB" placeholder="Select Hepatitis B Status">
                    <el-option label="Yes" value="yes" />
                    <el-option label="No" value="no" />
                </el-select>
            </el-form-item>

            <el-form-item label="HIV" :rules="[{ required: true, message: 'HIV status is required', trigger: 'blur' }]">
                <el-select v-model="newRecord.hiv" placeholder="Select HIV Status">
                    <el-option label="Yes" value="yes" />
                    <el-option label="No" value="no" />
                </el-select>
            </el-form-item>

            <el-form-item label="Syphilis" :rules="[{ required: true, message: 'Syphilis status is required', trigger: 'blur' }]">
                <el-select v-model="newRecord.syphilis" placeholder="Select Syphilis Status">
                    <el-option label="Yes" value="yes" />
                    <el-option label="No" value="no" />
                </el-select>
            </el-form-item>

            <el-form-item label="Physical Exam Result" :rules="[{ required: true, message: 'Physical Exam Result is required', trigger: 'blur' }]">
                <el-select v-model="newRecord.physicalExamResult" placeholder="Select Exam Result">
                    <el-option label="Good" value="good" />
                    <el-option label="Average" value="average" />
                    <el-option label="Poor" value="poor" />
                </el-select>
            </el-form-item>

            <el-form-item label="Physical Exam Time" :rules="[{ required: true, message: 'Physical Exam Time is required', trigger: 'blur' }]">
                <el-date-picker v-model="newRecord.physicalExamTime" type="datetime" placeholder="Select Date and Time" />
            </el-form-item>

            <el-form-item label="Test Result">
                <el-input v-model="newRecord.testResult" />
            </el-form-item>

            <el-form-item label="Test Time" :rules="[{ required: true, message: 'Test Time is required', trigger: 'blur' }]">
                <el-date-picker v-model="newRecord.testTime" type="datetime" placeholder="Select Test Date and Time" />
            </el-form-item>

            <el-form-item label="Test Tube Number" :rules="[{ required: true, message: 'Test Tube Number is required', trigger: 'blur' }]">
                <el-input v-model="newRecord.testTubeNumber" />
            </el-form-item>

            <el-form-item label="Staff ID" :rules="[{ required: true, message: 'Staff ID is required', trigger: 'blur' }]">
                <el-input v-model="newRecord.staffID" type="number" />
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
    <el-dialog v-model="showEditDialog" title="Edit Health Record">
        <el-form :model="editRecord" label-width="100px">
            <el-form-item label="Donor ID" :rules="[{ required: true, message: 'Donor ID is required', trigger: 'blur' }]">
                <el-input v-model="editRecord.donorID" type="number" />
            </el-form-item>

            <el-form-item label="Blood Type" :rules="[{ required: true, message: 'Blood Type is required', trigger: 'blur' }]">
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

            <el-form-item label="Gender" :rules="[{ required: true, message: 'Gender is required', trigger: 'blur' }]">
                <el-select v-model="editRecord.gender" placeholder="Select Gender">
                    <el-option label="Male" value="Male" />
                    <el-option label="Female" value="Female" />
                </el-select>
            </el-form-item>

            <el-form-item label="Height" :rules="[{ required: true, message: 'Height is required', trigger: 'blur' }]">
                <el-input v-model="editRecord.height" type="number" />
            </el-form-item>

            <el-form-item label="Weight" :rules="[{ required: true, message: 'Weight is required', trigger: 'blur' }]">
                <el-input v-model="editRecord.weight" type="number" />
            </el-form-item>

            <el-form-item label="Hepatitis B" :rules="[{ required: true, message: 'Hepatitis B status is required', trigger: 'blur' }]">
                <el-select v-model="editRecord.hepatitisB" placeholder="Select Hepatitis B Status">
                    <el-option label="Yes" value="yes" />
                    <el-option label="No" value="no" />
                </el-select>
            </el-form-item>

            <el-form-item label="HIV" :rules="[{ required: true, message: 'HIV status is required', trigger: 'blur' }]">
                <el-select v-model="editRecord.hiv" placeholder="Select HIV Status">
                    <el-option label="Yes" value="yes" />
                    <el-option label="No" value="no" />
                </el-select>
            </el-form-item>

            <el-form-item label="Syphilis" :rules="[{ required: true, message: 'Syphilis status is required', trigger: 'blur' }]">
                <el-select v-model="editRecord.syphilis" placeholder="Select Syphilis Status">
                    <el-option label="Yes" value="yes" />
                    <el-option label="No" value="no" />
                </el-select>
            </el-form-item>

            <el-form-item label="Physical Exam Result" :rules="[{ required: true, message: 'Physical Exam Result is required', trigger: 'blur' }]">
                <el-select v-model="editRecord.physicalExamResult" placeholder="Select Exam Result">
                    <el-option label="Good" value="good" />
                    <el-option label="Average" value="average" />
                    <el-option label="Poor" value="poor" />
                </el-select>
            </el-form-item>

            <el-form-item label="Physical Exam Time" :rules="[{ required: true, message: 'Physical Exam Time is required', trigger: 'blur' }]">
                <el-date-picker v-model="editRecord.physicalExamTime" type="datetime" placeholder="Select Date and Time" />
            </el-form-item>

            <el-form-item label="Test Result">
                <el-input v-model="editRecord.testResult" />
            </el-form-item>

            <el-form-item label="Test Time" :rules="[{ required: true, message: 'Test Time is required', trigger: 'blur' }]">
                <el-date-picker v-model="editRecord.testTime" type="datetime" placeholder="Select Test Date and Time" />
            </el-form-item>

            <el-form-item label="Test Tube Number" :rules="[{ required: true, message: 'Test Tube Number is required', trigger: 'blur' }]">
                <el-input v-model="editRecord.testTubeNumber" />
            </el-form-item>

            <el-form-item label="Staff ID" :rules="[{ required: true, message: 'Staff ID is required', trigger: 'blur' }]">
                <el-input v-model="editRecord.staffID" type="number" />
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
import healthApi from '@/api/HealthManagamentapi.js';

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
                donorID: null,          // 捐献者ID
                bloodType: "",          // 血型
                gender: "",             // 性别
                height: "",             // 身高
                weight: "",             // 体重
                hepatitisB: "no",         // 是否患有乙型肝炎
                hiv: "no",                // 是否感染HIV
                syphilis: "no",           // 是否感染梅毒
                physicalExamResult: "good", // 体检结果
                physicalExamTime: "2024-12-08 10:00:00",   // 体检时间
                testResult: "good",       // 检测结果
                testTime: "2024-12-08 10:00:00",           // 检测时间
                testTubeNumber: "",     // 试管编号
                staffID: null           // 工作人员ID
            },

            // 编辑记录数据
            editRecord: {
                id: null,               // 记录ID
                donorID: null,          // 捐献者ID
                bloodType: "",          // 血型
                gender: "",             // 性别
                height: "",             // 身高
                weight: "",             // 体重
                hepatitisB: "",         // 是否患有乙型肝炎
                hiv: "",                // 是否感染HIV
                syphilis: "",           // 是否感染梅毒
                physicalExamResult: "", // 体检结果
                physicalExamTime: "",   // 体检时间
                testResult: null,       // 检测结果
                testTime: "",           // 检测时间
                testTubeNumber: "",     // 试管编号
                staffID: null           // 工作人员ID
            },

        };
    },
    methods: {
        // 加载数据
        async loadData() {
            this.loading = true;
            try {
                const response = await healthApi.getPage({
                    page: this.pagination.currentPage,
                    pageSize: this.pagination.pageSize,
                });
                console.log('Health records:', response.data);
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
                await healthApi.delete(ids);
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
                await healthApi.update(this.editRecord);

                this.showEditDialog = false;
                this.loadData(); // 刷新数据
            } catch (error) {
                console.error("更新记录失败", error);
            }
        },

        // 添加记录
        async handleAddRecord() {
            // 确保数字字段是正确类型
            if (this.newRecord.donorID !== null) {
                this.newRecord.donorID = Number(this.newRecord.donorID);
            }
            if (this.newRecord.staffID !== null) {
                this.newRecord.staffID = Number(this.newRecord.staffID);
            }
            
            try {
                console.log("插入记录:", this.newRecord);
                await healthApi.add(this.newRecord);
                this.showAddDialog = false;
                this.loadData(); // 刷新数据
            } catch (error) {
                console.error("插入记录失败", error);
            }
        },
    },

    created() {
        this.loadData();
    },
};
</script>

