<template>
  <div>
      <div>
        <label for="username">아이디</label>
        <input type="text" id="username" v-model="username">
      </div>
      <div>
        <label for="emailAddress">이메일</label>
        <input type="email" id="emailAddress" v-model="email">
      </div>
      <div>
        <label for="password">비밀번호</label>
        <input type="password" id="password" v-model="password">
      </div>
      <button type="submit" @click="sendSignUp">가입하기</button>
      <p>이미 계정이 있으십니까? <a href="/login">Sign in</a></p>
  </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import service from "../utils/https";

export default class RegisterPage extends Vue {
  username = '';
  password = '';
  email ='';


    // await service.post('/api/registrations', {
    //     username: "test123",
    //     password: "password",
    //     email: "test@mail.com"
    //   })
    //   .then(res => {
    //     console.log(res);
    //   })
    //   .catch(error => console.log(error));

    // console.log("hello");

  

  private sendSignUp():void{

    service.post('/api/registrations', {
        username: this.username,
        password: this.password, 
        email: this.email
      })
      .then(res => {
        console.log(res); 
        if(1 == Number(res)){
          alert("회원가입에 성공하였습니다.\n로그인페이지로 이동해주세용");
        }
        //console.log(JSON.stringify(res)); 
      })
      .catch(error => console.log(error)
      
      );
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
