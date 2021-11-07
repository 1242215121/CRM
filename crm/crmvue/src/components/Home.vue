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
					<el-menu-item index="1-1"  >
						<router-link @click="addtabs($event)" style="color: #000000;text-decoration-line: none"  to="/personal">修改密码
						</router-link>
						</el-menu-item>
					<el-menu-item index="1-2" @click="out()">退出登录</el-menu-item>
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
					  <el-submenu index="1">
					       
					          <template #title>
								   <i class="el-icon-setting"></i>
					  			 <router-link to="/FormAttribute">系统设置</router-link>
					  		</template>
							<el-menu-item index="1-1">部门管理</el-menu-item>
							<el-menu-item index="1-2">用户管理</el-menu-item>
							<el-menu-item index="1-3">权限管理</el-menu-item>
					  </el-submenu>
				      <el-submenu index="2">
						<!-- 标题插槽：完成版-->
				        <template #title>
				          <i class="el-icon-location"></i><!-- 图标 -->
				          <span>
							  市场及客户
						  </span>
				        </template>
						<el-menu-item index="2-1">
							<router-link to="/activity">市场活动</router-link>
						</el-menu-item>
						<el-menu-item index="2-2">
							<router-link to="/clue">线索</router-link>
						</el-menu-item>
						<el-menu-item index="2-3">
							<router-link to="/client">客户</router-link>
					    </el-menu-item>
						<el-menu-item index="2-4">
							<router-link to="/contacts">联系人</router-link>
						</el-menu-item>
				      </el-submenu>
	
				      <el-submenu index="3">
				        <template #title>
							 <i class="el-icon-document"></i>
							<span>
								销售过程管理
							</span>
						</template>
						<el-menu-item index="3-1">
							<router-link to="/salefunnel">销售机会</router-link>
						</el-menu-item>
						<el-menu-item index="3-2">
							<router-link to="/quotations">报价单</router-link>
						</el-menu-item>
						<el-menu-item index="3-3">
							<router-link to="/saleorder">销售订单</router-link>
						</el-menu-item>
						<el-menu-item index="3-4">
							<router-link to="/refunds">退货单</router-link>
						</el-menu-item>
				      </el-submenu>
					  <el-submenu index="4">
					    <template #title>
					  		<i class="el-icon-menu"></i>
					  		<span>
					  			回款及开票
					  		</span>
					  	</template>
					  		<el-menu-item index="4-1">
								<router-link to="/kpbl">开票办理</router-link>
							</el-menu-item>
					  		<el-menu-item index="4-2">
								<router-link to="/hkqr">回款确认</router-link>
							</el-menu-item>
					  		<el-menu-item index="4-3">
								<router-link to="/ddhz">按订单汇总</router-link>
							</el-menu-item>
					  		<el-menu-item index="4-4">
								<router-link to="/kpjl">开票记录</router-link>
							</el-menu-item>
							<el-menu-item index="4-5">
								<router-link to="/hkjl">回款记录</router-link>
							</el-menu-item>
							<el-menu-item index="4-6">
								<router-link to="/qcjl">回款期次</router-link>
							</el-menu-item>
					  </el-submenu>
					  <el-submenu index="5">
					    <template #title>
					  		<i class="el-icon-menu"></i>
					  		<span>
					  			产品
					  		</span>
					  	</template>
					  		<el-menu-item index="5-1">
								<router-link to="/Product">产品库</router-link>
							</el-menu-item>
					  		<el-menu-item index="5-2">出入库办理</el-menu-item>
					  		<el-menu-item index="5-3">出入库单</el-menu-item>
					  		<el-menu-item index="5-4">出入库流水</el-menu-item>
							<el-menu-item index="5-5">统计</el-menu-item>
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
	import { h } from 'vue'
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
		},
		created() {
			console.log('当前登录用户',this.$store.state.users);
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
		border-bottom: solid 1px #e6e6e6;
		float: right;
		display: inline-block;
	}

  
  
</style>
