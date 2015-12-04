package com.example.testflowlayout;

import com.example.testflowlayout.FlowLayout.FlowLayoutLayoutParams;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		FlowLayout flowLayout = (FlowLayout) findViewById(R.id.flowLayout);
		
		flowLayout.removeAllViews();
		for (int i = 0; i < 110; i++) {
			View item = View.inflate(this, R.layout.fowlayout_item, null);
			TextView tv = (TextView) item.findViewById(R.id.tv);
			tv.setText("kkkkk"+i);
			flowLayout.addView(item, new FlowLayout.FlowLayoutLayoutParams(FlowLayoutLayoutParams.WRAP_CONTENT, FlowLayoutLayoutParams.WRAP_CONTENT));
		}
		
	}
}
