package edu.buaa.park;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-17
 * Time: 下午1:09
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager {

    /**
     * 管理多个parkingBoys
     */
     List<ParkingBoy>   parkingBoys ;

    protected List<ParkPlace> parkPlaces;
    private  ParkingLotChooser parkingLotChooser;
    /**
     * 获取经理的id号，唯一标示
     */
    private String  parkingManagerId;


    public ParkingManager(List<ParkPlace> parkPlaces, ParkingLotChooser parkingLotChooser) {
        this.parkPlaces=parkPlaces;
        this.parkingLotChooser = parkingLotChooser;
    }

    public ParkingManager(String parkingManagerId,List<ParkingBoy> parkingBoys ,List<ParkPlace> parkPlaces ,ParkingLotChooser parkingLotChooser) {
        this.parkingManagerId =parkingManagerId;
        this.parkingBoys =  parkingBoys;
        this.parkPlaces = parkPlaces;

        this.parkingLotChooser = parkingLotChooser;
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
    public String getParkingManagerId(){
        return  parkingManagerId;
    }
    public List<ParkPlace> getParkPlaces()  {
        return this.parkPlaces;
    }

    public void showParkingBoys(List<ParkingBoy> parkingBoys)  {

        for(int i = 0;i< parkingBoys.size();i++)
        {
            System.out.println(""+parkingBoys.get(i).getParkingBoyId());
        }

    }
}
