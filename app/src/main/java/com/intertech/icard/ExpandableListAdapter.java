package com.intertech.icard;

import java.util.List;
import java.util.Map;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ExpandableListAdapters extends BaseExpandableListAdapter {

    private Activity context;
    private Map<String, List<String>> laptopCollections;
    private List<String> laptops;

    public ExpandableListAdapters(Activity context, List<String> laptops,
                                 Map<String, List<String>> laptopCollections) {
        this.context = context;
        this.laptopCollections = laptopCollections;
        this.laptops = laptops;
    }

    public Object getChild(int groupPosition, int childPosition) {
        return laptopCollections.get(laptops.get(groupPosition)).get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String laptop = (String) getChild(groupPosition, childPosition);
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_installment_child, null);
        }

        ((TextView) convertView.findViewById(R.id.child_date)).setText(laptop.split(",")[0].substring(0,35));

        ((TextView) convertView.findViewById(R.id.child_money)).setText(laptop.split(",")[2]+" ₺");
        ((TextView) convertView.findViewById(R.id.child_detail_1)).setText(laptop.split(",")[4].replace("T"," "));
        ((TextView) convertView.findViewById(R.id.child_detail_2)).setText(laptop.split(",")[1]+"/"+laptop.split(",")[3]);

        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        return laptopCollections.get(laptops.get(groupPosition)).size();
    }

    public Object getGroup(int groupPosition) {
        return laptops.get(groupPosition);
    }

    public int getGroupCount() {
        return laptops.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String laptopName = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_installment,
                    null);
        }
        TextView item = (TextView) convertView.findViewById(R.id.parent_date);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(laptopName.split("/")[0]);

        TextView item2 = (TextView) convertView.findViewById(R.id.parent_money);
        item2.setTypeface(null, Typeface.BOLD);
        item2.setText(laptopName.split("/")[1]);
        return convertView;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}