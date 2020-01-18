package example

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class EngineSpec extends Specification implements DomainUnitTest<Engine> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
