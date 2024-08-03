<template>
  <div class="patient">
    <div class="header">
      <div class="logo"><span>mo</span><span>dule</span></div>
      <ul>
        <router-link to="/u1"><li :class="isli==1?'li_active':''" @click="isli=1">首页</li></router-link>
        <li @click="logout()">退出登录</li>
      </ul>
    </div>
    <div class="center">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import router from '@/router/index.js'

export default {
  data(){
    return {
      isli:1
    }
  },
  methods:{
    logout(){
      router.push('/')
    }
  }
}
</script>

<style scoped>
.header{
  position: relative;
  width: 100%;
  height: 100px;
}
.logo{
  position: absolute;
  top: 50%;
  left: 6%;
  transform: translateY(-50%);
  font-size: 35px;
  font-weight: 700;
}
.logo span:first-child{
  color: #606eff;
}
.logo span:last-child{
color: #fb7370;
}
.header ul{
  width: 18%;
  height: 40px;
  position: absolute;
  top: 50%;
  right: 3%;
  transform: translateY(-50%);
}
.header ul li{
  display: inline-block;
  width: 49%;
  height: 100%;
  text-align: center;
  line-height: 40px;
}
.header ul li:nth-child(2){
  color: #fff;
  background-color: #fb7370;
  border-radius: 20px;
  font-weight: 700;
}
.header ul li:last-child:hover{
  cursor: pointer;
}


  .li_active{
    color: #606eff;
  }
</style>