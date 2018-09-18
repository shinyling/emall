import Vue from 'vue'
import Vuex from 'vuex'

import { constantRouterMap } from '@/router'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {id: null, name: null},
    author: 'shiny',
    access_token: null,
    routers: constantRouterMap
  },
  getters: {
    user (state) {
      return state.user
    },
    routers (state) {
      return state.routers
    }
  },
  mutations: {
    setUserId (state, userId) {
      localStorage.setItem('userId', userId)
      state.user.id = userId
    },
    setUsername (state, username) {
      localStorage.setItem('username', username)
      state.user.name = username
    },
    setAccessToken (state, token) {
      localStorage.setItem('access_token', token)
      state.access_token = token
    },
    logout (state) {
      localStorage.removeItem('access_token')
      localStorage.removeItem('userId')
      localStorage.removeItem('username')
      state.access_token = null
      state.user = null
    },
    setRouters (state, routers) {
      state.routers = constantRouterMap
    }
  },
  actions: {
    refresh ({commit}) {
      commit('setUserId', localStorage.getItem('userId'))
      commit('setUsername', localStorage.getItem('username'))
      commit('setAccessToken', localStorage.getItem('access_token'))
    },
    clear ({commit}) {
      commit('logout')
    },
    generateRoutes ({ commit }, data) {
      return new Promise(resolve => {
        commit('setRouters', null)
        resolve()
      })
    }
  }
})