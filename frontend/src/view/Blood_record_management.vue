
<template>
    <div>
        <h1>Blood Record Management</h1>
            <p>This is the blood record management page.</p>
        <dynamic-table :columns="columns" :fetch-data="fetchBloodRecords" />
    </div>
</template>

<script>
import DynamicTable from "@/components/DynamicTable.vue";
import axios from "axios";

export default {
    components: { DynamicTable },
    methods: {
        async fetchBloodRecords(page, size) {
            const response = await axios.get("/api/blood-records", {
                params: { page, size },
            });
            return {
                columns: response.data.columns, // 动态表头
                data: response.data.data,       // 表格数据
                total: response.data.total,     // 总记录数
            };
        },
    },
};
</script>
