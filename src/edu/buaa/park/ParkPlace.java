package edu.buaa.park;
import java.util.*;

public class ParkPlace {
    private int index;
    private int capacity;
    private int totalCapacity;
    private Map<Ticket,Car> placeCarMaps=new HashMap<Ticket,Car>() ;
    public ParkPlace(){

    }
    public ParkPlace(int capacity) {
        this.capacity=capacity;
        this.totalCapacity = capacity ;
    }
   /**
    public ParkPlace(int capacity ,int totalCapacity) {
        this.capacity = capacity;
        this.totalCapacity = totalCapacity ;
    }
  */
    public ParkPlace(int index ,int capacity) {
        this.index = index;
        this.capacity = capacity;
        this.totalCapacity = capacity ;
    }
    public Ticket  parkCar(Car car){
        if(capacity <=0) throw new ParkFullException("车库满了");
        Ticket ticket=new Ticket();
        placeCarMaps.put(ticket,car);
        capacity--;
        return ticket;
    }

    public Car fecthCar(Ticket ticket) {

        Car car=placeCarMaps.get(ticket);
        if(car!=null){
            placeCarMaps.remove(ticket);
            capacity++;}
        return car;

    }
    public int getAvailableNum(){
        return  this.capacity;
    }

    public int getTotalCapacity(){
        return this.totalCapacity;
    }
    public int getIndex(){
        return this.index ;
    }
}

