<template>
	<div id="gap">
		<el-row>
			<el-col :span="5">
				<el-input placeholder="联系人名称" size="mini" v-model="input">
				</el-input>
			</el-col>
			<el-col :span="4" :push="1">
				<el-button type="primary" size="mini" @click="getContactsData()">查询</el-button>
			</el-col>
			<el-col :span="4" :push="11">
				<el-button type="primary" size="mini" @click="drawer=true">新增</el-button>
			</el-col>
		</el-row>
	</div>
	<el-drawer title="新增线索" v-model="drawer" :with-header="false" size="50%">
		<div class="big">
			<el-form :model="contactse" ref="contactse" :rules="rules">
				<el-form-item label="姓名:" class="ttsalary" prop="contactsName">
					<el-input v-model="contactse.contactsName" placeholder="请输入姓名"></el-input>
				</el-form-item>
				<el-form-item label="职务:" class="ttsalary" prop="contactsDuty">
					<el-input v-model="contactse.contactsDuty" placeholder="请输入职务"></el-input>
				</el-form-item>
				<el-form-item label="联系电话:" class="ttsalary" prop="contactsPhone">
					<el-input v-model="contactse.contactsPhone" placeholder="请输入电话号码"></el-input>
				</el-form-item>
				<el-form-item label="在职情况:" class="ttsalary" prop="contactsCase">
					<el-select v-model="contactse.contactsCase" placeholder="请选择角色">
						<el-option v-if="caset!=null" v-for="item in caset" :key="item.value" :label="item.label"
							:value="item.label">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="所属角色:" class="ttsalary" prop="contactsRole">
					<el-select v-model="contactse.contactsRole" placeholder="请选择角色">
						<el-option v-if="role!=null" v-for="item in role" :key="item.value" :label="item.label"
							:value="item.label">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="button">
					<el-button type="primary" @click="getInContacts('contactse')">提交</el-button>
					<el-button @click="resetForm()">重置</el-button>
				</el-form-item>
			</el-form>
		</div>
	</el-drawer>
	<!-- 表格 -->
	<el-table :data="contactsData" style="width: 100%">
		<el-table-column prop="contactsName" label="姓名" width="190" />
		<el-table-column prop="contactsDuty" label="职务" width="190"/>
		<el-table-column prop="contactsPhone" label="联系电话" width="210"/>
		<el-table-column prop="contactsRole" label="角色" width="210"/>
		<el-table-column prop="contactsCase" label="在职情况" />
		
	</el-table>
	<!-- 分页 -->
	<el-pagination :current-page="pageNo" @current-change="getContactsData" background
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
				drawer: false, //面板状态
				pageNo: 1,
				size: 3,
				total: 0,
				input: '',
				contactsData:[],
				/* users:{
					usersId: '', //员工id
					usersName: '', //员姓名
				}, */
				contacts:{
					contactsName:'',//联系人名称
					pageNo: 1,
					size: 3
				},
				role: [{
						value: '选项1',
						label: '关键决策人'
					},
					{
						value: '选项2',
						label: '分项决策人'
					},
					{
						value: '选项3',
						label: '普通人'
					},
					{
						value: '选项4',
						label: '直接用户'
					},
					{
						value: '选项4',
						label: '核心支持者'
					}
				],
				caset: [{
						value: '选项1',
						label: '在职'
					},
					{
						value: '选项2',
						label: '离职'
					},
					
				],
				contactse:{
					contactsName:''
				},
				rules: {
					contactsName: [{
						required: true,
						message: '请输入姓名',
						trigger: 'blur'
					}, ],
					contactsDuty: [{
						required: true,
						message: '请输入职务',
						trigger: 'blur'
					}, ],
					contactsRole: [{
						required: true,
						message: '请输入角色',
						trigger: 'blur'
					}, ],
					contactsCase: [{
						required: true,
						message: '请输入在职情况',
						trigger: 'blur'
					}, ],
					contactsPhone: [{
						required: true,
						message: '请输入联系电话',
						trigger: 'blur'
					}, ],
				
				},
			}
		},
		methods: {
			//重置
			resetForm() {
				this.contactse = {};
			},
			getContactsData(no) {
				this.contacts.contactsName = this.input;
				if(no == undefined){
					no = this.pageNo
				}
				this.contacts.pageNo = no;
				this.contacts.size = this.size;
				this.axios.post(
					"contacts/selectContacts",
					this.contacts
				).then(c => {
					console.log("34567",c);
					this.contactsData = c.obj.list;
					this.total = c.obj.total;
				})

			},
			getInContacts(row){
				this.axios.post('contacts/inContacts',this.contactse).then((v) => {
					if(v.code == 1){
						ElMessage({
							message: "活动新增成功!",
							type: 'success'
						});
						this.drawer = false;
						this.getContactsData();
					}else{
						ElMessage({
							message: v.msg,
							type: 'erro'
						});
					}
				})
			}
			
		},
		created() {
			this.getContactsData();
		}
	}
</script>

<style>
	.big {
		margin-top: 15px;
		margin-left: 13%;
		width: 80%;
		/* box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); */
	}
	#gap {
		margin-top: 10px;
		margin-left: 10px;
	}

	.ttsalary {
		width: 82%;
	}
</style>
