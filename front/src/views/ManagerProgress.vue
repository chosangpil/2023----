<template>
  <div class="ManagerPrograss">
    <!-- 기존 게시판 코드 -->
    <div>
       <b-container fluid>
         <!-- 게시판 헤더 -->
         <b-row style="padding:10px;">
           <!-- 게시판 제목 -->
           <b-col md="6">
             <h2 align="left">진행 상황</h2>
           </b-col>
          </b-row>
         <!-- 고객사 목록 table -->
          <b-row>
             <b-table hover :items="contents" :filter="filter" :fields="fields" @row-clicked="JobDetail"></b-table>
          </b-row>
       </b-container>
    </div>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: 'ManagerProgress',
  data(){
    return{
      contents:[],
      fields:[
        {key:'MANAGER', label:'No.'},
        {key:'M_EMAIL', label:'관리자 이메일'},
        {key:'M_NUMBER', label:'전화번호'},
        {key:'M_ID', label:'관리자 아이디'},
      ],
      filter: '',
      user_code:'zxc'
    }
  },
  methods:{
    retrieveContents(){
      http
        .get("/Manager-Progress")
        .then(response=>{
          this.contents = response.data;
          console.log(response.data);
        })
        .catch(e=>{
          console.log(e);
        })
    },
    checkUserCode(){
      http
        .post("/check-usercode")
        .then(response=>{
          console.log(response.data);
          if(response.data){
            this.user_code = 'zxc'
          }
          else{
            this.user_code = 'asd';
          }
        })
        .catch(e=>{
          console.log(e);
        })
    },
    JobDetail(row)
    {
    
      http
      .post("/checkdetail",
      {
        post_NO: row.post_NO,
        company: row.company,
        position: row.position,
        qualify: row.qualify,
        employ_TYPE: row.employ_TYPE,
        regi_DT:row.regi_DT
      })
      .then((response) => 
      {
        console.log(response);
        if (response.data)
        {
          console.log(response.data);
          alert("페이지 이동");
          console.log(row.post_NO);
          console.log("구분용");
          this.$router.push({name: "JobDetail",params: {post_NO:row.post_NO}});
        } else{
          console.log(response.data);
          alert("페이지 이동 실패");
        }
      })
      .catch((e) => {
        console.log(e);
        alert("페이지 이동x");
      })
    alert(row.position)
    }
  }
  
  ,
  mounted(){
    this.retrieveContents();
    this.checkUserCode();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello{
  padding: 30px
}
</style>9