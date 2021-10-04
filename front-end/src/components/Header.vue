<template>
  <div>
    <!-- <img class="logo" src="/static/images/logo.png"> -->
   <h1>미스터콱</h1>
  </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";

@Options({
  props: {
    msg: String,
  },
})
export default class Header extends Vue {
  msg!: string;

  private test() {
    console.log("click!");
  }

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
