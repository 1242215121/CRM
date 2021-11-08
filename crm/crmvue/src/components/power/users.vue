<template>
	<div style="padding: 20px;">

		<div>

			<el-form :model="ruleForm" size="mini" ref="ruleForm" label-width="60px" class="demo-ruleForm">
				<table>
					<tr>
						<td>
							<el-form-item label="姓名" prop="usersName" >
								<el-input v-model="ruleForm.usersName"  @change="loadData()" placeholder="输入名字回车查询" @keyup.enter="loadData()"></el-input>
							</el-form-item>
						</td>
						<td>
							<el-form-item label="部门" prop="deptId">
								<el-select v-model="ruleForm.deptId" @change="loadData()">
									<el-option label="全部" value="0"></el-option>
									<el-option v-for="v in dept" :label="v.deptName" :key="v.deptId" :value="v.deptId" >
										
									</el-option>
								</el-select>
							</el-form-item>
						</td>
						<td>
							<el-form-item label="职位" prop="ajobId">
								<el-select v-model="ruleForm.ajobId" @change="loadData()">
									<el-option label="全部" value="0"></el-option>
									<el-option v-for="v in ajob" :label="v.ajobName" :key="v.ajobId" :value="v.ajobId" >
										
									</el-option>
								</el-select>
							</el-form-item>
						</td>
						<td>
							<el-form-item label="状态" prop="state">
								<el-select v-model="ruleForm.state" @change="loadData()">
									<el-option label="全部" value="2"></el-option>
									<el-option label="启用" value="1"></el-option>
									<el-option label="停用" value="0"></el-option>
								</el-select>
							</el-form-item>
						</td>
						
						<td>
							<el-form-item>
								<!-- <el-button type="primary" size="mini" @click="submitForm('ruleForm')">查询</el-button> -->
								<el-button type="primary" size="mini" @click="addUsers()">新增</el-button>
							</el-form-item>
						</td>
					</tr>
				</table>
			</el-form>


		</div>

		<el-table :data="tableData" style="width: 100%">
			<el-table-column label="用户编号" width="80" align="center" header-align="center">
				<template #default="scope">
					<span style="margin-left: 10px">{{ scope.row.usersId }}</span>
				</template>
			</el-table-column>
			<el-table-column label="用户名" width="120" align="center" header-align="center">
				<template #default="scope">
					<span style="margin-left: 10px">{{ scope.row.usersName }}</span>
				</template>
			</el-table-column>
			<el-table-column label="姓名" width="100" align="center" header-align="center">
				<template #default="scope">
					<span style="margin-left: 10px">{{ scope.row.usersFullname }}</span>
				</template>
			</el-table-column>
			<el-table-column label="电话" width="160" align="center" header-align="center">
				<template #default="scope">
					<i class="el-icon-phone"></i>
      
					<span style="margin-left: 10px">{{ scope.row.usersPhone }}</span>
				</template>
			</el-table-column>
			<el-table-column label="所属部门" width="180" align="center" header-align="center">
				<template #default="scope">
					<span style="margin-left: 10px" v-if="scope.row.dept">{{ scope.row.dept.deptName }}</span>
				</template>
			</el-table-column>
			<el-table-column label="所属职位" width="100" align="center" header-align="center">
				<template #default="scope">
					<span style="margin-left: 10px" v-if="scope.row.ajob">{{ scope.row.ajob.ajobName }}</span>
				</template>
			</el-table-column>
			<el-table-column label="用户状态" width="200" align="center" header-align="center">
				<template #default="scope">
					<el-switch
					  style="display: block"
					  v-model="scope.row.flag"
					  active-color="#13ce66"
					  inactive-color="#ff4949"
					  active-text="启用"
					  inactive-text="停用"
					  @change="updateState(scope.row.usersId,scope.row.flag?1:0)"
					>
					</el-switch>
				</template>
			</el-table-column>
		
			<el-table-column label="操作" width="160" align="center" header-align="center">
				<template #default="scope">

							<div class="name-wrapper">
								<el-tag type="info" size="medium" style="margin-right: 10px;" @click="rowClick(scope.row,1)">查看</el-tag>
								<el-tag type="success" v-if="scope.row.flag" size="medium" style="margin-right: 10px;" @click="rowClick(scope.row,2)">编辑</el-tag>
							</div>
							
					
				</template>
			</el-table-column>
		</el-table>

		<div class="block" style="text-align: center; margin: 10px;">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page=pageNo
				:page-sizes="[5,8,10,15]" :page-size=pageSize layout="total, sizes, prev, pager, next, jumper"
				:total=total>
			 </el-pagination>
		</div>

	</div>
</template>

<script>
	export default {
		data() {
			return {
				tableData: [],
				total: 0,
				pageSize: 5,
				pageNo: 1,
				ruleForm: {
					usersName: '',
					ajobId:'0' ,
					deptId:'0',
					state:'2'
				},
				ajob:[],
				dept:[]
			}
		},
		methods: {
			handleEdit(index, row) {
				console.log(index, row);
			},
			handleDelete(index, row) {
				console.log(index, row);
			},
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				this.pageNo = 1;
				this.pageSize = val;
				this.loadData();
			},
			handleCurrentChange(val) {
				this.pageNo = val;
				console.log(`当前页: ${val}`);
				this.loadData();
			},
			submitForm(formName) {
				this.loadData();
				console.log(formName);
			},
			updateState(uid,sta){
				this.axios.get("/users/updateState",{
						params: {
							usersid: uid,
							state: sta
						}
					}).then(res=>{
						if(res.code == 1){
							this.$message.success("修改成功！");
							this.loadData();
					}
				})
			},
			//查询绑值
			loadData() {
				
				var $this = this;
				
				this.axios.post("/users/allpage", {
					pageNo: $this.pageNo,
					pageSize: $this.pageSize,
					name: $this.ruleForm.usersName,
					ajobid:$this.ruleForm.ajobId,
					deptid:$this.ruleForm.deptId,
					state:$this.ruleForm.state
				}).then(res => {
					console.log(res, "后台返回的数据");
					this.tableData = res.obj.list; //返回的是封装好的MyResult对象。data存储的是集合
					this.tableData.forEach(v=>{
						if(v.state==1){
							v.flag=true;
						}else{
							v.flag=false;
						}
					})
					this.total = res.obj.total;
				})
			},
			addUsers(){
				this.$router.push("usersfrom");
			},
			rowClick(row,i) {
				console.log('点击了某一行', row);
				this.$router.push({
					name: "usersfrom",
					params: {
						usersId: row.usersId,
						edit:i
					}
				});
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
		created() {
	
			this.lodeDept();
			this.loadData();
			this.loadAjob();
		}
	}
</script>

<style>

</style>
