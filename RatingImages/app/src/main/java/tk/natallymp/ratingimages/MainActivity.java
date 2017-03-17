package tk.natallymp.ratingimages;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private String url_image;

    private ImageView imageView1;
    private EditText edit_message1;
    private ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_message1 = (EditText) findViewById(R.id.edit_message);
        WebView webView = (WebView) findViewById(R.id.web_view1);
        webView.loadUrl("http://ya.ru");
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setClickable(true);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLink("https://mail.ru");
            }
        });





    }

    public void onClickGO(View v){
        String url_image =  edit_message1.getText().toString();



        //вывод картинки в imageview
        Picasso
                .with(this)
                .load(url_image)
                .placeholder(R.drawable.errormessage)
                .error(R.drawable.errormessage)
                .into(imageView1);

    }

    public void onClick_go_url(View v) {
        String url_image =  edit_message1.getText().toString();
        toLink(url_image);
    }
    //перейти по ссылке рабочи код
    private void toLink(String url){

        Uri address = Uri.parse(url);
        Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openlinkIntent);
    }

}

