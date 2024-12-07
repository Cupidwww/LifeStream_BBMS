<template>
    <div>
        <h1>Blood Records</h1>
        <el-table :data="tableData" style="width: 100%">
            <el-table-column v-for="column in columns" :key="column" :label="column" :prop="column" />
        </el-table>
    </div>
</template>

<script>
import axios from "axios";

export default {
    data() {
        return {
            columns: ['ID', 'Name', 'Username', 'Email'],  // 假设你的表格列是这些
            tableData: [],  // 用于保存表格数据
            total: 0,       // 总记录数
        };
    },
    methods: {
        async fetchBloodRecords(page = 1, size = 10) {
            console.log("请求发送中...", { page, size });  // 打印请求参数

            try {
                // 发送请求获取数据
                const response = await axios.get("https://jsonplaceholder.typicode.com/users", {
                    params: { page, size },
                });

                console.log("请求成功，响应数据：", response.data);  // 打印返回的数据

                // 处理数据，假设返回的数据就是表格内容
                this.tableData = response.data.map((user, index) => ({
                    ID: (page - 1) * size + index + 1,  // 生成 ID
                    Name: user.name,
                    Username: user.username,
                    Email: user.email,
                }));

                // 假设总记录数是返回的数据的长度，实际上你可以根据 API 的返回来处理
                this.total = response.data.length;

            } catch (error) {
                console.error("请求失败，错误信息：", error);  // 打印错误信息
                this.tableData = [];
                this.total = 0;
            }
        },
    },
    mounted() {
        this.fetchBloodRecords();  // 初始化加载数据
    },
};
</script>
