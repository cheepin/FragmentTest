package com.example.fujit.fragmenttest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseHelperTest
{

    @Test
    public void deleteList()
    {
        Context context = InstrumentationRegistry.getTargetContext();
        DatabaseHelper db = new DatabaseHelper(context);

        db.deleteList(4);
        assertNotNull(context);
    }
}