<template>
  <div class="one">
    <el-input
      placeholder="请输入内容"
      v-model="search"
      clearable
      prefix-icon="el-icon-search"
    ></el-input>
    <el-button type="primary" icon="el-icon-search" @click="query(search)"
      >查询</el-button
    >
    <!-- <el-upload
      accept=".xls,.xlsx"
      style="display: inline-block; margin-left: 10px"
      class="upload-demo"
      :show-file-list="false"
      action="http://localhost:8888/users/importData"
      :on-success="handleSuccess"
    >
      <el-button type="primary" icon="el-icon-share">导入</el-button>
    </el-upload> -->
    <el-table
      :data="tableData"
      border
      style="width: 100%"
      :header-cell-style="{ background: '#eef1f6', color: '#606266' }"
    >
      <el-table-column prop="username" label="账号" width="150">
      </el-table-column>
      <el-table-column prop="password" label="密码" width="150">
      </el-table-column>
      <el-table-column prop="name" label="姓名" width="150"> </el-table-column>
      <el-table-column prop="sex" label="性别" width="150"> </el-table-column>
      <el-table-column prop="age" label="出生年月日" width="150">
      </el-table-column>
      <el-table-column prop="tel" label="电话" width="150"> </el-table-column>
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.row)" type="text" size="small"
            >编辑</el-button
          >
          <el-button @click="handleDel(scope.row)" type="text" size="small"
            >注销</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      title="用户信息管理"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose"
      :append-to-body="true"
    >
      <el-form ref="form" :model="from" label-width="90px">
        <el-form-item label="账号">
          <el-input
            placeholder="请输入"
            v-model="from.username"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input
            placeholder="请输入"
            v-model="from.password"
            show-password
          ></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input
            placeholder="请输入"
            v-model="from.name"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-input
            placeholder="请输入"
            v-model="from.sex"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="出生年月日">
          <el-date-picker
            type="date"
            placeholder="请输入"
            v-model="from.age"
            format="yyyy 年 MM 月 dd 日"
            value-format="yyyy-MM-dd"
            style="width: 100%"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="联系方式">
          <el-input
            placeholder="请输入"
            v-model="from.tel"
            clearable
          ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="sub()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      tableData: [],
      search: '',
      dialogVisible: false,
      from: {
        username: '',
        password: '',
        name: '',
        sex: '',
        age: '',
        tel: ''
      }
    }
  },
  mounted() {
    this.data()
  },
  methods: {
    data() {
      axios({
        url: 'http://localhost:8888/userList?state=用户',
        method: 'get'
      }).then(res => {
        this.tableData = res.data
      })
    },
    query(search) {
      axios({
        url: 'http://localhost:8888/userList?state=用户',
        method: 'get'
      }).then(res => {
        const filteredArr = res.data.filter((item) => {
          return item.username.indexOf(search) > -1 ||
            item.name.indexOf(search) > -1
        })
        this.tableData = filteredArr
      })
    },
    handleEdit(row) {
      this.id = row.id
      this.dialogVisible = true
      this.from = {
        username: row.username,
        password: row.password,
        name: row.name,
        sex: row.sex,
        age: row.age,
        tel: row.tel
      }
    },
    sub() {
      if (this.from.username == '' || this.from.password == '') {
        this.$message({
          showClose: true,
          message: "请完整填写！",
          type: "error",
        });
      } else {
        axios({
          url: 'http://localhost:8888/userList/' + this.id,
          method: 'patch',
          data: {
            username: this.from.username,
            password: this.from.password,
            name: this.from.name,
            sex: this.from.sex,
            age: this.from.age,
            tel: this.from.tel
          }
        }).then(res => {
          this.dialogVisible = false
          this.data()
          this.$message({
            showClose: true,
            message: "修改成功！",
            type: "success",
          });
        })
      }
    },
    handleDel(row) {
      axios({
        url: 'http://localhost:8888/userList/' + row.id,
        method: 'delete'
      }).then(res => {
        this.data()
        this.$message({
          showClose: true,
          message: "注销成功！",
          type: "success",
        });
      })
    }
  }
}
</script>

<style scoped>
.one > .el-input {
  width: 250px;
  margin: 3px 5px 6px 0;
}
</style>