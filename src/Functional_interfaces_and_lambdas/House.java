package Functional_interfaces_and_lambdas;

import java.util.function.Function;
import java.util.function.Predicate;

public class House  {
    private final String address;
    private String floorNames;
    private int floor ;

    public House(String address, String floorNames, int floor) {
        this.address = address;
        this.floor = floor;
        this.floorNames=floorNames;
    }

    public String getAddress() {
        return address;
    }


    public String getFloorNames() {
        return floorNames;
    }

    public void setFloorNames(String floorNames) {
        this.floorNames = floorNames;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                " адрес " + address + '\'' +
                " наименования этажа " + floorNames + '\'' +
                " этаж " + floor;
    }

}
