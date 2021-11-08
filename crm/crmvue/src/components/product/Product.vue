<template>
	<el-row style="margin-top: 20px;margin-left: 10px; ">
		<el-col :push="0" :span="3">
			<el-cascader v-model="proCon.proTypeId"
			style="width: 150px;"
			 :options="type" :props="{value:'typeId',label:'typeName',children:'types',checkStrictly: true,expandTrigger: 'hover'}" 
			 @change="handleChange1"
			 filterable
			 debounce
			 clearable
			 placeholder="产品类别"
			 :show-all-levels="false"></el-cascader>
			 
			
		</el-col>
		<el-col :span="3">
			<el-select v-model="proCon.proState"  placeholder="启用状态" style="width: 150px;" @change="getData()"  clearable >
			   <el-option
			     v-for="item in options"
			     :key="item.value"
			     :label="item.label"
			     :value="item.value">
			   </el-option>
			 </el-select>
		</el-col>
		<el-col :span="2">
			<el-select v-model="proCon.proInventoryState"  placeholder="库存状态" style="width: 150px;" @change="getData()" clearable  >
			   <el-option
			     v-for="item in options1"
			     :key="item.value"
			     :label="item.label"
			     :value="item.value">
			   </el-option>
			 </el-select>
		</el-col>
		<el-col :push="2" :span="8">
			<el-input style="width: 200px;" v-model="proCon.content"  @input="getData()" placeholder="请输入产品名称"></el-input>
		</el-col>		
		
		
		<el-col :push="2" :span="4">
			 <el-dropdown>
			   <el-button  >
			     属性设置<i class="el-icon-arrow-down el-icon--right"></i>
			   </el-button>
			   <template #dropdown>
			     <el-dropdown-menu>
			       <el-dropdown-item @click="typeProp()">产品类别</el-dropdown-item>
			       <el-dropdown-item>基准价</el-dropdown-item>
			       <el-dropdown-item>启用状态</el-dropdown-item>
			       <el-dropdown-item>负责人变更</el-dropdown-item>
			     </el-dropdown-menu>
			   </template>
			 </el-dropdown>
		</el-col>
		<el-col :push="2" :span="2">
			<el-button round @click="openPro()">新增产品</el-button>
		</el-col>
	</el-row>
	
	
	<el-tabs style="margin: 10px;">
	<el-tab-pane label="所有产品" >
		 <el-table
			:data="product.slice((pageNo-1)*pageSize,pageNo*pageSize)"
		    style="width: 100%"
			@row-click="dot"
			@selection-change="choose"
		  >
		    <el-table-column type="selection"    width="50" > </el-table-column>
		    <el-table-column prop="proId"    sortable  label="产品编号" width="115" ></el-table-column>
		    <el-table-column prop="proName" label="产品名称" width="100"> </el-table-column>
			<el-table-column prop="type.typeName" label="产品分类" > </el-table-column>		
			<el-table-column prop="proState" label="启用状态" > 
				<template #default="en">
					{{en.row.proState ==1 ? '启用' : '停用' }}
				</template>
			</el-table-column>
			<el-table-column prop="users.usersFullname" label="负责人" width="80"> </el-table-column>
			<el-table-column prop="proUnit" label="产品单位" width="80"> </el-table-column>
			<el-table-column prop="proPrice" label="基准价格" width="80"> </el-table-column>
			<el-table-column prop="proInventoryState" label="库存状态" width="80"> 
				<template #default="en">
					{{en.row.proInventoryState == 0 ? '正常' : (en.row.proInventoryState == 1 ? '零库存':'负库存') }}
				</template>
			</el-table-column>
			<el-table-column prop="proInventoryAmount" label="库存数量" width="80" > </el-table-column>
			<el-table-column prop="proInventoryUsable" label="可用库存" width="80"> </el-table-column>
			<el-table-column prop="proInventoryLock" label="锁定库存"  width="80"> </el-table-column>
			<el-table-column prop="proModel" label="产品型号" width="80"> </el-table-column>
			<el-table-column prop="proDescribe" label="产品描述" width="80">
				<template #default="scope">
					<el-popover effect="light" trigger="hover" placement="top">
					  <template #default>
						<p>{{ scope.row.proDescribe}}</p>
					  </template>
					  <template #reference>
						<div class="name-wrapper">
						  <el-tag size="medium">{{'描述'}}</el-tag>
						</div>
					  </template>
					</el-popover>
				</template>
			</el-table-column>
			<el-table-column prop="proDate" sortable  label="创建时间" width="140" > </el-table-column>
		  </el-table>
		  <!-- 分页器 -->
		  <div class="block" style="margin-top:15px;">
		  	<el-pagination align='center'
		  		background
		  		@size-change="handleSizeChange" 
		  		@current-change="handleCurrentChange" 
		  		:current-page="pageNo" 
		  		:page-sizes="[5,10,15]" 
		  		:page-size="pageSize" 
		  		layout="total, sizes, prev, pager, next, jumper" 
		  		:total="product.length">
		  	</el-pagination>
		  </div>
	</el-tab-pane>
	<el-tab-pane label="我负责的" >
		<el-table
			:data="MyProduct.slice((pageNo-1)*pageSize,pageNo*pageSize)"
		    style="width: 100%"
			@row-click="dot"
		 >
		   <el-table-column type="selection"    width="50" > </el-table-column>
		   <el-table-column prop="proId"    sortable  label="产品编号" width="115" ></el-table-column>
		   <el-table-column prop="proName" label="产品名称" width="100"> </el-table-column>
					<el-table-column prop="type.typeName" label="产品分类" > </el-table-column>		
					<el-table-column prop="proState" label="启用状态" > 
						<template #default="en">
							{{en.row.proState ==1 ? '启用' : '停用' }}
						</template>
					</el-table-column>
					<el-table-column prop="users.usersFullname" label="负责人" width="80"> </el-table-column>
					<el-table-column prop="proUnit" label="产品单位" width="80"> </el-table-column>
					<el-table-column prop="proPrice" label="基准价格" width="80"> </el-table-column>
					<el-table-column prop="proInventoryState" label="库存状态" width="80"> 
						<template #default="en">
							{{en.row.proInventoryState == 0 ? '正常' : (en.row.proInventoryState == 1 ? '零库存':'负库存') }}
						</template>
					</el-table-column>
					<el-table-column prop="proInventoryAmount" label="库存数量" width="80" > </el-table-column>
					<el-table-column prop="proInventoryUsable" label="可用库存" width="80"> </el-table-column>
					<el-table-column prop="proInventoryLock" label="锁定库存"  width="80"> </el-table-column>
					<el-table-column prop="proModel" label="产品型号" width="80"> </el-table-column>
					<el-table-column prop="proDescribe" label="产品描述" width="80">
						<template #default="scope">
							<el-popover effect="light" trigger="hover" placement="top">
							  <template #default>
								<p>{{ scope.row.proDescribe}}</p>
							  </template>
							  <template #reference>
								<div class="name-wrapper">
								  <el-tag size="medium">{{'描述'}}</el-tag>
								</div>
							  </template>
							</el-popover>
						</template>
					</el-table-column>
					<el-table-column prop="proDate" sortable  label="创建时间" width="140" > </el-table-column>
		 </el-table>
		 <!-- 分页器 -->
		  <div class="block" style="margin-top:15px;">
		  	<el-pagination align='center'
		  		background
		  		@size-change="handleSizeChange1" 
		  		@current-change="handleCurrentChange1" 
		  		:current-page="pageNos" 
		  		:page-sizes="[5,10,15]" 
		  		:page-size="pageSizes" 
		  		layout="total, sizes, prev, pager, next, jumper" 
		  		:total="MyProduct.length">
		  	</el-pagination>
		  </div>
	</el-tab-pane>
	<el-tab-pane label="产品分类" >
		
		<el-button @click="dialogVisible=true">新增类别</el-button>
		<el-tree ref="tree" :data="type" node-key="typeId"
		  :props="props"   default-expand-all
		  check-strictly
		  @node-click="on"
		  style="width: 400px; "
		  @check-change="checkChange">
		  
			 <template #default="{ node, data }">
			         <span class="custom-tree-node">
			           <span>{{ node.label }}</span>
			           <span>
			             <a @click.stop="remove(node, data)">x</a>
			           </span>
			         </span>
			       </template>
		</el-tree>
	</el-tab-pane>
	</el-tabs>
	
	
	<!--新增类别弹框-->
	<el-dialog
		title="新增类别"
		 v-model="dialogVisible"
		width="35%"
		@close="cancel('ss')"
	>
		<el-form label-width="100px" :rules="rules1" :model="ruleForm1" class="demo-ruleForm" ref="ss">
			<el-form-item label="类别名称" prop="typeName">
				<el-input v-model="typeObject.typeName" placeholder="请输入类别名称" style="width: 320px;"  clearable></el-input>
			</el-form-item>
			<el-form-item label="上级类别">
				<el-select v-model="typeObject.parentId"  placeholder="请选择上级类别" style="width: 320px;"   clearable >
				   <el-option
				     v-for="item in typeAll"
				     :key="item.typeId"
				     :label="item.typeName"
				     :value="item.typeId">
				   </el-option>
				 </el-select>
			</el-form-item>
		</el-form>
		<template #footer>
		  <span class="dialog-footer">
		    <el-button @click="cancel('ss')">取 消</el-button>
		    <el-button type="primary" @click="addType('ss')">确 定</el-button>
		  </span>
		</template>
	</el-dialog>
	
	
	
	
	<!--新增(修改)抽屉-->
	<el-drawer
	  :title="title"
	  v-model="drawer"
	  :direction="direction"
	  size="700px"
	  destroy-on-close
	  @close="cancel('xx')"
	>
	 <el-form :rules="rules"  label-width="100px" :model="ruleForm" class="demo-ruleForm" ref="xx">
	 	   <el-col :span="12" >
	 	   <el-form-item label="产品名称:" prop="name">
	 	      <el-input v-model="pro.proName"   placeholder="请输入产品名称" clearable></el-input> 
	 	   </el-form-item>    
	 	   </el-col> 	  
	 	   <el-col :span="12">
	 	   <el-form-item label="产品分类:" prop="type">
	 	      <el-cascader v-model="pro.proTypeId" 
			   :options="type" :props="{value:'typeId',label:'typeName',children:'types',checkStrictly: true,expandTrigger: 'hover'}" 
			   @change="handleChange"
			   filterable
			   debounce
			   clearable
			   :show-all-levels="false"></el-cascader>
	 	   </el-form-item>
	 	   </el-col>
	 		<el-col :span="12">
	 		<el-form-item label="启用状态:" prop="state">
			   <el-select v-model="pro.proState"  placeholder="请选择启用状态" style="width: 220px;"   clearable >
			      <el-option
			        v-for="item in options"
			        :key="item.value"
			        :label="item.label"
			        :value="item.value">
			      </el-option>
			    </el-select>
	 		</el-form-item>
	 		</el-col>
	 		<el-col :span="12">
	 		<el-form-item label="负责人:" prop="person">
			   <el-select v-model="pro.proPerson"  placeholder="请选择负责人" style="width: 220px;"   clearable >
			      <el-option
			        v-for="item in duty"
			        :key="item.usersId"
			        :label="item.usersFullname"
			        :value="item.usersId">
			      </el-option>
			    </el-select>
	 		</el-form-item>
	 		</el-col>
	 		<el-col :span="12">
	 		<el-form-item label="产品单位:" prop="unit">
	 		   <el-input v-model="pro.proUnit" placeholder="请输入产品单位"  clearable></el-input>
	 		</el-form-item>
	 		</el-col>
	 		<el-col :span="12">
	 		<el-form-item label="基准价格:" prop="price" >
	 		   <el-input onkeyup="value=value.replace(/[^\d]/g,'')" v-model="pro.proPrice"  placeholder="请填写基准价格"  clearable></el-input>
	 		</el-form-item>
	 		</el-col>
			<el-col :span="12">
			<el-form-item label="库存数量:" prop="count" v-if="is==0">
			   <el-input onkeyup="value=value.replace(/[^\d]/g,'')"  v-model="pro.proInventoryAmount"  placeholder="请填写库存数量"  clearable></el-input>
			</el-form-item>
			</el-col>
			<el-col :span="12">
			<el-form-item label="产品型号:" >
			   <el-input  v-model="pro.proModel" placeholder="请填写产品型号"  clearable></el-input>
			</el-form-item>
			</el-col>
			<el-col :span="12">
			<el-form-item label="条形码:" >
			   <el-input  v-model="pro.proBar" placeholder="请填写条形码"  clearable></el-input>
			</el-form-item>
			</el-col>
			<el-col :span="12">
			<el-form-item label="产品描述:" >
			   <el-input v-model="pro.proDescribe" type="textarea" :rows="2"  placeholder="请填写产品描述"  clearable></el-input>
			</el-form-item>
			</el-col>
	 	</el-form>
		<el-row style="margin-top: 340px; margin-left: 560px;">
			<el-col :span="2" >
				<el-button type="danger" @click="addProduct('xx')" >确定</el-button>
			</el-col>
		</el-row>
	</el-drawer>
	
	<!--批量修改类别弹框-->
	<el-dialog
		title="产品类别设置"
		 v-model="dialogVisible1"
		width="35%"
	>
		<el-form label-width="100px" >
			<el-form-item label="类别名称" prop="typeName">
				<el-select v-model="typeNumber" placeholder="请选择产品类别" style="width: 320px;"   clearable >
				   <el-option
				     v-for="item in typeAll"
				     :key="item.typeId"
				     :label="item.typeName"
				     :value="item.typeId">
				   </el-option>
				 </el-select>
			</el-form-item>
		</el-form>
		<template #footer>
		  <span class="dialog-footer">
		    <el-button >取 消</el-button>
		    <el-button type="primary" @click="addtypeProp()">确 定</el-button>
		  </span>
		</template>
	</el-dialog>
	
	
	
</template>

<script>
	import qs from 'qs'
	import { defineComponent } from 'vue'
	 import { ElMessage } from 'element-plus'
	export default{
		data() {
			var name =(rule, value, callback) =>{
				 if (this.pro.proName==='') {
				          return callback(new Error('产品名称不能为空'))
				 }
				 return callback();
			}
			var type =(rule, value, callback) =>{
				 if (this.pro.proTypeId==='') {
				          return callback(new Error('产品类别不能为空'))
				 }
				 return callback();
			}
			var state =(rule, value, callback) =>{
				 if (this.pro.proState==='') {
				          return callback(new Error('状态不能为空'))
				 }
				 return callback();
			}
			var person =(rule, value, callback) =>{
				 if (this.pro.proPerson==='') {
				          return callback(new Error('负责人不能为空'))
				 }
				 return callback();
			}
			var unit =(rule, value, callback) =>{
				 if (this.pro.proUnit==='') {
				          return callback(new Error('产品单位不能为空'))
				 }
				 return callback();
			}
			var price =(rule, value, callback) =>{
				 if (this.pro.proPrice==='') {
				          return callback(new Error('基准价不能为空'))
				 }
				 return callback();
			}
			var count =(rule, value, callback) =>{
				 if (this.pro.proInventoryAmount==='') {
				          return callback(new Error('库存数量不能为空'))
				 }
				 return callback();
			}
			var typeName =(rule, value, callback) =>{
				 if (this.typeObject.typeName==='') {
				          return callback(new Error('类别名称不能为空'))
				 }
				 this.typeAll.forEach(r=>{
				 	 if(r.typeName == this.typeObject.typeName){
				 		 return callback(new Error('类别名称重复'))
				 	 }
				 })
				 return callback();
			}
			
			return{
				ruleForm: {
					name: '',
					type: '',
					state: '',
					person: '',
					unit: '',
					price: '',
					count:''
				},
			    rules: {
					name: [{ validator: name, trigger: 'change' }],
					type: [{ validator: type, trigger: 'change' }],
				    state: [{ validator: state, trigger: 'change' }],
				    person: [{ validator: person, trigger: 'change' }],
					unit: [{ validator: unit, trigger: 'change' }],
					price: [{ validator: price, trigger: 'change' }],
					count: [{ validator: count, trigger: 'change' }]
				},
				ruleForm1: {
					typeName:'',
				},
				rules1: {
					typeName: [{ validator: typeName, trigger: 'blur' }]
				},
				
				//新增类别弹框
				dialogVisible:false,
				dialogVisible1:false,
				//新增抽屉
				drawer:false,
				direction: 'rtl',
				//接收所有产品
				product:[],
				MyProduct:[],
				//接收所有产品类别
				type:[],
				typeAll:[],
				//接收负责人
				duty:[],
				//产品对象
				pro:{
					proId:0,
					proName:'',
					proTypeId:'',
					proState:'',
					proPerson:'',
					proUnit:'',
					proPrice:'',
					proInventoryState:'',
					proInventoryAmount:'',
					proInventoryUsable:'',
					proInventoryLock:0,
					proModel:'',
					proDescribe:'',
					proDate:'',
					proBar:'',
				},
				//是否启用
				options: [
				          {
				            value: 1,
				            label: '启用',
				          },
				          {
				            value: 2,
				            label: '停用',
				          },
				],
				//库存状态
				options1: [
				          {
				            value: 0,
				            label: '正常',
				          },
				          {
				            value: 1,
				            label: '零库存',
				          },
						  {
						    value: 2,
						    label: '负库存',
						  },
				],
				
				//区别新增还是修改
				is:0,
				//搜所条件
				proCon:{
					proTypeId:'',
					proState:'',
					proInventoryState:'',
					content:'',
				},
				title:'新增产品',
				//类别树形控件
				props: {
					id:'typeId',
					label: 'typeName',
					children:'types'
				},
				//类别对象
				typeObject:{
					typeId:0,
					typeName:'',
					parentId:'',
				},
				//接收选中表格的数据
				pitch:[],
				pit:{
					proId:'',
					proTypeId:'',
					proPrice:'',
					proState:'',
					proPerson:'',
				},
				typeNumber:'',
				
				
				
				
				//分页
				total:0,
				pageNo:1,
				pageSize:5,
				//分页
				total1:0,
				pageNos:1,
				pageSizes:5,
			}
		},
		methods:{
			//初始化
			getData(){
				
				let usersId = this.$store.state.users.usersId;
				
				//查询所有产品
				this.axios({url:"/hzc/selPro",params:{product:this.proCon}})
				.then((res)=>{
					this.product = res.data;
					
					//查我负责的
					this.MyProduct = [],
					res.data.forEach(r=>{
						if(r.proPerson == usersId){
							this.MyProduct.push(r)
						}
					})
				}).catch(()=>{})
				
				//查询所有类别
				this.axios({url:"/hzc/selType"})
				.then((res)=>{
					this.type =res.data;
				}).catch(()=>{})
				
				//查询所有类别
				this.axios({url:"/hzc/selAll"})
				.then((res)=>{
					this.typeAll =res.data;
				}).catch(()=>{})
				
			},
			//点击打开新增弹框
			openPro(){
				
				this.drawer = true;
				
				//查询负责人
				this.axios({url:"/users/ajobId"})
				.then((res)=>{
					this.duty = res.data;
				}).catch(()=>{})
			},
			//确定新增
			addProduct(formName){
				
				this.$refs[formName].validate((valid) => {
					if (valid) {
						//等于0就新增
						if(this.pro.proId == 0){
							var vm = this;
							var y = new Date().getFullYear();
							var m = vm.appendZero(new Date().getSeconds() + 1);
							var miao  =vm.appendZero(new Date().getMilliseconds())
							this.pro.proId ='CP'+ y+''+m+''+miao;
							
							this.pro.proInventoryState = 0;
							
							if(this.pro.proInventoryAmount == 0){
								this.pro.proInventoryState = 1;
							}
							this.pro.proInventoryUsable = this.pro.proInventoryAmount;
							this.axios({url:"/hzc/insertPro",params:{product:this.pro}})
							.then((res)=>{
									if(res.code == 1){
										ElMessage.success({
											message: '新增成功',
											type: 'success'
										});
									}
									
								this.cancel(formName)
								this.getData();
							}).catch(()=>{})
						}else{
							this.axios({url:"/hzc/updatePro",params:{product:this.pro}})
							.then((res)=>{
								if(res.code == 1){
									ElMessage.success({
										message: '修改成功',
										type: 'success'
									});
								}
								this.cancel(formName)
								this.getData();
							}).catch(()=>{})
						}
					}
				})
			},
			//取消
			cancel(formName){
				this.pro ={
					proId:'',
					proName:'',
					proTypeId:'',
					proState:'',
					proPerson:'',
					proUnit:'',
					proPrice:'',
					proInventoryState:'',
					proInventoryAmount:'',
					proInventoryUsable:'',
					proInventoryLock:0,
					proModel:'',
					proDescribe:'',
					proDate:'',
					proBar:'',
				}
				this.is = 0;
				this.drawer = false;
				
				this.dialogVisible = false;
				this.typeObject = {
					typeId:0,
					typeName:'',
					parentId:'',
				}
				
				
				this.$refs[formName].resetFields();
			},
			//点击表格行 修改产品信息
			dot(row){
				console.log(row)
				this.drawer = true;
				this.title = '修改产品';
				this.is = 1;
				
				this.pro.proId = row.proId;
				this.pro.proName = row.proName;
				this.pro.proTypeId = row.proTypeId;
				this.pro.proState = row.proState;
				this.pro.proPerson = row.proPerson;
				this.pro.proUnit = row.proUnit;
				this.pro.proPrice = row.proPrice;
				this.pro.proModel = row.proModel;
				this.pro.proBar = row.proBar;
				this.pro.proDescribe = row.proDescribe;
			},
			on(node,data,value) {
			     console.log(data);	
				 this.dialogVisible = true;
				 this.typeObject.typeId = data.data.typeId;
				 this.typeObject.typeName = data.data.typeName;
				 
				 if(data.data.parentId != 0){
					 this.typeObject.parentId = data.data.parentId;
				 }
				 
			 },
			//确定新增类别
			addType(formName){
				this.$refs[formName].validate((valid) => {
					if (valid) {
						
						if(this.typeObject.typeId == 0){
							this.axios({url:"/hzc/insertType",params:{type:this.typeObject}})
							.then((res)=>{
								if(res.code == 1){
									ElMessage.success({
										message: '新增成功',
										type: 'success'
									});
								}	
								this.cancel(formName)
								this.getData();
							}).catch(()=>{})
						}else{
							this.axios({url:"/hzc/updateType",params:{type:this.typeObject}})
							.then((res)=>{
								if(res.code == 1){
									ElMessage.success({
										message: '修改成功',
										type: 'success'
									});
								}	
								this.cancel(formName)
								this.getData();
							}).catch(()=>{})
						}
						
							
					}
				})
			},
			//删除类别
			remove(node, data){
				this.$confirm('是否删除?', '提示', {
				  confirmButtonText: '确定',
				  cancelButtonText: '取消',
				  type: 'warning',
				}).then(() => {
					this.axios({url:"/hzc/deleteType",params:{typeId:data.typeId}})
					.then((res)=>{
						if(res.code == 1){
							ElMessage.success({
								message: '删除成功',
								type: 'success'
							});
						}	
						this.getData();
					}).catch(()=>{})
					
				}).catch(() => {
					this.$message({
					  type: 'info',
					  message: '已取消删除',
					})
				})
			},
			//获取选中的表格数据
			choose(val){
				this.pitch=[];
				val.forEach(r=>{
					this.pit.proId = r.proId;
					
					this.pitch.push(this.pit);
					this.pit ={
						proId:'',
						proTypeId:'',
						proPrice:'',
						proState:'',
						proPerson:'',
					}
				})
			},
			//批量修改产品类别
			typeProp(){
				if(JSON.stringify(this.pitch)=='[]'){
					 ElMessage.warning({
						message: '请先选择数据！',
						type: 'warning',
					  })
					return;
				}
				this.dialogVisible1 = true;
			},
			//确定修改产品类别
			addtypeProp(){
				if(this.typeNumber == ''){
					ElMessage.error('请选中产品类别')
					return;
				}
				this.pitch.forEach(v=>{
					v.proTypeId = this.typeNumber;
					v.proState = "1";
				})
				
				this.batch();
			},
			
			//批量修改方法
			batch(){
				this.axios.post("/hzc/batchType",this.pitch)
				.then((res)=>{
					
				}).catch(()=>{})
			},
			
			
			
			
			
			
			
			
			
			//日期方法
			appendZero(obj) {
				if (obj < 10) {
					return "0" + obj;
				} else {
					return obj;
				}
			},
			
			//获取类别选中的值
			handleChange(value) {
				console.log(value)
				if (value != null) {
					this.pro.proTypeId = value[value.length-1];
				}
			
			},
			//获取类别选中的值
			handleChange1(value) {
				console.log(value)
				if (value != null) {
					this.proCon.proTypeId = value[value.length-1];
				}
				this.getData();
			},
			//前端分页插件
			handleSizeChange(val) {
			   console.log(`每页 ${val} 条`);
			   this.pageNo = 1;
			   this.pageSize= val;
			  },
			handleCurrentChange(val) {
			   console.log(`当前页: ${val}`);
			   this.pageNo = val;
			},
			//前端分页插件
			handleSizeChange1(val) {
			   console.log(`每页 ${val} 条`);
			   this.pageNos = 1;
			   this.pageSizes= val;
			  },
			handleCurrentChange1(val) {
			   console.log(`当前页: ${val}`);
			   this.pageNos = val;
			},
		},
		created() {
			this.getData();
		}
	}
	
</script>

<style>
	.custom-tree-node {
	    flex: 1;
	    display: flex;
	    align-items: center;
	    justify-content: space-between;
	    font-size: 14px;
	    padding-right: 8px;
	  }
</style>
