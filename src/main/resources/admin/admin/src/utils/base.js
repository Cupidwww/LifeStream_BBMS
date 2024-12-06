const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootypiqw/",
            name: "springbootypiqw",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootypiqw/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于Java的含江西郊医院血库管理系统的设计与实现 "
        } 
    }
}
export default base
