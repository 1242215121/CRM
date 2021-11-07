<template>
	<el-button type="text" @click="dialogFormVisible = true">新建期次</el-button>
	
	<el-dialog title="新建期次" v-model="dialogFormVisible" width="40%">
	  <el-form :model="periodoftime">
	    	<el-form-item label="关联订单" prop="periodoftimeDdid" :label-width="formLabelWidth">
	    		<el-input v-model="periodoftime.periodoftimeDdid.hkCpname" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
	    	</el-form-item>
			<el-form-item label="期次名称" prop="periodoftimeName" :label-width="formLabelWidth">
				<el-input v-model="periodoftime.periodoftimeName" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
			</el-form-item>
			<el-form-item label="负责人" prop="usersFullname" :label-width="formLabelWidth">
				<el-input v-model="periodoftime.periodoftimeFzr.usersFullname" style="width: 280px;" autocomplete="off"  readonly="true"></el-input>
			</el-form-item>
			<el-form-item label="计划回款金额" prop="periodoftimePrice" :label-width="formLabelWidth">
				<el-input-number v-model="periodoftime.periodoftimePrice" :min="1" style="width: 280px;" label="描述文字"></el-input-number>
			</el-form-item>
			<el-form-item label="计划回款日期" prop="periodoftimeDate" :label-width="formLabelWidth">
				<el-date-picker
						        v-model="periodoftime.periodoftimeDate"
						        align="right"
						        type="date"
								style="width: 280px;"
						        placeholder="选择日期"
								value-format="YYYY-MM-DD"
						        :picker-options="pickerOptions">
						  </el-date-picker>
			</el-form-item>
			<el-form-item label="备注" prop="periodoftimeBz" :label-width="formLabelWidth">
				<el-input
				  type="textarea"
				  :autosize="{ minRows: 2, maxRows: 6}"
				  placeholder="请输入内容"
				  style="width: 280px;"
				  v-model="periodoftime.periodoftimeBz"></el-input>
			</el-form-item>
	  </el-form>
	  <div slot="footer" class="dialog-footer" style="text-align: center;">
	    <el-button @click="dialogFormVisible = false">取 消</el-button>
	    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
	  </div>
	</el-dialog>
</template>

<script>
	export default {
	    data() {
	      return {
	        dialogFormVisible: false,//新建期次显示绑定值
	        periodoftime: {
	          periodoftimeId: '',
	          periodoftimeDdid: {},
	          periodoftimeName: '',
	          periodoftimeFzr: {},
	          periodoftimePrice: 0,
	          periodoftimeDate: '',
	          periodoftimeBz: ''
	        },//期次对象（表单数据）
	        formLabelWidth: '120px',
			ddxx:{
				soId:'',
				soName:'',
				soMoney:10000,
				soOrderstatu:'',
				soBack:0,
				soPay:10000,
				soReturn:0,
				soBackstatu:0,
				soInvoicing:0,
				soInvostatu:0,
				soDate:'', 
				soNum:0,
				soWynum:0,
				soNonum:0,
				soWarestatu:0
			}//订单信息
	      };
	    }
	  };
</script>

<style>
</style>
