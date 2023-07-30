package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.entity.Vehicle;
import org.MikeOfficiaI.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/addVehicle")
    public String getVehicle(Model model) {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);
        return "newVehicle";
    }

    @PostMapping("/saveVehicle")
    public String postVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "newVehicle";
    }

    @GetMapping("/getVehicle")
    public void getVehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);
    }

    @GetMapping("/getVehicle/{id}")
    public Vehicle getVehicle(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));
    }
}
