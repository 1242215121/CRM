import axios from 'axios'
import Home from '@/components/Home.vue'

//初始化菜单
export const initModule = (router, store,next,to) => {
	//如果vuex的状态管理中存在路由信息，则不需要再次请求
	if (store.state.routers.length > 0) {
		return;
	}
	if (!store.state.users) {
		return;
	}
	
	if (store.state.users) {
		// //获取用户信息
		axios.get("users/usersRole", {
			params: {
				uid: store.state.users.usersId
			}
		}).then(res => {
			
			let arr=[];
			if (res.code == 1) {
			
				var myroutes=[];
				res.data.forEach(v=>{
					v.role.roleModule.forEach(j=>{
						
						myroutes.push(j.module);
					})
				})
				
				//1、对后台查询到的菜单信息，就行格式化，主要目的是：要符合Vue的路由的要求
				var fmtRoutes = formatRoutes(myroutes);
				 // console.log("从数据库查出来的",fmtRoutes);
				console.log(fmtRoutes,'fmtRoutes');
				//2、将菜单信息，添加到路由对象中
				fmtRoutes.forEach(rou=>{
					if(rou.children!=null){
						arr.push(rou);
						rou.children.forEach(chi=>{
						
							router.addRoute("Home",chi);
						})
					}
			
				})
				console.log(router,'路由信息');
				store.commit('initModule',arr);//将路由结果存入状态管理器
				
				//动态刷新之后的解决办法
				next({...to,replace:true})
			} else {
				router.replace({
					path: '/login'
				});
			}
		})
		
	}else{
		//没有用户信息直接返回
		return;
	}


}

//批量导入
const modules = import.meta.glob('../**/**.vue')
//组装路由
const formatRoutes = (routes) => {
	let fmRoutes = [];
	routes.forEach(router => {

		let {
			moduleUrl,
			moduleComponent,
			moduleName,
			moduleIcon,
			children
		} = router; //取数据库的数据
		
		if (children && children instanceof Array) {
			children = formatRoutes(children);
		}
		let fmRouter = {};
		if (router.moduleUrl == null) {
			fmRouter = {
				name: moduleName,
				iconcls:moduleIcon,
				children: children
			}
		} else {
			fmRouter = {
				path: moduleUrl,
				name: moduleName,
				component:modules[`../components/${moduleComponent}.vue`],
				iconcls:moduleIcon,
				children: children
			}
		}

		fmRoutes.push(fmRouter);
	});
	
	return fmRoutes;
}
