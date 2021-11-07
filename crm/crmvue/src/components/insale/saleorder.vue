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
				<el-drawer title="新增销售机会" v-model="drawer" :with-header="false" size="50%">
					<div class="big">
						<el-form :model="formInline" ref="formInline" :rules="rules">
							<el-form-item label="机会名称:" class="ttsalary" prop="name">
								<el-input v-model="formInline.name" placeholder="请输入机会名称"></el-input>
							</el-form-item>
							<el-form-item label="机会金额:" class="ttsalary" prop="money">
								<el-input v-model="formInline.money" placeholder="请输入机会金额"></el-input>
							</el-form-item>
							<el-form-item label="负责人员:" class="ttsalary" prop="emp">
								<el-select v-model="formInline.emp" placeholder="请选择负责人员">
									<el-option v-if="users!=null" v-for="u in users" :key="u.usersId"
										:label="u.usersName" :value="u.usersId">
									</el-option>
								</el-select>
							</el-form-item>
							<el-form-item label="所属客户:" class="ttsalary" prop="custom">
								<el-select v-model="formInline.custom" placeholder="请选择所属客户">
									<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
										:label="o.oadeptName" :value="o.oadeptId">
									</el-option>
								</el-select>
							</el-form-item>
							<el-form-item label="联系人员:" class="ttsalary" prop="person">
								<el-select v-model="formInline.person" placeholder="请输入联系人员">
									<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
										:label="o.oadeptName" :value="o.oadeptId">
									</el-option>
								</el-select>
							</el-form-item>
							<el-form-item label="关联活动:" class="ttsalary" prop="activity">
								<el-select v-model="formInline.activity" placeholder="请选择关联活动">
									<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
										:label="o.oadeptName" :value="o.oadeptId">
									</el-option>
								</el-select>
							</el-form-item>
							<el-form-item label="预成交日:" class="ttsalary" prop="value2">
								<div class="block">
									<el-date-picker v-model="formInline.value2" 
									type="datetime" :disabledDate="dealDisabledDate"
									placeholder="请选择时间">
									</el-date-picker>
								</div>
							</el-form-item>
							<el-form-item class="button">
								<el-button type="primary" @click="submitForm('formInline')">提交</el-button>
								<el-button @click="resetForm()">重置</el-button>
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
				eeid: null,
				users:[],
				order: {},
				orders: [],
				product:[],
				total: 0, //总页数
				pageSize: 3, //每页的条数
				pageNo: 1, //第几页
				index: 0,
				dialogVisible:false,//产品产看状态
				starttime:null,
				drawer: false, //面板状态新增
				formInline:{},
				rules:{
					name:[
						{ required: true, message: '请输入机会名称',trigger: 'blur'},
					],
					emp:[
						{ required: true, message: '请输入负责人员', trigger: 'blur' },
					],
					custom:[
						{ required: true, message: '请输入所属客户', trigger: 'blur' },
					],
					person:[
						{ required: true, message: '请输入联系人员', trigger: 'blur' },
					],
					activity:[
						{ required: true, message: '请输入关联活动', trigger: 'blur' },
					],
					money:[
						{ required: true, message: '请输入机会金额', trigger: 'blur' },
						{pattern: /^[0-9]*$/, message: '请输入数字'},
						{pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '机会金额需要大于0'},
						
					],
					value2:[
						{ required: true, message: '请选择时间',trigger: 'blur'},
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
			//重置
			resetForm(){
				this.formInline = {};
			},
			//提交
			submitForm(formName) { //销售机会新增
				this.$refs[formName].validate((valid) => {
					if (valid) {
						//数据不为空，
						let $this = this;
						console.log("选择的时间：",$this.formInline.value2);
						$this.starttime = this.formatDate($this.formInline.value2);
						console.log("选择时间：", $this.starttime);
						console.log("出差原因：",$this.formInline.name);
						console.log("出差地点：",$this.formInline.money);
						
						// this.axios.post("/bussiness/insert",Qs.stringify({
						// 	starttime:$this.starttime,
						// 	endtime:$this.endtime,
						// 	reason:$this.formInline.reason,
						// 	address:$this.formInline.address,
						// 	eeid:$this.eeid,
						// })).then(res=>{
						// 	// console.log("调薪申请：",res.code);
						// 	if (res.code == 1) {
						// 		ElMessage({
						// 			message: "出差申请新增成功!",
						// 			type: 'success'
						// 		});
						// 		//关闭，并重新刷新页面
						// 		$this.drawer = false;
						// 		this.loadData();
								
						// 	}else{
						// 		ElMessage({
						// 			message: res.msg,
						// 			type: 'erro'
						// 		});
						// 	}
						// })
						
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
			// 负责人查询
			loadUser(){
				let $this = this;
				this.axios.get("/users").then(res => {
					console.log("负责人:",res);
					$this.users = res.data;
				})
			},
		},
		created() {
			this.loadData();
			this.loadUser();
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
	
	.ttsalary {
		width: 82%;
	}
</style>
