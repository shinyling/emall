<template>
  <div class="wrapper" style="height: auto; min-height: 100%;">
    <header-div></header-div>
    <left-div></left-div>
    <right-div></right-div>
    <footer-div></footer-div>
  </div>
</template>

<script>
import HeaderDiv from '../header'
import FooterDiv from '../footer'
import LeftDiv from '../left'
import RightDiv from '../right'
export default {
  name: 'layout',
  components: {
    HeaderDiv, FooterDiv, LeftDiv, RightDiv
  }
}
</script>

<style scoped>
  .container{
    position: absolute;
    top: 0;
    bottom: 0;
    width: 100%;
  }
</style>
