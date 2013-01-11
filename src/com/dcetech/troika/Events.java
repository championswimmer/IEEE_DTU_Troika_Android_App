package com.dcetech.troika;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;


public class Events extends Activity {
	HorizontalScrollView eventsScroller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		
		eventsScroller=((HorizontalScrollView) findViewById(R.id.eventsScroller));
		eventsScroller.postDelayed(new Runnable() {
	        @Override
	        public void run() {
	        	eventsScroller.fling(3200);
	        	eventsScroller.fling(900);
	        	eventsScroller.fling(1500);
	        }
	    }, 1000);
		eventsScroller.postDelayed(new Runnable() {
	        @Override
	        public void run() {
	        	eventsScroller.fling(-1700);
	        	eventsScroller.fling(-800);
	        	eventsScroller.fling(-1100);
	        }
	    }, 2000);
		eventsScroller.postDelayed(new Runnable() {
	        @Override
	        public void run() {
	        	eventsScroller.fling(1800);
	        	eventsScroller.fling(1300);
	        	eventsScroller.fling(600);
	        }
	    }, 3000);
		eventsScroller.postDelayed(new Runnable() {
	        @Override
	        public void run() {
	        	eventsScroller.fling(-1200);
	        	eventsScroller.fling(-500);
	        	eventsScroller.fling(-100);
	        }
	    }, 4000);
	
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
            	Intent contacts = new Intent(Events.this, Contacts.class);
                startActivity(contacts);
                finish();
            	return true;
            case R.id.menu_events:
            	Intent events = new Intent(Events.this, Events.class);
                startActivity (events);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
	
	@Override
	public void onBackPressed() {
		Intent mainpage = new Intent(Events.this, MainPage.class);
        startActivity(mainpage);
        finish();

	}
	
}
