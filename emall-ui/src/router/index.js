import Vue from 'vue'
import Router from 'vue-router'
import store from '../store/store'
import Layout from '@/components/layout/Layout'
import Home from '@/page/Home'
import {getToken} from '@/utils/token'

Vue.use(Router)

if (getToken()) {
  store.commit('setAccessToken', getToken())
}
export const constantRouterMap = [
  {
    path: '/login',
    name: '登录',
    component: () => import('@/page/login')
  }, {
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
export const dynamicRouterMap = [
  {
    path: '/user',
    name: '用户管理',
    redirect: 'user',
    icon: 'fa fa-user',
    noDropdown: true,
    meta: {
      requireAuth: true,
    },
    component: Layout,
    children: [{path: 'user', component: (resolve) => require(['@/page/user'], resolve)}]
  }
]
const router = new Router({
  routes: constantRouterMap
})
router.beforeEach((to, from, next) => {
  if (to.matched.some(r => r.meta.requireAuth)) {
    store.dispatch('refresh')
    if (store.state.access_token) {
      store.dispatch('generateRoutes', store.state.menus)
      next()
    } else {
      console.log(JSON.stringify(store.state))
      next({
        path: '/login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
})
export default router
