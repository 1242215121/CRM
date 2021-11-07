<template>
	<router-view></router-view>
</template>

<script>
	/* 
	 1、页面刷新前的触发事件beforeunload
		将state中的数据暂时存储到sessionStorage中
	 2、Vue的钩子函数中，将sessionStorage中的值，赋值给state
		sessionStorage清空
	 */
	export default{
		data(){
			return{
				
			}
		},
		methods:{
			
		},
		created(){	
			//判断sessionStorage中键state有没有值
			if(sessionStorage.getItem("state")){
				let mystate = JSON.parse(sessionStorage.getItem("state"))
				
				this.$store.replaceState(
					Object.assign(
						{},
						this.$store.state,
						mystate
					)
				)
				sessionStorage.removeItem("state");
				
			}
		},
		mounted(){
			//在刷新页面之前把全部路由储存到routes数组里 在sessionStorage保存起来
			let state = this.$store.state;
			state.routers=[];
			//注册beforeunload事件，让其在页面刷新前的一瞬间执行转存操作
			window.addEventListener("beforeunload",function(){
				let stateStr = JSON.stringify(state);
				 
				sessionStorage.setItem("state",stateStr);
			})
		}
	}
</script>


<style>
</style>
