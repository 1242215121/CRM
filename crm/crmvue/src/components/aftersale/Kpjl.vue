<template>
	<div style="margin-top:20px;margin-left:20px">
		<el-input v-model="nr" style="width:200px;" placeholder="请输入订单名称">
		</el-input>
		<el-button type="primary" icon="el-icon-search" @click="getData()">搜索</el-button>

		<el-table :data="tableData" border @row-click="xq" style="width: 100%;margin-top:10px;">
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
			<el-table-column prop="invoicePjid.papertypeName" label="开票类型" width="150" show-overflow-tooltip :formatter="ztxs">
			</el-table-column>
			<el-table-column prop="invoiceKphm" label="开票号码" width="150">
			</el-table-column>
			<el-table-column prop="invoiceShr.usersFullname" label="办理人" width="150">
			</el-table-column>
			<el-table-column prop="invoiceZt" label="开票状态" width="150" show-overflow-tooltip :formatter="ztxs">
			</el-table-column>
			<el-table-column prop="invoiceBz" label="备注" width="400">
			</el-table-column>

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
					url: 'http://localhost:8086/llw/kpcx',
					params:{pageNo:no,size:this.size,'nr':this.nr}
				}).then(res => {
					console.log(res)
					this.tableData = res.obj.kpcx;
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
