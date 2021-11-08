<template>
	<div id="gap">
		<el-row>
			<el-col :span="5">
				<el-input placeholder="线索名称" size="mini" v-model="input">
				</el-input>
			</el-col>
			<el-col :span="4" :push="1">
				<el-button type="primary" size="mini" @click="getClueData()">查询</el-button>
			</el-col>
			<el-col :span="4" :push="11">
				<el-button type="primary" size="mini" @click="drawer=true">新增</el-button>
			</el-col>
		</el-row>
	</div>
	<el-drawer title="新增线索" v-model="drawer" :with-header="false" size="50%">
		<div class="big overflowAuto">
			<el-form :model="clue" ref="clue" :rules="rules">
				<el-form-item label="线索名称:" class="ttsalary" prop="clueName">
					<el-input v-model="clue.clueName" placeholder="请输入线索名称"></el-input>
				</el-form-item>
				<el-form-item label="联系电话:" class="ttsalary" prop="cluePhone">
					<el-input v-model="clue.cluePhone" placeholder="请输入联系电话"></el-input>
				</el-form-item>
				<el-form-item label="负责人员:" class="ttsalary" prop="users">
					<el-select v-model="clue.users.usersId" placeholder="请输入负责人员">
						<el-option v-if="userse!=null" v-for="u in userse" :key="u.usersId"
							:label="u.usersFullname" :value="u.usersId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="更新时间:" class="ttsalary" prop="clueTime">
					<div class="block">
						<el-date-picker v-model="clue.clueTime" type="datetime"
							:disabledDate="dealDisabledDate" placeholder="请选择时间">
						</el-date-picker>
					</div>
				</el-form-item>
				<el-form-item label="跟进状态:" class="ttsalary" prop="clueGoState">
					<el-select v-model="clue.clueGoState" placeholder="请输入跟进状态">
						<el-option v-if="goState!=null" v-for="item in goState" :key="item.value" :label="item.label"
							:value="item.label">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="线索状态:" class="ttsalary" prop="clueState">
					<el-select v-model="clue.clueState" placeholder="请输入活动状态">
						<el-option v-if="state!=null" v-for="item in state" :key="item.value"
							:label="item.label" :value="item.label">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="公司:" class="ttsalary" prop="clueCompany">
					<el-input v-model="clue.clueCompany" placeholder="请输入公司"></el-input>
				</el-form-item>
				<el-form-item label="行业:" class="ttsalary" prop="cluePost">
					<el-input v-model="clue.cluePost" placeholder="请输入行业"></el-input>
				</el-form-item>
				<el-form-item label="职务:" class="ttsalary" prop="clueDuty">
					<el-input v-model="clue.clueDuty" placeholder="请输入职务"></el-input>
				</el-form-item>
				<el-form-item class="button">
					<el-button type="primary" @click="getInClue('clue')">提交</el-button>
					<el-button @click="resetForm()">重置</el-button>
				</el-form-item>
			</el-form>
		</div>
	</el-drawer>
	<!-- 表格 -->
	<el-table :data="clueData" style="width: 100%">
		<el-table-column prop="clueName" label="线索名称" width="140" />
		<el-table-column prop="users.usersName" label="负责人" width="140" />
		<el-table-column prop="clueCompany" label="公司" width="170" />
		<el-table-column prop="cluePost" label="行业" width="140" />
		<el-table-column prop="clueGoState" label="跟进状态" width="140" />
		<el-table-column prop="clueDuty" label="职务" />
		<el-table-column prop="clueState" label="线索状态" />
		<el-table-column prop="clueTime" label="更新时间" width="170" />
		<el-table-column prop="cluePhone" label="联系电话" width="170" />
		<el-table-column label="操作" width="140px">
			<template #default="scope">
				<el-button type="primary" size="mini" v-if="scope.row.clueState == '未转化'"
				 plain @click="drawer1=true">转化为客户
				</el-button>
			</template>
		</el-table-column>
	</el-table>
	<el-drawer  v-model="drawer1" :with-header="false" size="50%">
		<div class="big overflowAuto">
		<el-form label-width="80px" :model="client" ref="client" :rules="rule">
				<el-form-item label="客户编码" class="ttsalary" prop="clientRule">
					<el-input placeholder="" v-model="client.clientRule" :disabled="true" size="medium" />
				</el-form-item>
				<el-form-item label="客户名称" class="ttsalary" prop="clientName">
					<el-input placeholder="" v-model="client.clientName"/>
				</el-form-item>
				<el-form-item label="客户电话" class="ttsalary" prop="clientPhone">
					<el-input placeholder="" v-model="client.clientPhone"/>
				</el-form-item>
				<el-form-item label="客户级别" class="ttsalary" prop="clientRank">
					<el-input placeholder="" v-model="client.clientRank" size="medium" />
				</el-form-item>
				<el-form-item label="客户地址" class="ttsalary" prop="clientAddress">
					<el-input placeholder="" v-model="client.clientAddress" size="medium" />
				</el-form-item>
				<el-form-item label="负责人员" class="ttsalary" prop="users">
					<el-select v-model="client.users.usersId" placeholder="请输入负责人员">
						<el-option v-if="userse!=null" v-for="u in userse" :key="u.usersId"
							:label="u.usersFullname" :value="u.usersId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="跟进状态" class="ttsalary" prop="clientState">
					<el-select v-model="client.clientState" placeholder="请输入跟进状态">
						<el-option v-if="clientState!=null" v-for="item in clientState" :key="item.value" :label="item.label"
							:value="item.label">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="客户规模" class="ttsalary" prop="clientScale">
					<el-select v-model="client.clientScale" placeholder="请输入活动状态">
						<el-option v-if="clientScale!=null" v-for="item in clientScale" :key="item.value"
							:label="item.label" :value="item.label">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="button">
					<el-button type="primary" @click="getInClient('client')">提交</el-button>
					<el-button @click="resetForm()">重置</el-button>
				</el-form-item>
		</el-form>
	</div>
</el-drawer>
	<!-- 分页 -->
	<el-pagination :current-page="pageNo" @current-change="getClueData" background
		layout="total,prev, pager, next,jumper" :page-size="size" :total="total">
	</el-pagination>
</template>




<script>
	import {
		ElMessage
	} from 'element-plus'
	import Qs from 'qs'
	export default {
		data() {
			return {
				drawer1:false,
				drawer: false, //面板状态
				pageNo: 1,
				size: 3,
				total: 0,
				input: '',
				clueData: [],//线索表
				userse: [], //负责人
				users: { //员工表
					usersId: '', //员工id
					usersFullname: '', //员姓名
					deptId: '' //部门id
				},
				client:{
					clientId:''
				},
				clue: {
					clueName: '', //线索名称
					pageNo: 1,
					size: 3
				},
				clue:{
					clueName:'',
					users: { //员工表
						usersId: '', //员工id
						usersFullname: '', //员姓名
						deptId: '' //部门id
					},
				},
				client:{
					clientName:'',
					users: { //员工表
						usersId: '', //员工id
						usersFullname: '', //员姓名
						deptId: '' //部门id
					},
				},
				rule:{
					
					clientName: [{
						required: true,
						message: '请输入客户名称',
						trigger: 'blur'
					}, ],
					clientPhone: [{
						required: true,
						message: '请输入客户电话',
						trigger: 'blur'
					}, ],
					clientRank: [{
						required: true,
						message: '请输入客户级别',
						trigger: 'blur'
					}, ],
					clientAddress: [{
						required: true,
						message: '请输入客户地址',
						trigger: 'blur'
					}, ],
					users: [{
						required: true,
						message: '请输入负责人员',
						trigger: 'blur'
					}, ],
					clientState: [{
						required: true,
						message: '请输入跟进状态',
						trigger: 'blur'
					}, ],
					clientScale: [{
						required: true,
						message: '请输入客户规模',
						trigger: 'blur'
					}, ],
				},
				rules: {
					clueName: [{
						required: true,
						message: '请输入线索名称',
						trigger: 'blur'
					}, ],
					cluePhone: [{
						required: true,
						message: '请输入联系电话',
						trigger: 'blur'
					}, ],
					users: [{
						required: true,
						message: '请输入负责人员',
						trigger: 'blur'
					}, ],
					clueTime: [{
						required: true,
						message: '请输入更新时间',
						trigger: 'blur'
					}, ],
					clueGoState: [{
						required: true,
						message: '请输入跟进状态',
						trigger: 'blur'
					}, ],
					clueState: [{
						required: true,
						message: '请输入线索状态',
						trigger: 'blur'
					}, ],
					clueCompany: [{
						required: true,
						message: '请输入公司',
						trigger: 'blur'
					}, ],
				
				},
				goState: [{
						value: '选项1',
						label: '已联系'
					}, {
						value: '选项2',
						label: '未联系'
					},
					{
						value: '选项1',
						label: '二次联系'
					}, {
						value: '选项2',
						label: '多次联系'
					},
					{
						value: '选项1',
						label: '关闭'
					}
				],
				state:[{
						value: '选项1',
						label: '未转化'
					}, {
						value: '选项2',
						label: '已转化'
					},
					
				],
				clientState:[{
						value: '选项1',
						label: '初步沟通'
					}, {
						value: '选项2',
						label: '方案提报'
					},
					{
						value: '选项3',
						label: '正式报价'
					}, {
						value: '选项4',
						label: '合同谈判'
					},
					{
						value: '选项5',
						label: '正式签约'
					},
					{
						value: '选项6',
						label: '售后服务'
					}
				],
				clientScale:[{
						value: '选项1',
						label: '20人以下'
					}, {
						value: '选项2',
						label: '20-100人'
					},
					{
						value: '选项3',
						label: '100-300人'
					}, {
						value: '选项4',
						label: '300-800人'
					},
					{
						value: '选项5',
						label: '10000以上'
					},
					
				],
			}
		},
		methods: {
			/* 查user所有 */
			loadUser() {
				let $this = this;
				this.axios.get("/users").then(res => {
					console.log("负责人:", res);
					$this.userse = res.data;
				})
			},
			//重置
			resetForm() {
				this.clue = {};
			},
			theRandom() {
				var k = Math.round(Math.random() * 10000000)
				this.client.clientRule = "KH"+k
			},
			/* 联表查询 */
			getClueData(no) {
				this.clue.clueName = this.input;
				if (no == undefined) {
					no = this.pageNo
				}
				this.clue.pageNo = no;
				this.clue.size = this.size;
				this.axios.post(
					"clue/selectClue",
					this.clue
				).then(c => {
					console.log("34567", c);
					this.clueData = c.obj.list;
					this.total = c.obj.total;
				})

			},
			getInClue(formName){
				this.$refs[formName].validate((valid) => {
					if (valid) {
						this.axios.post('clue/inClue',this.clue).then((c) => {
							if(c.code == 1){
								ElMessage({
									message: "线索新增成功!",
									type: 'success'
								});
								this.drawer = false;
							}else{
								ElMessage({
									message: x.msg,
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
				})
			},
			getInClient(formName){
				this.$refs[formName].validate((valid) => {
					if (valid) {
						this.axios.post('client/inClient',this.client).then((l) => {
							if(l.code == 1){
								ElMessage({
									message: "转化客户成功!",
									type: 'success'
								});
								this.drawer1=false;
							}else{
								ElMessage({
									message: x.msg,
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
				})
				
			}
		},
		created() {
			this.getClueData();
			this.loadUser();
			this.theRandom();
		}
	}
</script>

<style>
	#gap {
		margin-top: 10px;
		margin-left: 10px;
	}

	.big {
		margin-top: 15px;
		margin-left: 13%;
		width: 80%;
		/* box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); */
	}

	.ttsalary {
		width: 82%;
	}
	.overflowAuto {
		overflow-y: auto;
		position: absolute;
		width: 100%;
		height: 100%;
	}
	
	.overflowAuto::-webkit-scrollbar {
		height: 6px;
		width: 6px;
	}
	
	.overflowAuto::-webkit-scrollbar-thumb {
		background: rgb(224, 214, 235);
	}
</style>
