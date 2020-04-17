package car_info_system.lab5_ex2.repository;

import car_info_system.lab5_ex2.models.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void whenFindCarByName_returnMaker() {

        Car save_car = entityManager.persistAndFlush(new Car("prius","toyota")); // insert

        Car car = carRepository.findByName("prius");


        assertThat(car.getName()).isEqualTo(save_car.getName());

        Car found = carRepository.findByName("outro");
        assertThat(found).isNull();
    }

    @Test
    void whenInvalidName_thenReturnNull() {
        Car found = carRepository.findByName("outro");
        assertThat(found).isNull();
    }


    @Test
    public void givenSetOfCars_whenFindAll_thenReturnAllCars() {

        Car a = new Car("aaaa","bbbb");
        Car b = new Car("bbbb","aaaa");

        entityManager.persist(a);
        entityManager.persist(b);
        entityManager.flush();

        List<Car> allCars = carRepository.findAll();

        assertThat(allCars).hasSize(2).extracting(Car::getName).containsOnly(a.getName(), b.getName());
    }



}
