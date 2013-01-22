package com.dcetech.troika;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;


public class Events extends Activity {
	ScrollView eventsScroller;
	public String[] eventFbPages;
	public String[] eventWebPages;

	public void loadURLs() {
		eventFbPages = getResources().getStringArray(R.array.event_fb_pages);
		eventWebPages = getResources().getStringArray(R.array.event_web_pages);
	}
	
	public void goToFb (String uri) {
		try {
		Uri fbUri = Uri.parse(uri);
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
	public void goToWeb (String uri) {
		Uri webUri = Uri.parse(uri);
        Intent launchWeb = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(launchWeb);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		
		loadURLs();
		eventsScroller=((ScrollView) findViewById(R.id.eventsScroller));
		eventsScroller.postDelayed(new Runnable() {
	        @Override
	        public void run() {
	        	eventsScroller.fling(2200);
	        	eventsScroller.fling(600);
	        	eventsScroller.fling(900);
	        }
	    }, 1000);
		eventsScroller.postDelayed(new Runnable() {
	        @Override
	        public void run() {
	        	eventsScroller.fling(-1100);
	        	eventsScroller.fling(-400);
	        	eventsScroller.fling(-700);
	        }
	    }, 2000);
		
		ImageView BITS = (ImageView) findViewById(R.id.imageBITS);
		BITS.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[1]);
	        }
	    });
		BITS.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[1]);
	        	return true;
	        }
	    });
		
        ImageView BOTS = (ImageView) findViewById(R.id.imageBOTS);
		BOTS.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[2]);
	        }
	    });
		BOTS.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[2]);
	        	return true;
	        }
	    });
		
        ImageView BRAINWAVE = (ImageView) findViewById(R.id.imageBRAINWAVE);
		BRAINWAVE.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[3]);
	        }
	    });
		BRAINWAVE.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[3]);
	        	return true;
	        }
	    });
		
        ImageView BULLSBEARS = (ImageView) findViewById(R.id.imageBULLSBEARS);
		BULLSBEARS.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[4]);
	        }
	    });
		BULLSBEARS.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[4]);
	        	return true;
	        }
	    });
		
        ImageView BYTES = (ImageView) findViewById(R.id.imageBYTES);
		BYTES.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[5]);
	        }
	    });
		BYTES.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[5]);
	        	return true;
	        }
	    });
		
        ImageView DESIGNPRO = (ImageView) findViewById(R.id.imageDESIGNPRO);
		DESIGNPRO.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[6]);
	        }
	    });
		DESIGNPRO.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[6]);
	        	return true;
	        }
	    });
		
        ImageView ELECTROCUTION = (ImageView) findViewById(R.id.imageELECTROCUTION);
		ELECTROCUTION.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[7]);
	        }
	    });
		ELECTROCUTION.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[7]);
	        	return true;
	        }
	    });
		
        ImageView ENVISION = (ImageView) findViewById(R.id.imageENVISION);
		ENVISION.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[8]);
	        }
	    });
		ENVISION.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[8]);
	        	return true;
	        }
	    });
		
        ImageView ETHERAVATAR = (ImageView) findViewById(R.id.imageETHERAVATAR);
		ETHERAVATAR.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[9]);
	        }
	    });
		ETHERAVATAR.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[9]);
	        	return true;
	        }
	    });
		
        ImageView JUNKYARD = (ImageView) findViewById(R.id.imageJUNKYARD);
		JUNKYARD.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[10]);
	        }
	    });
		JUNKYARD.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[10]);
	        	return true;
	        }
	    });
		
        ImageView MIST = (ImageView) findViewById(R.id.imageMIST);
		MIST.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[11]);
	        }
	    });
		MIST.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[11]);
	        	return true;
	        }
	    });
		
        ImageView RADIX = (ImageView) findViewById(R.id.imageRADIX);
		RADIX.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[12]);
	        }
	    });
		RADIX.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[12]);
	        	return true;
	        }
	    });
		
        ImageView SPAC = (ImageView) findViewById(R.id.imageSPAC);
		SPAC.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[13]);
	        }
	    });
		SPAC.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[13]);
	        	return true;
	        }
	    });
		
        ImageView TECHNOVISION = (ImageView) findViewById(R.id.imageTECHNOVISION);
		TECHNOVISION.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[14]);
	        }
	    });
		TECHNOVISION.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[14]);
	        	return true;
	        }
	    });
		
        ImageView TODOENUNO = (ImageView) findViewById(R.id.imageTODOENUNO);
		TODOENUNO.setOnClickListener (new View.OnClickListener() { 
	        public void onClick(View v) {
	        	goToFb(eventWebPages[15]);
	        }
	    });
		TODOENUNO.setOnLongClickListener (new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	goToFb(eventFbPages[15]);
	        	return true;
	        }
	    });
		
		RunCounters EventRun = ((RunCounters)getApplicationContext());
		if (!(EventRun.HasEventRun())) {
		final Toast eventChooser = Toast.makeText(Events.this, "Click on any event to visit event website.\n\nLong-press on event to go to Facebook page", Toast.LENGTH_LONG);
		eventChooser.setGravity(Gravity.CENTER, eventChooser.getXOffset() / 2, eventChooser.getYOffset() / 2);
		new CountDownTimer(2000, 1000)
		{

		    public void onTick(long millisUntilFinished) {eventChooser.show();}
		    public void onFinish() {eventChooser.show();}

		}.start();
		}
		EventRun.RunEvent();

	}
	

/*	@Override
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
    }*/
	
	@Override
	public void onBackPressed() {
		Intent mainpage = new Intent(Events.this, MainPage.class);
        startActivity(mainpage);
        finish();

	}
	
}
