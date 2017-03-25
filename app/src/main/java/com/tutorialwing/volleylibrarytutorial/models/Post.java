package com.tutorialwing.volleylibrarytutorial.models;

import com.tutorialwing.volleylibrarytutorial.Constants;

import org.json.JSONException;
import org.json.JSONObject;

public class Post {

	private String name;
	private String title;
	private String category;
	private String url;

	public Post(JSONObject jsonObject) {
		parseJson(jsonObject);
	}

	private void parseJson(JSONObject jsonObject) {
		try {
			name = jsonObject.getString(Constants.KEY_NAME);
			title = jsonObject.getString(Constants.KEY_TITLE);
			category = jsonObject.getString(Constants.KEY_CATEGORY);
			url = jsonObject.getString(Constants.KEY_URL);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getUrl() {
		return url;
	}
}
