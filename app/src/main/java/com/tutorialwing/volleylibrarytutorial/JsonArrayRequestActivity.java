package com.tutorialwing.volleylibrarytutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.tutorialwing.volleylibrarytutorial.models.Posts;

import org.json.JSONArray;

public class JsonArrayRequestActivity extends AppCompatActivity implements View.OnClickListener {

	public static final String REQUEST_TAG = "JSON_ARRAY_REQUEST_TAG";
	public static final String JSON_URL = "http://tutorialwing.com/api/tutorialwing_posts.json";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.json_array_request_activity);

		View view = findViewById(R.id.get_request);
		if (view != null)
			view.setOnClickListener(this);
	}

	private void sendRequest() {
		JsonArrayRequest jsonArrayReq = new JsonArrayRequest(JSON_URL,
				new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						showResponse(new Posts(response));
					}
				},
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
					}
				});

		// Adding JsonObject request to request queue
		AppController.getInstance().addToRequestQueue(jsonArrayReq, REQUEST_TAG);
	}

	private void showResponse(Posts posts) {
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.request_response);
		if (recyclerView != null) {
			PostAdapter postAdapter = new PostAdapter(posts, R.layout.single_post);
			recyclerView.setLayoutManager(new LinearLayoutManager(this));
			recyclerView.setAdapter(postAdapter);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.get_request:
				sendRequest();
				break;
		}
	}
}
