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
		  >
		    <el-table-column type="selection"   width="50" > </el-table-column>
		    <el-table-column prop="proId"   sortable  label="产品编号" width="100" ></el-table-column>
		    <el-table-column prop="proName" label="产品名称" > </el-table-column>
			<el-table-column prop="proTypeId" label="产品分类" > </el-table-column>		
			<el-table-column prop="proState" label="启用状态" > </el-table-column>
			<el-table-column prop="proPerson" label="负责人"> </el-table-column>
			<el-table-column prop="proUnit" label="产品单位" > </el-table-column>
			<el-table-column prop="proPrice" label="基准价格" > </el-table-column>
			<el-table-column prop="proInventoryState" label="库存状态" > </el-table-column>
			<el-table-column prop="proInventoryAmount" label="库存数量" > </el-table-column>
			<el-table-column prop="proInventoryUsable" label="可用库存"> </el-table-column>
			<el-table-column prop="proInventoryLock" label="锁定库存" > </el-table-column>
			<el-table-column prop="proModel" label="产品型号" > </el-table-column>
			<el-table-column prop="proDescribe" label="产品描述" > </el-table-column>
			<el-table-column prop="proDate" sortable  label="创建时间" width="160" > </el-table-column>
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
	>
	 <el-form :rules="rules"  label-width="100px" :model="ruleForm" class="demo-ruleForm" ref="xx">
	 	   <el-col :span="12" >
	 	   <el-form-item label="产品名称:" >
	 	      <el-input v-model="pro.proName"   placeholder="请输入产品名称" clearable></el-input> 
	 	   </el-form-item>    
	 	   </el-col> 	  
	 	   <el-col :span="12">
	 	   <el-form-item label="产品分类:" >
	 	      <el-cascader v-model="pro.proTypeId"  :options="type" :props="{ value: 'typeId', label: 'typeName'}" :show-all-levels="false"></el-cascader>
	 	   </el-form-item>
	 	   </el-col>
	 		<el-col :span="12">
	 		<el-form-item label="启用状态:" >
	 		   <el-input v-model="pro.proState" placeholder="请选择启用状态"  clearable></el-input>
	 		</el-form-item>
	 		</el-col>
	 		<el-col :span="12">
	 		<el-form-item label="负责人:" >
	 		   <el-input v-model="pro.proPerson"  placeholder="请选择负责人"  clearable></el-input>
	 		</el-form-item>
	 		</el-col>
	 		<el-col :span="12">
	 		<el-form-item label="产品单位:" >
	 		   <el-input v-model="pro.proUnit" placeholder="请输入产品单位"  clearable></el-input>
	 		</el-form-item>
	 		</el-col>
	 		<el-col :span="12">
	 		<el-form-item label="基准价格:" >
	 		   <el-input v-model="pro.proPrice"  placeholder="请填写基准价格"  clearable></el-input>
	 		</el-form-item>
	 		</el-col>
			<el-col :span="12">
			<el-form-item label="库存数量:" >
			   <el-input v-model="pro.proInventoryAmount"  placeholder="请填写库存数量"  clearable></el-input>
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
				<el-button type="danger" @click="drawer=false" >确定</el-button>
			</el-col>
		</el-row>
	</el-drawer>
	
	
</template>

<script>
	
	export default{
		data() {
			return{
				drawer:false,
				direction: 'rtl',
				//接收所有产品
				product:[],
				//接收所有产品类别
				type:[],
				//产品对象
				pro:{
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
					proInventoryLock:'',
					proModel:'',
					proDescribe:'',
					proDate:'',
					proBar:'',
				},
				
			}
		},
		methods:{
			getData(){
				//查询所有产品
				this.axios({url:"/hzc/selPro"})
				.then((res)=>{
					this.product = res.data;
					console.log(res.data);
				}).catch(()=>{})
				
				//查询所有类别
				this.axios({url:"/hzc/selType"})
				.then((res)=>{
					this.type = res.data;
					console.log(res.data);
				}).catch(()=>{})
			},
		},
		created() {
			this.getData();
		}
	}
	
</script>

<style>
</style>
