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
		    <el-table-column type="selection" > </el-table-column>
		    <el-table-column prop="proId" label="产品编号" ></el-table-column>
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
			<el-table-column prop="proDate" label="创建时间" > </el-table-column>
		  </el-table>
	</el-tab-pane>
	<el-tab-pane label="我负责的" >
	</el-tab-pane>
	</el-tabs>
	
	
	<!--新增(修改)抽屉-->
	<el-drawer
	  title="我是标题"
	  v-model="drawer"
	  :direction="direction"
	  size="600px"
	  destroy-on-close
	>
	  <span>我来啦!</span>
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
				
				
			}
		},
		methods:{
			getData(){
				this.axios({url:"/hzc/selPro"})
				.then((res)=>{
					this.product = res.data;
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
