package com.csform.android.uiapptemplate;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Toast;

import com.csform.android.uiapptemplate.adapter.DragAndDropTravelAndSocialAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.TouchViewDraggableManager;

public class DragAndDropTravelAndSocialActivity extends ActionBarActivity {

	public static final String LIST_VIEW_OPTION = "com.csform.android.uiapptemplate.DragAndDropTravelAndSocialActivity";
	public static final String DRAG_AND_DROP_TRAVEL = "drag.and.drop.travel";
	public static final String DRAG_AND_DROP_SOCIAL = "drag.and.drop.social";

	private DynamicListView mDynamicListView;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_views);

		mDynamicListView = (DynamicListView) findViewById(R.id.dynamic_listview);
		mDynamicListView.setDividerHeight(0);

		String category = CategoriesListViewActivity.LIST_VIEW_OPTION_DRAG_AND_DROP;
		Bundle extras = getIntent().getExtras();
		if (extras != null
				&& extras
						.containsKey(CategoriesListViewActivity.LIST_VIEW_OPTION_DRAG_AND_DROP)) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
				category = extras
						.getString(
								CategoriesListViewActivity.LIST_VIEW_OPTION_DRAG_AND_DROP,
								DRAG_AND_DROP_TRAVEL);
			} else {
				category = extras
						.getString(CategoriesListViewActivity.LIST_VIEW_OPTION_DRAG_AND_DROP);
			}
		}
		if (category.equals(DRAG_AND_DROP_TRAVEL)) {
			setUpDragAndDrop();
		} else {
			mDynamicListView
					.setBackgroundResource(R.drawable.drag_and_drop_background_image);
			setUpDragAndDropSocial();
		}
		Toast.makeText(this, "Long press an item to start dragging",
				Toast.LENGTH_SHORT).show();

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Drag and Drop");
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void setUpDragAndDrop() {
		final DragAndDropTravelAndSocialAdapter adapter = new DragAndDropTravelAndSocialAdapter(
				this, DummyContent.getDummyModelDragAndDropTravelList(),
				DRAG_AND_DROP_TRAVEL);
		mDynamicListView.setAdapter(adapter);
		mDynamicListView.enableDragAndDrop();
		TouchViewDraggableManager tvdm = new TouchViewDraggableManager(
				R.id.drag_and_drop_travel_icon);
		mDynamicListView.setDraggableManager(new TouchViewDraggableManager(
				R.id.icon));
		mDynamicListView.setDraggableManager(tvdm);
		mDynamicListView
				.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, int position, long id) {
						mDynamicListView.startDragging(position);
						return true;
					}
				});
	}

	private void setUpDragAndDropSocial() {
		final DragAndDropTravelAndSocialAdapter adapter = new DragAndDropTravelAndSocialAdapter(
				this, DummyContent.getDummyModelList(), DRAG_AND_DROP_SOCIAL);
		mDynamicListView.setAdapter(adapter);
		mDynamicListView.enableDragAndDrop();
		TouchViewDraggableManager tvdm = new TouchViewDraggableManager(
				R.id.drag_and_drop_travel_icon);
		mDynamicListView.setDraggableManager(new TouchViewDraggableManager(
				R.id.icon));
		mDynamicListView.setDraggableManager(tvdm);
		mDynamicListView
				.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, int position, long id) {
						mDynamicListView.startDragging(position);
						return true;
					}
				});
	}
}
