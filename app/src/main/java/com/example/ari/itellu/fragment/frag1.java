package com.example.ari.itellu.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ari.itellu.R;
import com.example.ari.itellu.adapter.RecyclerAdapter;
import com.example.ari.itellu.content.kontenUkm;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class frag1 extends Fragment {
    private RecyclerView myrecycler;
    private List<kontenUkm> konten1;
    View v;


    public frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_frag1, container, false);

        //referensi recylerview yang ada pada fragment1
        myrecycler = (RecyclerView) v.findViewById(R.id.rcukm);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getContext(), konten1);

        myrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycler.setAdapter(recyclerAdapter);
        // Inflate the layout for this fragment
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        konten1 = new ArrayList<>();
        konten1.add(new kontenUkm("UKM Aksara", "deskripsi UKM Aksara", R.drawable.aksara));
        konten1.add(new kontenUkm("UKM Band", "deskripsi UKM Band", R.drawable.band));
        konten1.add(new kontenUkm("UKM Basket", "deskripsi UKM Basket", R.drawable.basket));
        konten1.add(new kontenUkm("UKM Bola", "deskripsi UKM Bola", R.drawable.bola));
        konten1.add(new kontenUkm("UKM GHOST", "deskripsi UKM GHOST", R.drawable.ghostttt));
        konten1.add(new kontenUkm("UKM KOPMA", "deskripsi UKM KOPMA", R.drawable.logokopma));
        konten1.add(new kontenUkm("UKM SEARCH", "deskripsi UKM SEARCH", R.drawable.search));

    }
}
