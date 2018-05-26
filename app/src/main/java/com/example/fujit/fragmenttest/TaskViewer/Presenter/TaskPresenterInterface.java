package com.example.fujit.fragmenttest.TaskViewer.Presenter;

import com.example.fujit.fragmenttest.TaskViewer.TaskPage.view.TaskPageView;

public interface TaskPresenterInterface
{
    TaskPageView createTaskPage(int position);

    int getMaxListNumber();
}
