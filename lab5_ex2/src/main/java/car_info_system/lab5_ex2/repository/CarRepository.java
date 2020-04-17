package car_info_system.lab5_ex2.repository;

import car_info_system.lab5_ex2.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car,Long> {

    Car findByName(String name);

    List<Car> findAll();




}
