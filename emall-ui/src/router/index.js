import Vue from 'vue'
import Router from 'vue-router'
import store from '@/store/store'
import Layout from '@/components/layout/Layout'
import Home from '@/components/page/Home'

Vue.use(Router)

if (window.localStorage.getItem('token')) {
  store.commit('setAccessToken', window.localStorage.getItem('access_token'))
  store.commit('setUserId', window.localStorage.getItem('userId'))
  store.commit('setUsername', window.localStorage.getItem('username'))
}
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
router.beforeEach((to, from, next) => {
  if (to.matched.some(r => r.meta.requireAuth)) {
    store.dispatch('refresh')
    if (store.state.access_token) {
      store.dispatch('generateRoutes', {})
      next()
    } else {
      console.log(JSON.stringify(store.state))
      next({
        path: '/',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
})
export default router