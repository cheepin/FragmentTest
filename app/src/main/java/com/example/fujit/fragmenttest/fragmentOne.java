package com.example.fujit.fragmenttest;

import android.app.ActionBar;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;


public class fragmentOne extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        LinearLayout linearLayout = new LinearLayout(getActivity());
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);


        LayoutParams lparam = new LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        Button button1 = new Button(getActivity());
        button1.setLayoutParams(lparam);
        linearLayout.addView(button1);

        container.addView(linearLayout);

        return inflater.inflate(R.layout.fragment_fragment_one, container, false);
    }

}
