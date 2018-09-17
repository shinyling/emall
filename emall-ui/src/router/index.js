import Vue from 'vue'
import Router from 'vue-router'

import Layout from '@/components/layout/Layout'
import Home from '@/components/page/Home'

Vue.use(Router)

export const constantRouterMap = [
  {
    path: '/',
    name: '主页',
    redirect: 'home',
    icon: 'fa fa-home',
    noDropdown: true,
    meta: {
      requireAuth: true
    },
    component: Layout,
    children: [{path: 'home', component: Home}]
  }
]
const router = new Router({
  routes: constantRouterMap
})

export default router
