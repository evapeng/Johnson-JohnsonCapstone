package capstone.cmu.edu.landingpage;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {

    private final Context context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final String[] profession;
    private final String[] rank;

    public CustomListAdapter(Context context, String[] itemname, Integer[] imgid, String[] rank, String[] profession) {
        super(context, R.layout.activity_list, itemname);
        // ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, blogPostTitles)
        //super(context, R.layout.activity_list, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.profession=profession;
        this.rank=rank;
    }

   /* public View getView(int position,View view,ViewGroup parent) {
       // View row = view;

        //Context con= view.getContext();

        LayoutInflater inflater = view.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_list, parent,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView txtRank = (TextView) rowView.findViewById(R.id.ranking);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position] );
        txtRank.setText(rank[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText(profession[position]);
        return rowView;

    }*/
}