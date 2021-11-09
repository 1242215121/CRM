<template>
	<el-card style="margin: 10px;">
		<div style="width: 200px;text-align: center;margin: auto;font-size: 28px;border-bottom: #C0C0C0 1px solid;">
			权限管理
			<span style="width: 140px;display: block;border-bottom: 1px sandybrown solid;margin:5px auto;"></span>
		</div>
		<el-row v-for="r in role" style="border-bottom: 1px solid silver;margin-bottom: 20px;">
			<el-col :span="24" style="margin: 2px;font-style: italic;font-size: 20px;">
				{{r.roleName}}
				
			</el-col>
			<el-col :span="24" style="margin: 2px;padding-left: 10px;font-size: 12px;">
				{{r.roleDesc}}
			</el-col>
			<el-col :span="24" style="margin: 2px;">
				关联用户
				<div style="margin: 10px 0px;">
					<el-row>
						<el-col v-for="u in r.usersRole" :span="2" style="text-align: center;">
							<div>
								<!-- <img
								        :src="'../../'+o.empFileImg"
								        class="image"
								/> -->
								<img
										v-if="u.users.usersImgs"
								        :src="'../../'+u.users.usersImgs"
								        class="image"
								/>
								<img
										v-if="!u.users.usersImgs"
								        :src="'../../public/imgs/wjl.jpg'"
								        class="image"
								/>
								<el-tag type="success">{{u.users.usersFullname}}</el-tag>
							</div>
						</el-col>
						<el-button
						title="添加用户"
						@click="setRoleId(r.roleId)"
						class="btn">
							+
							</el-button>
						<el-button 
						title="删除用户"
						class="btn">
							-
							</el-button>
					</el-row>
				</div>
			</el-col>
			<el-col :span="24" style="margin: 10px;">
				关联模块
				<div style="margin: 10px 0px;">
				<el-row>
					<el-col v-for="m in r.roleModule" :span="2" style="text-align: center;">
						<div>
							<i :class="m.module.moduleIcon" style="width: 80px;height: 80px;"></i>
							<el-tag>{{m.module.moduleName}}</el-tag>
						</div>
					</el-col>
					<el-button
					title="添加模块"
					@click="addModule(r.roleId)"
					class="btn">
						+
						</el-button>
					<el-button 
					title="删除模块"
					class="btn">
						-
						</el-button>
				</el-row>	
			
				</div>
			</el-col>
		</el-row>
	</el-card>
	
	<el-drawer title="消息通知" size="45%;" v-model="drawer" :direction="direction"
		:before-close="newshandleClose" destroy-on-close>
		
	<el-table :data="tableData" size="mini" style="width: 100%">
		<el-table-column label="用户编号" width="80" align="center" header-align="center">
			<template #default="scope">
				<span style="margin-left: 10px">{{ scope.row.usersId }}</span>
			</template>
		</el-table-column>
		<el-table-column label="姓名" width="100" align="center" header-align="center">
			<template #default="scope">
				<span style="margin-left: 10px">{{ scope.row.usersFullname }}</span>
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
	
		<el-table-column label="操作" width="160" align="center" header-align="center">
			<template #default="scope">

				<div class="name-wrapper">
					<el-tag type="success" size="medium" style="margin-right: 10px;" @click="addUsers(scope.row.usersId)">添加</el-tag>
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
		
	</el-drawer>
</template>

<script>
	 export default {
	   data() {
	     return {
	       role:[],
		   tableData: [],
		   total: 0,
		   pageSize: 5,
		   pageNo: 1,
		   roleid:'',
		   drawer: false,
		   direction: 'rtl',
	     }
	   },
	   methods: {
	 		lodeRole(){
	 			var $this=this;
	 			this.axios.get("/role/all").then(res=>{
	 				console.log("查询到的角色",res.data)
	 				$this.role=res.data;
	 				
	 			})
	 		},
			setRoleId(rid){
				this.roleid=rid;
				this.drawer=true;
			},
			addUsers(uid){
				var $this=this;
				this.axios.post("/role/usersRole",{
					users:{
						usersId:uid
					},
					role:{
						roleId:$this.roleid
					}
				}).then(res=>{
					console.log("查询到的角色",res)
					if(res.code==1){
						this.$message.success("添加成功！");
					}
					//关闭抽屉
					this.drawer=false;
					//重新加载数据
					this.lodeRole();
				})
			},
			addModule(mid){
				
			},
			//查询绑值
			loadData() {
				
				var $this = this;
				
				this.axios.post("/users/allpage", {
					pageNo: $this.pageNo,
					pageSize: $this.pageSize
				}).then(res => {
					console.log(res, "后台返回的数据");
					this.tableData = res.obj.list; //返回的是封装好的MyResult对象。data存储的是集合
					this.total = res.obj.total;
				})
			},
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
			newshandleClose(done) {
				this.$confirm('确认关闭？')
					.then(_ => {
						done();
					})
					.catch(_ => {});
			},
	   },
	   created(){
	 		this.lodeRole();
			this.loadData();
	 	},
	}
</script>

<style scoped="scoped">
	.btn{
		font-size: 40px;
		width: 80px;
		height: 80px;
		margin: 10px;
	}
	img{
		width: 80px;
		height: 80px;
	}
	.el-icon-setting:before {
	    font-size: 60px;
		color: coral;
	}
	.el-icon-menu:before {
	    font-size: 60px;
		color: seagreen;
	}
	.el-icon-edit-outline:before {
	    font-size: 60px;
		color: cornflowerblue;
	}
	.el-icon-location:before {
	    font-size: 60px;
		color: lightsalmon;
	}
	.el-icon-document:before {
	    font-size: 60px;
		color: crimson;
	}
</style>
