package com.hipits.regionalinfo.busanfestival.manager;

import com.hipits.regionalinfo.busanfestival.R;
import com.hipits.regionalinfo.busanfestival.model.TabImageId;

public class TabImageIdManager {
	private static TabImageIdManager tabImageIdManager;
	
	
	public static TabImageIdManager getInstance() {
		if (tabImageIdManager == null) {
			tabImageIdManager = new TabImageIdManager();
		}
		return tabImageIdManager;
	}
	
	public TabImageId getTabImagIds(String msg) {
		
		TabImageId imageId = null;
		Integer[] selectIds, unSelectedIds;
		
		if (msg.equals("port")) {
			selectIds = new Integer[]{R.drawable.tap_3_mouseover_01,
					R.drawable.tap_3_mouseover_02, R.drawable.tap_3_mouseover_03
					, R.drawable.tap_3_mouseover_04};
			unSelectedIds = new Integer[]{R.drawable.tap_3_normal_01,
					R.drawable.tap_3_normal_02, R.drawable.tap_3_normal_03
					, R.drawable.tap_3_normal_04};
			imageId = new TabImageId(selectIds, unSelectedIds);

		} else if (msg.equals("sea")) {
			selectIds = new Integer[]{R.drawable.tap_4_mouseover_01,
					R.drawable.tap_4_mouseover_02, R.drawable.tap_4_mouseover_03
					,R.drawable.tap_4_mouseover_04};
			unSelectedIds = new Integer[]{R.drawable.tap_4_normal_01,
					R.drawable.tap_4_normal_02, R.drawable.tap_4_normal_03
					, R.drawable.tap_4_normal_04};
			imageId = new TabImageId(selectIds, unSelectedIds);
			
		} else if (msg.equals("rock")) {
			selectIds = new Integer[]{R.drawable.tap_2_mouseover_01,
					R.drawable.tap_2_mouseover_02, R.drawable.tap_2_mouseover_03
					,R.drawable.tap_2_mouseover_04};
			unSelectedIds = new Integer[]{R.drawable.tap_2_normal_01,
					R.drawable.tap_2_normal_02, R.drawable.tap_2_normal_03
					, R.drawable.tap_2_normal_04};
			imageId = new TabImageId(selectIds, unSelectedIds);
		
		} else if (msg.equals("flame")) {
			selectIds = new Integer[]{R.drawable.tap_5_mouseover_01,
					R.drawable.tap_5_mouseover_02, R.drawable.tap_5_mouseover_03
					,R.drawable.tap_5_mouseover_04};
			unSelectedIds = new Integer[]{R.drawable.tap_5_normal_01,
					R.drawable.tap_5_normal_02, R.drawable.tap_5_normal_03
					, R.drawable.tap_5_normal_04};
			imageId = new TabImageId(selectIds, unSelectedIds);
		
		} else if (msg.equals("sun")) {
			selectIds = new Integer[]{R.drawable.tap_1_mouseover_01,
					R.drawable.tap_1_mouseover_02, R.drawable.tap_1_mouseover_03
					,R.drawable.tap_1_mouseover_04};
			unSelectedIds = new Integer[]{R.drawable.tap_1_normal_01,
					R.drawable.tap_1_normal_02, R.drawable.tap_1_normal_03
					, R.drawable.tap_1_normal_04};
			imageId = new TabImageId(selectIds, unSelectedIds);
		}
		return imageId;
	}
}
