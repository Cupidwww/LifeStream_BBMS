# 项目运行说明

### Setup
1. 在服务器启动MySQL服务，并新建数据库
2. 在新建的数据库中运行db文件夹下的sql文件
3. 后端依赖配置
    - 为项目下载Maven，建议使用idea辅助
    - 修改配置文件，将数据库名称，MySQL服务的用户名和密码修改为自己的，[配置文件](./src/main/resources/application.yml)

    - 首次运行项目在终端执行`mvn install`，安装依赖，注意要在项目根目录下运行
    - 非首次运行可以直接运行`mvn clean`
    - 然后运行`mvn package`打包，后面如果修改后端代码都要先clean后package
    - 运行`java -jar target/springbootypiqw-0.0.1-SNAPSHOT.jar`即可启动后端
    - 注意后端运行较占内存和较为耗电，如果在本机上运行要注意检测系统性能状态
4. 前端依赖配置与运行，可见frontend文件夹下的[README文件](./frontend/README.md)
5. 前端后端都可以运行后，应该可以看见程序界面
