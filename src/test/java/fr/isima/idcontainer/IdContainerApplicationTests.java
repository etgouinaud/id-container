package fr.isima.idcontainer;

import fr.isima.idcontainer.container.Container;
import fr.isima.idcontainer.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdContainerApplicationTests {

    Container container;

    @BeforeEach
    void createContainer(){
        container = Container.getcontainer();
    }

    @Test
    @DisplayName("Test simple injection")
    void testSimpleInjection() {
    try{
        container.register(Wheel[].class, RoadWheel[].class);
        container.register(GearBox.class, ShortGearBox.class);
        Car car = (Car) container.newInstance(Car.class);
        Assertions.assertTrue(car.getGearBox() instanceof ShortGearBox);
        Assertions.assertTrue(car.getWheelList() instanceof RoadWheel[]);



    }catch (Exception e){

    }
    }

}
