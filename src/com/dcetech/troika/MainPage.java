package com.dcetech.troika;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainPage extends Activity {
	
	public int backPress;

	
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
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
        }



	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		final RunCounters MainRun = ((RunCounters)getApplicationContext());
		
		AlertDialog.Builder mist_builder = new AlertDialog.Builder(this);
		mist_builder.setTitle(R.string.mist_about);
		mist_builder.setMessage(R.string.mist_about_content);
		mist_builder.setCancelable(false);
		mist_builder.setPositiveButton("Don't show again", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MainRun.SeenMist();
                launchVideo(true);
            }
        });
		mist_builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	launchVideo(true);
                // Keep seeing this dialog and the video until you get smart enough to click the other option
            }
        });
		  final AlertDialog mist_alert = mist_builder.create();
		  
		  
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
				if (!(MainRun.HasSeenMist())) {
					  mist_alert.show();
					  }
				else {
					launchVideo(true);
				}
				
			}

		}.start();
		}
		else {
			if (!(MainRun.HasSeenMist())) {
				  mist_alert.show();
				  }
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
            case R.id.menu_about:
            	AlertDialog.Builder mist_builder = new AlertDialog.Builder(this);
        		mist_builder.setTitle("TROIKA 2013\nby IEEE DTU");
        		mist_builder.setMessage("TROIKA, a chariot drawn by three horses abreast, is a quintessential symbol of progress and advancement. Everything about TROIKA, the annual technological fiesta of IEEE DTU, while glittering in full glory, offers something even superior to gold- a purpose. This is the higher purpose of discovering oneness with the aim of advancing humanity through the path of science and technology. It seeks to celebrate the inquisitive nature of human mind, man’s curiosity and his heart’s perseverance to find answers that made the world what it is today, the tendency of human soul which yearns to answer the question “Why?” The answer is rubber dinghy rapids, every time it is pitted against the seemingly infallible. Enthusing life in science aficionados and stirring their souls for almost two decades, such a higher purpose forms the strong foundation of TROIKA. Come. Celebrate with TROIKA 2013. And be a part of the legacy!");
        		mist_builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        		AlertDialog mist_alert = mist_builder.create();
            	mist_alert.show();
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
}
