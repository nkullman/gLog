package io.github.nkullman.glog;

import java.util.ArrayList;

/**
 * Created by Nick on 5/8/2016.
 */
public class gLog_Log {

    ArrayList<gLog_Entry> logEntries = new ArrayList<>();

    String getLastEntryLocation(){
        return this.logEntries.get(this.logEntries.size()-1).getLocation();
    }

    String addEntry(gLog_Entry entry){
        if (logEntries.size() < 1) {
            addInitialEntry(entry);
        } else {
            addNewEntry(entry);
        }
    }

}
