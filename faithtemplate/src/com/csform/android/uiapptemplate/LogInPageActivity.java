package com.csform.android.uiapptemplate;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInPageActivity extends Activity implements OnClickListener {

	public static final String LOGIN_PAGE_AND_LOADERS_CATEGORY = "com.csform.android.uiapptemplate.LogInPageAndLoadersActivity";
	public static final String SOCIAL = "Social";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE); // Removing
																// ActionBar
		String category = SOCIAL;
		Bundle extras = getIntent().getExtras();
		if (extras != null
				&& extras.containsKey(LOGIN_PAGE_AND_LOADERS_CATEGORY)) {
			category = extras.getString(LOGIN_PAGE_AND_LOADERS_CATEGORY, SOCIAL);
		}
		setContentView(category);
	}

	private void setContentView(String category) {
		EditText loginText;
		EditText passText;
		if (category.equals(SOCIAL)) {
			setContentView(R.layout.activity_login_page_social);
		} else if (category.equals(SOCIAL)) {
			setContentView(R.layout.activity_login_page_social);
			loginText = (EditText) findViewById(R.id.login_page_social_login_text);
			passText = (EditText) findViewById(R.id.login_page_social_login_password);
			Typeface sRobotoThin = Typeface.createFromAsset(getAssets(),
					"fonts/Roboto-Thin.ttf");
			;
			loginText.setTypeface(sRobotoThin);
			passText.setTypeface(sRobotoThin);
		}
		TextView login, register, skip;
		login = (TextView) findViewById(R.id.login);
		register = (TextView) findViewById(R.id.register);
		skip = (TextView) findViewById(R.id.skip);

		login.setOnClickListener(this);
		register.setOnClickListener(this);
		skip.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v instanceof TextView) {
			TextView tv = (TextView) v;
			Toast.makeText(this, tv.getText(), Toast.LENGTH_SHORT).show();
		}
	}
}
