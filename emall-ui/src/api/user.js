import * as request from '../providers/http-service'

export default {
  login: (username, password) => {
    var grant_type = 'password'
    var scope = 'app'
    var headers = {
      'Authorization': 'Basic YWNtZTphY21lc2VjcmV0',
      'Content-Type': 'application/x-www-form-urlencoded'
    }
    return request.POST_HEADER('/auth/oauth/token', {username, password, grant_type, scope}, headers)
  },
  getUserInfo: () => {
    return request.GET('/ucenter/user/info')
  }
}
