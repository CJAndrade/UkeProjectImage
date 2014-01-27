package cja.ukeimage.com;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class UkeProjectImageActivity extends Activity { //implements OnClickListener
    /** Called when the activity is first created. */
	ToggleButton tbG,tbC,tbE,tbA,tbAll;
	Button stopButton;
	TextView stringTuned;
	AnalogClock analogClock;
	ProgressBar timer;
	//MediaPlayer mp;
	//int explosion;
	//SoundPool sp;
	//MediaPlayer mediaPlayer;
	MediaPlayer mediaPlayerG,mediaPlayerC,mediaPlayerE,mediaPlayerA,mediaPlayerAll;
	//boolean isChecked;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.main);
       // sp= new SoundPool(5,AudioManager.STREAM_MUSIC,0);
		//explosion = sp.load(this,R.raw.explosion, 1);
    	tbG = (ToggleButton) findViewById(R.id.tbG);
		tbC = (ToggleButton) findViewById(R.id.tbC);
		tbE = (ToggleButton) findViewById(R.id.tbE);
		tbA = (ToggleButton) findViewById(R.id.tbA);
		tbAll = (ToggleButton) findViewById(R.id.tbAll);
		
		//timer = (ProgressBar) findViewById(R.id.pbTimer);
		stopButton = (Button) findViewById(R.id.bStop);
		stringTuned = (TextView) findViewById(R.id.tvString);
		//analogClock = (AnalogClock) findViewById(R.id.analogClock);
		
		mediaPlayerG = MediaPlayer.create(getBaseContext(), R.raw.gchord);
		mediaPlayerC = MediaPlayer.create(getBaseContext(), R.raw.cchord);
		mediaPlayerE = MediaPlayer.create(getBaseContext(), R.raw.echord);
		mediaPlayerA = MediaPlayer.create(getBaseContext(), R.raw.achord);
		mediaPlayerAll = MediaPlayer.create(getBaseContext(), R.raw.allchords);
		
		stopButton.setVisibility(View.INVISIBLE);
		stringTuned.setText(" ");
		
		stopButton.setOnClickListener(new View.OnClickListener() {
			
	   		public void onClick(View v) {
	   			// TODO Auto-generated method stub
	   			//tbC.setChecked(!isChecked);
	   			//tbG.setChecked(!isChecked);
					//timer.
		   			//if(mediaPlayer.isPlaying() == true)
		   			//{
	   			

	    		
		   		    stringTuned.setText(" ");
		   			mediaPlayerG.setLooping(false);
		   			mediaPlayerG.pause();  //BUG//if you hit stop first there is a stack trace error.
		   			mediaPlayerC.setLooping(false);
		   			mediaPlayerC.pause(); 
		   			mediaPlayerE.setLooping(false);
		   			mediaPlayerE.pause(); 
		   			mediaPlayerA.setLooping(false);
		   			mediaPlayerA.pause();
		   			mediaPlayerAll.setLooping(false);
		   			mediaPlayerAll.pause(); 
		   			//}
		   			//else
		   			//{
		   			//	stringTuned.setText("STOOPPPcarELSE");
		   			//}
	   			
	   		}
	   	});
		//G string toggle
		tbG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		    	//mediaPlayer.stop();//BUG//there is no activity started the App force closes 
		    	
		    	if (isChecked) {
		    
		    		//mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.explosion);
		            // The toggle is enabled
		    		tbC.setChecked(!isChecked); //BP//not sure if this should be above the mediaplayer star()
		    		tbE.setChecked(!isChecked);
		    		tbA.setChecked(!isChecked);
		    		tbAll.setChecked(!isChecked);
		    		
		    		mediaPlayerG.setLooping(true);//Looping
		    		mediaPlayerG.start();

		    		stopButton.setVisibility(View.VISIBLE);
		    		stringTuned.setText("G Top-Fourth string");  //BUG//Fixed//other button sounds keep playing when this button is hit
		        	
		        } else {
		        	
		            // The toggle is disabled
		        	mediaPlayerG.setLooping(false);
		        	mediaPlayerG.pause();
		        	//mediaPlayer.pause();
		        	stringTuned.setText(" ");
		        	
		        }
		    }
		});	
		
		//C string Toggle
		tbC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		    		
		        if (isChecked) {
		        	
		        	//mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.explosion);
		            // The toggle is enabled
		    		tbG.setChecked(!isChecked); //BP//not sure if this should be above the mediaplayer star()
		    		tbE.setChecked(!isChecked);
		    		tbA.setChecked(!isChecked);
		    		tbAll.setChecked(!isChecked);
		        	
		        	mediaPlayerC.setLooping(true); 
		        	mediaPlayerC.start();
		        	stopButton.setVisibility(View.VISIBLE);
		        	stringTuned.setText("C Third string");
		        } else {
		            // The toggle is disabled
		        	mediaPlayerC.setLooping(false);
		        	//mediaPlayer.pause();
		        	//mediaPlayerC.stop();
		        	mediaPlayerC.pause();
		        	
		        	stringTuned.setText(" ");
		        	
		        }
		    }
		});	
		
		//E string toggle
		
		tbE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		    		
		        if (isChecked) {
		            // The toggle is enabled
		        	//mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.explosion);
		    		tbC.setChecked(!isChecked); //BP//not sure if this should be above the mediaplayer star()
		    		tbG.setChecked(!isChecked);
		    		tbA.setChecked(!isChecked);
		    		tbAll.setChecked(!isChecked);
		    		
		        	mediaPlayerE.setLooping(true); 
		        	mediaPlayerE.start();
		        	stopButton.setVisibility(View.VISIBLE);
		        	stringTuned.setText("E Second string");
		        } else {
		            // The toggle is disabled
		        	mediaPlayerE.setLooping(false); 
		        	//mediaPlayer.pause();
		        	mediaPlayerE.pause();
		        	stringTuned.setText(" ");
		        	
		        }
		    }
		});
		
		//A string toggle
		
		tbA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		    	
		        if (isChecked) {
		        	//mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.explosion);	
		            // The toggle is enabled
		    		tbC.setChecked(!isChecked); //BP//not sure if this should be above the mediaplayer star()
		    		tbE.setChecked(!isChecked);
		    		tbG.setChecked(!isChecked);
		    		tbAll.setChecked(!isChecked);
		    		
		        	mediaPlayerA.setLooping(true); 
		        	mediaPlayerA.start();
		        	stopButton.setVisibility(View.VISIBLE);
		        	stringTuned.setText("A Bottom-First string");
		        } else {
		            // The toggle is disabled
		        	mediaPlayerA.setLooping(false); 
		        	mediaPlayerA.pause();
		        	stringTuned.setText(" ");
		        	
		        }
		    }
		});
		
		//Play All string
		tbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		    		
		    	if (isChecked) {
		            // The toggle is enabled
		    		//mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.explosion);
		    		tbC.setChecked(!isChecked); //BP//not sure if this should be above the mediaplayer star()
		    		tbE.setChecked(!isChecked);
		    		tbA.setChecked(!isChecked);
		    		tbG.setChecked(!isChecked);
		    		
		    		mediaPlayerAll.setLooping(true);
		    		mediaPlayerAll.start();
		    		stopButton.setVisibility(View.VISIBLE);
		        	stringTuned.setText("Play all strings");
		        } else {
		            // The toggle is disabled
		        	mediaPlayerAll.setLooping(false);
		        	mediaPlayerAll.pause();
		        	stringTuned.setText(" ");
		        	
		        }
		    }
		});	
		
	
		
    } //TODO//call the release() at the end of the application
    //TODO//implement error Handling
    


	
	//Add WAKE_LOCK permission to the manifest
	/*
    @Override
	public void onClick(View arg0) {
		switch(arg0.getId()){
		case R.id.bStop:
		stringTuned.setText("STOPPP");
			//sp.play(explosion, 1, 1, 0, 0, 1);
	    break;
		} 	
	}*/
   
    @Override
    protected void onStop() {
       
        mediaPlayerG.stop();
        mediaPlayerC.stop();
        mediaPlayerE.stop();
        mediaPlayerA.stop();
        mediaPlayerAll.stop();
        //mediaPlayer.release();
       super.onStop();
    }
  @Override
  protected void onDestroy() {

        //mediaPlayer.stop();
        mediaPlayerG.release();
        mediaPlayerC.release();
        mediaPlayerE.release();
        mediaPlayerA.release();
        mediaPlayerAll.release();
        
        super.onDestroy();
    }




@Override
protected void onRestart() {
	// TODO Auto-generated method stub

	mediaPlayerG = MediaPlayer.create(getBaseContext(), R.raw.gchord);
	mediaPlayerC = MediaPlayer.create(getBaseContext(), R.raw.cchord);
	mediaPlayerE = MediaPlayer.create(getBaseContext(), R.raw.echord);
	mediaPlayerA = MediaPlayer.create(getBaseContext(), R.raw.achord);
	mediaPlayerAll = MediaPlayer.create(getBaseContext(), R.raw.allchords);
	
	super.onRestart();
}




@Override
public boolean onCreateOptionsMenu(android.view.Menu menu) {
	// TODO Auto-generated method stub
	super.onCreateOptionsMenu(menu); //Deleting the return
    MenuInflater blowUpMenu = getMenuInflater();
    blowUpMenu.inflate(R.menu.uke_menu, menu);
    return true;
}




@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	switch(item.getItemId()){
	case R.id.UkeWiki:
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Ukulele"));
		startActivity(browserIntent);
		break;
	case R.id.UkeAbout:
		Intent i = new Intent("cja.ukeimage.com.ABOUT");
		startActivity(i);
		break;
	}
	return false;
	//return super.onOptionsItemSelected(item);
}


}