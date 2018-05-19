package com.example.fujit.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class TableView extends Fragment
{
    private ViewPager myViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_table_view, container, false);

        myViewPager = layout.findViewById(R.id.myTab);
        TableViewAdapter tableViewAdapter = new TableViewAdapter(getActivity().getSupportFragmentManager(), getActivity());
        myViewPager.setAdapter(tableViewAdapter);

        return layout;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener)
    {
        myViewPager.addOnPageChangeListener(listener);
    }


}
