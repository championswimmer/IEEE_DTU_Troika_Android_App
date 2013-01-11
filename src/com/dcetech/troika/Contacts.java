package com.dcetech.troika;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.QuickContactBadge;
import android.util.Log;
import android.database.Cursor;
import android.content.ContextWrapper;


public class Contacts extends Activity {

	public static final int INSERT_CONTACT_REQUEST = 100;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
	}
	
	

	public void addContactChairman (View view) {
    	Intent addContact = new Intent(Intent.ACTION_INSERT);
		addContact.setType(ContactsContract.Contacts.CONTENT_TYPE);
		addContact.putExtra(ContactsContract.Intents.Insert.NAME, "Ishaan Malhotra");
		addContact.putExtra(ContactsContract.Intents.Insert.ACTION, "Ishaan Malhotra");
		addContact.putExtra(ContactsContract.Intents.Insert.PHONE, "+91-7838002865");
		addContact.putExtra(ContactsContract.Intents.Insert.EMAIL, "ishaanmalhotra22@gmail.com");
		startActivityForResult(addContact, INSERT_CONTACT_REQUEST);
	}
	public void addContactViceChairman (View view) {
		Intent addContact = new Intent(Intent.ACTION_INSERT);
		addContact.setType(ContactsContract.Contacts.CONTENT_TYPE);
		addContact.putExtra(ContactsContract.Intents.Insert.NAME, "Aseem Sayal");
		addContact.putExtra(ContactsContract.Intents.Insert.PHONE, "+91-9871905960");
		addContact.putExtra(ContactsContract.Intents.Insert.EMAIL, "aseem.sayal@gmail.com");
		startActivityForResult(addContact, INSERT_CONTACT_REQUEST);
	}
	public void addContactHeadCorpo (View view) {
		Intent addContact = new Intent(Intent.ACTION_INSERT);
		addContact.setType(ContactsContract.Contacts.CONTENT_TYPE);
		addContact.putExtra(ContactsContract.Intents.Insert.NAME, "Anantika Gupta");
		addContact.putExtra(ContactsContract.Intents.Insert.PHONE, "+91-9971611442");
		addContact.putExtra(ContactsContract.Intents.Insert.EMAIL, "anantikag@gmail.com");
		startActivityForResult(addContact, INSERT_CONTACT_REQUEST);
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
