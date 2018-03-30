package com.atempa.dam18_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

public class MyArrayAdapter extends ArrayAdapter {

    public MyArrayAdapter(@NonNull Context context, int textViewResourceId, @NonNull String[] objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public boolean hasStableIds() {
        return super.hasStableIds();
    }
}
