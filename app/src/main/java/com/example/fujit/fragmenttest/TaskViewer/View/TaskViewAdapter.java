package com.example.fujit.fragmenttest.TaskViewer.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.fujit.fragmenttest.TaskViewer.Presenter.TaskPresenterInterface;

public class TaskViewAdapter extends FragmentStatePagerAdapter
{
    TaskPresenterInterface presenter;

    public TaskViewAdapter(FragmentManager fm, TaskPresenterInterface presenter)
    {
        super(fm);
        this.presenter = presenter;
    }

    @Override
    public Fragment getItem(int position)
    {
        return presenter.createTaskPage(position);
    }

    @Override
    public int getCount()
    {
        return presenter.getMaxListNumber();
    }


}
