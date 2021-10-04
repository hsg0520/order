<template>
  home Page
  <a style="margin :20px" href="/login" >로그인</a>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import service from "../utils/https";

@Options({
  props: {
    msg: String,
  },
})
export default class HomePage extends Vue {
  msg!: string;

  methods!: {
    
  }
  
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
