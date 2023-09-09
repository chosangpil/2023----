<template>
  <div class="join-indv">
    <h3 align="center" style="font-weight: bold; margin-bottom: 25px">개인 회원가입</h3>
    
    <b-form class="join-form">

      <!-- 이름 -->
      <b-form-group label-cols-lg="3" label="Name" label-for="input-name">
        <b-form-input
          id="input-name"
          type="text"
          v-model="form.name"
          placeholder="Enter Name"
          required
        ></b-form-input>
      </b-form-group>

      <!-- 성별 -->
      <b-form-group label-cols-lg="3" label="Gender" label-for="btn-radio-gender">
        <b-form-radio-group
          id="btn-radio-gender"
          :options="genderOptions"
          class="btn-gender"
          v-model="form.gender"
          name="radio-btn-outline"
          buttons
        ></b-form-radio-group>
      </b-form-group>

      
      <!-- <b-form-group label-cols-lg="3" label-align-sm="right" label="Name" label-for="input-name">
          <b-form-input
            id="input-name"
            type="text"
            v-model="form.name"
            placeholder="Enter Name"
            required
          ></b-form-input>
        </b-form-group> -->
      <!-- id / pw -->
      <b-form-group label-cols-lg="3" label="ID" label-for="input-ID">
        <b-form-input
          id="input-ID"
          type="text"
          v-model="form.id"
          placeholder="Enter ID"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group label-cols-lg="3" label="PW" label-for="input-PW">
        <b-form-input
          id="input-PW"
          type="password"
          v-model="form.pw"
          placeholder="Enter Password"
          required
        ></b-form-input>
      </b-form-group>

      <!-- email -->
      <b-form-group label-cols-lg="3" label="E-mail" label-for="input-email">
        <b-form-input
          id="input-email"
          type="email"
          v-model="form.email"
          placeholder="Enter E-mail"
          required
        ></b-form-input>
      </b-form-group>

      <!-- 연락처 -->
      <b-form-group label-cols-lg="3" label="Contact" label-for="input-contact">
        <b-form-input
          id="input-contact"
          type="text"
          v-model="form.contact"
          placeholder="Enter Contact Information"
          required
        ></b-form-input>
      </b-form-group>

      <!-- 출생년월일 -->
      <b-form-group label-cols-lg="3" label="Birth year" label-for="datepicker-dob">
        <b-form-input
          id="datepicker-dob"
          type="text"
          v-model="form.dob"
          placeholder="Enter Year of Birth"
          required
        ></b-form-input>
      </b-form-group>

      <!-- 학력 -->
      
      <div class="AcademicCareer-label" >
        <span style="margin-right: 4px; font-weight: bold;">Academic Career</span>
        <span>
          <b-button class="career-btn" @click="addAcademic"> Add </b-button>
          <b-button class="career-btn"  @click="removeAcademic"> Delete </b-button>
        </span>
      </div>
      <b-form-group>
        <!-- <b-button variant="primary" @click="addAcademic"> + </b-button> -->
        <div v-for="acirow in academicRows" :key="acirow" class="join-form-2">
          <b-form-group class="career-form-group">
            <span class="academicLevel-label">학위 : </span>
            <b-form-select
              v-model="acirow.degree"
              :options="degreeOptions"
            ></b-form-select>
          </b-form-group>
          <b-form-group
          label-cols-lg="4"
          label="School Name"
          label-for="input-school"
          class="career-form-group">
            <b-form-input
              id="input-school"
              type="text"
              v-model="acirow.school"
              placeholder="Enter School Name"
            ></b-form-input>
          </b-form-group>
          <b-form-group
          label-cols-lg="4"
          label="Department"
          label-for="input-academic-dept"
          class="career-form-group">
            <b-form-input
              id="input-academic-dept"
              type="text"
              v-model="acirow.dept"
              placeholder="Enter Department"
            ></b-form-input>
          </b-form-group>
          <b-form-group
          label-cols-lg="4"
          label="Admission Year"
          label-for="input-academic-ay"
          class="career-form-group">
            <b-form-input
              id="input-academic-ay"
              type="text"
              v-model="acirow.ay"
              placeholder="Enter Admission Year"
            ></b-form-input>
          </b-form-group>
          <b-form-group
          label-cols-lg="4"
          label="Graduation Year"
          label-for="input-academic-gy"
          class="last-career-form-group">
            <b-form-input
              id="input-academic-gy"
              type="text"
              v-model="acirow.gy"
              placeholder="Enter Graduation Year"
            ></b-form-input>
          </b-form-group>
          <!-- <b-button variant="danger" @click="removeAcademic"> - </b-button> -->
        </div>
      </b-form-group>

      <!-- 경력 -->
      <div class="career-label">
          <span style="margin-right: 4px; font-weight: bold;">Career</span>
          <span>
            <b-button class="career-btn" @click="addCareer"> Add </b-button>
            <b-button class="career-btn" @click="removeCareer"> Delete </b-button>
          </span>
        </div>
      <b-form-group>
        <div class="join-form-2" v-for="cirow in careerRows" :key="cirow">
              <b-form-group
              label-cols-lg="4"
              label="Company Name"
              label-for="input-company"
              class="career-form-group">
                <b-form-input
                  id="input-company"
                  type="text"
                  v-model="cirow.company"
                  placeholder="Enter Company Name"
                ></b-form-input>
              </b-form-group>
              <b-form-group
              label-cols-lg="4"
              label="Department"
              label-for="input-career-dept"
              class="career-form-group">
                <b-form-input
                  id="input-career-dept"
                  type="text"
                  v-model="cirow.dept"
                  placeholder="Enter Department"
                ></b-form-input>
              </b-form-group>
              <b-form-group
              label-cols-lg="4"
              label="Duty"
              label-for="input-duty"
              class="last-career-form-group">
                <b-form-input
                  id="input-duty"
                  type="text"
                  v-model="cirow.duty"
                  placeholder="Enter Duty"
                ></b-form-input>
              </b-form-group>
          
            </div>
        
      </b-form-group>

      <b-button class="joinButton" type="button" variant="outline-secondary" @click="joinIndvUser">완료</b-button>
    </b-form>
  </div>
</template>

<script>
import http from "../http-common";

const academicList = [];
const careerList = [];

export default {
  name: "JoinIndv",
  data() {
    return {
      form: {
        name: "",
        gender: 0,
        id: "",
        pw: "",
        email: "",
        contact: "",
        dob: null,
        age: 0,
      },
      academicRows: [{ degree: "", school: "", dept: "", ay: null, gy: null }],
      careerRows: [{ company: "", dept: "", duty: "" }],
      genderOptions: [
        { text: "남", value: 0 },
        { text: "여", value: 1 },
      ],
      degreeOptions: [
        { text: "학사학위", value: "bachelor" },
        { text: "석사학위", value: "master" },
        { text: "박사학위", value: "doctor" },
      ],
    };
  },
  methods: {
    
    joinIndvUser() {
      http
        .post("/success-join-indv", {
          p_ID: this.form.id,
          p_PW: this.form.pw,
          name: this.form.name,
          p_EMAIL: this.form.email,
          phone: this.form.contact,
          birth_DATE: this.form.dob,
          age: this.form.age,
          gender: this.form.gender,
        })
        .then((response) => {
          console.log(response.data);
          this.joinCareerInfo();
          this.joinAcdemicCareerInfo();
          alert("회원가입이 완료!");
          this.$router.push({ name: "Login" });
        })
        .catch((e) => {
          console.log(e);
          alert("회원가입 실패..");
          this.$router.go(0);
        });
    },
    joinAcdemicCareerInfo() {
      this.matchAcademic();
      http
        .post("/success-join-aci", academicList)
        .then((response) => {
          alert("학력 추가 가져오기 성공..");/*break point*/
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
          alert("학력 추가 가져오기 실패..");/*break point*/
        });
    },
    joinCareerInfo() {
      this.matchCareer();
      http
        .post("/success-join-ci", careerList)
        .then((response) => {
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    addAcademic: function() {
      this.academicRows.push({
        degree: "",
        school: "",
        dept: "",
        ay: null,
        gy: null,
      });
    },
    removeAcademic: function(row) {
      this.academicRows.splice(this.academicRows.indexOf(row), 1);
    },
    addCareer() {
      this.careerRows.push({
        company: "", dept: "", duty: "" 
      });
    },
    removeCareer(row) {
      this.careerRows.splice(this.careerRows.indexOf(row), 1);
    },
    matchAcademic() {
      for (var i = 0; i < this.academicRows.length; i++) {
        academicList[i] = {
          p_ID: this.form.id,
          degree: this.academicRows[i].degree,
          school_NAME: this.academicRows[i].school,
          major: this.academicRows[i].dept,
          admission_DATE: this.academicRows[i].ay,
          graduation_DATE: this.academicRows[i].gy
        };
      }
      alert("학력 리스트 가져오기 성공..");/*break point*/
    },
    matchCareer() {
      for (var i = 0; i < this.careerRows.length; i++) {
        careerList[i] = {
          p_ID: this.form.id,
          p_COMPANY: this.careerRows[i].company,
          p_DEPARTMENT: this.careerRows[i].dept,
          p_DUTY: this.careerRows[i].duty,
        };
      }
    },
  },
};
</script>

<style>

@import "../assets/CSS/joinIndv.css";

.join-indv {
  padding: 30px;
  margin: 0 auto;
  margin-top: 50px;
  margin-bottom: 50px;
  width: 450px;
}

.join-form .form-group {
  display: flex;
}

.join-form-2 .form-group {
  display: flex;
}

.form-group > div {
  width: 100%;
}

</style>
