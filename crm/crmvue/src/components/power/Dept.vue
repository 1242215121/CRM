
<template>
<el-card style="margin: 20px;min-height: 500px;">
	<div style="text-align: center;margin: 10px;">
		<el-button @click="addDept(),dialogFormVisible=true" type="primary">新增部门</el-button>
		<el-button @click="deleteDept()" type="primary">新增职位</el-button>
		<el-button @click="addAjob()" type="danger">删除部门</el-button>
		<el-button @click="deleteAjob()" type="danger">删除职位</el-button>
	</div>
    <el-table
      :data="tableData"
      style="width: 100%;margin-bottom: 20px;"
      row-key="id"
      border
      default-expand-all
      :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
    >
      <el-table-column prop="date" label="编号" sortable width="180">
      </el-table-column>
      <el-table-column prop="name" label="部门名称" sortable width="180">
      </el-table-column>
      <el-table-column prop="address" label="描述"> </el-table-column>
	  <el-table-column prop="ajobs" label="职位">
		  <template #default="scope">
		  	<el-tag v-if="scope.row.ajobs" v-for="v in scope.row.ajobs" style="margin-left: 10px">{{v.ajobName}}</el-tag>
		  </template>
	  </el-table-column>
	  <el-table-column label="操作">
	  		  <template #default="scope">
				  <el-button @click="updateDiy(scope.row.date)">编辑</el-button>
	  		  	 <el-button @click="delectDiy(scope.row.date)">删除</el-button>
	  		  </template>
	  </el-table-column>
    </el-table>
	
	<div class="block" style="text-align: center; margin: 10px;">
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page=pageNo
			:page-sizes="[5,8,10,15]" :page-size=pageSize layout="total, sizes, prev, pager, next, jumper"
			:total=total>
		 </el-pagination>
	</div>
    
  </el-card>
  
  <el-dialog title="新增部门" v-model="dialogFormVisible">
  	<el-form :model="approveform" ref="approveform" :rules="approverules">
  		<el-row>
  			<el-col :span="12">
  				<div class="grid-content bg-purple-dark">
  					<el-form-item required label="用户账号" label-width="80px">
  						<el-input v-model="userName"></el-input>
  					</el-form-item>
  				</div>
  			</el-col>
  			<el-col :span="12">
  				<div class="grid-content bg-purple-dark">
  					<el-form-item required label="用户密码" label-width="80px">
  						<el-input v-model="password"></el-input>
  					</el-form-item>
  				</div>
  			</el-col>
  		</el-row>
  
  	</el-form>
  	<template #footer>
  		<span class="dialog-footer">
  			<el-button @click="dialogFormVisible = false">取 消</el-button>
  			<el-button type="primary" @click="subapprove('approveform')">确 定</el-button>
  		</span>
  	</template>
  </el-dialog>
</template>

<script>
  export default {
    data() {
      return {
		ruleForm: {
			usersName: '',
			ajobId:'0' ,
			deptId:'0'
		},
		ajob:[],
		dept:[],  
		total: 0,
		pageSize: 5,
		pageNo: 1,
        tableData: [],
		dialogFormVisible: false,
		approveform: {
		},
		approverules: {},
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
		//绑定职位
		loadAjob(){
			
			var $this=this;
			this.axios.get("/ajob/all").then(res=>{
				console.log("查询到的职位",res.data)
				$this.ajob=res.data;
				
			})
		},
		loadData(){
			var $this=this;
			this.axios.post("/dept/allpage",{
				pageNo:$this.pageNo,
				pageSize:$this.pageSize
			}).then(res=>{
				console.log("查询到的部门",res.obj)
				$this.tableData=[];
				$this.dept=res.obj.list;
				$this.total=res.obj.total;
				$this.dept.forEach(v=>{
					var datasuper={}
					datasuper.date=v.deptId;
					datasuper.name=v.deptName;
					datasuper.address=v.deptDesc;
					datasuper.ajobs=v.ajobs;
					if(v.ajobs){
						datasuper.children=[];
						v.ajobs.forEach(j=>{
							var datasub={};
							datasub.date='';
							datasub.name=j.ajobName;
							datasub.address=j.ajobDesc;
							datasuper.children.push(datasub);
						})
					}
					$this.tableData.push(datasuper);
				})
			})
		},
		//新增部门
		addDept(){
			
		},
		//删除部门
		deleteDept(){
			
		},
		//新增职位
		addAjob(){
			
		},
		//删除职位
		deleteAjob(){
			
		},
		delectDiy(id){
			alert(id);
		}
		
    },
	created(){
		this.loadData();
		this.loadAjob();
	}
  }
</script>

<style>

</style>
