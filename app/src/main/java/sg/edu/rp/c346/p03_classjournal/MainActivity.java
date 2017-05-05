package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvModules;
    ArrayList<Modules> module;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModules = (ListView)findViewById(R.id.lvModules);

        module = new ArrayList<Modules>();
        module.add(new Modules("C347", "Android Programming II"));


        aa = new ModulesAdapter(this,R.layout.row,module);
        lvModules.setAdapter(aa);

        Intent i = new Intent(MainActivity.this,Info.class);
        i.putExtra("module","android");
        startActivity(i);
    }
}
