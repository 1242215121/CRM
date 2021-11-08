<template>
	<el-container>
		<el-header>有谱CRM
			<el-menu :default-active="activeIndex2" class="el-menu-demo" mode="horizontal" @select="handleSelect"
				background-color="" text-color="#000" active-text-color="#ffd04b">
				<el-submenu index="1">
					<template #title>
						<div>
							<el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png">
							</el-avatar>
						</div>
					</template>
					<el-menu-item index="1-1" @click="outUsers()">退出登录</el-menu-item>
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
				<el-menu
				      :uniqueOpened="true"
				      default-active="1-1"
				      class="el-menu-vertical-demo"
				      @open="handleOpen"
				      @close="handleClose"
				      background-color="slategray"
				      text-color="#fff"
				      active-text-color="#ffd04b">
					  <el-submenu v-for="(item,index) in routers" :index="index">
					       
					          <template #title>
								   <i :class="item.iconcls" style="color: #FFFFFF"></i>
									<span>
									{{item.name}}
									</span>
					  		</template>
							<el-menu-item v-if="item.children!='' " v-for="item2,index2 in item.children" :index="index+'-'+index2">
								<router-link :to="item2.path">{{item2.name}}</router-link>
								</el-menu-item>
							
					  </el-submenu>
				
					  </el-menu>
			
			</el-aside>
			<el-container>
				<!-- 视图区 -->
				<el-main>
			
					<div>
						<router-view></router-view>
					</div>

				</el-main>

			</el-container>
		</el-container>
		<el-container>
			<el-footer>
				版权归属 ©TR02005-危健林 所有
			</el-footer>
		</el-container>
	</el-container>
</template>

<script>
	import {
		ElMessage
	} from 'element-plus'
	export default {
		data() {
			return {
				
			};
		},
		methods: {
			handleOpen(key, keyPath) {
				console.log(key, keyPath);
			},
			handleClose(key, keyPath) {
				console.log(key, keyPath);
			},
			outUsers(){
				this.$confirm('确定退出系统?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					//退出登录
					this.$store.state.routers = [];
					this.$store.state.users = [];
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
			}
		},
		created() {
			console.log('当前登录用户',this.$store.state.users);
		},
		computed: {
			routers() {
				return this.$store.state.routers
				
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
		background-color: silver;
		color: #fff;
		text-align: center;
		line-height: 60px;
	}

	.el-aside {
		background-color: slategray;
		color: #fff;
		min-height: 500px;
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
		border-bottom: none;
		float: right;
		display: inline-block;
		border-radius: 70%;
		width: 80px;
		background: none;
	}
	.el-menu.el-menu--horizontal :hover{
		background: none;
	}

  
</style>
