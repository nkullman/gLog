package io.github.nkullman.glog;

import java.util.ArrayList;
import java.util.Date;

/**
 * A log consists of log entries, as well as a specific vehicle with its odometer reading
 * Created by Nick on 5/8/2016.
 */
public class gLog_Log {

    private ArrayList<gLog_Entry> logEntries = null;
    private gLog_Vehicle vehicle = null;
    private double odometerReading = Double.NaN;
    private double totalGallonsLogged = Double.NaN;
    private double totalMilesLogged = Double.NaN;

    public gLog_Log(){
        this.totalMilesLogged = 0;
        this.odometerReading = 0;
        this.totalGallonsLogged = 0;
        this.logEntries = new ArrayList<>();
        this.vehicle = new gLog_Vehicle();
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
            if (getEntry(i).getDate().equals(entry.getDate()))
                return i;

        return -1;
    }

    public int getNumEntries(){
        return this.logEntries.size();
    }

    public gLog_Vehicle getVehicle(){
        return this.vehicle.clone();
    }


    public String addEntry(gLog_Entry entry){
        if (logEntries.size() < 1) {
            return addInitialEntry(entry);
        } else {
            return addNewEntry(entry);
        }
    }

    public double getOdometerReading() { return this.odometerReading; }
    public double getTotalGallonsLogged() { return this.totalGallonsLogged; }
    public double getTotalMilesLogged() { return this.totalMilesLogged; }
    public ArrayList<gLog_Entry> getAllLogEntries() { return cloneLogEntries(); }

    private ArrayList<gLog_Entry> cloneLogEntries() {
        ArrayList<gLog_Entry> result = new ArrayList<>();
        for (gLog_Entry entry : this.logEntries)
            result.add(entry.clone());
        return result;
    }

    private String addInitialEntry(gLog_Entry entry){

        // check for issues with the entry (odometer
        return "Why am I returning a string?";
    }

    private String addNewEntry(gLog_Entry entry){

        // check for issues with entry (odometer reading greater than previous, ...)
        this.totalMilesLogged += entry.getOdometerReading() - this.odometerReading;
        this.totalGallonsLogged += entry.getGallons();
        this.odometerReading = entry.getOdometerReading();
        return "Why a string??";
    }

}
