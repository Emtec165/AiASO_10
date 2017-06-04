package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysztof Pikóra on 02.06.17.
 *
 * Two dimensional hash table
 *
 * Explaining:
 * For given amount of devices / items create array in which one cell represents one device type ( [ bike, car, phone ] ).
 * For given amount of devices / items of certain type extend previous array
 * and put devices name to their corresponding index like so
 * [ [bike redBike, bike blueBike], [car yellowCar, car greenCar], [phone blackPhone] ].
 *
 * Enter device name and check if exact device exists in two dimensional array if yes return index of corresponding device type
 *
 * ask for "yellowCar" -> return 1
 * ask for "blueBike" -> return 0
 * ask for "blackPhone" -> return 2
 * ask for "blackMonitor -> return null
 */

public class Main {

    public static void main(String[] args) {

        int indexOfDeviceType;
        boolean deviceFoundInNestedList = false;
        Device redBike = new Device("bike", "redBike");
        Device blueBike = new Device("bike", "blueBike");
        Device yellowCar = new Device("car", "yellowCar");
        Device greenCar = new Device("car", "greenCar");
        Device blackPhone = new Device("phone", "blackPhone");


        Device deviceToFind = new Device("phone", "blackPhone");


        redBike.documentationCreationCapabilityTest(4, "Jun");  //documentation creation capability test


        List<Device> deviceList = new ArrayList<>();
        List<List<Device>> nestedDeviceList = new ArrayList<>();

        deviceList.add(redBike);
        deviceList.add(blueBike);
        deviceList.add(yellowCar);
        deviceList.add(greenCar);
        deviceList.add(blackPhone);






        /**
        * check if the device / item type is already in nested list.
        * If not -- add it to list
        * if yes -- add it to nested list at type corresponding index.
        */
        for (int i = 0; i < deviceList.size(); i++){
            indexOfDeviceType = -1;
            boolean deviceTypeIsAlreadyInArray = false;
            Device removedDevice =  deviceList.get(i);


            int removedDeviceTypeHashcode = removedDevice.getDeviceTypeHashcode();

            for (int j = 0; j < nestedDeviceList.size(); j++){
                if (removedDeviceTypeHashcode == nestedDeviceList.get(j).get(0).getDeviceTypeHashcode()){
                    deviceTypeIsAlreadyInArray = true;
                    indexOfDeviceType = j;
                    break;
                }
            }

            if (deviceTypeIsAlreadyInArray == false){
                List<Device> subList = new ArrayList<>();
                subList.add(removedDevice);
                nestedDeviceList.add(subList);

            } else {
                if (indexOfDeviceType != -1) {
                    List<Device> subList = nestedDeviceList.remove(indexOfDeviceType);
                    subList.add(removedDevice);
                    nestedDeviceList.add(subList);
                }
            }

        }
        System.out.println(nestedDeviceList + "\n");


        /**
         * Search for requested device type list index
         */
        indexOfDeviceType = -1;
        for (int i = 0; i < nestedDeviceList.size(); i++){
            if (deviceToFind.getDeviceTypeHashcode() == nestedDeviceList.get(i).get(0).getDeviceTypeHashcode()){
                indexOfDeviceType = i;
                break;
            }
        }


        /**
         * Search for requested device name.
         * If found requested device return list index.
         */
        try {
            List<Device> subList = nestedDeviceList.get(indexOfDeviceType);
            for (int i = 0; i < subList.size(); i++) {
                Device subElement = subList.get(i);
                if (subElement.getDeviceNameHashcode() == deviceToFind.getDeviceNameHashcode()) {
                    deviceFoundInNestedList = true;
                    break;
                }
            }

            if (deviceFoundInNestedList == true) {
                System.out.println("Device \"" + deviceToFind + "\" exist in nested list and its type index is: " + indexOfDeviceType);
            } else {
                System.out.println("Device \"" + deviceToFind + "\" don't exist in nested list.");
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Device \"" + deviceToFind + "\" type don't exist in nested list.\n" + e);
        }

        System.out.println(""); //repo change
    }
}
