package io.github.nkullman.glog;

import android.location.Location;

import java.util.Date;

/**
 * This class defines an entry the log
 * Created by Nick on 5/8/2016.
 */
public class gLog_Entry {

    gLog_Log log = null;
    gLog_Vehicle vehicle = null;
    double odometerReading = Double.NaN; // vehicle's current odometer reading
    Date date = null; // date of refueling
    String stationOwner = null; // "Shell", "Texaco", etc.
    String geoloc = null; // currently just have them type it in
    // Location geoloc = null; TODO add ability to get user's current location

    public gLog_Entry(gLog_Log log){
        this.date = new Date();
        this.geoloc = this.log.getLastEntryLocation();
        this.stationOwner = this.log.getLastEntryStation();
        this.odometerReading = this.log.getLastEntryOdometer();
        this.vehicle = this.log.getLastEntryVehicle();
    }

    public String getLocation(){
        return this.geoloc;
    }


}