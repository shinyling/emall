import Vue from 'vue'
import Vuex from 'vuex'
import {getToken, setToken, removeToken} from '../utils/token'

import { constantRouterMap, dynamicRouterMap } from '@/router'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {},
    menus: [],
    resources: [],
    author: 'shiny',
    access_token: null,
    routers: constantRouterMap
  },
  getters: {
    resources (state) {
      return state.resources
    },
    menus (state) {
      return state.menus
    },
    user (state) {
      return state.user
    },
    routers (state) {
      return state.routers
    }
  },
  mutations: {
    setUser(state, user){
      state.user = user
    },
    setMenus(state, user){
      state.menus = user.menus
    },
    setResources(state, user){
      state.resources = user.resources
    },
    setAccessToken (state, token) {
      state.access_token = token
    },
    logout (state) {
      removeToken()
      state.access_token = null
      state.user = null
    },
    setRouters (state, routers) {
      state.routers = constantRouterMap.concat(routers)
    }
  },
  actions: {
    setUser({commit},user){
      commit('setUser', user)
      commit('setMenus', user)
      commit('setResources', user)
    },
    storeToken({commit},token){
      setToken(token)
      commit('setAccessToken', token)
    },
    refresh ({commit}) {
      commit('setAccessToken', getToken())
    },
    clear ({commit}) {
      commit('logout')
    },
    generateRoutes ({ commit }, data) {
      let dr = new Array();
      for(let i = 0; i< dynamicRouterMap.length; i++){
        let name=dynamicRouterMap[i].name;
        for(let j = 0; j < data.length; j++){
          if(data[j].name==name){
            dr.push(dynamicRouterMap[i]);
          }
        }
      }
      return new Promise(resolve => {
        commit('setRouters', dr)
        resolve()
      })
    }
  }
})
