package com.example.momenali.custompreference;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.widget.SeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Momen Ali on 3/17/2018.
 */

public class SettingFragment extends PreferenceFragmentCompat {

/*    public static int  presentValue;
    @BindView(R.id.seekbar)
    SeekBar seekbar;*/

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preference_xml);
      /*  ButterKnife.bind(this,getActivity());
        seekbar.setProgress(presentValue);*/
    }
}
