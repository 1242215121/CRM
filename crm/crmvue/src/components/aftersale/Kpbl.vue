<template>
		<div style="margin-top:20px;margin-left:20px">
			<el-tabs v-model="activeName" @tab-click="handleClick">
				<el-tab-pane label="待办理" name="first"></el-tab-pane>
				<el-tab-pane label="已办理" name="second"></el-tab-pane>
				<el-tab-pane label="已驳回" name="third"></el-tab-pane>
			</el-tabs>
		</div>
		<div style="margin-top:20px;margin-left:20px">
			<el-input v-model="nr" style="width:200px;" placeholder="请输入内容" >
			</el-input>
			<el-button type="primary" icon="el-icon-search" @click="getData()">搜索</el-button>
			<el-table :data="tableData" border @row-click="xq" style="width: 100%;margin-top:10px;">
				<el-table-column prop="invoiceName" label="申请名称" width="150">
				</el-table-column>
				<el-table-column prop="invoiceDdid.soName" label="订单名称" width="150">
				</el-table-column>
				<el-table-column prop="invoiceKhid.clientName" label="客户名称" width="150">
				</el-table-column>
				<el-table-column prop="invoiceQcid.periodoftimeName" label="回款期次" width="150">
				</el-table-column>
				<el-table-column prop="invoiceJbr.usersFullname" label="经办人" width="150">
				</el-table-column>
				<el-table-column prop="invoicePrice" label="开票金额" width="150">
				</el-table-column>
				<el-table-column prop="invoiceDate" label="开票日期" width="210">
				</el-table-column>
				<el-table-column prop="invoicePjid.papertypeName" label="开票类型" width="150">
				</el-table-column>
				<el-table-column prop="invoiceKphm" label="开票号码" width="150">
				</el-table-column>
				<el-table-column prop="invoicePjtt" label="票据抬头" width="150">
				</el-table-column>
				<el-table-column prop="invoiceNssbh" label="纳税识别号" width="150">
				</el-table-column>
				<el-table-column prop="invoiceShr.usersFullname" label="办理人" width="150">
				</el-table-column>
				<el-table-column prop="invoiceZt" label="开票状态" width="150" show-overflow-tooltip :formatter="ztxs">
				</el-table-column>
				<el-table-column prop="invoiceBz" label="备注" width="400">
				</el-table-column>
				<el-table-column prop="invoiceBlbz" label="办理备注" width="400">
				</el-table-column>
			</el-table>
			<div class="block">
				<el-pagination style="position: absolute;right:10px" @size-change="hal1" @current-change="hal"
					:page-sizes="[5, 10, 15]" :total="total" :page-size="size" :current-page="pageNo"
					layout="total, sizes, prev, pager, next, jumper">
				</el-pagination>
			</div>
			
			<el-drawer :title="btxs" v-model="drawer" :direction="direction" size='50%' :before-close="qk">
				<el-button size="mini" v-if="kpjl.invoiceZt==3? true:false" style="position: absolute;right:10px" @click="kpbl()">开票办理</el-button>
				<el-button size="mini" v-if="kpjl.invoiceZt==3? true:false" style="position: absolute;right:100px" @click="bh()">驳回</el-button>
				<div style="margin-left:20px;">
					<div style="width: 150px;display: inline-block;">
						<p>创建人：{{kpjl.invoiceJbr.usersFullname}}</p>
						<p>订单名称：{{kpjl.invoiceDdid.soName}}</p>
					</div>
					<div style="width: 260px;margin-left: 20px;display: inline-block;">
						<p>创建日期：{{kpjl.invoiceSqdate}}</p>
						<p>客户名称：{{kpjl.invoiceKhid.clientName}}</p>
					</div>
					<div style="width: 200px;margin-left: 20px;display: inline-block;">
						<p>票据类型：{{kpjl.invoicePjid.papertypeName}}</p>
					</div>
				</div>
				<div style="margin-left:20px;">
					<el-tabs v-model="activeName1">
						<el-tab-pane label="概况" name="first">
							<span>基础信息</span>
							<div style="margin-top: 10px;">
								<div style="width: 200px;display: inline-block;">
									<p>回款期次：{{kpjl.invoiceQcid.periodoftimeName}}</p>
									<p>经办人：{{kpjl.invoiceJbr.usersFullname}}</p>
								</div>
								<div style="margin-left: 200px;width: 200px;display: inline-block;">
									<p>开票金额：{{kpjl.invoicePrice}}</p>
									<p>票据抬头：{{kpjl.invoicePjtt}}</p>
								</div>
								<div style="margin-bottom:20px ;">
									<p>纳税识别号：{{kpjl.invoiceNssbh}}</p>
									<p>备注说明：{{kpjl.invoiceBz}}</p>
								</div>
							</div>
							
							<hr/>
							
							<span>办理信息</span>
							<div style="margin-top: 20px;">
								<div style="width: 280px;display: inline-block;">
									<p>开票日期：{{kpjl.invoiceDate}}</p>
								</div>
								<div style="margin-left: 120px;width: 200px;display: inline-block;">
									<p>开票号码：{{kpjl.invoiceKphm}}</p>
								</div>
								<p>办理备注：{{kpjl.invoiceBlbz}}</p>
							</div>

							
						</el-tab-pane>
						<el-tab-pane label="附件资料" name="second"></el-tab-pane>
					</el-tabs>
				</div>
			</el-drawer>
			
			<el-dialog title="开票办理" v-model="dialogFormVisible" width="40%">
			  <el-form :model="kpjl">
					<el-form-item label="开票日期" prop="invoiceDate" :label-width="formLabelWidth">
						<el-date-picker
								        v-model="kpjl.invoiceDate"
								        align="right"
								        type="date"
										style="width: 280px;"
								        placeholder="选择日期"
										value-format="YYYY-MM-DD"
								        :picker-options="pickerOptions">
								  </el-date-picker>
					</el-form-item>
					<el-form-item label="开票号码" prop="invoiceKphm" :label-width="formLabelWidth">
						<el-input v-model="kpjl.invoiceKphm" style="width: 280px;" autocomplete="off"></el-input>
					</el-form-item>
					<el-form-item label="办理备注" prop="invoiceBlbz" :label-width="formLabelWidth">
						<el-input
						  type="textarea"
						  :autosize="{ minRows: 2, maxRows: 6}"
						  placeholder="请输入内容"
						  style="width: 280px;"
						  v-model="kpjl.invoiceBlbz"></el-input>
					</el-form-item>
			  </el-form>
			  <div slot="footer" class="dialog-footer" style="text-align: center;">
			    <el-button @click="gb()">取 消</el-button>
			    <el-button type="primary" @click="qd()">确 定</el-button>
			  </div>
			</el-dialog>
		</div>
	 
</template>

<script>
	import { defineComponent } from 'vue'
		 import { ElMessage } from 'element-plus'
	export default {
	    data() {
	      return {
	        activeName: 'first',
			activeName1:'first',
			input:'',
			tableData:[],
			total:0,
			pageNo:1,
			size:5,
			zt:3,
			kp:[],
			emp: {}, //当前登录用户
			drawer: false, //抽屉显示
			direction: 'rtl',
			kpjl: {}, //回款记录
			btxs: '', //抽屉标题
			dialogFormVisible: false,
			formLabelWidth: '120px',
			
	      };
	    },
	    methods: {
	      handleClick(tab, event) {
	        console.log(this.activeName);
			if(this.activeName=='first'){
				this.zt=3;
			}else if(this.activeName=='second'){
				this.zt=1;
			}else if(this.activeName=='third'){
				this.zt=2;
			}
			this.getData();
	      },
		  getData(no){
			  if (no == undefined) {
			  	no = this.pageNo
			  }
			  this.axios({
			  	url: 'http://localhost:8086/llw/kpblcx',
			  	params:{pageNo:no,size:this.size,'zt':this.zt,'nr':this.nr}
			  }).then(res => {
			  	console.log(res)
			  	this.tableData = res.obj.kpblcx;
			  	this.total = res.obj.total;
			  }).catch(function() {
			  
			  })
		  },
		  hal(val){
		  	console.log(val);
		  	this.pageNo=val;
		  	this.getData();
		  },
		  hal1(val){
		  	console.log(val);
		  	this.size=val;
		  	this.getData();
		  },
		  selectionLineChangeHandle (val) {
		       this.kp = val
		  },
		  qk(){
		  	this.activeName1='first';
		  	this.drawer=false;
		  },
		  xq(row, column, event) {
		  	console.log(row);
		  	this.kpjl = row;
		  	this.btxs = '申请名称：'+row.invoiceName;
		  	if (row.receivableZt == 1) {
		  		this.zt = '已办理';
		  	} else if (row.receivableZt == 2) {
		  		this.zt = '被驳回';
		  	} else if (row.receivableZt == 3) {
		  		this.zt = '待办理';
		  	}
		  	this.drawer = true;
		  },
		  ztxs(row, column, cellValue) {
		  	if (cellValue == 1) {
		  		return '已办理';
		  	} else if (cellValue == 2) {
		  		return '被驳回';
		  	} else if (cellValue == 3) {
		  		return '待办理';
		  	}
		  },
		  gb(){
			  this.dialogFormVisible=false;
			  this.qk();
		  },
		  kpbl(){
			  this.dialogFormVisible=true;
		  },
			qd(){
				this.kpjl.invoiceShr=this.emp;
				this.kpjl.invoiceZt=1;
				this.axios.post("http://localhost:8086/llw/qrbl",
				{'kpjl':this.kpjl})
				.then(res=>{
					if(res.obj==0){
						this.gb();
						this.getData();
						ElMessage.success({
							message: '成功',
							type: 'success'
						});
					}else{
						this.$message.error('办理失败');
					}
				}).catch((v)=>{
					console.log(v)
				})
			},
			bh(){
				this.axios.post("http://localhost:8086/llw/kpbhbl",
				{'id':this.kpjl.invoiceId,'shr':this.emp})
				.then(res=>{
					if(res.obj==0){
						this.gb();
						this.getData();
						ElMessage.success({
							message: '成功',
							type: 'success'
						});
					}else{
						this.$message.error('办理失败');
					}
				}).catch((v)=>{
					console.log(v)
				})
			}
	    },created(){
			this.emp = this.$store.state.users;
	    	this.getData()
	    }
	  };
</script>

<style>

</style>
