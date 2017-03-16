package com.tutorialwing.volleylibrarytutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {

	public static final String IMAGE_URL = "http://tutorialwing.com/api/tutorialwing_logo.jpg";

	private ImageView imageView;
	private ImageView imageViewWithPlaceholderAndError;
	private NetworkImageView networkImageView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.image_activity);

		View view = findViewById(R.id.load_image);
		if (view != null)
			view.setOnClickListener(this);

		view = findViewById(R.id.load_network_image);
		if (view != null)
			view.setOnClickListener(this);

		view = findViewById(R.id.load_image_placeholder_error);
		if (view != null)
			view.setOnClickListener(this);

		imageView = (ImageView) findViewById(R.id.image_view);
		imageViewWithPlaceholderAndError = (ImageView) findViewById(R.id.image_view_placeholder_error);
		networkImageView = (NetworkImageView) findViewById(R.id.network_image_view);
	}

	private void sendRequest() {
		ImageLoader imageLoader = AppController.getInstance().getImageLoader();
		imageLoader.get(IMAGE_URL, new ImageLoader.ImageListener() {
			@Override
			public void onResponse(ImageLoader.ImageContainer response, boolean arg1) {
				showResponse(response);
			}

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
	}

	private void showResponse(ImageLoader.ImageContainer response) {
		if (imageView != null) {
			imageView.setImageBitmap(response.getBitmap());
		}
	}

	private void loadImageWithPlaceholderAndError() {
		ImageLoader imageLoader = AppController.getInstance().getImageLoader();
		if (imageViewWithPlaceholderAndError != null) {
			// Loading image with placeholder and error image
			imageLoader.get(IMAGE_URL, ImageLoader.getImageListener(imageViewWithPlaceholderAndError, R.mipmap.ic_launcher, R.drawable.error));
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.load_image:
				sendRequest();
				break;
			case R.id.load_image_placeholder_error:
				loadImageWithPlaceholderAndError();
				break;
			case R.id.load_network_image:
				ImageLoader imageLoader = AppController.getInstance().getImageLoader();
				if (networkImageView != null) {
					networkImageView.setImageUrl(IMAGE_URL, imageLoader);
				}
				break;
		}
	}
}
