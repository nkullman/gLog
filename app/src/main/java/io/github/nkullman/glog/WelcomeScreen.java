package io.github.nkullman.glog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Map;

public class WelcomeScreen extends AppCompatActivity {

    // todo add a "view data" button or something similar

    private String[] logsAvailable;
    private static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        // get the list of log files available
        final SharedPreferences mPrefs = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
        Map<String,?> keys = mPrefs.getAll();

        // instantiate and populate list of log file names
        ArrayList<String> al = new ArrayList<>();
        for(Map.Entry<String,?> entry : keys.entrySet())
            if (entry.getKey().startsWith("log_"))
                al.add(entry.getKey().substring(4));

        // if there is at least one available log
        if (al.size()>0) {
            // convert to and store as array
            logsAvailable = new String[al.size()];
            logsAvailable = al.toArray(logsAvailable);

            // add content (available logs) to the spinner
            Spinner s = (Spinner) findViewById(R.id.logPicker_spinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, logsAvailable);
            s.setAdapter(adapter);
        } else {
            // no logs available
            // disable the spinner and the add entry button
            Spinner s = (Spinner) findViewById(R.id.logPicker_spinner);
            Button b = (Button) findViewById(R.id.button_newEntry);
            s.setEnabled(false);
            s.setClickable(false);
            b.setText("No existing logs found");
            b.setEnabled(false);
        }
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
        Intent intent = new Intent(this, startNewLogActivity.class);
        startActivity(intent);
        System.out.println("You pressed 'Add new log'");

    }
}
