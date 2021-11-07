<template>
	<div style="margin-top:20px;margin-left:20px">
		<el-input v-model="nr" style="width:200px;" placeholder="请输入回款编号">
		</el-input>
		<el-button type="primary" icon="el-icon-search">搜索</el-button>

		<el-table :data="tableData" border @row-click="xq" style="width: 100%;margin-top:10px;">
			<el-table-column prop="receivableId" label="回款编号" width="150">
			</el-table-column>
			<el-table-column prop="receivableDdid.soName" label="订单名称" width="150">
			</el-table-column>
			<el-table-column prop="receivableKhid.clientName" label="客户名称" width="150">
			</el-table-column>
			<el-table-column prop="receivableQcid.periodoftimeName" label="回款期次" width="150">
			</el-table-column>
			<el-table-column prop="receivableJbr.usersFullname" label="经办人" width="150">
			</el-table-column>
			<el-table-column prop="receivablePrice" label="回款金额" width="150">
			</el-table-column>
			<el-table-column prop="receivableDate" label="回款日期" width="210">
			</el-table-column>
			<el-table-column prop="receivableZt" label="状态" width="150" show-overflow-tooltip :formatter="ztxs">
			</el-table-column>
			<el-table-column prop="receivableHkfs" label="回款方式" width="150">
			</el-table-column>
			<el-table-column prop="receivableShr.usersFullname" label="审核人" width="150">
			</el-table-column>
			<el-table-column prop="receivableBz" label="备注" width="400">
			</el-table-column>

		</el-table>
		<div class="block">
			<el-pagination style="position: absolute;right:10px" @size-change="hal1" @current-change="hal"
				:page-sizes="[5, 10, 15]" :total="total" :page-size="size" :current-page="pageNo"
				layout="total, sizes, prev, pager, next, jumper">
			</el-pagination>
		</div>


		<el-drawer :title="btxs" v-model="drawer" :direction="direction" size='50%' :before-close="handleClose">
			<div style="margin-left:20px;">
				<div style="width: 150px;display: inline-block;">
					<p>经办人：{{hkjl.receivableJbr.usersFullname}}</p>
					<p>审核人：{{hkjl.receivableShr.usersFullname}}</p>
				</div>
				<div style="width: 260px;margin-left: 20px;display: inline-block;">
					<p>回款金额：{{hkjl.receivablePrice}}</p>
					<p>回款日期：{{hkjl.receivableDate}}</p>
				</div>
				<div style="width: 200px;margin-left: 20px;display: inline-block;">
					<p>关联客户：{{hkjl.receivablePrice}}</p>
					<p>销售订单：{{hkjl.receivableDdid.soName}}</p>
				</div>
			</div>
			<div style="margin-top:20px;margin-left:20px;">
				<el-tabs v-model="activeName" @tab-click="handleClick">
					<el-tab-pane label="概况" name="first">
						<div style="height: 100px;">
							<span>回款方式：{{hkjl.receivableHkfs}}</span>
							<span style="margin-left: 300px;">审核状态：{{zt}}</span>
							<p>备注：{{hkjl.receivableBz}}</p>
						</div>
						<div style="margin-top:20px;">
							<span>关联产品：</span>
							<el-table :data="hkxq" border style="width: 100%;margin-top: 10px;">
								<el-table-column prop="hkCpid" label="产品编号" width="150">
								</el-table-column>
								<el-table-column prop="hkCpname" label="产品名称" width="150">
								</el-table-column>
								<el-table-column prop="hkSl" label="销售数量" width="150">
								</el-table-column>
								<el-table-column prop="hkXszje" label="销售总价" width="150">
								</el-table-column>
								<el-table-column prop="hkHkprice" label="本次回款金额" width="150">
								</el-table-column>
								<el-table-column prop="hkBz" label="备注" width="400">
								</el-table-column>
							</el-table>
						</div>
					</el-tab-pane>
					<el-tab-pane label="附件资料" name="second"></el-tab-pane>
				</el-tabs>
			</div>
		</el-drawer>
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
				drawer: false, //抽屉显示
				direction: 'rtl',
				hkjl: {}, //回款记录
				btxs: '', //抽屉标题
				zt: '', //状态显示值
				hkjlxq: [] //回款关联产品
			};
		},
		methods: {
			getData(no) {
				if (no == undefined) {
					no = this.pageNo
				}
				this.axios({
					url: 'http://localhost:8086/llw/hkcx',
					params: {
						pageNo: no,
						size: this.size,
						'zt': '',
						'nr': this.nr
					}
				}).then(res => {
					console.log(res)
					this.tableData = res.obj.hkcx;
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
					return '已确认';
				} else if (cellValue == 2) {
					return '被驳回';
				} else if (cellValue == 3) {
					return '待确认';
				}
			},
			xq(row, column, event) {
				console.log(row);
				this.hkjl = row;
				this.btxs = "回款编号：" + row.receivableId;
				if (row.receivableZt == 1) {
					this.zt = '已确认';
				} else if (row.receivableZt == 2) {
					this.zt = '被驳回';
				} else if (row.receivableZt == 3) {
					this.zt = '待确认';
				}
				this.drawer = true;
				this.hkxqgetData();
			},
			handleClose(done) {
				this.$confirm('确认关闭？')
					.then(_ => {
						done();
					})
					.catch(_ => {});
			},
			hkxqgetData() {
				this.axios({
					url: 'http://localhost:8086/llw/hkxqcx'
				}).then(res => {
					console.log(res)
					this.hkjlxq = res.obj.hkxqcx;
				}).catch(function() {
			
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
</style>
