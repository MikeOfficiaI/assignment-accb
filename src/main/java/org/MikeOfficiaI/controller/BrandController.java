package org.MikeOfficiaI.controller;

import org.MikeOfficiaI.model.Brand;
import org.MikeOfficiaI.service.BrandService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/addVehicle")
    public String postCustomer(Model model) {
        List<Brand> brands = brandService.getBrands();
        model.addAttribute("vehicles", brands);
        return "newVehicle";
    }

    @PostMapping("/saveBrand")
    public String postVehicle(@ModelAttribute Brand brand) {
        System.out.println(brand.toString());
        brandService.saveBrand(brand);
        return "newVehicle";
    }

    @GetMapping("/getBrand")
    public void getVehicles(Model model) {
        List<Brand> brands = brandService.getBrands();
        model.addAttribute("brands", brands);
    }
}
