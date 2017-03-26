package ru.ufacsdb.makegesture;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {


    GestureLibrary gLib;
    GestureOverlayView gestures;
    EditText etCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gLib = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if (!gLib.load()) {
            finish();
        }
        etCalc = (EditText) findViewById(R.id.etCalc);

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
                if      (prediction.name.equals("1"))
                    addsymbol("1");
                else if (prediction.name.equals("2"))
                    addsymbol("2");
                else if (prediction.name.equals("3"))
                    addsymbol("3");
                else if (prediction.name.equals("4"))
                    addsymbol("4");
                else if (prediction.name.equals("5"))
                    addsymbol("5");
                else if (prediction.name.equals("6"))
                    addsymbol("6");
                else if (prediction.name.equals("7"))
                    addsymbol("7");
                else if (prediction.name.equals("8"))
                    addsymbol("8");
                else if (prediction.name.equals("9"))
                    addsymbol("9");
                else if (prediction.name.equals("0"))
                    addsymbol("0");
                else if (prediction.name.equals("+"))
                    addsymbol("+");
                else if (prediction.name.equals("-"))
                    addsymbol("-");
                else if (prediction.name.equals("*"))
                    addsymbol("*");
                else if (prediction.name.equals("/"))
                    addsymbol("/");
            }
            else{
                Toast.makeText(getApplicationContext(), "Жест неизвестен", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void addsymbol(String string) {
        etCalc.setText(etCalc.getText()+string);
    }


}
