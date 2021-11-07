<template>
	<div id="gap">
		<el-row>
			<el-col :span="5">
				<el-input placeholder="活动名称/地址" v-model="input" size="mini">
				</el-input>
			</el-col>
			<el-col :span="4" :push="1">
				<el-button type="primary" size="mini" @click="getActivityData()">查询</el-button>
			</el-col>
			<el-col :span="4" :push="11">
				<el-button type="primary" size="mini" @click="drawer=true">新增</el-button>
			</el-col>
		</el-row>
	</div>
	<el-drawer title="新增市场活动" v-model="drawer" :with-header="false" size="50%">
		<div class="big overflowAuto">
			<el-form :model="formInline" ref="formInline" :rules="rules">
				<el-form-item label="活动名称:" class="ttsalary" prop="name">
					<el-input v-model="formInline.name" placeholder="请输入活动名称"></el-input>
				</el-form-item>
				<el-form-item label="负责人员:" class="ttsalary" prop="user">
					<el-input v-model="formInline.user" placeholder="请输入负责人"></el-input>
				</el-form-item>
				<el-form-item label="开始时间:" class="ttsalary" prop="value1">
					<div class="block">
						<el-date-picker v-model="formInline.value1" type="datetime" :disabledDate="dealDisabledDate"
							placeholder="请选择时间">
						</el-date-picker>
					</div>
				</el-form-item>
				<el-form-item label="结束时间:" class="ttsalary" prop="value2">
					<div class="block">
						<el-date-picker v-model="formInline.value2" type="datetime" :disabledDate="dealDisabledDate"
							placeholder="请选择时间">
						</el-date-picker>
					</div>
				</el-form-item>
				<el-form-item label="活动地址:" class="ttsalary" prop="address">
					<el-input v-model="formInline.address" placeholder="请输入活动地址"></el-input>
				</el-form-item>
				<el-form-item label="活动类型:" class="ttsalary" prop="type">
					<el-select v-model="activityData.activityName" placeholder="请输入活动类型">
						<el-option v-if="type!=null" v-for="item in type" :key="item.value" :label="item.label"
							:value="item.label">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="活动状态:" class="ttsalary" prop="state">
					<el-select v-model="activityData.activityState" placeholder="请输入活动状态">
						<el-option v-if="state!=null" v-for="item in state" :key="item.value" :label="item.label"
							:value="item.label">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="计划成本:" class="ttsalary" prop="planCost">
					<el-input v-model="formInline.address" placeholder="请输入计划成本"></el-input>
				</el-form-item>
				<el-form-item label="实际成本:" class="ttsalary" prop="relityCost">
					<el-input v-model="formInline.address" placeholder="请输入实际成本"></el-input>
				</el-form-item>
				<el-form-item label="计划收入:" class="ttsalary" prop="planIncome">
					<el-input v-model="formInline.address" placeholder="请输入计划收入"></el-input>
				</el-form-item>
				<el-form-item label="实际收入:" class="ttsalary" prop="relityIncome">
					<el-input v-model="formInline.address" placeholder="请输入实际收入"></el-input>
				</el-form-item>
				<el-form-item label="活动计划:" class="ttsalary" prop="plan">
					<el-input v-model="formInline.address" placeholder="请输入活动计划"></el-input>
				</el-form-item>
				<el-form-item class="button">
					<el-button type="primary" @click="submitForm('formInline')">提交</el-button>
					<el-button @click="resetForm()">重置</el-button>
				</el-form-item>
			</el-form>
		</div>
	</el-drawer>
	<!-- 表格 -->
	<el-table :data="activityData" style="width: 100%">
		<el-table-column prop="activityName" label="活动名称" width="150" />
		<el-table-column prop="users.usersName" label="负责人" />
		<el-table-column prop="depts.deptName" label="所属团队" width="150"/>
		<el-table-column prop="activityStart" label="开始时间" width="150" />
		<el-table-column prop="activityOver" label="结束时间" width="150" />
		<el-table-column prop="activityAddress" label="活动地址" width="150" />
		<el-table-column prop="activityType" label="活动类型" />
		<el-table-column prop="activityState" label="活动状态" />
		<el-table-column prop="activityPlanCost" label="计划成本" />
		<el-table-column prop="activityRealityCost" label="实际成本" />
		<el-table-column prop="activityPlan" label="实际收入" />
		<el-table-column prop="activityPlanIncome" label="计划收入" />
		<el-table-column prop="activityRealityIncome" label="活动计划" />
	</el-table>
	<!-- 分页 -->
	<el-pagination :current-page="pageNo" @current-change="getActivityData" background
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
				activityData: [], //市场活动
				users: { //员工表
					usersId: '', //员工id
					usersName: '', //员姓名
					deptId: '' //部门id
				},
				depts: { //部门表
					deptId: '', //部门id
					deptName: '' //部门名称
				},
				activity: {
					activityName: '',
					activityAddress: '',
					pageNo: 1,
					size: 3
				},
				state: [
					{
						value: '选项1',
						label: '已计划'
					},
					{
						value: '选项2',
						label: '进行中'
					},
					{
						value: '选项3',
						label: '已结束'
					},
					{
						value: '选项4',
						label: '意外终止'
					}
				],
				type :[
					{
					value: '选项1',
					label: '线上营销'
				},{
					value: '选项2',
					label: '线下营销'
				},
				{
					value: '选项1',
					label: '关系维护'
				},{
					value: '选项2',
					label: '联合促销'
				},
				{
					value: '选项1',
					label: '其他机会'
				},{
					value: '选项2',
					label: '会研商讨'
				}
				],
				formInline: {},
				rules: {
					name: [{
						required: true,
						message: '请输入活动名称',
						trigger: 'blur'
					}, ],
					user: [{
						required: true,
						message: '请输入负责人员',
						trigger: 'blur'
					}, ],
					value1: [{
						required: true,
						message: '请输入开始时间',
						trigger: 'blur'
					}, ],
					value2: [{
						required: true,
						message: '请输入结束时间',
						trigger: 'blur'
					}, ],
					address: [{
						required: true,
						message: '请输入活动地址',
						trigger: 'blur'
					}, ],
					type: [{
						required: true,
						message: '请选择活动类型',
						trigger: 'blur'
					}, ],
					state: [{
						required: true,
						message: '请选择活动状态',
						trigger: 'blur'
					}, ],

				},
			}
		},
		methods: {
			dealDisabledDate(time) {
				return time.getTime() <= Date.now() - 24 * 60 * 60 * 1000;
			},
			//重置
			resetForm() {
				this.formInline = {};
			},
			getActivityData(no) {
				this.activity.activityName = this.input;
				this.activity.activityAddress = this.input;
				if (no == undefined) {
					no = this.pageNo
				}
				this.activityData.pageNo = no;
				this.activityData.size = this.size;
				this.axios.post(
					"activity/seActivity",
					this.activity
				).then(res => {
					console.log(res);
					this.activityData = res.obj.list;
					this.total = res.obj.total;
				})

			},
			getInActivity(row) {
				this.axios.post('activity/inActivity', this.activity).then((x) => {
					if (x.code == 1) {
						
						
					} else {


					}
					this.getActivityData();
				});
			}
		},
		created() {
			this.getActivityData();

		}
	}
</script>

<style>
	#gap {
		margin-top: 10px;
		margin-left: 10px;
	}

	.ttsalary {
		width: 82%;
	}

	.big {
		margin-top: 15px;
		margin-left: 13%;
		width: 80%;
		/* box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); */
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
