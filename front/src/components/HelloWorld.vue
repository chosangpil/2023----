<template>
  <div class="hello">
   <h1>Home</h1>
    <!-- navbar(헤더) -->
   <h3 v-for="personal in test2" :key="personal.P_ID">{{personal.NAME}}</h3>
 
     <!-- navbar(헤더) -->
  </div>

</template>

<script>
import http from "../http-common";// eslint-disable-line no-unused-vars
export default {
  name: 'HelloWorld',
    data(){
    return{
      personal:[]
    }
},

/**/

/*추가*/
methods:{
    retrieveUsers(){
      http
        .get("/list")
        .then(response=>{
          this.personal = response.data;
          console.log(response.data);
        })
        .catch(e=>{
          console.log(e);
        })
    }
  },
  
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