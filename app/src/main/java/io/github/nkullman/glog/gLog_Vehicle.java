package io.github.nkullman.glog;

/**
 * Created by Nick on 5/8/2016.
 */
public class gLog_Vehicle {

    private String make;
    private String model;
    private int year;
    private double odometer_reading;

    /**
     * Construct a new vehicle of the year given make, model, and year with the
     * given odometer reading.
     */
    public gLog_Vehicle(int year, String make, String model, double odometer_reading) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.odometer_reading = odometer_reading;
    }

    /**
     * Default constructor makes a brand new 2015 Subaru Forester
     */
    public gLog_Vehicle() {
        this.year = 2015;
        this.make = "Subaru";
        this.model = "Forester";
        this.odometer_reading = 0;
    }

    /* Setters */
    public void setYear(int year) {
        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setOdometer_reading(double odometer_reading) {
        this.odometer_reading = odometer_reading;
    }

    /* Getters */
    public double getOdometer_reading() {
        return this.odometer_reading;
    }

    public int getYear() {
        return this.year;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    /**
     * Clone the vehicle
     */
    public gLog_Vehicle clone() {
        return new gLog_Vehicle(this.year, this.make, this.model, this.odometer_reading);
    }
}
