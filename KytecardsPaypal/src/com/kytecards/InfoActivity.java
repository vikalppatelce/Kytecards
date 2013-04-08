package com.kytecards;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends Activity
{

	Button icall;
	Button iemail;
	Button iphotocard;
	Button ipostcard;
	TextView whyus;

	@Override
	public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.info);
	    ipostcard = ((Button)findViewById(R.id.postcard));
	    iphotocard = ((Button)findViewById(R.id.photocard));
	    icall = ((Button)findViewById(R.id.contactbutton));
	    iemail = ((Button)findViewById(R.id.emailbutton));
	    whyus= (TextView)findViewById(R.id.whyus);
	    
	    whyus.setText(readTxt());
	    ipostcard.setOnClickListener(new View.OnClickListener()
	    {
	      @Override
		public void onClick(View paramView)
	      {
	        startActivity(new Intent(getApplicationContext(), TipActivity.class));
	      }
	    });
	    iphotocard.setOnClickListener(new View.OnClickListener()
	    {
	      @Override
		public void onClick(View paramView)
	      {
	      }
	    });
	    icall.setOnClickListener(c);
	    iemail.setOnClickListener(e);
	  }	
	
	private String readTxt(){

	     InputStream inputStream = getResources().openRawResource(R.raw.kytecards);
	     System.out.println(inputStream);
	     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

	     int i;
	     try {
	    	 i = inputStream.read();
	    	 while (i != -1)
	    	 {
	    		 byteArrayOutputStream.write(i);
	    		 i = inputStream.read();
	    	 }
	    	 inputStream.close();
	     	 } catch (IOException e) {
	     		 			e.printStackTrace();
	     	 						}

	     return byteArrayOutputStream.toString();
	    }
	
  View.OnClickListener c = new View.OnClickListener()
  {
    @Override
	public void onClick(View paramView)
    {
      new StringBuilder("tel:").append(getResources().getString(R.string.phonebutton)).toString();
      Intent localIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:"));
      startActivity(localIntent);
    }
  };
  View.OnClickListener e = new View.OnClickListener()
  {
    @Override
	public void onClick(View paramView)
    {
      String str = getResources().getString(R.string.email_id);
      Intent localIntent1 = new Intent("android.intent.action.SEND");
      localIntent1.putExtra("android.intent.extra.EMAIL", str);
      localIntent1.putExtra("android.intent.extra.SUBJECT", "| PostCard App");
      try
      {
        startActivity(localIntent1);
        return;
      }
      catch (Exception localException1)
      {
        try
        {
          Intent localIntent2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.gm"));
          startActivity(localIntent2);
          return;
        }
        catch (Exception localException2)
        {
          Intent localIntent3 = new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.google.android.gm"));
          startActivity(localIntent3);
        }
      }
    }
  };
  
}
