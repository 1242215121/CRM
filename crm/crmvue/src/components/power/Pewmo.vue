<template>
	<el-card>
		<el-row>
			<el-col :span="24">
				角色名
			</el-col>
			<el-col :span="24">
				角色描述
			</el-col>
			<el-col :span="24">
				<el-button>添加</el-button>
				<el-button>删除</el-button>
			</el-col>
		</el-row>
	</el-card>
</template>

<script>
	 export default {
	   data() {
	     return {
	       tableData: [
	         {
	           id: 1,
	           date: '2016-05-02',
	           name: '王小虎',
	           address: '上海市普陀区金沙江路 1518 弄',
	         },
	         {
	           id: 2,
	           date: '2016-05-04',
	           name: '王小虎',
	           address: '上海市普陀区金沙江路 1517 弄',
	         },
	         {
	           id: 3,
	           date: '2016-05-01',
	           name: '王小虎',
	           address: '上海市普陀区金沙江路 1519 弄',
	           children: [
	             {
	               id: 31,
	               date: '2016-05-01',
	               name: '王小虎',
	               address: '上海市普陀区金沙江路 1519 弄',
	             },
	             {
	               id: 32,
	               date: '2016-05-01',
	               name: '王小虎',
	               address: '上海市普陀区金沙江路 1519 弄',
	             },
	           ],
	         },
	         {
	           id: 4,
	           date: '2016-05-03',
	           name: '王小虎',
	           address: '上海市普陀区金沙江路 1516 弄',
	         },
	       ],
	      
	     }
	   },
	   methods: {
	 		lodeDate(){
	 			// var $this=this;
	 			// this.axios.get("/dept/all").then(res=>{
	 			// 	console.log("查询到的部门",res.data)
	 			// 	$this.dept=res.data;
	 				
	 			// })
	 		}
	   },
	   created(){
	 		this.lodeDate();
	 	},
	}
</script>

<style scoped="scoped">
	
</style>
