package com.dcetech.troika;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
		Uri fbUri = Uri.parse(getResources().getString(R.string.troika_fb_page));
        Intent launchFb = new Intent(Intent.ACTION_VIEW, fbUri);
        startActivity(launchFb);
	}
	public void goToWeb (View view) {
		Uri webUri = Uri.parse(getResources().getString(R.string.troika_web_page));
        Intent launchWeb = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(launchWeb);
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

				
			}

		}.start();
		}
		else {
			setContentView(R.layout.activity_main_page);
		}
		
		backPress = 0;
		MainRun.RunMain();
	
	}
/*
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
            	Intent contacts = new Intent(MainPage.this, Contacts.class);
                startActivity(contacts);
                finish();
            	return true;
            case R.id.menu_events:
            	Intent events = new Intent(MainPage.this, Events.class);
                startActivity (events);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
*/    
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
