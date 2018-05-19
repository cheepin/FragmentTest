package com.example.fujit.fragmenttest;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TableViewAdapter extends FragmentPagerAdapter
{
    private Context context;

    public TableViewAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        Tab tab = new Tab();
        //引数設定
        Bundle bundle = new Bundle();
        bundle.putInt(Tab.index, position);
        tab.setArguments(bundle);
        return tab;
    }

    @Override
    public int getCount()
    {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        return databaseHelper.getMaxListCount();
    }


}
