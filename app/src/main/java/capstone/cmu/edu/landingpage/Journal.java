package capstone.cmu.edu.landingpage;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

//import graphview
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LabelFormatter;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

public class Journal extends Fragment {
    EditText bg;
    Button bOk;
    static LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
    static LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>();

    DecimalFormat format = new DecimalFormat("0.#");
    static ArrayList<Date> dates = new ArrayList<>();
    static ArrayList<Double> datesLong = new ArrayList<>();
    static ArrayList<Double> readings = new ArrayList<>();
    static ArrayList<Double> carbs = new ArrayList<>();
    static ArrayList<String> faces = new ArrayList<>();
    static ArrayList<String> moods = new ArrayList<>();
    static ArrayList<Integer> tiredness = new ArrayList<>();

    DateFormat dateFormat  = new SimpleDateFormat("MM/dd HH m a");
    DateFormat dateFormatLabel;
    static GraphView graph;
    View myView;

    static int initiated = 0;

    public Journal (){
        //add faces
        faces.add("☺️"); //happy face 0
        faces.add("\uD83D\uDE10"); //neutral symbol
        faces.add("☹️"); //sad face
        faces.add("\uD83D\uDE16"); //upset face 3
        if (initiated == 0) {
            addDefault();
            initiated = 1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        myView=inflater.inflate(R.layout.activity_journal,container,false);
        getActivity().setTitle("Journal");

        dateFormatLabel = new SimpleDateFormat("MM/dd/Y h a");

        //add faces
        faces.add("☺️"); //happy face 0
        faces.add("\uD83D\uDE10"); //neutral symbol
        faces.add("☹️"); //sad face
        faces.add("\uD83D\uDE16"); //upset face 3

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);


        graph = (GraphView)myView.findViewById(R.id.graph);

        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    int i = datesLong.indexOf(value);

                    return (dateFormat.format(value));
                } else {
                    // show currency for y values
                    return format.format(value);
                }
            }
        });


        //format graph
        graph.getGridLabelRenderer().setHorizontalLabelsAngle(30);

        //new BG data points
        ;
        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(myView.getContext(), "Blood glucose reading: "+dataPoint.getY(), Toast.LENGTH_SHORT).show();
                dataPoint.getX();
                TextView d = (TextView) myView.findViewById(R.id.journalDate);
                TextView dn = (TextView) myView.findViewById(R.id.journalNumber);
                TextView fn = (TextView) myView.findViewById(R.id.foodNumber);
                TextView mi = (TextView) myView.findViewById(R.id.moodIcon);

                //find date
                int i = datesLong.indexOf(dataPoint.getX());
                d.setText("Entry made on " + dateFormatLabel.format(dates.get(i)));
                Log.e("READING", String.valueOf(readings.get(i)));
                dn.setText(String.valueOf(readings.get(i)));
                fn.setText(String.valueOf(carbs.get(i).toString()));
                mi.setText(moods.get(i));
            }
        });


        if (initiated == 0) {
            addDefault();
            initiated = 1;
        }

        graph.addSeries(series);
        graph.getSecondScale().addSeries(series2);

        //set color and scale for tiredness
        graph.getSecondScale().setMinY(0);
        graph.getSecondScale().setMaxY(4);
        series2.setColor(Color.RED);
        graph.getGridLabelRenderer().setVerticalLabelsSecondScaleColor(Color.RED);

        graph.getViewport().setScalable(true);
        graph.getViewport().setScrollable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollableY(true);

        graph.getViewport().setXAxisBoundsManual(true);

        Calendar c = Calendar.getInstance();
        Calendar cur = Calendar.getInstance();
        c.add(Calendar.DATE, - 3);

        graph.getViewport().setMinX(c.getTime().getTime());
        graph.getViewport().setMaxX(cur.getTime().getTime());

        setDate();

        return myView;
    }

    void setDate() {
        TextView d = (TextView) myView.findViewById(R.id.journalDate);
        TextView dn = (TextView) myView.findViewById(R.id.journalNumber);
        TextView mi = (TextView) myView.findViewById(R.id.moodIcon);

        if (dates.size() > 0) {
            d.setText("Last Entry was on " + dateFormatLabel.format(dates.get(dates.size() - 1)));
            dn.setText(String.valueOf(readings.get(readings.size() - 1)));
        }

        ImageView mImageView;
        mImageView = (ImageView) myView.findViewById(R.id.blood);
        mImageView.setImageResource(R.drawable.blood);

        TextView fn = (TextView) myView.findViewById(R.id.foodNumber);
        fn.setText(String.valueOf(carbs.get(carbs.size() - 1)));
        mi.setText(moods.get(moods.size() - 1));

        ImageView mImageViewfood;
        mImageViewfood = (ImageView) myView.findViewById(R.id.food);
        mImageViewfood.setImageResource(R.drawable.apple);

    }

    public void addDefault(){

        double y, x;
        x = -5.0;
        //generate random diet and BG numbers
        Random rnd = new Random();
        for (int i = 8; i >=0; i--) {

            //x = days before today's date
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, - i);
            Date d = c.getTime();

            dates.add(d);
            datesLong.add((double)
                    d .getTime());

            //random BG numbers
            y = rnd.nextInt(70) + 80;

            //random carb number
            double carb = rnd.nextInt(45) + 30;

            //random tiredness number
            Integer tired = rnd.nextInt(3) + 1;

            //random mood number
            Integer mood = rnd.nextInt(3);
            moods.add(faces.get(mood));

            readings.add(y);
            carbs.add(carb);
            tiredness.add(tired);

            series.appendData(new DataPoint(c.getTime(), y), true, 100);
            series2.appendData(new DataPoint(c.getTime(),tired),true, 20);
        }

    }
    static void addEntry(double BG, double carb, int t, int mood) {

        Calendar c = Calendar.getInstance();
        Date d = c.getTime();

        dates.add(d);
        datesLong.add((double)d.getTime());

        readings.add(BG);
        carbs.add(carb);
        tiredness.add(t);
        moods.add(faces.get(mood));

        series.appendData(new DataPoint(d, BG), true, 100);
        series2.appendData(new DataPoint(d, t),true, 100);

        graph.removeAllSeries();
        graph.addSeries(series);

    }
}
