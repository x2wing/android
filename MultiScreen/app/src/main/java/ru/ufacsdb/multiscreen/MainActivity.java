package ru.ufacsdb.multiscreen;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


public class MainActivity extends ListActivity {

    //надписи в списке
    String[] islands = { "Канары", "Курилы", "Мальдивы", "Филиппины"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        //адаптер списка меню
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, islands);
        // инициализатор меню
        setListAdapter(adapter);


        OnItemClickListener itemListener = new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        toCountry(Canari.class);
                        break;
                    case 1:
                        toCountry(Curili.class);
                        break;
                    case 2:
                        toCountry(Maldivi.class);
                        break;
                    case 3:
                        toCountry(Philippini.class);
                        break;
                }
                Toast.makeText(getBaseContext(), "Вы выбрали " + parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();


            }
        };
        getListView().setOnItemClickListener(itemListener);

    }
    private void toCountry(Class<?> country) {

        Intent intent = new Intent(MainActivity.this, country);
        startActivity(intent);
    }
}
