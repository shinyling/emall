const menuKey = 'EMALL-MENU'

export function setMenu(menu) {
  localStorage.setItem(menuKey,menu)
}

export function getMenu() {
  return localStorage.getItem(menuKey)
}

export function removeMenu() {
  localStorage.removeItem(menuKey)
}
