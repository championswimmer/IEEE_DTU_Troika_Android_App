package com.dcetech.troika;

import java.util.ArrayList;
import java.util.List;
import android.app.Application;

public class RunCounters extends Application {
	
	private int MainRunCounter = 0;
	public int EventRunCounter = 0;
	public int ContactRunCounter = 0;
	
	public boolean HasMainRun (){
		if (MainRunCounter == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	public void RunMain () {
		MainRunCounter++;
	}

	public boolean HasEventRun (){
		if (EventRunCounter == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	public void RunEvent () {
		EventRunCounter++;
	}

	public boolean HasContactRun (){
		if (ContactRunCounter == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	public void RunContact () {
		ContactRunCounter++;
	}
	
	public void ResetCounters () {
		MainRunCounter = 0;
		//EventRunCounter = 0;
		//ContactRunCounter = 0;
	}

}
