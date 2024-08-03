<template>
  <div>
    <el-container>
      <el-aside :width="asideWidth">
        <div style="height: 60px; line-height: 60px; font-size: 20px; display: flex; align-items: center; justify-content: center">
          <img :src="require('@/assets/logo.png')" style="width: 30px;" alt="">
          <span class="logo-title" v-show="!isCollapse">后台系统 管理端</span>
        </div>
        <el-menu router :collapse="isCollapse" :collapse-transition="false" background-color="#001529"
                 active-text-color="#fff" text-color="rgba(255, 255, 255, 0.65)" :default-active="$route.path"
                 style="border: none" :unique-opened="true" @open="handleOpen" >
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-menu"></i><span>用户管理</span></template>
            <el-menu-item index="/front1" @click="two='用户管理'">用户管理</el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i><span>模组管理</span></template>
            <el-menu-item index="/front2" @click="two='模组管理'">模组管理</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
 
      <el-container>
        <el-header style="height: 60px; line-height: 60px; display: flex; align-items: center; box-shadow: 2px 0 6px rgba(0, 21, 41, .35);">
          <i :class="collapseIcon" @click="handleCollapse" style="font-size: 26px"></i>
          <el-breadcrumb separator="/" style="margin-left: 20px">
            <el-breadcrumb-item style="font-weight:700;color:#000;">{{one}}</el-breadcrumb-item>
            <el-breadcrumb-item >{{two}}</el-breadcrumb-item>
          </el-breadcrumb>
 
          <div style="flex: 1; display: flex; justify-content: flex-end; align-items: center">
            <i class="el-icon-quanping" @click="handleFullScreen" style="font-size: 25px"></i>
            <el-dropdown placement="bottom">
              <div style="display: flex; align-items: center; cursor: pointer">
                <img :src="require('@/assets/头像.png')" style="width: 30px;" alt="">
 
                <span>管理员</span>
              </div>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item><div @click="dialogVisible=true">个人信息</div></el-dropdown-item>
                <el-dropdown-item><div @click="dialogVisible1=true">修改密码</div></el-dropdown-item>
                <el-dropdown-item><div @click="logout()">退出登录</div></el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </el-header>
 
        <el-main>
          <div style="box-shadow: 0 0 10px rgba(0,0,0,.1); padding: 10px 20px; border-radius: 5px; margin-bottom: 10px">
            <router-view></router-view>
          </div>
          
        </el-main>
      </el-container>
    </el-container>
    <el-dialog
      title="个人信息修改"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose"
      :append-to-body="true">
      <el-form ref="form" :model="from" label-width="90px">
      <el-form-item label="姓名">
        <el-input placeholder="请输入" v-model="from.name" clearable></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-input placeholder="请输入" v-model="from.sex" clearable></el-input>
      </el-form-item>
      <el-form-item label="出生年月日">
        <el-date-picker type="date" placeholder="请输入" v-model="from.age" format="yyyy 年 MM 月 dd 日"
      value-format="yyyy-MM-dd" style="width: 100%;"></el-date-picker>
      </el-form-item>
      <el-form-item label="联系方式">
        <el-input placeholder="请输入" v-model="from.tel" clearable></el-input>
      </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="sub()">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
      title="密码修改"
      :visible.sync="dialogVisible1"
      width="30%"
      :before-close="handleClose"
      :append-to-body="true">
      <el-form ref="form" :model="from1" label-width="90px">
        <el-form-item label="账号">
        <el-input placeholder="请输入" v-model="from1.username" disabled></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input placeholder="请输入" v-model="from1.password" show-password></el-input>
      </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible1 = false">取 消</el-button>
        <el-button type="primary" @click="sub1()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
 
<script>
import axios from 'axios'
 import router from '@/router/index.js'
export default {
  name: 'HomeView',
  data() {
    return {
      isCollapse: false,
      asideWidth: '200px',
      collapseIcon: 'el-icon-s-fold',
      one:'用户管理',
      two:'用户管理',
      dialogVisible:false,
      dialogVisible1:false,
      id:null,
      from:{
        name:'',
        sex:'',
        age:'',
        tel:''
      },
      from1:{
        username:'',
        password:''
      }
    }
  },
  mounted() {
     axios({
          url: 'http://localhost:8888/userList?username='+window.sessionStorage.getItem('username'),
          method: 'get'
      }).then(res => {
        this.id = res.data[0].id
          this.from = {
            name:res.data[0].name,
            sex:res.data[0].sex,
            age:res.data[0].age,
            tel:res.data[0].tel
          }
          this.from1 = {
            username:res.data[0].username,
            password:res.data[0].password
          }
      })
  },
  methods: {
    handleFullScreen() {
      document.documentElement.requestFullscreen()
    },
    handleCollapse() {
      this.isCollapse = !this.isCollapse
      this.asideWidth = this.isCollapse ? '64px' : '200px'
      this.collapseIcon = this.isCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold'
    },
    handleOpen(key, keyPath) {
      const arr = ['用户管理','模组管理']
       this.one = arr[key-1]
    },
    sub(){
        
          axios({
              url: 'http://localhost:8888/userList/'+this.id,
              method: 'patch',
              data:{
                  name:this.from.name,
                  sex:this.from.sex,
                  age:this.from.age,
                  tel:this.from.tel
              }
          }).then(res => {
              this.dialogVisible = false
              this.$message({
                  showClose: true,
                  message: "修改成功！",
                  type: "success",
              });
          })
            
        
    },
    sub1(){
        if(this.from1.password==''){
            this.$message({
                showClose: true,
                message: "请完整填写！",
                type: "error",
            });
        }else{ 
          axios({
              url: 'http://localhost:8888/userList/'+this.id,
              method: 'patch',
              data:{
                  password:this.from1.password
              }
          }).then(res => {
              this.dialogVisible1 = false
              this.$message({
                  showClose: true,
                  message: "修改成功！",
                  type: "success",
              });
          })
            
        }
    },
    logout(){
      router.push('/')
    }
  }
}
</script>
 
<style>
.el-menu--inline, .el-menu-item {
  background-color: #000c17 !important;
}
 
.el-submenu__title {
  height: 40px !important;
  line-height: 40px !important;
  padding: 0 25px !important;
  transition: color 0s;
}
.el-menu--collapse .el-submenu__title {
  padding: 0 20px !important;
}
.el-submenu__title>i:nth-child(1) {
  margin-top: 2px;
}
.el-submenu__title>i.el-submenu__icon-arrow {
  margin-top: -5px;
}
.el-menu-item {
  min-width: 0 !important;
  width: calc(100% - 10px);
  margin: 5px;
  height: 40px !important;
  line-height: 40px !important;
  border-radius: 5px;
}
.el-menu--inline>.el-menu-item {
  padding-left: 50px !important;
}
.el-menu-item.is-active {
  background-color: dodgerblue !important;
}
 
.el-menu-item:hover {
  color: #fff !important;
}
 
.el-submenu__title:hover *, .el-submenu__title:hover {
  color: #fff !important;
}
 
.el-aside {
  box-shadow: 2px 0 6px rgba(0, 21, 41, .35);
  background-color: #001529;
  color: #fff;
  min-height: 100vh;
  transition: width .3s;
}
.el-menu--collapse .el-tooltip {
  padding: 0 15px !important;
}
.logo-title {
  margin-left: 5px;
  transition: all .3s;
}
.el-menu {
  transition: all .3s;
}
</style>