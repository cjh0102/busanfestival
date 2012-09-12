package com.hipits.regionalinfo.busanfestival.adapter;


import java.util.ArrayList;

import com.hipits.regionalinfo.busanfestival.manager.TabImageIdManager;
import com.hipits.regionalinfo.busanfestival.model.TabImageId;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;

public class TabAdpater extends FragmentPagerAdapter implements TabHost.OnTabChangeListener, 
ViewPager.OnPageChangeListener {

	private Context context;
	private TabHost tabHost;
	private ViewPager viewPager;
	private final ArrayList<TabInfos> mTabs = new ArrayList<TabInfos>();
	private String msg;

	public TabAdpater(FragmentActivity fm, TabHost tabHost,
			ViewPager viewPager, String msg) {
		super(fm.getSupportFragmentManager());
		this.context= fm;
		this.tabHost = tabHost;
		this.viewPager = viewPager;
		this.msg = msg;
		this.tabHost.setOnTabChangedListener(this);
		this.viewPager.setAdapter(this);
		this.viewPager.setOnPageChangeListener(this);
	}

	static final class TabInfos {
		private final String tag;
		private final Class<?> clss;
		private final Bundle bundle;

		TabInfos(String _tag, Class<?> _class, Bundle bundle) {
			tag = _tag;
			clss = _class;
			this.bundle = bundle;
		}
	}

	static class DummyTabFactory implements TabHost.TabContentFactory {
		private final Context mContext;

		public DummyTabFactory(Context context) {
			mContext = context;
		}
		@Override
		public View createTabContent(String tag) {
			View v = new View(mContext);
			v.setMinimumWidth(0);
			v.setMinimumHeight(0);
			return v;
		}
	}


	public void addTab(TabHost.TabSpec tabSpec, Class<?> clss, Bundle bundle) {
		tabSpec.setContent(new DummyTabFactory(context));
		String tag = tabSpec.getTag();
		TabInfos info = new TabInfos(tag, clss, bundle);
		mTabs.add(info);
		tabHost.addTab(tabSpec);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mTabs.size();
	}

	@Override
	public Fragment getItem(int position) {
		TabInfos info = mTabs.get(position);
		return Fragment.instantiate(this.context, info.clss.getName());
	}

	@Override
	public void onTabChanged(String tabId) {
		int position;
		position = tabHost.getCurrentTab();
		viewPager.setCurrentItem(position);

		TabImageId tabImageId = TabImageIdManager.getInstance().getTabImagIds(msg);

		Integer[] unselected_TabImageIds = tabImageId.getUnSelectedIds();
		Integer[] selected_TabImageIds = tabImageId.getSelectIds();

		// 선택 되지 않았을 경우
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			tabHost.getTabWidget().getChildAt(i).setBackgroundResource(unselected_TabImageIds[i]);
		}
		// 선택 되었을 경우
		tabHost.getTabWidget().getChildAt(position).setBackgroundResource(selected_TabImageIds[position]);
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
	}

	@Override
	public void onPageSelected(int position) {
		
		TabWidget widget = tabHost.getTabWidget();
		int oldFocusability = widget.getDescendantFocusability();
		widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
		tabHost.setCurrentTab(position);
		widget.setDescendantFocusability(oldFocusability);
	}

	@Override
	public void onPageScrollStateChanged(int state) {
	}
}

