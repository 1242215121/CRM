
<template>
<el-card style="margin: 20px;min-height: 500px;">
	<div style="text-align: center;margin: 10px;">
		<el-button @click="addDept()" type="primary">新增部门</el-button>
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
    </el-table>
	
	<div class="block" style="text-align: center; margin: 10px;">
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page=pageNo
			:page-sizes="[5,8,10,15]" :page-size=pageSize layout="total, sizes, prev, pager, next, jumper"
			:total=total>
		 </el-pagination>
	</div>
    
  </el-card>
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
				$this.dept=res.obj.list;
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
