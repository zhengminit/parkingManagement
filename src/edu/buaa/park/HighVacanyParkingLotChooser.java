package edu.buaa.park;

import edu.buaa.park.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-18
 * Time: 下午12:41
 * To change this template use File | Settings | File Templates.
 */
public class HighVacanyParkingLotChooser implements ParkingLotChooser{

    /**
     * @  获取空置率最高的那个停车场
     * @param parkPlaceList
     * @return  parkPlace;
     */
    public  ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList)
    {
        int maxsizeIndex=0;

        double highestVacanyRate = (double)parkPlaceList.get(0).getAvailableNum() / parkPlaceList.get(0).getTotalCapacity();

        for(int i = 1; i < parkPlaceList.size(); i++)
        {
            double tempVacanyRate = (double)parkPlaceList.get(i).getAvailableNum() / parkPlaceList.get(i).getTotalCapacity();

            if( tempVacanyRate > highestVacanyRate)
            {
                highestVacanyRate = tempVacanyRate;
                maxsizeIndex=i;
            }
        }

        if(parkPlaceList.get(maxsizeIndex).getAvailableNum()==0)
            throw new ParkFullException("所有的停车场都已满");

        return   parkPlaceList.get(maxsizeIndex);
    }
}
