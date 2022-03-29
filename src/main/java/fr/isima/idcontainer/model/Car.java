package fr.isima.idcontainer.model;

import fr.isima.idcontainer.annotate.InjectField;

public class Car {
    @InjectField
    private GearBox gearBox;

    @InjectField
    private Wheel[] wheelList;

    public Car(GearBox gearBox, Wheel[] wheelList){
        this.gearBox = gearBox;
        this.wheelList = wheelList;
    }

    public void setGearBox(GearBox gearBox){
        this.gearBox = gearBox;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setWheelList(Wheel[] wheelList){
        this.wheelList = wheelList;
    }

    public Wheel[] getWheelList(){
        return wheelList;
    }
}
