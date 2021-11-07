<template>
	<div style="margin-top:20px;margin-left:20px">
		<el-input v-model="nr" style="width:200px;" placeholder="请输入订单名称">
		</el-input>
		<el-button type="primary" icon="el-icon-search" @click="getData()">搜索</el-button>

		<el-table :data="tableData" border @row-click="xq" style="width: 100%;margin-top:10px;">
			<el-table-column prop="periodoftimeDdid.soName" label="订单名称" width="150">
			</el-table-column>
			<el-table-column prop="periodoftimeKhid.clientName" label="客户名称" width="150">
			</el-table-column>
			<el-table-column prop="periodoftimeName" label="期次名称" width="150">
			</el-table-column>
			<el-table-column prop="periodoftimeFzr.usersFullname" label="负责人" width="150">
			</el-table-column>
			<el-table-column prop="periodoftimePrice" label="计划回款金额" width="150">
			</el-table-column>
			<el-table-column prop="periodoftimeDate" label="计划回款日期" width="210">
			</el-table-column>
			<el-table-column prop="yqts" label="逾期天数" width="150">
			</el-table-column>
			<el-table-column prop="periodoftimeSjprice" label="实际回款金额" width="150">
			</el-table-column>
			<el-table-column prop="periodoftimeKpprice" label="开票金额" width="150">
			</el-table-column>
			<el-table-column prop="periodoftimeBz" label="备注" width="400">
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
				tableData: [], //表格数据
				total: 0, //总记录数
				pageNo: 1, //起始记录数
				size: 5, //页大小
				nr: '', //输入框绑定值
				emp: {}, //当前登录用户
				hkjl: {}, //回款记录
			};
		},
		methods: {
			getData(no) {
				if (no == undefined) {
					no = this.pageNo
				}
				this.axios({
					url: 'http://localhost:8086/llw/qccx',
					params:{pageNo:no,size:this.size,'nr':this.nr}
				}).then(res => {
					console.log(res)
					this.tableData = res.obj.qccx;
					for(var i=0;i<this.tableData.length;i++){
						if(this.tableData[i].periodoftimeQczt!=1){
							this.tableData[i].yqts=this.getDayis(this.tableData[i].periodoftimeDate);
						}else{
							this.tableData[i].yqts='未逾期';
						}
					}
					this.total = res.obj.total;
				}).catch(function(ss) {

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
					return '已回款';
				} else if (cellValue == 2) {
					return '部分回款';
				} else if (cellValue == 3) {
					return '未回款';
				}
			},
			getDayis(dateString1){
				
				let nowdate=new Date();
				console.log(nowdate)
				console.log(dateString1)
				let y = nowdate.getFullYear();
				let m = nowdate.getMonth() + 1;
				let d = nowdate.getDate();
				let systime=y+'-'+m+'-'+d
				console.log(systime)
				let date1=new Date(systime);
				let date2=new Date(dateString1);
				let fh=''
				if(date1.getTime()>date2.getTime()){
					let xcts=Math.ceil((date1-date2)/(1*24*60*60*1000))
					fh=xcts+'天';
				}else{
					fh='未逾期'
				}
				return fh;
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
