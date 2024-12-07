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
    data() {
        return {
            columns: [],
            data: [],
            total: 0,
        };
    },
    methods: {
        async fetchBloodRecords(page, size) {
            console.log("请求发送中...", { page, size });  // 打印请求参数

            try {
                const response = await axios.get("https://jsonplaceholder.typicode.com/users", {
                    params: { page, size },
                });

                console.log("请求成功，响应数据：", response.data);  // 打印返回的数据

                return {
                    columns: response.data.columns,  // 动态表头
                    data: response.data.data,        // 表格数据
                    total: response.data.total,      // 总记录数
                };
            } catch (error) {
                console.error("请求失败，错误信息：", error);  // 打印错误信息
                return {
                    columns: [],
                    data: [],
                    total: 0,
                };
            }
        },
    },
    mounted() {
        // 调用 fetchBloodRecords 方法，触发请求
        console.log("组件已加载，开始发送请求...");
        this.fetchBloodRecords(1, 10);  // 假设每页 10 条数据，当前页为 1
    },
};
</script>
