<template>
	<div id="gap">
		<el-row>
			<el-col :span="5">
				<el-input placeholder="活动名称/负责人/地址" v-model="input">
				</el-input>
			</el-col>
			<el-col :span="4" :push="1">
				<el-button type="primary" size="medium">查询</el-button>
			</el-col>
			<el-col :span="4" :push="11">
				<el-button type="primary" size="medium" @click="dialog = true">新增</el-button>
			</el-col>
		</el-row>
	</div>
	<el-dialog title="新建活动" width="450px" v-model="dialog">
      <h1>hhhhh</h1>
	</el-dialog>
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
				dialog: false,
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
				}
			}
		},
		methods: {
			getActivityData(no) {
				if (no == undefined) {
					no = this.pageNo
				}
				this.axios({
					url: "activity/seActivity",
					params: {
						pageNo: no,
						size: this.size
					}
				}).then((h) => {
					this.activityData = h.list;
					this.total = h.total;
					console.log('hhhhh', h.data.list)
				}).catch(function() {
					
				})
			}
		},
		created() {
			this.getActivityData(this.pageNo);
		}
	}
</script>

<style>
	#gap {
		margin-top: 10px;
		margin-left: 10px;
	}
</style>
