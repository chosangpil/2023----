<template>
  <div class="my-page-indv">
  <b-form>
    <b-container fluid align="left">
            <!-- 포지션명(공고 제목) -->
      <b-row style="margin-top:40px;margin-left:30px">
        <b-col md="12">
          <h2 align="left">채용공고</h2>
        </b-col>
      </b-row>
        <b-row style="margin-top:40px;margin-left:50px">
         <b-col sm="2">
            <h5>제목 :</h5>
          </b-col> 
          <b-col sm="10" style="width:600px">
            <b-form-input
              id="input-pos"
              type="text"
              v-model="form.posName"
              placeholder="Enter Job Posting Title"
              required
            ></b-form-input>
          </b-col>
        </b-row>
                <!-- 포지션명(공고 제목) -->
        <b-row style="margin-top:10px;margin-left:50px">
          <b-col md="2 ">
            <h5 align="left">채용형태 :</h5>
          </b-col>
          <b-col sm="10" style="width:600px">
            <b-form-select
              id="input-employtype"
              v-model="form.employType"
              :options="employTypeOptions"
              required
            ></b-form-select>
          </b-col>
        </b-row>

        <b-row style="margin-top:10px;margin-left:50px">
          <b-col md="2 ">
            <h5 align="left">자격 요건 :</h5>
          </b-col>
          <b-col sm="10" style="width:600px">
            <b-form-select
              id="input-employtype"
              v-model="form.qualify"
              :options="qualifyOptions"
              required
            ></b-form-select>
          </b-col>
        </b-row>
        
        <b-row style="margin-top:10px;margin-left:50px">
          <b-col md="2">
            <h5 align="left">마감일 :</h5>
          </b-col>
        <b-col sm="10" style="width:300px">
            <b-form-datepicker
              id="datepicker-deadline"
              v-model="form.deadline"
              close-button
              required
            ></b-form-datepicker>
          </b-col>
        </b-row>

  
        <b-row style="margin-top:5px;margin-left:50px">

          <b-col md="2">
            <h5>Contact :</h5>
          </b-col>
          <b-col md="10" style="width:1000px">
            <b-form-textarea
              id="textarea-task"
              v-model="form.taskInfo"
              rows="14"
              max-rows="14"
              required
            ></b-form-textarea>
            </b-col>
        </b-row>

    </b-container>
        <b-row align-h="center" style="padding:20px;">
            <b-col>
              <div v-show="usercode == userInfo.co_ID">
                <b-button variant="primary" type="button" @click="ModifyPost">수정완료</b-button>
              </div> 
          </b-col>
        </b-row>
    </b-form>
  </div>
</template>

<script>
import http from "../http-common";
  var jobob={
        post_NO: "",  
        company: "",
        position: "",
        qualify: "",
        employ_TYPE: "",
        regi_DT: "",
        job:"",
        co_ID:"",
  }
export default { 
  name: "JobDetail",

  data()
  {
    return{      
      isLogin: false,
      loginUser: '',
      userInfo: {},
      form: {
        posName: "",
        qualify: "",
        employType: "",
        deadline: "",
        taskInfo: "",
      },
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
    qualifyOptions: [
        { text: "경력직", value: "경력" },
        { text: "경력 무관", value: "신입" },
      ],
      employTypeOptions: [
        { text: "정규직", value: "정규직" },
        { text: "계약직", value: "계약직" },
      ],
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
         document.getElementById('name').innerHTML=this.job.post_NO;
         console.log(jobob);
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
            this.form.posName=this.job.position;
            this.form.qualify=this.job.qualify;
            this.form.employType=this.job.employ_TYPE;
            this.form.deadline=this.job.regi_DT;
            this.form.taskInfo=this.job.job;

            //email 가져오기
            http
              .get("/mypage-comp", { params: { userID: this.job.co_ID} })
              .then((response) => {

                this.company = response.data;
                this.usercode=this.company.co_ID 
                console.log(response.data);
                document.getElementById("email").innerHTML =this.company.co_EMAIL
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
  ModifyPost()
    {
      var message=confirm("수정을 완료하시겠습니까?");
      if (message)
      {
        http
        .post("/modify-position", {
          position: this.form.posName,
          qualify: this.form.qualify,
          employ_TYPE: this.form.employType,
          regi_DT: this.form.deadline,
          job: this.form.taskInfo,
          post_NO: this.post_NO
        })
        .then((response) => {
          console.log(response.data);
          alert("포지션 DB 수정 완료!");
          this.$router.push({name: "JobDetail",query: {post_NO:this.post_NO}});
        })
        .catch((e) => {
          console.log(e);
          alert("포지션 DB 수정 실패..");
          this.$router.go(0);
        });
      }
      else{
        console.log("1");
      }
  },
    modifyPosition() {
      http
        .post("/modify-position", {
          position: this.form.posName,
          qualify: this.form.qualify,
          employ_TYPE: this.form.employType,
          regi_DT: this.form.deadline,
          job: this.form.taskInfo,
          post_NO: this.post_NO
        })
        .then((response) => {
          console.log(response.data);
          this.$router.push({name: "JobDetail",query: {post_NO:this.post_NO, co_ID:this.company.co_ID}});
        })
        .catch((e) => {
          console.log(e);
          alert("포지션 DB 수정 실패..");
          this.$router.go(0);
        });
    },
  },

  mounted()
  {
    this.check();
    this.checkUserCode();
    this.checkLoginUser()
   //this.checkDetailSession();
   this.post_NO=this.$route.query.post_NO;
   this.co_ID=this.$route.queery.co_ID;
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