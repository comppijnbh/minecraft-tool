<template>
    <div class="one">
        <el-input placeholder="请输入内容" v-model="search" clearable prefix-icon="el-icon-search"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="query(search)">查询</el-button>
        <el-button type="primary" icon="el-icon-plus" @click="add()">新增</el-button>
        <el-table
            :data="tableData"
            border
            style="width: 100%"
            :header-cell-style="{background:'#eef1f6',color:'#606266'}">
            <el-table-column
            prop="img"
            label="图片"
            width="150">
            <template slot-scope="scope">
                <img :src="scope.row.img" alt="" style="width:100px;height:80px;">
            </template>
            </el-table-column>
            <el-table-column
            prop="name"
            label="名称"
            width="200">
            </el-table-column>
            <el-table-column
            prop="text"
            label="描述"
            width="400">
            </el-table-column>
            <el-table-column
            prop="time"
            label="上传时间"
            width="150">
            </el-table-column>
            <el-table-column
            fixed="right"
            label="操作"
            width="150">
            <template slot-scope="scope">
                <el-button @click="handleSee(scope.row)" type="text" size="small">查看</el-button>
                <el-button @click="handleDel(scope.row)" type="text" size="small">删除</el-button>
            </template>
            </el-table-column>
        </el-table>
        <el-dialog
      title="新增模组信息"
      :visible.sync="dialogVisible"
      width="40%"
      :before-close="handleClose"
      :append-to-body="true"
    >
      <el-form ref="form" :model="from" label-width="90px">
        <el-form-item label="图片">
          <el-input
            placeholder="请输入"
            v-model="from.img"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="名称">
          <el-input
            placeholder="请输入"
            v-model="from.name"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入"
            v-model="from.text"
            clearable
          ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="sub()">确 定</el-button>
      </span>
    </el-dialog>
        <el-dialog title="评论" :visible.sync="dialogTableVisible">
            <el-table :data="gridData">
                <el-table-column property="username" label="评论人" width="150"></el-table-column>
                <el-table-column property="text" label="评论内容" width="300"></el-table-column>
                <el-table-column
                fixed="right"
                label="操作"
                width="150">
                <template slot-scope="scope">
                    <el-button @click="handleShan(scope.row)" type="text" size="small">删除</el-button>
                </template>
                </el-table-column>
            </el-table>
        </el-dialog>
    </div>
</template>

<script>
 import axios from 'axios'
export default {
  data() {
    return {
    tableData:[],
    gridData:[],
    search:'',
    dialogTableVisible: false,
    dialogVisible:false,
    id:null,
    from:{
        img:'',
        name:'',
        text:'',
        time:''
    }
    }
  },
  mounted() {
    this.data()
  },
  methods: {
    data(){
        axios({
            url: 'http://localhost:8888/list',
            method: 'get'
        }).then(res => {
            this.tableData = res.data
        })
    },
    query(search){
        axios({
            url: 'http://localhost:8888/list',
            method: 'get'
        }).then(res => {
            const filteredArr = res.data.filter((item) => {
                return item.name.indexOf(search) >-1
            })
            this.tableData = filteredArr
        })
    },
    add(){
        this.dialogVisible = true
        this.from = {
            img:'',
            name:'',
            text:'',
            time:''
        }
    },
    sub(){
        if(this.from.name=='' || this.from.text==''){
            this.$message({
                showClose: true,
                message: "请完整填写！",
                type: "error",
            });
        }else{
            const date = new Date()
            axios({
                url: 'http://localhost:8888/list',
                method: 'post',
                data:{
                    img:this.from.img,
                    name:this.from.name,
                    text:this.from.text,
                    time:date.toLocaleString()
                }
            }).then(res => {
                this.dialogVisible = false
                this.data()
                this.$message({
                    showClose: true,
                    message: "新增成功！",
                    type: "success",
                });
            })
        }
    },
    handleSee(row){
        this.id = row.id
        axios({
            url: 'http://localhost:8888/comment?listId='+row.id,
            method: 'get'
        }).then(res => {
            this.gridData = res.data
            this.dialogTableVisible = true
            this.$message({
                showClose: true,
                message: "查询成功！",
                type: "success",
            });
        })
    },
    handleDel(row){
        axios({
            url: 'http://localhost:8888/list/'+row.id,
            method: 'delete'
        }).then(res => {
            this.data()
            this.$message({
                showClose: true,
                message: "删除成功！",
                type: "success",
            });
        })
    },
    handleShan(row){
        axios({
            url: 'http://localhost:8888/comment/'+row.id,
            method: 'delete'
        }).then(res => {
            this.handleSee({id:this.id})
            this.$message({
                showClose: true,
                message: "删除成功！",
                type: "success",
            });
        })
    }
  }
}
</script>

<style scoped>
.one > .el-input{
    width: 250px;
    margin: 3px 5px 6px 0;
}
</style>