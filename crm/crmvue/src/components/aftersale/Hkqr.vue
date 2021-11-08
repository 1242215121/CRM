<template>
		<div style="margin-top:20px;margin-left:20px">
			<el-tabs v-model="activeName" @tab-click="handleClick">
				<el-tab-pane label="待确认" name="first"></el-tab-pane>
				<el-tab-pane label="已确认" name="second"></el-tab-pane>
				<el-tab-pane label="已驳回" name="third"></el-tab-pane>
			</el-tabs>
		</div>
		<div style="margin-top:20px;margin-left:20px">
			<el-input v-model="nr" style="width:200px;" placeholder="请输入回款编号" >
			</el-input>
			<el-button type="primary" icon="el-icon-search" @click="getData()">搜索</el-button>
			<div style="display: inline-block;position: absolute;right:10px;">
				<el-button type="primary" @click="qd()" v-if="anxs">确认</el-button>
				<el-button type="danger"  @click="bh()" v-if="anxs">驳回</el-button>
			</div>
			
			<el-table
			    :data="tableData"
				@selection-change="selectionLineChangeHandle"
			    border
			    style="width: 100%;margin-top:10px;">
				<el-table-column
				  type="selection"
				  width="55">
				</el-table-column>
			    <el-table-column
			      prop="receivableId"
			      label="回款编号"
			      width="150">
			    </el-table-column>
			    <el-table-column
			      prop="receivableDdid.soName"
			      label="订单名称"
			      width="150">
			    </el-table-column>
			    <el-table-column
			      prop="receivableKhid.clientName"
			      label="客户名称"
				  width="150">
			    </el-table-column>
				<el-table-column
				  prop="receivableQcid.periodoftimeName"
				  label="回款期次"
				  width="150">
				</el-table-column>
				<el-table-column
				  prop="receivableJbr.usersFullname"
				  label="经办人"
				  width="150">
				</el-table-column>
				<el-table-column
				  prop="receivablePrice"
				  label="回款金额"
				  width="150">
				</el-table-column>
				<el-table-column
				  prop="receivableDate"
				  label="回款日期"
				  width="210">
				</el-table-column>
				<el-table-column
				  prop="receivableZt"
				  label="状态"
				  width="150"
				  show-overflow-tooltip
				  :formatter="ztxs">
				</el-table-column>
				<el-table-column
				  prop="receivableHkfs"
				  label="回款方式"
				  width="150">
				</el-table-column>
				<el-table-column
				  prop="receivableShr.usersFullname"
				  label="审核人"
				  width="150">
				</el-table-column>
				<el-table-column
				  prop="receivableBz"
				  label="备注"
				  width="400">
				</el-table-column>
			 </el-table>
			 <div class="block">
			     <el-pagination
				 style="position: absolute;right:10px"
			       @size-change="hal1"
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
			zt:3,
			hk:[],
			nr:'',
			emp:{},
			anxs:true
	      };
	    },
	    methods: {
	      handleClick(tab, event) {
	        console.log(this.activeName);
			if(this.activeName=='first'){
				this.anxs=true;
				this.zt=3;
			}else if(this.activeName=='second'){
				this.anxs=false;
				this.zt=1;
			}else if(this.activeName=='third'){
				this.anxs=false;
				this.zt=2;
			}
			this.getData();
	      },
		  getData(no){
			  if(no == undefined){
			  	no = this.pageNo
			  }
			  this.axios({
			  	url:'http://localhost:8086/llw/hkcx',
			  	params:{pageNo:no,size:this.size,'zt':this.zt,'nr':this.nr}
			  }).then(res=>{
				console.log(res)
				this.tableData = res.obj.hkcx;
			  	this.total=res.obj.total;
			  }).catch(function(){
			  	
			  })
		  },
		  hal(val){
		  	console.log(val);
		  	this.pageNo=val;
		  	this.getData();
		  },
		  hal1(val){
		  	console.log(val);
		  	this.size=val;
		  	this.getData();
		  },
		  selectionLineChangeHandle (val) {
		       this.hk = val
		  },qd(){
			  console.log(this.hk)
			  this.axios.post("http://localhost:8086/llw/hkqr",
			  {'hk':this.hk,'emp':this.emp})
			  .then((v)=>{
			  	this.getData();
			  }).catch((v)=>{
			  	console.log(v)
			  })
		  },
		  bh(){
				this.axios.post("http://localhost:8086/llw/hkbh",
				{'hk':this.hk,'emp':this.emp})
				.then((v)=>{
					this.getData();
				}).catch((v)=>{
					console.log(v)
				})
		  },
		  ztxs(row, column, cellValue){
				if (cellValue == '1'){
				    return '已确认';
				}else if (cellValue == '2'){
				    return '被驳回';
				}else if (cellValue == '3'){
				    return '待确认';
				}
			}
	    },created(){
			this.emp=this.$store.state.users;
			this.getData();
		}
	  };
</script>

<style>

</style>
