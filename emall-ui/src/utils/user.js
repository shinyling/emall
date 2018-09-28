const userKey = 'EMALL-CURRENT-USER'

export function setCurrentUser(user) {
  localStorage.setItem(userKey,user)
}

export function getCurrentUser() {
  return localStorage.getItem(userKey)
}

export function removeCurrentUser() {
  localStorage.removeItem(userKey)
}
