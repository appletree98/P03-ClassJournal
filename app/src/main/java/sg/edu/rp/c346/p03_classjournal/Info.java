package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Info extends AppCompatActivity {
    Button btnInfo;
    Button btnEmail;
    Button btnAdd;
    ListView lvJ;
    ArrayList<Journal> journal;
    ArrayAdapter aa;

    int weekSize;
    int requestCodeForAdd = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);///

        btnInfo = (Button) findViewById(R.id.buttonInfo);
        btnEmail = (Button) findViewById(R.id.buttonEmail);
        btnAdd = (Button)findViewById(R.id.buttonAdd);
        lvJ = (ListView)findViewById(R.id.ListViewJournal);




       journal= new ArrayList<Journal>();

        Journal obj1 = new Journal("A","C347",1);

        Journal obj2 = new Journal("B","C347",2);
        Journal obj3 = new Journal("C","C347",3);

        journal.add(obj1);
        journal.add(obj2);
        journal.add(obj3);

        aa = new JournalAdapter(Info.this, R.layout.row2, journal);
        lvJ.setAdapter(aa);
        Intent intent = getIntent();
        String moduleC = intent.getStringExtra("module");


//        Intent intent = getIntent();
//            final Journal jour = (Journal) intent.getSerializableExtra("journal");
//            journal.add(jour);
//            lvJ.setAdapter(aa);


//        lvJ.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Food selectedFood = food.get(position);
////
////                Toast.makeText(MainActivity.this, selectedFood.getName()
////                                + " Star: " + selectedFood.isStar(),
////                        Toast.LENGTH_LONG).show();
//            }
//        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // The action you want this intent to do;
                Intent email = new Intent(Intent.ACTION_SEND);
                
                String message = "";
                for(int i=0; i < journal.size(); i++) {
                    Journal currentJournal = journal.get(i);
                    message += currentJournal.getWeek() + currentJournal.getDgGrade();

                    email.putExtra(Intent.EXTRA_TEXT,
                            "Hi faci, " +
                                    "I am ..." +
                                    "Please see my remarks so far, thank you!" + message);
                }
                // ACTION_SEND is used to indicate sending text
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }});
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weekSize = journal.size() + 1;
                Intent weeks = new Intent(Info.this, AddData.class);
                weeks.putExtra("week", journal.size() + 1 + "");
                startActivityForResult(weeks, requestCodeForAdd);
            }

        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Intent intent = getIntent();
        String moduleC = intent.getStringExtra("module");

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                // Get data passed back from 2nd activity
                String grade = data.getStringExtra("grade");
                // Get data passed back from 2nd activity


                if (requestCode == requestCodeForAdd) {
                    journal.add(new Journal(grade,moduleC,weekSize));
                    aa.notifyDataSetChanged();
                }

            }
        }
    }
}