package capstone.cmu.edu.landingpage;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class EarnPoints extends Fragment implements View.OnClickListener {

    View myView;
    private Button option1Button,option2Button,option3Button,option4Button;
    int oldPoints=0;
    int exScore;

    private SharedPreferences earnPrefs;
    public static final String EARN_PREFS = "ArithmeticFile";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.activity_earn,container,false);
        getActivity().setTitle("Share and Earn");
       // earnPrefs = getSharedPreferences(EARN_PREFS, 0);
//
//        if(savedInstanceState!=null){
//            //restore state
//            oldPoints = savedInstanceState.getInt("Score");
//        }

        // Rate Us 30pts
        option1Button = (Button) myView.findViewById(R.id.r1);
        option1Button.setText("Rate Us - 30 pts");
        option1Button.setOnClickListener(this);

        // Share App & Recommend to Friends  50 pts
        option2Button = (Button) myView.findViewById(R.id.r2);
        option2Button.setText("Share App - 50 pts");
        option2Button.setOnClickListener(this);

        // Upgrade 1000pts
        option3Button = (Button) myView.findViewById(R.id.r3);
        option3Button.setText("Upgrade App - 10 pts");
        option3Button.setOnClickListener(this);

        // Add friends 5 pts
        option4Button = (Button) myView.findViewById(R.id.r4);
        option4Button.setText("Add Friends - 20 pts");
        option4Button.setOnClickListener(this);

//        MyProfile mp = ((MainActivity)getActivity()).mp;
//        //mp.setVal(oldPoints);
//        //SecondFragment f = new SecondFragment();
//        Bundle b = new Bundle();
//        b.putInt("points", 30);
//
//        Log.d("EarnPOints", String.valueOf(oldPoints));
//
//        mp.setArguments(b);

        return myView;


    }

    @Override
    public void onClick(View view) {

        //AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());


        if(view.getId()==R.id.r1){
            oldPoints = 30;

            Toast.makeText(getActivity(),
                            "Congratulations! \n 30 Points added",Toast.LENGTH_SHORT).show();
        }
        else if(view.getId()==R.id.r2){
            oldPoints = 50;
            Toast.makeText(getActivity(),
                    "Congratulations! \n 50 Points added",Toast.LENGTH_SHORT).show();
        }
        else if(view.getId()==R.id.r3){
            oldPoints = 10;
            Toast.makeText(getActivity(),
                    "Congratulations! \n 10 Points added",Toast.LENGTH_SHORT).show();
        }
        else if(view.getId()==R.id.r4){
            oldPoints = 20;
            Toast.makeText(getActivity(),
                    "Congratulations! \n 20 Points added",Toast.LENGTH_SHORT).show();
        }

        MyProfile mp = ((MainActivity)getActivity()).mp;

        Bundle b = new Bundle();
        b.putInt("points", oldPoints);


        mp.setArguments(b);

    }


}
