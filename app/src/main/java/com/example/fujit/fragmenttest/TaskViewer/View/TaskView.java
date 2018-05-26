package com.example.fujit.fragmenttest.TaskViewer.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.fujit.fragmenttest.R;
import com.example.fujit.fragmenttest.TaskViewer.Presenter.TaskPresenterImpl;
import com.example.fujit.fragmenttest.TaskViewer.Presenter.TaskPresenterInterface;

import java.util.ArrayList;
import java.util.List;


public class TaskView extends Fragment implements TableViewInterface
{
    private ViewPager myViewPager;
    private List<ViewPager.OnPageChangeListener> listenerList = new ArrayList<>();
    private TaskPresenterInterface presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //プレゼンター生成
        presenter = new TaskPresenterImpl(getContext());

        //レイアウト抽出
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_table_view, container, false);
        myViewPager = layout.findViewById(R.id.myTab);

        //pagerアダプターをセット
        myViewPager.setAdapter(new TaskViewAdapter(getActivity().getSupportFragmentManager(),presenter));

        //リスナーをセット
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
