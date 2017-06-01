package capstone.cmu.edu.landingpage;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TriviaActivityLevels extends Fragment implements View.OnClickListener {
    private Button level1Button;
    View myView;


    /*
    This method displays the levels for the user to select and then display the trivia questions
     */
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.second_layout, container, false);
        getActivity().setTitle("Trivia");
        // super.onCreate(savedInstanceState);


        level1Button = (Button) myView.findViewById(R.id.level1);
        //   level1Button.setOnClickListener(this);
        level1Button.setOnClickListener(this);
        return myView;
    }

    /*
 Based on the level chosen by the user, the questions and options will be displayed
 */
    public void onClick(View view) {
        if (view.getId() == R.id.level1) {

            Intent highIntent = new Intent(getActivity(), TriviaActivity.class);
            this.startActivity(highIntent);

        }

        //This bit of the code can be implemented to extend the trivia so that the next level of questions
        //can be designed for the higher levels


        //    else if (view.getId() == R.id.level2) {
        //      Intent highIntent = new Intent(this, TriviaActivity.class);
        //    this.startActivity(highIntent);
        //}
        //  else if (view.getId() == R.id.level3) {
        //    Intent highIntent = new Intent(this, TriviaActivity.class);
        //  this.startActivity(highIntent);
        //}
    }
}



