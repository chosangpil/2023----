<template>
  <div class="my-page-comp">
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
              {{ userInfo.company }}
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
              {{userInfo.hr}}
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
              {{userInfo.co_EMAIL}}
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
              {{userInfo.co_NUMBER}}
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
              {{ userInfo.category_ID }}
            </b-card>
          </b-col>
          <b-col md="2">
            <h5>Company Size :</h5>
          </b-col>
          <b-col md="4">
            <b-card no-body class="text-left" style="padding:5px;">
              {{userInfo.size_ID}}
            </b-card>
          </b-col>
          </b-row>        
      </div>
    </b-container>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "MyPageComp",
  data() {
    return {
      userInfo: {},
      isLogin: false,
      loginUser: '',
    };
  },
  methods: {
    // 로그인한 개인회원의 id를 가져옴
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
    // id로 개인회원의 정보 조회
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
  },
  mounted() {
    this.checkLoginUser();
  },
};
</script>

<style scoped>
.my-page-body {
  width: 700px;
  padding: 20px;
  margin: 0 20px;
}
</style>
