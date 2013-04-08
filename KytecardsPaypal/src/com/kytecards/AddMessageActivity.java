package com.kytecards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class AddMessageActivity extends Activity{
	
	EditText gText;
	Button next;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.messagescreen);
		
		gText=(EditText)findViewById(R.id.greeting);
		next=(Button)findViewById(R.id.next);
		
		next.setOnClickListener(l);
	}
	
	
	View.OnClickListener l= new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(AddMessageActivity.this,AddReceipentActivity.class);
			startActivity(i);
		}
	};
}
