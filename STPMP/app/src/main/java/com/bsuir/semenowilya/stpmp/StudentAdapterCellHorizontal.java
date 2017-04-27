package com.bsuir.semenowilya.stpmp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by semenow on 4/27/17.
 */

public class StudentAdapterCellHorizontal extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList mDataSource;

    public StudentAdapterCellHorizontal(Context context, ArrayList items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        Student student = (Student) getItem(position);
        View rowView = mInflater.inflate(R.layout.student_list_item, viewGroup, false);

        TextView firstName = (TextView) rowView.findViewById(R.id.firstName);
        TextView lastName = (TextView) rowView.findViewById(R.id.lastName);

        firstName.setText(student.firstName);
        lastName.setText(student.lastName);

        return rowView;
    }
}
