package com.example.swipelistviewandroid.adapters;

import java.util.List;

import com.example.swipelistviewandroid.R;
import com.example.swipelistviewandroid.models.ItemData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<ItemData>{
	private List<ItemData> mItemData;
	private Context mContext;
	private int mResource;
	private LayoutInflater mInflater;
	
	public ItemAdapter(Context context, int resource, List<ItemData> objects) {
		super(context, resource, objects);
		mItemData =  objects;
		mResource = resource;
		mContext = context;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder vh = null;
		
		if(view == null) {
			mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = mInflater.inflate(mResource, parent,false);
			vh = new ViewHolder();
			vh.txtItemName = (TextView)view.findViewById(R.id.txtItemName);
			vh.checkItem  = (CheckBox)view.findViewById(R.id.checkItem);
			view.setTag(vh);
		}else {
			vh = (ViewHolder)view.getTag();
		}
		
		final ItemData itemData = mItemData.get(position);
		vh.txtItemName.setText(itemData.getItemName());
		vh.checkItem.setText(String.valueOf(itemData.getId()));
		
		vh.checkItem.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CheckBox chkBox = (CheckBox)v.findViewById(R.id.checkItem);
				
				if((Integer)chkBox.getTag() == position) {
					if(chkBox.isChecked()) {
						itemData.setChecked(true);
					}else {
						itemData.setChecked(false);
					}
				}
			}
		});
		
		vh.checkItem.setTag(position);
		vh.checkItem.setChecked(itemData.isChecked());
		return view;
	}
	
	static class ViewHolder {
		TextView txtItemName;
		CheckBox checkItem;
	}
}
