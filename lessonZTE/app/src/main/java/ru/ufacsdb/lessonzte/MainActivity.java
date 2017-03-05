package ru.ufacsdb.lessonzte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView helloTv;
    private int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTv = (TextView) findViewById(R.id.hello_tv);
        Button helloBtn = (Button) findViewById(R.id.hello_btn);

        helloBtn.setOnClickListener(onClickListener); // Обработчик
    }
    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            counter++;
            helloTv.setText(counter+"");

        }
    };
}
