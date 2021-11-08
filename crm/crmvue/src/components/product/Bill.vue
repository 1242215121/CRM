<template>
	<el-row style="margin-top: 20px;margin-left: 10px; ">
		<el-col :push="0" :span="3">
			<el-select v-model="billCon.billState"  placeholder="办理状态" style="width: 150px;" @change="getData()"  clearable >
			   <el-option
			     v-for="item in options2"
			     :key="item.value"
			     :label="item.label"
			     :value="item.value">
			   </el-option>
			 </el-select>
		</el-col>
		<el-col :span="3">
			<el-select v-model="billCon.billAction" placeholder="库存动作" style="width: 150px;" @change="getData()"  clearable >
			   <el-option
			     v-for="item in options3"
			     :key="item.value"
			     :label="item.label"
			     :value="item.value">
			   </el-option>
			 </el-select>
		</el-col>
		<el-col :span="2">
			<el-select v-model="billCon.billWay" placeholder="发起方式" style="width: 150px;" @change="getData()" clearable  >
			   <el-option
			     v-for="item in options4"
			     :key="item.value"
			     :label="item.label"
			     :value="item.value">
			   </el-option>
			 </el-select>
		</el-col>
		<el-col :push="2" :span="10">
			<el-input style="width: 200px;" @input="getData()" v-model="billCon.content"  placeholder="请输入出入库单编号"></el-input>
		</el-col>		
		<el-col :push="2" :span="2">
			<el-button round @click="openBill()">新增出入库单</el-button>
		</el-col>
	</el-row>
	
	<el-tabs style="margin: 10px;">
	<el-tab-pane label="出入库单" >
		 <el-table
			:data="bill.slice((pageNo-1)*pageSize,pageNo*pageSize)"
		    style="width: 100%"
			@row-click="dot"
		  >
		    <el-table-column prop="billId" sortable  label="出入库单编号" width="130"  ></el-table-column>
		    <el-table-column prop="billAction" label="库存动作">
				<template #default="en">
					{{en.row.billAction ==1 ? '出库' : '入库' }}
				</template>
			</el-table-column>
			<el-table-column prop="billCount" label="数量合计" ></el-table-column>		
			<el-table-column prop="billWay" label="发起方式" ></el-table-column>
			<el-table-column prop="billOrder" label="关联单据" > </el-table-column>
			<el-table-column prop="users.usersFullname" label="发起人" > </el-table-column>
			<el-table-column prop="billCreateDate" label="创建时间" width="160"></el-table-column>
			<el-table-column prop="billManageDate" label="办理时间"  width="160"></el-table-column>
			<el-table-column prop="users.usersFullnames" label="办理人员"  > </el-table-column>
			<el-table-column prop="billState" label="办理状态"> 
				<template #default="en">
					{{en.row.billState ==1 ? '未办理' : '已办理' }}
				</template>
			</el-table-column>
			<el-table-column label="操作">
				<template v-slot:default="s">
					<el-button v-if="s.row.billState ==1 && s.row.billOrder != '' && s.row.billOrder !=0 " 
					size="mini"  @click.stop ="wipe(s.row)">删除</el-button>
				</template>
			</el-table-column>
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
		  		:total="bill.length">
		  	</el-pagination>
		  </div>
	</el-tab-pane>
	</el-tabs>
	
	
	<!--详单抽屉-->
	<el-drawer
	  title="新增出入库单"
	   size="800px"
	  v-model="dialogVisible"
	  @close="cancel()"
	  >
	  <el-form  label-width="100px"  class="demo-ruleForm">
		<el-col :span="8">
		<el-form-item label="出入库说明:" >
		   <el-input
		     style="width: 250px;"
		     placeholder="请输入出入库说明"
			 v-model="billObject.billLibraryExplain"
		     >
		   </el-input>
		</el-form-item>
		</el-col>	
		<el-col :span="10">
		<el-form-item>
		   <el-radio v-model="enter" label="true">出库单</el-radio>
		   <el-radio v-model="enter" label="false">入库单</el-radio>
		</el-form-item>
		</el-col>
		<el-col :push="2" >
		  <el-button type="primary" @click="openPro()" icon="el-icon-s-custom" >选择产品</el-button>
		</el-col>		
		
		<el-table
		  :data="billObject.bills"
		  border
		  height="400px"
		  style="width: 100%;margin-top: 20px; ">
		  <el-table-column
		    prop="preId"
		    label="产品编号">
		  </el-table-column>
		  <el-table-column
		    prop="preName"
		    label="产品名称">
		  </el-table-column>		 
		  <el-table-column
		    prop="preUnit"
		    label="单位">
		  </el-table-column>
		  <el-table-column
		    prop="billsCount"
		    label="数量">
			<template v-slot:default="r">
				<el-input placeholder="数量" onkeyup="value=value.replace(/[^\d]/g,'')" v-model="r.row.billsCount"></el-input>
			</template>
		  </el-table-column>
		 <el-table-column
		   prop="billsRemark"
		   label="备注">
		   <template v-slot:default="r">
		   	<el-input placeholder="备注" v-model="r.row.billsRemark"></el-input>
		   </template>
		 </el-table-column>
		 
		
		  <el-table-column
		  	label="操作" >
		  	<template v-slot:default="s">
				<el-button @click="remove(s.$index)">删除</el-button>
		  	</template>  				
			</el-table-column>
		</el-table>
	  </el-form>
	 
	<el-row style="margin-top: 10px;">
		<el-col :span="6" :push="20">
			<el-button type="danger" @click="addBill()">确定</el-button>
		</el-col>
	</el-row>
	</el-drawer>
	
	<!--产品信息弹框-->
	<el-dialog
	  title="药品信息"
	  v-model="dialogVisible1"
	  width="62%"
	  >
		<el-row>
			<el-col :push="0" :span="4">
				<el-cascader v-model="proCon.proTypeId"
				style="width: 130px;"
				 :options="type" :props="{value:'typeId',label:'typeName',children:'types',checkStrictly: true,expandTrigger: 'hover'}" 
				 @change="handleChange1"
				 filterable
				 debounce
				 clearable
				 placeholder="产品类别"
				 :show-all-levels="false"></el-cascader>
			</el-col>
			<el-col :span="4">
				<el-select v-model="proCon.proState"  placeholder="启用状态" style="width: 130px;" @change="openPro()"  clearable >
				   <el-option
				     v-for="item in options"
				     :key="item.value"
				     :label="item.label"
				     :value="item.value">
				   </el-option>
				 </el-select>
			</el-col>
			<el-col :span="2">
				<el-select v-model="proCon.proInventoryState"  placeholder="库存状态" style="width: 130px;" @change="openPro()" clearable  >
				   <el-option
				     v-for="item in options1"
				     :key="item.value"
				     :label="item.label"
				     :value="item.value">
				   </el-option>
				 </el-select>
			</el-col>
			<el-col :push="2" :span="8">
				<el-input style="width: 200px;" v-model="proCon.content"  @input="openPro()" placeholder="请输入产品名称"></el-input>
			</el-col>
			</el-row>
			
			  <el-table
			    :data="product"
			    border
				@selection-change="choose"
			    style="width: 100%;margin-top: 10px;">
			  	<el-table-column
			  		type="selection"
			  		width="50">
			  	</el-table-column>
			    <el-table-column
			      prop="proId"
			      label="产品编号">
			    </el-table-column>
			    <el-table-column
			      prop="proName"
			      label="产品名称">
			    </el-table-column>
			    <el-table-column
			      prop="type.typeName"
			      label="产品分类">
			    </el-table-column>
			    <el-table-column prop="proState" label="启用状态" >
			    	<template #default="en">
			    		{{en.row.proState ==1 ? '启用' : '停用' }}
			    	</template>
			    </el-table-column>
				<el-table-column prop="proUnit" label="产品单位" width="80"> </el-table-column>
				<el-table-column prop="proInventoryState" label="库存状态" width="80"> 
					<template #default="en">
						{{en.row.proInventoryState == 0 ? '正常' : (en.row.proInventoryState == 1 ? '零库存':'负库存') }}
					</template>
				</el-table-column>
				<el-table-column prop="proInventoryAmount" label="库存数量" width="80" > </el-table-column>
				<el-table-column prop="proInventoryUsable" label="可用库存" width="80"> </el-table-column>
			  </el-table>
			  	
	  <template #footer>
		  <span class="dialog-footer">
			 <el-button @click="dialogVisible1 = false">取 消</el-button>
			 <el-button type="primary" @click="send()">确 定</el-button>
		  </span>
	  </template>	  
	  </el-dialog>
	 
	<!--出入库单详情-->
	 <el-dialog
	   title="出入库单详情"
	   v-model="dialogVisible2"
	   width="62%"
	   >
	 <el-table
	   :data="bills"
	   border
	   style="width: 100%;margin-top: 10px;">
	   <el-table-column prop="preId" label="产品编号"></el-table-column>
	   <el-table-column prop="preName" label="产品名称"></el-table-column>
	   <el-table-column prop="preUnit" label="单位"></el-table-column>
	   <el-table-column prop="billsCount" label="数量"></el-table-column>
	   <el-table-column prop="billsRemark" label="备注"></el-table-column>
	 </el-table>
	   
	</el-dialog>
</template>

<script>
	import qs from 'qs'
	import { defineComponent } from 'vue'
	 import { ElMessage } from 'element-plus'
	 
	 export default{
		 data(){
			 return{
				dialogVisible:false,
				dialogVisible1:false,
				dialogVisible2:false,
				//接收所有出入库单
				bill:[],
				//详单
				bills:[],
				
				//新增出入库单对象
				billObject:{
					billId:0,
					billAction:'',
					billCount:'',
					billWay:'其他',
					billOrder:'',
					billPerson:'',
					billCreateDate:'',
					billManageDate:'',
					billLibraryDate:'',
					billManagePerson:'',
					billState:1,
					billLibraryExplain:'',
					billManageExplain:'',
					bills:[]
				},
				//详表对象
				billsObject:{
					billsId:0,
					preId:'',
					preName:'',
					preUnit:'',
					billsCount:1,
					billsRemark:'',
					billId:'',
					maxCount:''
				},
				//产品搜所条件
				proCon:{
					proTypeId:'',
					proState:'',
					proInventoryState:'',
					content:'',
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
				options2: [
				          {
				            value: 1,
				            label: '未办理',
				          },
						  {
						    value: 2,
						    label: '已办理',
						  },
				],
				options3: [
				          {
				            value: 1,
				            label: '出库',
				          },
						  {
						    value: 2,
						    label: '入库',
						  },
				],
				options4: [
				          {
				            value: '销售订单',
				            label: '销售订单',
				          },
						  {
						    value: '退货单',
						    label: '退货单',
						  },
						  {
						    value: '其他',
						    label: '其他',
						  },
				],
				type:[],
				//接收所有产品
				product:[],
				//接收选中的产品
				pitchPro:[],
				
				enter:'true',
				
				//搜所条件
				billCon:{
					billAction:'',
					billState:'',
					billWay:'',
					content:'',
				},
				//分页
				total:0,
				pageNo:1,
				pageSize:5,
			 }
		 },
		 methods:{
			 //初始化
			 getData(){
				 //查询所有产品
				 this.axios({url:"/hzc/selectBill",params:{bill:this.billCon}})
				 .then((res)=>{
					this.bill = res.data;
					console.log(res.data)				
				 }).catch(()=>{})
			 },
			 //点击表格行出现详单数据
			 dot(row){
				 this.bills=[];
				 row.bills.forEach(z=>{
					 this.bills.push(z)
				 })
				 console.log(this.bills)
				 this.dialogVisible2 = true;
			 },
			 //点击新增出现弹框
			 openBill(){
				 this.dialogVisible = true;
			 },
			 //选择产品
			 openPro(){
				 this.dialogVisible1 = true;
				 
				 //查询所有类别
				 this.axios({url:"/hzc/selType"})
				 .then((res)=>{
				 	this.type =res.data;
				 }).catch(()=>{})
				 
				 //查询所有产品
				 this.axios({url:"/hzc/selPro",params:{product:this.proCon}})
				 .then((res)=>{
				 	this.product = res.data;			 				 	
				 }).catch(()=>{})
			 },
			 //获取选中的产品
			 choose(val){
				this.pitchPro = val;
			 },
			 //将选中的产品添加到出入库单详表
			 send(){
				 this.pitchPro.forEach(z=>{
					 this.billsObject.preId = z.proId;
					 this.billsObject.preName = z.proName;
					 this.billsObject.preUnit = z.proUnit;
					 this.billsObject.maxCount = z.proInventoryUsable;
					 
					 this.billObject.bills.push(this.billsObject);
					 
					 this.billsObject = {
						 billsId:0,
						 preId:'',
						 preName:'',
						 preUnit:'',
						 billsCount:1,
						 billsRemark:'',
						 billId:'',
						 maxCount:''
					 }
				 })
				 this.dialogVisible1 = false;
				 
			 },
			 //删除行
			 remove(index){
			 	    this.billObject.bills.splice(index,1);
			 },
			 //确定添加出入库单
			 addBill(){
				 //判断是否有产品
				 if(JSON.stringify(this.billObject.bills)=='[]'){
					 ElMessage.warning({
					 	message: '请选择	产品！',
					 	type: 'warning',
					   })
					 return;
				 }
				 //判断是出库单还是入库单
				 if(this.enter == 'true'){
					 let a = 0;
					 let b = 0;
					 let c = 0;
					 this.billObject.bills.forEach(z=>{
						 if(z.billsCount == '' || z.billsCount == 0){							 
							 a = 1;
						 } 
						 if(z.billsCount > z.maxCount){
							 b = 1
						 }
						 //数量合计
						 c += parseInt(z.billsCount) ;
					 })
					 if(a == 1){
						ElMessage.warning({
							message: '请输入数量！',
							type: 'warning',
						  })
						return false; 
					 }
					 if(b == 1){
						ElMessage.warning({
							message: '可用库存数量不足！',
							type: 'warning',
						  })
						return false; 
					 }
					 //给出入库单主表赋值
					 var vm = this;
					 var y = new Date().getFullYear();
					 var m = vm.appendZero(new Date().getSeconds() + 1);
					 var miao  =vm.appendZero(new Date().getMilliseconds())
					 this.billObject.billId ='CKD'+ y+''+m+''+miao; 
					 this.billObject.billAction = 1;
					 this.billObject.billCount = c;
					 this.billObject.billPerson = this.$store.state.users.usersId;
					 
					 this.axios.post('/hzc/insertBill',this.billObject)
					 .then((res)=>{
					 	if(res.code == 1){
					 		 ElMessage.success({
					 			message: '新增成功',
					 			type: 'success'
					 		 });					 
					 	}	
					 	this.getData();
					 	this.cancel();
					 }).catch(()=>{})
					 
				 }else{
					let a = 0;
					let c = 0;
					this.billObject.bills.forEach(z=>{
						 if(z.billsCount == '' || z.billsCount == 0){							 
							 a = 1;
						 } 
						 //数量合计
						 c += parseInt(z.billsCount) ;
					}) 
					if(a == 1){
						ElMessage.warning({
							message: '请输入数量！',
							type: 'warning',
						  })
						return false; 
					}
					//给出入库单主表赋值
					var vm = this;
					var y = new Date().getFullYear();
					var m = vm.appendZero(new Date().getSeconds() + 1);
					var miao  =vm.appendZero(new Date().getMilliseconds())
					this.billObject.billId ='RKD'+ y+''+m+''+miao; 
					this.billObject.billAction = 2;
					this.billObject.billCount = c;
					this.billObject.billPerson = this.$store.state.users.usersId;
					
					this.axios.post('/hzc/insertBill',this.billObject)
					.then((res)=>{
						if(res.code == 1){
							 ElMessage.success({
								message: '新增成功',
								type: 'success'
							 });					 
						}	
						this.getData();
						this.cancel();
					}).catch(()=>{})
				 }
				 
				 
			 },
			 //编辑
			 wipe(row){
				 console.log(row);
				 this.$confirm('是否删除?', '提示', {
				   confirmButtonText: '确定',
				   cancelButtonText: '取消',
				   type: 'warning',
				 })
			    .then(() => {
				   
				   this.axios({url:"/hzc/deleteBill",params:{billId:row.billId}})
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
			 
			 
			 
			 
			 
			 //取消
			 cancel(){
				 this.dialogVisible = false;
				 this.billObject = {
				 	billId:0,
				 	billAction:'',
				 	billCount:'',
				 	billWay:'其他',
				 	billOrder:'',
				 	billPerson:'',
				 	billCreateDate:'',
				 	billManageDate:'',
				 	billLibraryDate:'',
				 	billManagePerson:'',
				 	billState:1,
				 	billLibraryExplain:'',
				 	billManageExplain:'',
				 	bills:[]
				 }
			 },
			 
			 
			 //获取类别选中的值
			 handleChange1(value) {
			 	console.log(value)
			 	if (value != null) {
			 		this.proCon.proTypeId = value[value.length-1];
			 	}
				this.openPro();
			 },
			 //日期方法
			 appendZero(obj) {
			 	if (obj < 10) {
			 		return "0" + obj;
			 	} else {
			 		return obj;
			 	}
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
		 },
		 created() {
		 	this.getData();
		 }
	 }
</script>

<style>
</style>
