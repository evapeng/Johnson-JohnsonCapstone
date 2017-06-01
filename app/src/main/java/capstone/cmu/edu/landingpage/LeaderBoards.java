package capstone.cmu.edu.landingpage;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.widget.SimpleAdapter;

/*
 This class contains the working code for LeaderBoards where all the top scorer's and maximum badge owner's
 info is displayed with a photo, their rank and their respective profession.
/*
Class LeaderBoard contains the information about the users who has been ranked
the top among all players based on points they have scored
and number of badges they have earned.
 */
public class LeaderBoards extends Fragment {

    // User's names are hardcoded for now.
    String[] itemname ={
            "Nina Alcov",
            "flora Smith",
            "Lara Kell",
            "Frodo Gabriel",
            "Amber Nicole"
    };

    Integer[] imgid={
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5
    };

    // User's ranks
    String[] rank={
            "Rank 1",
            "Rank 2",
            "Rank 3",
            "Rank 4",
            "Rank 5"
    };

    // User's profession
    String[] profession={
            "Investment Banker",
            "Teacher",
            "Entrepreneur",
            "Doctor",
            "Engineer"
    };

    @Nullable
    @Override
    // This fragment will display all the rank holders with their ranking info, profile picture, and their profession.
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View myView=inflater.inflate(R.layout.activity_leaderboard,container,false);
        getActivity().setTitle("Leaderboard");

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        // Attaching the name, rank , profession and image with each rank holder.
        for(int i=0;i<5;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("name", itemname[i]);
            hm.put("rank",rank[i]);
            hm.put("profession", profession[i]);
            hm.put("img", Integer.toString(imgid[i]));
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "name","rank","profession","img" };

        // Ids of views in listview_layout
        int[] to = { R.id.item,R.id.ranking,R.id.textView1, R.id.icon};

        // Adapter to lay out the complete hasmap on the ListView.
        SimpleAdapter adapter = new SimpleAdapter(myView.getContext(), aList, R.layout.activity_list, from, to);
        ListView list1=(ListView)myView.findViewById(R.id.list);
        list1.setAdapter(adapter);

        return myView;
    }


}


