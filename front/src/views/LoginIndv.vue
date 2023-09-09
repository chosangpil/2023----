<template>
  <div class="login-indv">
    <b-form class="join-form">
      <b-card class="shadow">
        <h2 align="center" style="font-weight: 500; margin-bottom: 20px">User Login</h2>
        <!-- ID -->
        <b-form-group label-cols-lg="3" label="ID" label-for="input-id" style="text-align: center;">
          <b-form-input
            id="input-id"
            type="text"
            v-model="form.id"
            placeholder="Enter ID"
            required
          ></b-form-input>
        </b-form-group>

        <!-- 비밀번호 -->
        <b-form-group label-cols-lg="3" label="Password" label-for="input-pw" style="text-align: center;">
          <b-form-input
            id="input-pw"
            type="password"
            v-model="form.pw"
            placeholder="Enter Password"
            required
            @keyup.enter="loginIndv"
          ></b-form-input>
        </b-form-group>

        <b-button type="button" style="width:100%; margin: 10px 0 7px 0;" variant="primary" @click="loginIndv"> 로그인 </b-button>
      </b-card>
    </b-form>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "LoginIndv",
  data() {
    return {
      form: {
        id: "",
        pw: "",
      },
    };
  },
  methods: {
    loginIndv() {
      http
        .post("/login", {
          id: this.form.id,
          pw: this.form.pw,
          user_code: 0,
        })
        .then((response) => {
          console.log(response);
          if (response.data) {
            console.log(response.data);
            alert("로그인 성공!");
            this.$router.push({name : 'Home'});
            // this.$router.go(0);
          } else {
            console.log(response.data);
            alert("로그인 실패..ID/PW를 다시 확인해주세요.");
            // this.$router.go(0);
          }
        })
        .catch((e) => {
          console.log(e);
          alert("로그인 실패..오류 발생..");
          // this.$router.go(0);
        });
    },
  },
};
</script>

<style>
.login-indv {
  position: absolute;
  top: 380px;
  left: 50%;
  width: 400px;
  margin: -150px 0 0 -200px;
  text-align: left;
}
</style>
