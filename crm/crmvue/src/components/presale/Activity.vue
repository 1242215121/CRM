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
			<el-form :model="activitys" ref="activitys" :rules="rules">
				<el-form-item label="活动名称:" class="ttsalary" prop="activityName">
					<el-input v-model="activitys.activityName" placeholder="请输入活动名称"></el-input>
				</el-form-item>
				<el-form-item label="负责人员:" class="ttsalary" prop="usersName">
					<el-select v-model="activitys.usersName" placeholder="请输入负责人员">
						<el-option v-if="userse!=null" v-for="u in userse" :key="u.usersId"
							:label="u.usersName" :value="u.usersId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="开始时间:" class="ttsalary" prop="activityStart">
					<div class="block">
						<el-date-picker v-model="activitys.activityStart" type="datetime"
							:disabledDate="dealDisabledDate" placeholder="请选择时间">
						</el-date-picker>
					</div>
				</el-form-item>
				<el-form-item label="结束时间:" class="ttsalary" prop="activityOver">
					<div class="block">
						<el-date-picker v-model="activitys.activityOver" type="datetime"
							:disabledDate="dealDisabledDate" placeholder="请选择时间">
						</el-date-picker>
					</div>
				</el-form-item>
				<el-form-item label="活动类型:" class="ttsalary" prop="activityType">
					<el-select v-model="activitys.activityType" placeholder="请输入活动类型">
						<el-option v-if="type!=null" v-for="item in type" :key="item.value" :label="item.label"
							:value="item.label">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="活动状态:" class="ttsalary" prop="activityState">
					<el-select v-model="activitys.activityState" placeholder="请输入活动状态">
						<el-option v-if="state!=null" v-for="item in state" :key="item.value" :label="item.label"
							:value="item.label">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="活动地址:" class="ttsalary" prop="avtivityAddress">
					<el-input v-model="activitys.avtivityAddress" placeholder="请输入活动地址"></el-input>
				</el-form-item>
				<el-form-item label="计划成本:" class="ttsalary" prop="activityPlanCost">
					<el-input v-model="activitys.activityPlanCost" placeholder="请输入计划成本"></el-input>
				</el-form-item>
				<el-form-item label="实际成本:" class="ttsalary" prop="activityRealityCost">
					<el-input v-model="activitys.activityRealityCost" placeholder="请输入实际成本"></el-input>
				</el-form-item>
				<el-form-item label="计划收入:" class="ttsalary" prop="activityPlanIncome">
					<el-input v-model="activitys.activityPlanIncome" placeholder="请输入计划收入"></el-input>
				</el-form-item>
				<el-form-item label="实际收入:" class="ttsalary" prop="activityRealityIncome">
					<el-input v-model="activitys.activityRealityIncome" placeholder="请输入实际收入"></el-input>
				</el-form-item>
				<el-form-item label="活动计划:" class="ttsalary" prop="activityPlan">
					<el-input v-model="activitys.activityPlan" placeholder="请输入活动计划"></el-input>
				</el-form-item>
				<el-form-item class="button">
					<el-button type="primary" @click="getInActivity('activitys')">提交</el-button>
					<el-button @click="resetForm()">重置</el-button>
				</el-form-item>
			</el-form>
		</div>
	</el-drawer>
	<!-- 表格 -->
	<el-table :data="activityData" style="width: 100%">
		<el-table-column prop="activityName" label="活动名称" width="150" />
		<el-table-column prop="users.usersName" label="负责人" />
		<el-table-column prop="depts.deptName" label="所属团队" width="150" />
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
				size: 5,
				total: 0,
				input: '',
				userse: [], //负责人
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
				activity: { //查询
					activityName: '',
					activityAddress: '',
					pageNo: 1,
					size: 5
				},
				state: [{
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
				type: [{
						value: '选项1',
						label: '线上营销'
					}, {
						value: '选项2',
						label: '线下营销'
					},
					{
						value: '选项1',
						label: '关系维护'
					}, {
						value: '选项2',
						label: '联合促销'
					},
					{
						value: '选项1',
						label: '其他机会'
					}, {
						value: '选项2',
						label: '会研商讨'
					}
				],
				activitys: {
					activityName: ''
				},
				rules: {
					activityName: [{
						required: true,
						message: '请输入活动名称',
						trigger: 'blur'
					}, ],
					usersName: [{
						required: true,
						message: '请输入负责人员',
						trigger: 'blur'
					}, ],
					activityStart: [{
						required: true,
						message: '请输入开始时间',
						trigger: 'blur'
					}, ],
					activityOver: [{
						required: true,
						message: '请输入结束时间',
						trigger: 'blur'
					}, ],
					avtivityAddress: [{
						required: true,
						message: '请输入活动地址',
						trigger: 'blur'
					}, ],
					activityType: [{
						required: true,
						message: '请选择活动类型',
						trigger: 'blur'
					}, ],
					activityState: [{
						required: true,
						message: '请选择活动状态',
						trigger: 'blur'
					}, ],

				},
			}
		},
		methods: {
			loadUser() {
				let $this = this;
				this.axios.get("/users").then(res => {
					console.log("负责人:",res);
					$this.userse = res.data;
				})
			},
			dealDisabledDate(time) {
				return time.getTime() <= Date.now() - 24 * 60 * 60 * 1000;
			},
			//重置
			resetForm() {
				this.activitys = {};
			},
			getActivityData(no) {
				this.activity.activityName = this.input;
				this.activity.activityAddress = this.input;
				if (no == undefined) {
					no = this.pageNo
				}
				this.activity.pageNo = no;
				this.activity.size = this.size;
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
				var $this=this;
				this.axios.post('activity/inActivity', this.activitys).then((x) => {
					if (x.code == 1) {
						ElMessage({
							message: "活动新增成功!",
							type: 'success'
						});
						$this.drawer = false;
						$this.getActivityData();
					} else {
						ElMessage({
							message: x.msg,
							type: 'erro'
						});
					}
				})

			}

		},
		created() {
			this.getActivityData();
			this.loadUser();
			
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
