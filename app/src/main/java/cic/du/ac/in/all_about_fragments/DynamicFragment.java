package cic.du.ac.in.all_about_fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Scorpion on 12/27/2018.
 */

public class DynamicFragment extends Fragment {

    View rootview;
    ListView listView;
    String [] countries_list;
    ArrayAdapter<String> adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_dynamic,container,false);
        fireUpList();
        return rootview;
    }

    private void fireUpList() {
        Context context = getContext();

        // Setting listview
        countries_list = getResources().getStringArray(R.array.countries_list);
        listView = rootview.findViewById(R.id.countries);
        adapter = new ArrayAdapter<String>(context,R.layout.design_list,countries_list);
        listView.setAdapter(adapter);

    }
}
