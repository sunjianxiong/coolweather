package com.coolweather.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coolweather.app.R;

public class WeatherActivity extends Activity implements OnClickListener {

	private LinearLayout weatherInfoLayout;

	private TextView cityNameText;

	private TextView publisText;

	private TextView weatherDespText;

	private TextView temp1Text;

	private TextView temp2Text;

	private TextView currentDateText;

	private Button switchCity;

	private Button refreshWeather;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weather_layout);

		weatherInfoLayout = (LinearLayout) findViewById(R.id.weather_info_layout);
		cityNameText = (TextView) findViewById(R.id.city_name);
		publisText = (TextView) findViewById(R.id.publish_text);
		weatherDespText = (TextView) findViewById(R.id.weather_desp);
		temp1Text = (TextView) findViewById(R.id.temp1);
		temp2Text = (TextView) findViewById(R.id.temp2);
		currentDateText = (TextView) findViewById(R.id.current_date);

		String countyCode = getIntent().getStringExtra("county_code");
		if (!TextUtils.isEmpty(countyCode)) {
			publisText.setText("同步中...");
			weatherInfoLayout.setVisibility(View.INVISIBLE);
			cityNameText.setVisibility(View.INVISIBLE);
			queryWeatherCode(countyCode);
		} else {
			//showWeather();
		}
	}

	private void queryWeatherCode(String countyCode) {
		String address = "http://www.weather.com.cn/data/cityinfo/" + countyCode + ".xml";
		//queryFromServer(address, "countryCode");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
