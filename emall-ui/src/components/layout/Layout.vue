<template>
  <div class="layout">
    <Layout>
      <header-div/>
      <Layout>
        <Sider hide-trigger :style="{background: '#fff'}">
          <menu-div/>
        </Sider>
        <Layout :style="{padding: '0 24px 24px'}">
          <breadcrumb-div />
          <Content :style="{padding: '24px', minHeight: '480px', background: '#fff'}">
            <router-view></router-view>
          </Content>
        </Layout>
      </Layout>
    </Layout>
    <foot-div />
  </div>
</template>
<script>
  import footDiv from '../footer'
  import headerDiv from '../header'
  import menuDiv from '../menu/menu'
  import breadcrumbDiv from '../breadcrumb/breadcrumb'
  export default {
    components:{
      footDiv, headerDiv, menuDiv, breadcrumbDiv
    }
  }
</script>
<style scoped>
  .layout{
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
  .layout-logo{
    width: 100px;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    float: left;
    position: relative;
    top: 15px;
    left: 20px;
  }
  .layout-nav{
    width: 420px;
    margin: 0 auto;
    margin-right: 20px;
  }
</style>
