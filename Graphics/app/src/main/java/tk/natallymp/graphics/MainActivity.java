package tk.natallymp.graphics;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;


public class MainActivity extends AppCompatActivity {

    private static final int TEXT_SIZE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = buildIntent();
        startActivity(intent);
    }

    public Intent buildIntent() {
        int[] values = new int[] { 25,25,25,25 };
        String[] bars = new String[] {"Bananas",  "Kiwi", "Oranges", "Cream"};
        int[] colors = new int[] { Color.YELLOW,  Color.GREEN, Color.RED, Color.CYAN };

        CategorySeries series = new CategorySeries("Pie Chart");
        DefaultRenderer dr = new DefaultRenderer();

        for (int v=0; v<4; v++){
            series.add(bars[v], values[v]);
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(colors[v]);
            dr.addSeriesRenderer(r);
        }
        dr.setZoomButtonsVisible(true);
        dr.setZoomEnabled(true);
        dr.setChartTitleTextSize(20);
        dr.setLegendTextSize(TEXT_SIZE);
        dr.setChartTitleTextSize(20);
        dr.setZoomButtonsVisible(false);
        dr.setLabelsTextSize(TEXT_SIZE);
        dr.setLegendTextSize(TEXT_SIZE);
        dr.setLabelsColor(Color.BLACK);
        return ChartFactory.getPieChartIntent(this, series, dr, "Fruit Salad");
    }
}

