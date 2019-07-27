package com.example.fujit.fragmenttest.TaskViewer.TaskPage.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.example.fujit.fragmenttest.R;
import com.example.fujit.fragmenttest.ReachMaxException;
import com.example.fujit.fragmenttest.TaskViewer.TaskPage.presenter.TaskPagePresenterInterface;
import com.example.fujit.fragmenttest.TaskViewer.TaskPage.presenter.TaskPagePresenterPresenterImpl;
import com.example.fujit.fragmenttest.model.ToDoButton;

import java.util.ArrayList;
import java.util.List;

import fujitutil.DPConverter;

public class TaskPageView extends Fragment
{
    public static final String index = "index";
    private TaskPagePresenterInterface presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.tab, container, false);
        presenter = new TaskPagePresenterPresenterImpl(this, layout);
        presenter.createButtonList(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                DPConverter.convertPx2Dp(50, getContext())));

        return layout;
    }

}
