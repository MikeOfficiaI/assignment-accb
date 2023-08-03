package org.MikeOfficiaI.service;

import org.MikeOfficiaI.entity.Customer;
import org.MikeOfficiaI.entity.Vehicle;
import org.MikeOfficiaI.exception.CustomerNotFoundException;
import org.MikeOfficiaI.exception.VehicleNotFoundException;
import org.MikeOfficiaI.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle get(long id) throws VehicleNotFoundException {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            return vehicle.get();
        }
        throw new VehicleNotFoundException("Could not find vehicle with ID " + id);
    }
}
