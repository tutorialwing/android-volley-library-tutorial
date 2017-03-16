package com.tutorialwing.volleylibrarytutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class StringRequestActivity extends AppCompatActivity {

	public static final String REQUEST_TAG = "STRING_REQUEST_TAG";
	public static final String JSON_URL = "http://tutorialwing.com/api/tutorialwing_welcome.json";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.string_request_activity);

		View view = findViewById(R.id.get_request);
		if (view != null)
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					sendRequest();
				}
			});
	}

	private void sendRequest() {
		StringRequest stringRequest = new StringRequest(JSON_URL,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						showResponse(response);
					}
				},
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(StringRequestActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
					}
				});

		AppController.getInstance().addToRequestQueue(stringRequest, REQUEST_TAG);
	}

	private void showResponse(String response) {
		TextView txvResponse = (TextView) findViewById(R.id.request_response);
		if (txvResponse != null) {
			txvResponse.setText(response);
		}
	}

}
