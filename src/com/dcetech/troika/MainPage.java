package com.dcetech.troika;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MainPage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
	
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
            	Intent contacts = new Intent(MainPage.this, Contacts.class);
                startActivity(contacts);
                finish();
            	return true;
            case R.id.menu_events:
            	Intent mainpage = new Intent(MainPage.this, MainPage.class);
                startActivity(mainpage);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
	public void onBackPressed() {
		finish();
    }
}
