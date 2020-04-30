package com.example.lbsmodul5;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        // Add a marker in Sydney and move the camera
        LatLng telkom = new LatLng(-7.1524416, 111.8819376);
        mMap.addMarker(new MarkerOptions().position(telkom).title("Rumah Saya"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(telkom,15));

        LatLng sd_kadipaten = new LatLng(-7.1525455, 111.8860213);
        mMap.addMarker(new MarkerOptions().position(sd_kadipaten).title("SDN Kadipaten 1 Bojonegoro"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sd_kadipaten,15));

        mMap.addPolyline(new PolylineOptions().add(
            telkom,
                new LatLng(-7.1523623,111.8828169),
                new LatLng(-7.1525099,111.8860206),
                new LatLng(-7.152391,111.8818316),
             sd_kadipaten
            ).width(10).color(Color.BLUE)
        );

    }
}
