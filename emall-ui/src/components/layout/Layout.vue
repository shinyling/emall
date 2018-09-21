<template>
  <div class="layout">
    <Layout>
      <header-div></header-div>
      <Layout><left-div></left-div><Layout><right-div></right-div></Layout></Layout>
      <footer-div></footer-div>
    </Layout>
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
  .layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
</style>
