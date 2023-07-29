package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.model.Customer;
import org.MikeOfficiaI.model.Vehicle;
import org.MikeOfficiaI.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/addVehicle")
    public String postCustomer(Model model) {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);
        return "newVehicle";
    }

    @PostMapping("/saveVehicle")
    public String postVehicle(@ModelAttribute Vehicle vehicle) {
        System.out.println(vehicle.toString());
        vehicleService.saveCustomer(vehicle);
        return "newVehicle";
    }

    @GetMapping("/getVehicle")
    public void getVehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);
    }
}
