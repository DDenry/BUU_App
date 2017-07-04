package com.dr.rui.sotired.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.List;

/**
 * Created by rui on 2017-05-09.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private List<Drawable> groupArray;
    private List<List<String>> childArray;
    private Context context;

    public ExpandableAdapter(Context context, List<Drawable> groupArray, List<List<String>> childArray) {
        this.context = context;
        this.groupArray = groupArray;
        this.childArray = childArray;
    }

    @Override
    public int getGroupCount() {
        return groupArray.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childArray.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupArray.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childArray.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class GroupHolder {
    }

    private class ChildHolder {
    }
}
