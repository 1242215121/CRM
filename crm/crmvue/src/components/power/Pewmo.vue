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
</template>

<script>
	 export default {
	   data() {
	     return {
	       role:[]
	     }
	   },
	   methods: {
	 		lodeDate(){
	 			var $this=this;
	 			this.axios.get("/role/all").then(res=>{
	 				console.log("查询到的角色",res.data)
	 				$this.role=res.data;
	 				
	 			})
	 		}
	   },
	   created(){
	 		this.lodeDate();
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
