package example

import grails.gorm.MultiTenant

class Vehicle implements MultiTenant<Vehicle> {
    String model
    Integer year
    String manufacturer

    static hasMany = [engines: Engine]
    static constraints = {
        model blank:false
        year min:1980
    }

    static mapping = {
        tenantId name:'manufacturer'
    }
}