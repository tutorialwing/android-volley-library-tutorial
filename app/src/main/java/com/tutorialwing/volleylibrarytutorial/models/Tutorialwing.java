package com.tutorialwing.volleylibrarytutorial.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Tutorialwing {
	private String website;
	private String topics;
	private String facebook;
	private String twitter;
	private String pinterest;
	private String youtube;
	private String message;

	private String KEY_WEBSITE = "website";
	private String KEY_TOPICS = "topics";
	private String KEY_FACEBOOK = "facebook";
	private String KEY_TWITTER = "twitter";
	private String KEY_PINTEREST = "pinterest";
	private String KEY_YOUTUBE = "youtube";
	private String KEY_MESSAGE = "message";

	public Tutorialwing(JSONObject object) {
		parseJsonObject(object);
	}

	private void parseJsonObject(JSONObject jsonObject) {
		try {
			website = jsonObject.getString(KEY_WEBSITE);
			topics = jsonObject.getString(KEY_TOPICS);
			facebook = jsonObject.getString(KEY_FACEBOOK);
			twitter = jsonObject.getString(KEY_TWITTER);
			pinterest = jsonObject.getString(KEY_PINTEREST);
			youtube = jsonObject.getString(KEY_YOUTUBE);
			message = jsonObject.getString(KEY_MESSAGE);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String getWebsite() {
		return website;
	}

	public String getTopics() {
		return topics;
	}

	public String getFacebook() {
		return facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public String getPinterest() {
		return pinterest;
	}

	public String getYoutube() {
		return youtube;
	}

	public String getMessage() {
		return message;
	}
}
