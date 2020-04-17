package car_info_system.lab5_ex2.models;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "car")
public class Car {

    public static final int MAZ_SIZE = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = MAZ_SIZE)
    private String name;

    @Size(min = 3, max = MAZ_SIZE)
    private String maker;

    public Car(){
    }

    public Car(String name,String maker){
        this.name=name;
        this.maker=maker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
