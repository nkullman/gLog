package io.github.nkullman.glog;

import java.util.ArrayList;
import java.util.Date;

/**
 * A log consists of log entries, as well as a specific vehicle with its odometer reading
 * Created by Nick on 5/8/2016.
 */
public class gLog_Log {

    private ArrayList<gLog_Entry> logEntries = null;
    private int numberOfLogEntries = -1;
    private gLog_Entry mostRecentEntry = null;
    private gLog_Vehicle vehicle = null;
    private double latestOdometerReading = Double.NaN;
    private double totalGallonsLogged = Double.NaN;
    private double totalMilesLogged = Double.NaN;


    public gLog_Log(gLog_Vehicle vehicle){
        System.out.println("I made a new log");
        this.totalMilesLogged = 0;
        this.totalGallonsLogged = 0;
        this.logEntries = new ArrayList<>();
        this.numberOfLogEntries = logEntries.size();
        this.vehicle = vehicle.clone();
        this.latestOdometerReading = this.vehicle.getOdometer_reading();
    }

    public gLog_Entry getEntry(int index){
        return this.logEntries.get(index).clone();
    }

    public gLog_Entry getEntry(Date date){
        for (gLog_Entry entry : this.logEntries)
            if (entry.getDate().equals(date))
                return entry.clone();

        return null;
    }

    public int getLogEntryIndex(Date date){
        for (int i = 0; i < this.getNumEntries(); i++)
            if (getEntry(i).getDate().equals(date))
                return i;

        return -1;
    }

    public int getLogEntryIndex(gLog_Entry entry){
        for (int i = 0; i < this.getNumEntries(); i++)
            if (getEntry(i).getOdometerReading() == entry.getOdometerReading())
                return i;

        return -1;
    }

    public int getNumEntries(){
        return this.logEntries.size();
    }

    public gLog_Vehicle getVehicle(){
        return this.vehicle.clone();
    }

    public double getLastOdometerReading() { return this.latestOdometerReading; }

    public double getTotalGallonsLogged() { return this.totalGallonsLogged; }

    public double getTotalMilesLogged() { return this.totalMilesLogged; }

    public ArrayList<gLog_Entry> getAllLogEntries() { return cloneLogEntries(); }

    private ArrayList<gLog_Entry> cloneLogEntries() {
        ArrayList<gLog_Entry> result = new ArrayList<>();
        for (gLog_Entry entry : this.logEntries)
            result.add(entry.clone());
        return result;
    }

    private void addEntry(gLog_Entry entry){

        this.logEntries.add(entry.clone());
        this.numberOfLogEntries = logEntries.size();
        this.mostRecentEntry = entry.clone();
        this.vehicle.setOdometer_reading(entry.getOdometerReading());
        this.totalMilesLogged += entry.getOdometerReading() - this.latestOdometerReading;
        this.totalGallonsLogged += entry.getGallons();
        this.latestOdometerReading = entry.getOdometerReading();
    }

}
