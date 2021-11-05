import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

import {resolve} from 'path'

/* vite工程的启动文件 */
export default defineConfig({
  plugins: [vue()],
  resolve:{
	  alias:{
		  '@':resolve(__dirname,'src')
	  }
  },
  server:{
	  port:4000,
	  open:true
  }
})
