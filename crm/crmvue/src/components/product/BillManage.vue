<template>
	<el-row style="margin-top: 20px;margin-left: 10px; ">
	
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
	</el-row>
	
	<el-tabs style="margin: 10px;">
	<el-tab-pane label="出入库办理" >
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
			<el-table-column prop="billCreateDate" sortable label="创建时间" width="160"></el-table-column>

			<el-table-column prop="billState" label="办理状态"> 
				<template #default="en">
					{{en.row.billState ==1 ? '未办理' : '已办理' }}
				</template>
			</el-table-column>
			<el-table-column label="操作">
				<template v-slot:default="s">
					<el-button @click.stop ="openManage(s.row)">办理</el-button>
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
	
	<!--办理弹框-->
	 <el-dialog
	   title="办理"
	   v-model="dialogVisible1"
	   @close="cancel()"
	   width="35%"
	   >
	 <el-form label-width="100px" >
	 	<el-form-item label="出库日期" >
	 		 <el-date-picker v-model="billObject.billLibraryDate"  type="date" style="width: 320px;" placeholder="选择日期">
	 		    </el-date-picker>
	 	</el-form-item>
	 	<el-form-item label="办理说明">
	 		<el-input v-model="billObject.billManageExplain" type="textarea" :rows="4"  placeholder="请输入办理说明" style="width: 320px;"  clearable></el-input>
	 	</el-form-item>
	 </el-form>
	 <template #footer>
	   <span class="dialog-footer">
	     <el-button @click="cancel()">取 消</el-button>
	     <el-button type="primary" @click="addManage()">确 定</el-button>
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
				//新增出入库单对象
				billObject:[],
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
				 this.axios({url:"/hzc/selectBill1",params:{bill:this.billCon}})
				 .then((res)=>{
					this.bill = res.data;
													
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
			 //打开办理弹框
			 openManage(row){
				 
				 this.billObject = row;
				 this.billObject.billLibraryDate = new Date();
				 
				 
				 this.billObject.billManagePerson = this.$store.state.users.usersId;
				 
				 this.dialogVisible1 = true;
			 },
			 //确定办理
			 addManage(){
				 this.billObject.billLibraryDate = this.gettime(this.billObject.billLibraryDate);
				 console.log(this.billObject)
				 this.axios.post('/hzc/updateBill',this.billObject)
				 .then((res)=>{
				 	if(res.code == 1){
						ElMessage.success({
							message: '办理成功',
							type: 'success'
						});		
					}
					this.getData();
					this.cancel();
				 }).catch(()=>{})
				 
			 },
			 
			 cancel(){
				 this.billObject=[];
				 this.dialogVisible1 = false;
			 },
			 
			 
			 gettime(data) {
			   let value = data.getFullYear() + '-' +
			     this.checkTime(data.getMonth() + 1) + '-' +
			     this.checkTime(data.getDate()) + ' ' +
			     this.checkTime(data.getHours()) + ':' +
			     this.checkTime(data.getMinutes()) + ':' +
			     this.checkTime(data.getSeconds());
			   return value
			 },
			 checkTime(i) {
			     if (i < 10) {
			       i = "0" + i
			     }
			     return i;
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
