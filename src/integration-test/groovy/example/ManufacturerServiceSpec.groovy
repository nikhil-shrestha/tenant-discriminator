package example

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ManufacturerServiceSpec extends Specification {

    ManufacturerService manufacturerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Manufacturer(...).save(flush: true, failOnError: true)
        //new Manufacturer(...).save(flush: true, failOnError: true)
        //Manufacturer manufacturer = new Manufacturer(...).save(flush: true, failOnError: true)
        //new Manufacturer(...).save(flush: true, failOnError: true)
        //new Manufacturer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //manufacturer.id
    }

    void "test get"() {
        setupData()

        expect:
        manufacturerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Manufacturer> manufacturerList = manufacturerService.list(max: 2, offset: 2)

        then:
        manufacturerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        manufacturerService.count() == 5
    }

    void "test delete"() {
        Long manufacturerId = setupData()

        expect:
        manufacturerService.count() == 5

        when:
        manufacturerService.delete(manufacturerId)
        sessionFactory.currentSession.flush()

        then:
        manufacturerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Manufacturer manufacturer = new Manufacturer()
        manufacturerService.save(manufacturer)

        then:
        manufacturer.id != null
    }
}
