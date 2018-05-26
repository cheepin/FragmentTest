package com.example.fujit.fragmenttest.model;

import android.support.test.InstrumentationRegistry;

import com.example.fujit.fragmenttest.DatabaseHelper;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ToDoButtonDAOTest
{
    @Test
    public void DAOTest()
    {
        ToDoButtonDAO dao = new ToDoButtonDAO(InstrumentationRegistry.getTargetContext());
        dao.DeleteList(0);

    }

}