<template>
  <div class="my-page-indv">
    <b-container fluid align="left">
      <b-row style="padding:10px;">
        <b-col md="12">
          <h2 align="left">채용공고</h2>
        </b-col>
      </b-row>
        <div class="my-page-body">
          <b-row style="padding:10px;">
            <b-col md="2">
              <h5>제목 :</h5>
            </b-col>
            <b-col md="5">
              <b-card no-body class="text-left" style="padding:5px;">
                {{ job.position }}
              </b-card>
            </b-col>
            <b-col md="2">
              <h5>채용형태 :</h5>
            </b-col>
            <b-col md="3">
              <b-card no-body class="text-left" style="padding:5px;">
               {{job.employ_TYPE}}
              </b-card>
            </b-col>
         </b-row> 
         <b-row style="padding:10px;">
          <b-col md="2">
            <h5>자격 요건:</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{job.qualify}}
            </b-card>
          </b-col>
        </b-row>
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>Email:</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{company.co_EMAIL}}
            </b-card>
          </b-col>
        </b-row>
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>마감일:</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{job.regi_DT}}
            </b-card>
          </b-col>
        </b-row>
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>Contact :</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{company.co_NUMBER}} 
            </b-card>
          </b-col>
        </b-row>
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>직무설명 :</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              <p id="name"></p>
            </b-card>
          </b-col>
        </b-row>
      </div>
    </b-container>
    <h6></h6>
        <b-row align-h="center" style="padding:10px;">
            <b-col>
              <div v-show="usercode == userInfo.co_ID">
                <b-button variant="primary" v-on:click="ModifyPage();">수정</b-button>
                <b-button class="button1" > </b-button>
                <b-button class="button2" v-on:click="DeletePost();">삭제</b-button>
              </div> 
          </b-col>
        </b-row>
  </div>
</template>

<script>
import http from "../http-common";
export default { 
  name: "JobDetail",

  data()
  {
    return{      
      isLogin: false,
      loginUser: '',
      userInfo: {},
    job: {
        post_NO: "",  
        company: "",
        position: "",
        qualify: "",
        employ_TYPE: "",
        regi_DT: "",
        job:"",
        co_ID:"",
    },
    usercode:"",
    user_code:"",
    co_check:"",
    checkInfo: false,
    company:{
    },
  };
  },
  methods: {
    check(){
      http
        .post("/checkdetail",
         {
        co_ID:this.co_ID,
        post_NO: this.post_NO,
        company: this.company,
        position: this.position,
        qualify: this.qualify,
        employ_TYPE: this.employ_TYPE,
        regi_DT: this.regi_DT
        })
        .then((response) => {
         if (response.data != -1){ 
         this.checkInfo = true;
         this.callrowdetail();
         }
        else{
          this.checkInfo = false;
          }
        })
        .catch((e) => { 
          console.log(e);
        });
    },
    callrowdetail()
    {  
      http
        .get("/jobdetail",{params: {post_NO: this.post_NO}})
        .then((response) => {  
          if (response.data != -1)
          {
            console.log(response.data);
            this.job = response.data; 
            this.job['job'] = this.job['job'].replace(/\n/gi, '<br>');
            this.job['job'] = this.job['job'].replace(/ /gi, '&nbsp;');
            document.getElementById("name").innerHTML =this.job.job
            //email 가져오기
            http
              .get("/mypage-comp", { params: { userID: this.job.co_ID} })
              .then((response) => {
                this.company = response.data;
                this.usercode=this.company.co_ID 
                console.log(response.data);
                document.getElementById("email").innerHTML =this.company.email;
              })
              .catch((e) => {
                console.log(e);
              });
              //이메일 가져오기
            }
              })
        .catch((e) => 
        {
          console.log(e)
        });
    },
    /*
   checkemail() {
    alert(this.job.co_ID);
      http
        .get("/mypage-comp", { params: { userID: this.job.co_ID} })
        .then((response) => {

          this.company = response.data;
          console.log(response.data);
          document.getElementById("email").innerHTML =this.co_EMAIL
        })
        .catch((e) => {
          console.log(e);
        });
    },*/
    checkUserCode(){
      http
        .post("/check-usercode")
        .then(response=>{
          console.log(response.data);
          if(response.data){
            this.user_code = 'qwe'
          }
          else{
            this.user_code = 'asd';
          }
        })
        .catch(e=>{
          console.log(e);
        })
    },
    ModifyPage()
    {
      this.$router.push({name:"ModifyPost" ,query: {post_NO:this.job.post_NO,co_ID:this.company.co_ID}})
    },
    checkLoginUser() {
      http
        .post("/check-session")
        .then((response) => {
          if (response.data != null && response.data != "") {
            console.log(response.data);
            this.isLogin = true;
            this.loginUser = response.data;
            this.getCompany();            
          } else {
            this.isLogin = false;
          }
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getCompany() {
      http
        .get("/mypage-comp", { params: { userID: this.loginUser } })
        .then((response) => {
          this.userInfo = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    DeletePost()
    {
      var message=confirm("삭제하시겠습니까?")
      if(message){
      http
      .post("/delete",
      {post_NO: this.post_NO}
      )

        .then((response) => {  
          if (response.data != -1)
          {
            console.log(response.data);
            this.$router.push({ name: "JobPosting" });
          }
              })
        .catch((e) => 
        {
          console.log(e)
        });
    }
    else{
      console.log("1");
    }
    }
  },
  mounted()
  {
    this.check();
    this.checkUserCode();
    this.checkLoginUser()
   //this.checkDetailSession();
   this.post_NO=this.$route.query.post_NO;

  },    

};
  

</script>

<style>

.button1 {
  background-color: white;
  border: 1px white;
  width: 1px;
}

.button2 {
  background-color: red;
  color: white;
}




</style>