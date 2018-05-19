package com.example.fujit.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

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
