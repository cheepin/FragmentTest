package com.example.fujit.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * フラグメントの基本<br>
 * 1.フラグメント用レイアウトファイルを作成する。(fragment_table_view.xml)<br>
 * 2.フラグメント用クラスを生成する。(ButtonPlacer参照) <br>
 * 3.アクティビティに切り替え用のレイアウトを配置する(activity_main.xmlのFrameLayout参照)<br>
 * 4.FragmentManagerのインスタンスを生成する。<br>
 * 5.FragmentManager.beginTransactionからFragmentTransactionのインスタンスを生成する <br>
 * 6.FragmentTransaction#replaceで3で生成したレイアウトのIDと2で作成したフラグメントを引数にわたす <br>
 * 7.FragmentTransaction#commitでコミットする。
 * 
 */
public class FragmentPlacer
{
    public FragmentPlacer()
    {

    }

    static public void addFragment(AppCompatActivity context, Fragment fragment, int fragmentId)
    {
        FragmentManager fm = context.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(fragmentId, fragment);
        ft.commit();
    }

}
