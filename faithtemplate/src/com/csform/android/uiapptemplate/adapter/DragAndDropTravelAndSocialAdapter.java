package com.csform.android.uiapptemplate.adapter;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.csform.android.uiapptemplate.DragAndDropTravelAndSocialActivity;
import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.csform.android.uiapptemplate.util.ImageUtil;
import com.nhaarman.listviewanimations.util.Swappable;

public class DragAndDropTravelAndSocialAdapter extends BaseAdapter implements
		Swappable {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<DummyModel> mDummyModelList;
	private String category;

	public DragAndDropTravelAndSocialAdapter(Context context,
			ArrayList<DummyModel> dummyModelList, String category) {
		mContext = context;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mDummyModelList = dummyModelList;
		this.category = category;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public int getCount() {
		return mDummyModelList.size();
	}

	@Override
	public Object getItem(int position) {
		return mDummyModelList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mDummyModelList.get(position).getId();
	}

	@Override
	public void swapItems(int positionOne, int positionTwo) {
		Collections.swap(mDummyModelList, positionOne, positionTwo);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			if (category
					.equals(DragAndDropTravelAndSocialActivity.DRAG_AND_DROP_TRAVEL)) {
				convertView = mInflater.inflate(
						R.layout.list_item_drag_and_drop_travel, parent, false);
				holder = new ViewHolder();
				holder.image = (ImageView) convertView
						.findViewById(R.id.drag_and_drop_travel_image);
				holder.text = (TextView) convertView
						.findViewById(R.id.drag_and_drop_travel_text);
				holder.subtext = (TextView) convertView
						.findViewById(R.id.drag_and_drop_travel_subtext);
				holder.icon = (TextView) convertView
						.findViewById(R.id.drag_and_drop_travel_icon);
				holder.rating = (TextView) convertView
						.findViewById(R.id.drag_and_drop_travel_rating);
				convertView.setTag(holder);
			} else {
				convertView = mInflater.inflate(
						R.layout.list_item_drag_and_drop_social, parent, false);
				holder = new ViewHolder();
				holder.image = (ImageView) convertView
						.findViewById(R.id.item_drag_and_drop_social_image);
				holder.text = (TextView) convertView
						.findViewById(R.id.item_drag_and_drop_social_name);
				holder.place = (TextView) convertView
						.findViewById(R.id.item_drag_and_drop_social_place);
				convertView.setTag(holder);
			}
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		DummyModel dm = mDummyModelList.get(position);

		if (category
				.equals(DragAndDropTravelAndSocialActivity.DRAG_AND_DROP_TRAVEL)) {
			ImageUtil.displayImage(holder.image, dm.getImageURL(), null);
			holder.text.setText(dm.getText());

			holder.icon.setText(R.string.fontello_drag_and_drop);
		} else {
			ImageUtil.displayRoundImage(holder.image, dm.getImageURL(), null);
			holder.text.setText(dm.getText());

		}
		return convertView;
	}

	private static class ViewHolder {
		public ImageView image;
		public/* Roboto */TextView text;
		public/* Roboto */TextView subtext;
		public/* Fontello */TextView icon;
		public/* Roboto */TextView rating;
		public/* Roboto */TextView place;
	}
}
