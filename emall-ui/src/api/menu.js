import * as API from '../providers/http-service'

export default {
  list: params => {
    return API.POST('/api/menu/loadMenuByUserId', params)
  }
}
