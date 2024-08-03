<template>
    <div class="a">
        <el-carousel :interval="4000" type="card" height="300px">
            <el-carousel-item v-for="item in banner" :key="item">
            <img :src="item" alt="" style="height:100%;width:100%">
            </el-carousel-item>
        </el-carousel>
        <p>模组论坛  <el-input
            placeholder="请输入"
            v-model="search"
            clearable
            style="width:300px;margin-right:10px;"
          ></el-input></p>
        <div class="no">
            <div class="no1" v-for="(item,index) in noList" :key="index" v-show="item.name?.indexOf(search)>-1">
                <p @click="open(item.text,item.img,item.id)"><span>{{index+1}}. {{item.name}}</span><span>{{item.time}}</span></p>
                <el-divider></el-divider>
            </div>
        </div>
        <div class="footer">模组信息论坛</div>
        <el-dialog
        title="评论"
        :visible.sync="dialogVisible"
        width="55%"
        :before-close="handleClose"
        :append-to-body="true">
        <div>
            <p class="pp">{{text}}</p>
            <img :src="img" alt="" class="iimg">
            <div class="comments">
                <div class="comment" v-for="(itme,index) in spList" :key="index">
                    <div class="avatar">
                        <img src="../assets/头像.png" alt="Avatar">
                    </div>
                    <div class="comment-content">
                        <h3>{{itme.username}}</h3>
                        <p>{{itme.text}}</p>
                    </div>
                </div>
            </div>
            <el-input
                @keyup.native.enter="handleEnter()"
                type="textarea"
                placeholder="请输入"
                v-model="textarea"
                clearable
            ></el-input>
        </div>
    </el-dialog>
    </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      banner: [
        "https://h5.cyol.com/f/new/carousel/20230825/64e80f823cf37.jpg",
        "https://h5.cyol.com/f/new/carousel/20230830/64eea39620bae.jpg",
        "https://h5.cyol.com/f/new/carousel/20240108/659b92296b866.jpg",
        "https://h5.cyol.com/f/new/carousel/20230830/64eea4218d7b9.jpg",
      ],
      search:'',
      noList: null,
      spList: null,
      dialogVisible: false,
      id: null,
      text: "",
      img: "",
      textarea: "",
    };
  },
  mounted() {
    axios({
      url: "http://localhost:8888/list",
      method: "get",
    }).then((res) => {
      this.noList = res.data;
    });
  },
  methods: {
    open(text, img, id) {
      this.dialogVisible = true;
      this.id = id;
      this.text = text;
      this.img = img;
      axios({
        url: "http://localhost:8888/comment?listId=" + id,
        method: "get",
      }).then((res) => {
        this.spList = res.data.reverse();
      });
    },
    handleEnter() {
      if (this.textarea != "") {
        axios({
          url: "http://localhost:8888/comment",
          method: "post",
          data: {
            listId: this.id,
            username: window.sessionStorage.getItem("username"),
            text: this.textarea,
          },
        }).then((res) => {
          this.textarea = "";
          this.open(this.text, this.img, this.id);
        });
      }
    }
  },
};
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.a {
  padding-top: 40px;
}
.no {
  width: 60%;
  height: 250px;
  overflow: auto;
  margin: 30px auto;
}
.a > p {
  width: 60%;
  margin: 30px auto;
  font-size: 22px;
  font-weight: bold;
  color: #db261f;
  margin-bottom: 20px;
}
.no1 p span:first-child {
  width: 82%;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
  vertical-align: middle;
  white-space: nowrap;
}
.no1 p span:first-child:hover {
  font-weight: 700;
  cursor: pointer;
}
.no1 p span:last-child {
  width: 18%;
  vertical-align: middle;
  display: inline-block;
  color: #999;
  font-size: 13px;
}

.sp {
  width: 60%;
  margin: 30px auto;
}
.sp > p {
  font-size: 22px;
  font-weight: bold;
  color: #db261f;
  margin-bottom: 20px;
}
.sp div {
  width: 30%;
  height: 260px;
  margin: 10px 1.5%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  position: relative;
  display: inline-block;
  vertical-align: top;
}
.sp div img {
  width: 100%;
  height: 80%;
}
.sp div p {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-size: 14px;
}
.sp div span {
  color: #999;
  font-size: 12px;
  margin-top: 10px;
}
.sp div .el-button {
  position: absolute;
  bottom: 2px;
  right: 2px;
}
.footer {
  width: 100%;
  background-color: #333;
  letter-spacing: 3px;
  height: 80px;
  text-align: center;
  line-height: 80px;
  color: #eee;
}

.comments {
  max-width: 600px;
  height: 250px;
  overflow: auto;
  margin: 0 auto;
}

.comment {
  display: flex;
  margin-bottom: 20px;
  background-color: #fff;
  padding: 10px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
.pp {
  line-height: 22px;
  text-indent: 2em;
}
.iimg {
  width: 240px;
  height: 150px;
}
.avatar {
    display: block;
  flex: 0 0 auto;
  margin-right: 10px;
}

.avatar img {
  width: 50px;
  height: 50px;
  border-radius: 50%;
}

.comment-content {
  flex: 1 1 auto;
}

.comment-content h3 {
  margin-bottom: 5px;
}

.comment-content p {
  color: #555;
}
</style>