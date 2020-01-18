package example

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VehicleController {

    VehicleService vehicleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vehicleService.list(params), model: [vehicleCount: vehicleService.count()]
    }

    def show(Long id) {
        Vehicle vehicle = id ? vehicleService.find(id) : null
        respond vehicle
    }

    def create() {
        respond new Vehicle(params)
    }

    def save(String model, Integer year) {
        try {
            Vehicle vehicle = vehicleService.save(model, year)
            flash.message = 'Vehicle created'
            redirect vehicle
        } catch (ValidationException e) {
            respond e.errors, view: 'create'
        }
    }

    def edit(Long id) {
        respond vehicleService.get(id)
    }

    def update(Long id, String model, Integer year) {
        try {
            Vehicle vehicle = vehicleService.update(id, model, year)
            if (vehicle == null) {
                notFound()
            } else if ( vehicle.hasErrors() ) {
                redirect action: 'edit', params: [id: id]
            }
            else {
                flash.message = 'Vehicle updated'
                redirect vehicle
            }
        } catch (ValidationException e) {
            respond e.errors, view: 'edit'
        }
    }



    def delete(Long id) {
        Vehicle vehicle = vehicleService.delete(id)
        if (vehicle == null) {
            notFound()
        }
        else {
            flash.message = 'Vehicle Deleted'
            redirect action: 'index', method: 'GET'
        }
    }

    protected void notFound() {
        flash.message = 'Vehicle not found'
        redirect uri: '/vehicles', status: NOT_FOUND
    }
}
