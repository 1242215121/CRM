
<template>
<el-card style="margin: 20px;min-height: 500px;">
	<div style="text-align: center;margin: 10px;">
		<el-button @click="dialogFormVisible=true,addDept=true,approveform=[]" type="primary">新增部门</el-button>
		<el-button @click="dialogFormVisible2=true,addAjob=true,approveform2=[]" type="primary">新增职位</el-button>
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
		  <template #default="scope">
		  	<el-tag type="info" style="border-radius: 50%;" v-if="scope.row.ajobs">{{scope.row.date}}</el-tag>
		  </template>
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
				  <el-button type="warning" @click="updateDiy(scope.row)">编辑</el-button>
	  		  	 <el-button type="danger" @click="delectDiy(scope.row)">删除</el-button>
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
  
  <el-dialog :title="addDept?'新增部门':'修改部门'" v-model="dialogFormVisible">
  	<el-form :model="approveform" ref="approveform" :rules="approverules">
  		<el-row>
  			<el-col :span="12">
  				<div class="grid-content bg-purple-dark">
  					<el-form-item  label="部门名称" prop="deptName" label-width="80px">
  						<el-input v-model="approveform.deptName"></el-input>
  					</el-form-item>
  				</div>
  			</el-col>
  			<el-col :span="12">
  				<div class="grid-content bg-purple-dark">
  					<el-form-item  label="部门描述" prop="deptDesc" label-width="80px">
  						<el-input v-model="approveform.deptDesc"></el-input>
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
  
  <el-dialog :title="addAjob?'新增职位':'修改职位'" v-model="dialogFormVisible2">
  	<el-form :model="approveform2" ref="approveform2" :rules="approverules2">
  		<el-row>
  			<el-col :span="8">
  				<div class="grid-content bg-purple-dark">
  					<el-form-item required label="职位名称" prop="ajobName" label-width="80px">
  						<el-input v-model="approveform2.ajobName"></el-input>
  					</el-form-item>
  				</div>
  			</el-col>
  			<el-col :span="8">
  				<div class="grid-content bg-purple-dark">
  					<el-form-item required label="职位描述" prop="ajobDesc" label-width="80px">
  						<el-input v-model="approveform2.ajobDesc"></el-input>
  					</el-form-item>
  				</div>
  			</el-col>
			<el-col :span="8">
				<div class="grid-content bg-purple-dark">
					<el-form-item required label="所属部门" label-width="80px">
						<el-select  v-model="mydeptid">
							<el-option v-for="v in depts" :label="v.deptName" :key="v.deptId" :value="v.deptId" >
						
							</el-option>
						</el-select>
					</el-form-item>
				</div>
			</el-col>
  		</el-row>
  
  	</el-form>
  	<template #footer>
  		<span class="dialog-footer">
  			<el-button @click="dialogFormVisible2 = false">取 消</el-button>
  			<el-button type="primary" @click="subapprove2('approveform2')">确 定</el-button>
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
		total: 0,
		pageSize: 5,
		pageNo: 1,
        tableData: [],
		dept:[],
		depts:[],
		mydeptid:'',
		dialogFormVisible: false,
		dialogFormVisible2: false,
		addDept:true,
		addAjob:true,
		approveform: {
			deptId:'',
			deptName:'',
			deptDesc:''
		},
		approverules: {
			deptName: [{
					required: true,
					message: '请输入部门名称',
					trigger: 'blur'
				},
				{
					min: 2,
					max: 8,
					message: '长度在 2 到 8 个字符',
					trigger: 'blur'
				}
			],
			deptDesc: [{
					required: true,
					message: '请输入部门描述',
					trigger: 'blur'
				},
				{
					min: 6,
					max: 20,
					message: '长度在 6 到 20 个字符',
					trigger: 'blur'
				}
			],
		},
		approveform2: {
			ajobId:'',
			ajobName:'',
			ajobDesc:''
		},
		approverules2: {
			ajobName: [{
					required: true,
					message: '请输入职位名称',
					trigger: 'blur'
				},
				{
					min: 2,
					max: 8,
					message: '长度在 2 到 8 个字符',
					trigger: 'blur'
				}
			],
			ajobDesc: [{
					required: true,
					message: '请输入职位描述',
					trigger: 'blur'
				},
				{
					min: 6,
					max: 20,
					message: '长度在 6 到 20 个字符',
					trigger: 'blur'
				}
			],
		},
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
							datasub.date=j.ajobId;
							datasub.name=j.ajobName;
							datasub.address=j.ajobDesc;
							datasuper.children.push(datasub);
						})
					}
					$this.tableData.push(datasuper);
				})
			})
		},

		delectDiy(row){
			// dialogFormVisible=true,addDept=true
			if(row.children){
				this.axios.get("/dept/delete",{
					params:{
						did:row.date
					}
				}).then(res=>{
					if(res.code==1){
						this.$message.success("删除成功！");
						//重新绑定表格数据
						$this.loadData();
						$this.lodeDept();
					}
				})
			}else{
				this.axios.get("/ajob/delete",{
					params:{
						ajobid:row.date
					}
				}).then(res=>{
					if(res.code==1){
						this.$message.success("删除成功！");
						//重新绑定表格数据
						$this.loadData();
						$this.lodeDept();
					}
				})
			}

		},
		updateDiy(row){
			// dialogFormVisible=true,addDept=true
			if(row.children){
				//绑值
				this.approveform.deptId=row.date;
				this.approveform.deptName=row.name;
				this.approveform.deptDesc=row.address;
				this.dialogFormVisible=true
				this.addDept=false;
			}else{
				// this.approveform2.ajobDesc
				this.approveform2.ajobId=row.date;
				this.approveform2.ajobName=row.name;
				this.approveform2.ajobDesc=row.address;
				this.dialogFormVisible2=true
				this.addAjob=false;
			}

		},
		subapprove(formName){
			var $this=this;
			this.$refs[formName].validate((valid) => {
			
				if (valid) {
					//新增部门
					if($this.addDept){
						this.axios.post("/dept/add",{
							deptId:$this.approveform.deptId,
							deptName:$this.approveform.deptName,
							deptDesc:$this.approveform.deptDesc
						}).then(res=>{
							console.log("后台返回的结果",res)
							if(res.code==1){
								this.$message.success("新增成功！");
								//关闭弹框
								$this.dialogFormVisible=false;
								//重新绑定表格数据
								$this.loadData();
								$this.lodeDept();
							}else if(res.msg=="部门已存在!"){
								//清空输入框
								this.approveform.deptName='';
							}
							
							
						})
					}else{
					//修改部门
						
						this.axios.post("/dept/update",{
							deptId:$this.approveform.deptId,
							deptName:$this.approveform.deptName,
							deptDesc:$this.approveform.deptDesc
						}).then(res=>{
							console.log("后台返回的结果",res)
							if(res.code==1){
								this.$message.success("修改成功！");
								//关闭弹框
								$this.dialogFormVisible=false;
								//重新绑定表格数据
								$this.loadData();
								$this.lodeDept();
							}else if(res.msg=="部门名称已存在!"){
								//清空输入框
								this.approveform.deptName='';
							}
							
						})
					}
				}
			})
		
			
		},
		subapprove2(formName){
			var $this=this;
			this.$refs[formName].validate((valid) => {
				if (valid) {
					//新增职位
					if($this.addAjob){
						this.axios.post("/ajob/add",{
							ajobId:$this.approveform2.ajobId,
							ajobName:$this.approveform2.ajobName,
							ajobDesc:$this.approveform2.ajobDesc,
							dept:{
								deptId:$this.mydeptid
							}
						}).then(res=>{
							console.log("后台返回的结果",res)
							if(res.code==1){
								this.$message.success("新增成功！");
								//关闭弹框
								$this.dialogFormVisible2=false;
								//重新绑定表格数据
								$this.loadData();
								$this.lodeDept();
							}else if(res.msg=="该部门下已有该职位，新增失败!"){
								//清空输入框
								this.approveform2.ajobName='';
							}
							
						})
					}else{
					//修改职位
						this.axios.post("/ajob/update",{
							ajobId:$this.approveform2.ajobId,
							ajobName:$this.approveform2.ajobName,
							ajobDesc:$this.approveform2.ajobDesc,
							dept:{
								deptId:$this.deptid
							}
						}).then(res=>{
							console.log("后台返回的结果",res)
							if(res.code==1){
								this.$message.success("修改成功！");
								//关闭弹框
								$this.dialogFormVisible2=false;
								//重新绑定表格数据
								$this.loadData();
								$this.lodeDept();
							}else if(res.msg=="该部门下已有该职位，修改失败!"){
								//清空输入框
								this.approveform2.ajobName='';
							}
							
						})
					}
				}
			})
		
		},
		//绑定部门
		lodeDept(){
				
			var $this=this;
			this.axios.get("/dept/all").then(res=>{
				
				$this.depts=res.data;
				console.log("查询到的部门$this.dept",$this.depts)
			})
		},
    },
	created(){
		this.loadData();
		this.loadAjob();
		this.lodeDept();
	}
  }
</script>

<style>

</style>

 