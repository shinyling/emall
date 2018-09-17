import * as API from '../providers/http-service'

export default {
  login: params => {
    return API.POST('/api/user/login', params)
  }
}
