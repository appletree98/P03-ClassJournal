package sg.edu.rp.c346.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017519 on 5/5/2017.
 */

public class JournalAdapter  extends ArrayAdapter<Journal> {


    private ArrayList<Journal> journal;
    private Context context;
    private TextView tvGrade,tvWeek;
    private ImageView iv;

    public JournalAdapter(Context context, int resource, ArrayList<Journal> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        journal = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row2, parent, false);

        // Get the TextView object
        tvWeek = (TextView) rowView.findViewById(R.id.textViewWeek);
        tvGrade = (TextView)rowView.findViewById(R.id.textViewGrade);
        // Get the ImageView object
        iv = (ImageView) rowView.findViewById(R.id.imageView);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Journal current = journal.get(position);
        // Set the TextView to show the food
        tvWeek.setText("Week " + current.getWeek());
        tvGrade.setText(current.getDgGrade());
        // Set the image to star or nostar accordingly
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
