package car_info_system.lab5_ex2.controllers;

import car_info_system.lab5_ex2.models.Car;
import car_info_system.lab5_ex2.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService=carService;
    }

    @PostMapping("/cars" )
    public ResponseEntity<Car> createEmployee(@RequestBody Car employee) {
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carService.save(employee);
        return new ResponseEntity<>(saved, status);
    }


    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) {
        return carService.getCarDetails(name);
    }

    @GetMapping(path="/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }


}
