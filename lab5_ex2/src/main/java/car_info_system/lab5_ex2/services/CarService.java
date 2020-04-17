package car_info_system.lab5_ex2.services;

import car_info_system.lab5_ex2.models.Car;
import car_info_system.lab5_ex2.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String key) {
        return  carRepository.findByName(key);
    }

    public Car getCarById(Long id){
        return carRepository.findById(id).orElse(null);
    }

    public Car getCarByName(String name){
        return carRepository.findByName(name);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }


    public boolean exists(String name) {

        if (carRepository.findByName(name) != null) {
            return true;
        }
        return false;
    }


    public Car save(Car car) {
        return carRepository.save(car);
    };


}
