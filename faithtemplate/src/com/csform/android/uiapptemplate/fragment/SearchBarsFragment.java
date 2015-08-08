package com.csform.android.uiapptemplate.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.SearchBarsActivity;
import com.csform.android.uiapptemplate.adapter.SubcategoryAdapter;

public class SearchBarsFragment extends Fragment implements OnItemClickListener {

	private ListView mListView;
	private List<String> mSearchBars;

	public static SearchBarsFragment newInstance() {
		return new SearchBarsFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mSearchBars = new ArrayList<String>();
		mSearchBars.add(SearchBarsActivity.SEARCH_BARS_DARK);
		mSearchBars.add(SearchBarsActivity.SEARCH_BARS_LIGHT);
		mSearchBars.add(SearchBarsActivity.SEARCH_BARS_TRAVEL);
		mSearchBars.add(SearchBarsActivity.SEARCH_BARS_SOCIAL);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_search_bars, container, false);
		
		mListView = (ListView) rootView.findViewById(R.id.list_view);
		mListView.setAdapter(new SubcategoryAdapter(getActivity(), mSearchBars));
		mListView.setOnItemClickListener(this);
		
		return rootView;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent(getActivity(), SearchBarsActivity.class);
		intent.putExtra(SearchBarsActivity.SEARCH_BARS_OPTION, mSearchBars.get(position));
		startActivity(intent);
	}
}
