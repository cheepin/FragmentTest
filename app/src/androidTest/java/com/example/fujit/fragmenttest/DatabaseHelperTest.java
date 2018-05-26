package com.example.fujit.fragmenttest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DatabaseHelperTest
{

    @Test
    public void deleteList()
    {
        Context context = InstrumentationRegistry.getTargetContext();
        DatabaseHelper db = new DatabaseHelper(context);

        try{
            System.out.println("-----------------");
            List<String> list = db.getTextFromList(3);

            for (String str : list)
            {
                System.out.println(str);
            }
        }
        catch (ReachMaxException e)
        {
            e.printStackTrace();
        }
        System.out.println("-----------------");

    }
}