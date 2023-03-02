package com.college.exercises_s22;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MessageDetailFragment extends Fragment {
    private int position;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            // Get back arguments
            if(getArguments() != null) {
                position = getArguments().getInt(MainActivity.ITEM_POSITION, 0);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        // Inflate the xml file for the fragment
        return inflater.inflate(R.layout.fragment_message_detail, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {;
        // Set values for view here
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvDetails =  view.findViewById(R.id.tvDetails);

        // update view
        tvTitle.setText(Message.messageList[position]);
        tvDetails.setText(Message.messageDetails[position]);
    }
}
