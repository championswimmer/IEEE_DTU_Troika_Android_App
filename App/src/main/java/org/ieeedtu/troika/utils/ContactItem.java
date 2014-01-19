package org.ieeedtu.troika.utils;

import android.content.Context;

import org.ieeedtu.troika.R;

/**
 * Created by championswimmer on 20/1/14.
 */
public class ContactItem {
    public String[] cTitle;
    public String[] cName;
    public String[] cEmail;
    public String[] cPhone;


    public ContactItem(Context context) {
        cTitle = context.getResources().getStringArray(R.array.contact_title);
        cName = context.getResources().getStringArray(R.array.contact_name);
        cEmail = context.getResources().getStringArray(R.array.contact_email);
        cPhone = context.getResources().getStringArray(R.array.contact_phone);
    }

    public int getLength() {
        return cTitle.length;
    }

    public int getFields() {
        return 3;
    }

    public String[] getChild(int i) {
        String[] singleContact = new String[4];
        singleContact[0] = cTitle[i];
        singleContact[1] = cName[i];
        singleContact[3] = cEmail[i];
        singleContact[2] = cPhone[i];
        return singleContact;
    }
}
