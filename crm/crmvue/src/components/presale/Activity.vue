<template>
	<div id="gap">
		<el-row>
			<el-col :span="5">
				<el-input placeholder="活动名称/地址" v-model="input">
				</el-input>
			</el-col>
			<el-col :span="4" :push="1">
				<el-button type="primary" size="medium" @click="getActivityData()">查询</el-button>
			</el-col>
			<el-col :span="4" :push="11">
				<el-button type="primary" size="medium" @click="drawer=true">新增</el-button>
			</el-col>
		</el-row>
	</div>
	<el-drawer title="新增市场活动" v-model="drawer" :with-header="false" size="50%">
		<div class="big">
			<el-form>
				<el-form-item label="机会名称:" class="ttsalary">
					<el-input placeholder="请输入机会名称"></el-input>
				</el-form-item>
				<el-form-item label="机会金额:" class="ttsalary">
					<el-input placeholder="请输入机会金额"></el-input>
				</el-form-item>
				<!-- <el-form-item label="负责人员:" class="ttsalary" prop="">
					<el-select v-model="" placeholder="请输入负责人员">
						<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
							:label="o.oadeptName" :value="o.oadeptId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="所属客户:" class="ttsalary" prop="custom">
					<el-select v-model="formInline.custom" placeholder="请输入所属客户">
						<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
							:label="o.oadeptName" :value="o.oadeptId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="联系人员:" class="ttsalary" prop="person">
					<el-select v-model="formInline.person" placeholder="请输入联系人员">
						<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
							:label="o.oadeptName" :value="o.oadeptId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="关联活动:" class="ttsalary" prop="activity">
					<el-select v-model="formInline.activity" placeholder="请输入关联活动">
						<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
							:label="o.oadeptName" :value="o.oadeptId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="预成交日:" class="ttsalary" prop="value2">
					<div class="block">
						<el-date-picker v-model="formInline.value2" 
						type="datetime" :disabledDate="dealDisabledDate"
						placeholder="请选择时间">
						</el-date-picker>
					</div>
				</el-form-item> -->
				<el-form-item class="button">
					<el-button type="primary" @click="submitForm('formInline')">提交</el-button>
					<el-button @click="resetForm()">重置</el-button>
				</el-form-item>
			</el-form>
		</div>
	</el-drawer>
	<!-- 表格 -->
	<el-table :data="activityData" style="width: 100%">
		<el-table-column prop="activityName" label="活动名称" width="140" />
		<el-table-column prop="users.usersName" label="负责人" />
		<el-table-column prop="depts.deptName" label="所属团队" />
		<el-table-column prop="activityStart" label="开始时间" width="140" />
		<el-table-column prop="activityOver" label="结束时间" width="140" />
		<el-table-column prop="activityAddress" label="活动地址" width="140" />
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
				activity:{
					activityName:'',
					activityAddress:'',
					pageNo:1,
					size:3
				}
			}
		},
		methods: {
			getActivityData(no) {
				this.activity.activityName=this.input;
				this.activity.activityAddress=this.input;
				if (no == undefined) {
					no = this.pageNo
				}
				this.activityData.pageNo=no;
				this.activityData.size=this.size;
				this.axios.post(
					"activity/seActivity",
					this.activity
				).then(res => {
					console.log(res);
					this.activityData = res.obj.list;
					this.total = res.obj.total;
				})
				
			},
			
		
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
</style>
