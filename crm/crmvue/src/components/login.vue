<template>
	   
	<div class="login_box">

		<el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" class="demo-ruleForm">
			<h3 class="login_title">账号密码登录</h3>
			<el-form-item prop="account">
				<el-input type="text" v-model="ruleForm.account" placeholder="账号" autocomplete="off" @keyup.enter="login()"></el-input>
			</el-form-item>
			<el-form-item prop="pass">
				<el-input type="password" v-model="ruleForm.pass" placeholder="密码" autocomplete="off" @keyup.enter="login()"></el-input>
			</el-form-item>

			<el-form-item>
				<el-button style="width: 100%" type="primary" @click="submitClick('ruleForm')">登录</el-button>
			</el-form-item>
		</el-form>
	</div>
	

</template>

<script>
	
	import qs from 'qs';
	import {
		ElMessage
	} from 'element-plus';
	
	export default {
	
		data() {
			var validateaccount = (rule, value, callback) => {
				if (value === '') {
					callback(new Error('请输入账号'));
				} else {
					if (this.ruleForm.account !== '') {
						this.$refs.ruleForm.validateField('account');
					}
					callback();
				}
			};
			var validatePass = (rule, value, callback) => {
				if (value === '') {
					callback(new Error('请输入密码'));
				} else {
					if (this.ruleForm.pass !== '') {
						this.$refs.ruleForm.validateField('pass');
					}
					callback();
				}
			};
			
			return {
				 ruleForm: {
					account: '',
					pass: ''
				},
				rules: {
					account: [{
						validator: validateaccount,
						trigger: 'blur'
					}],
					pass: [{
						validator: validatePass,
						trigger: 'blur'
					}]
					
				}
			}
		},
		methods: {
			 
			submitClick(formName) {
				
				this.$refs[formName].validate((valid) => {
					if (valid) {
							this.login();					
					} else {
						return false;
					}
				});

			},
			login() {
				let data = {
					usersName: this.ruleForm.account,
					usersPwd: this.ruleForm.pass
				};
				let parms = qs.stringify(data);
			
				this.axios.post("users/login", parms).then(res => {
					console.log("后台返回的数据是：",res);
					if (res.code == 1) {
						//用户信息存入store中。调用./src/store/index.js的方法login，参数就是data.obj(当前登录的用户信息)
						this.$store.commit('login',res.obj);
						this.$router.replace('/usersfrom');
						this.$message.success("登录成功！");
					} else {
						if(res.msg=="密码错误！！"){
							this.ruleForm.pass='';
						}else if(res.msg=="用户名错误！！"){
							this.ruleForm.account='';
							this.ruleForm.pass='';
						}
					}
				})
			}
		},
		created() {
			   
			 
		}
	}
</script>
<style scoped="scoped">
	
	.el-form-item__content {
		margin: 0px;
	}

	.login_box {
		z-index: 1;
		border-radius: 15px;
		background-clip: padding-box;
		position: absolute;
		width: 350px;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		padding: 35px 35px 15px 35px;
		background: #fff;
		border: 1px solid #eaeaea;
		
	}

	.login_title {
		text-align: center;
		margin: 0px auto 40px auto;
		text-align: center;
		color: #505458;
	}
	.box{
		height: 500px;
	}
</style>
