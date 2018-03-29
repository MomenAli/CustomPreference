package com.example.momenali.custompreference;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * Created by Momen Ali on 3/19/2018.
 */

public class SeekbarPreference extends Preference  {

    private static final String TAG = "SeekbarPreference";

    int presentValue;


    public SeekbarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.seekbar_preferences);

    }

    
    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        super.onSetInitialValue(restorePersistedValue, defaultValue);
        if (restorePersistedValue){
            presentValue = getPersistedInt(0);
            Log.d(TAG, "SeekbarPreference: "+getPersistedInt(0));
        }else{
            presentValue = 5;
        }

    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        Log.d(TAG, "onBindViewHolder: ");
        super.onBindViewHolder(holder);
        holder.itemView.setClickable(false);
        SeekBar seekBar = (SeekBar) holder.findViewById(R.id.seekbar);

        seekBar.setProgress(presentValue);

        final TextView tvSummary = (TextView) holder.findViewById(R.id.tvNumber);
        tvSummary.setText(String.valueOf(presentValue));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSummary.setText(String.valueOf(progress));
                Log.d(TAG, "onProgressChanged: ");
                persistInt(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch: ");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch: ");

            }
        });

    }
}
