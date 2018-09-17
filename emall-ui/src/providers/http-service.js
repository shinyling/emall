import axios from 'axios'
import router from '../router'
import store from '../store/store'

axios.defaults.timeout = 5000
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8'

axios.interceptors.request.use(config => {
  config.data = JSON.stringify(config.data)
  if (store.state.access_token) {
    config.headers.access_token = store.state.access_token
  }

  return config
}, error => {
  return Promise.reject(error)
})

axios.interceptors.response.use(
  response => {
    var result = response.data
    if (result.code === 200) {
      return result
    } else if (result.code === 401) {
      router.replace({
        path: '/',
        query: {redirect: router.currentRoute.fullPath}
      })
    } else {
    }
  }, error => {
    switch (error.response.status) {
      case 401: {
        store.commit('logout')
        router.replace({
          path: '/',
          query: {redirect: router.currentRoute.fullPath}
        })
        break
      }
    }
    return Promise.reject(error)
  }
)

export const POST = (url, params) => {
  return axios.post(`${url}`, params).then(res => res.data)
}

export const GET = (url, params) => {
  return axios.get(`${url}`, {params: params}).then(res => res.data)
}

export const PUT = (url, params) => {
  return axios.put(`${url}`, params).then(res => res.data)
}

export const DELETE = (url, params) => {
  return axios.delete(`${url}`, {params: params}).then(res => res.data)
}

export const PATCH = (url, params) => {
  return axios.patch(`${url}`, params).then(res => res.data)
}

export default axios
