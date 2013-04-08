package com.kytecards;

import java.math.BigDecimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalPayment;
 
public class PaypalA extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        invokeSimplePayment();
    }
    
    
    private void invokeSimplePayment(){
    	
    	try{
    		
    		PayPalPayment newPayment = new PayPalPayment();
    		newPayment.setSubtotal(BigDecimal.valueOf(0.99));
    		newPayment.setCurrencyType("USD");
    		//.setCurrency("USD");
    		newPayment.setRecipient("vikalppatelce@yahoo.com");
    		newPayment.setMerchantName("Kytecards.com");
    		
    		PayPal pp = PayPal.getInstance();
    		if(pp==null)
    			pp = PayPal.initWithAppID(this, "APP-80W284485P519543T", PayPal.ENV_SANDBOX);
    		
    		Intent paypalIntent = pp.checkout(newPayment, this);
    		this.startActivityForResult(paypalIntent, 1);
    		
    	}catch(Exception e){e.printStackTrace();}
    }
    
    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(resultCode) {
		case Activity.RESULT_OK:
		//The payment succeeded
		String payKey = data.getStringExtra(PayPalActivity.EXTRA_PAY_KEY);
		Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
		Intent i=new Intent(getApplicationContext(),ThanksActivity.class);
		startActivity(i);
		//Tell the user their payment succeeded
		break;
		case Activity.RESULT_CANCELED:
		//The payment was canceled
		//Tell the user their payment was canceled
		break;
		case PayPalActivity.RESULT_FAILURE:
		//The payment failed -- we get the error from the EXTRA_ERROR_ID and EXTRA_ERROR_MESSAGE
		String errorID = data.getStringExtra(PayPalActivity.EXTRA_ERROR_ID);
		String errorMessage = data.getStringExtra(PayPalActivity.EXTRA_ERROR_MESSAGE);
		//Tell the user their payment was failed.
		}
		}
    
    
}
