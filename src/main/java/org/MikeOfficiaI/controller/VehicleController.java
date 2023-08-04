package org.MikeOfficiaI.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.MikeOfficiaI.dto.ContractDto;
import org.MikeOfficiaI.entity.Contract;
import org.MikeOfficiaI.entity.Vehicle;
import org.MikeOfficiaI.exception.ContractNotFoundException;
import org.MikeOfficiaI.exception.VehicleNotFoundException;
import org.MikeOfficiaI.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Api(description = "Controller for the vehicle entity")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle/add")
    @ApiOperation("Get list of all customers and viewing the creating new customer page")
    public String getVehicle(Model model) {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);
        return "newVehicle";
    }

    @PostMapping("/vehicle/save")
    @ApiOperation("Saving new vehicle")
    public String postVehicle(@ModelAttribute Vehicle vehicle, RedirectAttributes redirectAttributes) {
        vehicleService.saveVehicle(vehicle);
        redirectAttributes.addFlashAttribute("message", "The vehicle has been created successfully.");
        return "redirect:/contracts";
    }

    @GetMapping("/vehicle/get/{id}")
    @ApiOperation("Getting specific vehicle")
    public Vehicle getVehicle(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));
    }

    @RequestMapping("/vehicle/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Vehicle vehicle = vehicleService.get(id);
            model.addAttribute("vehicle", vehicle);
            return "updateVehicle";
        } catch (VehicleNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "The contract has been saved successfully.");
            return "redirect:/contracts";
        }
    }
}
