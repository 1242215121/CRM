<template>
	<h3>销售机会</h3>
	<div class="top">
		<el-container>
			<el-header class="header" style="height: 40px">
				<el-button size="mini" icon="el-icon-circle-plus-outline" @click="add">销售机会新增
				</el-button>
			</el-header>

			<el-main>
				<div class="search">
					<el-form :inline="true" :model="sale" class="demo-form-inline">
						<el-form-item label="编号:" size="mini">
							<el-input v-model="sale.id" placeholder="请输入机会编号" type="number"></el-input>
						</el-form-item>
						<el-form-item label="名称:" size="mini">
							<el-input v-model="sale.name" placeholder="请输入机会名称"></el-input>
						</el-form-item>
						<el-form-item>
							<el-button type="primary" @click="onSubmit" size="mini">查询</el-button>
						</el-form-item>
					</el-form>
				</div>
				<el-table :data="sales" style="width: 100%">
					<el-table-column prop="sfId" label="销售机会编号"></el-table-column>
					<el-table-column prop="user.usersName" label="负责人"></el-table-column>
					<el-table-column prop="sfName" label="机会名称"></el-table-column>
					<el-table-column prop="sfMoney" label="机会金额"></el-table-column>
					<el-table-column prop="sfDate" label="预计成交日"></el-table-column>
					<el-table-column prop="sjstart" label="所属客户"></el-table-column>
					<el-table-column prop="sjresult" label="关联活动"></el-table-column>
					<el-table-column prop="sjresult" label="联系人"></el-table-column>
					<el-table-column prop="sjresult" label="关联产品"></el-table-column>
				</el-table>
				<!-- 分页 -->
				<el-pagination hide-on-single-page background @current-change="handleCurrentChange" layout="prev, pager, next"
					:page-size="pageSize" :total="total">
				</el-pagination>
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
				sale: {},
				sales: [],
				total: 0, //总页数
				pageSize: 3, //每页的条数
				pageNo: 1, //第几页
				index: 0,
				
			};
		},
		methods: {
			// 参数接收
			common(res) {
				let $this = this;
				// console.log("我的res", res)
				$this.sales = res.obj.list;
				$this.total = res.obj.total
				$this.pageSize = res.obj.pageSize
				$this.pageNo = res.obj.pageNum
			},
			//调薪申请新增 跳转页面
			add(){
				this.$router.replace("/salefunnelAdd");
			},
			//多条件查询
			onSubmit() {
				let $this = this;
				console.log("调薪编号---------" + $this.salary.sjid);
				console.log("调薪申请人---------" + $this.salary.name);
				console.log("eeeeeeeeee", this.value2 == '')
				this.axios.post("/salaryadjust", {
					no: $this.pageNo,
					size: $this.pageSize,
					sjid: $this.salary.sjid,
					name: $this.salary.name,
					starttime: $this.starttime,
					endtime: $this.endtime,
				}).then(res => {
					// console.log("调薪申请多条件查询", res);
					this.common(res);
					$this.index = 1;
				})

			},
			loadData() {
				let $this = this;
				this.axios.get("/salefunnel", {
					params: {
						no: $this.pageNo,
						size: $this.pageSize
					}
				}).then(res => {
					console.log("销售机会:",res);
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
		},
		created() {
			this.loadData();
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
</style>
