package com.company;

import java.util.Random;

/**
 * Created by Krzysztof Pikóra on 02.06.17.
 *
 * A Device object represents device / item which has name and it's type.
 */
public class Device {

    private String deviceType;
    private String deviceName;
    private int deviceTypeHashcode;
    private int deviceNameHashcode;
    private static int doNotEvenBotherId;
    private int uniqueId;


    static {
        Random generator = new Random();
        doNotEvenBotherId = generator.nextInt(1000);
    }



    /**
     * Device / item constructor
     * @param deviceType device type (e.g. bicycle)
     * @param deviceName device name (e.g. mountain bike)
     */
    public Device(String deviceType, String deviceName){
        this.deviceType = deviceType;
        this.deviceName = deviceName;
        this.deviceTypeHashcode = this.deviceType.hashCode();
        this.deviceNameHashcode = this.deviceName.hashCode();

        //just for fun
        uniqueId = doNotEvenBotherId;
        doNotEvenBotherId++;
    }



    /**
     * @return device type hashcode
     */
    public int getDeviceTypeHashcode(){
        return deviceTypeHashcode;
    }



    /**
     * @return device name hashcode
     */
    public int getDeviceNameHashcode(){
        return deviceNameHashcode;
    }



    /**
     * Just example method to test class documentation methodology
     * @param foo current day of the week
     * @param bar current shorthand of the month
     * @return random int between 1, 999
     * @deprecated just testing
     */
    public int documentationCreationCapabilityTest(int foo, String bar){
        Random generator = new Random();
        int randomInt = generator.nextInt(1000);
        return randomInt;
    }

    @Override
    public String toString(){
        return deviceType + " " + deviceName + " unique id: " + uniqueId;
    }
}
