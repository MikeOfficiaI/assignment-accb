package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.model.Vehicle;
import org.MikeOfficiaI.service.VehicleService;
import org.springframework.ui.Model;
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
    public String postVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.saveCustomer(vehicle);
        return "redirect:/contract";
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Vehicle> liststudent = vehicleService.getVehicles();
        model.addAttribute("listscontract", liststudent);
        return "index";
    }

    @GetMapping("/getVehicle")
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }
}
