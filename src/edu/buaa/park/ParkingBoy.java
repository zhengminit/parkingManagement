package edu.buaa.park;

import java.util.List;

public  class ParkingBoy {
    protected List<ParkPlace> parkPlaces;
    private  ParkingLotChooser parkingLotChooser;
    /**
     * 获取停车仔的id号，唯一标示
     */
    private String  parkingBoyId;

    public ParkingBoy(List<ParkPlace> parkPlaces, ParkingLotChooser parkingLotChooser) {
        this.parkPlaces=parkPlaces;
        this.parkingLotChooser = parkingLotChooser;
    }

    public ParkingBoy(String parkingBoyId ,List<ParkPlace> parkPlaces) {
        this.parkingBoyId = parkingBoyId;
        this.parkPlaces=parkPlaces;
    }


    public ParkingBoy(String parkingBoyId ,List<ParkPlace> parkPlaces, ParkingLotChooser parkingLotChooser) {
        this.parkingBoyId = parkingBoyId;
        this.parkPlaces=parkPlaces;
        this.parkingLotChooser = parkingLotChooser;
    }

    public List<ParkPlace>  getParkPlaces(){
        return this.parkPlaces;
    }
    public Ticket park(Car car) {
      return parkingLotChooser.getAvailablePark(parkPlaces).parkCar(car);
    }

    public Integer getAvailableNum() {
        int availableNum=0;
        for(ParkPlace parkPlace:parkPlaces){
            availableNum+=parkPlace.getAvailableNum();
        }
       return availableNum;
    }
    public Car fetch(Ticket ticket) {
        Car fetchedCar=null;
        for(ParkPlace parkPlace:parkPlaces){
            fetchedCar=parkPlace.fecthCar(ticket);
            if(fetchedCar!=null){return fetchedCar;}
        }
        throw new NoCarException("没有此车");
    }
            public String getParkingBoyId(){
                return this.parkingBoyId;
            }

}
