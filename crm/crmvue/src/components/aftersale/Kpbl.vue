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
			<el-table
			    :data="tableData"
			    border
			    style="width: 100%;margin-top:10px;">
			    <el-table-column
			      prop="date"
			      label="日期"
			      width="180">
			    </el-table-column>
			    <el-table-column
			      prop="name"
			      label="姓名"
			      width="180">
			    </el-table-column>
			    <el-table-column
			      prop="address"
			      label="地址">
			    </el-table-column>
				<el-table-column
					fixed="right"
				  	label="操作" 
					width="300">
				  	<template v-slot:default="s">
						<el-button size="mini">处理</el-button>
				  	</template>  				
				</el-table-column>
			 </el-table>
			 <div class="block">
			     <el-pagination
				 style="position: absolute;right:10px"
			       @size-change="hal"
			       @current-change="hal"
			       :page-sizes="[5, 10, 15]"
				   :total="total"
				   :page-size="size"
				   :current-page="pageNo"
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
