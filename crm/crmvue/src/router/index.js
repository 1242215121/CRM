import Home from '@/components/Home.vue'
import Login from '@/components/login.vue'

/* 1、创建路由数组 
	path 唯一，一级路由必须以/开头
	name 唯一，可选
	component 路径对应子组件对象
	mate 可选
*/
let routes = [{
		path: '/login',
		component: Login,
		name: 'Login',
		meta: {
			title: "xxx后台管理系统"
		},
	},
	{
		path: '/Home',
		component: Home,
		name: 'Home',
		meta: {
			title: "CRM后台管理系统"
		},
		children: [
			{
				path: '/404',
				component: () => import('@/components/404.vue'),
				name: '404',
				meta: {
					title: "404"
				}
			}

		 ]
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
