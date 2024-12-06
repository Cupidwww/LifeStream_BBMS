<template>
<div :style='{"border":"2px solid #a4d9b7","padding":"20px","margin":"20px auto 0","borderRadius":"8px","flexWrap":"wrap","background":"#fff","width":"1200px","position":"relative"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="200px"
    >
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="血库编号" prop="xuekubianhao">
            <el-input v-model="ruleForm.xuekubianhao" 
                placeholder="血库编号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="血型" prop="xuexing">
            <el-input v-model="ruleForm.xuexing" 
                placeholder="血型" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="血液种类" prop="xueyezhonglei">
            <el-input v-model="ruleForm.xueyezhonglei" 
                placeholder="血液种类" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="袋数" prop="daishu">
            <el-input v-model="ruleForm.daishu" 
                placeholder="袋数" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="血量" prop="xueliang">
            <el-input v-model="ruleForm.xueliang" 
                placeholder="血量" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="入库日期" prop="rukuriqi" >
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.rukuriqi" 
                  type="date"
                  placeholder="入库日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="备注" prop="beizhu">
            <el-input v-model="ruleForm.beizhu" 
                placeholder="备注" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="工号" prop="gonghao">
            <el-input v-model="ruleForm.gonghao" 
                placeholder="工号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="姓名" prop="xingming">
            <el-input v-model="ruleForm.xingming" 
                placeholder="姓名" clearable ></el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"8px 0 0 0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"20px 40px 20px 260px","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"20px","background":"#47b144","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"2px solid #3db769","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#3db769","borderRadius":"20px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            xuekubianhao : false,
            xuexing : false,
            xueyezhonglei : false,
            daishu : false,
            xueliang : false,
            rukuriqi : false,
            beizhu : false,
            gonghao : false,
            xingming : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          xuekubianhao: '',
          xuexing: '',
          xueyezhonglei: '',
          daishu: '',
          xueliang: '',
          rukuriqi: '',
          beizhu: '',
          gonghao: '',
          xingming: '',
        },
        rules: {
          xuekubianhao: [
          ],
          xuexing: [
          ],
          xueyezhonglei: [
          ],
          daishu: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          xueliang: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          rukuriqi: [
          ],
          beizhu: [
          ],
          gonghao: [
          ],
          xingming: [
          ],
        },
      };
    },
    computed: {



    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.rukuriqi = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='xuekubianhao'){
              this.ruleForm.xuekubianhao = obj[o];
              this.ro.xuekubianhao = true;
              continue;
            }
            if(o=='xuexing'){
              this.ruleForm.xuexing = obj[o];
              this.ro.xuexing = true;
              continue;
            }
            if(o=='xueyezhonglei'){
              this.ruleForm.xueyezhonglei = obj[o];
              this.ro.xueyezhonglei = true;
              continue;
            }
            if(o=='daishu'){
              this.ruleForm.daishu = obj[o];
              this.ro.daishu = true;
              continue;
            }
            if(o=='xueliang'){
              this.ruleForm.xueliang = obj[o];
              this.ro.xueliang = true;
              continue;
            }
            if(o=='rukuriqi'){
              this.ruleForm.rukuriqi = obj[o];
              this.ro.rukuriqi = true;
              continue;
            }
            if(o=='beizhu'){
              this.ruleForm.beizhu = obj[o];
              this.ro.beizhu = true;
              continue;
            }
            if(o=='gonghao'){
              this.ruleForm.gonghao = obj[o];
              this.ro.gonghao = true;
              continue;
            }
            if(o=='xingming'){
              this.ruleForm.xingming = obj[o];
              this.ro.xingming = true;
              continue;
            }
          }
          this.ruleForm.daishu = 0
          this.ruleForm.xueliang = 0
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.gonghao!=''&&json.gonghao) || json.gonghao==0){
                this.ruleForm.gonghao = json.gonghao
            }
            if((json.xingming!=''&&json.xingming) || json.xingming==0){
                this.ruleForm.xingming = json.xingming
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('xueyeruku/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        var obj = JSON.parse(localStorage.getItem('crossObj'));
        var table = localStorage.getItem('crossTable');
        obj.daishu = parseFloat(obj.daishu) + parseFloat(this.ruleForm.daishu)

        //this.$http.post(table+`/update`, obj).then(res => {});
        var obj = JSON.parse(localStorage.getItem('crossObj'));
        var table = localStorage.getItem('crossTable');
        obj.xueliang = parseFloat(obj.xueliang) + parseFloat(this.ruleForm.xueliang)

        //this.$http.post(table+`/update`, obj).then(res => {});
        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('xueyeruku/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算
                          var obj = JSON.parse(localStorage.getItem('crossObj'));
                          var table = localStorage.getItem('crossTable');

                          obj.daishu = parseFloat(obj.daishu) + parseFloat(this.ruleForm.daishu)
                          obj.xueliang = parseFloat(obj.xueliang) + parseFloat(this.ruleForm.xueliang)

                          this.$http.post(table+`/update`,obj).then(res => {});
                          this.$http.post('xueyeruku/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {
                  var obj = JSON.parse(localStorage.getItem('crossObj'));
                  var table = localStorage.getItem('crossTable');

                  obj.daishu = parseFloat(obj.daishu) + parseFloat(this.ruleForm.daishu)
                  obj.xueliang = parseFloat(obj.xueliang) + parseFloat(this.ruleForm.xueliang)

                  this.$http.post(table+`/update`,obj).then(res => {});
                  this.$http.post('xueyeruku/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 200px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 200px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #9ce0b5;
	  border-radius: 4px;
	  padding: 0 12px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  outline: none;
	  color: #666;
	  width: 80%;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #9ce0b5;
	  border-radius: 4px;
	  padding: 0 10px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  outline: none;
	  color: #666;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #9ce0b5;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  outline: none;
	  color: #666;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid #9ce0b5;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  color: #3db769;
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #9ce0b5;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  color: #3db769;
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #9ce0b5;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  color: #3db769;
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #9ce0b5;
	  border-radius: 4px;
	  padding: 12px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  outline: none;
	  color: #666;
	  width: 80%;
	  font-size: 14px;
	  min-height: 180px;
	}
</style>
