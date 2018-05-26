package com.example.fujit.fragmenttest.TaskViewer.TaskPage.presenter;

import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.example.fujit.fragmenttest.ReachMaxException;
import com.example.fujit.fragmenttest.TaskViewer.Presenter.TaskPresenterInterface;
import com.example.fujit.fragmenttest.TaskViewer.TaskPage.view.TaskPageView;
import com.example.fujit.fragmenttest.model.ToDoButton;
import com.example.fujit.fragmenttest.model.ToDoButtonDAO;

import java.util.ArrayList;
import java.util.List;

import fujitutil.DPConverter;

import static com.example.fujit.fragmenttest.TaskViewer.TaskPage.view.TaskPageView.index;


public class TaskPagePresenterPresenterImpl implements TaskPagePresenterInterface
{
    private TaskPageView view;
    private LinearLayout layout;
    private ToDoButtonDAO dao;

    //コンストラクタ
    public TaskPagePresenterPresenterImpl(Fragment context, LinearLayout layout)
    {
        this.view = (TaskPageView)context;
        this.layout = layout;
        this.dao = new ToDoButtonDAO(context.getActivity());
    }

    //初期LayOut作成
    @Override
    public void createButtonList(LayoutParams params)
    {
        //ボタン生成
        for (ToDoButton buttonText : getButtonListFromIndex(view.getArguments().getInt(index)))
        {

            Button button = new Button(view.getActivity());


            //パラメータ設定
            button.setLayoutParams(params);
            button.setText(buttonText.getButtonText());
            button.setOnClickListener(view -> view.setEnabled(false));
            layout.addView(button);
        }

    }

    private List<ToDoButton> getButtonListFromIndex(int index)
    {
        return dao.getButtonList().get(index);
    }


}
