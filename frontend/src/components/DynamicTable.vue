<template>
    <div>
    <el-table :data="tableData" border style="width: 100%" v-loading="loading">
        <!-- 动态渲染列 -->
        <el-table-column v-for="(column, index) in columns" :key="index" :prop="column.prop" :label="column.label"
            :width="column.width||'auto'" :align="column.align || 'center'">
            <!-- 支持插槽自定义渲染 -->
            <template v-slot="scope">
                <slot :name="column.slot" v-bind="scope">
                    {{ scope.row[column.prop] }}
                </slot>
            </template>
        </el-table-column>

        <!-- 操作列 -->
        <el-table-column v-if="actions.length" label="操作" align="center" width="150">
            <template v-slot="scope">
                <el-button v-for="(action, index) in actions" :key="index" :type="action.type || 'primary'" size="small"
                    @click="() => action.handler(scope.row)">
                    {{ action.label }}
                </el-button>
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
    </div>
</template>

<script>
export default {
    name: "DynamicTable",
    props: {
        columns: {
            type: Array,
            required: true, // 表格列配置 [{ label: '名称', prop: 'name', width: '150px', slot: 'customName' }]
        },
        actions: {
            type: Array,
            default: () => [], // 操作列配置 [{ label: '编辑', handler: () => {}, type: 'success' }]
        },
        data: {
            type: Array,
            default: () => [], // 表格数据
        },
        pagination: {
            type: Object,
            default: null, // 分页配置 { total: 100, pageSize: 10, currentPage: 1 }
        },
        loading: {
            type: Boolean,
            default: false, // 加载状态
        },
    },
    computed: {
        tableData() {
            return this.data;
        },
    },
    methods: {
        handlePageChange(page) {
            this.$emit("page-change", page); // 向父组件传递页码变更事件
        },
        
        handleSizeChange(size) {
            this.$emit("size-change", size); // 向父组件传递分页大小变化事件
        },
        
    },
};
</script>

<style scoped></style>
