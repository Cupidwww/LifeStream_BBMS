<template>
    <div>
        <h1 class="page-title">User Management</h1>

        <!-- 查询工具栏 -->
        <div v-if="isTableReady" class="search-bar">
            <!-- 查询表单 -->
            <el-form :model="searchQuery" label-width="auto" class="search-form">
                <!-- ID -->
                <el-form-item label="ID">
                    <el-input v-model="searchQuery.id" type="number" placeholder="Enter ID" />
                </el-form-item>

                <!-- 用户名 -->
                <el-form-item label="Username">
                    <el-input v-model="searchQuery.username" placeholder="Enter Username" />
                </el-form-item>

                <!-- 角色 -->
                <el-form-item label="Role" prop="role">
                <el-select v-model="searchQuery.role" placeholder="Select Role">
                    <el-option label="ADMIN" value="ADMIN" />
                    <el-option label="DONOR" value="DONOR" />
                    <el-option label="EMPLOYEE" value="EMPLOYEE" />
                </el-select>
                </el-form-item>

                <!-- 员工编号 -->
                <el-form-item label="Employee Number">
                    <el-input v-model="searchQuery.employeeNumber" type="number" placeholder="Enter Employee Number" />
                </el-form-item>

                <!-- 姓名 -->
                <el-form-item label="Name">
                    <el-input v-model="searchQuery.name" placeholder="Enter Name" />
                </el-form-item>

                <!-- 性别 -->
                <el-form-item label="Gender">
                    <el-select v-model="searchQuery.gender" placeholder="Select Gender">
                        <el-option label="Male" value="Male" />
                        <el-option label="Female" value="Female" />
                    </el-select>
                </el-form-item>

                <!-- 年龄 -->
                <el-form-item label="Age">
                    <el-input v-model="searchQuery.age" type="number" placeholder="Enter Age" />
                </el-form-item>

                <!-- 电话 -->
                <el-form-item label="Phone">
                    <el-input v-model="searchQuery.phone" placeholder="Enter Phone" />
                </el-form-item>

                <!-- 邮箱 -->
                <el-form-item label="Email">
                    <el-input v-model="searchQuery.email" placeholder="Enter Email" />
                </el-form-item>

                <!-- 身份证号 -->
                <el-form-item label="ID Card">
                    <el-input v-model="searchQuery.idCard" placeholder="Enter ID Card" />
                </el-form-item>

                <!-- 家庭地址 -->
                <el-form-item label="Home Address">
                    <el-input v-model="searchQuery.homeAddress" placeholder="Enter Home Address" />
                </el-form-item>

                <!-- 查询按钮 -->
                <el-form-item class="center-buttons">
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
        <el-dialog v-model="showAddDialog" title="添加用户记录" 
                class="dialog-box"
                :draggable="true" 
                :modal="true" 
                :close-on-click-modal="false">
            <el-form :model="newRecord" label-width="auto">
                <!-- 用户名 -->
                <el-form-item label="Username" class="dialog-label" :rules="[{ required: true, message: 'Username is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.username" placeholder="Enter Username" />
                </el-form-item>

                <!-- 密码 -->
                <el-form-item label="Password" class="dialog-label" :rules="[{ required: true, message: 'Password is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.password" placeholder="Enter Password" />
                </el-form-item>

                <!-- 角色 -->
                <el-form-item label="Role" class="dialog-label" :rules="[{ required: true, message: 'Role is required', trigger: 'blur' }]">
                    <el-select v-model="newRecord.role" placeholder="Select Role">
                        <el-option label="ADMIN" value="ADMIN" />
                        <el-option label="DONOR" value="DONOR" />
                        <el-option label="EMPLOYEE" value="EMPLOYEE" />
                    </el-select>
                </el-form-item>

                <!-- 员工编号 -->
                <el-form-item label="Employee Number" class="dialog-label">
                    <el-input v-model="newRecord.employeeNumber" type="number" placeholder="Enter Employee Number" />
                </el-form-item>

                <!-- 姓名 -->
                <el-form-item label="Name" class="dialog-label" :rules="[{ required: true, message: 'Name is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.name" placeholder="Enter Name" />
                </el-form-item>

                <!-- 性别 -->
                <el-form-item label="Gender" class="dialog-label" :rules="[{ required: true, message: 'Gender is required', trigger: 'blur' }]">
                    <el-select v-model="newRecord.gender" placeholder="Select Gender">
                        <el-option label="Male" value="Male" />
                        <el-option label="Female" value="Female" />
                    </el-select>
                </el-form-item>

                <!-- 年龄 -->
                <el-form-item label="Age" class="dialog-label">
                    <el-input v-model="newRecord.age" type="number" placeholder="Enter Age" />
                </el-form-item>

                <!-- 电话 -->
                <el-form-item label="Phone" class="dialog-label" :rules="[{ required: true, message: 'Phone is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.phone" placeholder="Enter Phone" />
                </el-form-item>

                <!-- 邮箱 -->
                <el-form-item label="Email" class="dialog-label" :rules="[{ required: true, message: 'Email is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.email" placeholder="Enter Email" />
                </el-form-item>

                <!-- 身份证号 -->
                <el-form-item label="ID Card" class="dialog-label" :rules="[{ required: true, message: 'ID Card is required', trigger: 'blur' }]">
                    <el-input v-model="newRecord.idCard" placeholder="Enter ID Card" />
                </el-form-item>

                <!-- 家庭地址 -->
                <el-form-item label="Home Address" class="dialog-label">
                    <el-input v-model="newRecord.homeAddress" placeholder="Enter Home Address" />
                </el-form-item>

                <!-- 头像 -->
                <el-form-item label="Avatar" class="dialog-label">
                    <el-input v-model="newRecord.avatar" placeholder="Enter Avatar URL" />
                </el-form-item>

                <!-- 添加时间 -->
                <el-form-item label="Add Time" class="dialog-label">
                    <el-date-picker v-model="newRecord.addtime" type="datetime" placeholder="Choose Add Time" />
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
        <el-dialog v-model="showEditDialog" title="编辑用户记录" 
                class="dialog-box"
                :draggable="true" 
                :modal="true" 
                :close-on-click-modal="false">
            <el-form :model="editRecord" label-width="auto">
                <!-- 用户名 -->
                <el-form-item label="Username" class="dialog-label" >
                    <el-input v-model="editRecord.username" placeholder="Enter Username" />
                </el-form-item>

                <!-- 密码 -->
                <el-form-item label="Password" class="dialog-label" >
                    <el-input v-model="editRecord.password"  placeholder="Enter Password" />
                </el-form-item>

                <!-- 角色 -->
                <el-form-item label="Role" class="dialog-label">
                    <el-select v-model="editRecord.role" placeholder="Select Role">
                        <el-option label="ADMIN" value="ADMIN" />
                        <el-option label="DONOR" value="DONOR" />
                        <el-option label="EMPLOYEE" value="EMPLOYEE" />
                    </el-select>
                </el-form-item>

                <!-- 员工编号 -->
                <el-form-item label="Employee Number" class="dialog-label">
                    <el-input v-model="editRecord.employeeNumber" type="number" placeholder="Enter Employee Number" />
                </el-form-item>

                <!-- 姓名 -->
                <el-form-item label="Name" class="dialog-label" >
                    <el-input v-model="editRecord.name" placeholder="Enter Name" />
                </el-form-item>

                <!-- 性别 -->
                <el-form-item label="Gender" class="dialog-label">
                    <el-select v-model="editRecord.gender" placeholder="Select Gender">
                        <el-option label="Male" value="Male" />
                        <el-option label="Female" value="Female" />
                    </el-select>
                </el-form-item>

                <!-- 年龄 -->
                <el-form-item label="Age" class="dialog-label">
                    <el-input v-model="editRecord.age" type="number" placeholder="Enter Age" />
                </el-form-item>

                <!-- 电话 -->
                <el-form-item label="Phone" class="dialog-label">
                    <el-input v-model="editRecord.phone" placeholder="Enter Phone" />
                </el-form-item>

                <!-- 邮箱 -->
                <el-form-item label="Email" class="dialog-label">
                    <el-input v-model="editRecord.email" placeholder="Enter Email" />
                </el-form-item>

                <!-- 身份证号 -->
                <el-form-item label="ID Card" class="dialog-label">
                    <el-input v-model="editRecord.idCard" placeholder="Enter ID Card" />
                </el-form-item>

                <!-- 家庭地址 -->
                <el-form-item label="Home Address" class="dialog-label">
                    <el-input v-model="editRecord.homeAddress" placeholder="Enter Home Address" />
                </el-form-item>

                <!-- 头像 -->
                <el-form-item label="Avatar" class="dialog-label">
                    <el-input v-model="editRecord.avatar" placeholder="Enter Avatar URL" />
                </el-form-item>

                <!-- 添加时间 -->
                <el-form-item label="Add Time" class="dialog-label">
                    <el-date-picker v-model="editRecord.addtime" type="datetime" placeholder="Choose Add Time" />
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
import userApi from '@/api/userapi';
import dayjs from 'dayjs';
import '@/assets/css/global.css'

export default {
    data() {
        return {
            isTableReady: false,  // 控制表格的显示
            loading: false,
            tableData: [],
            selectedRows: [],  // 存储选中的数据
            searchQuery: {
                id: null,
                username: "",
                password: "",
                role: "",
                employeeNumber: null,
                name: "",
                gender: "",
                age: null,
                phone: "",
                email: "",
                idCard: "",                
                homeAddress: "",
                avatar: "",
            },
            // 定义验证规则
            rules: {
                role: [
                { required: true, message: 'Please select a role', trigger: 'change' }
                ]
            },
            // 用于存储查询条件

            // 分页
            pagination: {
                total: 0,
                currentPage: 1,
                pageSize: 10,
            },

            showAddDialog: false,  // 控制添加数据弹窗的显示
            showEditDialog: false,  // 控制编辑数据弹窗的显示

            newRecord: {
                id: null,
                username: "",
                password: "",
                role: "",
                employeeNumber: null,
                name: "",
                gender: "",
                age: null,
                phone: "",
                email: "",
                idCard: "",                
                homeAddress: "",
                avatar: "",
                addtime: "",
            },

            editRecord: {
                id: null,
                username: "",
                password: "",
                role: "",
                employeeNumber: null,
                name: "",
                gender: "",
                age: null,
                phone: "",
                email: "",
                idCard: "",                
                homeAddress: "",
                avatar: "",
                addtime: "",
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
                const response = await userApi.getPage(params);
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

        // 编辑记录行数据复制
        async handleEdit(row) {
            this.editRecord = { ...row }; // 复制当前行数据到编辑数据模型
            this.showEditDialog = true;
        },

        // 更新记录
        async handleUpdateRecord() {
            console.log("更新记录成功:", this.editRecord);
            try {
                if (this.editRecord.addtime) {
                this.editRecord.addtime = this.formatDate(this.editRecord.addtime);
                }
                await userApi.updateUser(this.editRecord);
                this.showEditDialog = false;
                this.loadData(); //刷新数据
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
                if (this.newRecord.addtime) {
                this.newRecord.addtime = this.formatDate(this.newRecord.addtime);
                }
                console.log("插入记录:", this.newRecord);
                await userApi.addUser(this.newRecord);
                this.showAddDialog = false;
                this.loadData();
            } catch (error) {
                console.error("插入记录失败，错误信息：", error);
            }
        },

        // 查询
        async handleSearch() {
            this.pagination.total = 1; // 重置分页到第一页
            this.pagination.currentPage = 1; // 重置分页到第一页
            this.loading = true;
            try {
                if (this.searchQuery.role === "") {
                    this.$message.error('Please select a role');
                    return;
                }
                if (this.searchQuery.addtime) {
                    this.searchQuery.addtime = this.formatDate(this.searchQuery.addtime);
                }
                const response = await userApi.getUserList(this.searchQuery);
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
                username: "",
                password: "",
                role: "",
                employeeNumber: null,
                name: "",
                gender: "",
                age: null,
                phone: "",
                email: "",
                idCard: "",                
                homeAddress: "",
                avatar: "",
            };
            this.loading = true;
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
}

</script>
