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
 * Date: 12-12-17
 * Time: 下午1:38
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManagerTest
{

      List<ParkingBoy> parkingBoys = new ArrayList<ParkingBoy>();
    ParkPlace parkplace1,parkplace2,parkplace3,parkplace4,parkplace5;
    ParkingBoy parkingBoy1 ,parkingBoy2 ,newParkingBoy;
    List<ParkPlace> parkPlaces1 = new ArrayList<ParkPlace>() ;
    List<ParkPlace> parkPlaces2 = new ArrayList<ParkPlace>() ;
    List<ParkPlace> parkPlaces3 = new ArrayList<ParkPlace>() ;
    ParkingManager parkingManager;


    @Before
    public void init()
    {
        parkplace1 = new  ParkPlace(1,20);
        parkplace2 = new  ParkPlace(2,18);
        parkplace3 = new  ParkPlace(3,16);
        parkplace4 = new  ParkPlace(4,22);
        parkplace5 = new  ParkPlace(5,10);
        parkPlaces1.add(parkplace1);
        parkPlaces1.add(parkplace2);
        parkPlaces2.add(parkplace3);
        parkPlaces2.add(parkplace4);
        parkPlaces3.add(parkplace5);
        parkingBoy1 = new ParkingBoy("停车仔1",parkPlaces1);
        parkingBoy2 = new ParkingBoy("停车仔2",parkPlaces2);
        parkingBoys.add(parkingBoy1);
        parkingBoys.add(parkingBoy2);


    }

    /**
     * 经理添加停车仔
     */

    @Test
    public void testAddParkingBoy()
    {
        System.out.println("显示添加前的停车仔列表：");
           ParkingManager mp = new ParkingManager("经理1",parkingBoys,parkPlaces3,new FirstAvailableParkingLotChooser());
        mp.showParkingBoys(parkingBoys);
        System.out.println("显示添加后的停车仔列表：");
        newParkingBoy = new ParkingBoy("新停车仔",parkPlaces3);
        parkingBoys.add(newParkingBoy);
       mp.showParkingBoys(parkingBoys);
    }


    /**
     * 经理删除停车仔
     */
    @Test
    public void testDelParkingBoy()
    {
        System.out.println("显示删除前的停车仔列表：");
        ParkingManager mp = new ParkingManager("经理1",parkingBoys,parkPlaces3,new FirstAvailableParkingLotChooser());
        mp.showParkingBoys(parkingBoys);
        System.out.println("显示删除后的停车仔列表：");
        parkingBoys.remove(parkingBoy2);
        mp.showParkingBoys(parkingBoys);
    }

    /**
     * 经理查看管理的停车仔
     */
    @Test
    public void testshowParkingBoy()
    {
        System.out.println("显示管理的停车仔列表：");
        ParkingManager mp = new ParkingManager("经理1",parkingBoys,parkPlaces3,new FirstAvailableParkingLotChooser());
        mp.showParkingBoys(parkingBoys);
    }



    /**
     * 经理停车
     */
    @Test
    public void parkManager_ShouldParkCar()
    {
        Car car=new Car();
        int maxParkingNum=20;
        ParkPlace parkPlace=new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace) ;
        ParkingManager parkingManager= new ParkingManager(parkPlaces, new FirstAvailableParkingLotChooser());
        Ticket ticket=parkingManager.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1), parkingManager.getAvailableNum());
    }
    /*
    * 经理取车
    * */
    @Test
    public void parkManager_ShouldfetchCar()
    {
        Car car=new Car();
        int maxParkingNum=20;
        ParkPlace parkPlace=new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace) ;
        ParkingManager parkingManager= new ParkingManager(parkPlaces, new FirstAvailableParkingLotChooser());
        Ticket ticket=parkingManager.park(car);
        Assert.assertSame(car,parkingManager.fetch(ticket));
    }
}
