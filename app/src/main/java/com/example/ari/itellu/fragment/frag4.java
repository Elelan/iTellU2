package com.example.ari.itellu.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ari.itellu.MapsActivity;
import com.example.ari.itellu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class frag4 extends Fragment {
    ImageView img;
    Button btnMap;
    View v;
    Activity act;


    public frag4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_frag4, container, false);

        return v;

    }

    @Override
    public void onStart() {
        super.onStart();
        img = (ImageView) v.findViewById(R.id.map);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MapsActivity.class);
                getActivity().startActivity(i);
            }
        });
    }
}
