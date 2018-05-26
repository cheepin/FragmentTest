package com.example.fujit.fragmenttest.model;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.Button;

import com.example.fujit.fragmenttest.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ToDoButtonDAO
{
    private DatabaseHelper db;


    public ToDoButtonDAO(Context context)
    {
        db = new DatabaseHelper(context);
    }


    public List<List<ToDoButton>> getButtonList()
    {
        List<List<ToDoButton>> buttonList = new ArrayList<>();
        for (int i = 0; i <= db.getMaxListCount(); i++)
        {
            List<ToDoButton> tempList = new ArrayList<>();
            List<String> list = db.getTextFromList(i);
            for (String text : list)
            {
                ToDoButton toDoButton = new ToDoButton();
                toDoButton.setButtonText(text);
                toDoButton.setListNumber(i);
                tempList.add(toDoButton);
            }
            if(!tempList.isEmpty())
            {
                buttonList.add(tempList);
            }
        }
        
        return buttonList;
    }

    public void DeleteList(int index)
    {
        int deleteIndex = getButtonList().get(index).get(0).getListNumber();
        db.exeSQL("Delete " + " From " + DatabaseHelper.TABLE_NAME + " Where "
                + DatabaseHelper.COL_2 + " = " + deleteIndex);
    }
}
