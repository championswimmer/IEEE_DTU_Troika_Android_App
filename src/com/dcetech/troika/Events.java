package com.dcetech.troika;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class Events extends Activity {
	HorizontalScrollView eventsScroller;
	ViewFlipper eventViewer;
	public int eventOpt = 0;
	public String[] eventFbPages;
	public String[] eventWebPages;
	View ButtonBar;
	
	public void loadURLs() {
		eventFbPages = getResources().getStringArray(R.array.event_fb_pages);
		eventWebPages = getResources().getStringArray(R.array.event_web_pages);
	}
	public void viewInflater (int opt) {
    	eventOpt = opt;
    	eventViewer.setDisplayedChild(opt);
    	ButtonBar.setVisibility(View.VISIBLE);
	}

	public void goToFb (String uri) {
		Uri fbUri = Uri.parse(uri);
        Intent launchFb = new Intent(Intent.ACTION_VIEW, fbUri);
        startActivity(launchFb);
	}
	public void goToWeb (String uri) {
		Uri webUri = Uri.parse(uri);
        Intent launchWeb = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(launchWeb);
	}
	public void onClickFb (View view) {
		goToFb(eventFbPages[eventOpt]);
	}
	public void onClickWeb (View view) {
		goToWeb(eventWebPages[eventOpt]);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		
		loadURLs();
		ButtonBar = (View) findViewById(R.id.ButtonBar);
		ButtonBar.setVisibility(View.GONE);
		
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
		
		eventViewer =(ViewFlipper) findViewById(R.id.viewFlipperEvents);
		ImageView BITS = (ImageView) findViewById(R.id.imageBITS);
		BITS.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(1);
	        }
	    });
        ImageView BOTS = (ImageView) findViewById(R.id.imageBOTS);
		BOTS.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(2);
	        }
	    });
        ImageView BRAINWAVE = (ImageView) findViewById(R.id.imageBRAINWAVE);
		BRAINWAVE.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(3);
	        }
	    });
        ImageView BULLSBEARS = (ImageView) findViewById(R.id.imageBULLSBEARS);
		BULLSBEARS.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(4);
	        }
	    });
        ImageView BYTES = (ImageView) findViewById(R.id.imageBYTES);
		BYTES.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(5);
	        }
	    });
        ImageView DESIGNPRO = (ImageView) findViewById(R.id.imageDESIGNPRO);
		DESIGNPRO.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(6);
	        }
	    });
        ImageView ELECTROCUTION = (ImageView) findViewById(R.id.imageELECTROCUTION);
		ELECTROCUTION.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(7);
	        }
	    });
        ImageView ENVISION = (ImageView) findViewById(R.id.imageENVISION);
		ENVISION.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(8);
	        }
	    });
        ImageView ETHERAVATAR = (ImageView) findViewById(R.id.imageETHERAVATAR);
		ETHERAVATAR.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(9);
	        }
	    });
        ImageView JUNKYARD = (ImageView) findViewById(R.id.imageJUNKYARD);
		JUNKYARD.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(10);
	        }
	    });
        ImageView MIST = (ImageView) findViewById(R.id.imageMIST);
		MIST.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(11);
	        }
	    });
        ImageView RADIX = (ImageView) findViewById(R.id.imageRADIX);
		RADIX.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(12);
	        }
	    });
        ImageView SPAC = (ImageView) findViewById(R.id.imageSPAC);
		SPAC.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(13);
	        }
	    });
        ImageView TECHNOVISION = (ImageView) findViewById(R.id.imageTECHNOVISION);
		TECHNOVISION.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(14);
	        }
	    });
        ImageView TODOENUNO = (ImageView) findViewById(R.id.imageTODOENUNO);
		TODOENUNO.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	viewInflater(15);
	        }
	    });

		final Toast eventChooser = Toast.makeText(Events.this, "Click on any event from the topbar to see details.\n\nYou can visit the event's facebook page or website", Toast.LENGTH_LONG);
		eventChooser.setGravity(Gravity.CENTER, eventChooser.getXOffset() / 2, eventChooser.getYOffset() / 2);
		new CountDownTimer(2000, 1000)
		{

		    public void onTick(long millisUntilFinished) {eventChooser.show();}
		    public void onFinish() {eventChooser.show();}

		}.start();

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
