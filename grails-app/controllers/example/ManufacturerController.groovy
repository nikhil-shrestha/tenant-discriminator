package example


import org.grails.datastore.mapping.multitenancy.web.SessionTenantResolver
import grails.gorm.transactions.ReadOnly
import groovy.transform.CompileStatic

@CompileStatic
class ManufacturerController {

    ManufacturerService manufacturerService

    @ReadOnly
    def index() {
        render view: '/index', model: [manufacturers: manufacturerService.findAll()]
    }

    @ReadOnly
    def select(String id) {
        Manufacturer m = manufacturerService.findByName(id)
        if ( m ) {
            session.setAttribute(SessionTenantResolver.ATTRIBUTE, m.name.toLowerCase())
            redirect controller: 'vehicle'
        }
        else {
            render status: 404
        }
    }
}
