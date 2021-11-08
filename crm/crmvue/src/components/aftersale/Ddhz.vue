<template>
	<div style="margin-top:20px;margin-left:20px">
		<el-input v-model="nr" style="width:200px;" placeholder="请输入订单名称">
		</el-input>
		<el-button type="primary" icon="el-icon-search" @click="getData()">搜索</el-button>
	
		<el-table :data="tableData" border @row-click="xq" style="width: 100%;margin-top:10px;">
			<el-table-column prop="soId" label="订单编号"></el-table-column>
			<el-table-column prop="user.usersName" label="负责人"></el-table-column>
			<el-table-column prop="soName" label="订单名称"></el-table-column>
			<el-table-column prop="soMoney" label="订单金额"></el-table-column>
			<el-table-column prop="soOrderstatu" label="订单状态"></el-table-column>
			<el-table-column prop="soBack" label=" 回款金额"></el-table-column>
			<el-table-column prop="soPay" label=" 欠款金额"></el-table-column>
			<el-table-column prop="soReturn" label=" 退货单金额"></el-table-column>
			<el-table-column prop="soBackstatu" label=" 回款状态"></el-table-column>
			<el-table-column prop="soInvoicing" label=" 开票状态"></el-table-column>
			<el-table-column prop="soInvostatu" label=" 开票金额"></el-table-column>
			<el-table-column prop="soDate" label="成交日期" width="100px"></el-table-column>
			<el-table-column prop="soNum" label="产品数量"></el-table-column>
			<el-table-column prop="soWynum" label=" 已出库数量"></el-table-column>
			<el-table-column prop="soNonum" label=" 未出库数量"></el-table-column>
			<el-table-column prop="soWarestatu" label=" 出库状态"></el-table-column>
			<el-table-column prop="client.clientName" label="所属客户"></el-table-column>
			<el-table-column prop="salefunnelBySfId.sfName" label="关联机会"></el-table-column>
		</el-table>
		<div class="block">
			<el-pagination style="position: absolute;right:10px" @size-change="hal1" @current-change="hal"
				:page-sizes="[5, 10, 15]" :total="total" :page-size="size" :current-page="pageNo"
				layout="total, sizes, prev, pager, next, jumper">
			</el-pagination>
		</div>
		
		<el-drawer :title="btxs" v-model="drawer" :direction="direction" size='50%' :before-close="qk">
			<div style="margin-left:20px;margin-bottom: 20px;">
				<div>
					<span>负责人：{{ddjl.user.usersName}}</span>
					<span style="margin-left: 40px;">成交日期：{{ddjl.soDate}}</span>
					<span style="margin-left: 40px;">订单金额：{{ddjl.soMoney}}</span>
					<div style="margin-top: 20px;">
						<span>客户：{{ddjl.client.clientName}}</span>
					</div>
				</div>
			</div>
			<div style="margin-left:20px;">
				<el-tabs v-model="activeName" class="eee">
					<el-tab-pane label="概况" name="first">
						<span>订单信息</span>
						<div style="margin-top: 10px;">
							
						</div>
						
						<hr/>
					</el-tab-pane>
					<el-tab-pane label="回款" name="second">
						<div style="height: 40px;">
							<span>回款</span>
							<el-button style="position: absolute;right:30px" size="mini" @click="xjqc()">新建期次</el-button>
						</div>
						<div>
							<span>金额总计：{{ddjl.soMoney}}</span>
							<span style="margin-left: 20px;">已回款金额：{{ddjl.soBack}}</span>
							<span style="margin-left: 20px;">未回款金额：{{ddjl.soPay}}</span>
							<span style="margin-left: 20px;">已开票金额：{{ddjl.soInvostatu}}</span>
						</div>
						<!-- x为对象，i为下标 -->
						<div v-for="(x,i) in qc">
							<div style="width: 700px;height:100px;border: #C0C0C0 solid 1px;padding: 10px;margin-top: 10px;margin-bottom: 10px;">
								<div>
									<span>{{x.periodoftimeName}}</span>
									<el-button style="position: absolute;right:150px" size="mini" @click="xzhk(x)">添加回款</el-button>
									<el-button style="position: absolute;right:30px" size="mini" @click="xjkp(x)">新建开票申请</el-button>
									<br/>
									<br/>
									<span>负责人：{{x.periodoftimeFzr.usersFullname}}</span>
									<span style="margin-left: 20px;">计划回款日期：{{x.periodoftimeDate}}</span>
									<span style="margin-left: 20px;">计划回款：{{x.periodoftimePrice}}</span>
									<span style="margin-left: 20px;">实际回款：{{x.periodoftimeSjprice}}</span>
									<br/>
									<span>开票金额：{{x.periodoftimeKpprice}}</span>
									<el-button style="position: absolute;right:30px" size="mini" @click="qcdel(x)">删除</el-button>
								</div>
							</div>
						</div>
						
					</el-tab-pane>
					<el-tab-pane label="附件资料" name="third"></el-tab-pane>
				</el-tabs>
			</div>
		</el-drawer>
		
		<el-dialog title="新建期次" v-model="dialogFormVisible" width="40%" @close="qcqk()">
		  <el-form :model="periodoftime">
		    	<el-form-item label="关联订单" prop="periodoftimeDdid" :label-width="formLabelWidth">
		    		<el-input v-model="periodoftime.periodoftimeDdid.soName" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
		    	</el-form-item>
				<el-form-item label="期次名称" prop="periodoftimeName" :label-width="formLabelWidth">
					<el-input v-model="periodoftime.periodoftimeName" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="负责人" prop="usersFullname" :label-width="formLabelWidth">
					<el-input v-model="periodoftime.periodoftimeFzr.usersFullname" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="计划回款金额" prop="periodoftimePrice" :label-width="formLabelWidth">
					<el-input-number v-model="periodoftime.periodoftimePrice" :min="0" :max="kjhje" style="width: 280px;" label="描述文字"></el-input-number>
				</el-form-item>
				<el-form-item label="计划回款日期" prop="periodoftimeDate" :label-width="formLabelWidth">
					<el-date-picker
							        v-model="periodoftime.periodoftimeDate"
							        align="right"
							        type="date"
									style="width: 280px;"
							        placeholder="选择日期"
									value-format="YYYY-MM-DD"
							        :picker-options="pickerOptions">
							  </el-date-picker>
				</el-form-item>
				<el-form-item label="备注" prop="periodoftimeBz" :label-width="formLabelWidth">
					<el-input
					  type="textarea"
					  :autosize="{ minRows: 2, maxRows: 6}"
					  placeholder="请输入内容"
					  style="width: 280px;"
					  v-model="periodoftime.periodoftimeBz"></el-input>
				</el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer" style="text-align: center;">
		    <el-button @click="qcqk()">取 消</el-button>
		    <el-button type="primary" @click="qcqd()">确 定</el-button>
		  </div>
		</el-dialog>
	
		
		<el-dialog title="添加回款记录" v-model="dialogFormVisible1" width="40%" @close="hkqk()">
		  <el-form :model="receivable">
			  <el-form-item label="回款编号" prop="receivableId" :label-width="formLabelWidth">
			  	<el-input v-model="receivable.receivableId" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
			  </el-form-item>
		    	<el-form-item label="关联订单" prop="receivableDdid" :label-width="formLabelWidth">
		    		<el-input v-model="receivable.receivableDdid.soName" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
		    	</el-form-item>
				<el-form-item label="回款期次" prop="receivableQcid" :label-width="formLabelWidth">
					<el-input v-model="receivable.receivableQcid.periodoftimeName" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="经办人" prop="receivableJbr" :label-width="formLabelWidth">
					<el-input v-model="receivable.receivableJbr.usersFullname" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="回款金额" prop="receivablePrice" :label-width="formLabelWidth">
					<el-input-number v-model="receivable.receivablePrice" :min="0" :max="khkje" style="width: 280px;" label="描述文字"></el-input-number>
				</el-form-item>
				<el-form-item label="回款日期" prop="receivableDate" :label-width="formLabelWidth">
					<el-date-picker
							        v-model="receivable.receivableDate"
							        align="right"
							        type="date"
									style="width: 280px;"
							        placeholder="选择日期"
									value-format="YYYY-MM-DD"
							        :picker-options="pickerOptions">
							  </el-date-picker>
				</el-form-item>
				<el-form-item  label="回款方式" prop="receivableHkfs" :label-width="formLabelWidth">
					<el-select  v-model="receivable.receivableHkfs"  placeholder="请选择" style="width: 280px;" >
				     <el-option
				       v-for="item in hkfs"
				       :key="item.value"
				       :label="item.value"
				       :value="item.value">
				     </el-option>
				    </el-select>
				</el-form-item>	
				<el-form-item label="备注" prop="periodoftimeBz" :label-width="formLabelWidth">
					<el-input
					  type="textarea"
					  :autosize="{ minRows: 2, maxRows: 6}"
					  placeholder="请输入内容"
					  style="width: 280px;"
					  v-model="periodoftime.periodoftimeBz"></el-input>
				</el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer" style="text-align: center;">
		    <el-button @click="hkqk()">取 消</el-button>
		    <el-button type="primary" @click="hkqd()">确 定</el-button>
		  </div>
		</el-dialog>
			
			
		<el-dialog title="新建开票" v-model="dialogFormVisible2" width="40%" @close="kpqk()">
		  <el-form :model="invoice">
				<el-form-item label=" 申请名称" prop="invoiceName" :label-width="formLabelWidth">
					<el-input v-model="invoice.invoiceName" style="width: 280px;" autocomplete="off"></el-input>
				</el-form-item>
		    	<el-form-item label="关联订单" prop="invoiceDdid" :label-width="formLabelWidth">
		    		<el-input v-model="invoice.invoiceDdid.soName" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
		    	</el-form-item>
				<el-form-item label="关联客户" prop="invoiceKhid" :label-width="formLabelWidth">
					<el-input v-model="invoice.invoiceKhid.clientName" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="回款期次" prop="invoiceQcid" :label-width="formLabelWidth">
					<el-input v-model="invoice.invoiceQcid.periodoftimeName" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="开票金额" prop="receivablePrice" :label-width="formLabelWidth">
					<el-input-number v-model="invoice.invoicePrice" :min="0" :max="kkpje" style="width: 280px;" label="描述文字"></el-input-number>
				</el-form-item>
				<el-form-item label="经办人" prop="invoiceJbr" :label-width="formLabelWidth">
					<el-input v-model="invoice.invoiceJbr.usersFullname" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="票据类型" prop="invoicePjid" :label-width="formLabelWidth">
					<el-select  v-model="invoice.invoicePjid" value-key="papertypeId" placeholder="请选择" style="width: 280px;" >
					 <el-option
					   v-for="item in lx"
					   :key="item.papertypeId"
					   :label="item.papertypeName"
					   :value="item">
					 </el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="票据抬头" prop="invoicePjtt" :label-width="formLabelWidth">
					<el-input v-model="invoice.invoicePjtt" style="width: 280px;" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item label="纳税识别号" prop="invoiceNssbh" :label-width="formLabelWidth">
					<el-input v-model="invoice.invoiceNssbh" style="width: 280px;" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item label="备注说明" prop="invoiceBlbz" :label-width="formLabelWidth">
					<el-input
					  type="textarea"
					  :autosize="{ minRows: 2, maxRows: 6}"
					  placeholder="请输入内容"
					  style="width: 280px;"
					  v-model="invoice.invoiceBlbz"></el-input>
				</el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer" style="text-align: center;">
		    <el-button @click="kpqk()">取 消</el-button>
		    <el-button type="primary" @click="kpqd()">确 定</el-button>
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
				activeName: 'first', //选项卡
				tableData: [], //表格数据
				total: 0, //总记录数
				pageNo: 1, //起始记录数
				size: 5, //页大小
				nr: '', //输入框绑定值
				emp: {}, //当前登录用户
				drawer: false, //抽屉显示
				direction: 'rtl',
				ddjl: {}, //订单
				btxs: '', //抽屉标题
				dialogFormVisible: false,
				formLabelWidth: '120px',
				qc:[],
				periodoftime: {
				  periodoftimeId: '',
				  periodoftimeDdid: {},
				  periodoftimeName: '',
				  periodoftimeFzr: {},
				  periodoftimePrice: 0,
				  periodoftimeDate: '',
				  periodoftimeBz: '',
				  periodoftimeKhid:'',
				  periodoftimeSjprice:0,
				  periodoftimeQczt:3,
				  periodoftimeKpprice:0
				},
				kjhje:0,
				dialogFormVisible1:false,
				dialogFormVisible2:false,
				receivable:{
					receivableId:'',
					receivableDdid:{},
					receivableJbr:{},
					receivablePrice:0,
					receivableDate:'',
					receivableHkfs:'',
					receivableBz:'',
					receivableZt:3,
					receivableQcid:{},
					receivableKhid:{},
					receivableShr:{}
				},
				hkfs:[{value:'现金'},{value:'网银'},{value:'转账'},{value:'其他'}],
				khkje:0,
				hkcx:[],
				invoice:{
					invoiceId:'',
					invoicePjid:{},
					invoiceName:'',
					invoiceDdid:{},
					invoiceQcid:{},
					invoicePrice:0,
					invoiceJbr:{},
					invoicePjtt:'',
					invoiceNssbh:'',
					invoicePhone:'',
					invoiceBz:'',
					invoiceZt:3,
					invoiceKhyh:'',
					invoiceKhzh:'',
					invoiceKhdz:'',
					invoiceKhid:{},
					invoiceShr:{},
					invoiceKphm:'',
					invoiceDate:'',
					invoiceBlbz:'',
					invoiceSqdate:''
				},
				kkpje:0,
				kpcx:[],
				lx:[]
			};
		},
		methods: {
			getData(no) {
				if (no == undefined) {
					no = this.pageNo
				}
				this.axios({
					url: 'http://localhost:8086/llw/ddcx',
					params:{pageNo:no,size:this.size,'nr':this.nr}
				}).then(res => {
					console.log(res)
					this.tableData = res.obj.ddcx;
					this.total = res.obj.total;
				}).catch(function() {
	
				})
			},
			hal(val) {
				console.log(val);
				this.pageNo = val;
				this.getData();
			},
			hal1(val) {
				console.log(val);
				this.size = val;
				this.getData();
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
			xq(row, column, event) {
				console.log(row);
				this.ddjl = row;
				this.btxs = "订单名称：" + row.soName;
				this.drawer = true;
				this.qcddcx();
			},
			qcddcx(){
				this.axios({
					url: 'http://localhost:8086/llw/qcddcx',
					params:{'id':this.ddjl.soId}
				}).then(res => {
					console.log(res)
					this.qc = res.obj.qcddcx;
				}).catch(function() {
					
				})
			},
			xjqc(){
				this.periodoftime.periodoftimeDdid=this.ddjl;
				this.qcnam()
				this.periodoftime.periodoftimeFzr=this.emp;
				this.periodoftime.periodoftimeKhid=this.ddjl.client;
				this.dialogFormVisible=true;
				for(var i=0;i<this.qc.length;i++){
					this.kjhje=this.kjhje+this.qc[i].periodoftimePrice;
				}
				this.kjhje=this.ddjl.soMoney-this.kjhje;
			},
			qcnam(){
				this.periodoftime.periodoftimeName='第'+(this.qc.length+1)+'期'
			},
			qcqk(){
				this.periodoftime={
				  periodoftimeId: '',
				  periodoftimeDdid: {},
				  periodoftimeName: '',
				  periodoftimeFzr: {},
				  periodoftimePrice: 0,
				  periodoftimeDate: '',
				  periodoftimeBz: '',
				  periodoftimeKhid:'',
				  periodoftimeSjprice:0,
				  periodoftimeQczt:3,
				  periodoftimeKpprice:0
				};
				this.kjhje=0;
				this.drawer=false;
				this.dialogFormVisible=false;
			},
			qcqd(){
				if(this.periodoftime.periodoftimePrice>0 && this.periodoftime.periodoftimeDate!=''){
					this.axios.post("http://localhost:8086/llw/qcxz",
					this.periodoftime)
					.then(res=>{
						if(res.obj==0){
							this.qcqk();
							this.getData();
							ElMessage.success({
								message: '新增成功',
								type: 'success'
							});
						}else{
							this.$message.error('新增失败');
						}
					}).catch((v)=>{
						console.log(v)
					})
				}else{
					this.$message.error('计划金额要大于0，并完善信息');
				}
				
			},
			xzhk(row){
				console.log(row)
				this.khkje=row.periodoftimePrice
				this.hkqccx(row.periodoftimeId)
				this.hkbh();
				this.receivable.receivableDdid=this.ddjl;
				this.receivable.receivableQcid=row;
				this.receivable.receivableJbr=this.emp;
				this.receivable.receivableKhid=this.ddjl.client;
				this.dialogFormVisible1=true;
			},
			hkbh(){
				let yy = new Date().getFullYear();
				let mm = new Date().getMonth()+1;
				let dd = new Date().getDate();
				let hh = new Date().getHours();
				let mf = new Date().getMinutes()<10 ? '0'+new Date().getMinutes() : new Date().getMinutes();
				let ss = new Date().getSeconds()<10 ? '0'+new Date().getSeconds() : new Date().getSeconds();
				let sjs=Math.round(Math.random()*100);
				this.receivable.receivableId='Hk'+yy+mm+dd+hh+mf+ss+sjs;
			},
			hkqccx(no){
				this.axios({
					url: 'http://localhost:8086/llw/hkcxqcid',
					params:{'id':no}
				}).then(res => {
					this.hkcx = res.obj.hkjlcx;
					for(var i=0;i<this.hkcx.length;i++){
						console.log(this.hkcx[i].receivablePrice)
						this.khkje=this.khkje-this.hkcx[i].receivablePrice;
					}
				}).catch(function() {
					
				})
			},
			hkqd(){
				if(this.receivable.receivableHkfs!='' && this.receivable.receivablePrice>0 && this.receivable.receivableDate!=''){
					console.log(this.receivable)
					this.axios.post("http://localhost:8086/llw/hkxz",
					{'receivable':this.receivable})
					.then(res=>{
						if(res.obj==0){
							this.hkqk();
							this.getData();
							ElMessage.success({
								message: '新增成功',
								type: 'success'
							});
						}else{
							this.$message.error('新增失败');
						}
					}).catch((v)=>{
						console.log(v)
					})
				}else{
					this.$message.error('回款金额要大于0,并完善信息');
				}
				
			},
			hkqk(){
				this.receivable={
					receivableId:'',
					receivableDdid:{},
					receivableJbr:{},
					receivablePrice:0,
					receivableDate:'',
					receivableHkfs:'',
					receivableBz:'',
					receivableZt:3,
					receivableQcid:{},
					receivableKhid:{},
					receivableShr:{}
				}
				this.khkje=0;
				this.drawer=false;
				this.dialogFormVisible1=false;
			},
			xjkp(row){
				this.kkpje=row.periodoftimePrice;
				this.kpqccx(row.periodoftimeId)
				this.invoice.invoiceDdid=this.ddjl;
				this.invoice.invoiceJbr=this.emp;
				this.invoice.invoiceQcid=row;
				this.invoice.invoiceKhid=this.ddjl.client;
				this.dialogFormVisible2=true;
			},
			kpqd(){
				if(this.invoice.invoiceName!='' && JSON.stringify(this.invoice.invoicePjid)!='{}' && this.invoice.invoicePrice>0){
					console.log(this.invoice)
					this.axios.post("http://localhost:8086/llw/kpxz",
					this.invoice)
					.then(res=>{
						if(res.obj==0){
							this.kpqk();
							this.getData();
							ElMessage.success({
								message: '新增成功',
								type: 'success'
							});
						}else{
							this.$message.error('新增失败');
						}
					}).catch((v)=>{
						console.log(v)
					})
				}else{
					this.$message.error('请完善信息，开票金额要大于0');
				}
				
			},
			kpqk(){
				this.invoice={
					invoiceId:'',
					invoicePjid:{},
					invoiceName:'',
					invoiceDdid:{},
					invoiceQcid:{},
					invoicePrice:0,
					invoiceJbr:{},
					invoicePjtt:'',
					invoiceNssbh:'',
					invoicePhone:'',
					invoiceBz:'',
					invoiceZt:3,
					invoiceKhyh:'',
					invoiceKhzh:'',
					invoiceKhdz:'',
					invoiceKhid:{},
					invoiceShr:{},
					invoiceKphm:'',
					invoiceDate:'',
					invoiceBlbz:'',
					invoiceSqdate:''
				}
				this.kkpje=0;
				this.drawer=false;
				this.dialogFormVisible2=false;
			},
			kpqccx(no){
				this.axios({
					url: 'http://localhost:8086/llw/kpqccx',
					params:{'id':no}
				}).then(res => {
					this.kpcx = res.obj.kpqccx;
					this.lx = res.obj.pjlx;
					for(var i=0;i<this.kpcx.length;i++){
						console.log(this.kpcx[i].invoicePrice)
						this.kkpje=this.kkpje-this.kpcx[i].invoicePrice;
					}
				}).catch(function() {
					
				})
			},
			qk(){
				this.activeName='first';
				this.drawer=false;
			},
			qcdel(no){
				this.periodoftime=no;
				console.log(this.periodoftime)
				this.axios.post("http://localhost:8086/llw/qcdel",
				this.periodoftime)
				.then(res=>{
					if(res.obj==0){
						this.qcqk();
						this.getData();
						ElMessage.success({
							message: '删除成功',
							type: 'success'
						});
					}else{
						this.$message.error('删除失败,已有相关联数据');
					}
				}).catch((v)=>{
					console.log(v)
				})
			}
		},
		created() {
			this.emp = this.$store.state.users;
			this.getData();
		}
	};
</script>

<style>
	.el-drawer__body {
	    overflow: auto;
	    /* overflow-x: auto; */
	}
	
	/*2.隐藏滚动条，太丑了*/
	.el-drawer__container ::-webkit-scrollbar{
	    display: none;
	}
</style>
