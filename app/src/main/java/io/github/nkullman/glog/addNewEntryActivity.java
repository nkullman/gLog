package io.github.nkullman.glog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addNewEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_entry);

        // get gLog's shared preferences
        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);

        // get the ID of the log to which to assign the entry
        Intent intent = getIntent();
        String logId = intent.getStringExtra("log_id");

        // retrieve the log
        Gson gson = new Gson();
        String json = mPrefs.getString(logId,"");
        final gLog_Log currLog = gson.fromJson(json,gLog_Log.class);

        Button doneButton = (Button) findViewById(R.id.submitEntrybutton);
        assert doneButton != null;
        doneButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                // retrieve all values
                // TODO add alerts or something if vals passed are invalid

                double or = Double.parseDouble((
                        (EditText)findViewById(R.id.odometerReading_editText)).getText().toString());
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date date = null;
                try {
                    date = df.parse(((
                            (EditText)findViewById(R.id.date_editText)).getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                double ppg = Double.parseDouble((
                        (EditText)findViewById(R.id.pricePerGal_editText)).getText().toString());
                double galsFilled = Double.parseDouble((
                        (EditText)findViewById(R.id.gals_editText)).getText().toString());
                String loc = ((EditText)findViewById(R.id.location_editText)).getText().toString();
                if (loc.equals("\"Sequim, WA\"")) loc = "";
                String fs = ((EditText)findViewById(R.id.station_editText)).getText().toString();
                if (fs.equals("\"QuikTrip, Shell, BP, etc.\"")) fs = "";
                String notes = ((EditText)findViewById(R.id.demoNote_editText)).getText().toString();
                if (notes.equals("\"While taking Grandma to get ice cream. Filled up with premium\"")) notes = "";

                currLog.addEntry(new gLog_Entry(date,loc,fs,or,ppg,galsFilled,notes));

                // todo update some stats, show screen w summary statistics
                // "Since last fill! -- mpg, mi driven,..."
                // have an OK button at the bottom of that screen
                // hitting that takes you to the home page
            }
        });
    }
}
