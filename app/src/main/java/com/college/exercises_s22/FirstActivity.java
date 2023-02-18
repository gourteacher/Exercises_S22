package com.college.exercises_s22;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";

    private ArrayList<String> elements = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Your program starts here
        super.onCreate(savedInstanceState);

        // setContentView loads objects onto the screen.
        // Before this function, the screen is empty.
        setContentView(R.layout.activity_first);

        ListView myList = findViewById(R.id.theListView);
        MyListAdapter myAdapter = new MyListAdapter();
        myList.setAdapter( myAdapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener( click -> {
            elements.add( "Another Row");
            myAdapter.notifyDataSetChanged();
        });

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                elements.remove(i);
                myAdapter.notifyDataSetChanged();
            }
        });

        myList.setOnItemLongClickListener( (p, b, pos, id) -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.ab_choice)

                    //What is the message:
                    .setMessage(R.string.ab_add_row)

                    //what the Yes button does:
                    .setPositiveButton(R.string.ab_yes, (click, arg) -> {
                        elements.add("HELLO");
                        myAdapter.notifyDataSetChanged();
                    })
                    //What the No button does:
                    .setNegativeButton(R.string.ab_no, (click, arg) -> { })

                    //An optional third button:
                    .setNeutralButton(R.string.ab_maybe, (click, arg) -> {  })

                    //You can add extra layout elements:
                    .setView(getLayoutInflater().inflate(R.layout.row_layout, null) )

                    //Show the dialog
                    .create().show();

            /*
            alertDialogBuilder.setTitle(R.string.ab_choice)
                    .setItems(R.array.array_color, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // The 'which' argument contains the index position
                            // of the selected item
                            if (which==0) {
                                b.setBackgroundColor(Color.RED);
                            } else if (which== 1) {
                                b.setBackgroundColor(Color.BLUE);
                            } else {
                                b.setBackgroundColor(Color.GREEN);
                            }
                        }
                    }).show();
                */
            return true;
        });
    }

    private class MyListAdapter extends BaseAdapter {

        public int getCount() { return elements.size();}

        public Object getItem(int position) { return "This is row " + position; }

        public long getItemId(int position) { return position; }

        public View getView(int position, View old, ViewGroup parent)
        {
            LayoutInflater inflater = getLayoutInflater();

            //make a new row:
            View newView = inflater.inflate(R.layout.row_layout, parent, false);

            //set what the text should be for this row:
            TextView tView = newView.findViewById(R.id.textGoesHere);
            tView.setText( getItem(position).toString() );

            //Button b =  newView.findViewById(R.id.textGoesHere);
            //b.setText( getItem(position).toString() );

            //return it to be put in the table
            return newView;
        }
    }
}