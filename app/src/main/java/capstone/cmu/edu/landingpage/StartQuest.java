package capstone.cmu.edu.landingpage;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

// This activity fetches all the selected quests from the Today'sQuest fragment and starts the progress bar for its completion for the day.
// On completion, the user is awarded the specified points against the quest completed.
public class StartQuest extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startquest);

        String stringExtra1 = getIntent().getExtras().getString("selection");
        String[] splited = stringExtra1.split("\n");

        TextView textView1 = (TextView) findViewById(R.id.s1);
        textView1.setText(splited[0]);
        TextView textView2 = (TextView) findViewById(R.id.s2);
        textView2.setText(splited[1]);
        TextView textView3 = (TextView) findViewById(R.id.s3);
        textView3.setText(splited[2]);
        TextView textView4 = (TextView) findViewById(R.id.s4);
        textView4.setText(splited[3]);

    }
}