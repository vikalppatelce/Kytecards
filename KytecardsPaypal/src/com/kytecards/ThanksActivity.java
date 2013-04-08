package com.kytecards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ThanksActivity extends Activity{
	
	Button exit,feedback,again;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.thankyou);
		
		feedback=(Button)findViewById(R.id.feedbackbutton);
		again=(Button)findViewById(R.id.againbutton);
		exit=(Button)findViewById(R.id.exitbutton);
		
		feedback.setOnClickListener(f);
		again.setOnClickListener(a);
		exit.setOnClickListener(e);
	}
	
	View.OnClickListener f=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
	View.OnClickListener a=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(ThanksActivity.this,PicPickerActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
		}
	};

	View.OnClickListener e=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			ThanksActivity.this.finish();
			android.os.Process.killProcess(android.os.Process.myPid());
		}
	};
}
