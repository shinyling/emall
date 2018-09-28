<template>
  <Menu active-name="home" theme="light" width="auto" :open-names="['1']">
    <MenuItem name="home"><Icon type="md-home" />主页&nbsp;&nbsp;&nbsp;&nbsp;</MenuItem>
    <div class="dynamicMenu" v-for="menu of menus">
      <MenuItem :name="menu.code"><Icon :type="menu.icon" />{{menu.name}}</MenuItem>
    </div>
  </Menu>
</template>
<script>
  import { mapState } from 'vuex'
  export default {
    data () {
      return {
      }
    },
    computed: mapState ({
      menus: state => state.menus
    })
  }
</script>
<style></style>
