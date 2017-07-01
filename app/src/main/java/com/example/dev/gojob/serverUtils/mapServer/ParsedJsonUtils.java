package com.example.dev.gojob.serverUtils.mapServer;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.dev.gojob.maps.MapsActivity;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



/**
 * Created by dev on 07.06.17.
 */

public class ParsedJsonUtils implements OnLoadComplite{

    private static ParsedJsonUtils parsedJsonUtils;
    private static ArrayList<String> nameAgency;
    private static ArrayList<String> priceAgency;
    private static ArrayList<String> phoneAgency;
    private static ArrayList<String> addressAgency;
    private static ArrayList<String> schrduleAgency;
//    private ArrayList<Double> latitudeAgency;
//    private ArrayList<Double> longitudeAgency;
    private ArrayList<LatLng> latlngAgency;
    private static ArrayList<String> requisitesAgency;
    private static ArrayList<String> creditCardAgency;

    private static Context mContext;

    private ParsedJsonUtils(){
        nameAgency = new ArrayList<>();
        priceAgency = new ArrayList<>();
        phoneAgency = new ArrayList<>();
        addressAgency = new ArrayList<>();
        schrduleAgency = new ArrayList<>();
        latlngAgency = new ArrayList<>();
//        latitudeAgency = new ArrayList<>();
//        longitudeAgency = new ArrayList<>();
        requisitesAgency = new ArrayList<>();
        creditCardAgency = new ArrayList<>();
        ServerUtils myAsyncTask  = new ServerUtils();
        myAsyncTask.setOnLoadComplite(this);
        myAsyncTask.getAllData();

        Log.e("@@@@@@", "ParsedJsonUtils: " + myAsyncTask.toString());

    }

    public static ParsedJsonUtils getInstance(Context context) {
        if (parsedJsonUtils == null){
            parsedJsonUtils = new ParsedJsonUtils();
        }
        mContext = context;
        return parsedJsonUtils;
    }


    @Override
    public void onLoadComplite(final String json) {

        ((MapsActivity)mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (json.isEmpty()){

                    Toast.makeText(mContext, "Load data error", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(mContext, "Data were load seccessfuly", Toast.LENGTH_SHORT).show();



                JSONObject dataJsonObj = null;

                try {
                    dataJsonObj = new JSONObject(json);
                    JSONArray agencies = dataJsonObj.getJSONArray("agencies");

                    // 2. перебираем и выводим необходимые данные
                    for (int i = 0; i < agencies.length(); i++) {
                        JSONObject agent = agencies.getJSONObject(i);

                        nameAgency.add(agent.getString("name"));
                        priceAgency.add(agent.getString("price"));
                        phoneAgency.add(agent.getString("phone"));
                        addressAgency.add(agent.getString("address"));
                        schrduleAgency.add(agent.getString("schrdule"));
                        Log.d("@@@@",agent.getString("latitude")+" hgddighkdgy");
                        if (agent.getString("latitude").equals("null") & agent.getString("longitude").equals("null")) {
                            Log.d("@@@@",agent.getString("latitude")+"in if");

                        }
                        else {
                            Log.d("@@@@",agent.getString("latitude")+" : in else if");
                            double lat = Double.parseDouble(agent.getString("latitude").toString());
                            double lng = Double.parseDouble(agent.getString("longitude").toString());

                            LatLng position = new LatLng(lat, lng);
                            latlngAgency.add(position);
                        }
//                        latitudeAgency.add(Double.parseDouble(agent.getString("latitude")));
//                        longitudeAgency.add(Double.parseDouble(agent.getString("longitude")));
                        requisitesAgency.add(agent.getString("requisites"));
                        creditCardAgency.add(agent.getString("credit_card"));
                    }
                    Log.e("###", "onLoadComplite: "+nameAgency.size());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });




    }


    public static ArrayList<String> getNameAgencies(){
        return nameAgency;
    }

    //        price
    public static ArrayList<String> getPriceAgencies() {
        return priceAgency;
    }

    //        phone
    public static ArrayList<String> getPhoneAgencies() {
        return phoneAgency;
    }

    //        address
    public static ArrayList<String> getAddressAgencies() {
        return addressAgency;
    }

    //        schrdule
    public static ArrayList<String> getSchrduleAgencies() {
        return schrduleAgency;
    }

    public ArrayList<LatLng> getLatlngAgency(){
        return latlngAgency;
    }

//    //        latitude
//    public ArrayList<Double> getLatitudeAgencies() {
//        return latitudeAgency;
//    }
//
//    //        longitude
//    public ArrayList<Double> getLongitudeAgencies() {
//        return longitudeAgency;
//    }

    //        requisites
    public static ArrayList<String> getRequisitesAgencies() {
        return requisitesAgency;
    }

    //        credit_card
    public static ArrayList<String> getCreditCardAgencies() {
        return creditCardAgency;
    }



}
