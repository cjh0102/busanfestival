package com.hipits.regionalinfo.busanfestival.activity;

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
		
		MapController mapController = guideMapView.getController();
		GeoPoint geoPoint = new GeoPoint((int)(35.0794252204516 * 1e6), (int)(129.07817602157593 * 1e6));	
		mapController.setCenter(geoPoint);
		mapController.setZoom(17);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
