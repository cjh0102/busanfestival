package com.hipits.regionalinfo.busanfestival.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;


public class GuideMapActivity extends MapActivity {
	private MapView guideMapView;
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_guidemap);
		
		guideMapView = (MapView)findViewById(R.id.guideMapView);
		guideMapView.setBuiltInZoomControls(true);
		
		Intent intent = getIntent();
		GeoPoint geoPoint = getGeoPoint(intent.getStringExtra("msg"));	

		MapController mapController = guideMapView.getController();
		mapController.setCenter(geoPoint);
		mapController.setZoom(18);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	public GeoPoint getGeoPoint(String msg){
		GeoPoint geoPoint = null;
		
		if (msg.equals("sun")) {
			geoPoint = new GeoPoint((int)(35.158758 * 1e6), (int)(129.160396 * 1e6));
		} else if (msg.equals("rock")) {
			geoPoint = new GeoPoint((int)(35.170072 * 1e6), (int)(128.973656 * 1e6));
		} else if (msg.equals("port")) {
			geoPoint = new GeoPoint((int)(35.080777 * 1e6), (int)(129.078798 * 1e6));
		} else if (msg.equals("sea")) {
			geoPoint = new GeoPoint((int)(35.158758 * 1e6), (int)(129.160396 * 1e6));
		} else if (msg.equals("flame")) {
			geoPoint = new GeoPoint((int)(35.153192 * 1e6), (int)(129.118667 * 1e6));
		}
		return geoPoint;
	}

}
