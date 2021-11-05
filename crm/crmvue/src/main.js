import {
	createApp
} from 'vue'
import Start from './Start.vue'
/* 1、导入element-plus */
import ElementPlus from 'element-plus'
import 'element-plus/lib/theme-chalk/index.css'
//将日期改成中文
import 'dayjs/locale/zh-cn'
import locale from 'element-plus/lib/locale/lang/zh-cn'

/* 2、导入axios */
import axios from '@/axios/index.js'
import VueAxios from 'vue-axios'
/* 3、导入路由 */
import router from '@/router/index.js'
// 引入vuex的store对象
import store from '@/store/index.js'
//初始化菜单

//富文本编辑器
import { QuillEditor } from '@vueup/vue-quill'
import '@vueup/vue-quill/dist/vue-quill.snow.css';
 
 
 

//路由卫士
router.beforeEach((to, from, next) => {
	
	if(to.name=="Login"){
		next();
		return;
	}
	//检查状态管理器中的对象值
	let user=store.state.users.usersId;
	
	// if(user==undefined){
	// 	next("/login");
	// }
	
})



//修改
axios.defaults.withCredentials = false;

/* 1、创建Vue对象 */
let app = createApp(Start)
/* 2、导入element-plus */
app.use(ElementPlus, {
	locale
})
/* 3、加载axios */
app.use(VueAxios, axios)
/* 4、加载路由 */
app.use(router)
/* 4、加载vuex */
app.use(store)
/* 最后、挂载元素 */
app.mount('#app')
app.component('QuillEditor', QuillEditor)

