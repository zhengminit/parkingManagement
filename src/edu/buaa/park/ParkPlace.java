package edu.buaa.park;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 11-6-22
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */

public class ParkPlace
{
    private int index;
    private int availableParkingLot;
    private int totalCapacity;
    private Map<Ticket,Car> placeCarMaps=new HashMap<Ticket,Car>() ;

    public ParkPlace()
    {

    }
    public ParkPlace(int capacity)
    {
        this.availableParkingLot=capacity;
        this.totalCapacity = capacity ;
    }

    public ParkPlace(int index ,int capacity) {
        this.index = index;
        this.availableParkingLot = capacity;
        this.totalCapacity = capacity ;
    }

    public Ticket parkCar(Car car)
    {
        if(availableParkingLot <=0)
            throw new ParkFullException("车库满了");

        Ticket ticket=new Ticket();

        placeCarMaps.put(ticket,car);

        availableParkingLot--;

        return ticket;
    }

    public Car fetchCar(Ticket ticket)
    {
        Car car=placeCarMaps.get(ticket);

        if(car!=null){
            placeCarMaps.remove(ticket);
            availableParkingLot++;
        }

        return car;
    }

    public int getAvailableNum()
    {
        return  this.availableParkingLot;
    }

    public int getTotalCapacity()
    {
        return this.totalCapacity;
    }

    public int getIndex()
    {
        return this.index ;
    }
}

