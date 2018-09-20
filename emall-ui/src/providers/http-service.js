import axios from 'axios'
import router from '../router'
import qs from 'qs'
import {getToken} from '../utils/token'
import {Notice, Message} from 'iview'

const service = axios.create({
  timeout: 15000
})

axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8'

service.interceptors.request.use(config => {
  config.data = JSON.stringify(config.data)
  if (getToken()) {
    config.headers['Authorization'] = 'Bearer ' + getToken()
  }
  return config
}, error => {
  console.log(error)
  return Promise.reject(error)
})

service.interceptors.response.use(
  response => {
    var result = response.data
    if (result.status === 200) {
      return result.data
    } else if (result.status === 401) {
      router.replace({
        path: '/',
        query: {redirect: router.currentRoute.fullPath}
      })
    } else {
      errorMessage(result.msg)
    }
  }, error => {
    switch (error.response.status) {
      case 401: {
        router.replace({
          path: '/',
          query: {redirect: router.currentRoute.fullPath}
        })
        break
      }
      default: errorMessage(error.message)
    }
    return Promise.reject(error)
  }
)
export const POST_HEADER = (url, params, headers) => {
  return axios({
    method: 'post',
    url: `${url}`,
    data: qs.stringify(params),
    headers : headers
  })
}

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

export function sucessMessage (msg) {
  Message.success(msg)
}

export function errorMessage (msg) {
  Notice.error({
    title: '错误提示',
    desc: msg,
    duration: 6
  })
}

export default service
