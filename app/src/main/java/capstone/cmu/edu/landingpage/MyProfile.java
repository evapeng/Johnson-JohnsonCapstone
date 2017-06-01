package capstone.cmu.edu.landingpage;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfile extends Fragment {

    View myView;
    int points = 0;
    // Dummy Rank
    int rank = 238;
    // Dummy level
    int level = 17;
    //Dummy games won
    int won = 15;

    @Nullable
    @Override
    // This method displays the users personal info, their points scored, number of games won,
    // their profile picture, the levels they have completed, their rank, the badges they have won,
    // and the trophies they have won.
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.activity_myprofile,container,false);
        getActivity().setTitle("Profile");

        Log.d("MyProfile", "Inside Oncreate View");
        Bundle args = getArguments();
        if(args != null){
            int new_points = args.getInt("points",0);
            args.putInt("points",0);
            points += new_points;
        }

        // Total points earned
        TextView textView3 = (TextView) myView.findViewById(R.id.pts_val);
        textView3.setText(String.valueOf(points));

        // Profile photo with dummy name
        ImageView imgView = (ImageView) myView.findViewById(R.id.profile_image);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.user3);
        RoundedBitmapDrawable rBD = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        rBD.setCircular(true);
        imgView.setImageDrawable(rBD);

        ImageView imgView1 = (ImageView) myView.findViewById(R.id.badge);
        ImageView imgView2 = (ImageView) myView.findViewById(R.id.badge);
        ImageView imgView3 = (ImageView) myView.findViewById(R.id.badge);
        ImageView imgView4 = (ImageView) myView.findViewById(R.id.badge);

        if(points>=1 && points<=10){
            // If my points is in between 1-10 then assign Beginners badge
            imgView1.setImageResource(R.drawable.beg);
        }
        else if(points>=11 && points<=30){
            // If my points is in between 11-30 then assign Intermediate badge
            imgView2.setImageResource(R.drawable.beg);
        }
        else if(points>=31 && points<=50){
            // If my points is in between 31-50 then assign Advanced badge
            imgView3.setImageResource(R.drawable.beg);
        }
        else if(points>=51 && points<=70){
            // If my points is in between 51-70 then assign Expert badge
            imgView4.setImageResource(R.drawable.beg);
        }

        ImageView imgView5 = (ImageView) myView.findViewById(R.id.trophy);
        ImageView imgView6 = (ImageView) myView.findViewById(R.id.trophy);
        ImageView imgView7 = (ImageView) myView.findViewById(R.id.trophy);
        ImageView imgView8 = (ImageView) myView.findViewById(R.id.trophy);

        if(level>=1 && level<=5){
            // If my level is in between 1-5 then assign babywalker trophy
            imgView5.setImageResource(R.drawable.quick);
        }
        else if(level>=6 && level<=10){
            // If my level is in between 6-10 then assign Quick learner trophy
            imgView6.setImageResource(R.drawable.quick);
        }
        else if(level>=11 && level<=20){
            // If my level is in between 11-20 then assign Road Runner trophy
            imgView7.setImageResource(R.drawable.quick);
        }
        else if(level>=21 && level<=30){
            // If my level is in between 21-30 then assign Fasttracker trophy
            imgView8.setImageResource(R.drawable.quick);
        }

        // Total Games Won
        TextView textView1 = (TextView) myView.findViewById(R.id.won_val);
        textView1.setText(String.valueOf(won));

        // Your overall rank
        TextView textView2 = (TextView) myView.findViewById(R.id.rank_val);
        textView2.setText(String.valueOf(rank));

        // Levels completed
        TextView textView6 = (TextView) myView.findViewById(R.id.level_val);
        textView6.setText(String.valueOf(level));

        // TextView showing the kind of badge you have won.
        TextView textView4 = (TextView) myView.findViewById(R.id.textView8);
        textView4.setText("Beginner Badge");

        // TextView showing the trophy you have won
        TextView textView5 = (TextView) myView.findViewById(R.id.textView9);
        textView5.setText("Quick Learner");

        return myView;
    }

}