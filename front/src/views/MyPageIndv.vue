<template>
  <div class="my-page-indv">
    <b-container fluid align="left">
      <!-- 마이페이지 헤더 -->
      <b-row style="padding:10px;">
        <b-col md="12">
          <h2 align="left">My Page</h2>
        </b-col>
      </b-row>
      <div class="my-page-body">
        <!-- 이름 및 성별 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>Name :</h5>
          </b-col>
          <b-col md="5">
            <b-card no-body class="text-left" style="padding:5px;">
              {{ userInfo.name }}
            </b-card>
          </b-col>
          <b-col md="2">
            <h5>Gender :</h5>
          </b-col>
          <b-col md="3">
            <b-card no-body class="text-left" style="padding:5px;">
              {{userInfo.gender}}
            </b-card>
          </b-col>
        </b-row>
        <!-- 출생년도 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>Y.O.B :</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{userInfo.birth_DATE}}
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
              {{userInfo.p_EMAIL}}
            </b-card>
          </b-col>
        </b-row>
        <!-- 번호 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>Contact :</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{userInfo.phone}}
            </b-card>
          </b-col>
        </b-row>
        <!-- 학력 -->
        <b-row style="padding:10px;">
          <h5>Academic Career</h5>
        </b-row>
        <div v-for="acirow in userACIList" :key="acirow">
          <b-row style="padding:5px;">
            <b-col md="2">
              <b-card no-body class="text-left" style="padding:5px;">
                {{acirow.degree}}
              </b-card>
            </b-col>
            <b-col md="3">
              <b-card no-body class="text-left" style="padding:5px;">
                {{acirow.school_NAME}}
              </b-card>
            </b-col>
            <b-col md="2">
              <b-card no-body class="text-left" style="padding:5px;">
                {{acirow.major}}
              </b-card>
            </b-col>
            <b-col md="2">
              <b-card no-body class="text-left" style="padding:5px;">
                {{acirow.admission_DATE}}
              </b-card>
            </b-col>
            <b-col md="1" align="center">
              <h5>~</h5>
            </b-col>
            <b-col md="2">
              <b-card no-body class="text-left" style="padding:5px;">
                {{acirow.graduation_DATE}}
              </b-card>
            </b-col>
          </b-row>
        </div>
        <!-- 경력 -->
        <b-row style="padding:10px;">
          <h5>Career</h5>
        </b-row>
        <div v-for="cirow in userCIList" :key="cirow">
          <b-row style="padding:5px;">
            <b-col md="4">
              <b-card no-body class="text-left" style="padding:5px;">
                {{cirow.p_COMPANY}}
              </b-card>
            </b-col>
            <b-col md="4">
              <b-card no-body class="text-left" style="padding:5px;">
                {{cirow.p_DEPARTMENT}}
              </b-card>
            </b-col>
            <b-col md="4">
              <b-card no-body class="text-left" style="padding:5px;">
                {{cirow.p_DUTY}}
              </b-card>
            </b-col>
          </b-row>
        </div>
      </div>
    </b-container>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "MyPageIndv",
  data() {
    return {
      userInfo: {},
      userCIList:[],
      userACIList:[],
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
            this.getPersonal();
            this.getCareer();
            this.getHaksa();
          } else {
            this.isLogin = false;
          }
        })
        .catch((e) => {
          console.log(e);
        });
    },
    // id로 개인회원의 정보 조회
    getPersonal() {
      http
        .get("/mypage-indv", { params: { userID: this.loginUser } })
        .then((response) => {
          this.userInfo = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    // id로 개인회원의 학력 조회
    getHaksa() {
      http
        .get("/mypage-indv-aci", { params: { userID: this.loginUser } })
        .then((response) => {
          this.userACIList = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    // id로 개인회원의 경력 조회
    getCareer() {
      http
        .get("/mypage-indv-ci", { params: { userID: this.loginUser } })
        .then((response) => {
          this.userCIList = response.data;
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
  width: 900px;
  padding: 20px;
  margin: 0 20px;
}
</style>
