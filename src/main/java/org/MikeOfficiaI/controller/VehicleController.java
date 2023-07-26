package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.model.Vehicle;
import org.MikeOfficiaI.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/addVehicle")
    public Vehicle postVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveCustomer(vehicle);
    }

    @GetMapping("/getVehicle")
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }
}
