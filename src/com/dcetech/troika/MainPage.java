package com.dcetech.troika;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainPage extends Activity {
	
	public int backPress;
	private Dialog dialog;
	
	public void goToEvents (View view) {
		Intent events = new Intent(MainPage.this, Events.class);
        startActivity (events);
        finish();
	}
	public void goToContacts (View view) {
		Intent contacts = new Intent(MainPage.this, Contacts.class);
        startActivity(contacts);
        finish();
	}
	public void goToFb (View view) {
		try {
		Uri fbUri = Uri.parse(getResources().getString(R.string.troika_fb_page));
        Intent launchFb = new Intent(Intent.ACTION_VIEW, fbUri);
        startActivity(launchFb);
		}
		catch (Exception e) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			  builder.setMessage("The Facebook app is needed to visit facebook pages");
			  AlertDialog alert = builder.create();
			  alert.show();

		}
	}
	public void goToWeb (View view) {
		Uri webUri = Uri.parse(getResources().getString(R.string.troika_web_page));
        Intent launchWeb = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(launchWeb);
	}
	
	public void launchVideo(boolean play) {
		VideoView myVideoView = (VideoView)MainPage.this.findViewById(R.id.videoViewTeaser);
        MediaController mediaController = new MediaController(MainPage.this);
        try{
            String vidpath = "android.resource://" + getPackageName() + "/" + R.raw.troika_teaser;
            Log.d("TROIKA", vidpath);
            myVideoView.setVideoURI(Uri.parse(vidpath));
            myVideoView.setMediaController(mediaController);
            if (play) {
                myVideoView.requestFocus();
                myVideoView.start();
            }
            else {
            	myVideoView.seekTo(122000);
            }
        }
        catch (Exception e){
        	
        	Log.d("TROIKA", "no video");
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }



	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		

		RunCounters MainRun = ((RunCounters)getApplicationContext());
		if (!(MainRun.HasMainRun())) {
		new CountDownTimer(3000, 1000)
		{
		    @Override
			public void onTick(long millisUntilFinished) {
				setContentView(R.layout.splash_screen);

				
			}
			@Override
			public void onFinish() {
				setContentView(R.layout.activity_main_page);
				launchVideo(true);
			}

		}.start();
		}
		else {
			setContentView(R.layout.activity_main_page);
			launchVideo(false);
		}


		
		backPress = 0;
		MainRun.RunMain();
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_page, menu);
		return true;
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_contacts:
            	showAbout();
            	return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
 
	public Toast exiter;
   
    @Override
	public void onBackPressed() {
    	backPress++;
    	switch (backPress){
    	case 1: {
    		exiter = Toast.makeText(MainPage.this, "Press back again to exit", Toast.LENGTH_SHORT);
    		exiter.show();
    		break;    		
    	}
       	case 2:{
       		finish();
    		break;
    	}
    	}
    }
    
    private void showAbout(){
    	dialog = new Dialog(MainPage.this);
		dialog.setContentView(R.layout.about);
		dialog.setTitle("About");
		dialog.show();
    }
}
