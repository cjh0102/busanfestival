package com.hipits.regionalinfo.busanfestival.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.TabHost;

import com.hipits.regionalinfo.busanfestival.R;
import com.hipits.regionalinfo.busanfestival.adapter.TabAdpater;
import com.hipits.regionalinfo.busanfestival.fragment.CalendarofEventsFragment;
import com.hipits.regionalinfo.busanfestival.fragment.FestivalGuideListFragment;
import com.hipits.regionalinfo.busanfestival.fragment.FestivalIntroductionFragment;
import com.hipits.regionalinfo.busanfestival.fragment.FestivalLocationFragment;
import com.hipits.regionalinfo.busanfestival.manager.TabImageIdManager;
import com.hipits.regionalinfo.busanfestival.model.TabImageId;

public class FestivalTabActivity extends FragmentActivity {

	private TabHost tabHost;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_festival);

		Intent intent = getIntent();

		String msg = intent.getStringExtra("msg");

		tabHost = (TabHost)findViewById(android.R.id.tabhost);
		tabHost.setup();

		ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
		TabAdpater adapter = new TabAdpater(this,tabHost, viewPager, msg);

		FestivalIntroductionFragment.MSG = msg;
		FestivalGuideListFragment.MSG = msg;
		CalendarofEventsFragment.MSG = msg;
		FestivalLocationFragment.MSG = msg;
		
		adapter.addTab(tabHost.newTabSpec("tag1").setIndicator(""), FestivalIntroductionFragment.class, null);
		adapter.addTab(tabHost.newTabSpec("tag2").setIndicator(""), FestivalGuideListFragment.class, null);
		adapter.addTab(tabHost.newTabSpec("tag3").setIndicator(""), CalendarofEventsFragment.class, null);
		adapter.addTab(tabHost.newTabSpec("tag4").setIndicator(""), FestivalLocationFragment.class, null);

		TabImageId tabImageId = TabImageIdManager.getInstance().getTabImagIds(msg);
		
		Integer[] unselected_TabImageIds = tabImageId.getUnSelectedIds();
	
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			tabHost.getTabWidget().getChildAt(i).setBackgroundResource(unselected_TabImageIds[i]);
		}

		tabHost.getTabWidget().setCurrentTab(0);
		tabHost.getTabWidget().getChildAt(0).setBackgroundResource(tabImageId.getSelectIds()[0]);
	}

}
