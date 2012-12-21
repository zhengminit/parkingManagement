package edu.buaa.test;

import edu.buaa.park.FirstAvailableParkingLotChooser;
import edu.buaa.park.ParkPlace;
import edu.buaa.park.ParkingBoy;
import edu.buaa.park.ParkingManager;
import edu.buaa.park.ParkingDirector;
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
public class ParkingDirectorTest
{

    /**
     * 主管查看所有的停车记录
     */

    List<ParkingManager> parkingManagers = new ArrayList<ParkingManager>();
    List<ParkingBoy> parkingBoys = new ArrayList<ParkingBoy>();
    ParkPlace parkplace1,parkplace2,parkplace3,parkplace4,parkplace5;
    ParkingBoy parkingBoy1 ,parkingBoy2;
    List<ParkPlace> parkPlaces1 = new ArrayList<ParkPlace>() ;
    List<ParkPlace> parkPlaces2 = new ArrayList<ParkPlace>() ;
    List<ParkPlace> parkPlaces3 = new ArrayList<ParkPlace>() ;
    ParkingManager parkingManager1;
    int  allCapacity;
    int allAvailableNum;

    @Before
    public void init()
    {
        parkplace1 = new  ParkPlace(1 ,20);
        parkplace2 = new  ParkPlace(2, 18);
        parkplace3 = new  ParkPlace(3, 16);
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
        parkingManager1 = new ParkingManager("经理1",parkingBoys,parkPlaces3,new FirstAvailableParkingLotChooser());
        parkingManagers.add(parkingManager1);

    }


    /**
     * 查看所有停车列表
     */
    @Test
    public void testAllRecord()
    {
        ParkingDirector pd = new ParkingDirector();
        pd.showAllRecord(parkingManagers);
    }
    /**
     * 查看所有停车列表并统计总的 车位数、空位数

     */
    @Test
    public void testAllRecordAndTotalCount()
    {
        ParkingDirector pd = new ParkingDirector();
        pd.showAllRecordAndTotalCount(parkingManagers);
    }

    /**
     * 查看所有停车列表并分开统计每个经理、员工的总车位数、空位数，以及统计总的 车位数、空位数

     */
    @Test
    public void testAllRecordAndCount()
    {
        ParkingDirector pd = new ParkingDirector();
        pd.showAllRecordAndCount(parkingManagers);
    }


}
