import axios from 'axios'
import Home from '@/components/Home.vue'

//初始化菜单
export const initModule = (router, store,next,to) => {
	//如果vuex的状态管理中存在路由信息，则不需要再次请求
	if (store.state.routes.length > 0) {
		return;
	}
	
	if (store.state.users) {
		// //获取用户信息
		// alert(store.state.users.usersId);
		// axios.get("jurisdiction/res", {
		// 	params: {
		// 		id: uid
		// 	}
		// }).then(res => {
			
		// 	let arr=[];
		// 	if (res.code == 1) {
				
		// 		//1、对后台查询到的菜单信息，就行格式化，主要目的是：要符合Vue的路由的要求
		// 		var fmtRoutes = formatRoutes(res.obj);
		// 		 // console.log("从数据库查出来的",fmtRoutes);
				
		// 		//2、将菜单信息，添加到路由对象中
		// 		fmtRoutes.forEach(row => {		
		// 		// console.log("这是row存在的",row);
		// 			row.children.forEach(r=> {
		// 				// console.log("这是row的子集",r);
		// 							//添加一级
		// 				 // console.log("这是row的子集",r.children);
		// 				if(r.children[0].type!=undefined){
		// 					// console.log(r);
		// 					 arr.push(row);
		// 					 router.addRoute(row);
		// 				}else{
		// 					 // console.log("不等于1级的或者没有权限的",r);
							
		// 					if(r.children[0].type==1){
		// 						 // console.log("这些是二级",r);
							
		// 					if(r.children[0].children[0].type==5){
		// 						console.log("满足查看条件的",r);
		// 						arr.push(row);
		// 						router.addRoute(row);
		// 					}else{
		// 						 // console.log("不满足查看条件的",r);
								 
		// 						row.children.forEach((x,index)=> {
		// 							if(x.name==r.name){
		// 							row.children.splice(index,1);
		// 							};
		// 						})　
		// 					} 
							
								
		// 					}else{
		// 						// console.log("没有权限的",r);
		// 						//删除没有权限的
		// 						　row.children.forEach((x,index)=> {
									
		// 							if(x.name==r.name){
		// 							row.children.splice(index,1);
		// 							};
		// 						})　
								
		// 					}
		// 				}
		// 			});
		// 		});
				
				
				
		// 		let ro={
		// 		path: '/',
		// 		component: Home,
		// 		name: 'Home',
		// 		redirect: '/news',
		// 		meta: {
		// 			title: "xxx后台管理系统"
		// 		}
		// 		};
		// 		if(arr==""){
		// 			arr.push(ro);
		// 			router.addRoute(arr);
					
		// 		}
				
		// 		 let resultarr = [...new Set(arr)];
				  
		// 		store.commit('initMenu',resultarr);//将路由结果存入状态管理器
				
		// 		//动态刷新之后的解决办法
		// 		// console.log("当前路由：",router.getRoutes())
		// 		next({...to,replace:true})
		// 	} else {
		// 		router.replace({
		// 			path: '/login'
		// 		});
		// 	}
		// })
		
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
				children: children
			}
		} else {
			fmRouter = {
				path: moduleUrl,
				name: moduleName,
				component:modules[`../components/${modularComponent}.vue`],
				iconcls:moduleIcon,
				children: children
			}
		}
		
		fmRoutes.push(fmRouter);
	});
	
	return fmRoutes;
}
