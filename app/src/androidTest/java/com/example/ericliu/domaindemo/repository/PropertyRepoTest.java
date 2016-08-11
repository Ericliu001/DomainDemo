package com.example.ericliu.domaindemo.repository;

import com.example.ericliu.domaindemo.model.Property;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by ericliu on 10/08/2016.
 */

public class PropertyRepoTest {

    PropertyRemoteRepo mRemoteRepo;

    @Before
    public void setUp() throws Exception {
        mRemoteRepo = new PropertyRemoteRepo();
    }

    @After
    public void tearDown() throws Exception {
        mRemoteRepo = null;

    }

    @Test
    public void testQuery() throws Exception {
        List<Property> propertyList = mRemoteRepo.query(null);
        assertNotNull(propertyList);
    }
}
