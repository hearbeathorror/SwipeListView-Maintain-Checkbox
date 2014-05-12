package com.example.swipelistviewandroid;

import java.util.List;

import com.example.swipelistviewandroid.adapters.ItemAdapter;
import com.example.swipelistviewandroid.models.ItemData;
import com.example.swipelistviewandroid.staticdata.StaticDataManager;
import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	private List<ItemData> mItemData;
	private SwipeListView mSwipeListView;
	private ItemAdapter mItemAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mSwipeListView = (SwipeListView)findViewById(R.id.example_lv_list);
		mItemData = StaticDataManager.getInstance().getItemList();
		mItemAdapter = new ItemAdapter(this, R.layout.individual_list_row, mItemData);
		
		mSwipeListView.setSwipeListViewListener(new BaseSwipeListViewListener() {
            @Override
            public void onOpened(int position, boolean toRight) {
            }

            @Override
            public void onClosed(int position, boolean fromRight) {
            }

            @Override
            public void onListChanged() {
            }

            @Override
            public void onMove(int position, float x) {
            }

            @Override
            public void onStartOpen(int position, int action, boolean right) {
                Log.d("swipe", String.format("onStartOpen %d - action %d", position, action));
            }

            @Override
            public void onStartClose(int position, boolean right) {
                Log.d("swipe", String.format("onStartClose %d", position));
            }

            @Override
            public void onClickFrontView(int position) {
                Log.d("swipe", String.format("onClickFrontView %d", position));
            }

            @Override
            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));
            }

            @Override
            public void onDismiss(int[] reverseSortedPositions) {
                /*for (int position : reverseSortedPositions) {
                    data.remove(position);
                }
                adapter.notifyDataSetChanged();*/
            }

        });
		
		mSwipeListView.setAdapter(mItemAdapter);
	}
}
