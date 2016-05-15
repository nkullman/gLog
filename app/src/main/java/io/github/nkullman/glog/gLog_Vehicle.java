package io.github.nkullman.glog;

/**
 * Created by Nick on 5/8/2016.
 */
public class gLog_Vehicle {

    private String make;
    private String model;
    private int year;

    public gLog_Vehicle(int year, String make, String model){
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public gLog_Vehicle(){
        this.year = 2015;
        this.make = "Subaru";
        this.model = "Forester";
    }

    public gLog_Vehicle clone() {
        return new gLog_Vehicle(this.year,this.make,this.model);
    }
}
