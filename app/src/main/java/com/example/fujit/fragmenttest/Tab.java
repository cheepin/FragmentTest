package com.example.fujit.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.List;

public class Tab extends Fragment
{
    public static final String index = "index";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.tab, container, false);

        DatabaseHelper db = new DatabaseHelper(getActivity());

        //表示文字取得
        List<String> list = db.getTextFromList(getArguments().getInt(index));

        //ボタン生成
        for (String buttonText :list)
        {
            Button button = new Button(getActivity());
            LayoutParams params = new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
            );

            //パラメータ設定
            button.setLayoutParams(params);
            button.setText(buttonText);
            button.setOnClickListener(view -> view.setEnabled(false));
            layout.addView(button);
        }
        return layout;
    }
}
