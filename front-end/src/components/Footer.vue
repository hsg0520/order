<template>
  <div>
    <span>가입 문의 : 000-0000-0000</span>
  </div>
</template>


<script lang="ts">
import { Options, Vue } from "vue-class-component";

@Options({
  props: {
    msg: String,
  },
})
export default class Footer extends Vue {
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
