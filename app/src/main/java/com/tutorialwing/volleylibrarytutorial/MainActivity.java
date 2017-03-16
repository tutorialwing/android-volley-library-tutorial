package com.tutorialwing.volleylibrarytutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setViewClickListener();
	}

	private void setViewClickListener() {
		View view = findViewById(R.id.string_request);
		if (view != null)
			view.setOnClickListener(this);

		view = findViewById(R.id.json_object_request);
		if (view != null)
			view.setOnClickListener(this);

		view = findViewById(R.id.json_array_request);
		if (view != null)
			view.setOnClickListener(this);

		view = findViewById(R.id.image_request);
		if (view != null)
			view.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.string_request:
				startActivity(new Intent(MainActivity.this, StringRequestActivity.class));
				break;
			case R.id.json_object_request:
				startActivity(new Intent(MainActivity.this, JsonObjectRequestActivity.class));
				break;
			case R.id.json_array_request:
				startActivity(new Intent(MainActivity.this, JsonArrayRequestActivity.class));
				break;
			case R.id.image_request:
				startActivity(new Intent(MainActivity.this, ImageActivity.class));
				break;
		}
	}
}
