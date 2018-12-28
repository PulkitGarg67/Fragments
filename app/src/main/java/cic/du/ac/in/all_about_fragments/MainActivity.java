package cic.du.ac.in.all_about_fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentActionListener {

    FragmentManager fragmentManager;
    Button button;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Fragments");
        button  = findViewById(R.id.getStarted);
        if(savedInstanceState==null){
            button.setVisibility(View.VISIBLE);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addFragment();
                }
            });
        }

        fragmentManager = getSupportFragmentManager();
    }

    private void addFragment(){
        button = findViewById(R.id.getStarted);
        button.setVisibility(View.INVISIBLE);
        fragmentTransaction = fragmentManager.beginTransaction();

        DynamicFragment dynamicFragment = new DynamicFragment();
        dynamicFragment.setFragmentActionListener(this  );
        fragmentTransaction.add(R.id.fragmentContainer,dynamicFragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onCountrySelected(Bundle bundle) {
        int action = bundle.getInt(FragmentActionListener.ACTION_KEY);
        switch (action){
            case FragmentActionListener.ACTION_VALUE_COUNTRY_SELECTED : addCountryDescription(bundle);
                break;
        }
    }

    private void addCountryDescription(Bundle bundle) {
        fragmentTransaction = fragmentManager.beginTransaction();

        DescriptionFragment descriptionFragment = new DescriptionFragment();
        descriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer,descriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
