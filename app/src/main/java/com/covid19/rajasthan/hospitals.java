package com.covid19.rajasthan;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class hospitals extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng latLng;
    private FusedLocationProviderClient fusedLocationClient;
    LocationRequest mLocationRequest;
    Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(180000);
        mLocationRequest.setFastestInterval(90000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        fusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
        mMap.setMyLocationEnabled(true);

        // Test Center 1
        final LatLng center1 = new LatLng(26.741301, 74.613675);
        mMap.addMarker(new MarkerOptions().position(center1).title("JLN Medical College").snippet("website: https://education.rajasthan.gov.in/jlnmcajmer"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center1));

        //Test Center 2
        final LatLng center2 = new LatLng(27.331818, 75.907692);
        mMap.addMarker(new MarkerOptions().position(center2).title("Dr. B. Lal Clinical Laboratory Pvt. Ltd.").snippet("website: https://www.blallab.com/"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center2));

        //Test Center 3
        final LatLng center3 = new LatLng(27.221000, 75.797835);
        mMap.addMarker(new MarkerOptions().position(center3).title("Krsnaa Diagnostics Pvt Ltd National institute of Ayurveda"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center3));

        //Test Center 4
        final LatLng center4 = new LatLng(26.893535, 75.812483);
        mMap.addMarker(new MarkerOptions().position(center4).title("Brig T.K. Narayanan Dept of Pathology").snippet("website: http://www.sdmh.in/departments/pathology-transfusion-medicine"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center4));

        //Test Center 5
        final LatLng center5 = new LatLng(27.214396, 75.885719);
        mMap.addMarker(new MarkerOptions().position(center5).title("Rajasthan University of Health Sciences").snippet("website: http://www.ruhsraj.org/"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center5));

        //Test Center 6
        final LatLng center6 = new LatLng(27.253712, 75.841774);
        mMap.addMarker(new MarkerOptions().position(center6).title("JNU Institute Of Medical Sciences And Research Centre").snippet("website: https://www.jnujaipur.ac.in/schools/institute-for-medical-sciences-and-research-centre/"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center6));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center6));

        //Test Center 7
        final LatLng center7 = new LatLng(27.369409, 75.885724);
        mMap.addMarker(new MarkerOptions().position(center7).title("SMS Medical College").snippet("website: https://education.rajasthan.gov.in/smsmcjaipur"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center7));

        //Test Center 8
        final LatLng center8 = new LatLng(27.077530, 75.863746);
        mMap.addMarker(new MarkerOptions().position(center8).title("Central Lab, The Mahatma Gandhi University of Medical Sciences and Technology").snippet("website: https://mgumst.org/contact-us.php"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center8));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if(marker.getPosition().equals(center1)) {
                    Uri uriUrl = Uri.parse("https://education.rajasthan.gov.in/jlnmcajmer");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center2)) {
                    Uri uriUrl = Uri.parse("https://www.blallab.com/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }

                else if(marker.getPosition().equals(center4)) {
                    Uri uriUrl = Uri.parse("http://www.sdmh.in/departments/pathology-transfusion-medicine");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center5)) {
                    Uri uriUrl = Uri.parse("http://www.ruhsraj.org/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center6)) {
                    Uri uriUrl = Uri.parse("https://www.jnujaipur.ac.in/schools/institute-for-medical-sciences-and-research-centre/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center7)) {
                    Uri uriUrl = Uri.parse("https://education.rajasthan.gov.in/smsmcjaipur");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center8)) {
                    Uri uriUrl = Uri.parse("https://mgumst.org/contact-us.php");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            }
        });

    }

    LocationCallback mLocationCallback=new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for(Location location1 : locationResult.getLocations()) {
                if (getApplicationContext() != null) {
                    mLastLocation = location1;
                    latLng = new LatLng(location1.getLatitude(), location1.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(7));
                }
            }

        }
    };
    public void onBackPressed(){
        Intent intent = new Intent(hospitals.this, home.class);
        startActivity(intent);
        finish();
    }
}
