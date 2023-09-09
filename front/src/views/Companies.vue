<template>
  <div class="companies">
    <!-- 기존 게시판 코드 -->
    <div>
       <b-container fluid>
         <!-- 게시판 헤더 -->
         <b-row style="padding:10px;">
           <!-- 게시판 제목 -->
           <b-col md="9">
             <h2 align="left">고객사 목록</h2>
           </b-col>
           <!-- 검색창 -->
           <b-col md="3">
             <b-input-group size="sm">
               <b-form-input
                id="filter-input"
                v-model="filter"
                type="search"
                placeholder="기업명/HR담당자/업종/규모"></b-form-input>
             </b-input-group>
           </b-col>
          </b-row>
         <!-- 고객사 목록 table -->
          <b-row>  
              
           <b-table hover :items="users" :filter="filter" :fields="fields" @row-clicked="CompanyDetail"></b-table>
            <!-- <b-table v-for="list in users" v-bind:key="list.co_NO">
             {{list.co_NO }}
             {{list.company }}
             </b-table>
             -->
              <!-- <b-table-simple>
              <colgroup>
                <col span="1" style="width=5%">
                <col span="1" style="width=45%">
                <col span="1" style="width=15%">
                <col span="1" style="width=15%">
                <col span="1" style="width=15%">
                <col span="1" style="width=25%">
              </colgroup>
              <b-thead>
                <b-th>No.</b-th>
                <b-th>기업명</b-th>
                <b-th>업종</b-th>
                <b-th>규모</b-th>
                <b-th>HR담당자</b-th>
                <b-th>E-mail</b-th>
              </b-thead>
              <b-tbody>
                <b-tr v-for="user in users" :key="user.co_no">
                  <b-td>{{user.co_no}}</b-td>
                  <b-td>{{user.company}}</b-td>
                  <b-td>{{user.categoryID}}</b-td>
                  <b-td>{{user.sizeID}}</b-td>
                  <b-td>{{user.hr}}</b-td>
                  <b-td>{{user.co_EMAIL}}</b-td>
                </b-tr>
              </b-tbody>
            </b-table-simple> -->
          </b-row>
       </b-container>
    </div>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: 'Companies',
  data(){
    return{
      users:[],
      fields:[
        {key:'co_NO', label:'No.'},
        {key:'co_ID', label:'ID'},
        {key:'company', label:'기업명'},
        {key:'category_ID', label:'분야'},
        {key:'size_ID', label:'기업규모'},/* 수정7-22 CO_SIZE -> SIZE_ID */
        {key:'hr', label:'HR담당자'},
        {key:'co_EMAIL', label:'E-mail'}/* 수정7-22 SIZE_ID -> co_EMAIL */
      ],
      filter: ''
    }
  },
  methods:{
    retrieveUsers(){
      http
        .get("/comp-list")
        .then(response=>{
          this.users = response.data;
          console.log(response.data);
          console.log(response.data[2]);
        })
        .catch(e=>{
          console.log(e);
        })
    },
  CompanyDetail(row)
 {
      http
      .post("/checkcompanydetail",
      {
        co_ID: row.co_ID,
        co_PW:row.co_PW,
        company:row.company,
        co_EMAIL:row.co_EMAIL,
        hr:row.hr,
        size_ID:row.size_ID,
        category_ID:row.category_ID,
      
     })
      .then((response) => 
      {
        console.log(response);
        if (response.data)
        {
          console.log(response.data);
          this.$router.push({name: "CompanyDetail",query: {co_ID:row.co_ID}});
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
  }
  ,
  mounted(){
    this.retrieveUsers();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello{
  padding: 30px
}
</style>