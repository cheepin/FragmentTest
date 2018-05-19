package com.example.fujit.fragmenttest;

import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper db;
    private TableView tableView;
    private int nowPage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setSubtitle(R.string.app_name);

        db = new DatabaseHelper(this);

        FragmentPlacer fPlacer = new FragmentPlacer();
        tableView = new TableView();
        fPlacer.addFragment(this, tableView, R.id.frameLayout1);



    }

//
//    @Override
//    public void onAttachFragment(Fragment fragment)
//    {
//        tableView.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
//        {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
//            {}
//
//            @Override
//            public void onPageSelected(int position)
//            {
//                nowPage = position;
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state)
//            {}
//        });
//    }



    //ツールバーの設定
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //追加
        menu.getItem(0).setOnMenuItemClickListener(item ->
        {
            FragmentPlacer fPlacer = new FragmentPlacer();
            ButtonPlacer buttonPlacer = new ButtonPlacer();
            fPlacer.addFragment(this, buttonPlacer, R.id.frameLayout1);
            return true;
        });

        //現在表示されているリストの削除
        menu.getItem(1).setOnMenuItemClickListener(item ->
        {
            System.out.println(nowPage);
            return true;
        });
        return true;
    }



}
