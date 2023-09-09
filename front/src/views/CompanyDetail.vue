<template>
  <div class="my-page-body">
    <b-container fluid align="left">
      <!-- 마이페이지 헤더 -->
      <b-row style="padding:10px;">
        <b-col md="12">
          <h2 align="left">My Page</h2>
        </b-col>
      </b-row>
      <div class="my-page-body">
        <!-- 기업명 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>Name :</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
               {{aboutcompany.company}}     
            </b-card>
          </b-col>
        </b-row>
        <!-- HR담당자명 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>HR :</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{aboutcompany.hr}}
            </b-card>
          </b-col>
        </b-row>
        <!-- 이메일 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>E-mail :</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{aboutcompany.co_EMAIL}}
            </b-card>
          </b-col>
        </b-row>
        <!-- 연락처 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>Contact :</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{aboutcompany.co_NUMBER}}
            </b-card>
          </b-col>
        </b-row>
        <!-- 기업 분야 및 규모 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>Category :</h5>
          </b-col>
          <b-col md="4">
            <b-card no-body class="text-left" style="padding:5px;">
              {{aboutcompany.category_ID}}
            </b-card>
          </b-col>
          <b-col md="2">
            <h5>Company Size :</h5>
          </b-col>
          <b-col md="4">
            <b-card no-body class="text-left" style="padding:5px;">
               {{aboutcompany.size_ID}}           
            </b-card>
          </b-col>
          </b-row>      
           <!-- 고객사 목록 table -->
          <b-col md="2">
          <br>
            <h5>  채용 정보 </h5>
          </b-col>           
          <b-row>  
             <b-table hover :items="contents" :filter="filter" :fields="fields" @row-clicked="JobDetail"></b-table>
          </b-row>  
      </div>
    </b-container>
  </div>
</template>

<script>
 
import http from "../http-common";

export default {
  name: "CompanyDetail",
  data() {
    return {
      contents:[],
      aboutcompany:{},
      company:{
        co_ID: "",
        co_PW:"",
        company:"",
        co_EMAIL:"",
        hr:"",
        about:"",
        size_ID:"",
        category_ID:"",
      }, 
      fields:[
        {key:'post_NO', label:'No.'},
        {key:'company', label:'기업명'},
        {key:'position', label:'공고 제목'},
        {key:'qualify', label:'경력조건'},
        {key:'employ_TYPE', label:'채용형태'},
        {key:'regi_DT', label:'채용마감'}
      ],
      chekcInfo:false,
    };
  },
  methods: {
    check2(){
      http
        .post("/checkcompanydetail",
         {
        co:  {co_ID: this.co_ID,
        co_PW:this.co_PW,
        company:this.company,
        co_EMAIL:this.co_EMAIL,
        co_NUMBER:this.co_NUMBER,
        hr:this.hr,
        about:this.about,
        size_ID:this.size_ID,
        category_ID:this.category_ID,
      }})
        .then((response) => {
         if (response.data != -1){ 
         this.checkInfo = true;
         //call about company 
        http
        .get("aboutcomp", { params: { co_ID: this.co_ID} })
        .then((response) => {
        this.aboutcompany = response.data;
        })
        .catch((e) => {
        console.log(e);
        });
          //
         //document.getElementById('name').innerHTML=this.job.post_NO;
         }
        else{
          this.checkInfo = false; 
          }
        })
        .catch((e) => {
          console.log(e);
        });
    },
    retrieveContents(){
      http
        .get("/job-com-posting",{ params: { co_ID: this.co_ID} })
        .then(response=>{
          this.contents = response.data; 
          console.log(response.data);
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
          this.$router.push({name: "JobDetail",query: {post_NO:row.post_NO}});
        } else{
          console.log(response.data);
          alert("페이지 이동 실패");
        }
      })
      .catch((e) => {
        console.log(e);
        alert("페이지 이동x");
      })
    }
    //회사의 정보를 가져옴
    /*CallAboutCompany() {
      http
        .get("aboutcomp", { params: { co_ID: this.co_ID} })
        .then((response) => {
        this.aboutcompany = response.data;
        alert("??");
        })
        .catch((e) => {
        alert(this.company.co_ID);
        alert(2); 
        console.log(e);
        });
    },*/
  },
  mounted() {
   this.check2();
   this.co_ID=this.$route.query.co_ID;
  
   this.retrieveContents();
  },
   
};

</script>

<style scoped>
.my-page-body {
  padding: 20px;
  margin: 0 20px;
}
</style>






