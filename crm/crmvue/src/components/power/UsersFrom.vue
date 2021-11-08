<template>
	
	<div style="margin: 20px; padding: 20px;">
		
	<el-card>
		<div style="text-align: center;margin: 20px;font-size: 22px;font-weight: 600;">
			{{lookstate?butstate?"修改用户信息":"新增用户":"用户信息"}}
		</div>
	<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
		<el-form-item label="姓名" required prop="usersFullname">
			<el-input v-model="ruleForm.usersFullname" maxlength="8" :readonly="!lookstate"></el-input>
		</el-form-item>
		<el-form-item label="性别" prop="usersSex">
			<el-radio-group v-model="ruleForm.usersSex">
				<el-radio label="男" value="男" :disabled="!lookstate"></el-radio>
				<el-radio label="女" value="女" :disabled="!lookstate"></el-radio>
			</el-radio-group>
		</el-form-item>
		<el-form-item label="用户名" required prop="usersName">
			<el-input v-model="ruleForm.usersName" maxlength="16" :readonly="!lookstate"></el-input>
		</el-form-item>
		<el-form-item label="密码" required prop="usersPwd">
			<el-input v-model="ruleForm.usersPwd" maxlength="16" :readonly="!lookstate"></el-input>
		</el-form-item>
		<el-form-item label="职位" required prop="ajob">
			<el-input v-if="!lookstate" v-model="ruleForm.ajob.ajobName" :readonly="!lookstate"></el-input>
			<el-select v-if="lookstate" v-model="ruleForm.ajob.ajobId">
				<el-option v-for="v in ajob" :label="v.ajobName" :key="v.ajobId" :value="v.ajobId" >
					
				</el-option>
			</el-select>
		</el-form-item>
		<el-form-item label="所在部门" required prop="dept">
			<el-input  v-if="!lookstate" v-model="ruleForm.dept.deptName" :readonly="!lookstate"></el-input>
			<el-select v-if="lookstate" v-model="ruleForm.dept.deptId">
			<el-option v-for="v in dept" :label="v.deptName" :key="v.deptId" :value="v.deptId" >
				
			</el-option>
			</el-select>
		</el-form-item>
		<el-form-item label="联系电话" required prop="usersPhone">
			<el-input v-model="ruleForm.usersPhone" maxlength="11" :readonly="!lookstate"></el-input>
		
		</el-form-item>
		<el-form-item label="出生日期">
			<el-form-item prop="usersBirth">
				<el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.usersBirth"
					:readonly="!lookstate"></el-date-picker>
			</el-form-item>
		</el-form-item>
		<el-form-item label="电子邮箱" prop="usersEmail">
			<el-input v-model="ruleForm.usersEmail" maxlength="25" :readonly="!lookstate"></el-input>
		</el-form-item>
		<div style="text-align: center;">
			<el-button type="primary" v-show="lookstate" @click="commitfrom('ruleForm')">{{butstate?"修改":"新增"}}</el-button>
			<el-button type="primary" @click="descrout">返回</el-button>
		</div>
		
	</el-form>
	</el-card>
	</div>
</template>

<script>
	import qs from 'qs';
	import {
		ElMessage
	} from 'element-plus';
	export default {
		data() {
			return {
				//表单数据
				ruleForm: {
					usersId:'',
					usersName:'',
					usersPwd:'',
					usersFullname:'',
					usersSex:'',
					usersBrith:'',
					usersPhone:'',
					usersEmail:'',
					usersImgs:'',
					state:1,
					ajob:{
						ajobId:'',
						ajobName:''
					},
					dept:{
						deptId:'',
						deptName:''
					}
				},
				ajob:[],
				dept:[],
				//验证信息
				rules: {
					usersName: [{
							required: true,
							message: '请输入用户名',
							trigger: 'blur'
						},
						{
							min: 2,
							max: 16,
							message: '长度在 2 到 16 个字符',
							trigger: 'blur'
						}
					],
					usersPwd: [{
							required: true,
							message: '请输入密码',
							trigger: 'blur'
						},
						{
							min: 2,
							max: 16,
							message: '长度在 2 到 16 个字符',
							trigger: 'blur'
						}
					],
					usersFullname: [{
							required: true,
							message: '请输入姓名',
							trigger: 'blur'
						},
						{
							min: 2,
							max: 8,
							message: '长度在 2 到 8 个字符',
							trigger: 'blur'
						}
					],
					usersPhone: [{
							required: true,
							message: '请输入电话',
							trigger: 'blur'
						},
						{
							min: 11,
							max: 11,
							message: '长度在 11 个字符',
							trigger: 'blur'
						}
					],
					ajob: [{
						required: true,
						message: '请选择职位',
						trigger: 'change'
					}],
					dept: [{
						required: true,
						message: '请选择部门',
						trigger: 'change'
					}],
				},
				//修改还是新增
				butstate: false,
				//查看还是修改
				lookstate: true,
				
			};
		},
		methods: {
			commitfrom(formName){
				var $this=this;
				console.log($this.ruleForm,"ruleForm");
				this.$refs[formName].validate((valid) => {
					if (valid) {
						if(!this.butstate){
							//新增
							this.axios.post("/users/add",{
								usersId:$this.ruleForm.usersId,
								usersName:$this.ruleForm.usersName,
								usersPwd:$this.ruleForm.usersPwd,
								usersFullname:$this.ruleForm.usersFullname,
								usersSex:$this.ruleForm.usersSex=="男"?1:0,
								usersBrith:$this.ruleForm.usersBrith,
								usersPhone:$this.ruleForm.usersPhone,
								usersEmail:$this.ruleForm.usersEmail,
								usersImgs:'public/imgs/wjl.jpg',
								state:1,
								ajob:{
									ajobId:$this.ruleForm.ajob.ajobId,
								},
								dept:{
									deptId:$this.ruleForm.dept.deptId,
								}
							}).then(res=>{
								if(res.code == 1){
									this.$message.success("新增成功！");
									this.$router.push("users");
								}else if(res.msg=="该用户名已被注册!"){
									alert(1);
									this.ruleForm.usersName='';
								}
								
							})
						}else{
							//修改
							this.axios.post("/users/update",{
								usersId:$this.ruleForm.usersId,
								usersName:$this.ruleForm.usersName,
								usersPwd:$this.ruleForm.usersPwd,
								usersFullname:$this.ruleForm.usersFullname,
								usersSex:$this.ruleForm.usersSex=="男"?1:0,
								usersBrith:$this.ruleForm.usersBrith,
								usersPhone:$this.ruleForm.usersPhone,
								usersEmail:$this.ruleForm.usersEmail,
								usersImgs:$this.ruleForm.usersImgs,
								ajob:{
									ajobId:$this.ruleForm.ajob.ajobId,
								},
								dept:{
									deptId:$this.ruleForm.dept.deptId,
								}
							}).then(res=>{
								if(res.code == 1){
									this.$message.success("修改成功！");
									this.$router.push("users");
								}
							})
						}
					}
				})
				
				
			},
			descrout(){
				this.$router.push("users");
			},
			bandform(usersId,edit){
				if(usersId){
					//根据主键查询  绑值
					this.axios.get("/users/byusersid",{
						params:{
							usersid:usersId
						}
					}).then(res=>{
						console.log("查到的users",res)
						this.ruleForm=res.obj;
						if(this.ruleForm.usersSex==1){
							this.ruleForm.usersSex="男"
						}else{
							this.ruleForm.usersSex="女"
						}
					})
					
					//判断是编辑、查看、新增状态
					if(edit==1){
						this.lookstate=false;
					}else if(edit==2){
						this.butstate=true;
					}
				}
			},
			//绑定职位
			loadAjob(){
				
				var $this=this;
				this.axios.get("/ajob/all").then(res=>{
					console.log("查询到的职位",res.data)
					$this.ajob=res.data;
					
				})
			},
			//绑定部门
			lodeDept(){
					
				var $this=this;
				this.axios.get("/dept/all").then(res=>{
					console.log("查询到的部门",res.data)
					$this.dept=res.data;
					
				})
			},
		},
		//钩子函数
		created() {
			this.loadAjob();
			this.lodeDept();
			if (this.$route.params.usersId||this.$route.params.edit) {
				this.bandform(this.$route.params.usersId, this.$route.params.edit);
			}

		}
	}
</script>

<style scoped="scoped">
	.filetable td {
		width: 33%;
	}

	.entrytable td {
		width: 33%;
	}

	.entrytable,
	.filetable th {
		text-align: left;
		margin: 10px;
	}

	.filetable,
	.entrytable th {
		text-align: left;
		margin: 10px;
	}
</style>

