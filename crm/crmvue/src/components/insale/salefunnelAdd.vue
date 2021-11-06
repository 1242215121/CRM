<template>
	<h3>新增销售机会</h3>
	<!-- 返回 -->
	<div>
		<el-button size="mini" icon="el-icon-back" type="primary"
		style="width: 50px;height: 30px;" @click="back"></el-button>
	</div>
	<div class="top">
		<el-container>
				<div class="big">
					<el-form :model="formInline" ref="formInline" :rules="rules">
						<el-form-item label="出差地点:" class="ttsalary" prop="address">
							<el-input v-model="formInline.address" placeholder="请输入出差地点" prefix-icon="el-icon-delete-location"></el-input>
						</el-form-item>
						<el-form-item label="出差时间:" class="ttsalary" prop="value2">
							<div class="block">
								<el-date-picker v-model="formInline.value2" 
								type="daterange" :shortcuts="shortcuts"
								:disabledDate="dealDisabledDate"
									range-separator="至" start-placeholder="开始时间" end-placeholder="结束时间">
								</el-date-picker>
							</div>
						</el-form-item>
						<el-form-item label="出差原因:" class="ttreason" prop="reason">
							<el-input v-model="formInline.reason" placeholder="请输入出差原因" type="textarea"
								:autosize="{ minRows: 4}"></el-input>
						</el-form-item>
						<el-form-item class="button">
							<el-button type="primary" @click="submitForm('formInline')">提交</el-button>
							<el-button @click="resetForm()">重置</el-button>
						</el-form-item>
					</el-form>
				</div>
			
		</el-container>
	</div>
</template>

<script>
	import {
		ElMessage
	} from 'element-plus'

	import Qs from 'qs'

	export default {
		data() {
			return {
				eeid: null,
				total: 0, //总页数
				pageSize: 2, //每页的条数
				pageNo: 1, //第几页
				dialogVisible:false,
				forms:{},
				starttime: null, //开始时间
				endtime: null, //结束时间
				formInline:{},
				rules:{
					address:[
						{ required: true, message: '请输入出差地点',trigger: 'blur'},
					],
					value2:[
						{ required: true, message: '请选择出差时间',trigger: 'blur'},
					],
					reason:[
						{ required: true, message: '请输入出差原因', trigger: 'blur' },
					],
				},
			};
		},
		methods: {
			// 返回
			back(){
				this.$router.replace("/salefunnel");
			},
			//重置
			resetForm(){
				this.formInline.address = null;
				this.formInline.value2 = '';
				this.formInline.reason = null;
			},
			dealDisabledDate(time) {
			    return time.getTime() <= Date.now()-24*60*60*1000;
			},  
			//提交
			submitForm(formName) { //出差申请
				this.$refs[formName].validate((valid) => {
					if (valid) {
						//数据不为空，
						let $this = this;
						if ($this.formInline.value2 != '' && $this.formInline.value2 != null) {
							
							$this.starttime = this.formatDate($this.formInline.value2[0]);
							$this.endtime = this.formatDate($this.formInline.value2[1]);
						} else {
							$this.starttime = null;
							$this.endtime = null;
						}
						console.log("开始时间：", $this.starttime);
						console.log("结束时间：", $this.endtime)
						console.log("出差原因：",$this.formInline.reason);
						console.log("出差地点：",$this.formInline.address);
						$this.eeid = this.$store.state.user.name.obj.emp.eeid;
						this.axios.post("/bussiness/insert",Qs.stringify({
							starttime:$this.starttime,
							endtime:$this.endtime,
							reason:$this.formInline.reason,
							address:$this.formInline.address,
							eeid:$this.eeid,
						})).then(res=>{
							// console.log("调薪申请：",res.code);
							if (res.code == 1) {
								ElMessage({
									message: "出差申请新增成功!",
									type: 'success'
								});
								// 跳转页面 回到申请页面
								this.$router.replace("/application");
								
							}else{
								ElMessage({
									message: res.msg,
									type: 'erro'
								});
							}
						})
						
					} else {
						ElMessage({
							message: "请完整填写信息",
							type: 'erro'
						});
						return false;
					}
				});
			},
			//基本信息
			loadData(){
				let $this = this;
				$this.eeid = this.$store.state.user.name.obj.emp.eeid;
				this.axios.get("/salefunnel/selectByEeidMany", {
					params: {
						eeid:$this.eeid
					}
				}).then(res => {
					// console.log("休假基本信息查询：",res);
					$this.forms.postname = res.obj.eename;
					$this.forms.deptname = res.obj.oadept.oadeptName;
				})
			},
			
			handleCurrentChange(val) {
				this.pageNo = val;
				this.loadBussiness();
			},
			//转化成年月日
			formatDate: function(value) {
				var date = new Date(value);
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				var day = date.getDate();
				if (month < 10) {
					month = "0" + month;
				}
				if (day < 10) {
					day = "0" + day;
				}
			
				return year + "-" + month + "-" + day;
			},
		},
		mounted() {
			this.loadData();
			this.loadBussiness();
		}
	};
</script>

<style scoped="scoped">
	h3 {
		margin-top: 10px;
		text-align: center;
	}

	.top {
		margin-top: 20px;
		margin-left: 10px;
	}

	.header {
		border-bottom: 1px solid #CAC6C6;
	}

	.el-table {
		font-size: 12px;
	}
	
	.big {
		margin-top: 5px;
		margin-left: 13%;
		width: 75%;
		border: 1px solid black;
		/* box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); */
	}
	
	.el-form{
		margin: 10px;
	}
	
	.demo-form-inline .el-input {
		border-bottom: 1px solid black;
	}
	
	.ttsalary {
		width: 35%;
	}
	
	.ttreason {
		width: 90%;
	}
	
	.button{
		text-align: center;
	}
</style>
