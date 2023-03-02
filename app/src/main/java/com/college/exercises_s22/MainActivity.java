package com.college.exercises_s22;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity  implements MessageListFragment.OnItemSelectedListener {

    static final String ITEM_POSITION = "position";
    private boolean isTablet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_layout);

        isTablet = findViewById(R.id.flContainer2) != null;

        if (savedInstanceState == null) {

            // Instance of first fragment
            MessageListFragment firstFragment = new MessageListFragment();

            // Add Fragment to FrameLayout (flContainer), using FragmentManager
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
            ft.setReorderingAllowed(true);
            ft.add(R.id.flContainer1, firstFragment);    // add    Fragment
            ft.commit();     // commit FragmentTransaction

            //if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (isTablet)  {
                MessageDetailFragment secondFragment = new MessageDetailFragment();
                Bundle args = new Bundle();
                args.putInt(ITEM_POSITION, 0);
                secondFragment.setArguments(args);  // Communicate with Fragment using Bundle

                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                ft2.add(R.id.flContainer2, secondFragment);
                ft2.commit();
            }
        }
    }

    @Override
    public void onMessageItemSelected(int position) {
        Toast.makeText(this, getString(R.string.toast_msg, "MessageListFragment", position), Toast.LENGTH_SHORT).show();

        // Load Detail Fragment
        MessageDetailFragment secondFragment = new MessageDetailFragment();

        Bundle args = new Bundle();
        args.putInt(ITEM_POSITION, position);
        secondFragment.setArguments(args); // (1) Communicate with Fragment using Bundle

        if (isTablet)  {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer2, secondFragment)
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer1, secondFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
