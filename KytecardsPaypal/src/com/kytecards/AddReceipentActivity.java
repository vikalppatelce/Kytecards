package com.kytecards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class AddReceipentActivity extends Activity{
	
	EditText inmate,email;
	Button send;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.receipent);
		
		inmate=(EditText)findViewById(R.id.inmate);
		email=(EditText)findViewById(R.id.email);
		send=(Button)findViewById(R.id.send);
	
		send.setOnClickListener(s);
	}
	
	View.OnClickListener s=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(AddReceipentActivity.this,PurchaseActivity.class);
			startActivity(i);
		}
	};
}
