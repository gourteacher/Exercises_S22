package com.college.exercises_s22;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//Like an activity, but doesn't need to cover the whole screen
public class MessageListFragment extends Fragment {
    private ArrayAdapter<String> itemsAdapter;
    private OnItemSelectedListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, Message.messageList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        // Inflate the xml file for the fragment
        return inflater.inflate(R.layout.fragment_message_list, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ListView lvItems = view.findViewById(R.id.lvItems);
        lvItems.setAdapter(itemsAdapter);

        lvItems.setOnItemClickListener((parent, view1, position, id) -> {
            // go to activity to load message details fragment
            listener.onMessageItemSelected(position); // (3) Communicate with Activity using Listener
        });
    }


    // onAttach method is called when the Fragment instance is associated with an Activity.
    // This does not mean the Activity is fully initialized.
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener) {
            this.listener = (OnItemSelectedListener) context;
        }
    }


    // Define the events that the fragment will use to communicate
    public interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity
        void onMessageItemSelected(int position);
    }

}
