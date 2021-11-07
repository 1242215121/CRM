<template>
		<div style="margin-top:20px;margin-left:20px">
			<el-tabs v-model="activeName" @tab-click="handleClick">
				<el-tab-pane label="待办理" name="first"></el-tab-pane>
				<el-tab-pane label="已办理" name="second"></el-tab-pane>
				<el-tab-pane label="已驳回" name="third"></el-tab-pane>
			</el-tabs>
		</div>
		<div style="margin-top:20px;margin-left:20px">
			<el-input v-model="input" style="width:200px;" placeholder="请输入内容" >
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
		</div>
	 
</template>

<script>
	export default {
	    data() {
	      return {
	        activeName: 'first',
			input:'',
			tableData:[],
			total:0,
			pageNo:1,
			size:5,
			zt:0
	      };
	    },
	    methods: {
	      handleClick(tab, event) {
	        console.log(this.activeName);
			if(this.activeName=='first'){
				this.zt=0;
			}else if(this.activeName=='second'){
				this.zt=1;
			}else if(this.activeName=='third'){
				this.zt=2;
			}
			this.getData();
	      },
		  getData(){
			  console.log("1")
		  },
		  hal(val){
		  	console.log(val);
		  	this.pageNo=val;
		  	this.getData();
		  }
	    }
	  };
</script>

<style>

</style>
