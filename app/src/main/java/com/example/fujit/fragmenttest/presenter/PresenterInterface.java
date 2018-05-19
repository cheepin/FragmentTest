package com.example.fujit.fragmenttest.presenter;

import android.support.v4.view.ViewPager;

import com.example.fujit.fragmenttest.view.TableViewInterface;


@SuppressWarnings("unused")
public interface PresenterInterface
{
    void setOnPageChangeListener(TableViewInterface fragment);
    void onDeleteButton();
    int  getNowPage();
}
