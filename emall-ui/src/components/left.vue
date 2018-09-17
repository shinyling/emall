<template>
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar" style="height: auto;">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>{{user.name}}</p>
          <a href="#"><i class="fa fa-circle text-success"></i>在线</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu tree" data-widget="tree">
        <li class="header" style="text-align: center">主菜单</li>
      <li class="treeview" v-if="!menu.hidden&&menu.noDropdown" v-for="menu in routers" v-bind:key="menu.name">
        <router-link v-if="menu.noDropdown" :to="menu.path+'/'+menu.children[0].path">
          <i :class="menu.icon"></i> <span>{{menu.name}}</span>
        </router-link>
        <a href="#" v-if="!menu.noDropdown">
          <i :class="menu.icon"></i> <span>{{menu.name}}</span>
          <span class="pull-right-container">
            <i class="fa fa-angle-left pull-right"></i>
          </span>
        </a>
        <ul class="treeview-menu" v-if="!menu.noDropdown" v-for="child of menu.children" v-bind:key="child.path">
          <li><router-link :to="menu.path+'/'+child.path"><i :class="child.icon"></i> {{child.name}}</router-link></li>
        </ul>
      </li>
        <!--<li class="treeview">-->
          <!--<router-link to="/menu/menu">-->
            <!--<span>主页</span>-->
          <!--</router-link>-->
          <!--<a href="#">-->
            <!--<i class="fa fa-index"></i> <span>主页</span>-->
            <!--<span class="pull-right-container">-->
              <!--<i class="fa fa-angle-left pull-right"></i>-->
            <!--</span>-->
          <!--</a>-->
          <!--<ul class="treeview-menu">-->
            <!--<li><router-link to="/menu/index">菜单管理</router-link></li>-->
          <!--</ul>-->
        <!--</li>-->
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
</template>

<script>
import {mapGetters} from 'vuex'
import API from '../api/menu'
export default {
  name: 'left',
  data () {
    return {
      menus: []
    }
  },
  computed: mapGetters([
    'user',
    'routers'
  ]),
  created: function () {
    this.getMenuList(this.$store.state.user.id)
  },
  methods: {
    getMenuList (userId) {
      var self = this
      var param = {id: userId}
      API.list(param).then(function (result) {
        self.menus = result
      }, function (err) {
        console.log(err)
      })
    }
  }
}
</script>

<style scoped>
  .sidebar-menu>li {
    text-align: left;
  }
</style>
