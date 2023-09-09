<template>
    <div class="join">
    <b-card class="shadow">
        
        <h2>Create Account</h2>  
        <b-row align-h="center" style="padding:10px;">
            <b-col>
                <b-button class="button" size="lg" variant="primary" href="/#/join-indv">일반회원가입</b-button>
            </b-col>
        </b-row>
        
        <b-row align-h="center" style="padding:10px;">
            <b-col>
                <b-button class="button" size="lg" variant="primary" href="/#/join-comp">기업회원가입</b-button>  
            </b-col>
        </b-row>
        
        <b-row align-h="center" style="padding:10px;">
                    <b-col>
                        <b-button variant="secondary" href="/">Matching Platform</b-button>
                    </b-col>
                </b-row>
    </b-card>
  </div>
</template>

<script>
export default {
};
</script>

<style>
.join{
  position:absolute;
  top: 380px;
  left: 50%;
  width: 400px;
  margin: -150px 0 0 -200px;
}
</style>