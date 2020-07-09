package tdc.edu.vn.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setEvent();
    }

    private void setEvent() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ArrayList sensorList = new ArrayList<String>();
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(Sensor item : sensors){
            sensorList.add(item.getName() + " : " + item.getVendor());
        }
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sensorList);
        listView.setAdapter(adapter);
    }
}
