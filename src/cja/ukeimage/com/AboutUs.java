package cja.ukeimage.com;

import org.apache.http.protocol.HTTP;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AboutUs extends Activity{
    Button sendEmail ; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutus);
		TextView aboutString = (TextView)findViewById(R.id.tvAbout);
		aboutString.setText(Html.fromHtml(getString(R.string.nice_about)));
		sendEmail = (Button) findViewById(R.id.bSendEmail);
		sendEmail.setBackgroundColor(Color.GRAY);
		sendEmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*Context context = getApplicationContext();
				CharSequence text = "Sending email";
				int duration = Toast.LENGTH_SHORT;
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();*/
				//Getting device info
				String myDeviceModel = android.os.Build.MODEL;
				String myDeviceVersion = android.os.Build.VERSION.SDK;
				
				String emailMessage ="                        "
						+ '\n'
						+"                                  "
						+"=================================="
						+ " Here is my device information,which should help trouble shooting "
						+ '\n'
						+"Make and Model : " +myDeviceModel
						+ '\n'
						+ "Android API Version : " + myDeviceVersion
						+ '\n'
						+"Uke Tuner Version : 1.1 ";
				//Defining Send email Intent
				Intent emailIntent = new Intent(Intent.ACTION_SEND);
				// The intent does not have a URI, so declare the "text/plain" MIME type
				emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
				emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"candrade.uke@gmail.com"}); // recipients
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Uke Tuner:: ");
				emailIntent.putExtra(Intent.EXTRA_TEXT, emailMessage);
				startActivity(emailIntent);
			}
		});
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	
}
