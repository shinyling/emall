const resourceKey = 'EMALL-RESOURCES'

export function setResources(resources) {
  localStorage.setItem(resourceKey,resources)
}

export function getResources() {
  return localStorage.getItem(resourceKey)
}

export function removeResources() {
  localStorage.removeItem(resourceKey)
}
