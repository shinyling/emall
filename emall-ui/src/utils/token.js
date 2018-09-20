const accessTokenKey = 'EMALL_ACCESS_TOKEN'
const refreshTokenKey = 'EMALL_REFRESH_TOKEN'

export function getToken () {
  return localStorage.getItem(accessTokenKey)
}


export function setToken (token) {
  localStorage.setItem(accessTokenKey, token)
}

export function removeToken () {
  localStorage.removeItem(accessTokenKey)
}
