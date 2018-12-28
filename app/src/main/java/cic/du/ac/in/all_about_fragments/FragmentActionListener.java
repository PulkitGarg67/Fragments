package cic.du.ac.in.all_about_fragments;

import android.os.Bundle;

/**
 * Created by Scorpion on 12/28/2018.
 */

public interface FragmentActionListener {

    int ACTION_VALUE_COUNTRY_SELECTED = 1;
    String ACTION_KEY = "action_key";
    String KEY_SELECTED_COUNTRY="KEY_SELECTED_COUNTRY";

    void onCountrySelected(Bundle bundle);
}
