package cic.du.ac.in.all_about_fragments;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Scorpion on 12/28/2018.
 */

public class DescriptionFragment extends Fragment {

    private View rootView;
    private TextView textViewContent, textViewHeading;
    private String countryName;
    private String countryDescription;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.countries_description, container, false);
        initUI();
        return rootView;
    }

    private void initUI(){
        textViewContent = rootView.findViewById(R.id.content);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        countryName = bundle.getString(FragmentActionListener.KEY_SELECTED_COUNTRY,"India");
        countryDescription = getString(getStringId(countryName));
    }

    private int getStringId(String countryName){
        switch(countryName){
            case "India" :
                return R.string.India;
            case "USA" :
                return R.string.USA;
            case "Pakistan" :
                return R.string.Pakistan;
            case "Bangladesh" :
                return R.string.Bangladesh;
            case "Egypt" :
                return R.string.Egypt;
            case "Indonesia" :
                return R.string.Indonesia;
            case "UK" :
                return R.string.UK;
            case "Germany" :
                return R.string.Germany;
            default :
                return R.string.India;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(countryName);
        textViewContent.setText(countryDescription);
    }
}
