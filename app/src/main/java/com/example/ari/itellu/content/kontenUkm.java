package com.example.ari.itellu.content;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

import com.example.ari.itellu.DetailActivity;

public class kontenUkm {

    private String Name;
    private String Deskripsi;
    private int Photo;


    public kontenUkm() {

    }

    public kontenUkm(String name, String deskripsi, int photo) {
        Name = name;
        Deskripsi = deskripsi;
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

}
