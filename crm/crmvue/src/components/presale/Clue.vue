<template>
	<div id="gap">
		<el-row>
			<el-col :span="5">
				<el-input placeholder="线索名称" size="mini" v-model="input">
				</el-input>
			</el-col>
			<el-col :span="4" :push="1">
				<el-button type="primary" size="mini" @click="getClueData()">查询</el-button>
			</el-col>
			<el-col :span="4" :push="11">
				<el-button type="primary" size="mini" @click="drawer=true">新增</el-button>
			</el-col>
		</el-row>
	</div>
	<el-drawer title="新增线索" v-model="drawer" :with-header="false" size="50%">
		<div class="big">
			<el-form>
				<el-form-item label="机会名称:" class="ttsalary">
					<el-input placeholder="请输入机会名称"></el-input>
				</el-form-item>
				<el-form-item label="机会金额:" class="ttsalary">
					<el-input placeholder="请输入机会金额"></el-input>
				</el-form-item>
				<!-- <el-form-item label="负责人员:" class="ttsalary" prop="">
					<el-select v-model="" placeholder="请输入负责人员">
						<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
							:label="o.oadeptName" :value="o.oadeptId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="所属客户:" class="ttsalary" prop="custom">
					<el-select v-model="formInline.custom" placeholder="请输入所属客户">
						<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
							:label="o.oadeptName" :value="o.oadeptId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="联系人员:" class="ttsalary" prop="person">
					<el-select v-model="formInline.person" placeholder="请输入联系人员">
						<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
							:label="o.oadeptName" :value="o.oadeptId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="关联活动:" class="ttsalary" prop="activity">
					<el-select v-model="formInline.activity" placeholder="请输入关联活动">
						<el-option v-if="oadept!=null" v-for="o in oadept" :key="o.oadeptId"
							:label="o.oadeptName" :value="o.oadeptId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="预成交日:" class="ttsalary" prop="value2">
					<div class="block">
						<el-date-picker v-model="formInline.value2" 
						type="datetime" :disabledDate="dealDisabledDate"
						placeholder="请选择时间">
						</el-date-picker>
					</div>
				</el-form-item> -->
				<el-form-item class="button">
					<el-button type="primary" @click="submitForm('formInline')">提交</el-button>
					<el-button @click="resetForm()">重置</el-button>
				</el-form-item>
			</el-form>
		</div>
	</el-drawer>
	<!-- 表格 -->
	<el-table :data="clueData" style="width: 100%">
		<el-table-column prop="clueName" label="线索名称" width="140" />
		<el-table-column prop="users.usersName" label="负责人" width="140" />
		<el-table-column prop="clueCompany" label="公司" width="170" />
		<el-table-column prop="cluePost" label="行业" width="140" />
		<el-table-column prop="clueGoState" label="跟进状态" width="140" />
		<el-table-column prop="clueDuty" label="职务" />
		<el-table-column prop="clueState" label="线索状态" />
		<el-table-column prop="clueTime" label="更新时间" width="170" />
		<el-table-column prop="cluePhone" label="联系电话" width="170" />
	</el-table>
	<!-- 分页 -->
	<el-pagination :current-page="pageNo" @current-change="getClueData" background
		layout="total,prev, pager, next,jumper" :page-size="size" :total="total">
	</el-pagination>
</template>




<script>
	import {
		ElMessage
	} from 'element-plus'
	import Qs from 'qs'
	export default {
		data() {
			return {
				drawer: false, //面板状态
				pageNo: 1,
				size: 3,
				total: 0,
				input: '',
				clueData: [],
				users: {
					usersId: '', //员工id
					usersName: '', //员姓名
				},
				clue: {
					clueName: '', //线索名称
					pageNo: 1,
					size: 3
				}
			}
		},
		methods: {
			getClueData(no) {
				this.clue.clueName = this.input;
				if (no == undefined) {
					no = this.pageNo
				}
				this.clue.pageNo = no;
				this.clue.size = this.size;
				this.axios.post(
					"clue/selectClue",
					this.clue
				).then(c => {
					console.log("34567", c);
					this.clueData = c.obj.list;
					this.total = c.obj.total;
				})

			},

		},
		created() {
			this.getClueData(this.pageNo);

		}
	}
</script>

<style>
	#gap {
		margin-top: 10px;
		margin-left: 10px;
	}

	.big {
		margin-top: 15px;
		margin-left: 13%;
		width: 80%;
		/* box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); */
	}

	.ttsalary {
		width: 82%;
	}
</style>
