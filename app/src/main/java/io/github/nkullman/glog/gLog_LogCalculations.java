package io.github.nkullman.glog;

/**
 * Created by Nick on 5/14/2016.
 */
public class gLog_LogCalculations {

    public double getDistanceTraveled(gLog_Entry firstEntry, gLog_Entry laterEntry){
        return Math.abs(laterEntry.getOdometerReading() - firstEntry.getOdometerReading());
    }

    public double getMPG(gLog_Log log, gLog_Entry firstEntry, gLog_Entry laterEntry){
        double miles = laterEntry.getOdometerReading() - firstEntry.getOdometerReading();

        int firstIdx = log.getLogEntryIndex(firstEntry);
        int laterIdx = log.getLogEntryIndex(laterEntry);
        double gallons = 0;
        for (int i = firstIdx+1; i <= laterIdx; i++)
            gallons += log.getEntry(i).getGallons();

        return miles/gallons;
    }

    // PRE: log has two or more entries
    public double getMPG(gLog_Log log) {
        return (log.getTotalMilesLogged()/log.getTotalGallonsLogged());
    }

}
