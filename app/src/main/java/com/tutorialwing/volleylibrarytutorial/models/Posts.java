package com.tutorialwing.volleylibrarytutorial.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Posts {

	private List<Post> posts;

	public Posts(JSONArray jsonArray) {
		parseJson(jsonArray);
	}

	private void parseJson(JSONArray jsonArray) {
		posts = new ArrayList<>();
		for (int i = 0; i < jsonArray.length(); i++) {
			try {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				posts.add(new Post(jsonObject));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Post> getPosts() {
		return posts;
	}
}
