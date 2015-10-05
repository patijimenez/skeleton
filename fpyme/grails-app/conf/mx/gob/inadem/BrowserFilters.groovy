package mx.gob.inadem

class BrowserFilters {

    def userAgentIdentService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
              if(userAgentIdentService.isMsie()) {
                def version = Float.parseFloat(userAgentIdentService.getBrowserVersion())
                if(controllerName && version < 9) {
                  if(controllerName == 'auth') {
                    redirect(controller: 'modernBrowser')
                    return false
                  } else if(controllerName != 'modernBrowser') {
                    return false
                  }
                }
              }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
