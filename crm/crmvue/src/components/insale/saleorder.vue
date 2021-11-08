<template>
	<h3>销售订单</h3>
	<div class="top">
		<el-container>
			<el-header class="header" style="height: 40px">
				<el-button size="mini" icon="el-icon-circle-plus-outline" @click="drawer=true">销售订单新增
				</el-button>
			</el-header>

			<el-main>
				<div class="search">
					<el-form :inline="true" :model="order" class="demo-form-inline">
						<el-form-item label="编号:" size="mini">
							<el-input v-model="order.id" placeholder="请输入订单编号" type="number"></el-input>
						</el-form-item>
						<el-form-item label="名称:" size="mini">
							<el-input v-model="order.name" placeholder="请输入订单名称"></el-input>
						</el-form-item>
						<el-form-item>
							<el-button type="primary" @click="onSubmit" size="mini">查询</el-button>
						</el-form-item>
					</el-form>
				</div>
				<el-table :data="orders" style="width: 100%">
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
					<el-table-column label="操作" width="250px">
						<template #default="scope">
							<el-button type="primary" size="mini" @click="look(scope.row)" plain>查看</el-button>
							<el-button type="primary" size="mini" @click="ware(scope.row)" plain>新增出库单</el-button>
						</template>
					</el-table-column>
				</el-table>
				<!-- 分页 -->
				<el-pagination hide-on-single-page background @current-change="handleCurrentChange" layout="prev, pager, next"
					:page-size="pageSize" :total="total">
				</el-pagination>
				<el-drawer title="新增销售机会" v-model="drawer" :with-header="false" size="55%">
					<div class="big overflowAuto">
						<el-form :model="formInline" ref="formInline" :rules="rules">
							<el-form-item label="订单名称:" class="ttsalary" prop="name">
								<el-input v-model="formInline.name" placeholder="请输入订单名称"></el-input>
							</el-form-item>
							<el-form-item label="所属客户:" class="ttsalary" prop="custom">
								<el-select v-model="formInline.custom" placeholder="请输入所属客户">
									<el-option v-if="client!=null" v-for="c in client" :key="c.clientId"
										:label="c.clientName" :value="c.clientId">
									</el-option>
								</el-select>
							</el-form-item>
							<el-form-item label="销售机会:" class="ttsalary" prop="person">
								<el-select v-model="formInline.person" placeholder="请输入联系人员">
									<el-option v-if="salefunnel!=null" v-for="s in salefunnel" :key="s.sfId"
										:label="s.sfName" :value="s.sfId">
									</el-option>
								</el-select>
							</el-form-item>
							<el-form-item label="&nbsp;&nbsp;添加产品:">
								<el-button type="text" @click="add" icon="el-icon-circle-plus-outline">关联产品</el-button>
							</el-form-item>
							<div v-if="dpp"
							style="margin-left: 2%;border: 1px solid gray;margin-bottom:5%;width: 80%;">
								<el-table :data="oppro" style="margin: 20px;width: 95%;">
									<el-table-column prop="proId" label="产品编号" width="100px"></el-table-column>
									<el-table-column prop="proName" label="产品名称"></el-table-column>
									<el-table-column prop="proPrice" label="产品价格"></el-table-column>
									<el-table-column label="销售数量">
										<template #default="scope">
											<el-input-number v-model="scope.row.num" :min="1" size="mini">
											</el-input-number>
										</template>
									</el-table-column>
								</el-table>
							</div>
							<el-form-item class="button">
								<el-button type="primary" @click="submitForm('formInline')">提交</el-button>
								<el-button @click="resetForm()">重置</el-button>
								<el-button @click="cancel()">取消</el-button>
							</el-form-item>
						</el-form>
					</div>
				</el-drawer>
				<el-drawer title="新增销售机会" v-model="dialogVisible" :with-header="false" size="58%">
					<div class="overflowAuto" style="margin:2%;">
						<h4 style="margin-top: 1%;">产品信息</h4>
						<!-- 查看产品 -->
						<el-table :data="product" style="width: 100%">
							<el-table-column prop="product.proId" label="产品编号"></el-table-column>
							<el-table-column prop="product.proName" label="产品名称"></el-table-column>
							<el-table-column prop="product.proPrice" label="产品价格"></el-table-column>
							<el-table-column prop="proNum" label="产品数量" width="100px"></el-table-column>
						</el-table>
						<hr/>
						<div>
							<el-row>
								<el-col :span="12">
									<h4>退货单信息</h4>
								</el-col>
								<el-col :span="4"></el-col>
								<el-col :span="4"></el-col>
								<el-col :span="4">
									<p style="padding-top: 6%;">
										<el-button type="primary" size="mini" v-if="statu=true"
										@click="adds()">新增</el-button>
									</p>
								</el-col>
							</el-row>
							<!-- 退货单信息 -->
							<el-table :data="back" style="width: 100%">
								<el-table-column prop="rId" label="退货编号"></el-table-column>
								<el-table-column prop="users.usersName" label="负责人"></el-table-column>
								<el-table-column prop="rName" label="退货名称"></el-table-column>
								<el-table-column prop="rMoney" label="退货金额"></el-table-column>
								<el-table-column prop="rDate" label="退货日期" width="100px"></el-table-column>
								<el-table-column prop="rReasons" label="退货原因"></el-table-column>
								<el-table-column prop="rTel" label="联系电话" ></el-table-column>
								
							</el-table>
						</div>
					</div>
				</el-drawer>
				
				<el-dialog title="产品信息" v-model="Visible" width="50%" :before-close="handleClose">
					<!-- 查看产品 -->
					<el-table :data="fabric" style="width: 100%" @selection-change="handleSelectionChange">
						<el-table-column type="selection" width="55" />
						<el-table-column prop="proId" label="产品编号" width="100px"></el-table-column>
						<el-table-column prop="proName" label="产品名称"></el-table-column>
						<el-table-column prop="proPrice" label="产品价格"></el-table-column>
						<el-table-column prop="proInventoryAmount" label="库存数量"></el-table-column>
					</el-table>
					<el-button type="primary" @click="sure" size="mini">确定</el-button>
				</el-dialog>
				
				<!-- 新增退货单 -->
				<el-dialog title="新增退货单" v-model="rorder" width="50%" :before-close="handleClose">
					<div>
						<el-form :model="form" ref="form" :rules="rulesform">
							<el-form-item label="退货名称:" class="ttsalary" prop="name">
								<el-input v-model="form.name" placeholder="请输入退货单名称"></el-input>
							</el-form-item>
							<el-form-item label="退货原因:" class="ttsalary" prop="reason">
								<el-input v-model="form.reason" placeholder="请输入退货原因"></el-input>
							</el-form-item>
							<el-form-item label="联系电话:" class="ttsalary" prop="tel">
								<el-input v-model="form.tel" placeholder="请输入联系电话"></el-input>
							</el-form-item>
							<el-form-item label="退货方式:" class="ttsalary" prop="way">
								<el-select v-model="form.way" placeholder="请选择退货方式">
									<el-option id="1" value="现金">现金</el-option>
									<el-option id="2" value="网银转账">网银转账</el-option>
								</el-select>
							</el-form-item>
							<el-form-item label="退货日期:" class="ttsalary" prop="value2">
								<div class="block">
									<el-date-picker v-model="form.value2" type="datetime"
										:disabledDate="dealDisabledDate" placeholder="请选择时间">
									</el-date-picker>
								</div>
							</el-form-item>
							<el-form-item class="button">
								<el-button type="primary" @click="submit('form')">提交</el-button>
								<el-button @click="reset()">重置</el-button>
								<el-button @click="can()">取消</el-button>
							</el-form-item>
						</el-form>
					</div>
				</el-dialog>
			</el-main>
		</el-container>
	</div>
</template>

<script>
	import {
		ElMessage
	} from 'element-plus'

	import Qs from 'qs'
	export default {
		data() {
			return {
				statu:false,
				soId:null,//订单编号
				userid: null,
				rorder:false,//退货单新增面板
				back:[],//退货单信息
				starttime:null,
				form:{},
				rulesform:{
					name:[
						{ required: true, message: '请输入退货单名称',trigger: 'blur'},
					],
					reason:[
						{ required: true, message: '请输入退货原因', trigger: 'blur' },
					],
					way:[
						{ required: true, message: '请选择退货方式', trigger: 'blur' },
					],
					tel:[
						{ required: true, message: '请输入联系电话', trigger: 'blur' },
					],
					value2: [{
						required: true,
						message: '请选择时间',
						trigger: 'blur'
					}, ],
				},
				client: [], //客户
				salefunnel: [], //销售机会
				fabric: [], //所有产品信息
				oppro: [], //选中的产品信息
				dpp: false, //表单中的div是否显示
				Visible: false, //关联产品
				order: {},
				orders: [],
				product:[],
				total: 0, //总页数
				pageSize: 2, //每页的条数
				pageNo: 1, //第几页
				index: 0,
				dialogVisible:false,//产品产看状态
				drawer: false, //面板状态新增
				formInline:{},
				rules:{
					name:[
						{ required: true, message: '请输入订单名称',trigger: 'blur'},
					],
					custom:[
						{ required: true, message: '请输入所属客户', trigger: 'blur' },
					],
					person:[
						{ required: true, message: '请输入联系人员', trigger: 'blur' },
					],
					
				},
				
				//新增出入库单对象
				billObject:{
					billId:0,
					billAction:'',
					billCount:'',
					billWay:'销售订单',
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
					billsCount:0,
					billsRemark:'',
					billId:'',
					maxCount:''
				},
				
			};
		},
		methods: {
			// 参数接收
			common(res) {
				let $this = this;
				// console.log("我的res", res)
				$this.orders = res.obj.list;
				$this.total = res.obj.total
				$this.pageSize = res.obj.pageSize
				$this.pageNo = res.obj.pageNum
			},
			//退货单新增
			adds(row){
				console.log("新增退货单，销售订单信息：",this.soId);
				this.rorder = true;
			},
			reset(){
				this.form = {};
			},
			can(){
				this.reset();
				this.rorder = false;
			},
			//提交
			submit(formName) { //退货单新增
				this.$refs[formName].validate((valid) => {
					if (valid) {
						//数据不为空，
						let $this = this;
						console.log("退货单名称：",$this.form.name);
						console.log("退货原因：", $this.form.reason);
						console.log("退货方式：", $this.form.way);
						console.log("联系电话：", $this.form.tel);
						console.log("选择的时间：", $this.form.value2);
						$this.starttime = this.formatDate($this.form.value2);
						
						this.axios.post("/refunds/insert",{
							name: $this.form.name,
							reason: $this.form.reason,
							way: $this.form.way,
							tel:$this.form.tel,
							starttime:$this.starttime,
							userid:this.$store.state.users.usersId,
							soId:$this.soId,
						}).then(res=>{
							// console.log("调薪申请：",res.code);
							if (res.code == 1) {
								ElMessage({
									message: "退货单新增成功!",
									type: 'success'
								});
								//关闭，并重新刷新页面
								this.can();
								//根据订单编号查询所有退货单
								this.axios.get("/refunds/select",{
									params: {
										soid: $this.soId,
									}
								}).then(res => {
									console.log("退货单信息:",res);
									$this.back = res.data;
								})
								
							}else{
								ElMessage({
									message: res.msg,
									type: 'erro'
								});
							}
						})
						
					} else {
						ElMessage({
							message: "请完整填写信息",
							type: 'erro'
						});
						return false;
					}
				});
			},
			//转化成年月日
			formatDate: function(value) {
				var date = new Date(value);
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				var day = date.getDate();
				if (month < 10) {
					month = "0" + month;
				}
				if (day < 10) {
					day = "0" + day;
				}
			
				return year + "-" + month + "-" + day;
			},		
			dealDisabledDate(time) {
			    return time.getTime() <= Date.now()-24*60*60*1000;
			},  
			//查询所有产品的信息
			add() {
				let $this = this;
				$this.Visible = true;
			},
			sure() {
				//关闭产品信息弹框
				let $this = this;
				$this.Visible = false;
			},
			//选中的产品信息
			handleSelectionChange(val) {
				this.oppro = val;
				if (this.oppro.length > 0) {
					this.dpp = true;
				}
				console.log("选中的产品：", this.oppro);
			},
			//重置
			resetForm() {
				this.dpp = false;
				this.formInline = {};
				this.oppro = [];
			},
			//取消
			cancel() {
				//关闭窗口，并重置
				console.log("取消")
				this.resetForm();
				this.drawer = false;
				console.log("取消2")
			},
			//提交
			submitForm(formName) { //销售机会新增
				this.$refs[formName].validate((valid) => {
					if (valid) {
						//数据不为空，
						let $this = this;
						console.log("订单名称：",$this.formInline.name);
						console.log("所属客户：", $this.formInline.custom);
						console.log("联系人员：", $this.formInline.person);
						console.log("添加的产品：", $this.oppro);
						//添加的产品不能为空
						if($this.oppro.length>0){
							this.axios.post("/saleorder/insert",{
								name: $this.formInline.name,
								custom: $this.formInline.custom,
								person: $this.formInline.person,
								user: $this.userid,
								product: $this.oppro,
							}).then(res=>{
								// console.log("调薪申请：",res.code);
								if (res.code == 1) {
									ElMessage({
										message: "销售订单新增成功!",
										type: 'success'
									});
									//关闭，并重新刷新页面
									this.cancel();
									this.loadData();
									
								}else{
									ElMessage({
										message: res.msg,
										type: 'erro'
									});
								}
							})
							
						}else{
							ElMessage({
								message: "产品不能为空！！！",
								type: 'warning'
							});
						}
						
					} else {
						ElMessage({
							message: "请完整填写信息",
							type: 'erro'
						});
						return false;
					}
				});
			},
		
			//查看产品详情
			look(row) {
				let $this = this;
				console.log("订单编号：",row.soId)
				$this.soId = row.soId;
				$this.dialogVisible = true;
				this.axios.get("/sorderpro", {
					params: {
						soid: row.soId,
					}
				}).then(res => {
					console.log("产品组成：", res);
					$this.product = res.data;
				})
				//根据订单编号查询所有退货单
				this.axios.get("/refunds/select",{
					params: {
						soid: row.soId,
					}
				}).then(res => {
					console.log("退货单信息:",res);
					$this.back = res.data;
					if(res.data.length>0){
						$this.statu = true;
					}
				});
				
				
			},
			//多条件查询
			onSubmit() {
				let $this = this;
				console.log("机会编号---------" + $this.order.id);
				console.log("机会名称---------" + $this.order.name);
				this.axios.post("/saleorder/many",{
					no: $this.pageNo,
					size: $this.pageSize,
					id:$this.order.id,
					name:$this.order.name,
				}).then(res=>{
					// console.log("销售订单多条件查询", res);
					this.common(res);
					$this.index = 1;
				})
			},
			loadData() {
				let $this = this;
				$this.userid = this.$store.state.users.usersId;
				this.axios.get("/saleorder", {
					params: {
						no: $this.pageNo,
						size: $this.pageSize
					}
				}).then(res => {
					// console.log("销售订单:",res);
					$this.common(res);
				})
			},
			handleCurrentChange(val) {
				this.pageNo = val;
				if (this.index == 1) {
					this.onSubmit();
				}else {
					this.loadData();
				}

			},
			loadClient() {
				let $this = this;
				this.axios.get("/client").then(res => {
					console.log("客户:",res);
					$this.client = res.data;
				})
			},
			loadSale() {
				let $this = this;
				this.axios.get("/salefunnel/select").then(res => {
					console.log("销售机会:",res);
					$this.salefunnel = res.data;
				})
			},
			loadProduct() {
				var $this = this;
				//查询所有产品
				this.axios.get("/hzc").then(res => {
					// console.log("产品信息:",res);
					$this.fabric = res.data;
				})
			},
			
			ware(row){
				this.axios.get("/sorderpro", {
					params: {
						soid: row.soId,
					}
				}).then(res => {
					res.data.forEach(z=>{
						this.billsObject.preId = z.product.proId;
						this.billsObject.preName = z.product.proName;
						this.billsObject.preUnit = z.product.proUnit;
						this.billsObject.billsCount = z.proNum;
						
						this.billObject.bills.push(this.billsObject)
						this.billsObject = {
							billsId:0,
							preId:'',
							preName:'',
							preUnit:'',
							billsCount:0,
							billsRemark:'',
							billId:'',
							maxCount:''
						}
					})
					
				})
				
				 let c = 0;
				 this.billObject.bills.forEach(z=>{				
					 //数量合计
					 c += parseInt(z.billsCount) ;
				 })
				 //给出入库单主表赋值
				 var vm = this;
				 var y = new Date().getFullYear();
				 var m = vm.appendZero(new Date().getSeconds() + 1);
				 var miao  =vm.appendZero(new Date().getMilliseconds())
				 this.billObject.billId ='CKD'+ y+''+m+''+miao; 
				 this.billObject.billAction = 1;
				 this.billObject.billCount = c;
				 this.billObject.billPerson = this.$store.state.users.usersId;
				 this.billObject.billOrder = row.soId ;
				 
				 console.log(this.billObject)
				 this.axios.post('/hzc/insertBill',this.billObject)
				 .then((res)=>{
					if(res.code == 1){
						 ElMessage.success({
							message: '新增成功',
							type: 'success'
						 });					 
					}	
					this.loadData();
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
		},
		created() {
			this.loadData();
			this.loadClient();
			this.loadSale();
			this.loadProduct();
		}
	}
</script>

<style scoped>
	h3 {
		margin-top: 10px;
		text-align: center;
	}

	.top {
		margin-top: 20px;
		margin-left: 10px;
	}

	.header {
		border-bottom: 1px solid #CAC6C6;
	}

	.el-table {
		font-size: 12px;
	}

	.anniu {
		margin-top: 20px;
		margin-left: 40%;
	}

	/* 分页 */
	.el-pagination {
		margin-top: 5px;
		text-align: center;
	}

	.text {
		width: 400px;
		/* border: 1px solid red; */
	}
	
	.big {
		margin-top: 15px;
		margin-left: 13%;
		width: 80%;
		/* box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); */
	}
	
	.overflowAuto {
		overflow-y: auto;
		position: absolute;
		width: 100%;
		height: 100%;
	}
	
	.overflowAuto::-webkit-scrollbar {
		height: 6px;
		width: 6px;
	}
	
	.overflowAuto::-webkit-scrollbar-thumb {
		background: rgb(224, 214, 235);
	}
	
	.ttsalary {
		width: 82%;
	}
</style>
