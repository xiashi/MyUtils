package along.com.library;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

import along.com.library.callback.ICallback;
import along.com.library.entity.LocationBean;

public class LocationUtil {
    private static String TAG = "LocationUtil";
    private static Context mContext;

    public static void getLocation(Context context, final ICallback<LocationBean> callback) {
        mContext = context;
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (callback != null) {
                callback.onError(new Throwable("no permission"));
            }
            return;
        }
        String mLocationProvider;
        final LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager == null) {
            if (callback != null) {
                callback.onError(new Throwable("locationManager null"));
            }
            return;
        }
        //获取所有可用的位置提供器
        List<String> providers = locationManager.getProviders(true);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
//                updateLocation(location, callback);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (providers == null || providers.isEmpty()) {
            if (callback != null) {
                callback.onError(new Throwable("providers null"));
            }
            return;
        }
        if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, locationListener, null);
            mLocationProvider = LocationManager.NETWORK_PROVIDER;
        } else if (providers.contains(LocationManager.GPS_PROVIDER)) {
            locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, locationListener, null);
            mLocationProvider = LocationManager.GPS_PROVIDER;
        } else if (providers.contains(LocationManager.PASSIVE_PROVIDER)) {
            locationManager.requestSingleUpdate(LocationManager.PASSIVE_PROVIDER, locationListener, null);
            mLocationProvider = LocationManager.PASSIVE_PROVIDER;
        } else {
            if (callback != null) {
                callback.onError(new Throwable("providers contains null"));
            }
            return;
        }
        Location location = locationManager.getLastKnownLocation(mLocationProvider);
        updateLocation(location, callback);
    }

    public static void updateLocation(Location location, final ICallback<LocationBean> callback) {
        if (location == null) {
            if (callback != null) {
                callback.onError(new Throwable("location null"));
            }
            return;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
//        Log.i(TAG, "latitude : " + latitude + "  longitude : " + longitude);
        getAddress(latitude, longitude, callback);
    }

    public static void getAddress(double latitude, double longitude, final ICallback<LocationBean> callback) {
        Geocoder geocoder = new Geocoder(mContext, Locale.ENGLISH);
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            Address address = addresses != null && addresses.size() > 0 ? addresses.get(0) : null;
            if (address != null) {
                String countryName = address.getCountryName();
                String countryCode = address.getCountryCode();
                Log.i(TAG, "countryName : " + countryName + "  countryCode : " + countryCode);
                if (callback != null) {
                    callback.onResult(new LocationBean(latitude, longitude, countryName, countryCode, address.toString()));
                }
            } else {
                if (callback != null) {

                    if (latitude == 0 && longitude == 0) {
                        callback.onError(new Throwable("address null"));
                    } else {
                        callback.onResult(new LocationBean(latitude, longitude, "***", "***", "***"));
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    public static void getLocationLatLon(Activity activity) {

        if (ContextCompat.checkSelfPermission(activity.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||

                ActivityCompat.checkSelfPermission(activity.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //请求权限

            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 0);

        } else {
            LocationUtil.getLocation(activity,new ICallback<LocationBean>() {
                @Override
                public void onResult(LocationBean locationBean) {

                }

                @Override
                public void onError(Throwable error) {
                    L.d("error : " + error);
                }
            });

        }


    }
}


