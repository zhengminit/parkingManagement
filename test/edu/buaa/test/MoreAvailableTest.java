package edu.buaa.test;

import edu.buaa.park.Car;
import edu.buaa.park.MaxAvailableParkingLotChooser;
import edu.buaa.park.ParkPlace;
import edu.buaa.park.ParkingBoy;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-18
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
public class MoreAvailableTest {

    private Integer totalAmount;
    private ParkingBoy parkingBoy;
    private List<ParkPlace> parkPlaces;
    @Before
    public void init(){
        List<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        Integer[] parkPlaceNums= new Integer[]{10, 20};
        totalAmount=0;
        for(Integer parknum:parkPlaceNums){
            parkPlaces.add(new ParkPlace(parknum));
            totalAmount+=parknum;
        }
        parkingBoy= new ParkingBoy(parkPlaces, new MaxAvailableParkingLotChooser());
        this.parkPlaces=parkPlaces;
    }

    /*smartparkingboy测试
   *    停车停在空车位多的那个停车场
   * */
    @Test
    public  void should_park_in_the_more_empty_parkplace(){
        parkingBoy.park(new Car());
        Assert.assertEquals(19, parkPlaces.get(1).getAvailableNum());
    }

    /*smartparkingboy测试
    两个车库空间相同时停在第0个
    * */
    @Test
    public void  should_park_in_the_first_parkplace_if_park_availableSize_same(){
        for(int i=0;i<10;i++){
            parkingBoy.park(new Car());
        }
        parkingBoy.park(new Car());
        Assert.assertEquals(9, parkPlaces.get(0).getAvailableNum());
    }
}
