<template>
	<el-container>
		<el-header>蓝天OA
			<el-menu :default-active="activeIndex2" class="el-menu-demo" mode="horizontal" @select="handleSelect"
				background-color="" text-color="#000" active-text-color="#ffd04b">
				<el-submenu index="1">
					<template #title>
						<div>
							<el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png">
							</el-avatar>
						</div>
					</template>
					<el-menu-item index="1-1">个人办公</el-menu-item>
					<el-menu-item index="1-2"  >
						<router-link @click="addtabs($event)" style="color: #000000;text-decoration-line: none"  to="/personal">修改密码
						</router-link>
						</el-menu-item>
					<el-menu-item index="1-3" @click="out()">退出登录</el-menu-item>
				</el-submenu>
			</el-menu>
		</el-header>
		<el-container>
			<!-- 菜单区 -->
			<el-aside width="200px">
				<!-- 导航菜单 
				uniqueOpened 是否每次只打开一个菜单
				default-active 默认活动的菜单的键
				class        菜单的样式名，允许自定义
				事件@open    菜单展开时的事件
				事件@close   菜单关闭时的事件
				background-color 整个菜单的背景颜色
				text-color   菜单文字的字体颜色
				active-text-color 活动菜单文字颜色
				两个子组件：
					el-submenu    可展开的菜单项，
								  可包含el-menu-item，以及el-menu-item-group
					el-menu-item  单个的菜单项
			-->


				<el-menu :uniqueOpened="true" :default-active="editableTabsValue" class="el-menu-vertical-demo"
					@open="handleOpen" @close="handleClose" background-color="#545c64" text-color="#fff"
					active-text-color="#ffd04b">
						<el-menu-item index="0">
								<i class="el-icon-menu"></i>
								<router-link to="/news">首页中心</router-link>
							</el-menu-item>

					<template v-for="(item,index) in routes">

						<template v-if="item.children!=undefined">

						<template v-if="item.name!='个人办公'">
							<el-submenu :index='index'>
								<!-- 标题插槽：完成版-->



								<template #title>
									<i :class="item.iconcls"></i>
									<span>{{item.name}}</span><!-- 菜单名称 -->


								</template>



								<template v-if="item.children!='' ">
									<template v-for="arr,index1 in item.children">
										
										<template v-if="arr.children[0].type==5">
											<template v-if="arr.type!=-1">
											<el-menu-item :index="index+'-'+index1">
												<i :class="arr.iconcls"></i>
												<router-link @click="addtabs($event)"  :to="arr.path">{{arr.name}}
												</router-link>
											</el-menu-item>
										</template>
										</template>
										
										<template v-else>
											
											<el-submenu :index="index+'-'+index1">
												<!-- 标题插槽：完成版-->
												<template #title>
													<i :class="arr.iconcls"></i>
													<span>{{arr.name}}</span><!-- 菜单名称 -->
												</template>
												
												<template v-for="arrs,index2 in arr.children">
													<template v-if="arrs.type!=-1">
											<el-menu-item :index="index+'-'+index1+'-'+index2">
												<i :class="arrs.iconcls"></i>
												
												<router-link @click="addtabs($event)" :to="arrs.path" >{{arrs.name}}
												</router-link>
												
											</el-menu-item>
													</template>
													</template>
												
												
												</el-submenu>
												
												
												
										</template>
										
								

									</template>

								</template>
							</el-submenu>

						</template>

						</template>
					</template>

				</el-menu>

			</el-aside>
			<el-container>
				<!-- 视图区 -->
				<el-main>
					<el-tabs type="card" @tab-remove="removeTab" @tab-click="gorouter" v-model="thistag">
						<el-tab-pane label="首页" name="news" :closable="false">
						</el-tab-pane>
						<el-tab-pane v-for="(item, index) in editableTabs" closable :label="item.title"
							:name="item.type" :title="item.title">
							
						</el-tab-pane>
					</el-tabs>


					<div>
						<router-view></router-view>
					</div>

				</el-main>

			</el-container>
		</el-container>
		<el-container>
			<el-footer>
				版权归属 ©TR02005-危健林 所有

				<el-badge :value="informNumber" type="danger" class="item">
				<el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
					<svg t="1625815187444" class="icon" viewBox="0 0 1024 1024" version="1.1"
						xmlns="http://www.w3.org/2000/svg" p-id="1218" width="32" height="32">
						<path
							d="M409.6 398.222q34.133 0 34.133 34.133v68.267q0 34.133-34.133 34.133t-34.133-34.133v-68.267q0-34.133 34.133-34.133z m227.555 0q34.134 0 34.134 34.133v68.267q0 34.133-34.134 34.133t-34.133-34.133v-68.267q0-34.133 34.133-34.133z"
							fill="#209CDC" p-id="1219"></path>
						<path
							d="M873.177 858.726A498.62 498.62 0 0 0 1012.622 512c0-276.025-224.552-500.622-500.576-500.622C235.93 11.264 11.378 235.861 11.378 512c0 276.025 224.552 500.622 500.576 500.622h364.68c17.773 0 33.884-10.285 41.37-26.283a45.625 45.625 0 0 0-6.144-48.65m-103.697 1.683H512C276.366 939.349 84.65 747.634 84.65 512S276.367 84.65 512 84.65 939.35 276.367 939.35 512a425.301 425.301 0 0 1-119.035 295.936c-34.224 35.499-31.425 84.582-12.152 131.436z"
							fill="#209CDC" p-id="1220"></path>
					</svg>
				</el-button>
				</el-badge>

				<el-drawer title="消息通知" size="40%;" v-model="drawer" :direction="direction"
					:before-close="newshandleClose" destroy-on-close>

					<el-table :data="tableData" size="mini" style="width: 600px;margin: 10px;" @cell-click="rowClick">
						<el-table-column label="通知时间" width="200">
							<template #default="scope">
								<i class="el-icon-time"></i>
								<span>{{ scope.row.informTime }}</span>
							</template>
						</el-table-column>
						<el-table-column label="通知主题" width="120">
							<template #default="scope">
								<span>{{ scope.row.informTitle }}</span>
							</template>
						</el-table-column>
						<el-table-column label="通知内容" width="200">
							<template #default="scope">
								<span>{{ scope.row.informContent }}</span>
							</template>
						</el-table-column>
						<el-table-column label="通知状态">
							<template #default="scope">
								<span>{{ scope.row.informEmps[0].informState==0?'未读':'已读' }}</span>
							</template>
						</el-table-column>
					</el-table>

					<div class="block">
						<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
							:current-page=pageNo :page-sizes="[5,6]" :page-size=pageSize
							layout="total, sizes, prev, pager, next, jumper" :total=total>
						</el-pagination>
					</div>

					<el-radio-group v-model="direction">
						<el-radio label="ltr" style="margin-right: 20px;">左侧显示</el-radio>
						<el-radio label="rtl">右侧显示</el-radio>
					</el-radio-group>
				</el-drawer>

			</el-footer>
		</el-container>
	</el-container>
</template>

<script>
	import {
		ElMessage
	} from 'element-plus'
	import { h } from 'vue'
	export default {
		data() {
			return {
				activeIndex: '1',
				activeIndex2: '1',
				drawer: false,
				direction: 'rtl',
				editableTabs: [],
				thistag: '-1',
				tableData: [],
				total: 0,
				pageSize: 5,
				pageNo: 1,
				informNumber:0
			};
		},
		methods: {
			out() {
				this.$confirm('确定退出系统?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {

					//退出登录
					this.$store.state.routes = [];
					this.$store.state.users = [];
					this.$store.state.emp = [];
					this.$router.addRoute([]);
					this.$router.replace({
						path: '/login'
					});

				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消'
					});
				});


			},
			handleOpen(key, keyPath) {
				console.log(key, keyPath);
			},
			handleClose(key, keyPath) {
				console.log(key, keyPath);
			},
			handleSelect(key, keyPath) {
				console.log(key, keyPath);
			},
			newshandleClose(done) {
				this.$confirm('确认关闭？')
					.then(_ => {
						done();
					})
					.catch(_ => {});
			},
			//标签页
			addtabs(e) {
				this.editableTabs = this.$store.state.tags
				var $this = this;
				var bo = this.editableTabs.find(item => item.title == e.target.innerText)
				if (!bo) {
					this.editableTabs.push({
						title: e.target.innerText,
						type: e.target.href,
						name: $this.editableTabs.length
					});
					//更换选中的标签页
					this.thistag = this.editableTabs[this.editableTabs.length - 1].name;
				}

			},
			removeTab(targetName) {
				console.log(this.editableTabs, "?????????");
				var bo = this.editableTabs.findIndex(item => item.title == targetName);
				var bp = this.editableTabs[this.editableTabs.length - 2];
				if (!bp) {
					this.$router.replace("news");
					this.thistag = '-1';
				} else {
					this.$router.replace(bp.type);
					this.thistag = bp.name;
				}
				this.editableTabs.splice(bo, 1);

			},
			//标签跳路由方法
			gorouter(tab) {
				this.$router.replace(tab.props.name);
				// this.$router.push("account");
			},
			//加载数据  get请求，获取的是集合数据
			loadData() {
				var $this=this;
				var myuid = this.$store.state.users.usersId;
				this.axios.get("/inform/byempid", {
						params: {
							no: this.pageNo,
							size: this.pageSize,
							uid: myuid
						}
					})
					.then(res => {
						console.log("封装之后返回的响应对象：", res);
						this.tableData = res.obj.list; //返回的是封装好的MyResult对象。data存储的是集合
						this.total = res.obj.total;

					})
				setTimeout(function(){//延时方法调自己
					$this.loadData();
				},30000);
			},
			notmessage() {
				var $this=this;
				var myuid = this.$store.state.users.usersId;
				this.informNumber=0;
				this.axios.get("/inform/byempid", {
						params: {
							uid: myuid
						}
					})
					.then(res => {
						res.obj.list.forEach(v=>{
							if(v.informEmps[0].informState==0){
								this.$notify({
								          title: '未读通知',
										  type: 'info',
										  // duration:0,
								          message: h(
								            'i',
								            { style: 'color: teal' },
								            v.informContent
								          ),
								 })
								this.informNumber +=1;
							}
						})

					})
					setTimeout(function(){//延时方法调自己
						$this.notmessage();
					},180000);
			},
			handleSizeChange(val) {
				this.pageSize = val;
				this.loadData();
			},
			handleCurrentChange(val) {
				this.pageNo = val;
				this.loadData();
			},
			rowClick(row, column) {
				console.log('点击了某一行', row);
				if(row.informTitle=="补卡申请"){
					this.$router.replace("/attendance");
				    this.drawer = false;
				    return;
				}
				this.axios.get("/inform/setstate", {
						params: {
							id: row.informEmps[0].informEmpId
						}
					})
					.then(res => {
						this.$router.push({
							name: row.informTitle,
							params: {
								tableId: row.tableId
							}
						});
							this.drawer = false;
					})

			},
		},
		created() {

			this.loadData();
			this.notmessage();
		},
		computed: {
			routes() {
				return this.$store.state.routes
			}
		}
	}
</script>

<style scoped="scoped">
	* {
		padding: 0px;
		margin: 0px;
	}

	html,
	body {
		height: 100%;
	}

	.el-header,
	.el-footer {
		background-color: skyblue;
		color: #fff;
		text-align: center;
		line-height: 60px;
	}

	.el-aside {
		background-color: #2C3E50;
		color: #fff;
		min-height: 600px;
	}

	.el-main {
		background-color: #fff;
		color: #333;
	}
</style>
<style scoped="scoped">
	.el-submenu.is-opened>.el-submenu__title .el-submenu__icon-arrow {
		color: deeppink;
	}

	.el-submenu__title i {
		color: yellow;
	}

	.el-aside a {
		text-decoration: none;
		color: inherit;
		/* inherit继承 */
	}

	/* 用户样式 */
	.el-menu.el-menu--horizontal {
		border-bottom: solid 1px #e6e6e6;
		float: right;
		display: inline-block;
	}

	/* 消息提醒 */
	.el-button--primary {
		color: #FFF;
		background: none;
		border: none;
		position: fixed;
		bottom: 80px;
		right: 20px;
		border-radius: 50%;
	}
	.item {
    margin-top: 10px;
    margin-right: 40px;
	color: #FFF;
	background-color: red;
	border: none;
	position: fixed;
	bottom: 115px;
	right: -15px;
	border-radius: 50%;
  }
  
</style>
