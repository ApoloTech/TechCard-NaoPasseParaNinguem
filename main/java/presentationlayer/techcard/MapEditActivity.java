package presentationlayer.techcard;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapEditActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Location Location;
    private LocationManager LocationManager;

    private Address address;

    private double latitude = 0.0;
    private double longitude = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_edit);

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            AlertDialog alert;
            alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Não se esconda de mim!");
            alert.setMessage("Ative suas opções de localização caso queira que eu te encontre!");
            alert.show();
        }else{
            LocationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            Location = LocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }

        if(Location != null){
            latitude = Location.getLatitude();
            longitude = Location.getLongitude();
            System.out.println("LAT:" + latitude + "    " + "LONG:" + longitude);
        }


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
    }

    public void SearchAddress(View v) throws IOException{
        final EditText input = new EditText(this);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(input)
                .setPositiveButton("Ir", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try{
                            String localName = input.getText().toString();
                            Geocoder geocoder;
                            Address address = null;
                            List<Address> addresses;

                            geocoder = new Geocoder(getApplicationContext());
                            addresses = geocoder.getFromLocationName(localName,1);
                            if(addresses.size() > 0) {
                                address = addresses.get(0);
                                double latitude = address.getLatitude();
                                double longitude = address.getLongitude();

                                LatLng pos = new LatLng(latitude, longitude);
                                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 15);
                                mMap.moveCamera(update);
                            }
                        }catch (Exception e){
                            Toast toast = Toast.makeText(MapEditActivity.this, "Não foi possível buscar local, tente novamente mais tarde", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                });
        builder.setNegativeButton("Cancelar", null);
        AlertDialog alert = builder.create();
        alert.setTitle("Digite uma cidade, estado, país, rua, etc.");
        alert.show();
    }

    public void newMarker(View v){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .title("Posso colocar qualquer coisa aqui"));

        LatLng pos = new LatLng(latitude, longitude);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 15);
        mMap.moveCamera(update);
        //todo modificar marcadores cor, icone.
        }

    public void ZoomIn(View v){
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
    }

    public void ZoomOut(View v){
        mMap.animateCamera(CameraUpdateFactory.zoomOut());
    }


    public void MoveCamera(long lat, long lng){
        LatLng pos = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 15);
        mMap.moveCamera(update);
    }

    public void OpenMap(View v) {
        Intent it = new Intent(this, MyMapActivity.class);
        startActivity(it);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Menu_Settings) {
            return true;
        } else if (id == R.id.Menu_Exit) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Exit(){
        //TODO fazer saída do APP.
    }

    public void Settings(){
        //TODO fazer menu de troca de informações pessoais.
    }

}
