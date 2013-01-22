package com.dcetech.troika;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.Toast;
import android.util.Log;
import android.database.Cursor;
import android.content.ContextWrapper;


public class Contacts extends Activity {

	public static final int INSERT_CONTACT_REQUEST = 100;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);

		QuickContactBadge badgeChairman = (QuickContactBadge) findViewById(R.id.quickContactBadgechairman);  
		badgeChairman.assignContactFromPhone("+91-7838002865", true);  
		badgeChairman.setImageResource(R.drawable.ic_contact_chairman);
		
		badgeChairman.setOnLongClickListener(new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	        	Intent addContact = new Intent(Intent.ACTION_INSERT);
	    		addContact.setType(ContactsContract.Contacts.CONTENT_TYPE);
	    		addContact.putExtra(ContactsContract.Intents.Insert.NAME, "Ishaan Malhotra");
	    		addContact.putExtra(ContactsContract.Intents.Insert.PHONE, "+91-7838002865");
	    		addContact.putExtra(ContactsContract.Intents.Insert.EMAIL, "ishaanmalhotra22@gmail.com");
	    		startActivityForResult(addContact, INSERT_CONTACT_REQUEST);
	            return true;
	        }
	    });
		QuickContactBadge badgeViceChairman = (QuickContactBadge) findViewById(R.id.quickContactBadgevicechairman);  
		badgeViceChairman.assignContactFromPhone("+91-9871905960", true);  
		badgeViceChairman.setImageResource(R.drawable.ic_contact_vicechairman);
		
		badgeViceChairman.setOnLongClickListener(new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	    		Intent addContact = new Intent(Intent.ACTION_INSERT);
	    		addContact.setType(ContactsContract.Contacts.CONTENT_TYPE);
	    		addContact.putExtra(ContactsContract.Intents.Insert.NAME, "Aseem Sayal");
	    		addContact.putExtra(ContactsContract.Intents.Insert.PHONE, "+91-9871905960");
	    		addContact.putExtra(ContactsContract.Intents.Insert.EMAIL, "aseem.sayal@gmail.com");
	    		startActivityForResult(addContact, INSERT_CONTACT_REQUEST);
	    		return true;
	        }
	    });

		QuickContactBadge badgeHeadCorpo = (QuickContactBadge) findViewById(R.id.quickContactBadgeheadcorpo);  
		badgeHeadCorpo.assignContactFromPhone("+91-9971611442", true);  
		badgeHeadCorpo.setImageResource(R.drawable.ic_contact_headcorpo);
		
		badgeHeadCorpo.setOnLongClickListener(new View.OnLongClickListener() { 
	        public boolean onLongClick(View v) {
	    		Intent addContact = new Intent(Intent.ACTION_INSERT);
	    		addContact.setType(ContactsContract.Contacts.CONTENT_TYPE);
	    		addContact.putExtra(ContactsContract.Intents.Insert.NAME, "Anantika Gupta");
	    		addContact.putExtra(ContactsContract.Intents.Insert.PHONE, "+91-9971611442");
	    		addContact.putExtra(ContactsContract.Intents.Insert.EMAIL, "anantikag@gmail.com");
	    		startActivityForResult(addContact, INSERT_CONTACT_REQUEST);
	    		return true;
	        }
	    });
		RunCounters ContactRun = ((RunCounters)getApplicationContext());
		if (!(ContactRun.HasContactRun())) {
		final Toast addContacts = Toast.makeText(Contacts.this, "Long-click the contacts images to save to Phonebook \n\nOnce contact is saved, short-click to call/sms/mail", Toast.LENGTH_LONG);
		addContacts.setGravity(Gravity.CENTER, addContacts.getXOffset() / 2, addContacts.getYOffset() / 2);
		new CountDownTimer(2000, 1000)
		{

		    public void onTick(long millisUntilFinished) {addContacts.show();}
		    public void onFinish() {addContacts.show();}

		}.start();
		}
		ContactRun.RunContact();

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
            	Intent contacts = new Intent(Contacts.this, Contacts.class);
                startActivity(contacts);
                finish();
            	return true;
            case R.id.menu_events:
            	Intent events = new Intent(Contacts.this, Events.class);
                startActivity(events);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
*/
	
	@Override
	public void onBackPressed() {
		Intent mainpage = new Intent(Contacts.this, MainPage.class);
        startActivity(mainpage);
        finish();

	}
   
}
