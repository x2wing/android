package tk.natallymp.dialog;


import android.app.AlertDialog;
import android.content.Context;

import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bgButton;
    public RelativeLayout relativeLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bgButton = (Button) findViewById(R.id.background_button);
        bgButton.setOnClickListener(this);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        context = MainActivity.this;
    }

    @Override
    public void onClick(View v) {


        //создание всплывающего окна
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //заголовок всплывающего окна
        builder.setTitle(R.string.message);




        //списко элеменотов всплывающего окна
        final CharSequence[] items = {
                getText(R.string.red), getText(R.string.yellow), getText(R.string.green)
        };


        builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0: {
                                relativeLayout.setBackgroundResource(R.color.redColor);
                                Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();
                                break;
                            }
                            case 1: {
                                relativeLayout.setBackgroundResource(R.color.yellowColor);
                                Toast.makeText(context, R.string.yellow, Toast.LENGTH_LONG).show();
                                break;
                            }
                            case 2: {
                                relativeLayout.setBackgroundResource(R.color.greenColor);
                                Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();
                                break;
                            }
                        }


                    }
                }
        );

        AlertDialog alert = builder.create();
        alert.show();





    }
}
