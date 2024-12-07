const express = require('express');
const app = express();
const port = 8080; // 设置后端服务端口

// 模拟接口：/mock/api/test
app.get('/mock/api/test', (req, res) => {
    console.log('Mock API /test called');
    res.json({
        message: 'Hello, Mock!',
    });
});

// 模拟接口：/mock/api/blood-records
app.get('/mock/api/blood-records', (req, res) => {
    const { page = 1, size = 10 } = req.query;

    console.log(`Mock API /blood-records called with page: ${page}, size: ${size}`);

    // 模拟生成数据
    const total = 100;  // 总记录数
    const columns = ['ID', 'Donor Name', 'Blood Type', 'Donation Date', 'Status'];  // 表头
    const data = [];

    for (let i = 0; i < size; i++) {
        data.push({
            ID: (page - 1) * size + i + 1,
            'Donor Name': `Donor ${Math.floor(Math.random() * 100)}`,
            'Blood Type': ['A+', 'B+', 'O+', 'AB+'][Math.floor(Math.random() * 4)],
            'Donation Date': `2024-01-${Math.floor(Math.random() * 30) + 1}`,
            Status: ['Pending', 'Completed', 'Rejected'][Math.floor(Math.random() * 3)],
        });
    }

    // 输出返回的数据
    console.log('Returning data:', { columns, data, total });

    res.json({
        columns,
        data,
        total,
    });
});

// 启动 Express 服务
app.listen(port, () => {
    console.log(`Mock server running at http://localhost:${port}`);
});
