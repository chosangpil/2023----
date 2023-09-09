<template>
  <div class="login">
    <b-card class="shadow">
      <h2>Login</h2>     
      <b-row align-h="center" style="padding:10px;">
        <b-button class="button" size="lg" href="/#/login-indv">일반회원 로그인</b-button>
          <!-- <b-col>
              <b-button class="button" size="lg" href="/#/login-indv">일반회원 로그인</b-button>
          </b-col> -->
      </b-row>
        
      <b-row align-h="center" style="padding:10px;">
        <b-button class="button" size="lg" variant="primary" href="/#/login-comp">기업회원 로그인</b-button>  
          <!-- <b-col>
              <b-button class="button" size="lg" variant="primary" href="/#/login-comp">기업회원 로그인</b-button>  
          </b-col> -->
      </b-row>

      <b-row align-h="center" style="padding:10px;">
        <b-button class="button" size="lg" variant="primary" href="/#/Manager-log">관리자 로그인</b-button>
          <!-- <b-col>
              <b-button class="button" size="lg" variant="primary" href="/#/Manager-log">관리자 로그인</b-button>  
          </b-col> -->
      </b-row>
      
      <div class="joinBox">
        <div style="padding-left: 15px;">not a member?</div>
        <b-button class="joinLinkButton" variant="link" href="/#/join">Create Account!</b-button>
      </div>
    </b-card>


  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        id: "",
        pw: "",
      },
    };
  },
};
</script>

<style>
@import "../assets/CSS/login.css";

.login {
  position: absolute;
  top: 380px;
  left: 50%;
  width: 400px;
  margin: -150px 0 0 -200px;
}
</style>
