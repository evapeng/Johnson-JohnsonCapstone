package capstone.cmu.edu.landingpage;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class third_fragment extends Fragment {
    View myView;
    //Buttons for choosing the community type
    public Button but1, but2, but3;
    public void init()
    {
        but1 = (Button) myView.findViewById(R.id.bDL);
        //Upon clicking, but1 redirects the user to the internal community class - DLC.class
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dLife = new Intent(getActivity(), DLC.class);
                startActivity(dLife);


            }
        });

    }
    public void init2()
    {
        but2 = (Button) myView.findViewById(R.id.bDD);
        //Upon clicking, but2 changes the text from 'request' to 'pending' to demonstrate the closed community permission feature
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                but2.setText("Pending");

            }
        });
    }
    public void init3()
    {
        but3 = (Button) myView.findViewById(R.id.bE);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Upon clicking, but3 redirects the user to the external community on facebook
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.addCategory(Intent.CATEGORY_BROWSABLE);
                intent2.setData(Uri.parse("https://www.facebook.com/groups/400739193632535/?ref=bookmarks"));
                startActivity(intent2);

            }
        });
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.third_layout,container,false);
        getActivity().setTitle("Community");
        init();
        init2();
        init3();
        return myView;

    }
}
