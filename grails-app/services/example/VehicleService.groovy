package example

import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Service
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

@Service(Vehicle)
@CurrentTenant
@CompileStatic
abstract class VehicleService {

    abstract List<Vehicle> list(Map args )

    abstract Integer count()

    abstract Vehicle find(Serializable id)

    abstract Vehicle save(String model,
                          Integer year)

    @Transactional
    Vehicle update( Serializable id,
                    String model,
                    Integer year) {
        Vehicle vehicle = find(id)
        if (vehicle != null) {
            vehicle.model = model
            vehicle.year = year
            vehicle.save(failOnError:true)
        }
        vehicle
    }

    abstract Vehicle delete(Serializable id)
}