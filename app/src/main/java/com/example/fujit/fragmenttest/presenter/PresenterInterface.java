package com.example.fujit.fragmenttest.presenter;

import com.example.fujit.fragmenttest.TaskViewer.View.TableViewInterface;


@SuppressWarnings("unused")
public interface PresenterInterface
{
    void setOnPageChangeListener(TableViewInterface fragment);
    void onDeleteButton();
    int  getNowPage();
}
