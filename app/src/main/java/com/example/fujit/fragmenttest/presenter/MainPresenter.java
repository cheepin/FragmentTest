package com.example.fujit.fragmenttest.presenter;

import android.support.v4.view.ViewPager;

import com.example.fujit.fragmenttest.TaskViewer.View.TableViewInterface;
import com.example.fujit.fragmenttest.model.ToDoButtonDAO;
import com.example.fujit.fragmenttest.view.ViewInterface;

public class MainPresenter implements PresenterInterface
{
    private  ToDoButtonDAO dao;
    private int nowPage = 0;

    public MainPresenter(ViewInterface view)
    {
        dao = new ToDoButtonDAO(view.getContext());

    }

    @Override
    public void setOnPageChangeListener(TableViewInterface viewPager)
    {
        viewPager.setOnPageChangeListenerOnCreate(new ViewPager.SimpleOnPageChangeListener()
        {

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
        dao.DeleteList(nowPage);
        nowPage = 0;
    }

    @Override
    public int getNowPage()
    {
        return nowPage;
    }


}
