package capstone.cmu.edu.landingpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class JournalEntry extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_entry);
        Button one = (Button) findViewById(R.id.journal_log);
        one.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Calendar c = Calendar.getInstance();
        //j.addDate(c);
        //homeActivity.record.add(j);
        RadioGroup t = (RadioGroup) findViewById(R.id.tiredGroup);
        RadioGroup s = (RadioGroup) findViewById(R.id.stressedGroup);
        EditText b = (EditText) findViewById(R.id.reading);
        EditText ca = (EditText) findViewById(R.id.carbs);

        if (t.getCheckedRadioButtonId() == -1 || s.getCheckedRadioButtonId() == -1
                || (b.getText().toString().equals("")) || (ca.getText().toString().equals(""))){
            Toast.makeText(this, "Please finish entering the information" , Toast.LENGTH_SHORT).show();
            return;
        }

        int tselectedId = t.getCheckedRadioButtonId();
        int sselectedId = s.getCheckedRadioButtonId();

        int tired = 0;
        int stressed = 0;

        RadioButton tbutton = (RadioButton) findViewById(tselectedId);
        RadioButton sbutton = (RadioButton) findViewById(sselectedId);


        switch (tbutton.getId()){
            case R.id.tired1:
                tired = 1;
                break;
            case R.id.tired2:
                tired = 2;
                break;
            case R.id.tired3:
                tired = 3;
                break;
            case R.id.tired4:
                tired = 4;
                break;
        }

        switch (sbutton.getId()){
            case R.id.stress1:
                stressed = 0;
                break;
            case R.id.stress2:
                stressed = 1;
                break;
            case R.id.stress3:
                stressed = 2;
                break;
            case R.id.stress4:
                stressed = 3;
                break;
        }


        Log.v("JOURNAL","here");
        Journal jj = new Journal();
        Journal.addEntry(Integer.valueOf(b.getText().toString()),Integer.valueOf(ca.getText().toString()),tired,stressed);
        finish();



    };

}
