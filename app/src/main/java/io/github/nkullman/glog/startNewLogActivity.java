package io.github.nkullman.glog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class startNewLogActivity extends AppCompatActivity {

    private static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_log);

        // get gLog's shared preferences
        final SharedPreferences mPrefs = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);

        Button doneButton = (Button) findViewById(R.id.submitLogbutton);
        assert doneButton != null;
        doneButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                // retrieve all values
                // TODO add alerts or something if vals passed are invalid

                double or = Double.parseDouble((
                        (EditText)findViewById(R.id.vehicleOdometerReading_editText)).getText().toString());
                int year = Integer.parseInt((
                        (EditText)findViewById(R.id.vehicleYear_editText)).getText().toString());
                String make = ((EditText)findViewById(R.id.vehicleMake_editText)).getText().toString();
                String model = ((EditText)findViewById(R.id.vehicleModel_editText)).getText().toString();

                // create vehicle and log
                gLog_Log newLog = new gLog_Log(new gLog_Vehicle(year,make,model,or));
                // initialize ID of the log
                String logId = "log_"+year+" "+make+" "+model+" ("+or+" mi)";
                // push the new log to the shared preferences
                SharedPreferences.Editor editor = mPrefs.edit();
                Gson gsonUp = new Gson();
                String jsonUp = gsonUp.toJson(newLog);
                editor.putString(logId, jsonUp);
                editor.commit();
                System.out.println(jsonUp);

                Intent intent = new Intent(startNewLogActivity.this, WelcomeScreen.class);
                startActivity(intent);
            }
        });
    }
}
