package io.github.nkullman.glog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class WelcomeScreen extends AppCompatActivity {

    // todo the welcome screen should read from the sharedpreferences thing the names of
    // all the logs (iterate over keys whose name starts with log_[...VEHICLEINFO_odometer]
    // populate the dropdown list for logs to choose from based off the responses from this iterating
    // if the list is empty, then disable the "add entry" button and just enable the add new log button
    // todo add a "view data" button or something similar

    private String[] logsAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        this.logsAvailable = new String[] {"2015 Subaru Forester (11208 mi)"};
        // TODO this should be reading keys from the shared preferences instead
        // add content (available logs) to the spinner
        Spinner s = (Spinner) findViewById(R.id.logPicker_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, logsAvailable);
        s.setAdapter(adapter);
    }

    public void addNewEntry(View view){

        Intent intent = new Intent(this, addNewEntryActivity.class);
        String logId = ((Spinner)findViewById(R.id.logPicker_spinner)).getSelectedItem().toString();
        intent.putExtra("log_id", logId);
        startActivity(intent);
        System.out.println("You pressed 'Add new entry'");
    }

    /** Called when the user clicks the Send button */
   /* public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/

    public void startNewLog(View view){
        // do new log stuff here
        //Intent intent = new Intent(this, startNewLogActivity.class);
        System.out.println("You pressed 'Add new entry'");

    }
}
