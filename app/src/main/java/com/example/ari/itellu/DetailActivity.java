package com.example.ari.itellu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;


public class DetailActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener{

    TextView tv_name;
    TextView tv_desk;
    ImageView img;

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    private static final String TAG = "DetailActivity";


    private SharedPreferences mSharedPreferences;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Menginisialisasi segala item pada layout
        tv_name = (TextView) findViewById(R.id.name_ukm);
        img = (ImageView) findViewById(R.id.img_ukm);
        tv_desk = (TextView) findViewById(R.id.deskripsiukm);

        //menerima data yang di passing
        Intent i = this.getIntent();
        String nama = i.getExtras().getString("NAME_KEY");
        String deskrip = i.getExtras().getString("DESK_KEY");
        int photo = i.getExtras().getInt("PHOTO_KEY");

        //mengambil data yang dipassing dari aktivitas
        tv_name.setText(nama);
        tv_desk.setText(deskrip);
        img.setImageResource(photo);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API)
                .build();
    }
}
