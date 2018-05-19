package com.example.fujit.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.fujit.fragmenttest.view.TableViewInterface;

import java.util.ArrayList;
import java.util.List;


public class TableView extends Fragment implements TableViewInterface
{
    private ViewPager myViewPager;
    private List<ViewPager.OnPageChangeListener> listenerList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_table_view, container, false);

        myViewPager = layout.findViewById(R.id.myTab);
        TableViewAdapter tableViewAdapter = new TableViewAdapter(getActivity().getSupportFragmentManager(), getActivity());
        myViewPager.setAdapter(tableViewAdapter);

        for(ViewPager.OnPageChangeListener  listener : listenerList)
        {
            myViewPager.addOnPageChangeListener(listener);
        }

        return layout;
    }


    /*
        OnCreateViewでPageChangerにリスナーを登録
    */
    @Override
    public void setOnPageChangeListenerOnCreate(ViewPager.OnPageChangeListener listener)
    {
        listenerList.add(listener);

    }


}
