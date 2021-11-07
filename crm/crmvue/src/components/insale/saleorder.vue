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
					<el-table-column label="操作">
						<template #default="scope">
							<el-button type="primary" size="mini" @click="look(scope.row)" plain>查看产品</el-button>
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
							<el-form-item label="订单金额:" class="ttsalary" prop="money">
								<el-input v-model="formInline.money" placeholder="请输入订单金额"></el-input>
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
				<el-dialog title="产品明细" v-model="dialogVisible" width="42%" :before-close="handleClose">
					<!-- 查看产品 -->
					<el-table :data="product" style="width: 100%">
						<el-table-column prop="product.proId" label="产品编号"></el-table-column>
						<el-table-column prop="product.proName" label="产品名称"></el-table-column>
						<el-table-column prop="product.proPrice" label="产品价格"></el-table-column>
						<el-table-column prop="proNum" label="产品数量"></el-table-column>
					</el-table>
				</el-dialog>
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
				userid: null,
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
				pageSize: 3, //每页的条数
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
					money:[
						{ required: true, message: '请输入订单金额', trigger: 'blur' },
						{pattern: /^[0-9]*$/, message: '请输入数字'},
						{pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '订单金额需要大于0'},
					],
					
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
						console.log("订单金额：",$this.formInline.money);
						console.log("所属客户：", $this.formInline.custom);
						console.log("联系人员：", $this.formInline.person);
						console.log("添加的产品：", $this.oppro);
						//添加的产品不能为空
						if($this.oppro.length>0){
							this.axios.post("/saleorder/insert",{
								name: $this.formInline.name,
								money: $this.formInline.money,
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
			//查看产品详情
			look(row) {
				let $this = this;
				console.log("订单编号：",row.soId)
				$this.dialogVisible = true;
				this.axios.get("/sorderpro", {
					params: {
						soid: row.soId,
					}
				}).then(res => {
					console.log("产品组成：", res);
					$this.product = res.data;
			
				})
				
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
