/* 导入vuex的相关函数 */
import {createStore} from 'vuex'
import axios from 'axios'
import qs from 'qs'

/* 创建store对象 */
let store = createStore({
	/* 状态管理 */
	state:{
		users:{}
	},
	/* 同步函数：修改状态中的变量 */
	mutations:{
		
	},
	/* 异步函数 */
	actions:{
	 },
	/*getter选择器：对state的状态变量做筛选和处理 
	  getter选择器的方法必须包含默认参数，state，表示当前状态对象
	  该参数必须放在函数的第一位
	  
	*/
	getters:{
		
	}
})
/* 导出 */
export default store