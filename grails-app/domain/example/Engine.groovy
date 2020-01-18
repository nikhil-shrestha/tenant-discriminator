package example

import grails.gorm.MultiTenant

class Engine implements MultiTenant<Engine> {
    Integer cylinders
    String manufacturer

    static constraints = {
        cylinders nullable: false
    }

    static mapping = {
        tenantId name:'manufacturer'
    }
}
