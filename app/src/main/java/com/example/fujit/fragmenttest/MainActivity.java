package com.example.fujit.fragmenttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;

import com.example.fujit.fragmenttest.presenter.MainPresenter;
import com.example.fujit.fragmenttest.presenter.PresenterInterface;
import com.example.fujit.fragmenttest.TaskViewer.TaskView;
import com.example.fujit.fragmenttest.view.ViewInterface;

public class MainActivity extends AppCompatActivity implements ViewInterface
{

    private PresenterInterface presenter;
    private int nowPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setSubtitle(R.string.app_name);

        FragmentPlacer fPlacer = new FragmentPlacer();

        TaskView taskView = new TaskView();
        fPlacer.addFragment(this, taskView, R.id.frameLayout1);
        presenter = new MainPresenter(this);
        presenter.setOnPageChangeListener(taskView);

    }

    //ツールバーの設定
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //追加

        menu.findItem(R.id.TaskView).setOnMenuItemClickListener(item ->
        {
            FragmentPlacer fPlacer = new FragmentPlacer();
            TaskView taskView = new TaskView();
            fPlacer.addFragment(this, taskView, R.id.frameLayout1);
            presenter.setOnPageChangeListener(taskView);
            return true;
        });


        menu.findItem(R.id.setting1).setOnMenuItemClickListener(item ->
        {
            FragmentPlacer fPlacer = new FragmentPlacer();
            ButtonPlacer buttonPlacer = new ButtonPlacer();
            fPlacer.addFragment(this, buttonPlacer, R.id.frameLayout1);
            return true;
        });

        //現在表示されているリストの削除
        menu.findItem(R.id.delete).setOnMenuItemClickListener(item ->
        {
            presenter.onDeleteButton();

            FragmentPlacer fPlacer = new FragmentPlacer();
            TaskView taskView = new TaskView();
            fPlacer.addFragment(this, taskView, R.id.frameLayout1);
            presenter.setOnPageChangeListener(taskView);
            return true;
        });
        return true;
    }


    @Override
    public Context getContext()
    {
        return this;
    }
}
