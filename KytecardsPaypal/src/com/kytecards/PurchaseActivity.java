package com.kytecards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class PurchaseActivity extends Activity {
	
	Button paypal,gwallet,internet;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.payment);
		
		paypal=(Button)findViewById(R.id.paypal);
		gwallet=(Button)findViewById(R.id.gwallet);
		internet=(Button)findViewById(R.id.internet);
		
		paypal.setOnClickListener(p);
		gwallet.setOnClickListener(g);
		internet.setOnClickListener(net);
		
	}
	
	View.OnClickListener p=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(PurchaseActivity.this,PaypalA.class);
			startActivity(i);
		}
	};
	
	View.OnClickListener g=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(PurchaseActivity.this, ThanksActivity.class);
			startActivity(i);
		}
	};
	
	View.OnClickListener net =new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(PurchaseActivity.this,ThanksActivity.class);
			startActivity(i);
		}
	};

}
