import Home from '@/components/Home.vue'
import Login from '@/components/login.vue'


/* 1、创建路由数组 
	path 唯一，一级路由必须以/开头
	name 唯一，可选
	component 路径对应子组件对象
	mate 可选
*/
let routes = [
	{
		path: '/login',
		component: Login,
		name: 'Login',
		meta: {
			title: "xxx后台管理系统"
		},
	},
	{
		path: '/',
		component: Home,
		name: 'Home',
		redirect: '/usersfrom',
		meta: {
			title: "CRM后台管理系统"
		},
		children: [
				{
					path: '/usersfrom',
					component:() => import('@/components/power/UsersFrom.vue'),
					name: 'usersfrom',
					meta: {
						title: "用户新增"
					},
				},
				// {
				// 					path: '/activity',
				// 					component:() => import('@/components/presale/Activity.vue'),
				// 					name: 'activity',
				// 					meta: {
				// 						title: "市场活动"
				// 					},
				// 				},
				// 				{
				// 					path: '/clue',
				// 					component:() => import('@/components/presale/Clue.vue'),
				// 					name: 'clue',
				// 					meta: {
				// 						title: "线索"
				// 					},
				// 				},
				// 				{
				// 					path: '/client',
				// 					component:() => import('@/components/presale/Client.vue'),
				// 					name: 'client',
				// 					meta: {
				// 						title: "客户"
				// 					},
				// 				},
				// 				{
				// 					path: '/contacts',
				// 					component:() => import('@/components/presale/Contacts.vue'),
				// 					name: 'contacts',
				// 					meta: {
				// 						title: "客户"
				// 					},
				// 				},
				// 				{
				// 					path: '/users',
				// 					component:() => import('@/components/power/users.vue'),
				// 					name: 'users',
				// 					meta: {
				// 						title: "用户管理"
				// 					},
				// 				},
				// 				{
				// 					path: '/dept',
				// 					component:() => import('@/components/power/Dept.vue'),
				// 					name: 'dept',
				// 					meta: {
				// 						title: "部门管理"
				// 					},
				// 				},
				// 				{
				// 					path: '/product',
				// 					component:() => import('@/components/product/Product.vue'),
				// 					name: 'product',
				// 					meta: {
				// 						title: "产品库"
				// 					},
				// 				},
				// 				{
				// 					path: '/salefunnel',
				// 					component:() => import('@/components/insale/Salefunnel.vue'),
				// 					name: 'salefunnel',
				// 					meta: {
				// 						title: "销售机会"
				// 					},
				// 				},
				// 				{
				// 					path: '/salefunnelAdd',
				// 					component:() => import('@/components/insale/SalefunnelAdd.vue'),
				// 					name: 'salefunnelAdd',
				// 					meta: {
				// 						title: "新增销售机会"
				// 					},
				// 				},
				// 				{
				// 					path: '/quotations',
				// 					component:() => import('@/components/insale/Quotations.vue'),
				// 					name: 'quotations',
				// 					meta: {
				// 						title: "报价单"
				// 					},
				// 				},
				// 				{
				// 					path: '/saleorder',
				// 					component:() => import('@/components/insale/Saleorder.vue'),
				// 					name: 'saleorder',
				// 					meta: {
				// 						title: "销售订单"
				// 					},
				// 				},
				// 				{
				// 					path: '/refunds',
				// 					component:() => import('@/components/insale/Refunds.vue'),
				// 					name: 'refunds',
				// 					meta: {
				// 						title: "退货单"
				// 					},
				// 				},
				// 				{
				// 					path: '/kpbl',
				// 					component:() => import('@/components/aftersale/Kpbl.vue'),
				// 					name: 'kpbl',
				// 					meta: {
				// 						title: "开票办理"
				// 					},
				// 				},
				// 				{
				// 					path: '/hkqr',
				// 					component:() => import('@/components/aftersale/Hkqr.vue'),
				// 					name: 'hkqr',
				// 					meta: {
				// 						title: "回款确认"
				// 					},
				// 				},
				// 				{
				// 					path: '/hkjl',
				// 					component:() => import('@/components/aftersale/Hkjl.vue'),
				// 					name: 'hkjl',
				// 					meta: {
				// 						title: "回款记录"
				// 					},
				// 				},
				// 				{
				// 					path: '/xz',
				// 					component:() => import('@/components/aftersale/Xz.vue'),
				// 					name: 'xz',
				// 					meta: {
				// 						title: "新增"
				// 					},
				// 				},
				// 				{
				// 					path: '/qcjl',
				// 					component:() => import('@/components/aftersale/Qcjl.vue'),
				// 					name: 'qcjl',
				// 					meta: {
				// 						title: "回款期次"
				// 					},
				// 				},
				// 				{
				// 					path: '/kpjl',
				// 					component:() => import('@/components/aftersale/Kpjl.vue'),
				// 					name: 'kpjl',
				// 					meta: {
				// 						title: "开票记录"
				// 					},
				// 				},
				// 				{
				// 					path: '/ddhz',
				// 					component:() => import('@/components/aftersale/Ddhz.vue'),
				// 					name: 'ddhz',
				// 					meta: {
				// 						title: "按订单汇总"
				// 					},
				// 				}
		 ],
		 
	}
]
//2、导入路由对象
import {
	createRouter,
	createWebHistory,
	createWebHashHistory
} from 'vue-router'
//3、创建路由对象 history\routes两个键名字不要写错
let router = createRouter({
	history: createWebHistory(), //createWebHashHistory  带#号
	routes
})




//4、导出对象
export default router
