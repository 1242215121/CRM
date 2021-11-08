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
	</div>	
</template>

<script>
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
			}
		},
		created() {
			this.emp = this.$store.state.users;
			this.getData();
		}
	};
</script>

<style>
</style>
