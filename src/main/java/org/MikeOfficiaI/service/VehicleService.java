package org.MikeOfficiaI.service;

import org.MikeOfficiaI.model.Vehicle;
import org.MikeOfficiaI.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle saveCustomer(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
