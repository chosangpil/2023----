<template>
  <div id="app">
    <!-- navbar(헤더) -->
    <div id="nav">
      <b-navbar toggleable="md" type="dark" variant="primary">
        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
        <b-navbar-brand style="padding-left: 20px;" href="/#/">Matching Monster</b-navbar-brand>
        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="/#/companies">Companies</b-nav-item>
            <b-nav-item href="/#/job-posting">JopPosting</b-nav-item>
            <div v-if="this.isLogin">
              <b-nav-item-dropdown right>
                <template #button-content>
                  ID : {{loginUser}}
                </template>
                <b-dropdown-item @click="goMyPage()">My Page</b-dropdown-item>
                <b-dropdown-item @click="logout()">Log Out</b-dropdown-item>
              </b-nav-item-dropdown>
            </div>
            <div v-else>
              <b-nav-item href="/#/login" style="float: left;">Login</b-nav-item>
              <b-nav-item href="/#/join" style="float: right;">Join</b-nav-item>
            </div>
            <div v-show="user_code == 'zxc'">
              <b-nav-item href="/#/Manager-Progress" style="float: right;">진행상황</b-nav-item>
            </div>
        
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <div>
      <router-view/><!--nav 바 밑에 router view 부분이 바뀜 -->
    </div>
  </div>

</template>

<script>
import http from "./http-common";

export default{
  name: "App",
  data(){
    return{
      isLogin: false,
      loginUser:'',
      user_code:'asd'
    }
  },
  
  methods:{
    checkSession(){
      http
        .post("/check-session")
        .then(response=>{
          if(response.data != null && response.data != ''){
            console.log(response.data);
            this.isLogin = true;
            this.loginUser = response.data;
          }
          else{
            this.isLogin = false;
          }
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
          if(response.data==2){
            this.user_code = 'zxc';
          }
          else if (response.data==1){
            this.user_code = 'asd';
          }
          else if (response.data==0){
            this.user_code = 'qwe';
          }
        })
        .catch(e=>{
          console.log(e);
        })
    },
    goMyPage(){
      http
        .post("/check-usercode")
        .then(response=>{
          console.log(response.data);
          if(response.data){
            this.$router.push({ name: "MyPageComp" });
          }
          else{
            this.$router.push({ name: "MyPageIndv" });
          }
        })
        .catch(e=>{
          console.log(e);
        })
    },
    logout(){
      http
        .post("/logout")
        .then(response=>{
          alert("로그아웃 되었습니다.");
          console.log(response.data);
          this.$router.push({ name: "Home" });
          this.$router.go(0);
        })
        .catch(e=>{
          console.log(e);
          alert("로그아웃 실패..");
          this.$router.go(0);
        })
    }
  },
  mounted(){
    this.checkSession();
  },
  updated(){
    this.checkSession();
    this.checkUserCode();
  }
}
</script>


<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

h2 {
  font-weight: 500 !important;
  margin-bottom: 20px !important;
  color: #0e73c3;
}
/*
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
<b-nav-item-dropdown right>
                <template #button-content>
                  진행상황
                </template>
              </b-nav-item-dropdown>
*/
</style>
