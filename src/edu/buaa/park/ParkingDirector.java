package edu.buaa.park;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-17
 * Time: 下午1:09
 * To change this template use File | Settings | File Templates.
 */


public class ParkingDirector {

    List<ParkingManager>   parkingManagers ;

    int allCapacity ;
    int allAvailableNum ;


    /**
     * 显示所有停车列表
     * @param parkingManagers
     */
    public void showAllRecord(List<ParkingManager>  parkingManagers){

          for(int i =0;i< parkingManagers.size();i++)
          {
          System.out.println("经理编号："+parkingManagers.get(i).getParkingManagerId());
              showPakingInfo(parkingManagers.get(i).getParkPlaces());
            for(int j =0;j<parkingManagers.get(i).parkingBoys.size();j++)
            {     System.out.println("停车仔编号："+
                   parkingManagers.get(i).parkingBoys.get(j).getParkingBoyId());
                showPakingInfo(parkingManagers.get(i).parkingBoys.get(j).getParkPlaces());
            }
          }
    }

    /**
     * 显示所有停车列表，并统计总的车位数，以及空位数
     * @param parkingManagers
     */
    public void showAllRecordAndTotalCount(List<ParkingManager>  parkingManagers){
        for(int i =0;i< parkingManagers.size();i++)
        {
            System.out.println("经理编号："+parkingManagers.get(i).getParkingManagerId());
            showPakingInfo(parkingManagers.get(i).getParkPlaces());
            allCapacity  = + calAllCapacity(parkingManagers.get(i).getParkPlaces());
            allAvailableNum  = + calAllAvailableNum(parkingManagers.get(i).getParkPlaces());
            for(int j =0;j<parkingManagers.get(i).parkingBoys.size();j++)
            {
                System.out.println("停车仔编号："+
                        parkingManagers.get(i).parkingBoys.get(j).getParkingBoyId());
                showPakingInfo(parkingManagers.get(i).parkingBoys.get(j).getParkPlaces());
                allCapacity  = + calAllCapacity(parkingManagers.get(i).parkingBoys.get(j).getParkPlaces());
                allAvailableNum  = + calAllAvailableNum( parkingManagers.get(i).parkingBoys.get(j).getParkPlaces());
            }
        }
        System.out.println("Total车位数："+allCapacity);
        System.out.println("Total空位数："+allAvailableNum);
    }

    /**
     * 显示所有停车列表，并统计每个经理、停车仔的车位数、空位数 以及 总的车位数，以及空位数
     * @param parkingManagers
     */
    public void showAllRecordAndCount(List<ParkingManager>  parkingManagers){
        for(int i =0;i< parkingManagers.size();i++)
        {
            System.out.println("经理编号："+parkingManagers.get(i).getParkingManagerId());
            showPakingInfo(parkingManagers.get(i).getParkPlaces());


            System.out.println("\tTotal车位数："+
                    calCapacity(parkingManagers.get(i).getParkPlaces()));
            System.out.println("\tTotal空位数："+
                    calAvailableNum(parkingManagers.get(i).getParkPlaces()));
            allCapacity  = + calAllCapacity(parkingManagers.get(i).getParkPlaces());
            allAvailableNum  = + calAllAvailableNum(parkingManagers.get(i).getParkPlaces());
            for(int j =0;j<parkingManagers.get(i).parkingBoys.size();j++)
            {
                System.out.println("停车仔编号："+
                        parkingManagers.get(i).parkingBoys.get(j).getParkingBoyId());
                showPakingInfo(parkingManagers.get(i).parkingBoys.get(j).getParkPlaces());

                System.out.println("\tTotal车位数："+
                        calCapacity(parkingManagers.get(i).parkingBoys.get(j).getParkPlaces()));
                System.out.println("\tTotal空位数："+
                        calAvailableNum( parkingManagers.get(i).parkingBoys.get(j).getParkPlaces()));

                allCapacity  = + calAllCapacity(parkingManagers.get(i).parkingBoys.get(j).getParkPlaces());
                allAvailableNum  = + calAllAvailableNum( parkingManagers.get(i).parkingBoys.get(j).getParkPlaces());
            }
        }
        System.out.println("Total车位数："+allCapacity);
        System.out.println("Total空位数："+allAvailableNum);
    }


    public void showPakingInfo(List<ParkPlace> parkPlaces) {
        for(int i =0 ;i< parkPlaces.size();i++)
        {
            System.out.println("\t停车场编号:" +parkPlaces.get(i).getIndex());
            System.out.println("\t\t车位数:" +parkPlaces.get(i).getTotalCapacity());
            System.out.println("\t\t空位数"+parkPlaces.get(i).getAvailableNum());

        }
    }



    public int  calAllCapacity(List<ParkPlace> parkPlaces){
        for(int i =0 ;i< parkPlaces.size();i++){
            allCapacity = allCapacity + parkPlaces.get(i).getTotalCapacity();
        }
        return allCapacity;
    }

    public int  calAllAvailableNum(List<ParkPlace> parkPlaces){
        for(int i =0 ;i< parkPlaces.size();i++){
            allAvailableNum = allAvailableNum + parkPlaces.get(i).getAvailableNum();
        }
        return allAvailableNum;
    }
    public int  calCapacity(List<ParkPlace> parkPlaces){
        int capacity = 0;
        for(int i =0 ;i< parkPlaces.size();i++){
            capacity = capacity + parkPlaces.get(i).getTotalCapacity();
        }
        return capacity;
    }

    public int  calAvailableNum(List<ParkPlace> parkPlaces){
        int availableNum = 0;
        for(int i =0 ;i< parkPlaces.size();i++){
            availableNum = availableNum + parkPlaces.get(i).getAvailableNum();
        }
        return availableNum;
    }

}
