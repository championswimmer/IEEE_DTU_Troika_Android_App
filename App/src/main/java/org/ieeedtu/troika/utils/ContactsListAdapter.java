package org.ieeedtu.troika.utils;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import org.ieeedtu.troika.R;

import java.security.acl.Group;

/**
 * Created by championswimmer on 20/1/14.
 */
public class ContactsListAdapter extends BaseExpandableListAdapter {

    private final ContactItem contact;
    public LayoutInflater inflater;
    public Activity activity;

    public ContactsListAdapter(Activity act, ContactItem c) {
        activity = act;
        contact = c;
        inflater = act.getLayoutInflater();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        switch (childPosition) {
            case 0:
                return contact.cName[groupPosition];
            case 1:
                return contact.cEmail[groupPosition];
            case 2:
                return contact.cPhone[groupPosition];
        }
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String children = (String) getChild(groupPosition, childPosition);
        TextView text = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_contacts_details, null);
        }
        text = (TextView) convertView.findViewById(R.id.contact_details_email);
        text.setText(children);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (groupPosition>2) {
            return 3;
        } else {
            return 2;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return contact.cTitle[groupPosition];
    }

    @Override
    public int getGroupCount() {
        return contact.getLength();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_contacts_title, null);
        }
        ((TextView) convertView).setText(contact.cTitle[groupPosition]);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}