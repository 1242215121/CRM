<template>
  <el-table :data="ActivityData" style="width: 100%">
	<el-table-column prop="activityName" label="活动名称" />
	<el-table-column prop="users.usersName" label="负责人" />
	<el-table-column prop="users.deptId.deptName" label="所属团队" />
	<el-table-column prop="activityStart" label="开始时间"/>
	<el-table-column prop="activityOver" label="结束时间"/>
	<el-table-column prop="activityAddress" label="活动地址" />
	<el-table-column prop="activityType" label="活动类型"/>
	<el-table-column prop="activityState" label="活动状态"/>
	<el-table-column prop="activityPlanCost" label="计划成本" />
	<el-table-column prop="activityRealityCost" label="实际成本" />
	<el-table-column prop="activityPlan" label="实际收入"  />
	<el-table-column prop="activityPlanIncome" label="计划收入" />
	<el-table-column prop="activityRealityIncome" label="活动计划" />
  </el-table>
</template>
	



<script>
export default {
  data() {
	return {
	  ActivityData: [],//市场活动
	  users:{//员工表
		 usersId:'',//员工id
		 usersName:'',//员姓名
		 deptId:''//部门id
	  }
	}
  },
  methods:{
	 getActivityData(){
		  this.axios("activity/seActivity").then((h) => {
			  console.log(h);
			  this.ActivityData=h;
		  }).catch(function(){
			  
		  })
	  }
  },
  created(){
	 this.getActivityData();
  }
}
</script>

<style>
</style>
