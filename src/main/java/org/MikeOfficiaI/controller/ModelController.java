package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.model.Model;
import org.MikeOfficiaI.service.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ModelController {

    private ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/addModel")
    public String postCustomer(org.springframework.ui.Model model) {
        List<Model> models = modelService.getModels();
        model.addAttribute("vehicles", models);
        return "newVehicle";
    }

    @PostMapping("/saveModel")
    public String postModel(@ModelAttribute Model model) {
        System.out.println(model.toString());
        modelService.saveModel(model);
        return "newVehicle";
    }

    @GetMapping("/getModel")
    public void getModels(org.springframework.ui.Model model) {
        List<Model> vehicles = modelService.getModels();
        model.addAttribute("vehicles", vehicles);
    }
}
