package com.csform.android.uiapptemplate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csform.android.uiapptemplate.R;

public class CheckAndRadioBoxesFragment extends Fragment {

	public static CheckAndRadioBoxesFragment newInstance() {
		return new CheckAndRadioBoxesFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_check_and_radio_boxes, container, false);
		
		return rootView;
	}
}
