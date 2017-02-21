package io.github.nkullman.glog;

import android.location.Location;

import java.util.Date;

/**
 * Defines an entry in the log
 * Created by Nick on 5/8/2016.
 */
public class gLog_Entry {

    private gLog_Log log = null; // the log to which this entry belongs
    private double odometerReading = Double.NaN; // vehicle's current odometer reading
    private Date date = null; // date of refueling
    private String stationOwner = null; // "Shell", "Texaco", etc.
    private String geoloc = null; // currently just have user provide string
    private double pricePerGallon = Double.NaN;
    private double gallons = Double.NaN;
    private String note = null;
    // Location geoloc = null; TODO add ability to get user's current location

    public gLog_Entry(gLog_Log log){
        this.log = log;
        this.date = new Date();
        this.geoloc = this.log.getEntry(this.log.getNumEntries()-1).getLocation();
        this.stationOwner = this.log.getEntry(this.log.getNumEntries()-1).getStationOwner();
        this.odometerReading = this.log.getLastOdometerReading();
        this.pricePerGallon = this.log.getEntry(this.log.getNumEntries()-1).getPricePerGallon();
        this.gallons = 0;
    }

    public gLog_Entry(gLog_Log log, Date date, double odometerReading, double pricePerGallon, double gallons) {
        this.log = log;
        this.date = date;
        this.odometerReading = odometerReading;
        this.pricePerGallon = pricePerGallon;
        this.gallons = gallons;
    }

    public gLog_Entry(gLog_Log log, Date date, String geoloc, String stationOwner, double odometerReading, double pricePerGallon, double gallons, String note){
        this.log = log;
        this.date = date; // TODO might have to update: arg = str, this will parse it
        this.geoloc = geoloc;
        this.stationOwner = stationOwner;
        this.odometerReading = odometerReading;
        this.pricePerGallon = pricePerGallon;
        this.gallons = gallons;
        this.note = note;
    }

    public Date getDate() { return (Date) this.date.clone(); }

    public void setDate(Date logEntryDate) {this.date = logEntryDate; }

    public String getLocation(){
        return this.geoloc;
    }

    public void setLocation(String entryLocation) { this.geoloc = entryLocation; }

    public String getStationOwner() { return this.stationOwner; }

    public void setStationOwner(String stationOwner) { this.stationOwner = stationOwner; }

    public double getOdometerReading() { return this.odometerReading; }

    public void setOdometerReading(double odometerReading) { this.odometerReading = odometerReading; }

    public double getPricePerGallon() { return this.pricePerGallon; }

    public void setPricePerGallon(double pricePerGallon) { this.pricePerGallon = pricePerGallon; }

    public double getGallons () { return this.gallons; }

    public void setGallons(double gallons) { this.gallons = gallons; }

    public String getNote () {return this.note;}

    public void setNote(String note) { this.note = note;}

    public gLog_Entry clone(){
        return new gLog_Entry(this.log, this.date, this.getLocation(), this.stationOwner, this.odometerReading,this.pricePerGallon,this.gallons, this.note);
    }

}