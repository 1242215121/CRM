<template>
	<el-row style="margin-top: 20px;margin-left: 10px; ">
		<el-col :push="0" :span="3">
			<el-select   placeholder="筛选条件" style="width: 150px;" @change="getData()"  >
			   <el-option
			     v-for="item in department"
			     :key="item.depaId"
			     :label="item.depaName"
			     :value="item.depaId">
			   </el-option>
			 </el-select>
		</el-col>
		<el-col :span="3">
			<el-select   placeholder="筛选条件" style="width: 150px;" @change="getData()"  >
			   <el-option
			     v-for="item in department"
			     :key="item.depaId"
			     :label="item.depaName"
			     :value="item.depaId">
			   </el-option>
			 </el-select>
		</el-col>
		<el-col :span="2">
			<el-select   placeholder="筛选条件" style="width: 150px;" @change="getData()"  >
			   <el-option
			     v-for="item in department"
			     :key="item.depaId"
			     :label="item.depaName"
			     :value="item.depaId">
			   </el-option>
			 </el-select>
		</el-col>
		<el-col :push="2" :span="10">
			<el-input style="width: 200px;"  placeholder="请输入产品名称"></el-input>
		</el-col>		
		<el-col :push="2" :span="2">
			<el-button round @click="drawer = true">新增产品</el-button>
		</el-col>
	</el-row>
	
	
	<el-tabs style="margin: 10px;">
	<el-tab-pane label="所有产品" >
		 <el-table
			:data="product"
		    style="width: 100%"
			@row-click="dot"
		  >
		    <el-table-column type="selection"    width="50" > </el-table-column>
		    <el-table-column prop="proId"    sortable  label="产品编号" width="115" ></el-table-column>
		    <el-table-column prop="proName" label="产品名称" width="100"> </el-table-column>
			<el-table-column prop="type.typeName" label="产品分类" > </el-table-column>		
			<el-table-column prop="proState" label="启用状态" > 
				<template #default="en">
					{{en.row.proState ==0 ? '启用' : '停用' }}
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
			<el-table-column prop="proDescribe" label="产品描述" width="80"> </el-table-column>
			<el-table-column prop="proDate" sortable  label="创建时间" width="140" > </el-table-column>
		  </el-table>
	</el-tab-pane>
	<el-tab-pane label="我负责的" >
	</el-tab-pane>
	</el-tabs>
	
	
	<!--新增(修改)抽屉-->
	<el-drawer
	  title="新建产品"
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
					count: [{ validator: count, trigger: 'change' }],
				},
				
				//新增抽屉
				drawer:false,
				direction: 'rtl',
				//接收所有产品
				product:[],
				//接收所有产品类别
				type:[],
				//接收负责人
				duty:[],
				//产品对象
				pro:{
					proId:'',
					proName:'',
					proTypeId:'',
					proState:'',
					proPerson:'',
					proUnit:'',
					proPrice:'',
					proInventoryState:0,
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
				            value: 0,
				            label: '启用',
				          },
				          {
				            value: 1,
				            label: '停用',
				          },
				],
				
				
				is:0,
			}
		},
		methods:{
			//初始化
			getData(){
				var $this=this;
				//查询所有产品
				this.axios({url:"/hzc/selPro"})
				.then((res)=>{
					this.product = res.data;
				}).catch(()=>{})
				
				//查询所有类别
				this.axios({url:"/hzc/selType"})
				.then((res)=>{
					this.type =res.data;
				}).catch(()=>{})
				
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
						var vm = this;
						var y = new Date().getFullYear();
						var m = vm.appendZero(new Date().getSeconds() + 1);
						var miao  =vm.appendZero(new Date().getMilliseconds())
						this.pro.proId ='CP'+ y+''+m+''+miao;
						
						if(this.pro.proInventoryAmount == 0){
							this.pro.proInventoryState = 1;
						}
						this.pro.proInventoryUsable = this.pro.proInventoryAmount;
						
						this.axios({url:"/hzc/insertPro",params:{product:this.pro}})
						.then((res)=>{
							console.log(res.code)
							if(res.code == 1){
								ElMessage.success({
									message: '新增成功',
									type: 'success'
								});
							}
							this.cancel(formName)
							this.getData();
						}).catch(()=>{})
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
					proInventoryState:0,
					proInventoryAmount:'',
					proInventoryUsable:'',
					proInventoryLock:0,
					proModel:'',
					proDescribe:'',
					proDate:'',
					proBar:'',
				}
				this.drawer = false;
				this.$refs[formName].resetFields();
			},
			//点击表格行 修改产品信息
			dot(row){
				console.log(row)
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
				if (value != null) {
					this.pro.proTypeId = value[value.length-1];
				}
			
			},
		},
		created() {
			this.getData();
		}
	}
	
</script>

<style>
</style>
