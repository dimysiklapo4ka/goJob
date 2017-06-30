package com.example.dev.gojob.maps;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev.gojob.serverUtils.mapServer.ParsedJsonUtils;
import com.example.dev.gojob.vacancy.activity.ValidVacancyActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import com.example.dev.gojob.R;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnInfoWindowLongClickListener,
        GoogleMap.OnInfoWindowCloseListener{

    private ParsedJsonUtils parsedJsonUtils = ParsedJsonUtils.getInstance(this);

//    private static final LatLng KFS = new LatLng(52.23064054639962, 21.016936227679253);
    private static final LatLng POLAND = new LatLng(52.230138870094514, 21.011593267321587);

    class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        // These are both viewgroups containing an ImageView with id "badge" and two TextViews with id
        // "title" and "snippet".
        private final View mWindow;

        CustomInfoWindowAdapter() {
            mWindow = getLayoutInflater().inflate(R.layout.custom_info_window, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {

            render(marker, mWindow);
            return mWindow;
        }

        @Override
        public View getInfoContents(Marker marker) {
            render(marker,mWindow);
            return mWindow;
        }

        private void render(Marker marker, View view) {

            String title = marker.getTitle();
            TextView titleUi = ((TextView) view.findViewById(R.id.title));
            if (title != null) {
                // Spannable string allows us to edit the formatting of the text.
                SpannableString titleText = new SpannableString(title);
                titleText.setSpan(new ForegroundColorSpan(Color.RED), 0, titleText.length(), 0);
                titleUi.setText(titleText);
            } else {
                titleUi.setText("");
            }

            String snippet = marker.getSnippet();
            TextView snippetUi = ((TextView) view.findViewById(R.id.price));
            if (snippet != null /**&& snippet.length() > 3*/) {
//                SpannableString snippetText = new SpannableString(snippet);
//                snippetText.setSpan(new ForegroundColorSpan(Color.MAGENTA), 0, 10, 0);
//                snippetText.setSpan(new ForegroundColorSpan(Color.BLUE), 12, snippet.length(), 0);
                snippetUi.setText(snippet);

            } else {
                snippetUi.setText("");
            }
        }
    }

    private GoogleMap mMap;

//    private Marker mKFS;
    private Marker mPoland;
    ArrayList<LatLng> markerLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        markerLatLng = parsedJsonUtils.getLatlngAgency();

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

        // Add lots of markers to the map.
        addMarkersToMap();

        // Setting an info window adapter allows us to change the both the contents and look of the
        // info window.
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());

        // Set listeners for marker events.  See the bottom of this class for their behavior.
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnMarkerDragListener(this);
        mMap.setOnInfoWindowCloseListener(this);
        mMap.setOnInfoWindowLongClickListener(this);

        // Override the default content description on the view, for accessibility mode.
        // Ideally this string would be localised.
        mMap.setContentDescription("Map with lots of markers.");

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(POLAND)
                .zoom(10)
                .bearing(45)
                .tilt(20).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        mMap.animateCamera(cameraUpdate);
        // mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));

    }


    private void addMarkersToMap() {
        // Uses a colored icon.
        for (int i = 0; i < markerLatLng.size(); i++) {
            if (markerLatLng.get(i) != null) {
                mMap.addMarker(new MarkerOptions()
                        .position(markerLatLng.get(i))
                        .title(ParsedJsonUtils.getNameAgencies().get(i))
                        .snippet("Price: "+ParsedJsonUtils.getPriceAgencies().get(i))
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

                Log.d("@@@@@", "marker " + i + "add");
            }
        }

        //add latlng User
        mPoland = mMap.addMarker(new MarkerOptions()
                .position(POLAND)
                .title("Poland")
                .snippet("Work in poland"));

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        Toast.makeText(this, "Click Info Window", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MapsActivity.this, ValidVacancyActivity.class);
        startActivity(intent);
    }

    @Override
    public void onInfoWindowClose(Marker marker) {

    }

    @Override
    public void onInfoWindowLongClick(Marker marker) {

        Toast.makeText(this, "Info Window long click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(this, marker.getTitle() + " click to marker ",
                Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
}