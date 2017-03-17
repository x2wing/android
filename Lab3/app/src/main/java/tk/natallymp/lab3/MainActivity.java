package tk.natallymp.lab3;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnActTwo;
    private static final String TAG=MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnActTwo = (Button) findViewById(R.id.btnActTwo);
    }


    public void onClickToActivity2(View v) {
        Intent intent = new Intent(MainActivity.this, main.class);
        startActivity(intent);
        }








}

