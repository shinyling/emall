import * as request from '../providers/http-service'

export default {
  login: (username, password) => {
    var grant_type = 'password'
    var scope = 'app'
    var headers = {
      'Authorization': 'Basic YWNtZTphY21lc2VjcmV0',
      'Content-Type': 'application/x-www-form-urlencoded'
    }
    var data = {
      username: username,
      password: password,
      grant_type: grant_type,
      scope: scope
    }
    return request.POST_HEADER('/auth/oauth/token', data, headers)
  },
  getUserInfo: () => {
    return request.GET('/api/user/info')
  }
}
