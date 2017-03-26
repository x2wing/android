package ru.ufacsdb.makegesture;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {


    GestureLibrary gLib;
    GestureOverlayView gestures;
    TextView tvOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gLib = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if (!gLib.load()) {
            finish();
        }
        tvOut = (TextView) findViewById(R.id.tvOut);

        gestures = (GestureOverlayView)  findViewById(R.id.gestureOverlayView1);
        gestures.addOnGesturePerformedListener(this);

    }

    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        //Создаёт ArrayList c загруженными из gestures жестами
        ArrayList<Prediction> predictions = gLib.recognize(gesture);
        if (predictions.size() > 0) {
            //если загружен хотябы один жест из gestures
            Prediction prediction = predictions.get(0);
            if (prediction.score > 1.0) {
                if (prediction.name.equals("1"))
                    tvOut.setText("1");
                else if (prediction.name.equals("s"))
                    tvOut.setText("stop");
                else if (prediction.name.equals("2"))
                    tvOut.setText("2");
            }
            else{
                tvOut.setText("Жест неизвестен");
            }
        }
    }


}
