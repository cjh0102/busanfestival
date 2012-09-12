package com.hipits.regionalinfo.busanfestival.model;

public class TabImageId {
	private Integer[] selectIds;
	private Integer[] unSelectedIds;
	
	public TabImageId(Integer[] selectIds, Integer[] unSelectedIds) {
		super();
		this.selectIds = selectIds;
		this.unSelectedIds = unSelectedIds;
	}
	public Integer[] getSelectIds() {
		return selectIds;
	}
	public void setSelectIds(Integer[] selectIds) {
		this.selectIds = selectIds;
	}
	public Integer[] getUnSelectedIds() {
		return unSelectedIds;
	}
	public void setUnSelectedIds(Integer[] unSelectedIds) {
		this.unSelectedIds = unSelectedIds;
	}

}
