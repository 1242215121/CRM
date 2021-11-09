<template>
	<h3>报价单</h3>
	<div class="top">
		<el-container>
			<el-header class="header" style="height: 40px">
				<el-button size="mini" icon="el-icon-circle-plus-outline" @click="drawer=true">报价单新增
				</el-button>
			</el-header>

			<el-main>
				<div class="search">
					<el-form :inline="true" :model="quotation" class="demo-form-inline">
						<el-form-item label="编号:" size="mini">
							<el-input v-model="quotation.id" placeholder="请输入报价单编号" type="number"></el-input>
						</el-form-item>
						<el-form-item label="名称:" size="mini">
							<el-input v-model="quotation.name" placeholder="请输入报价单名称"></el-input>
						</el-form-item>
						<el-form-item>
							<el-button type="primary" @click="onSubmit" size="mini">查询</el-button>
						</el-form-item>
					</el-form>
				</div>
				<el-table :data="quotations" style="width: 100%">
					<el-table-column prop="qId" label="报价单编号"></el-table-column>
					<el-table-column prop="salefunnelBySfId.user.usersName" label="负责人"></el-table-column>
					<el-table-column prop="qName" label="报价单名称"></el-table-column>
					<el-table-column prop="qMoney" label="报价金额"></el-table-column>
					<el-table-column prop="qDate" label="报价日期" width="100px"></el-table-column>
					<el-table-column prop="qStage" label="报价阶段"></el-table-column>
					<el-table-column prop="salefunnelBySfId.sfName" label="关联机会"></el-table-column>
					<el-table-column prop="qTime" label="最后更新时间" width="150px"></el-table-column>
					<el-table-column label="关联产品" width="200px">
						<template #default="scope">
							<p  v-if="scope.row.quotapros != null">
								<span v-for="s in scope.row.quotapros">
								{{s.product.proName}} ,
								</span>
							</p>
						</template>
					</el-table-column>
					<el-table-column label="操作"  width="200px">
						<template #default="scope">
							<el-button type="primary" size="mini" 
							v-if="scope.row.qStage=='草稿'"
							@click="update(scope.row)" 
							icon="el-icon-edit-outline" plain>修改</el-button>
							<el-button type="primary" size="mini" 
							@click="look(scope.row)"
							icon="el-icon-bank-card"  plain>查看产品</el-button>
						</template>
					</el-table-column>
				</el-table>
				<!-- 分页 -->
				<el-pagination hide-on-single-page background @current-change="handleCurrentChange" layout="prev, pager, next"
					:page-size="pageSize" :total="total">
				</el-pagination>
				<el-drawer title="新增报价单" v-model="drawer" :with-header="false" size="55%">
					<div class="big overflowAuto">
						<el-form :model="formInline" ref="formInline" :rules="rules">
							<el-form-item label="报价单名称:" class="ttsalary" prop="name">
								<el-input v-model="formInline.name" placeholder="请输入报价单名称"></el-input>
							</el-form-item>
							<el-form-item label="关联的机会:" class="ttsalary" prop="activity">
								<el-select v-model="formInline.activity" placeholder="请输入关联机会">
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
						<el-table-column prop="proInventoryUsable" label="库存数量"></el-table-column>
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
				userid:null,//登录人员编号
				salefunnel:[],//所有销售机会
				fabric: [], //所有产品信息
				oppro: [], //选中的产品信息
				dpp: false, //表单中的div是否显示
				Visible: false, //关联产品
				quotation: {},
				quotations: [],
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
						{ required: true, message: '请输入报价单名称',trigger: 'blur'},
					],
					activity:[
						{ required: true, message: '请输入关联机会', trigger: 'blur' },
					],
					
				},
			};
		},
		methods: {
			// 参数接收
			common(res) {
				let $this = this;
				// console.log("我的res", res)
				$this.quotations = res.obj.list;
				$this.total = res.obj.total
				$this.pageSize = res.obj.pageSize
				$this.pageNo = res.obj.pageNum
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
						console.log("报价单名称：",$this.formInline.name);
						console.log("关联机会：", $this.formInline.activity);
						console.log("添加的产品：", $this.oppro);
						if($this.oppro.length>0){
							this.axios.post("/quotations/insert",{
								name:$this.formInline.name,
								activity:$this.formInline.activity,
								product: $this.oppro,
							}).then(res=>{
								// console.log("调薪申请：",res.code);
								if (res.code == 1) {
									ElMessage({
										message: "报价单新增成功!",
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
			//修改报价单状态
			update(row){
				let $this = this;
				if(confirm("确定要将报价单状态改为确认状态？")){
					this.axios.get("/quotations/update", {
						params: {
							qid: row.qId,
						}
					}).then(res => {
						console.log("修改状态：", res);
						if(res.code==1){
							alert("报价单状态已修改完成！！！")
						}else{
							alert("报价单状态修改操作失误！！！")
						}
						this.loadData();			
					});
					
				}else{
					return false;
				}
			},
			//查看产品详情
			look(row) {
				let $this = this;
				$this.dialogVisible = true;
				this.axios.get("/quotapro", {
					params: {
						qid: row.qId,
					}
				}).then(res => {
					// console.log("产品组成：", res);
					$this.product = res.data;
				})
				
			},
			//多条件查询
			onSubmit() {
				let $this = this;
				console.log("机会编号---------" + $this.quotation.id);
				console.log("机会名称---------" + $this.quotation.name);
				this.axios.post("/quotations/many",{
					no: $this.pageNo,
					size: $this.pageSize,
					id:$this.quotation.id,
					name:$this.quotation.name,
				}).then(res=>{
					// console.log("报价单多条件查询", res);
					this.common(res);
					$this.index = 1;
				})
			},
			loadData() {
				let $this = this;
				$this.userid = this.$store.state.users.usersId;
				console.log("当前登录人员编号：",$this.userid);
				this.axios.get("/quotations", {
					params: {
						no: $this.pageNo,
						size: $this.pageSize
					}
				}).then(res => {
					// console.log("报价单:",res);
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
			loadProduct() {
				var $this = this;
				//查询所有产品
				this.axios.get("/hzc").then(res => {
					// console.log("产品信息:",res);
					$this.fabric = res.data;
				})
			},
			loadSale() {
				var $this = this;
				//查询所有产品
				this.axios.get("/salefunnel/select").then(res => {
					// console.log("产品信息:",res);
					$this.salefunnel = res.data;
				})
			},
		},
		created() {
			this.loadData();
			this.loadProduct();
			this.loadSale();
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
