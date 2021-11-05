<template>
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="ht-not-found not-found-default">
          <div class="content">
        
            <center><h2>噢！找不到页面。</h2></center>
			<center><h2><router-link style="text-decoration:none" to="/404" @click="$router.go(-1)"> 返回</router-link></h2></center>
          </div>
          <div id="clouds">
            <div class="cloud cloud-1"></div>
            <div class="cloud cloud-2"></div>
            <div class="cloud cloud-3"></div>
            <div class="cloud cloud-4"></div>
            <div class="cloud cloud-5"></div>
            <div class="cloud cloud-6"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
	import qs from 'qs'
	import {ElMessage} from 'element-plus'
export default {
  data(){
    return{}
	
  },methods:{
	  
	  	
	  
  },created(){
	
		
	}
}
</script>