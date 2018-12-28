package cic.du.ac.in.all_about_fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentActionListener {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button  = findViewById(R.id.getStarted);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });

        getSupportActionBar().setTitle("Fragments");
    }

    private void addFragment(){
        button = findViewById(R.id.getStarted);
        button.setVisibility(View.INVISIBLE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DynamicFragment dynamicFragment = new DynamicFragment();
        dynamicFragment.setFragmentActionListener(this);
        fragmentTransaction.add(R.id.fragmentContainer,dynamicFragment);
        fragmentTransaction.addToBackStack("Counries_Fragment");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        button = findViewById(R.id.getStarted);
        button.setVisibility(View.VISIBLE);
        super.onBackPressed();
    }

    @Override
    public void onCountrySelected(String country) {
        Toast.makeText(this, "Country Selected - "+ country, Toast.LENGTH_SHORT).show();
    }
}
