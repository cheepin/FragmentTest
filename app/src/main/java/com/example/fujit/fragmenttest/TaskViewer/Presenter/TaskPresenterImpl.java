package com.example.fujit.fragmenttest.TaskViewer.Presenter;

import android.content.Context;
import android.os.Bundle;

import com.example.fujit.fragmenttest.TaskViewer.TaskPage.view.TaskPageView;
import com.example.fujit.fragmenttest.model.ToDoButtonDAO;

public class TaskPresenterImpl implements TaskPresenterInterface
{
    ToDoButtonDAO dao;

    public TaskPresenterImpl(Context context)
    {
        this.dao = new ToDoButtonDAO(context);
    }

    //TaskPageの生成
    @Override
    public TaskPageView createTaskPage(int position)
    {
        TaskPageView taskPageView = new TaskPageView();
        //引数設定
        Bundle bundle = new Bundle();
        bundle.putInt(TaskPageView.index, position);
        taskPageView.setArguments(bundle);

        return taskPageView;
    }

    @Override
    public int getMaxListNumber()
    {
        return dao.getButtonList().size();
    }
}
