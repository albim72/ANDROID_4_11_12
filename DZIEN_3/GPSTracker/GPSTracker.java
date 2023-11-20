package com.marcin.gpstracker;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.IBinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.security.PrivateKey;

public class GPSTracker extends Service implements LocationListener {
    
    private final Context mContext;
    //flaga statusu GPS
    boolean isGPSEnabled = false;
    //flaga statusu sieci
    boolean inNetworkEnabled = false;
    //flaga ze statusu GPS
    boolean cenGetLocation = false;
    Location location;
    double latitude;
    double longitude;
    
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long   MIN_TIME_BE_UPDATES = 1000*60*1;
    
    protected LocationManager locationManager;

    public GPSTracker(Context mContext) {
        this.mContext = mContext;
        getLocation();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }
}
