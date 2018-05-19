package com.example.fujit.fragmenttest.presenter;

import android.support.v4.view.ViewPager;

import com.example.fujit.fragmenttest.DatabaseHelper;
import com.example.fujit.fragmenttest.view.TableViewInterface;
import com.example.fujit.fragmenttest.view.ViewInterface;

public class MainPresenter implements PresenterInterface
{
    private DatabaseHelper db;
    private ViewInterface view;
    private int nowPage = 0;

    public MainPresenter(ViewInterface view)
    {
        this.view = view;
        db = new DatabaseHelper(this.view.getContext());

    }

    @Override
    public void setOnPageChangeListener(TableViewInterface viewPager)
    {
        viewPager.setOnPageChangeListenerOnCreate(new ViewPager.SimpleOnPageChangeListener()
        {
              @Override
              public void onPageSelected(int position)
              {
                  nowPage = position;
                  System.out.println(nowPage);
              }

        });
    }

    @Override
    public void onDeleteButton()
    {
        db.deleteList(nowPage);
    }

    @Override
    public int getNowPage()
    {
        return nowPage;
    }


}
