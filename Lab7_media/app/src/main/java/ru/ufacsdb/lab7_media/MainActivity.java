package ru.ufacsdb.lab7_media;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener btnClick=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myLogs",v.getId()+"");
                Click(v.getId());
            }
        };
        ((ImageButton)findViewById(R.id.bMusic)).setOnClickListener(btnClick);
        ((ImageButton)findViewById(R.id.bCamera)).setOnClickListener(btnClick);
        ((ImageButton)findViewById(R.id.bGallery)).setOnClickListener(btnClick);
    }
    protected void Click(int view){
        Intent intent=null;
        Log.d("myLogs",view+"");
        switch (view){
            case R.id.bMusic: intent=new Intent(this,MediaActivity.class);   break;
            case R.id.bGallery: intent=new Intent(this,GalleryActivity.class); break;
            case R.id.bCamera: intent=new Intent(this,CameraActivity.class); break;
            default: break;
        }
        if(intent!=null){
            Log.d("myLogs","Интент = "+intent.toString());
            startActivity(intent);
        }
    }

}
