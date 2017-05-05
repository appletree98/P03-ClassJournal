package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
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

        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Modules selectedModule = module.get(position);
                Intent i = new Intent(MainActivity.this,Info.class);
                i.putExtra("module","android");
                startActivity(i);
            }
        });
    }
}
