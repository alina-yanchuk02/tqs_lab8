package car_info_system.lab5_ex2;

import car_info_system.lab5_ex2.controllers.CarController;
import car_info_system.lab5_ex2.controllers.CarNotFoundException;
import car_info_system.lab5_ex2.models.Car;
import car_info_system.lab5_ex2.services.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


public class CarControllerTest {

    @Autowired
    MockMvc servlet;

    @MockBean
    CarService carService;



    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    public void whenGetCar_thenReturnCar() throws Exception {

        given( carService.getCarDetails(anyString())).willReturn( new Car("prius","toyota"));

        servlet.perform(MockMvcRequestBuilders.get("/cars/qualquer_string"))
                .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("prius"));

 

    }

    @Test
    public void whenGetNonExistingCar_theReturnNothing() throws Exception {

        given( carService.getCarDetails("dont_exist")).willThrow( new CarNotFoundException() );

        servlet.perform(MockMvcRequestBuilders.get("/cars/exist"))
                .andExpect(status().isOk());
    }






}
