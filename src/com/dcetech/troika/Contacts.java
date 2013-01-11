package com.dcetech.troika;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.QuickContactBadge;
import android.util.Log;

public class Contacts extends Activity {

	public static final int INSERT_CONTACT_REQUEST = 100;

	public void addContactChairman (View view) {
		Intent contactChairman = new Intent(Intent.ACTION_INSERT);
		contactChairman.setType(ContactsContract.Contacts.CONTENT_TYPE);
		contactChairman.putExtra(ContactsContract.Intents.Insert.NAME, "Ishaan Malhotra");
		contactChairman.putExtra(ContactsContract.Intents.Insert.PHONE, "+91-7838002865");
		contactChairman.putExtra(ContactsContract.Intents.Insert.EMAIL, "ishaanmalhotra22@gmail.com");
		startActivityForResult(contactChairman, INSERT_CONTACT_REQUEST);
	}
	public void addContactViceChairman (View view) {
		Intent contactChairman = new Intent(Intent.ACTION_INSERT);
		contactChairman.setType(ContactsContract.Contacts.CONTENT_TYPE);
		contactChairman.putExtra(ContactsContract.Intents.Insert.NAME, "Aseem Sayal");
		contactChairman.putExtra(ContactsContract.Intents.Insert.PHONE, "+91-9871905960");
		contactChairman.putExtra(ContactsContract.Intents.Insert.EMAIL, "aseem.sayal@gmail.com");
		startActivityForResult(contactChairman, INSERT_CONTACT_REQUEST);
	}
	public void addContactHeadCorpo (View view) {
		Intent contactChairman = new Intent(Intent.ACTION_INSERT);
		contactChairman.setType(ContactsContract.Contacts.CONTENT_TYPE);
		contactChairman.putExtra(ContactsContract.Intents.Insert.NAME, "Anantika Gupta");
		contactChairman.putExtra(ContactsContract.Intents.Insert.PHONE, "+91-9971611442");
		contactChairman.putExtra(ContactsContract.Intents.Insert.EMAIL, "anantikag@gmail.com");
		startActivityForResult(contactChairman, INSERT_CONTACT_REQUEST);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
/*		QuickContactBadge badgeChairman = (QuickContactBadge) findViewById(R.id.quickContactBadgechairman);  
		badgeChairman.assignContactFromPhone("+91-7838002865", false);
		badgeChairman.assignContactFromEmail("ishaanmalhotra22@gmail.com", true);
		badgeChairman.setImageResource(R.drawable.ic_contact_chairman);
		badgeChairman.setMode(ContactsContract.QuickContact.MODE_SMALL);*/
		
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
            	Intent contacts = new Intent(Contacts.this, Contacts.class);
                startActivity(contacts);
                finish();
            	return true;
            case R.id.menu_events:
            	Intent mainpage = new Intent(Contacts.this, MainPage.class);
                startActivity(mainpage);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

	
	@Override
	public void onBackPressed() {
		Intent mainpage = new Intent(Contacts.this, MainPage.class);
        startActivity(mainpage);
        finish();

	}
   
}
