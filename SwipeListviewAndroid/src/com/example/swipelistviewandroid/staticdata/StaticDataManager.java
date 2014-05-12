package com.example.swipelistviewandroid.staticdata;

import java.util.ArrayList;
import java.util.List;

import com.example.swipelistviewandroid.models.ItemData;

public class StaticDataManager {
	private static StaticDataManager mStaticDataManager = new StaticDataManager();
	private List<ItemData> mItemData;
	
	public static StaticDataManager getInstance() {
		return mStaticDataManager;
	}
	
	public List<ItemData> getItemList() {
		mItemData = new ArrayList<ItemData>();
		
		for(int i=0;i<30;i++) {
			ItemData itemData = new ItemData();
			itemData.setId(i + 1);
			itemData.setItemName("Item " + (i+1));
			mItemData.add(itemData);
		}
		
		return mItemData;
	}
}
