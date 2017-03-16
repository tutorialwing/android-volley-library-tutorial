package com.tutorialwing.volleylibrarytutorial.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Post {

	private String name;
	private String title;
	private String category;
	private String url;

	private String KEY_NAME = "name";
	private String KEY_TITLE = "title";
	private String KEY_CATEGORY = "category";
	private String KEY_URL = "url";

	public Post(JSONObject jsonObject) {
		parseJson(jsonObject);
	}

	private void parseJson(JSONObject jsonObject) {
		try {
			name = jsonObject.getString(KEY_NAME);
			title = jsonObject.getString(KEY_TITLE);
			category = jsonObject.getString(KEY_CATEGORY);
			url = jsonObject.getString(KEY_URL);
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
