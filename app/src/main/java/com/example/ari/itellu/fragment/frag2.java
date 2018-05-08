package com.example.ari.itellu.fragment;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ari.itellu.R;


import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class frag2 extends Fragment {
    TextView txtDays, txtLong;
    View v;


    public frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_frag2, container, false);

        txtDays = (TextView) v.findViewById(R.id.txtDayremain);
        txtLong = (TextView) v.findViewById(R.id.txtLong);

        startTime();
        return v;
    }

    private void startTime() {
        long difference = getRemainDays();
        new CountDownTimer(difference,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                int days = (int) (millisUntilFinished/(1000*60*60*24));
                int hours = (int)((millisUntilFinished/(1000*60*60))%24);
                int mins = (int)(millisUntilFinished/(1000*60)%60);
                int sec = (int) (millisUntilFinished/(1000)%60);

                txtDays.setText(String.format("%d",days));
                txtLong.setText(String.format("%d DAYS %d:%d:%d",days,hours,mins,sec));
            }

            public void onFinish(){

            }
        }.start();
    }

    private long getRemainDays() {
        Date currentDate = new Date();
        Date endDate;
        if (currentDate.getMonth() <= 5){
            endDate = new Date(currentDate.getYear(),7,10);
        } else {
            endDate = new Date(currentDate.getYear()+1,7,10);
        }
        return endDate.getTime() - currentDate.getTime();
    }
}
