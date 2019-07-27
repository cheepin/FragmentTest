package com.example.fujit.fragmenttest;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fujitutil.DPConverter;

/**
 * フラグメントクラスの基本
 * 1.Fragmentを継承したクラスを生成する。
 * 2.onCreateView()をオーバーライドする。
 * 3.画面の初期化処理を行う。
 * 4.戻り値にLayoutInflater#inflaterメソッドを使用し、ここでres/layoutに作成したxmlと関連付ける。
 */
public class ButtonPlacer extends Fragment
{

    private LinearLayout myLinearContainer;
    private LayoutParams layoutParams;
    private List<EditText> editTextList = new ArrayList<>();


    //入力用テキスト作成
    private void createNewButton(ViewGroup container)
    {
        //EditText作成
        EditText edit1 = new EditText(getActivity());
        edit1.setHint(R.string.Creator_HintText);
        edit1.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        //追加
        editTextList.add(edit1);
        container.addView(edit1);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //インスタンス保持
        this.myLinearContainer = (LinearLayout) inflater.inflate(R.layout.button_placer, container, false);

        //LayoutParam作成


        //LinearLayout作成
        LinearLayout buttonLayout = new LinearLayout(getActivity());
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));


        //Addボタン生成
        Button addButton = new Button(getActivity());
        addButton.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,0.7f));

        addButton.setOnClickListener(view -> createNewButton(this.myLinearContainer));
        addButton.setText(R.string.Creator_AddButton);
        buttonLayout.addView(addButton);

        //Setボタン生成
        Button setButton = new Button(getActivity());
        setButton.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        setButton.setOnClickListener(view -> setTodoData());
        setButton.setText(R.string.Creator_SetButton);
        buttonLayout.addView(setButton);


        this.myLinearContainer.addView(buttonLayout);

        //最初のEditText作成
        createNewButton(this.myLinearContainer);
        return this.myLinearContainer;
    }

    //Todoリストをデータベースに保存
    public void setTodoData()
    {
        DatabaseHelper db = new DatabaseHelper(getActivity());
        int max = db.getMaxListCount();
        try
        {
            for (EditText editText : editTextList)
            {
                db.exeSQL("INSERT INTO STUDENT VALUES(?," + (max + 1) + ",\"" + editText.getText() + "\")");
            }
            Toast.makeText(getActivity(), R.string.successMsg, Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e)
        {
            System.out.println("SQLエラーが発生しました！！" );
            e.printStackTrace();
            Toast.makeText(getActivity(), R.string.setTodo_failMsg, Toast.LENGTH_SHORT).show();
        }
    }


}
