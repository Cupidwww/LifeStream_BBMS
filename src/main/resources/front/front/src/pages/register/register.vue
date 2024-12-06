<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","backgroundImage":"url(http://codegen.caihongy.cn/20221024/23b37078fa41495b866fda764fd3ea28.png)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"width":"750px","padding":"20px","margin":"40px 0","borderRadius":"10px","background":"#fff","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"width":"100%","margin":"20px 0 20px 0","lineHeight":"44px","fontSize":"36px","color":"#000","textAlign":"center"}'>基于Java的含江西郊医院血库管理系统的设计与实现 注册</p></div>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='gongzuorenyuan'" prop="gonghao">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>工号：</div>
				<el-input v-model="registerForm.gonghao"  placeholder="请输入工号" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='gongzuorenyuan'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='gongzuorenyuan'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='gongzuorenyuan'" prop="xingming">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>姓名：</div>
				<el-input v-model="registerForm.xingming"  placeholder="请输入姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='gongzuorenyuan'" prop="xingbie">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in gongzuorenyuanxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='gongzuorenyuan'" prop="nianling">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='gongzuorenyuan'" prop="shouji">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>手机：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='gongzuorenyuan'" prop="youxiang">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>邮箱：</div>
				<el-input v-model="registerForm.youxiang"  placeholder="请输入邮箱" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="xianxuebianhao">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>献血编号：</div>
				<el-input v-model="registerForm.xianxuebianhao"  placeholder="请输入献血编号" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="xianxuexingming">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>献血姓名：</div>
				<el-input v-model="registerForm.xianxuexingming"  placeholder="请输入献血姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="xingbie">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in xianxuerenyuanxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="nianling">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="lianxidianhua">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="shenfenzheng">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>身份证：</div>
				<el-input v-model="registerForm.shenfenzheng"  placeholder="请输入身份证" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="jiatingzhuzhi">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>家庭住址：</div>
				<el-input v-model="registerForm.jiatingzhuzhi"  placeholder="请输入家庭住址" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="xuexing">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>血型：</div>
                <el-select v-model="registerForm.xuexing" placeholder="请选择血型" >
                  <el-option
                      v-for="(item,index) in xianxuerenyuanxuexingOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0 auto 24px"}' v-if="tableName=='xianxuerenyuan'" prop="touxiang">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="xianxuerenyuantouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-button :style='{"border":"none","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","outline":"none","color":"#fff","borderRadius":"8px","background":"rgba(0, 0, 0, 1)","display":"block","width":"80%","fontSize":"16px","height":"40px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"cursor":"pointer","border":"1px solid rgba(204, 204, 204, 1)","padding":"0 10px","margin":"20px auto 5px","outline":"none","color":"#000","borderRadius":"8px","background":"none","display":"block","width":"80%","fontSize":"16px","height":"40px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 10%","color":"rgba(40, 40, 40, 1)","display":"inline-block","lineHeight":"1.5","fontSize":"12px","textDecoration":"none"}' to="/login">已有账户登录</router-link>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {
                xingbie: '',
                xingbie: '',
                xuexing: '',
            },
			rules: {},
            gongzuorenyuanxingbieOptions: [],
            xianxuerenyuanxingbieOptions: [],
            xianxuerenyuanxuexingOptions: [],
		}
    },
	mounted() {
	},
    created() {
      this.pageFlag = this.$route.query.pageFlag;
      this.tableName = this.$route.query.role;
      if ('gongzuorenyuan' == this.tableName) {
        this.rules.gonghao = [{ required: true, message: '请输入工号', trigger: 'blur' }];
      }
      if ('gongzuorenyuan' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('gongzuorenyuan' == this.tableName) {
        this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }];
      }
        this.gongzuorenyuanxingbieOptions = "男,女".split(',');
      if ('gongzuorenyuan' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
      if ('gongzuorenyuan' == this.tableName) {
        this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
      if ('gongzuorenyuan' == this.tableName) {
        this.rules.youxiang = [{ required: true, validator: this.$validate.isEmail, trigger: 'blur' }];
      }
      if ('xianxuerenyuan' == this.tableName) {
        this.rules.xianxuebianhao = [{ required: true, message: '请输入献血编号', trigger: 'blur' }];
      }
      if ('xianxuerenyuan' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('xianxuerenyuan' == this.tableName) {
        this.rules.xianxuexingming = [{ required: true, message: '请输入献血姓名', trigger: 'blur' }];
      }
        this.xianxuerenyuanxingbieOptions = "男,女".split(',');
      if ('xianxuerenyuan' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
      if ('xianxuerenyuan' == this.tableName) {
        this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
      if ('xianxuerenyuan' == this.tableName) {
        this.rules.shenfenzheng = [{ required: true, validator: this.$validate.isIdCard, trigger: 'blur' }];
      }
        this.xianxuerenyuanxuexingOptions = "A,B,AB,O".split(',');
    },
    //方法集合
    methods: {
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      xianxuerenyuantouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
               if(`gongzuorenyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
               if(`xianxuerenyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;

		.el-date-editor.el-input {
			width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid rgba(204, 204, 204, 1);
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: rgba(153, 153, 153, 1);
						width: 100%;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid rgba(204, 204, 204, 1);
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color:  rgba(153, 153, 153, 1);
						width: 288px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid rgba(204, 204, 204, 1);
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: rgba(153, 153, 153, 1);
						width: 288px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid rgba(204, 204, 204, 1);
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: rgba(153, 153, 153, 1);
						width: 288px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px solid rgba(204, 204, 204, 1);
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: rgba(153, 153, 153, 1);
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px solid rgba(204, 204, 204, 1);
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: rgba(153, 153, 153, 1);
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px solid rgba(204, 204, 204, 1);
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: rgba(153, 153, 153, 1);
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
	}
</style>
