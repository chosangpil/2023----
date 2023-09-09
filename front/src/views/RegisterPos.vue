<template>
  <div class="register-pos">
    <b-form>
      <b-container fluid>
        <!-- 포지션 DB 등록 헤더 -->
        <b-row style="padding:30px;">
          <b-col md="12">
            <h2 align="left">포지션 DB 등록</h2>
          </b-col>
        </b-row>

        <!-- 포지션 DB 입력폼 -->
        <!-- 포지션명(공고 제목) -->
        <b-row style="padding:10px;">
          <b-col sm="2">
            <label for="input-pos">공고 제목</label>
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
        <!-- 자격 요건 -->
        <b-row style="padding:10px;">
          <b-col sm="2">
            <label for="input-qualify">자격 요건</label>
          </b-col>
          <b-col sm="10" style="width:300px">
            <b-form-select
              id="input-qualify"
              v-model="form.qualify"
              :options="qualifyOptions"
              required
            ></b-form-select>
          </b-col>
        </b-row>
        <!-- 고용 형태 -->
        <b-row style="padding:10px;">
          <b-col sm="2">
            <label for="input-employtype">고용 형태</label>
          </b-col>
          <b-col sm="10" style="width:300px">
            <b-form-select
              id="input-employtype"
              v-model="form.employType"
              :options="employTypeOptions"
              required
            ></b-form-select>
          </b-col>
        </b-row>
        <!-- 모집 기간(모집 마감날짜) -->
        <b-row style="padding:10px;">
          <b-col sm="2">
            <label for="datepicker-deadline">모집 마감</label>
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
        <!-- 직무 설명 -->
        <b-row style="padding:10px;">
          <b-col sm="2">
            <label for="textarea-task">직무 설명</label>
          </b-col>
          <b-col sm="10" style="width:1000px">
            <b-form-textarea
              id="textarea-task"
              v-model="form.taskInfo"
              rows="8"
              max-rows="8"
              required
            ></b-form-textarea>
          </b-col>
        </b-row>
      </b-container>
      <!-- 입력 완료(등록) 버튼 -->
      <b-button type="button" variant="primary" @click="register"> 완료 </b-button>
    </b-form>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "RegisterPos",
  data() {
    return {
      form: {
        posName: "",
        qualify: "",
        employType: "",
        deadline: "",
        taskInfo: "",
      },
      qualifyOptions: [
        { text: "경력직", value: "경력" },
        { text: "경력 무관", value: "신입" },
      ],
      employTypeOptions: [
        { text: "정규직", value: "정규직" },
        { text: "계약직", value: "계약직" },
      ],
      co_no: -1,
      co_id: null,
    };
  },
  methods: {
    register() {
      this.getCO_ID();
    },
    getCO_NO() {
      // 가져온 기업 id로 co_no 얻기
      http
        .get("/comp-number", { params: { co_id: this.co_id } })
        .then((response) => {
          console.log(response.data);
          this.co_email = response.data;
          if (this.co_email != null){/*8-03 임시수정*/
            this.registerPosition();
          } 
          else {
            alert("포지션 DB 등록 실패..");
            this.$router.go(0);
          }
        })
        .catch((e) => {
          console.log(e);
          this.co_email = -1;
        });
    },
    getCO_ID() {
      // 세션을 통해 현재 로그인한 기업 id 가져오기
      http
        .post("/check-session")
        .then((response) => {
          console.log(response.data);
          console.log('회사 id 가져오기');
          if (response.data != null && response.data != "") {
            this.co_id = response.data;
            this.getCO_NO();
          } else {
            this.co_id = null;
          }
        })
        .catch((e) => {
          console.log(e);
          this.co_id = null;
        });
    },
    registerPosition() {
      http
        .post("/register-position", {
          position: this.form.posName,
          qualify: this.form.qualify,
          employ_TYPE: this.form.employType,
          regi_DT: this.form.deadline,
          job: this.form.taskInfo,
          co_EMAIL: this.co_no,
          co_ID:this.co_id 
        })
        .then((response) => {
          console.log(response.data);
          alert("포지션 DB 등록 완료!");
          this.$router.push({ name: "JobPosting" });
        })
        .catch((e) => {
          console.log(e);
          alert("포지션 DB 등록 실패..");
          this.$router.go(0);
        });
    },
  },
};
</script>

<style scoped></style>
