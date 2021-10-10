<template>
    <div>
            <div>
                <label for="username">아이디</label>
                <input type="text" id="username" v-model="username">
            </div>
            <div>
                <label for="password">비밀번호</label>
                <input type="password" id="password" v-model="password">
            </div>
            <button @click="login">로그인</button>
            <div>
                <a style="margin :20px" href="/register" >회원가입</a>
                <a style="margin :20px" href="#">비밀번호 찾기</a>
            </div>
    </div>
</template>

<script lang="ts">
import { Vue } from "vue-class-component";
import service from "../utils/https";

export default class LoginPage extends Vue {
   username = '';
  password = '';
  email ='';
  
  private login():void{
    //alert("test")
    service.post('/api/login', {
        username: this.username,
        password: this.password
      })
      .then(res => {
        alert(res);
        console.log(res); 
      })
      .catch(error => alert(error));
  };

  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
