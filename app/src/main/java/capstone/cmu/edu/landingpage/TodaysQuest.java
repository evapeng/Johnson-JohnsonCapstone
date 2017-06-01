package capstone.cmu.edu.landingpage;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

// This fragment performs the selection of quests by user as they click their choice of quests. It displays the quests on diabetes which can benefit them to convert it into a habit after a 21 day period.
// Once they complete such 21 days habitual scheme, they are awarded a trophy.
public class TodaysQuest extends Fragment implements OnClickListener {

    private Button saveBtn;
    private CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11;

    View myView;

    @Nullable
    @Override
    // Method which displays the quests with selection click options and a save button to save your selected quests for the day.
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_quest, container, false);
        getActivity().setTitle("Quests");

        saveBtn = (Button) myView.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(this);

        c1 = (CheckBox)myView.findViewById(R.id.t1);
        c2 = (CheckBox)myView.findViewById(R.id.t2);
        c3 = (CheckBox)myView.findViewById(R.id.t3);
        c4 = (CheckBox)myView.findViewById(R.id.t4);
        c5 = (CheckBox)myView.findViewById(R.id.t5);
        c6 = (CheckBox)myView.findViewById(R.id.t6);
        c7 = (CheckBox)myView.findViewById(R.id.t7);
        c8 = (CheckBox)myView.findViewById(R.id.t8);
        c9 = (CheckBox)myView.findViewById(R.id.t9);
        c10 = (CheckBox)myView.findViewById(R.id.t10);
        c11 = (CheckBox)myView.findViewById(R.id.t11);


        // Current Quests
        //Sync in your glucose today 10 pts
        c1.setText("Maintain Glucose to 5.2mmol/I - 10 pts");

        // Run 4 miles today  20 pts
        c2.setText("Run 4 miles today - 20 pts");

        // Take insulin today at 4:00 PM 5 pts
        c3.setText("Take insulin today at 4:00 PM - 5 pts");

        // Dance for 15 mins  15 pts
        c4.setText("Dance for 15 mins - 5 pts");

        // BG reading on fasting within 100 10 pts
        c5.setText("BG reading on fasting within 100 - 5 pts");

        // Go for diagnostic check up - 5 pts
        c6.setText("Go for diagnostic check up - 5 pts");

        // Test your carb skills - 5 pts
        c7.setText("Test your carb skills - 5 pts");

        // Do pushups 20 times - 10 pts
        c8.setText("Do pushups 20 times - 10 pts");

        // Calorie Intake (100 cal) - 10 pts
        c9.setText("Calorie Intake (100 cal) - 10 pts");

        // Salad for lunch for today - 50 pts
        c10.setText("Salad for lunch for today - 50 pts");

        // Watch 2 diabetic videos today - 20 pts
        c11.setText("Watch 2 diabetic videos today - 20 pts");

        return myView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.saveBtn) {
            Bundle b = new Bundle();
            ArrayList<String> selection = new ArrayList<String>();
            String tasks ="";
            if (c1.isChecked())
            {
                selection.add(c1.getText().toString());
                tasks += c1.getText();
                tasks += "\n";
                //b.putInt("1", 420);
            }
            if (c2.isChecked())
            {
                tasks += c2.getText();
                tasks += "\n";
                selection.add(c2.getText().toString());
            }
            if (c3.isChecked())
            {
                tasks += c3.getText();
                tasks += "\n";
                selection.add(c3.getText().toString());
            }
            if (c4.isChecked())
            {
                tasks += c4.getText();
                tasks += "\n";
                selection.add(c4.getText().toString());
            }
            if (c5.isChecked())
            {
                tasks += c5.getText();
                tasks += "\n";
                selection.add(c5.getText().toString());
            }
            if (c6.isChecked())
            {
                tasks += c6.getText();
                tasks += "\n";
                selection.add(c6.getText().toString());
            }
            if (c7.isChecked())
            {
                tasks += c7.getText();
                tasks += "\n";
                selection.add(c7.getText().toString());
            }
            if (c8.isChecked())
            {
                tasks += c8.getText();
                tasks += "\n";
                selection.add(c8.getText().toString());
            }
            if (c9.isChecked())
            {
                tasks += c9.getText();
                tasks += "\n";
                selection.add(c9.getText().toString());
            }
            if (c10.isChecked())
            {
                tasks += c10.getText();
                tasks += "\n";
                selection.add(c10.getText().toString());
            }
            if (c11.isChecked())
            {
                tasks += c11.getText();
                tasks += "\n";
                selection.add(c11.getText().toString());
            }

            Intent helpIntent = new Intent(getActivity(), StartQuest.class);
            b.putString("selection", tasks);
            helpIntent.putExtras(b);
            this.startActivity(helpIntent);
        }
    }
}

