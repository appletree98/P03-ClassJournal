package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddData extends AppCompatActivity {

    Button btnSubmit;
    RadioGroup rgGrade;
    TextView tvWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_data);

        btnSubmit = (Button)findViewById(R.id.buttonSubmit);
        rgGrade = (RadioGroup)findViewById(R.id.radiogroupGrade);
        tvWeek = (TextView)findViewById(R.id.textViewWeek);

        Intent intentReceived = getIntent();
        String weeks = intentReceived.getStringExtra("week");
        tvWeek.setText("Week " + weeks);





        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rgGrade.getCheckedRadioButtonId();
                RadioButton rbGrade = (RadioButton) findViewById(selectedButtonId);
                String grade = rbGrade.getText().toString();

                Intent i = new Intent();
                i.putExtra("grade", grade);
                setResult(RESULT_OK, i);
                finish();

            }
        });






    }

}
