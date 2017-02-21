package io.github.nkullman.glog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addNewEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_entry);

        Button doneButton = (Button) findViewById(R.id.submitEntrybutton);
        assert doneButton != null;
        doneButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                // retrieve all values
                // TODO add alerts or something if vals passed are invalid

                double or = Double.parseDouble((
                        (EditText)findViewById(R.id.odometerReading_editText)).getText().toString());
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = df.parse(((
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

                // todo this class (intent) should take a string indicating what log the entry belongs to
                // then it should look it up and retrieve it from the sharedpreferences using the
                // gson object
                // todo the welcome screen should read from the sharedpreferences thing the names of
                // all the logs (iterate over keys whose name starts with log_[...VEHICLEINFO_odometer]
                // populate the dropdown list for logs to choose from based off the responses from this iterating
                // if the list is empty, then disable the "add entry" button and just enable the add new log button

            }
        });
    }



    // if none, add the new entry to the log we're working with
    // update some stats or something
    // go to the screen with summary statistics:
    // "Since last fill! -- mpg, mi driven,..."
    // have an OK button at the bottom of that screen
    // hitting that takes you to the home page
    // where todo going to add a "view data" button or something
}
