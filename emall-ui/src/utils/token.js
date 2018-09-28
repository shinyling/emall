const accessTokenKey = 'EMALL_ACCESS_TOKEN'

export function getToken () {
  return localStorage.getItem(accessTokenKey)
}


export function setToken (token) {
  localStorage.setItem(accessTokenKey, token)
}

export function removeToken () {
  localStorage.removeItem(accessTokenKey)
}
