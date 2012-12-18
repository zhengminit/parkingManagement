package edu.buaa.test;

import edu.buaa.park.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-18
 * Time: 下午12:53
 * To change this template use File | Settings | File Templates.
 */
public class HighVacanyTest {

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
        parkingBoy= new ParkingBoy(parkPlaces, new HighVacanyParkingLotChooser());
        this.parkPlaces=parkPlaces;
    }



    /*superparkingboy测试
   *    停车停在空置率最高的那个停车场
   *    由于初始空置率都为1.第一次停车在第0个停车场，第二次根据高空置率计算，停留在第1个停车场。
   *    在此时，第0个停车场的空置率为9/10，而第1个停车场的空置率为19/20，故第三次停车仔第1个停车场。
   * */
    @Test
    public  void should_park_in_the_high_vacany_parkplace(){
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        Assert.assertEquals(9,
                 parkPlaces.get(0).getAvailableNum());
        Assert.assertEquals(18,
                parkPlaces.get(1).getAvailableNum());
    }

    /*superparkingboy测试
    两个车库空置率一样时停在第0个
    * */
    @Test
    public void  should_park_in_the_first_parkplace_if_park_highvacany_same(){
        parkingBoy.park(new Car());
        Assert.assertEquals(9, parkPlaces.get(0).getAvailableNum());
    }
}
