/* 封装axios */
import axios from 'axios'
// import VueAxios from 'vue-axios'
import Qs from 'qs'
import {ElMessage } from 'element-plus'

//统一的跨域前缀，其实就是你的SpringBoot的访问地址
axios.defaults.baseURL="http://localhost:8086/"
axios.defaults.timeout=100000

axios.interceptors.request.use(config=>{
	//在发起请求之前拦截处理，比如对参数格式，参数信息的验证，token信息
	return config;
})

axios.interceptors.response.use(res=>{
	//在得到服务器响应之后进行拦截
	// console.log("拦截之前的响应结果：",res);
	if(res.status==200){
		let result = res.data;//这里就是后台返回的真实数据
		if(result.code==0){
			ElMessage.warning({
				message: result.msg,
				type: 'warning'
			});
		}
	}else{
		ElMessage.error({
			message: "错误码："+res.status+",错误信息："+res.statusText,
			type: 'error'
		});
	}
	return res.data;
}
)

export default axios